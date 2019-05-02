package com.bectran.b2b.supplier.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.SupplierUserBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI Nov 15, 2010: 12:02:17 AM
 */
public class GroupAccountDAO {
    /**
     * @author LOUIS IFEGUNI Nov 14, 2010: 8:15:01 AM
     */
    public static void saveOrUpdate(GroupAccountBean bean)
            throws DataAccessException {
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
            String excpmessage = "Data Insert Failed in GroupAccountDAO.saveOrUpdate(GroupAccountBean bean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public List<GroupAccountBean> findGroupsForSupplier(long supplierId)
            throws DataAccessException {
        //
        List<GroupAccountBean> list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupAccountBean c where c.supplierId = :supplierId ";
            Query hquery = session.createQuery(query).setLong("supplierId",
                    supplierId);
            list = (ArrayList<GroupAccountBean>) hquery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in GroupAccountDAO.findGroup(long supplierId)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return list;
    }

    public GroupAccountBean findGroup(long id) throws DataAccessException {
        GroupAccountBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupAccountBean f where f.id = :id  ";
            bean = (GroupAccountBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in GroupAccountDAO.findGroup(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static SupplierUserBean getMainContact(long supplierId)
            throws DataAccessException {
        Session session = null;
        SupplierUserBean contact = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupAccountBean f where f.supplierId = :supplierId and f.primaryGroup = :primaryGroup ";
            Query hQuery = session.createQuery(query);
            hQuery.setLong("supplierId", supplierId);
            hQuery.setString("primaryGroup", MatrixConstants.ANSWER_YES);
            List ls = hQuery.list();
            GroupAccountBean bean = (GroupAccountBean) ls.get(0);
            contact = bean.getGroupContact();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in GroupAccountDAO.findGroup(long supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return contact;
    }

    public GroupAccountBean getPrimaryGroup(long supplierId)
            throws DataAccessException {
        Session session = null;
        GroupAccountBean bean = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupAccountBean f where f.supplierId = :supplierId and f.primaryGroup = :primaryGroup ";
            Query hQuery = session.createQuery(query);
            hQuery.setLong("supplierId", supplierId);
            hQuery.setString("primaryGroup", MatrixConstants.ANSWER_YES);
            List ls = hQuery.list();
            bean = (GroupAccountBean) ls.get(0);
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in GroupAccountDAO.getPrimaryGroup(long supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static List<GroupAccountBean> findAll() throws DataAccessException {
        //
        List<GroupAccountBean> list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupAccountBean c";
            Query hquery = session.createQuery(query);
            list = (ArrayList<GroupAccountBean>) hquery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in GroupAccountDAO.findAll()";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return list;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.out.println("---in---");
        // getRequestBridge(1);
        // getCreditReference(1);
        // findGroup(1l);
        GroupAccountBean groupBean = new GroupAccountDAO().getPrimaryGroup(1);
        SupplierUserBean admin = groupBean.getGroupContact();
        System.out.println(admin.getUserId());
        System.out.println("---out---");
    }
}
