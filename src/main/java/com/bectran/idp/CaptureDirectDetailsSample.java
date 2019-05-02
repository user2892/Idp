/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.idp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Santhosh
 * @date 27-May-2016 11:18:28 pm
 */
public class CaptureDirectDetailsSample extends HttpServlet {
    private static final long serialVersionUID = 3437683557945010256L;

    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Constructor of the object.
     */
    public CaptureDirectDetailsSample() {
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
    /**
     * The doGet method of the servlet. <br>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        readRequest(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("get........");
    }

    //
    public void readRequest(HttpServletRequest request,
                            HttpServletResponse response) {
        try {
            // Here we will send the Customer/Decision Data as part of Post Body
            BufferedReader rd = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = "";
            StringBuffer respString = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                respString.append(line);
            }
            
            System.out.println("--------------------");
            //JSONObject jsonObj = new JSONObject(respString.toString());
            System.out.println("Response:::"+respString.toString());
            
        }
        catch (Exception e) {
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
