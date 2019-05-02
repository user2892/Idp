package com.bectran.matrix.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

import com.bectran.b2b.constants.XmlDocFileConst;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.exception.ResourceLoadException;

/**
 * General we service utility
 *
 * @author Louis Ifeguni
 * @Creation date : Mar 27, 2005
 */
public class XmlDocUtil {
    /**
     * build a string from an XML document
     * 
     * @param doc
     * @return
     */
    public static String xmlDocToString(Document doc) {
        // build a string from an XML document
        XMLOutputter outputter = new XMLOutputter();
        String xml = null;
        xml = outputter.outputString(doc);
        return xml;
    }

    /**
     * converts string to xml document
     * 
     * @param input
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Document stringToXmlDoc(String input)
            throws ResourceLoadException {
        //
        SAXBuilder builder = new SAXBuilder();
        Document document = null;
        InputSource in = new InputSource(
                (InputStream) new ByteArrayInputStream(input.getBytes(Charset.defaultCharset())));
        try {
            document = builder.build(in);
        }
        catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new ResourceLoadException();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new ResourceLoadException();
        }
        //
        return document;
    }

    /**
     * READS AND XML DOCUMENT given the file location
     * 
     * @param fileLocation
     * @return
     * @throws ResourceLoadException
     */
    public static Document readDocument(String fileNameInXmlFolder)
            throws ResourceLoadException {
        SAXBuilder builder = new SAXBuilder();
        Document document;
        try {
            String fileLocation = XmlDocFileConst.getXmlDocFilePathPrefix()
                    + fileNameInXmlFolder;
            document = builder.build(new File(fileLocation));
            return document;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ResourceLoadException();
        }
    }

    /**
     * READS AND XML DOCUMENT given the file location
     * 
     * @param fileLocation
     * @return
     * @throws ResourceLoadException
     */
    public static Document readDocumentWithPath(String relativeFilePath)
            throws ResourceLoadException {
        SAXBuilder builder = new SAXBuilder();
        Document document;
        try {
            String fileLocation = AppConfig.getWebContentPath()
                    + relativeFilePath;
            document = builder.build(new File(fileLocation));
            return document;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ResourceLoadException();
        }
    }

    public static void main(String[] args) {
    }
}
