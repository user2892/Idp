/**
 *
 */
package com.bectran.opsmgt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;
import com.bectran.opsmgt.beans.OpsHeaderBean;
import com.bectran.opsmgt.beans.OpsUnitByGroupBean;
import com.bectran.opsmgt.beans.OpsUnitDefinitionBean;
import com.bectran.opsmgt.beans.OpsUnitRequestMgtBean;

/**
 * @author LOUIS IFEGUNI
 * @date Dec 23, 2012 : 1:40:20 PM
 */
public class OpsMgtDAO {
    public static void saveOrUpdateOpsMgt(OpsHeaderBean bean)
            throws DataAccessException {
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
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in OpsMgtDAO.setupOpsMgt(OpsHeaderBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void saveOrUpdateUnit(OpsUnitDefinitionBean bean)
            throws DataAccessException {
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
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in OpsMgtDAO.saveOrUpdateUnit(OpsUnitDefinitionBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void saveOrUpdateOpsUnitRequest(OpsUnitRequestMgtBean bean)
            throws DataAccessException {
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
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in OpsMgtDAO.saveOrUpdateOpsUnitRequest(OpsUnitRequestMgtBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void saveOrUpdateUnit(OpsUnitDefinitionBean bean,
                                        OpsUnitByGroupBean unitGroup)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            session.saveOrUpdate(bean);
            //
            unitGroup.setId(bean.getId());
            session.saveOrUpdate(unitGroup);
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in OpsMgtDAO.saveOrUpdateUnit(OpsUnitDefinitionBean bean, OpsUnitByGroupBean unitGroup)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static OpsHeaderBean find(long id) throws DataAccessException {
        //
        OpsHeaderBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from OpsHeaderBean c where c.id = :id ";
            Query hquery = session.createQuery(query).setLong("id", id);
            bean = (OpsHeaderBean) hquery.setMaxResults(1).uniqueResult();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in OpsMgtDAO.find(long id)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static List<OpsUnitDefinitionBean> findActiveUnits(long headerId)
            throws DataAccessException {
        //
        List<OpsUnitDefinitionBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            //
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from OpsUnitDefinitionBean b where b.headerId = :headerId and b.status = :status ");
            bf.append("  order by b.name asc ");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("headerId", headerId);
            hibQuery.setString("status", MatrixConstants.STATUS_ACTIVE);
            //
            ls = hibQuery.list();
            //
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in OpsMgtDAO.findActiveUnits(long headerId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static OpsUnitDefinitionBean findUnit(long id)
            throws DataAccessException {
        //
        OpsUnitDefinitionBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            //
            String query = " from OpsUnitDefinitionBean c where c.id = :id ";
            Query hquery = session.createQuery(query).setLong("id", id);
            bean = (OpsUnitDefinitionBean) hquery.setMaxResults(1)
                    .uniqueResult();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in OpsMgtDAO.findUnit(long id)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static OpsUnitRequestMgtBean findOpsUnitRequest(long id)
            throws DataAccessException {
        //
        OpsUnitRequestMgtBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            //
            String query = " from OpsUnitRequestMgtBean c where c.id = :id ";
            Query hquery = session.createQuery(query).setLong("id", id);
            bean = (OpsUnitRequestMgtBean) hquery.setMaxResults(1)
                    .uniqueResult();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in OpsMgtDAO.findOpsUnitRequest(long id)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static List<OpsUnitDefinitionBean> findActiveUnitsByParentId(long parentId)
            throws DataAccessException {
        //
        List<OpsUnitDefinitionBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            //
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from OpsUnitDefinitionBean b where b.parentId = :parentId and b.status = :status ");
            bf.append("  order by b.name asc ");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("parentId", parentId);
            hibQuery.setString("status", MatrixConstants.STATUS_ACTIVE);
            //
            ls = hibQuery.list();
            //
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in OpsMgtDAO.findUnitsByParentId(long parentId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("------1-----");
        findActiveUnits(1);
        System.out.println("------2-----");
    }
}
