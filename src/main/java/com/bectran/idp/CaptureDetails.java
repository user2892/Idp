/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.idp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.bectran.matrix.framework.AppConfig;

/**
 * @author Santhosh
 * @date 27-May-2016 11:18:28 pm
 */
public class CaptureDetails extends HttpServlet {
    private static final long serialVersionUID = 3437683557945010256L;
    public static final String IDP_AUTH_URL = "idp.auth.servlet.url";
    public static final String IDP_AUTH_USER_ID = "idp.auth.userid";
    public static final String IDP_AUTH_PWD = "idp.auth.pwd";

    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Constructor of the object.
     */
    public CaptureDetails() {
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
        System.out.println("Config path:"+AppConfig.getWebContentPath());
        // Receiving response - START
        sendRequest(request);
       
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("get........");
    }

    //
    public void sendRequest(HttpServletRequest request) {
        CloseableHttpClient client=null;
        try {
            client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(AppConfig.getValue(IDP_AUTH_URL));
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            
            params.add(new BasicNameValuePair("username",AppConfig.getValue(IDP_AUTH_USER_ID)));
            params.add(new BasicNameValuePair("password", AppConfig.getValue(IDP_AUTH_PWD)));
            
            //Setting Request parameters
            for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
                String name = e.nextElement();
                String value = request.getParameter(name);
                params.add(new BasicNameValuePair(name, value));
            }
           
            //
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            String repsonseData = readResponse(response);
            System.out.println("\t Response data ### \t"
                    + URLDecoder.decode(repsonseData, "UTF-8"));
            
            if(response.getFirstHeader("decisionData")!=null && StringUtils.isNotBlank(response.getFirstHeader("decisionData").getValue())){
                System.out.println("\t Header data ###\t"
                        + URLDecoder.decode(response.getFirstHeader("decisionData").getValue(), "UTF-8"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param response
     * @return
     * @throws IOException 
     * @throws Exception
     */
    public String readResponse(HttpResponse response) throws IOException {
        StringBuilder responseData = new StringBuilder();
        InputStream inputStream =null;
        BufferedReader br=null;
        try {
            inputStream = response.getEntity().getContent();
            if (inputStream != null) {
                br = new BufferedReader(new InputStreamReader(
                        inputStream,Charset.defaultCharset()));
                String line = null;
                while ((line = br.readLine()) != null) {
                    responseData.append(line);
                }
            }
        }
        catch (UnsupportedOperationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(br!=null){
                br.close();
            }
            if(inputStream!=null){
                inputStream.close();
            }
        }
        return responseData.toString();
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
