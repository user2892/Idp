package com.bectran.b2b.enterprise.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.enterprise.beans.CrApprovalBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 */
public class CrApprovalDAO {
    public CrApprovalBean findById(long id) throws DataAccessException {
        //
        CrApprovalBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            String query = " from CrApprovalBean b where b.id = :id  ";
            bean = (CrApprovalBean) session.createQuery(query).setLong("id", id)
                    .setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CrApprovalDAO.findById(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static CrApprovalBean findByRequestId(long requestId)
            throws DataAccessException {
        //
        CrApprovalBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            String query = " from CrApprovalBean b where b.requestId = :requestId  ";
            bean = (CrApprovalBean) session.createQuery(query)
                    .setLong("requestId", requestId).setMaxResults(1)
                    .uniqueResult();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CrApprovalDAO.findByRequestId(long requestId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public List<CrApprovalBean> getApprovalsForTransmission(long supplierId,
                                                            Date inboundDataStartDate,
                                                            int maxRecord)
            throws DataAccessException {
        //
        List<CrApprovalBean> ls = null;
        Session session = null;
        try {
            //
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from CrApprovalBean b where b.supplierId = :supplierId  ");
            bf.append("  and b.transmittedFlag = :transmittedFlag ");
            bf.append("  and b.approvalDate >= :inboundDataStartDate  ");
            bf.append("  and b.status IN ");
            bf.append(" ( ");
            bf.append(":approved, :declined, :Cancelled ");
            bf.append(" )");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("supplierId", supplierId);
            hibQuery.setString("transmittedFlag", MatrixConstants.ANSWER_NO);
            hibQuery.setTimestamp("inboundDataStartDate", inboundDataStartDate);
            //
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
            String excpmessage = "Error executing query in CrApprovalDAO.getApprovalsForTransmission(supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public List<CrApprovalBean> getApprovalsForTransmissionByGroup(long groupId,
                                                                   Date inboundDataStartDate,
                                                                   int maxRecord)
            throws DataAccessException {
        //
        List<CrApprovalBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from CrApprovalBean b where b.creditRequestSummary.groupId = :groupId  ");
            bf.append("  and b.transmittedFlag = :transmittedFlag ");
            bf.append("  and b.approvalDate >= :inboundDataStartDate  ");
            bf.append("  and b.status IN ");
            bf.append(" ( ");
            bf.append(":approved, :declined, :Cancelled ");
            bf.append(" )");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("groupId", groupId);
            hibQuery.setString("transmittedFlag", MatrixConstants.ANSWER_NO);
            hibQuery.setTimestamp("inboundDataStartDate", inboundDataStartDate);
            //
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
            String excpmessage = "Error executing query in CrApprovalDAO.getApprovalsForTransmissionByGroup(long groupId, Date inboundDataStartDate)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public void updateTransmittedApprovals(List<CrApprovalBean> ls,
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
                    " update CrApprovalBean b  set b.transmittedFlag = :transmittedFlag , b.trxnBatchControlToken =:trxnBatchControlToken  where b.id = :id  ");
            String query = bf.toString();
            //
            int batchCount = 0; // save in batches of 20
            for (CrApprovalBean bean : ls) {
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
            String excpmessage = "Error executing query in CrApprovalDAO.updateTransmittedApprovals";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void commitTransmittedApprovals(String trxnBatchControlToken)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            String query_open = " update CrApprovalBean b set b.transmittedFlag = :transmittedFlag where  b.trxnBatchControlToken = :trxnBatchControlToken   ";
            Query hibQuery = session.createQuery(query_open);
            hibQuery.setString("trxnBatchControlToken", trxnBatchControlToken);
            hibQuery.setString("transmittedFlag", MatrixConstants.ANSWER_YES);
            hibQuery.executeUpdate();
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CrApprovalDAO.updateTransmittedApprovals";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static List<CrApprovalBean> getTransmittedApprovalsForUpdate(String trxnBatchControlToken)
            throws DataAccessException {
        //
        List<CrApprovalBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            String query_open = " from CrApprovalBean b where  b.trxnBatchControlToken = :trxnBatchControlToken   ";
            Query hibQuery = session.createQuery(query_open);
            hibQuery.setString("trxnBatchControlToken", trxnBatchControlToken);
            ls = (ArrayList<CrApprovalBean>) hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CrApprovalDAO.getTransmittedApprovalsForUpdate";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public List<CrApprovalBean> getApprovalsForIDPTransmission(long supplierId,long requestId)
            throws DataAccessException {
        //
        List<CrApprovalBean> ls = null;
        Session session = null;
        try {
            //
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(" from CrApprovalBean b where b.supplierId = :supplierId and b.requestId = :requestId ");
            bf.append("  and b.status IN ");
            bf.append(" ( ");
            bf.append(":approved, :declined, :Cancelled ");
            bf.append(" )");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("supplierId", supplierId);
            hibQuery.setLong("requestId", requestId);
            //
            hibQuery.setString("approved", MatrixConstants.STATUS_APPROVED);
            hibQuery.setString("declined", MatrixConstants.STATUS_DECLINED);
            hibQuery.setString("Cancelled", MatrixConstants.STATUS_CANCELLED);
            //
            hibQuery.setMaxResults(1);
            ls = hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CrApprovalDAO.getApprovalsForIDPTransmission(supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }
    
    public List<CrApprovalBean> getApprovalsIDPTransmissionByGroup(long groupId,long requestId)
            throws DataAccessException {
        //
        List<CrApprovalBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(" from CrApprovalBean b where b.creditRequestSummary.groupId = :groupId  ");
            bf.append("  and b.requestId = :requestId ");
            bf.append("  and b.status IN ");
            bf.append(" ( ");
            bf.append(":approved, :declined, :Cancelled ");
            bf.append(" )");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("groupId", groupId);
            hibQuery.setLong("requestId", requestId);
            //
            hibQuery.setString("approved", MatrixConstants.STATUS_APPROVED);
            hibQuery.setString("declined", MatrixConstants.STATUS_DECLINED);
            hibQuery.setString("Cancelled", MatrixConstants.STATUS_CANCELLED);
            //
            hibQuery.setMaxResults(1);
            ls = hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CrApprovalDAO.getApprovalsForTransmissionByGroup(long groupId, Date inboundDataStartDate)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }
    /**
     * @param args
     * @throws DataAccessException
     */
    public static void main(String[] args) throws Exception {
        //
        System.out.println("----start---");
        //
        new CrApprovalDAO().getApprovalsForTransmissionByGroup(26, new Date(),
                6);
        System.out.println("----stop---");
    }
}
