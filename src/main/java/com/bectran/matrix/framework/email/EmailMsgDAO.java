package com.bectran.matrix.framework.email;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.crol.constants.CrolConstants;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.utils.MultHibUtil;

/**
 * @author LOUIS IFEGUNI
 * @Date Oct 28, 2006:11:15:22 PM
 */
public class EmailMsgDAO {
    public static void storeMessage(EmailMsgBean storeBean)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            session.save(storeBean);
            //
            //
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Data Insert Failed in EmailMsgDAO.storeMessage()", e);
            throw new DataAccessException(
                    "Data Insert Failed in EmailMsgDAO.storeMessage()");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static List getStoredMessages() throws DataAccessException {
        //
        List list = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            // Transaction tx = session.getTransaction();
            // tx.begin();
            //
            String query = " from EmailMsgBean";
            list = session.createQuery(query).list();
            //
            // tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Error executing query in EmailMsgDAO.getStoredMessages()",
                    e);
            throw new DataAccessException(
                    "Error executing query in EmailMsgDAO.getStoredMessages()");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
        return list;
    }

    public static void storeMsgInBatch(List emailList)
            throws DataAccessException {
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            int batchCount = 0; // save in batches of 20
            for (Iterator i = emailList.iterator(); i.hasNext();) {
                EmailMsgBean bean = (EmailMsgBean) i.next();
                session.save(bean);
                batchCount = batchCount + 1;
                if (batchCount % 20 == 0) { // 20, same as the JDBC batch size
                    // flush a batch of inserts and release memory:
                    session.flush();
                    session.clear();
                }
            }
            tx.commit();
            session.close();
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            String excpmessage = "Data Insert Failed in EmailMsgDAO.storeMsgInBatch()";
            AppLogger.log(AppLogger.ERROR, excpmessage, e);
            throw new DataAccessException(excpmessage);
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void processStoredMessages() throws DataAccessException {
        //
        List unsentMessages = null;
        Session session = null;
        try {
            session = MultHibUtil.currentSession(DbConstants.CROL_DB);
            Transaction tx = session.getTransaction();
            tx.begin();
            //
            // 1.first delete sent messages
            String deletequery = "delete from EmailMsgBean e where  e.sendStatus = :status ";
            session.createQuery(deletequery)
                    .setString("status", CrolConstants.STATUS_SUCCESS)
                    .executeUpdate();
            String query = " from EmailMsgBean e where e.emailResendProcess = :resproc and e.sendStatus = :status ";
            unsentMessages = session.createQuery(query)
                    .setString("status", CrolConstants.STATUS_FAILED)
                    .setString("resproc",
                            CrolConstants.EMAIL_RESEND_PROCESS_MODE_AUTO)
                    .list();
            // System.out.println("
            // unsentMessages.size--->"+unsentMessages.size());
            EmailMsgBean bean = null;
            for (Iterator i = unsentMessages.iterator(); i.hasNext();) {
                bean = (EmailMsgBean) i.next();
                // test trial count
                if (bean.getTrialCount() >= MatrixConstants.EMAIL_RESEND_MAX_COUNT) {
                    // re-send process now delegated to a manual effort -
                    // customer service
                    bean.setEmailResendProcess(
                            MatrixConstants.EMAIL_RESEND_PROCESS_MODE_MANUAL);
                    continue;
                }
                if (bean.getMessageType().trim()
                        .equals(MatrixConstants.MSG_TYPE_ONE)) {
                    //
                    bean.setToAddressArray(EmailMessageBuilder
                            .buildSingleAddressArray(bean.getToAddress()));
                }
                else if (bean.getMessageType().trim()
                        .equals(MatrixConstants.MSG_TYPE_MANY_COPY_ONE)) {
                    bean.setToAddressArray(
                            EmailHelper.buildAddressArrayFromStoredList(
                                    bean.getToAddressList()));
                    bean.setCopyAddressArray(EmailMessageBuilder
                            .buildSingleAddressArray(bean.getCopyAddress()));
                }
                else if (bean.getMessageType().trim()
                        .equals(MatrixConstants.MSG_TYPE_MANY)) {
                    bean.setToAddressArray(
                            EmailHelper.buildAddressArrayFromStoredList(
                                    bean.getToAddressList()));
                }
                else if (bean.getMessageType().trim()
                        .equals(MatrixConstants.MSG_TYPE_MANY_COPY_MANY)) {
                    bean.setToAddressArray(
                            EmailHelper.buildAddressArrayFromStoredList(
                                    bean.getToAddressList()));
                    bean.setCopyAddressArray(
                            EmailHelper.buildAddressArrayFromStoredList(
                                    bean.getCopyAddressList()));
                }
                try {
                    // send mail
                    MailSender.sendMail(bean);
                    bean.setSendStatus(MatrixConstants.STATUS_SUCCESS);
                }
                catch (Exception e) {
                    bean.setSendStatus(MatrixConstants.STATUS_FAILED);
                    bean.setTrialCount(bean.getTrialCount() + 1);
                }
            }
            //
            tx.commit();
            session.close();
            //
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR,
                    "Error executing query in EmailMsgDAO.processStoredMessages()",
                    e);
            throw new DataAccessException(
                    "Error executing query in EmailMsgDAO.processStoredMessages()");
        }
        finally {
            MultHibUtil.closeSession(session);
        }
    }

    public static void main(String[] args) throws DataAccessException {
        System.out.println(" start--->");
        // EmailMsgBean bean = new EmailMsgBean();
        // bean.setToAddress("lifeg@gmail.com");
        // storeMessage(bean);
        processStoredMessages();
        // getStoredMessages();
        System.out.println(" finish--->");
    }
}
