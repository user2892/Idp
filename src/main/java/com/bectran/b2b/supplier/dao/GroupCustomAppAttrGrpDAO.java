/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.b2b.supplier.dao;

import org.hibernate.Session;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.supplier.beans.GroupCustomAppAttrGrpBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author Shanmu
 * @date Sat May 21 15:17:06 IST 2016
 */
public class GroupCustomAppAttrGrpDAO {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>GroupCustomAppAttrGrpDAO</code>
     */
    private GroupCustomAppAttrGrpDAO() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @param headerId
     * @return
     * @throws DataAccessException
     */
    public GroupCustomAppAttrGrpBean retrieveGroupCustomAppAttrGrp(long id)
            throws DataAccessException {
        GroupCustomAppAttrGrpBean bean = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            String query = "from GroupCustomAppAttrGrpBean c where c.id = :id";
            bean = (GroupCustomAppAttrGrpBean) session.createQuery(query)
                    .setLong("id", id).setMaxResults(1).uniqueResult();
            session.close();
        } catch (Exception e) {
            String excpmessage = "Data retrieval Failed in GroupCustomAppAttrGrpBean.retrieveGroupCustomAppAttrGrp(long id)";
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        } finally {
            MultHibUtil.closeSession(session);
        }
        return bean;
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    public static GroupCustomAppAttrGrpDAO getInstance() {
        return new GroupCustomAppAttrGrpDAO();
    }
    // ----------------------------------------------------------- Inner Classes
}
