/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.attribute.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.attribute.beans.AttributeGroupBean;
import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author Shanmu
 * @date Aug 5, 2015 10:48:20 AM
 */
public class AttributeGroupDAO {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>AttributeGroupDAO</code>
     */
    private AttributeGroupDAO() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @param supplierID
     * @param groupID
     * @param attributeGroupBean
     * @return
     * @throws DataAccessException
     */
    public static AttributeGroupBean createAttributeGroup(long supplierID,
                                                          long groupID,
                                                          AttributeGroupBean attributeGroupBean)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(attributeGroupBean);
            transaction.commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.createAttributeGroup(long supplierID,long groupID,AttributeGroupBean attributeGroupBean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return attributeGroupBean;
    }

    /**
     * @param attributeGroupBean
     * @return
     * @throws DataAccessException
     */
    public static AttributeGroupBean updateAttributeGroup(AttributeGroupBean attributeGroupBean)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(attributeGroupBean);
            transaction.commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.updateAttributeGroup(AttributeGroupBean attributeGroupBean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return attributeGroupBean;
    }

    /**
     * @param supplierID
     * @param groupID
     * @param appType
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
    public static List<AttributeGroupBean> retrieveAll(long supplierID,
                                                       long groupID,
                                                       String appType)
            throws DataAccessException {
        List<AttributeGroupBean> bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from AttributeGroupBean b where b.supplierID = :supplierID and b.groupID = :groupID and b.appType=:appType ";
            bean = session.createQuery(query).setLong("supplierID", supplierID)
                    .setLong("groupID", groupID).setString("appType", appType)
                    .list();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.retrieveAll(long supplierID,long groupID,String appType)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    /**
     * @param supplierID
     * @param groupID
     * @param attributeGroupID
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
    public static List<AttributeGroupBean> retrieveAllActive(long supplierID,
                                                             long groupID)
            throws DataAccessException {
        List<AttributeGroupBean> bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from AttributeGroupBean b where b.supplierID = :supplierID and b.status=:status and b.groupID = :groupID order By b.showOrder";
            bean = session.createQuery(query).setLong("supplierID", supplierID)
                    .setString("status", MatrixConstants.STATUS_ACTIVE)
                    .setLong("groupID", groupID).list();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.retrieveAll(long supplierID,long groupID)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    /**
     * @param supplierID
     * @param groupID
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
    public static List<AttributeGroupBean> retrieveAll(long supplierID,
                                                       long groupID)
            throws DataAccessException {
        List<AttributeGroupBean> bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from AttributeGroupBean b where b.supplierID = :supplierID and b.groupID = :groupID order By b.showOrder";
            bean = session.createQuery(query).setLong("supplierID", supplierID)
                    .setLong("groupID", groupID).list();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.retrieveAll(long supplierID,long groupID)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    /**
     * @param supplierID
     * @param groupID
     * @param attributeGroupID
     * @return
     * @throws DataAccessException
     */
    public static AttributeGroupBean retrieveAttributeGroup(long supplierID,
                                                            long groupID,
                                                            long attributeGroupID)
            throws DataAccessException {
        AttributeGroupBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from AttributeGroupBean b where  b.supplierID = :supplierID and b.groupID = :groupID  and b.attributeGroupID = :attributeGroupID ";
            bean = (AttributeGroupBean) session.createQuery(query)
                    .setLong("supplierID", supplierID)
                    .setLong("groupID", groupID)
                    .setLong("attributeGroupID", attributeGroupID)
                    .setMaxResults(1).uniqueResult();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.retrieveAttributeGroup(long supplierID,long groupID,long attributeGroupID)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    /**
     * @param attributeGroupID
     * @return
     * @throws DataAccessException
     */
    public static AttributeGroupBean retrieveActiveAttributeGroup(long attributeGroupID)
            throws DataAccessException {
        AttributeGroupBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from AttributeGroupBean b where b.attributeGroupID = :attributeGroupID and b.status=:status ";
            bean = (AttributeGroupBean) session.createQuery(query)
                    .setString("status", MatrixConstants.STATUS_ACTIVE)
                    .setLong("attributeGroupID", attributeGroupID)
                    .setMaxResults(1).uniqueResult();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.retrieveAttributeGroup(long attributeGroupID)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    /**
     * @param attributeGroupID
     * @param status
     * @return
     * @throws DataAccessException
     */
    public static AttributeGroupBean retrieveAttributeGroup(long attributeGroupID)
            throws DataAccessException {
        AttributeGroupBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from AttributeGroupBean b where b.attributeGroupID = :attributeGroupID";
            bean = (AttributeGroupBean) session.createQuery(query)
                    .setLong("attributeGroupID", attributeGroupID)
                    .setMaxResults(1).uniqueResult();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.retrieveAttributeGroup(long attributeGroupID)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    /**
     * @param attributeGroupID
     * @return
     * @throws DataAccessException
     */
    public static boolean deleteAttributeGroup(long attributeGroupID)
            throws DataAccessException {
        boolean result = false;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction transaction = session.getTransaction();
            transaction.begin();
            String deleteQuery = " delete from ListValueBean lv where lv.attributeDefID  in ( select a.attributeDefID from AttributeDefBean a where a.attributeGroupID = :attributeGroupID )";
            session.createQuery(deleteQuery)
                    .setLong("attributeGroupID", attributeGroupID)
                    .executeUpdate();
            deleteQuery = "delete from AttributeDefBean a where a.attributeGroupID=:attributeGroupID";
            session.createQuery(deleteQuery)
                    .setLong("attributeGroupID", attributeGroupID)
                    .executeUpdate();
            deleteQuery = " delete from AttributeGroupBean a where a.attributeGroupID=:attributeGroupID";
            session.createQuery(deleteQuery)
                    .setLong("attributeGroupID", attributeGroupID)
                    .executeUpdate();
            transaction.commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.updateAttributeGroup(AttributeGroupBean attributeGroupBean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return result;
    }

    /**
     * @param attributeGroupID
     * @throws DataAccessException
     */
    public static void deactivateAttributeGroup(long attributeGroupID,
                                                String userID)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction transaction = session.getTransaction();
            transaction.begin();
            String updateQuery = " update AttributeDefBean a set a.status=:status,a.modifiedBy=:modifiedBy, a.modifiedDate=now() where a.attributeGroupID in :attributeGroupID";
            session.createQuery(updateQuery).setString("modifiedBy", userID)
                    .setString("status", MatrixConstants.STATUS_INACTIVE)
                    .setLong("attributeGroupID", attributeGroupID)
                    .executeUpdate();
            updateQuery = " update AttributeGroupBean a set a.status=:status where a.attributeGroupID = :attributeGroupID )";
            session.createQuery(updateQuery)
                    .setString("status", MatrixConstants.STATUS_INACTIVE)
                    .setLong("attributeGroupID", attributeGroupID)
                    .executeUpdate();
            transaction.commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.deactivateAttributeGroup(AttributeGroupBean attributeGroupBean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    /**
     * @param groupID
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
    public static List<AttributeGroupBean> retrieveAllNotAdded(long groupID)
            throws DataAccessException {
        List<AttributeGroupBean> bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from AttributeGroupBean b where b.status=:status and b.groupID = :groupID and b.attributeGroupID NOT in (select attributeGroupID from GroupCustomAppAttrGrpBean c WHERE c.groupID=:groupID)";
            bean = session.createQuery(query)
                    .setString("status", MatrixConstants.STATUS_ACTIVE)
                    .setLong("groupID", groupID).list();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AttributeGroupDAO.retrieveAll(long supplierID,long groupID)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        AttributeGroupBean attributeGroupBean = AttributeGroupDAO
                .retrieveActiveAttributeGroup(2);
        System.out.println(attributeGroupBean);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
