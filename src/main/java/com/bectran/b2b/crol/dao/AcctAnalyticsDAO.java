package com.bectran.b2b.crol.dao;

import java.util.List;

import org.hibernate.Session;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 */
public class AcctAnalyticsDAO {
    public static double crolScore(long creditAppId)
            throws DataAccessException {
        //
        double score = 0;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " select sum(f.crolScore), count(f.crolScore) from CreditRefBean f where f.creditAppId = :creditAppId "
                    + " and f.crolScore > 0 ";
            List ls = session.createQuery(query)
                    .setLong("creditAppId", creditAppId).list();
            double total = 0;
            int count = 0;
            try {
                Object[] row = (Object[]) ls.iterator().next();
                total = ((Double) row[0]).doubleValue();
                count = ((Long) row[1]).intValue();
                score = total / count;
            }
            catch (Exception e) {
                // this means customer has no reference
                // tx.commit();
                session.close();
                return 0;
            }
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Error executing query in CreditRefDAO.crolScore(String creditAppId)",
                    e);
            throw new DataAccessException(
                    "Error executing query in CreditRefDAO.crolScore(String creditAppId)");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return score;
    }

    public static double crolScore(long creditAppId, String referenceType)
            throws DataAccessException {
        //
        double score = 0;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " select sum(f.crolScore), count(f.crolScore) from CreditRefBean f where f.creditAppId = :creditAppId "
                    + "  and f.referenceType = :referenceType and f.crolScore > 0 ";
            List ls = session.createQuery(query)
                    .setLong("creditAppId", creditAppId)
                    .setString("referenceType", referenceType).list();
            double total = 0;
            int count = 0;
            try {
                Object[] row = (Object[]) ls.iterator().next();
                total = ((Double) row[0]).doubleValue();
                count = ((Long) row[1]).intValue();
                score = total / count;
            }
            catch (Exception e) {
                // this means customer has no reference
                // tx.commit();
                session.close();
                return 0;
            }
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Error executing query in CreditRefDAO.crolScore(String creditAppId)",
                    e);
            throw new DataAccessException(
                    "Error executing query in CreditRefDAO.crolScore(String creditAppId)");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return score;
    }

    public static int numberOfRefs(long creditAppId)
            throws DataAccessException {
        int count = 0;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_1 = " select count(f.id)from CreditRefBean f where f.creditAppId = :creditAppId  and f.crolScore > 0 ";
            Long countObj = (Long) session.createQuery(query_1)
                    .setLong("creditAppId", creditAppId).setMaxResults(1)
                    .uniqueResult();
            count = countObj.intValue();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AcctAnalyticsDAO.numberOfRefs()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return count;
    }

    public static int numberOfRefs(long creditAppId, String referenceType)
            throws DataAccessException {
        int count = 0;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query_1 = " select count(f.id)from CreditRefBean f where f.creditAppId = :creditAppId  and f.crolScore > 0  and f.referenceType = :referenceType ";
            Long countObj = (Long) session.createQuery(query_1)
                    .setLong("creditAppId", creditAppId)
                    .setString("referenceType", referenceType).setMaxResults(1)
                    .uniqueResult();
            count = countObj.intValue();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in AcctAnalyticsDAO.numberOfRefs(long creditAppId, String referenceType)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return count;
    }
}
