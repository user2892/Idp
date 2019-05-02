package com.bectran.b2b.supplier.dao;

import org.hibernate.Session;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI Oct 14, 2009: 2:15:01 PM
 */
public class SupplierCompanyDAO {
    public static SupplierCompanyBean findCompany(String corpID)
            throws DataAccessException {
        SupplierCompanyBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from SupplierCompanyBean f where f.corpID = :cde  ";
            bean = (SupplierCompanyBean) session.createQuery(query)
                    .setString("cde", corpID.trim()).setMaxResults(1)
                    .uniqueResult();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in SupplierCompanyDAO.findCompany()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    public SupplierCompanyBean findCompany(long id) throws DataAccessException {
        SupplierCompanyBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from SupplierCompanyBean f where f.id = :id  ";
            bean = (SupplierCompanyBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in SupplierCompanyDAO.findCompany(long id)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }
}
