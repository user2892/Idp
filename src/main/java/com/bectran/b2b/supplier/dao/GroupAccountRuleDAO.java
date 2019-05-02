/**
 * 
 */
package com.bectran.b2b.supplier.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.supplier.beans.GroupAccountRuleBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author Louis Ifeguni
 * @date Dec 8, 2013 : 11:37:45 AM
 */
public class GroupAccountRuleDAO {
    public void saveOrUpdate(GroupAccountRuleBean bean)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(bean);
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Data Insert Failed in GroupAccountRuleDAO.saveOrUpdate(GroupAccountRuleBean bean)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public GroupAccountRuleBean find(long id) throws DataAccessException {
        GroupAccountRuleBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from GroupAccountRuleBean f where f.id = :id  ";
            bean = (GroupAccountRuleBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in GroupAccountRuleDAO.findGroup(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public void updateRule(long id, String groupRule)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            String query = " update GroupAccountRuleBean f  set f.groupRule = :groupRule where f.id = :id ";
            session.createQuery(query).setLong("id", id)
                    .setString("groupRule", groupRule).executeUpdate();
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in updateRule(long id, String groupRule)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public void updateSearchScope(long id, String groupSearchScope)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            String query = " update GroupAccountRuleBean f  set f.groupSearchScope = :groupSearchScope where f.id = :id ";
            session.createQuery(query).setLong("id", id)
                    .setString("groupSearchScope", groupSearchScope)
                    .executeUpdate();
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in updateRule(long id, String groupRule)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
