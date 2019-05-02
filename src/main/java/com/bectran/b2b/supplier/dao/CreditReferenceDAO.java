package com.bectran.b2b.supplier.dao;

import org.hibernate.Session;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.crol.beans.CreditRefBean;
import com.bectran.b2b.crol.beans.RefRequestBridgeBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

public class CreditReferenceDAO {
    /**
     * @author LOUIS IFEGUNI Feb 104, 2010: 10:15:01 AM
     */
    public static RefRequestBridgeBean getRequestBridgeBean(long refForReqId)
            throws DataAccessException {
        //
        RefRequestBridgeBean supplier = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from RefRequestBridgeBean c where c.refForReqId = :refForReqId ";
            supplier = (RefRequestBridgeBean) session.createQuery(query)
                    .setLong("refForReqId", refForReqId).setMaxResults(1)
                    .uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Error executing query in CreditReferenceDAO.getRequestBridge(long refForReqId)",
                    e);
            throw new DataAccessException(
                    "Error executing query in CreditReferenceDAO.getRequestBridge(long refForReqId)");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return supplier;
    }

    public static CreditRefBean getCreditReference(long requestID)
            throws DataAccessException {
        //
        CreditRefBean supplier = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from CreditRefBean c where c.requestID = :requestID ";
            supplier = (CreditRefBean) session.createQuery(query)
                    .setLong("requestID", requestID).setMaxResults(1)
                    .uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Error executing query in CreditReferenceDAO.getCreditReference(long requestID)",
                    e);
            throw new DataAccessException(
                    "Error executing query in CreditReferenceDAO.getCreditReference(long requestID))");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return supplier;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("---in---");
        // getRequestBridge(1);
        getCreditReference(1);
        System.out.println("---out---");
    }
}
