/**
 * 
 */
package com.bectran.b2b.enterprise.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.enterprise.beans.CustomerDataUpdateStatusByGroupBean;
import com.bectran.b2b.enterprise.beans.EnterpriseAccountByGroupBean;
import com.bectran.b2b.enterprise.beans.EnterpriseIntgServiceBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @DATE Sep 19, 2011 : 8:30:54 PM
 */
public class EnterpriseAccountByGroupDAO {
    public EnterpriseAccountByGroupBean find(long id)
            throws DataAccessException {
        //
        EnterpriseAccountByGroupBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            String query = " from EnterpriseAccountByGroupBean b where b.id = :id  ";
            bean = (EnterpriseAccountByGroupBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in EnterpriseAccountByGroupDAO.find(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public EnterpriseAccountByGroupBean findByAccountId(String accountId)
            throws DataAccessException {
        //
        EnterpriseAccountByGroupBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from EnterpriseAccountByGroupBean b where b.accountId = :accountId  ";
            bean = (EnterpriseAccountByGroupBean) session.createQuery(query)
                    .setString("accountId", accountId).setMaxResults(1)
                    .uniqueResult();
            //
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in EnterpriseAccountByGroupDAO.findByAccountId(String accountId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public void saveOrUpdate(EnterpriseAccountByGroupBean bean)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            bean.setLastUpdate(new Date());
            session.saveOrUpdate(bean);
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in EnterpriseAccountByGroupDAO.saveOrUpdate(EnterpriseAccountByGroupBean bean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public List<CustomerDataUpdateStatusByGroupBean> dataUpdateStatus(long groupId)
            throws DataAccessException {
        //
        List<CustomerDataUpdateStatusByGroupBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            String query = " from CustomerDataUpdateStatusByGroupBean b where b.groupId = :groupId order by b.startTime desc ";
            Query hibQuery = session.createQuery(query).setLong("groupId",
                    groupId);
            hibQuery.setMaxResults(10);
            // ls = session.createQuery(query).setLong("groupId",
            // groupId).list();
            ls = hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in EnterpriseAccountByGroupDAO.dataUpdateStatus(long groupId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public void saveOrUpdateDataLoadStatus(CustomerDataUpdateStatusByGroupBean bean)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            session.saveOrUpdate(bean);
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in EnterpriseAccountByGroupDAO.saveOrUpdateDataLoadStatus(CustomerDataUpdateStatusByGroupBean bean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public List<EnterpriseAccountByGroupBean> getAccountsForSftpDataLoad(String integrationServiceType)
            throws DataAccessException {
        //
        List<EnterpriseAccountByGroupBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            //
            String query_open = " from EnterpriseAccountByGroupBean b where  b.integrationServiceType = :integrationServiceType  and b.accountStatus = :accountStatus ";
            Query hibQuery = session.createQuery(query_open);
            hibQuery.setString("integrationServiceType",
                    integrationServiceType);
            hibQuery.setString("accountStatus", MatrixConstants.STATUS_ACTIVE);
            ls = hibQuery.list();
            //
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in EnterpriseAccountByGroupDAO.getAccountsForSftpDataLoad()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }
    
    public static EnterpriseIntgServiceBean getEnterpriseIntgServiceBean(long supplierId,long groupId)
            throws DataAccessException {
        //
        EnterpriseIntgServiceBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from EnterpriseIntgServiceBean b where b.supplierId = :supplierId and integrationServiceType=:integrationServiceType ";
            if(groupId!=0){
                query = query + " and b.headerId=:headerId";
            }
            Query hibQuery = session.createQuery(query);        
            hibQuery.setLong("supplierId", supplierId);
            hibQuery.setString("integrationServiceType", MatrixConstants.ENTERPRISE_INTEGRATION_SERVICE_TYPE_IDP);
            
            if(groupId!=0){
                hibQuery.setLong("headerId", groupId);
            }
            
            bean = (EnterpriseIntgServiceBean)hibQuery.setMaxResults(1).uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in EnterpriseAccountByGroupDAO.getEnterpriseIntgServiceBean(long supplierId,long groupId, Session session)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }
    

 }
