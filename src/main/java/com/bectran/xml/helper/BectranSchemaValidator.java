package com.bectran.xml.helper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.bectran.matrix.framework.AppLogger;

public class BectranSchemaValidator {
    // private static final String SCHEMA_FOLDER="schema";
    /**
     * @param args
     */
    public static void validate(File schemaFile,
                                ByteArrayInputStream xmlDocument) {
        try {
            // define the type of schema - we use W3C:
            String schemaLang = "http://www.w3.org/2001/XMLSchema";
            // get validation driver:
            SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
            // create schema by reading it from an XSD file:
            Schema schema = factory.newSchema(new StreamSource(schemaFile));
            Validator validator = schema.newValidator();
            // at last perform validation:
            validator.validate(new StreamSource(xmlDocument));
        }
        catch (SAXException ex) {
            ex.printStackTrace();
            // we are here if the document is not valid:
            // ... process validation error...
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean validate(File schemaFile, InputStream xmlDocument) {
        try {
            // define the type of schema - we use W3C:
            String schemaLang = "http://www.w3.org/2001/XMLSchema";
            // get validation driver:
            SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
            // create schema by reading it from an XSD file:
            Schema schema = factory.newSchema(new StreamSource(schemaFile));
            Validator validator = schema.newValidator();
            // at last perform validation:
            validator.validate(new StreamSource(xmlDocument));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            AppLogger.log(AppLogger.ERROR, "VALIDATION FAILED", ex);
            return false;
        }
        return true;
    }

    /**
     * @param args
     */
    public boolean validate(File schemaFile, String xmlDocument) {
        try {
            // define the type of schema - we use W3C:
            String schemaLang = "http://www.w3.org/2001/XMLSchema";
            // get validation driver:
            SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
            // create schema by reading it from an XSD file:
            Schema schema = factory.newSchema(new StreamSource(schemaFile));
            Validator validator = schema.newValidator();
            // at last perform validation:
            ByteArrayInputStream inStream = new ByteArrayInputStream(
                    xmlDocument.getBytes(Charset.defaultCharset()));
            validator.validate(new StreamSource(inStream));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            // validation failed
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    public static String getSchemaFilePath(String fileName) {
        // String filepath =
        // AppConfig.getSystemProperty(AppConfig.WEB_CONTENT_FILE_PATH)+SCHEMA_FOLDER+File.separatorChar;
        String filepath = "H:/dev1/wkspace/myeclipse9/batch-wkspace/b2bentintg/WebRoot/schema/";
        return filepath + fileName;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
