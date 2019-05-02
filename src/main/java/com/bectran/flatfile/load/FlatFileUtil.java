package com.bectran.flatfile.load;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bectran.b2b.constants.FlatFileUpdateConstant;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.exception.ResourceLoadException;

/**
 * @author LOUIS IFEGUNI
 * @date Jul 26, 2012 : 9:49:06 AM
 */
public class FlatFileUtil {
    public static final int CUS_DATA_FLAG = 1;
    // public static final int CUS_BASIC_DATA_FLAG=1;
    public static final int CREDIT_DATA_FLAG = 2;
    public static final int ACCOUNT_OFFICER_DATA_FLAG = 3;
    //
    private File dir = null;
    private String[] children = null;
    FilenameFilter filter_cus_data = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.startsWith(
                    FlatFileUpdateConstant.CUSTOMER_DATA_FILE_NAME_PREFIX);
        }
    };

    public String[] namesOfFilesToProcess(String supplierTnNumber,
                                          int fileTypeFlag)
            throws ResourceLoadException {
        String directoryPath = getBaseFilePath(supplierTnNumber);
        // System.out.println("directoryPath----->:"+directoryPath);
        dir = new File(directoryPath);
        //
        children = dir.list(filter_cus_data);
        // if(fileTypeFlag==CUS_BASIC_DATA_FLAG){
        // children = dir.list(filter_cus_basic_data);
        // } else if(fileTypeFlag==CREDIT_DATA_FLAG){
        // children = dir.list(filter_credit_data);
        // } else if(fileTypeFlag==ACCOUNT_OFFICER_DATA_FLAG){
        // children = dir.list(filter_account_officer_data);
        // }
        //
        return children.clone();
    }

    public String getFilePathNameToProcess(String supplierTnNumber,
                                           String fileName)
            throws ResourceLoadException {
        String directoryPath = getBaseFilePath(supplierTnNumber);
        //
        return directoryPath + fileName;
    }

    public void renameAndMoveProcessedFile(String supplierTnNumber,
                                           String fileName)
            throws ResourceLoadException {
        // File (or directory) with old name
        String oldFilePath = getFilePathNameToProcess(supplierTnNumber,
                fileName);
        File oldfile = new File(oldFilePath);
        // File (or directory) with new name
        String newFilePath = getFilePathNameForProcessedData(supplierTnNumber,
                fileName);
        File newfile = new File(newFilePath);
        // Rename file (or directory)
        boolean success = oldfile.renameTo(newfile);
        if (!success) {
            // File was not successfully renamed
            System.out.println("--NOT RENAMED-- ");
        }
    }

    private String getBaseFilePath(String supplierTnNumber)
            throws ResourceLoadException {
        StringBuffer bf = new StringBuffer();
        bf.append(AppConfig.getValue(AppConfig.DATA_FILE_PATH_BASE).trim());
        // bf.append(supplierTnNumber.trim()+File.separatorChar);
        // bf.append(FlatFileUpdateConstant.WIP_FOLDER+File.separatorChar);
        bf.append(supplierTnNumber.trim() + "f/");
        bf.append(FlatFileUpdateConstant.WIP_FOLDER + "/");
        //
        String directoryPath = bf.toString();
        //
        return directoryPath;
    }

    private String getFilePathNameForProcessedData(String supplierTnNumber,
                                                   String fileName)
            throws ResourceLoadException {
        String directoryPath = getBaseFilePathProcessedData(supplierTnNumber);
        //
        return directoryPath + "PROCESSED_" + timeStampLabel() + "_" + fileName;
    }

    private String getBaseFilePathProcessedData(String supplierTnNumber)
            throws ResourceLoadException {
        //
        StringBuffer bf = new StringBuffer();
        bf.append(AppConfig.getValue(AppConfig.DATA_FILE_PATH_BASE).trim());
        //
        // bf.append(supplierTnNumber.trim()+File.separatorChar);
        // bf.append(FlatFileUpdateConstant.PROCESSED_FOLDER+File.separatorChar);
        //
        bf.append(supplierTnNumber.trim() + "f/");
        bf.append(FlatFileUpdateConstant.PROCESSED_FOLDER + "/");
        //
        String directoryPath = bf.toString();
        //
        return directoryPath;
    }

    public String timeStampLabel() {
        //
        SimpleDateFormat formatter;
        String pattern = "yyyyMMddHHmmss";
        formatter = new SimpleDateFormat(pattern);
        Date date = new Date();
        return formatter.format(date);
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
