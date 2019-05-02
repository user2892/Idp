/**
 * 
 */
package com.bectran.b2b.supplier.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.supplier.beans.GroupCustomAppCntrlBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 12, 2013 : 4:17:13 PM
 */
public class GroupCustomAppCntrlDAO {
    public static List<GroupCustomAppCntrlBean> find(long groupId)
            throws DataAccessException {
        //
        List<GroupCustomAppCntrlBean> list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomAppCntrlBean c where c.groupId = :groupId ";
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
            String excpmessage = "Data update Failed in GroupCustomAppCntrlDAO.find(long groupId)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return list;
    }

    public static void saveModel(GroupCustomAppCntrlBean bean)
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
            String excpmessage = "Data update Failed in GroupCustomAppCntrlDAO.saveModel(GroupCustomAppCntrlBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static GroupCustomAppCntrlBean findItem(String id)
            throws DataAccessException {
        GroupCustomAppCntrlBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomAppCntrlBean f where f.id = :id  ";
            bean = (GroupCustomAppCntrlBean) session.createQuery(query)
                    .setString("id", id).setMaxResults(1).uniqueResult();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in GroupCustomAppCntrlDAO.findItem(long id)";
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
