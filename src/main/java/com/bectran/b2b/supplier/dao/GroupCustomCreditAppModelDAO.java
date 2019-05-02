/**
 * 
 */
package com.bectran.b2b.supplier.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.supplier.beans.GroupCustomCreditAppModelBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 2, 2012 : 10:51:27 AM
 */
public class GroupCustomCreditAppModelDAO {
    /*
     * public static List<GroupCustomCreditAppModelBean> find(long groupId)
     * throws DataAccessException { // List<GroupCustomCreditAppModelBean> list
     * = null; Session session = null; try { session =
     * MultHibUtil.currentSession(DbConstants.CROL_DB); Transaction tx =
     * session.getTransaction(); tx.begin(); // String query =
     * " from GroupCustomCreditAppModelBean c where c.groupId = :groupId ";
     * Query hquery = session.createQuery(query).setLong("groupId", groupId);
     * list = hquery.list(); // tx.commit(); session.close(); // // } catch
     * (Exception e) { String excpmessage =
     * "Data update Failed in GroupCustomCreditAppModelDAO.find(long groupId)";
     * e.printStackTrace(); AppLogger.log(AppLogger.ERROR, excpmessage, e);
     * throw new DataAccessException(excpmessage); } finally {
     * MultHibUtil.closeSession(session); } return list; }
     */
    public static List<GroupCustomCreditAppModelBean> find(String formTypeId)
            throws DataAccessException {
        //
        List<GroupCustomCreditAppModelBean> list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomCreditAppModelBean c where c.formTypeId = :formTypeId ";
            Query hquery = session.createQuery(query).setString("formTypeId",
                    formTypeId);
            list = hquery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in GroupCustomCreditAppModelDAO.find(long groupId)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return list;
    }

    public static void saveModel(GroupCustomCreditAppModelBean bean)
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
            String excpmessage = "Data update Failed in GroupCustomCreditAppModelDAO.saveModel(GroupCustomCreditAppModelBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void deleteModel(GroupCustomCreditAppModelBean bean)
            throws DataAccessException {
        Session session = null;
        String query = "delete from GroupCustomCreditAppListContentBean b where b.headerId = :headerId ";
        bean.setListContentSet(null);
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            session.createQuery(query)
                    .setLong("headerId", bean.getId().longValue())
                    .executeUpdate();
            //
            session.delete(bean);
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in GroupCustomCreditAppModelDAO.deleteModel(GroupCustomCreditAppModelBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    /*
     * private static void deleteContentListModel(GroupCustomCreditAppModelBean
     * bean) throws DataAccessException { Session session = null; String query=
     * "delete from GroupCustomCreditAppListContentBean b where b.headerId = :headerId "
     * ; try { session = MultHibUtil.currentSession(DbConstants.CROL_DB);
     * Transaction tx = session.getTransaction(); tx.begin(); //
     * session.createQuery(query).setLong("headerId",
     * bean.getId().longValue()).executeUpdate(); // tx.commit();
     * session.close(); // // } catch (Exception e) { String excpmessage =
     * "Data update Failed in GroupCustomCreditAppModelDAO.deleteContentListModel(GroupCustomCreditAppModelBean bean)"
     * ; e.printStackTrace(); AppLogger.log(AppLogger.ERROR, excpmessage, e);
     * throw new DataAccessException(excpmessage); } finally {
     * MultHibUtil.closeSession(session); } }
     */
    public static GroupCustomCreditAppModelBean findItem(long id)
            throws DataAccessException {
        GroupCustomCreditAppModelBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomCreditAppModelBean f where f.id = :id  ";
            bean = (GroupCustomCreditAppModelBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in GroupCustomCreditAppModelDAO.findItem(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static List<GroupCustomCreditAppModelBean> all_for_fix()
            throws DataAccessException {
        //
        List<GroupCustomCreditAppModelBean> list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomCreditAppModelBean ";
            Query hquery = session.createQuery(query);
            list = hquery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in GroupCustomCreditAppModelDAO.all_for_fix()";
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
     * @throws DataAccessException
     */
    public static void main(String[] args) throws DataAccessException {
        // TODO Auto-generated method stub
        // find(1);
        System.out.println("-------------1----------");
    }
}
