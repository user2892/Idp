/**
 * 
 */
package com.bectran.b2b.supplier.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.supplier.beans.BecOptionalSubBean;
import com.bectran.b2b.supplier.beans.BecSubscriptionBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 28, 2012 : 11:39:17 PM
 */
public class BecOptionalSubDAO {
    public static BecOptionalSubBean findSub(String id)
            throws DataAccessException {
        //
        BecOptionalSubBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from BecOptionalSubBean c where c.id = :id ";
            bean = (BecOptionalSubBean) session.createQuery(query)
                    .setString("id", id).setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in BecOptionalSubDAO.findSub(String id)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static List<BecOptionalSubBean> find(long supplierId)
            throws DataAccessException {
        //
        List<BecOptionalSubBean> result = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from BecOptionalSubBean c where c.supplierId = :corpid ";
            result = session.createQuery(query).setLong("corpid", supplierId)
                    .list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in BecOptionalSubDAO.find(long supplierId)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return result;
    }

    public static void save(BecOptionalSubBean bean)
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
            String excpmessage = "Error executing query in BecOptionalSubDAO.store(BecOptionalSubBean bean)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void saveAll(List<BecOptionalSubBean> subList)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            int batchCount = 0; // save in batches of 20
            for (Iterator<BecOptionalSubBean> i = subList.iterator(); i
                    .hasNext();) {
                BecOptionalSubBean dt = (BecOptionalSubBean) i.next();
                session.saveOrUpdate(dt);
                batchCount = batchCount + 1;
                if (batchCount % 20 == 0) { // 20, same as the JDBC batch size
                    // flush a batch of inserts and release memory:
                    session.flush();
                    session.clear();
                }
            }
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Data update Failed in BecOptionalSubDAO.saveAll(List<BecOptionalSubBean> subList)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static List<BecSubscriptionBean> WORK_AROUND()
            throws DataAccessException {
        //
        List<BecSubscriptionBean> result = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from BecSubscriptionBean  ";
            result = session.createQuery(query).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            String excpmessage = "Error executing query in BecOptionalSubDAO.WORK_AROUND()";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        find(1);
        System.out.println("--done--");
    }
}
