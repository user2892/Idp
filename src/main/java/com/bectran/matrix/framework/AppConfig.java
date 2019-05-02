package com.bectran.matrix.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import com.bectran.matrix.framework.exception.ResourceLoadException;

/**
 * @Creation date : April 28, 2005
 * @author Louis Ifeguni
 */
public final class AppConfig {
    public static final String RESOURCE_MATRIX = "matrix";
    private static final String CONFIG_FILE_LOCATION = "config.file.location";
    public static final String DATA_FILE_PATH_BASE = "cus.data.file.base.path";
    public static final String RACKCLOUD_CONTAINER_NAME_PREFIX = "rackcloud.bectran.env.prefix";
    // public static final String DATA_FILE_PATH_BASE_XML =
    // "cus.data.file.base.path.xml";
    // public static final String DATA_FILE_TEMPWORK_XML =
    // "cus.data.file.tmpwork.path.xml";
    /**
     * MAIL HOST
     */
    public static final String MAIL_HOST = "mail.host";
    /**
     * AUTO - EMAIL ADDRESS
     */
    public static final String AUTO_EMAIL_ADDRESS = "auto.email.address";
    public static final String SUPPORT_EMAIL_ADDRESS = "support.email.address";
    public static final String AUTO_EMAIL_NAME = "auto.email.name";
    public static final String EXTPACK_EMAIL_ADDRESS = "extpack.email.address";
    public static final String EXTPACK_EMAIL_NAME = "extpack.email.name";
    /**
     * WEB CONTENT RESOURCE LOCATION ROOT PATH -- ..../WebContent/
     */
    public static final String WEB_CONTENT_FILE_PATH = "idp.bectran.webcontent.file.path";
    /**
     * LOG FILE LOCATION
     */
    public static final String LOG_FILE_LOCATION = "log.file.loc";
    /**
     * LOG4J PROPERTY FILE NAME
     */
    public static final String LOG4J_PROPERTY_FILE_NAME = "log4j.properties";
    // Active MQ
    public static final String ACTIVEMQ_BROKER_URL = "activeMQ.brokerURL";
    public static final String ACTIVEMQ_USERNAME = "activeMQ.username";
    public static final String ACTIVEMQ_PASSWORD = "activeMQ.password";

    /**
     * READS THE RESOURCE BUNDLE AND RETURNS THE VALUE OF THE SPECIFIED PROPERTY
     *
     * @param resourceBundleName
     * @param property
     * @return
     */
    public static String getValue(final String resourceBundleName,
                                  final String property)
            throws ResourceLoadException {
        //
        String propertyValue = "";
        try {
            ResourceBundle resource = ResourceBundle
                    .getBundle(resourceBundleName.trim());
            //
            propertyValue = resource.getString(property.trim());
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger
                    .log(AppLogger.ERROR,
                            "--Property Key does not exist in matrix property file ",
                            e);
            throw new ResourceLoadException();
        }
        return propertyValue.trim();
    }

    /**
     * GETS A PROPERTY VALUE FROM THE DEFAULT RESOURCE BUNDLE - CRISK
     *
     * @param property
     * @return
     */
    public static String getValue(final String property)
            throws ResourceLoadException {
        //
        String propertyValue = "";
        try {
            // ResourceBundle resource =
            // ResourceBundle.getBundle(RESOURCE_MATRIX);
            //
            String configFileLoc = configFileLocation();
            propertyValue = getValueFromAppConfig(configFileLoc, property);
            //
            // propertyValue = resource.getString(property.trim()); OLD
            //
        }
        catch (Exception e) {
            e.printStackTrace(); // to be logged and removed
            AppLogger
                    .log(AppLogger.ERROR,
                            "--Property Key does not exist in matrix property file ",
                            e);
            throw new ResourceLoadException();
        }
        return propertyValue.trim();
    }

    public static String configFileLocation() throws ResourceLoadException {
        String configFileLoc = null;
        try {
            ResourceBundle resource = ResourceBundle.getBundle(RESOURCE_MATRIX);
            configFileLoc = resource.getString(CONFIG_FILE_LOCATION);
        }
        catch (Exception e) {
            e.printStackTrace(); // to be logged and removed
            AppLogger
                    .log(AppLogger.ERROR,
                            "--Property Key does not exist in matrix property file ",
                            e);
            throw new ResourceLoadException();
        }
        return configFileLoc;
    }

    private static String getValueFromAppConfig(final String propertyFileLocation,
                                                String value)
            throws ResourceLoadException, IOException {
        //
        String propertyValue = "";
        FileInputStream fis =null;
        try {
            Properties prop = new Properties();
            // FileInputStream fis = new
            // FileInputStream("yourPropertiesFile.properties");
            fis = new FileInputStream(propertyFileLocation
                    + "idp.properties");
            prop.load(fis);
            // You can do something here like getting the value of a key.
            // Example
            propertyValue = prop.getProperty(value);
            
            //
        }
        catch (Exception e) {
            e.printStackTrace(); // to be logged and removed
            AppLogger
                    .log(AppLogger.ERROR,
                            "--Property Key does not exist in matrix property file ",
                            e);
            throw new ResourceLoadException();
        }
        finally{
            if(fis!=null){
                fis.close();
            }
        }
        return propertyValue.trim();
    }

    /**
     * RETRIVES THE SPECIFIED RESOURCE BUNDLE
     *
     * @param resourceBundleName
     * @return
     */
    public static ResourceBundle getResource(final String resourceBundleName)
            throws ResourceLoadException {
        ResourceBundle resource = null;
        try {
            resource = ResourceBundle.getBundle(resourceBundleName.trim());
            //
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger
                    .log(AppLogger.ERROR, "--Resource bundle is not found ", e);
            throw new ResourceLoadException();
        }
        //
        return resource;
    }

    /**
     * GETS A SPECIFIED SYSTEM PROPERTY VALUE
     *
     * @param propertyName
     * @return
     */
    public static String getSystemProperty(String propertyName) {
        String propertyValue = "";
        propertyValue = System.getProperty(propertyName);
        //
        return propertyValue.trim();
    }

    /**
     * ADDS A SPECIFIED SYSTEM PROPERTY VALUE
     *
     * @param propertyKey
     * @param propertyValue
     */
    public static void addSystemProperty(String propertyKey,
                                         String propertyValue) {
        System.getProperties().put(propertyKey, propertyValue);
    }

    public static String getWebContentPath() {
        // return
        // return "D:/SVNWorkspace/idp/src/main/resources/";
        return AppConfig.getSystemProperty(WEB_CONTENT_FILE_PATH);
    }
}
