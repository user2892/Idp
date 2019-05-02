package com.bectran.matrix.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Used to log information during the application flow for tracing, debugging
 * and error log purposes.
 *
 * @author IFEGUNIL
 */
public final class AppLogger {
    /**
     * LOG4J LOG LEVELS
     */
    public static final String DEBUG = "debug";
    public static final String TRACE = "trace";
    public static final String WARN = "warn";
    public static final String INFO = "info";
    public static final String ERROR = "error";
    public static final String FATAL = "fatal";
    /**
     * Logger instance.
     */
    private static Logger matrixLogger = Logger.getRootLogger();

    private AppLogger() {
    }

    /**
     * Logs the message according to the specified logging level.
     * 
     * @param logLevel_
     * @param message_
     */
    public static void log(final String logLevel_, final String message_) {
        //
        if (logLevel_.equals(DEBUG)) {
            matrixLogger.debug(message_);
        }
        else if (logLevel_.equals(INFO)) {
            matrixLogger.info(message_);
        }
        else if (logLevel_.equals(WARN)) {
            matrixLogger.warn(message_);
        }
        else if (logLevel_.equals(ERROR)) {
            matrixLogger.error(message_);
        }
        else if (logLevel_.equals(FATAL)) {
            matrixLogger.fatal(message_);
        }
        else {
            matrixLogger.debug(message_);
        }
    }

    /**
     * Logs the message according to the specified logging level.
     * 
     * @param logLevel_
     * @param message_
     * @param exception_
     */
    public static void log(final String logLevel_, final String message_,
                           final Throwable exception_) {
        //
        if (logLevel_.equals(DEBUG)) {
            matrixLogger.debug(message_, exception_);
        }
        else if (logLevel_.equals(INFO)) {
            matrixLogger.info(message_, exception_);
        }
        else if (logLevel_.equals(WARN)) {
            matrixLogger.warn(message_, exception_);
        }
        else if (logLevel_.equals(ERROR)) {
            matrixLogger.error(message_, exception_);
        }
        else if (logLevel_.equals(FATAL)) {
            matrixLogger.fatal(message_, exception_);
        }
        else {
            matrixLogger.debug(message_, exception_);
        }
    }

    /**
     * @param log4jPropertiesfilepath
     * @return
     * @throws ResourceLoadException
     * @throws IOException 
     */
    public static Properties updateLog4jPropertiesFile(String log4jPropertiesfilepath)
            throws ResourceLoadException, IOException {
        Properties log4jProperties = new Properties();
        FileInputStream in=null;
        try {
            // get log4j properties
            in = new FileInputStream(log4jPropertiesfilepath);
            log4jProperties.load(in);
            /*
             * compute log file location as the second level of the file
             * directory where CreditMatrix is installed ie if installed path is
             * "C:/dev/workspace/ws/serviceweb/WebContent/" - windows or
             * /usr/local/... or linux logfile directory =
             * C:/dev/LogfileLocation/ --OR-- /usr/LogfileLocation/
             */
            int i = log4jPropertiesfilepath.indexOf(File.separatorChar);
            int j = log4jPropertiesfilepath.indexOf(File.separatorChar, i + 1);
            String logfileLoc = log4jPropertiesfilepath.substring(0, j + 1)
                    + "app_logs" + File.separatorChar + "bectran_batch"
                    + File.separatorChar;
            // create directory if not exist
            File directory = new File(logfileLoc);
            boolean status=false;
            if (!directory.isDirectory()) {
                status = directory.mkdirs();
            }
            
            if(!status){
                AppLogger.log(INFO, "directory not created"); 
            }
            // add logfile name with Timestamp
            String timeStamp = logfileTimeStamp(new Date());
            String logfilename = "bectran_batch_" + timeStamp.trim() + "_log"
                    + ".log";
            log4jProperties.setProperty("log4j.appender.myAppender.File",
                    logfileLoc.trim() + logfilename.trim());
            
            //
        }
        catch (Exception e) {
            // no point to continue - exit deployment
            e.printStackTrace();
            AppLogger.log(AppLogger.FATAL, "LOGGER COULD NOT BE INITIALIZED..",
                    e);
            //
            throw new ResourceLoadException();
        }
        finally{
            if(in!=null){
                in.close();
            }
        }
        return log4jProperties;
    }

    /**
     * derives a time stamp string for the log file identification
     * 
     * @param date
     * @return
     */
    private static String logfileTimeStamp(Date date) {
        //
        SimpleDateFormat formatter;
        String pattern = "yyyyMMdd_Hmmss";
        formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * @param webcontentPath
     * @throws Exception
     */
    public static void initializeLog4J(String webcontentPath) throws Exception {
        // String relativePath = "WEB-INF" + File.separatorChar + "classes" +
        // File.separatorChar + AppConfig.LOG4J_PROPERTY_FILE_NAME;
        // String filePath = webcontentPath + relativePath;
        // Properties updatedLog4jProperties =
        // updateLog4jPropertiesFile(filePath);
        // PropertyConfigurator.configure(updatedLog4jProperties);
        String filePath = AppConfig.configFileLocation()
                + AppConfig.LOG4J_PROPERTY_FILE_NAME;
        Properties updatedLog4jProperties = updateLog4jPropertiesFile(filePath);
        PropertyConfigurator.configure(updatedLog4jProperties);
    }

    public static void main(String[] args) throws Exception {
        // System.out.println(logfileTimeStamp(new Date()));
        System.out.println(AppConfig.getValue("admin.log4j.support.email"));
    }
}
