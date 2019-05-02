/**
 * 
 */
package com.bectran.b2b.customer.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.customer.beans.CusCurrentTermsBean;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 *
 * @DATE Aug 18, 2011 : 9:03:31 AM
 */
public class CusCurrentTermsDAO {


	public static void save(CusCurrentTermsBean bean)
			throws DataAccessException {
		
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

		} catch (Exception e) {
			String excpmessage = "Data update Failed in CusCurrentTermsDAO.save(CusCurrentTermsBean bean)";
			e.printStackTrace();
			AppLogger.log(AppLogger.ERROR, excpmessage, e);
			throw new DataAccessException(excpmessage);
		}
		finally {
			MultHibUtil.closeSession(session);
		}
		
	}

	
	public  CusCurrentTermsBean getCurrentTerm(long id) throws DataAccessException {
		//
		CusCurrentTermsBean supplier = null;
		Session session = null;
        try {
           session = MultHibUtil.currentSession(DbConstants.CROL_DB);
//			Transaction tx = session.getTransaction();
//			tx.begin();
			//
			String query = " from CusCurrentTermsBean c where  c.id = :id ";
			supplier = (CusCurrentTermsBean) session.createQuery(query).setLong("id", id).setMaxResults(1).uniqueResult();

			//    
//			tx.commit();
			session.close();
			//
			//
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.log(AppLogger.ERROR, "Error executing query in CusCurrentTermsDAO.getCurrentTerm(long id)", e);
			throw new DataAccessException("Error executing query in CusCurrentTermsDAO.getCurrentTerm(long id)");
		}

		finally {
			MultHibUtil.closeSession(session);
		}
		return supplier;
	}	


	public static void main(String[] args) throws Exception {
		
		System.out.println("----start-------");
		new CusCurrentTermsDAO(). getCurrentTerm( 1);
		System.out.println("----end-------");
	}
}

