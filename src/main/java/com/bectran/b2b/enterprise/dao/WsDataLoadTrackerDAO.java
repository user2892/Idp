/**
 * 
 */
package com.bectran.b2b.enterprise.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.enterprise.beans.WsDataLoadTrackerBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MatrixPasswordUtil;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * LOUIS IFEGUNI Apr 12, 2016 / 8:25:51 AM
 */
public class WsDataLoadTrackerDAO {
    public void saveOrUpdate(WsDataLoadTrackerBean bean)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            session.saveOrUpdate(bean);
            String txnCode = bean.getId()
                    + MatrixPasswordUtil.generatePassword(8);
            bean.setTxnCode(txnCode);
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in WsDataLoadTrackerDAO.saveOrUpdate()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public WsDataLoadTrackerBean findByTxnCode(String txnCode)
            throws DataAccessException {
        //
        WsDataLoadTrackerBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from WsDataLoadTrackerBean b where b.txnCode = :txnCode  ";
            bean = (WsDataLoadTrackerBean) session.createQuery(query)
                    .setString("txnCode", txnCode).setMaxResults(1)
                    .uniqueResult();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in WsDataLoadTrackerDAO.findByTxnCode(String txnCode) ";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

}
