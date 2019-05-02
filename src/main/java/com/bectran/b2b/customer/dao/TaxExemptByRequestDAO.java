/**
 * 
 */
package com.bectran.b2b.customer.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.customer.beans.TaxExemptByRequestBean;
import com.bectran.b2b.customer.beans.TaxExemptCertBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 26, 2014 : 10:06:41 AM
 */
public class TaxExemptByRequestDAO {
    public List<TaxExemptByRequestBean> findTaxExemptsForRequest(long requestId)
            throws DataAccessException {
        //
        List<TaxExemptByRequestBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            StringBuffer bf = new StringBuffer();
            bf.append(
                    " from TaxExemptByRequestBean b where b.requestId = :requestId  ");
            String query = bf.toString();
            Query hibQuery = session.createQuery(query);
            hibQuery.setLong("requestId", requestId);
            //
            ls = hibQuery.list();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in TaxExemptByRequestDAO.findTaxExemptsForRequest(long requestId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    public static TaxExemptCertBean getTaxExempt(long id)
            throws DataAccessException {
        //
        TaxExemptCertBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from TaxExemptCertBean b where b.id = :id ";
            bean = (TaxExemptCertBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in TaxExemptCertMgtDAO.getTaxExempt(long id)";
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
     */
    public static void main(String[] args) throws Exception {
        //
        System.out.println("----start---");
        List<TaxExemptByRequestBean> ls = new TaxExemptByRequestDAO()
                .findTaxExemptsForRequest(380);
        System.out.println("----ls.size()---" + ls.size());
        TaxExemptByRequestBean bean = (TaxExemptByRequestBean) ls.get(0);
        System.out.println(
                "----detail---" + bean.getExemptCertBean().getExpiration());
        System.out.println("----end---");
    }
}
