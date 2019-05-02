/**
 * 
 */
package com.bectran.b2b.customer.dao;

import java.util.List;

import org.hibernate.Session;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.customer.beans.UploadableDocsByRequestBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author Louis Ifeguni DATE : 02-01-2016
 */
public class UploadableDocumentDAO {
    @SuppressWarnings("unchecked")
    public List<UploadableDocsByRequestBean> getUploadableDocsByRequest(long requestId)
            throws DataAccessException {
        List<UploadableDocsByRequestBean> list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = " from UploadableDocsByRequestBean b where b.requestId = :requestId ";
            list = session.createQuery(query).setLong("requestId", requestId)
                    .list();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Error executing query in CreditDocumentDAO.getUploadableDocsByRequest(long requestId) ";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return list;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("-----1-----");
        // getUploadableDocsByRequest(1);
        System.out.println("-----2-----");
    }
}
