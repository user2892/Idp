package com.bectran.flatfile.load;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bectran.b2b.constants.FlatFileUpdateConstant;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.matrix.utils.MatrixPasswordUtil;

/**
 * @author LOUIS IFEGUNI
 * @date Jul 26, 2012 : 9:49:06 AM
 */
public class FlatFileUtilXml {
    //
    public static final String NAMEPREFIX_CREDIT_DECI = "cred_deci";
    public static final String NAMEPREFIX_CREDIT_DECI_COND = "condensed_cred_deci";
    public static final String NAMEPREFIX_CREDIT_DECI_CUST_DECI = "cust_cred_deci";
    
    public static final String JSON_NAMEPREFIX_CREDIT_DECI_CUST_DECI = "json_cust_cred_deci";
    public static final String JSON_NAMEPREFIX_CUSTOMER = "json_cust_setup";
    //
    public static final String NAMEPREFIX_CUS_SETUP = "cus_xml_setup";
    //
    // public static final String
    // NAMEPREFIX_ACCOUNT_CREATION="acct_creat_from_ERP_xml_data";
    //
    public static final String TEMP_FOLDER = "tmpwork";
    //

    public String tempWorkFileName(String supplierTnNumber, String namePrefix)
            throws ResourceLoadException {
        StringBuffer bf = new StringBuffer();
        // bf.append(AppConfig.getValue(AppConfig.DATA_FILE_TEMPWORK_XML).trim());
        bf.append(getTempworkPath());
        bf.append(supplierTnNumber.trim() + "_" + namePrefix.trim() + ".");
        bf.append(MatrixPasswordUtil.generatePassword(5).trim() + ".");
        bf.append(timeStampLabel().trim() + ".xml");
        //
        return bf.toString();
    }

    public String fileNameInWip(String supplierTnNumber, String namePrefix,
                                String inbOrOutbFolder)
            throws ResourceLoadException {
        StringBuffer bf = new StringBuffer();
        bf.append(getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER, inbOrOutbFolder));
        bf.append(namePrefix.trim() + "_");
        bf.append(timeStampLabel().trim() + ".xml");
        //
        return bf.toString();
    }

    public String fileNameInProcessedFolder(String supplierTnNumber,
                                            String fileName,
                                            String inbOrOutbFolder)
            throws ResourceLoadException {
        StringBuffer bf = new StringBuffer();
        bf.append(getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.PROCESSED_FOLDER, inbOrOutbFolder));
        bf.append("PROCESSED_" + timeStampLabel().trim() + "_" + fileName);
        //
        return bf.toString();
    }

    public String fileNameInErrorFolder(String supplierTnNumber,
                                        String fileName, String inbOrOutbFolder)
            throws ResourceLoadException {
        StringBuffer bf = new StringBuffer();
        bf.append(getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.ERROR_FOLDER, inbOrOutbFolder));
        bf.append("ERROR_" + timeStampLabel().trim() + "_" + fileName);
        //
        // System.out.println("bf.toString()----->:"+bf.toString());
        return bf.toString();
    }

    public void renameAndMoveProcessedFile(File oldfile, File newfile)
            throws ResourceLoadException {
        // Rename file (or directory)
        boolean success = oldfile.renameTo(newfile);
        if (!success) {
            // File was not successfully renamed
            System.out.println("--NOT RENAMED-- ");
        }
    }

    private String getFilePath(String supplierTnNumber, String folder,
                               String inbOrOutbFolder)
            throws ResourceLoadException {
        StringBuffer bf = new StringBuffer();
        bf.append(AppConfig.getValue(AppConfig.DATA_FILE_PATH_BASE).trim());
        // bf.append(supplierTnNumber.trim()+"xml/inb/");
        bf.append(supplierTnNumber.trim() + "xml/" + inbOrOutbFolder + "/");
        bf.append(folder + "/");
        //
        String directoryPath = bf.toString();
        //
        return directoryPath.trim();
    }

    public String timeStampLabel() {
        //
        SimpleDateFormat formatter;
        String pattern = "yyyyMMddHHmmss";
        formatter = new SimpleDateFormat(pattern);
        Date date = new Date();
        return formatter.format(date);
    }
    //
    private File dir = null;
    private String[] children = null;
    FilenameFilter filter_cus_full_data = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(
                    FlatFileUpdateConstant.CUSTOMER_FULL_XMLDATA_FILE_NAME_PREFIX);
        }
    };
    FilenameFilter filter_cus_basic_info = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(
                    FlatFileUpdateConstant.CUSTOMER_BASIC_INFO_XMLDATA_FILE_NAME_PREFIX);
        }
    };
    FilenameFilter filter_account_creation_notif = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(
                    FlatFileUpdateConstant.ACCOUNT_CREATION_NOTIFICATION_FILE_NAME_PREFIX);
        }
    };
    FilenameFilter filter_cus_credit_info = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(
                    FlatFileUpdateConstant.CUSTOMER_CREDIT_INFO_XMLDATA_FILE_NAME_PREFIX);
        }
    };
    FilenameFilter filter_cus_account_officer = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(
                    FlatFileUpdateConstant.CUSTOMER_ACCOUNT_OFFICER_XMLDATA_FILE_NAME_PREFIX);
        }
    };
    FilenameFilter filter_cus_contact = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(
                    FlatFileUpdateConstant.CUSTOMER_CONTACT_XMLDATA_FILE_NAME_PREFIX);
        }
    };
    FilenameFilter filter_cus_portfolio = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(
                    FlatFileUpdateConstant.CUSTOMER_PORTFOLIO_XMLDATA_FILE_NAME_PREFIX);
        }
    };

    // ========================================\\======================================//==========================================\\======================================//
    public String[] namesOfOutbFilesToProcess_FullOutbound(String supplierTnNumber)
            throws ResourceLoadException {
        String directoryPath = getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER,
                FlatFileUpdateConstant.OUTBOUND_FOLDER);
        // System.out.println("directoryPath----->:"+directoryPath);
        dir = new File(directoryPath);
        //
        children = dir.list(filter_cus_full_data);
        //
        return children.clone();
    }

    public String[] namesOfOutbFilesToProcess_BasicInfo(String supplierTnNumber)
            throws ResourceLoadException {
        String directoryPath = getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER,
                FlatFileUpdateConstant.OUTBOUND_FOLDER);
        dir = new File(directoryPath);
        //
        children = dir.list(filter_cus_basic_info);
        //
        return children.clone();
    }

    public String[] namesOfOutbFilesToProcess_CreditInfo(String supplierTnNumber)
            throws ResourceLoadException {
        String directoryPath = getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER,
                FlatFileUpdateConstant.OUTBOUND_FOLDER);
        dir = new File(directoryPath);
        //
        children = dir.list(filter_cus_credit_info);
        //
        return children.clone();
    }

    public String[] namesOfOutbFilesToProcess_AccountOfficer(String supplierTnNumber)
            throws ResourceLoadException {
        String directoryPath = getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER,
                FlatFileUpdateConstant.OUTBOUND_FOLDER);
        dir = new File(directoryPath);
        //
        children = dir.list(filter_cus_account_officer);
        //
        return children.clone();
    }

    public String[] namesOfOutbFilesToProcess_Portfolio(String supplierTnNumber)
            throws ResourceLoadException {
        String directoryPath = getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER,
                FlatFileUpdateConstant.OUTBOUND_FOLDER);
        dir = new File(directoryPath);
        //
        children = dir.list(filter_cus_portfolio);
        //
        return children.clone();
    }

    public String[] namesOfOutbFilesToProcess_CustomerContactInfo(String supplierTnNumber)
            throws ResourceLoadException {
        String directoryPath = getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER,
                FlatFileUpdateConstant.OUTBOUND_FOLDER);
        dir = new File(directoryPath);
        //
        children = dir.list(filter_cus_contact);
        //
        return children.clone();
    }

    public String[] namesOfOutbFilesToProcessAccountCreationNotif(String supplierTnNumber)
            throws ResourceLoadException {
        String directoryPath = getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER,
                FlatFileUpdateConstant.OUTBOUND_FOLDER);
        System.out.println("directoryPath----->:" + directoryPath);
        dir = new File(directoryPath);
        //
        children = dir.list(filter_account_creation_notif);
        //
        return children.clone();
    }

    public String getFilePathNameToProcess(String supplierTnNumber,
                                           String fileName)
            throws ResourceLoadException {
        String directoryPath = getFilePath(supplierTnNumber,
                FlatFileUpdateConstant.WIP_FOLDER,
                FlatFileUpdateConstant.OUTBOUND_FOLDER);
        //
        return directoryPath + fileName;
    }

    public static String getTempworkPath() throws ResourceLoadException {
        return AppConfig.getWebContentPath().trim() + TEMP_FOLDER
                + File.separatorChar;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // new FlatFileUtil().namesOfFilesToProcess("");
        // new FlatFileUtil().renameProcessedFile("");
        // System.out.println("filename : "+timeStampLabel());
        // new FlatFileUtil().renameProcessedFile();
    }
}
