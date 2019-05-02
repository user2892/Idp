/**
 * 
 */
package com.bectran.b2b.supplier.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.supplier.beans.GroupCustomAppCategoryBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 12, 2013 : 4:17:13 PM
 */
public class GroupCustomAppCategoryDAO {
    public static List<GroupCustomAppCategoryBean> find(long groupId)
            throws DataAccessException {
        //
        List<GroupCustomAppCategoryBean> list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomAppCategoryBean c where c.groupId = :groupId ";
            Query hquery = session.createQuery(query).setLong("groupId",
                    groupId);
            list = hquery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in GroupCustomAppCategoryDAO.find(long groupId)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return list;
    }

    public static void saveModel(GroupCustomAppCategoryBean bean)
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
            String excpmessage = "Data update Failed in GroupCustomAppCategoryDAO.saveModel(GroupCustomAppCategoryBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void deleteModel(GroupCustomAppCategoryBean bean)
            throws DataAccessException {
        Session session = null;
        String query = "delete from GroupCustomCreditAppListContentBean b where b.headerId = :headerId ";
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
            String excpmessage = "Data update Failed in GroupCustomAppCategoryDAO.deleteModel(GroupCustomAppCategoryBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static GroupCustomAppCategoryBean findItem(long id)
            throws DataAccessException {
        GroupCustomAppCategoryBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomAppCategoryBean f where f.id = :id  ";
            bean = (GroupCustomAppCategoryBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in GroupCustomAppCategoryDAO.findItem(long id)";
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
     * @throws DataAccessException
     */
    public static void main(String[] args) throws DataAccessException {
        // TODO Auto-generated method stub
        find(1);
        System.out.println("-------------1----------");
    }
}
