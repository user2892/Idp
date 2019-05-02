package com.bectran.b2b.customer.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.AcctRefereeBean;
import com.bectran.b2b.customer.beans.CreditRequestBean;
import com.bectran.b2b.customer.beans.RefForRequestBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @Date Feb 25, 2007:12:15:35 PM
 */
public class RefForRequestDAO {
    public static void saveRefsForRequest(String acctNum, List refsForRequest,
                                          CreditRequestBean creditapp)
            throws DataAccessException {
        long requestId = creditapp.getId().longValue();
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            RefForRequestBean refForReq = null;
            for (Iterator i = refsForRequest.iterator(); i.hasNext();) {
                AcctRefereeBean ref = (AcctRefereeBean) i.next();
                refForReq = new RefForRequestBean();
                refForReq.setRefereeContactId(
                        ref.getRefereeContact().getId().longValue());
                refForReq.setRequestId(requestId);
                refForReq.setDateCreated(new Date());
                refForReq.setRefereeId(ref.getReferee().getId().longValue());
                refForReq.setAcctNum(acctNum);
                refForReq.setReferenceType(
                        ref.getRefereeContact().getReferenceType());
                refForReq.setCallStatus(
                        MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED);
                refForReq.setLastActivity(new Date());
                refForReq.setProcessId(creditapp.getProcessId());
                //
                session.saveOrUpdate(refForReq);
            }
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Data Insert Failed in RefForRequestDAO.saveRefsForRequest()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void saveOrUpdateRequestOnCall(RefForRequestBean bean)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(bean);
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Data Insert Failed in RefForRequestDAO.saveOrUpdateRequestOnCall()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static List<RefForRequestBean> refsForRequest(long requestId)
            throws DataAccessException {
        //
        List<RefForRequestBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from RefForRequestBean b where b.requestId = :requestId ";
            ls = (ArrayList<RefForRequestBean>) session.createQuery(query)
                    .setLong("requestId", requestId).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in RefForRequestDAO.refsForRequest()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List<RefForRequestBean> refsForRequest(long requestId,
                                                         String referenceType)
            throws DataAccessException {
        //
        List<RefForRequestBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from RefForRequestBean b where b.requestId = :requestId and b.referenceType = :referenceType ";
            ls = session.createQuery(query).setLong("requestId", requestId)
                    .setString("referenceType", referenceType).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in RefForRequestDAO.refsForRequest(long requestId, String referenceType)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static RefForRequestBean getRefForRequest(long id)
            throws DataAccessException {
        //
        RefForRequestBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from RefForRequestBean b where b.id = :id ";
            bean = (RefForRequestBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in RefForRequestDAO.getRefForRequest()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    /**
     * references with call status - CALLED, REMINDER, REMINDER-LIMIT
     * 
     * @param processId
     * @return
     * @throws DataAccessException
     */
    public static List refsOnCall(String processId) throws DataAccessException {
        //
        List ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from RefForRequestBean b where b.processId = :processId "
                    + " and (b.callStatus = :s1 or b.callStatus = :s2 or b.callStatus = :s3)";
            Query hibquery = session.createQuery(query);
            hibquery.setString("processId", processId);
            hibquery.setString("s1",
                    MatrixConstants.REFERENCE_CALL_STATUS_CALLED);
            hibquery.setString("s2",
                    MatrixConstants.REFERENCE_CALL_STATUS_REMINDER);
            hibquery.setString("s3",
                    MatrixConstants.REFERENCE_CALL_STATUS_REMINDER_LIMIT);
            // qualifying references are references whose requests have not been
            // closed - ie OPEN REQUEST
            // hibquery.setString("requeststatus",
            // CreditRequestBean.STATUS_OPEN);
            ls = hibquery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in RefForRequestDAO.refsOnCall()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List refsToBeCalled(String processId)
            throws DataAccessException {
        //
        List ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from RefForRequestBean b where b.processId = :processId "
                    + " and (b.callStatus = :s1 or b.callStatus = :s2 )";
            Query hibquery = session.createQuery(query);
            hibquery.setString("processId", processId);
            hibquery.setString("s1",
                    MatrixConstants.REFERENCE_CALL_STATUS_CALLED);
            hibquery.setString("s2",
                    MatrixConstants.REFERENCE_CALL_STATUS_REMINDER);
            ls = hibquery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in RefForRequestDAO.refsOnCall()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }
}
