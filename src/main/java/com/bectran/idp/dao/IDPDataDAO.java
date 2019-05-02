/**
 *
 */
package com.bectran.idp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.customer.beans.CreditReqTransmitDetailsBean;
import com.bectran.b2b.enterprise.beans.EnterpriseIntgServiceBean;
import com.bectran.idp.beans.IDPOnPrequalTransmitLogBean;
import com.bectran.idp.beans.IDPOnSubmutTransmitLogBean;
import com.bectran.idp.beans.IDPTransmitLogBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author Santhosh
 * @date June 1, 2016 : 11:04:24 AM
 */
public class IDPDataDAO {
    public void saveTransmitLogDetails(IDPTransmitLogBean transmitLogBean,EnterpriseIntgServiceBean entgIntgSvcBean)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(transmitLogBean);
            session.update(entgIntgSvcBean);
            session.update(entgIntgSvcBean.getIdpServiceBean());
            //
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in IDPDataDAO.saveTransmitLogDetails(transmitLogBean,entgIntgSvcBean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }
    
    /**
     * @param requestID
     * @return
     * @throws DataAccessException
     */
    public IDPTransmitLogBean findByRequestID(long requestID)
            throws DataAccessException {
        IDPTransmitLogBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = "from IDPTransmitLogBean c where c.requestId = :requestID";
            bean = (IDPTransmitLogBean) session.createQuery(query)
                    .setLong("requestID", requestID).setMaxResults(1)
                    .uniqueResult();
        }
        catch (Exception e) {
            String excpmessage = "Data retrieval Failed in IDPTransmitLogDAO.findByRequestID(String id)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }
    
    public void saveTransmitLogDetailsFromListener(IDPTransmitLogBean transmitLogBean)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(transmitLogBean);
            //
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in IDPDataDAO.saveTransmitLogDetailsFromListeners(transmitLogBean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }
    
    //Code change for BEC-496
    /**
     * @param requestID
     * @return
     * @throws DataAccessException
     */
    public CreditReqTransmitDetailsBean findCreditReqTransmitDetails(long requestID)
            throws DataAccessException {
        CreditReqTransmitDetailsBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = "from CreditReqTransmitDetailsBean c where c.headerId = :requestID";
            bean = (CreditReqTransmitDetailsBean) session.createQuery(query)
                    .setLong("requestID", requestID).setMaxResults(1)
                    .uniqueResult();
        }
        catch (Exception e) {
            String excpmessage = "Data retrieval Failed in IDPDataDAO.findCreditReqTransmitDetails(String requestID)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }
    
    /**
     * @param creditReqTransmitDetails
     * @throws DataAccessException
     */
    public void saveCreditReqTransmitDetailsBean(CreditReqTransmitDetailsBean creditReqTransmitDetails)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(creditReqTransmitDetails);
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in IDPDataDAO.saveCreditReqTransmitDetailsBean(creditReqTransmitDetails)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }
    
    
    /**
     * @param transmitLogBean
     * @param entgIntgSvcBean
     * @throws DataAccessException
     */
    public void saveOnSubmitTransmitLogDetails(IDPOnSubmutTransmitLogBean transmitLogBean,EnterpriseIntgServiceBean entgIntgSvcBean)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(transmitLogBean);
            session.update(entgIntgSvcBean);
            session.update(entgIntgSvcBean.getIdpServiceBean());
            //
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in IDPDataDAO.saveOnSubmitTransmitLogDetails(transmitLogBean,entgIntgSvcBean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }
    
    public void saveOnSubmitTransmitLogDetailsFromListener(IDPOnSubmutTransmitLogBean transmitLogBean)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(transmitLogBean);
            //
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in IDPDataDAO.saveOnSubmitTransmitLogDetailsFromListener(transmitLogBean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }
    public IDPOnPrequalTransmitLogBean findByPrequalTransmitLogBean(long requestID)
            throws DataAccessException {
    	IDPOnPrequalTransmitLogBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = "from IDPOnPrequalTransmitLogBean c where c.requestId = :requestID";
            bean = (IDPOnPrequalTransmitLogBean) session.createQuery(query)
                    .setLong("requestID", requestID).setMaxResults(1)
                    .uniqueResult();
        }
        catch (Exception e) {
            String excpmessage = "Data retrieval Failed in IDPTransmitLogDAO.findByRequestID(String id)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

	public void saveOnPreqaulTransmitLogDetailsFromListener(IDPOnPrequalTransmitLogBean transmitLogBean)
			 throws DataAccessException{
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(transmitLogBean);
            //
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in IDPDataDAO.saveOnPreqaulTransmitLogDetailsFromListener(transmitLogBean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
	}

	public void saveOnPrequalTransmitLogDetails(IDPOnPrequalTransmitLogBean transmitLogBean,
			EnterpriseIntgServiceBean entgIntgSvcBean) throws DataAccessException {
		 //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(transmitLogBean);
            session.update(entgIntgSvcBean);
            session.update(entgIntgSvcBean.getIdpServiceBean());
            //
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in IDPDataDAO.saveOnPrequalTransmitLogDetails(transmitLogBean,entgIntgSvcBean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
	}
}
