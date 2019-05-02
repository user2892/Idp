package com.bectran.b2b.crol.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.crol.beans.BankRefFormBean;
import com.bectran.b2b.crol.beans.CreditRefBean;
import com.bectran.b2b.crol.beans.CreditRefEvalBean;
import com.bectran.b2b.crol.beans.CrolRequestBean;
import com.bectran.b2b.crol.beans.TradeRefFormBean;
import com.bectran.b2b.customer.beans.RefForRequestBean;
import com.bectran.b2b.supplier.beans.ManualRefAuditBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI Jan 22, 2010: 7:41:03 AM
 */
public class CreditRefDAO {
    public static CreditRefBean getTradeCreditReference(Long requestId)
            throws DataAccessException {
        //
        CreditRefBean refBean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from CreditRefBean c where c.requestID = :reqid ";
            List list = session.createQuery(query)
                    .setLong("reqid", requestId.longValue()).list();
            if (list == null || list.size() < 1) {
                //
                // tx.commit();
                session.close();
                return null;
            }
            refBean = (CreditRefBean) list.get(0);
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Error executing query in CreditRefDAO.getTradeCreditReference()",
                    e);
            throw new DataAccessException(
                    "Error executing query in CreditRefDAO.getTradeCreditReference()");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return refBean;
    }

    public static List<CreditRefEvalBean> getScoreSheet(long crefId)
            throws DataAccessException {
        //
        List<CreditRefEvalBean> sheet = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from CreditRefEvalBean c where c.headerId = :headerId ";
            sheet = (ArrayList<CreditRefEvalBean>) session.createQuery(query)
                    .setLong("headerId", crefId).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Error executing query in CreditRefDAO.getScoreSheet()", e);
            throw new DataAccessException(
                    "Error executing query in CreditRefDAO.getScoreSheet()");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return sheet;
    }

    public static void createCreditRefManual(CrolRequestBean request,
                                             CreditRefBean refHeader,
                                             List<CreditRefEvalBean> scoreSheet,
                                             ManualRefAuditBean manualRefAuditBean,
                                             RefForRequestBean refForRequest)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            createCreditRefGen(request, refHeader, scoreSheet, session);
            //
            manualRefAuditBean.setCrolRefReqId(request.getId());
            manualRefAuditBean.setCreditRefHeaderId(refHeader.getId());
            //
            //
            // check for duplicates
            ManualRefAuditBean existingAuditBean = existingAuditBean(
                    manualRefAuditBean.getUserId(),
                    manualRefAuditBean.getCrolRefReqId(), session);
            if (existingAuditBean == null) {
                session.save(manualRefAuditBean);
            }
            else {
                existingAuditBean.setLastUpdate(new Date());
                session.update(existingAuditBean);
            }
            //
            session.update(refForRequest);
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Data Insert Failed in CreditRefDAO.createCreditRef()", e);
            throw new DataAccessException(
                    "Data Insert Failed in CreditRefDAO.createCreditRef()");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    private static ManualRefAuditBean existingAuditBean(String userId,
                                                        long crolRefReqId,
                                                        Session session)
            throws DataAccessException {
        //
        ManualRefAuditBean bean = null;
        System.out.println(
                "===made it in: CreditRefDAO.existingAuditBean(String userId, long crolRefReqId)------");
        try {
            //
            String query = " from ManualRefAuditBean c where c.crolRefReqId = :crolRefReqId  and c.userId = :userId ";
            //
            bean = (ManualRefAuditBean) session.createQuery(query)
                    .setLong("crolRefReqId", crolRefReqId)
                    .setString("userId", userId).setMaxResults(1)
                    .uniqueResult();
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in  CreditRefDAO.existingAuditBean(String userId, long crolRefReqId)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        return bean;
    }

    public static void updateCreditRefManual(CreditRefBean refHeader,
                                             List<CreditRefEvalBean> scoreSheet,
                                             ManualRefAuditBean manualRefAuditBean)
            throws DataAccessException {
        Session session = null;
        String deleteExtgScoreSheet = " delete from CreditRefEvalBean b where b.headerId = :headerId ";
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            /// \\\=========================================////\\\\
            session.createQuery(deleteExtgScoreSheet)
                    .setLong("headerId", refHeader.getId().longValue())
                    .executeUpdate();
            session.update(refHeader);
            //
            for (CreditRefEvalBean bean : scoreSheet) {
                bean.setHeaderId(refHeader.getId());
                session.saveOrUpdate(bean);
            }
            if (refHeader.isTradeReference()) {
                TradeRefFormBean tRef = refHeader.getTradeRefBean();
                session.update(tRef);
            }
            else {
                BankRefFormBean bankRef = refHeader.getBankRefBean();
                session.update(bankRef);
            }
            //// \\\========================================////\\\\\
            session.update(manualRefAuditBean);
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Data Insert Failed in CreditRefDAO.createCreditRef()", e);
            throw new DataAccessException(
                    "Data Insert Failed in CreditRefDAO.createCreditRef()");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void createCreditRef(CrolRequestBean request,
                                       CreditRefBean refHeader,
                                       List<CreditRefEvalBean> scoreSheet,
                                       RefForRequestBean refForRequest)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            createCreditRefGen(request, refHeader, scoreSheet, session);
            //
            session.update(refForRequest);
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Data Insert Failed in CreditRefDAO.createCreditRef()", e);
            throw new DataAccessException(
                    "Data Insert Failed in CreditRefDAO.createCreditRef()");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    private static void createCreditRefGen(CrolRequestBean request,
                                           CreditRefBean refHeader,
                                           List<CreditRefEvalBean> scoreSheet,
                                           Session session)
            throws DataAccessException {
        try {
            //
            session.save(refHeader);
            //
            session.update(request);
            for (Iterator<CreditRefEvalBean> i = scoreSheet.iterator(); i
                    .hasNext();) {
                CreditRefEvalBean bean = (CreditRefEvalBean) i.next();
                //
                bean.setHeaderId(refHeader.getId());
                session.saveOrUpdate(bean);
            }
            if (refHeader.isTradeReference()) {
                TradeRefFormBean tRef = refHeader.getTradeRefBean();
                tRef.setRefRequestId(request.getId());
                tRef.setCreditRefHeaderId(refHeader.getId());
                session.save(tRef);
            }
            else {
                BankRefFormBean bankRef = refHeader.getBankRefBean();
                bankRef.setRefRequestId(request.getId());
                bankRef.setCreditRefHeaderId(refHeader.getId());
                session.save(bankRef);
            }
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Data Insert Failed in CreditRefDAO.createCreditRefGen()",
                    e);
            throw new DataAccessException(
                    "Data Insert Failed in CreditRefDAO.createCreditRefGen()");
        }
    }

    public static TradeRefFormBean getTradeReference(long creditRefHeaderId)
            throws DataAccessException {
        //
        TradeRefFormBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from TradeRefFormBean c where c.creditRefHeaderId = :creditRefHeaderId ";
            bean = (TradeRefFormBean) session.createQuery(query)
                    .setLong("creditRefHeaderId", creditRefHeaderId)
                    .setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in  CreditRefDAO.getTradeReference()";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static BankRefFormBean getBankReference(long creditRefHeaderId)
            throws DataAccessException {
        //
        BankRefFormBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from BankRefFormBean c where c.creditRefHeaderId = :creditRefHeaderId ";
            bean = (BankRefFormBean) session.createQuery(query)
                    .setLong("creditRefHeaderId", creditRefHeaderId)
                    .setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in  CreditRefDAO.getBankReference(long creditRefHeaderId)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("---in---");
        getTradeReference(121);
        System.out.println("---out---");
    }
}
