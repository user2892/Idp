package com.bectran.matrix.framework.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

import com.bectran.b2b.base.beans.TitleAndDeptBean;
import com.bectran.b2b.base.beans.UserBaseBean;
import com.bectran.b2b.crol.beans.CrolUserBean;
import com.bectran.b2b.supplier.beans.CompanyInfoBaseBean;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.CommunicationFailureException;
import com.bectran.matrix.framework.exception.DataAccessException;

/**
 * @author LOUIS IFEGUNI Created on Feb 13, 2005
 */
public class EmailMessageBuilder {
    /**
     * HTML E-MAIL MESSAGES FOLDER - this path must be changed if the physical
     * name of the folder is chaged or renamed
     */
    public static final String MAIL_MESSAGES_RELATIVE_PATH = "mailmessages";

    /**
     * @param file
     * @param values
     * @return
     * @throws IOException
     * @throws CommunicationFailureException
     */
    public static String reconstrcutMessageBody(String fileName, Map values)
            throws CommunicationFailureException {
        String messageString = null;
        try {
            // get absolute path of file
            File inputFile = new File(
                    getMailMessageFilePathPrefix() + fileName);
            
            InputStreamReader in = new InputStreamReader( new FileInputStream(inputFile),Charset.defaultCharset());
            BufferedReader reader = new BufferedReader(in);
            StringBuffer messageBuffer = new StringBuffer();
            String inputLine;
            //
            while ((inputLine = reader.readLine()) != null) {
                //
                messageBuffer.append(inputLine);
                messageBuffer.append("\n");
                // System.out.println(messageBuffer.toString());
            }
            in.close();
            reader.close();
            messageString = messageBuffer.toString();
            //
            for (Iterator i = values.entrySet().iterator(); i.hasNext();) {
                Map.Entry mapEntry = (Map.Entry) i.next();
                // System.out.println("====>"+mapEntry.getKey()+",
                // "+mapEntry.getValue());
                //
                messageString = messageString.replace(
                        mapEntry.getKey().toString(),
                        mapEntry.getValue().toString());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, "Email communication failed...", e);
            throw new CommunicationFailureException();
        }
        return messageString;
    }

    /**
     * @return
     */
    public static String getMailMessageFilePathPrefix() {
        //
        String filepath = AppConfig
                .getSystemProperty(AppConfig.WEB_CONTENT_FILE_PATH)
                + MAIL_MESSAGES_RELATIVE_PATH + File.separatorChar;
        // String filepath =
        // "H:/workspace/myeclipse10/eintg-wspace/b2bentintgbatch/WebRoot/mailmessages/";
        return filepath;
    }

    public static Address[] buildSingleAddressArray(String emailAddress)
            throws CommunicationFailureException {
        if (emailAddress == null || emailAddress.length() < 1) {
            // no users in the company---that is unusual
            throw new CommunicationFailureException();
        }
        Address[] addr = null;
        try {
            addr = new Address[1];
            addr[0] = new InternetAddress(emailAddress.trim());
        }
        catch (Exception e) {
            //
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, "Email communication failed...", e);
            throw new CommunicationFailureException();
        }
        return addr;
    }


    /**
     * USES USER BASE BEAN - OVERLOADED METHODS
     * 
     * @param bean
     * @param deptConstant
     * @param titleConstant
     * @return
     * @throws DataAccessException
     */
    public static String buildUserSignature(UserBaseBean bean,
                                            String deptConstant,
                                            String titleConstant)
            throws DataAccessException {
        //
        StringBuffer buffer = new StringBuffer();
        buffer.append(bean.getUserName());
        String title = new TitleAndDeptBean()
                .getTitleDescription(bean.getTitle(), titleConstant);
        String dept = new TitleAndDeptBean()
                .getDeptDescription(bean.getDepartment(), deptConstant);
        if (title != null && title.trim().length() > 1) {
            buffer.append("<BR>");
            buffer.append(title);
        }
        if (dept != null && dept.trim().length() > 1) {
            buffer.append("<BR>");
            buffer.append(dept);
        }
        buffer.append("<BR>");
        buffer.append(bean.getPhone());
        buffer.append("<BR>");
        buffer.append(bean.getEmail());
        //
        return buffer.toString();
    }

    /**
     * @param corpBean
     * @return
     */
    public static String buildNameAndAddress(CompanyInfoBaseBean corp) {
        //
        StringBuffer buffer = new StringBuffer();
        buffer.append(corp.getCorpName());
        if (corp.getAddressLineOne() != null
                && corp.getAddressLineOne().trim().length() > 1) {
            buffer.append("<BR>" + corp.getAddressLineOne());
        }
        if (corp.getAddressLineTwo() != null
                && corp.getAddressLineTwo().trim().length() > 1) {
            buffer.append("<BR>" + corp.getAddressLineTwo());
        }
        //
        if (corp.getCity() != null && corp.getCity().trim().length() > 1) {
            buffer.append("<BR>" + corp.getCity());
        }
        if (corp.getState() != null && corp.getState().trim().length() > 1) {
            buffer.append("<BR>" + corp.getState() + " " + corp.getZipCode());
        }
        //
        // buffer.append("<BR>" +
        // XmlDataCacheMgr.getCountryName(corp.getCountryId()));
        //
        return buffer.toString();
    }

    public static List cleanUpAddresses(List corpusers)
            throws DataAccessException, CommunicationFailureException {
        List result = new ArrayList();
        for (Iterator i = corpusers.iterator(); i.hasNext();) {
            CrolUserBean bean = (CrolUserBean) i.next();
            try {
                new InternetAddress(bean.getEmail().trim());
                result.add(bean);
            }
            catch (Exception e) {
                // skip bad e-mail
                //
                continue;
            }
        }
        return result;
    }
}
