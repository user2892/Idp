/**
 * 
 */
package com.bectran.b2b.supplier.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.supplier.beans.GroupCustomCreditAppListContentBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 2, 2012 : 9:05:42 PM
 */
public class GroupCustomCreditAppListContentDAO {
    public static List<GroupCustomCreditAppListContentBean> find(long headerId)
            throws DataAccessException {
        //
        List<GroupCustomCreditAppListContentBean> list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomCreditAppListContentBean c where c.headerId = :headerId ";
            Query hquery = session.createQuery(query).setLong("headerId",
                    headerId);
            list = hquery.list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in GroupCustomCreditAppListContentDAO.find(long headerId)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return list;
    }

    public static void saveModel(GroupCustomCreditAppListContentBean bean)
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
            String excpmessage = "Data update Failed in GroupCustomCreditAppListContentDAO.saveModel(GroupCustomCreditAppListContentBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void deleteModel(GroupCustomCreditAppListContentBean bean)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            session.delete(bean);
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in GroupCustomCreditAppListContentDAO.deleteModel(GroupCustomCreditAppListContentBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static GroupCustomCreditAppListContentBean findItem(long id)
            throws DataAccessException {
        GroupCustomCreditAppListContentBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupCustomCreditAppListContentBean f where f.id = :id  ";
            bean = (GroupCustomCreditAppListContentBean) session
                    .createQuery(query).setLong("id", id).setMaxResults(1)
                    .uniqueResult();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in GroupCustomCreditAppListContentDAO.findItem(long id)";
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
