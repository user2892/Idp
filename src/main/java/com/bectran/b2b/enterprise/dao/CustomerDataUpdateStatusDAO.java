/**
 * 
 */
package com.bectran.b2b.enterprise.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.enterprise.beans.CustomerDataUpdateStatusByGroupBean;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Jul 1, 2012 - 3:45:16 PM
 */
public class CustomerDataUpdateStatusDAO {
    public void updateLoadStatus(GroupAccountBean groupBean, int recordCount,
                                 Date startTime, int batchCount,
                                 String cusDataType)
            throws DataAccessException {
        CustomerDataUpdateStatusByGroupBean statusBean = new CustomerDataUpdateStatusByGroupBean();
        statusBean.setStartTime(startTime);
        statusBean.setNumberOfBatch(batchCount);
        statusBean.setEndTime(new Date());
        statusBean.setNumberOfRec(recordCount);
        statusBean.setCusDataType(cusDataType);
        statusBean.setSupplierId(groupBean.getSupplierId());
        statusBean.setGroupId(groupBean.getId());
        statusBean.setId(
                groupBean.getSupplierId().toString() + "#" + groupBean.getId()
                        + "#" + cusDataType + "#" + computeTimeStamp());
        //
        saveOrUpdate(statusBean);
    }

    public static String computeTimeStamp() {
        //
        Date date = new Date();
        SimpleDateFormat formatter;
        String pattern = "yyyyMMddHHmmss";
        formatter = new SimpleDateFormat(pattern);
        String rfd = formatter.format(date)
                + Math.round(Math.random() * 1000000.0D);
        return rfd;
    }

    private void saveOrUpdate(CustomerDataUpdateStatusByGroupBean bean)
            throws DataAccessException {
        //
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(bean);
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CustomerDataUpdateStatusDAO.saveOrUpdate()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public List<CustomerDataUpdateStatusByGroupBean> findStatus(long supplierId)
            throws DataAccessException {
        //
        List<CustomerDataUpdateStatusByGroupBean> ls = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            String query_open = " from CustomerDataUpdateStatusByGroupBean b where b.supplierId = :supplierId "
                    + " order by b.cusDataType asc ";
            Query hibQuery = session.createQuery(query_open);
            hibQuery.setLong("supplierId", supplierId);
            ls = (ArrayList<CustomerDataUpdateStatusByGroupBean>) hibQuery
                    .list();
            //
            // tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CustomerDataUpdateStatusDAO.findTerms(long supplierId)";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new com.bectran.matrix.framework.exception.DataAccessException(
                    excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return ls;
    }

    /**
     * @param args
     * @throws DataAccessException
     */
    public static void main(String[] args) throws Exception {
        //
        System.out.println("----start---");
        // findTerm("ww");
        // new CustomerDataUpdateStatusDAO().findStatus(1);
        System.out.println("----stop---");
    }
}
