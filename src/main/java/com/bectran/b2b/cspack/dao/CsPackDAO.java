/**
 * 
 */
package com.bectran.b2b.cspack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.cspack.beans.CsPackBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Jan 12, 2013 : 9:49:38 PM
 */
public class CsPackDAO {
    public static List<CsPackBean> myRequestList(String userId)
            throws DataAccessException {
        //
        List<CsPackBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from CsPackBean b where b.userId = :userId order by b.lastUpdate desc";
            ls = session.createQuery(query).setString("userId", userId).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CsPackDAO.myRequestList(long requestId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static CsPackBean getCsPack(long id) throws DataAccessException {
        //
        CsPackBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from CsPackBean b where b.id = :id ";
            bean = (CsPackBean) session.createQuery(query).setLong("id", id)
                    .setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CsPackDAO.getCsPack(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public static void saveOrUpdate(CsPackBean bean)
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
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CsPackDAO.saveOrUpdate( CsPackBean bean)";
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
    public static void main(String[] args) throws Exception {
        System.out.println("-----1-----");
        // myRequestList("hshsh");
        // allRequestByUnit(1);
        System.out.println("-----2-----");
    }
}
