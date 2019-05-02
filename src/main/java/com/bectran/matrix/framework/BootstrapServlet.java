package com.bectran.matrix.framework;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bectran.b2b.constants.DbConstants;
import com.bectran.matrix.utils.MultHibUtil;



/**
 * @version         1.0
 * @author
 */
public class BootstrapServlet extends HttpServlet {
	
	/**
	 * default serial UID
	 */
	private static final long serialVersionUID = 1L;		
    /**
    * @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    }

    /**
    * @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    }

    /**
    * @see javax.servlet.GenericServlet#java.lang.String ()
    */
    public String getServletInfo() {
        return super.getServletInfo();
    }

    /**
    * @see javax.servlet.GenericServlet#void ()
    */
    public void init() throws ServletException {
        super.init();

        //obtain and store webcontent real path in the properties file
        String webcontentPath = this.getServletContext().getRealPath("/");
        int lenthOfPath = webcontentPath.length();
        String lastChar = webcontentPath.charAt(lenthOfPath - 1) + "";
        String desiredLastChar = File.separatorChar + "";

        //logic addresses the different processing of getRealPath on different platforms
        if (lastChar.trim().equals(desiredLastChar.trim())) {
            //
            AppConfig.addSystemProperty(AppConfig.WEB_CONTENT_FILE_PATH, webcontentPath);
            //System.out.println("..webcontentPath..: "+webcontentPath);
        } else {
            // S
            AppConfig.addSystemProperty(AppConfig.WEB_CONTENT_FILE_PATH,
                webcontentPath + File.separatorChar + "");
        }

        try {
            //initialize log4j logging
           AppLogger.initializeLog4J(AppConfig.getSystemProperty(AppConfig.WEB_CONTENT_FILE_PATH));


      
            //INITIALIZE HIBERNATE
           MultHibUtil.currentSession(DbConstants.CROL_DB);

            //
            System.err.println("...........BOOTSTRAP FINISHED SUCCESSFULLY................");
            AppLogger.log(AppLogger.INFO, "...BOOTSTRAP FINISHED SUCCESSFULLY.......");

            //
        } catch (Exception e) {
            //log error and  stop application startup if error occurs
            e.printStackTrace();
            AppLogger.log(AppLogger.FATAL, "...........APPLICATION FAILED AT BOOTSTRAP...........",   e);
        }

    }  
}
