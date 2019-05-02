package com.bectran.b2b.customer.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.base.beans.BatchItemBean;
import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.CreditRequestBean;
import com.bectran.b2b.customer.beans.PastCreditAppBean;
import com.bectran.b2b.supplier.beans.BecSubscriptionBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @Creation date : (Sep 6, 2004)
 * @author Louis Ifeguni
 */
public class CreditRequestDAO {
  /*  public static List getIdsForRefCall() throws DataAccessException {
        //
        List result = new ArrayList();
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            String query = " select f.id from CreditRequestBean  f where f.refCallStatus = :refCallStatus  ";
            result = session.createQuery(query)
                    .setString("refCallStatus",
                            MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED)
                    .list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.getIdsForRefCall()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return result;
    }
*/
  /*  public static List getIdsForRefCheck() throws DataAccessException {
        //
        List result = new ArrayList();
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            String query = " select f.id from CreditRequestBean  f where (f.refCallStatus <> :r1 or f.refCallStatus <> :r2) ";
            result = session.createQuery(query)
                    .setString("r1", MatrixConstants.STATUS_CLOSED)
                    .setString("r2",
                            MatrixConstants.REFERENCE_CALL_STATUS_NOT_CALLED)
                    .list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.getIdsForRefCheck()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return result;
    }

  */  public static List<CreditRequestBean> getCreditRequestToProcess(List list)
            throws DataAccessException {
        //
        String inClause = null;
        List<CreditRequestBean> result = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            StringBuffer bf = new StringBuffer();
            bf.append(":DUMB");
            for (Iterator i = list.iterator(); i.hasNext();) {
                BatchItemBean bean = (BatchItemBean) i.next();
                bf.append(",");
                bf.append(":id" + bean.getTempId());
            }
            inClause = bf.toString();
            String query = " from CreditRequestBean b where b.id in ("
                    + inClause + ")";
            Query hibQuery = session.createQuery(query);
            hibQuery.setString("DUMB", "DUMB");
            for (Iterator i = list.iterator(); i.hasNext();) {
                BatchItemBean bean = (BatchItemBean) i.next();
                hibQuery.setLong("id" + bean.getTempId(),
                        bean.getItemID().longValue());
            }
            result = (ArrayList<CreditRequestBean>) hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.getCreditRequestToProcess(List list)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return result;
    }

    /**
     * @param acctNum
     * @param status
     * @return
     * @throws DataAccessException
     */
    public static List findRequestByStatus(String acctNum, String status)
            throws DataAccessException {
        //
        List ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_open = " from CreditRequestBean b where b.status = :status and b.acctNum = :acctNum"
                    + " order by b.appDate desc ";
            String query_closed = " from CreditRequestBean b where b.status = :status and b.acctNum = :acctNum"
                    + " order by b.approvalDate desc ";
            if (status.equals(MatrixConstants.STATUS_OPEN)) {
                ls = session.createQuery(query_open).setString("status", status)
                        .setString("acctNum", acctNum).list();
            }
            else if (status.equals(MatrixConstants.STATUS_CLOSED)) {
                ls = session.createQuery(query_closed)
                        .setString("status", status)
                        .setString("acctNum", acctNum).list();
            }
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.findRequestByStatus()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List findRequestForReferenceCall(String acctNum)
            throws DataAccessException {
        //
        List ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_open = " from CreditRequestBean b where b.status = :status and b.acctNum = :acctNum and b.refCallCompleteFlag = :refCallCompleteFlag "
                    + " order by b.appDate desc ";
            ls = session.createQuery(query_open)
                    .setString("status", MatrixConstants.STATUS_OPEN)
                    .setString("acctNum", acctNum)
                    .setString("refCallCompleteFlag", MatrixConstants.ANSWER_NO)
                    .list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.findRequestForReferenceCall()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    /**
     * finds all request for an account
     * 
     * @param acctNum
     * @return
     * @throws DataAccessException
     */
    public static List<PastCreditAppBean> findRequestByAccount(String acctNum,
                                                               long supplierId)
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_open = " from PastCreditAppBean b where b.acctNum = :acctNum and b.supplierId = :supplierId "
                    + " order by b.appDate desc ";
            ls = (ArrayList<PastCreditAppBean>) session.createQuery(query_open)
                    .setLong("supplierId", supplierId)
                    .setString("acctNum", acctNum).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.findRequestByAccount()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    /**
     * finds all request for an account
     * 
     * @param acctNum
     * @return
     * @throws DataAccessException
     */
    public static List<PastCreditAppBean> openRequestBySupplier(long supplierId)
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_open = " from PastCreditAppBean b where b.supplierId = :supplierId and b.status = :status  "
                    + "  and b.archiveFlag = :archiveFlag "
                    + " order by b.id desc ";
            ls = session.createQuery(query_open)
                    .setString("archiveFlag", MatrixConstants.ANSWER_NO)
                    .setString("status", MatrixConstants.STATUS_OPEN)
                    .setLong("supplierId", supplierId).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.openRequestBySupplier(long supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List<PastCreditAppBean> closedRequestBySupplier(long supplierId)
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_open = " from PastCreditAppBean b where b.supplierId = :supplierId and b.status = :status "
                    + "  and b.archiveFlag = :archiveFlag "
                    + " order by b.id desc ";
            ls = (ArrayList<PastCreditAppBean>) session.createQuery(query_open)
                    .setString("archiveFlag", MatrixConstants.ANSWER_NO)
                    .setString("status", MatrixConstants.STATUS_CLOSED)
                    .setLong("supplierId", supplierId).setMaxResults(500)
                    .list(); // limit to 500
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.closedRequestBySupplier(long supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List<PastCreditAppBean> allRequestBySupplier(long supplierId)
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            // String query_open = " from PastCreditAppBean b where b.supplierId
            // = :supplierId "+ " order by b.id desc ";
            // ls = (ArrayList<PastCreditAppBean>)
            // session.createQuery(query_open).setLong("supplierId",
            // supplierId).setMaxResults(500).list(); //limit to 500
            // Query hquery = session.createQuery(query_open);
            // hquery.setLong("supplierId", supplierId);
            // maximum result to 500
            // hquery.setMaxResults(500);
            // ls = (ArrayList<PastCreditAppBean>)hquery.list();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from PastCreditAppBean b where b.supplierId = :supplierId ");
            bf.append("  and b.archiveFlag = :archiveFlag ");
            bf.append("  and b.status IN ");
            bf.append(" ( ");
            bf.append(":open, :closed ");
            bf.append(" )");
            bf.append("  order by b.id desc ");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("supplierId", supplierId);
            hibQuery.setString("archiveFlag", MatrixConstants.ANSWER_NO);
            //
            hibQuery.setString("open", MatrixConstants.STATUS_OPEN);
            hibQuery.setString("closed", MatrixConstants.STATUS_CLOSED);
            //
            hibQuery.setMaxResults(500);
            //
            // System.out.println(bf.toString());
            //
            ls = hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.allRequestBySupplier(long supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List<PastCreditAppBean> allRequestBySupplier_OLD(long supplierId)
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            // String query_open = " from PastCreditAppBean b where b.supplierId
            // = :supplierId "+ " order by b.id desc ";
            // ls = (ArrayList<PastCreditAppBean>)
            // session.createQuery(query_open).setLong("supplierId",
            // supplierId).setMaxResults(500).list(); //limit to 500
            // Query hquery = session.createQuery(query_open);
            // hquery.setLong("supplierId", supplierId);
            // maximum result to 500
            // hquery.setMaxResults(500);
            // ls = (ArrayList<PastCreditAppBean>)hquery.list();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from PastCreditAppBean b where b.supplierId = :supplierId and b.reviewType = :reviewType ");
            bf.append("  and b.archiveFlag = :archiveFlag ");
            bf.append("  and b.status IN ");
            bf.append(" ( ");
            bf.append(":open, :closed ");
            bf.append(" )");
            bf.append("  order by b.id desc ");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("supplierId", supplierId);
            hibQuery.setString("reviewType", MatrixConstants.ANSWER_NO);
            hibQuery.setString("archiveFlag", MatrixConstants.ANSWER_NO);
            //
            hibQuery.setString("open", MatrixConstants.STATUS_OPEN);
            hibQuery.setString("closed", MatrixConstants.STATUS_CLOSED);
            //
            hibQuery.setMaxResults(500);
            //
            // System.out.println(bf.toString());
            //
            ls = hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.allRequestBySupplier(long supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List<PastCreditAppBean> getUnApprovedRequest(long supplierId)
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from PastCreditAppBean b where b.supplierId = :supplierId and b.status = :status ");
            bf.append("  and b.creditDecision NOT IN ");
            bf.append(" ( ");
            bf.append(":approved, :declined, :inprogress ");
            bf.append(" )");
            bf.append("  order by b.id desc ");
            String query_open = bf.toString();
            Query hibQuery = session.createQuery(query_open);
            hibQuery.setLong("supplierId", supplierId);
            hibQuery.setString("status", MatrixConstants.STATUS_CLOSED);
            //
            hibQuery.setString("approved", MatrixConstants.STATUS_APPROVED);
            hibQuery.setString("declined", MatrixConstants.STATUS_DECLINED);
            hibQuery.setString("inprogress", MatrixConstants.STATUS_INPROGRESS);
            //
            // System.out.println(bf.toString());
            //
            ls = (ArrayList<PastCreditAppBean>) hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.getUnApprovedRequest(long supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static CreditRequestBean getRequest(long id)
            throws DataAccessException {
        //
        CreditRequestBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from CreditRequestBean b where b.id = :id  ";
            bean = (CreditRequestBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.getRequest()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public PastCreditAppBean getPastRequest(long id)
            throws DataAccessException {
        //
        PastCreditAppBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from PastCreditAppBean b where b.id = :id  ";
            bean = (PastCreditAppBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.getRequest()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static List test() throws DataAccessException {
        //
        List ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from CreditRequestBean  ";
            ls = session.createQuery(query).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.test()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List<CreditRequestBean> closedRequestTest()
            throws DataAccessException {
        //
        List<CreditRequestBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_open = " from CreditRequestBean b where b.status = :status"
                    + " order by b.id desc ";
            ls = (ArrayList<CreditRequestBean>) session.createQuery(query_open)
                    .setString("status", MatrixConstants.STATUS_CLOSED).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.closedRequestTest()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List openRequestsWithRefCalls(String processId)
            throws DataAccessException {
        //
        List ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from CreditRequestBean b where b.status = :status "
                    + " and b.processId = :procid and b.refCallCompleteFlag <> :flag ";
            ls = session.createQuery(query).setString("procid", processId)
                    .setString("status", MatrixConstants.STATUS_OPEN)
                    .setString("flag", MatrixConstants.ANSWER_YES).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.openRequestsWithRefCalls()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public void updateCallStatus(long requestId) throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            String query = " update CreditRequestBean b set b.refCallCompleteFlag = :flag "
                    + "where b.id = :id ";
            session.createQuery(query).setLong("id", requestId)
                    .setString("flag", MatrixConstants.ANSWER_YES)
                    .executeUpdate();
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.updateCallStatus()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static PastCreditAppBean appUtilization2(long supplierId)
            throws DataAccessException {
        //
        PastCreditAppBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from PastCreditAppBean b where b.supplierId = :supplierId  ";
            bean = (PastCreditAppBean) session.createQuery(query)
                    .setLong("supplierId", supplierId).setMaxResults(1)
                    .uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.getRequest()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static void validateSubscriptionCredit(BecSubscriptionBean subscriptionBean)
            throws DataAccessException {
        //
        long supplierId = subscriptionBean.getSupplierId().longValue();
        int appCredit = subscriptionBean.getAppCredit();
        //
        String queryCount = " select count(f.id) from CreditRequestBean  f where f.supplierId = :supplierId";
        // List<Long> result = new ArrayList<Long>();
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            Long appCount = (Long) session.createQuery(queryCount)
                    .setLong("supplierId", supplierId).setMaxResults(1)
                    .uniqueResult();
            appCount = (appCount == null) ? Long.valueOf(0) : appCount;
            subscriptionBean.setAppCount(appCount.intValue());
            if (appCount.intValue() > appCredit) {
                subscriptionBean.setExpired(true);
                subscriptionBean.setExpiredByAppUtilization(true);
            }
            else {
                subscriptionBean.setExpired(false);
                subscriptionBean.setExpiredByAppUtilization(false);
                //
                // tx.commit();
                /// session.close();
                // return;
            }
            // System.out.println("appCount.longValue()---->"+appCount.intValue());
            //
            // String query = " select f.id from CreditRequestBean f where
            // f.supplierId = :supplierId order by f.id asc";
            // result = (ArrayList<Long>)
            // session.createQuery(query).setLong("supplierId",
            // supplierId).list();
            //
            // int count =0;
            // long cutOffId =0;
            // for (Iterator<Long> i = result.iterator(); i.hasNext();) {
            // Long sid = (Long)i.next();
            // count++;
            // System.out.println(sid+",... "+count);
            // if(count==appCredit){
            // subscriptionBean.setAppCutOffId(sid);
            // cutOffId = sid.longValue();
            // //System.out.println("====>"+sid);
            // break;
            //
            // }
            // }
            // set credit request cut-off date
            // String queryCutOffRequest = " from CreditRequestBean b where b.id
            // = :id ";
            // CreditRequestBean cutOffbean =
            // (CreditRequestBean)session.createQuery(queryCutOffRequest).setLong("id",
            // cutOffId).setMaxResults(1).uniqueResult();
            // subscriptionBean.setAppCutOffDate(cutOffbean.getAppDate());
            //
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.validateSubscriptionCredit(BecSubscriptionBean subscriptionBean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static List<PastCreditAppBean> allClosedRequestTest()
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_open = " from PastCreditAppBean b where b.status = :status"
                    + " order by b.id desc ";
            ls = (ArrayList<PastCreditAppBean>) session.createQuery(query_open)
                    .setString("status", MatrixConstants.STATUS_CLOSED).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.allClosedRequestTest()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static List test3() throws DataAccessException {
        //
        List ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            //
            String query_open = " from CustomScoringUseTrackerBean ";
            ls = session.createQuery(query_open).list();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditRequestDAO.test3";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("-ls.size()----"+openRequestsWithRefCalls("BASE_PROCESS2").size());
        // updateCallStatus(1);
        System.out.println("-START-");
        //
        // test3();
        // allRequestBySupplier(1).size();
        System.out.println("-allRequestBySupplier(1).size()----"
                + allRequestBySupplier(1).size());
        // System.out.println(openRequestForDashboard(1).size()+" vs.
        // "+openRequestBySupplier(1).size());
        System.out.println("-FINISH-");
    }
}
