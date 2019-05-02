/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.idp;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bectran.matrix.framework.AppConfig;

/**
 * @author Santhosh
 * @date 27-May-2016 11:18:28 pm
 */
public class CaptureDirectDetails extends HttpServlet {
    private static final long serialVersionUID = 3437683557945010256L;

    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Constructor of the object.
     */
    public CaptureDirectDetails() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    @Override
    public void destroy() {
        super.destroy();
    }

    // ---------------------------------------------------------- Public Methods
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Config path:"+AppConfig.getWebContentPath());
        // Receiving response - START
        readRequest(request);
       
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("get........");
    }

    //
    @SuppressWarnings("unchecked")
    public void readRequest(HttpServletRequest request) {
        try {
            //Here we will send the Customer and Decision Data as List<NameValuePair> parameters 
            for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
                String name = e.nextElement();
                String value = request.getParameter(name);
                System.out.println("Resonse Type: "+name+"  Data::"+value);
            }
           
            //
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException
     *             if an error occurs
     */
    @Override
    public void init() throws ServletException {
        // Put your code here
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
