package com.bectran.sftp.xml.inbound.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;

import com.bectran.b2b.constants.BectranJMSMsgConstants;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.SupplierUserBean;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.email.EmailHelper;
import com.bectran.matrix.framework.email.EmailMsgBean;
import com.bectran.matrix.framework.email.JMSEmailHelper;
import com.bectran.matrix.framework.exception.CommunicationFailureException;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.utils.FormatUtility;

/**
 * @author LOUIS IFEGUNI
 * @date Nov 26, 2013 : 4:40:48 PM
 */
public class InvalidDataReportHelper {
    //
    public static final String INVALID_DATA_MSG_HTML = "invalidDataMsg.html";

    public void sendReport(List<String> invalidFileList,
                           GroupAccountBean groupBean)
            throws DataAccessException, ResourceLoadException,
            CommunicationFailureException, JMSException {
        // GroupAccountBean groupBean =
        // GroupAccountDAO.getPrimaryGroup(supplierId.longValue());
        SupplierUserBean admin = groupBean.getGroupContact();
        //
        StringBuffer bf = new StringBuffer();
        for (String file : invalidFileList) {
            bf.append("<li>" + file + "</li>");
        }
        EmailMsgBean emailBean = prepUserMail(admin, bf.toString());
        //
        // EmailMsgDAO.storeMessage(emailBean);
        JMSEmailHelper.sendMsg(BectranJMSMsgConstants.ACCOUNT_REVIEW_QUEUE,
                emailBean);
    }

    private EmailMsgBean prepUserMail(SupplierUserBean user, String listOfFiles)
            throws ResourceLoadException, CommunicationFailureException {
        //
        Map<String, String> values = new HashMap<String, String>();
        // name
        values.put("@USNA", user.getUserName().trim());
        //
        values.put("@LISTOFFILES", listOfFiles);
        //
        values.put("@DATETIME", FormatUtility.formatDate(new Date(),
                FormatUtility.DATE_FORMAT_LONG));
        //BEC-1705 : Start
        String toEmail = user.getEmail().trim();
        //BEC-1705 : End
        String title = "Data Load Failure Report";
        String fromEmail = AppConfig.getValue(AppConfig.SUPPORT_EMAIL_ADDRESS);
        String senderName = AppConfig.getValue(AppConfig.SUPPORT_EMAIL_ADDRESS);
        //
        EmailMsgBean emailBean = EmailHelper.prepareEmailOne(toEmail, title,
                values, INVALID_DATA_MSG_HTML, fromEmail, senderName,
                "INVALID-DATA-MSG-HTML");
        //
        return emailBean;
    }
}
