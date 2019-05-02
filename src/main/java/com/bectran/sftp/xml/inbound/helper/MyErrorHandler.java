/**
 * 
 */
package com.bectran.sftp.xml.inbound.helper;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author LOUIS IFEGUNI
 * @date Sep 30, 2013 : 8:48:59 PM
 */
public class MyErrorHandler implements ErrorHandler {
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("\nWARNING");
        exception.printStackTrace();
    }

    public void error(SAXParseException exception) throws SAXException {
        System.out.println("\nERROR");
        exception.printStackTrace();
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("\nFATAL ERROR");
        exception.printStackTrace();
    }
}
