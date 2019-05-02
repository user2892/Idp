/**
 *
 */
package com.bectran.b2b.customer.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.customer.beans.ClientCustomerInfoCopyBean;
import com.bectran.b2b.customer.beans.ExtUserBean;
import com.bectran.b2b.customer.beans.PastCreditAppBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.DateUtility;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Oct 2, 2013 : 9:04:24 PM
 */
public class CustomerDataDAO {
    public PastCreditAppBean findAppById(long id) throws DataAccessException {
        //
        PastCreditAppBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from PastCreditAppBean b where b.id = :id  ";
            bean = (PastCreditAppBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            //
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CustomerDataDAO.findAppById(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public List<PastCreditAppBean> getAppsForTransmission(long supplierId,
                                                          Date inboundDataStartDate,
                                                          int maxRecord)
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from PastCreditAppBean b where b.supplierId = :supplierId  ");
            bf.append("  and b.transmittedFlag <> :transmittedFlag ");
            bf.append("  and b.approvalDate >= :inboundDataStartDate  ");
            bf.append("  and b.creditDecision IN ");
            bf.append(" ( ");
            bf.append(":approved, :declined, :Cancelled ");
            bf.append(" )");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("supplierId", supplierId);
            hibQuery.setString("transmittedFlag", MatrixConstants.ANSWER_YES);
            hibQuery.setTimestamp("inboundDataStartDate", inboundDataStartDate);
            //
            hibQuery.setString("approved", MatrixConstants.STATUS_APPROVED);
            hibQuery.setString("declined", MatrixConstants.STATUS_DECLINED);
            hibQuery.setString("Cancelled", MatrixConstants.STATUS_CANCELLED);
            //
            hibQuery.setMaxResults(maxRecord);
            //
            // hibQuery.setMaxResults(CustomerDataLoadBase.MAX_DATA_QUERY_LOAD);
            ls = hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CustomerDataDAO.getAppsForTransmission(long supplierId, Date inboundDataStartDate)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public List<PastCreditAppBean> getAppsForTransmissionByGroup(long groupId,
                                                                 Date inboundDataStartDate,
                                                                 int maxRecord)
            throws DataAccessException {
        //
        List<PastCreditAppBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(" from PastCreditAppBean b where b.groupId = :groupId  ");
            bf.append("  and b.transmittedFlag <> :transmittedFlag ");
            bf.append("  and b.approvalDate >= :inboundDataStartDate  ");
            /*
             * bf.append("  and b.creditDecision IN "); bf.append(" ( ");
             * bf.append(":approved, :declined, :Cancelled "); bf.append(" )");
             */
            bf.append("  and b.creditDecision IN ");
            bf.append(" ( ");
            bf.append(":approved, :declined, :Cancelled ");
            bf.append(" )");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("groupId", groupId);
            hibQuery.setString("transmittedFlag", MatrixConstants.ANSWER_YES);
            hibQuery.setTimestamp("inboundDataStartDate", inboundDataStartDate);
            //
            /*
             * hibQuery.setString("approved", MatrixConstants.STATUS_APPROVED);
             * hibQuery.setString("declined", MatrixConstants.STATUS_DECLINED);
             * hibQuery.setString("Cancelled",
             * MatrixConstants.STATUS_CANCELLED);
             */
            hibQuery.setString("approved", MatrixConstants.STATUS_APPROVED);
            hibQuery.setString("declined", MatrixConstants.STATUS_DECLINED);
            hibQuery.setString("Cancelled", MatrixConstants.STATUS_CANCELLED);
            //
            hibQuery.setMaxResults(maxRecord);
            ls = hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CustomerDataDAO.getAppsForTransmissionByGroup(long groupId, Date inboundDataStartDate)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public void updateTransmittedData(List<PastCreditAppBean> ls,
                                      String transmittedFlag,
                                      String trxnBatchControlToken)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " update PastCreditAppBean b  set b.transmittedFlag = :transmittedFlag , b.trxnBatchControlToken =:trxnBatchControlToken  where b.id = :id  ");
            String query = bf.toString();
            //
            int batchCount = 0; // save in batches of 20
            for (PastCreditAppBean bean : ls) {
                //
                Query hibQuery = session.createQuery(query);
                hibQuery.setLong("id", bean.getId().longValue());
                hibQuery.setString("transmittedFlag", transmittedFlag);
                hibQuery.setString("trxnBatchControlToken",
                        trxnBatchControlToken);
                hibQuery.executeUpdate();
                //
                batchCount = batchCount + 1;
                if (batchCount % 20 == 0) { // 20, same as the JDBC batch size
                    // flush a batch of inserts and release memory:
                    session.flush();
                    session.clear();
                }
            }
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in CustomerDataDAO.updateTransmittedApprovals";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public void confirmTransmittedData(String transmittedFlag,
                                       String trxnBatchControlToken)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " update PastCreditAppBean b  set b.transmittedFlag = :transmittedFlag where b.trxnBatchControlToken =:trxnBatchControlToken ");
            String query = bf.toString();
            //
            Query hibQuery = session.createQuery(query);
            hibQuery.setString("transmittedFlag", transmittedFlag);
            hibQuery.setString("trxnBatchControlToken", trxnBatchControlToken);
            hibQuery.executeUpdate();
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in CustomerDataDAO.confirmTransmittedData( String transmittedFlag, String trxnBatchControlToken)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public ClientCustomerInfoCopyBean findClientCustomerCopyById(long id)
            throws DataAccessException {
        //
        ClientCustomerInfoCopyBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from ClientCustomerInfoCopyBean b where b.id = :id  ";
            bean = (ClientCustomerInfoCopyBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            //
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in findClientCustomerCopyById(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public ExtUserBean findCustomerContact(String userId)
            throws DataAccessException {
        //
        ExtUserBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from ExtUserBean b where b.userId = :userId  ";
            bean = (ExtUserBean) session.createQuery(query)
                    .setString("userId", userId).setMaxResults(1)
                    .uniqueResult();
            //
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in findCustomerContact(String userId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public PastCreditAppBean getAppsForTransmissionByRequestId(long supplierId,
                                                               long requestId)
            throws DataAccessException {
        //
        PastCreditAppBean creditAppBean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from PastCreditAppBean b where b.supplierId = :supplierId  ");
          //  bf.append("  and b.transmittedFlag <> :transmittedFlag ");
            bf.append("  and b.id = :requestId  ");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("supplierId", supplierId);
           // hibQuery.setString("transmittedFlag", MatrixConstants.ANSWER_YES);
            hibQuery.setLong("requestId", requestId);
            //
            creditAppBean = (PastCreditAppBean) hibQuery.setMaxResults(1)
                    .uniqueResult();
            //
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CustomerDataDAO.getAppsForTransmissionByRequestId(long supplierId,long requestId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return creditAppBean;
    }

    public void updateTransmittedData(PastCreditAppBean creditAppBean,
                                      String transmittedFlag,
                                      String trxnBatchControlToken)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " update PastCreditAppBean b  set b.transmittedFlag = :transmittedFlag , b.trxnBatchControlToken =:trxnBatchControlToken  where b.id = :id  ");
            String query = bf.toString();
            //
            //
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("id", creditAppBean.getId().longValue());
            hibQuery.setString("transmittedFlag", transmittedFlag);
            hibQuery.setString("trxnBatchControlToken", trxnBatchControlToken);
            hibQuery.executeUpdate();
            //
            session.flush();
            session.clear();
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in CustomerDataDAO.updateTransmittedData(PastCreditAppBean creditAppBean,String transmittedFlag,String trxnBatchControlToken)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public void updateTransmittedData(long requestId, String transmittedFlag)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " update PastCreditAppBean b  set b.transmittedFlag = :transmittedFlag where b.id = :id  ");
            String query = bf.toString();
            //
            //
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("id", requestId);
            hibQuery.setString("transmittedFlag", transmittedFlag);
            hibQuery.executeUpdate();
            //
            session.flush();
            session.clear();
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in CustomerDataDAO.updateTransmittedData(PastCreditAppBean creditAppBean,String transmittedFlag)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //
        System.out.println("----start---");
        //
        // new CustomerDataDAO().findClientCustomerCopyById(1);
        // List<PastCreditAppBean> ls =new
        // CustomerDataDAO().getAppsForTransmission(1,
        // DateUtility.dateOfXDaysFromToday(-8000),10);
        List<PastCreditAppBean> ls = new CustomerDataDAO()
                .getAppsForTransmissionByGroup(26,
                        DateUtility.dateOfXDaysFromToday(-500), 10);
        //
        System.out.println("----ls.size()---" + ls.size());
        System.out.println("----stop---");
    }
}
