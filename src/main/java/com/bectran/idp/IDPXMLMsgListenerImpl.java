/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.idp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.constants.WsErrorMessageConstants;
import com.bectran.idp.beans.IDPConstants;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.PassCodeHelper;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.framework.idp.IDPMsgBean;

/**
 * @author Santhosh
 * @date May 24, 2016 11:31:34 PM
 */
public class IDPXMLMsgListenerImpl implements MessageListener {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Queue queue;
    public static final String SSL_TRUSTSTORE_URL = "idp.ssl.trustStore";
    public static final String SSL_TRUSTSTORE_PWD = "idp.ssl.trustStorePassword";
    public static final String HTTPS_PROTOCOL = "idp.https.protocols";

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>BaseMsgListener</code>
     */
    public IDPXMLMsgListenerImpl() {
        super();
    }

    /**
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    @Override
    public void onMessage(Message message) {
        HttpClient httpclient=null;
        HttpResponse response = null;
        boolean isExecuted=true;
        IDPMsgBean idpMsgBean = null;
        
        try {
            //System.out.println("in XML Listener*************");
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Object object = objectMessage.getObject();
                if (object instanceof IDPMsgBean) {
                    idpMsgBean = (IDPMsgBean) object;
                    
                    //Save in TransmitLogDetails
                    if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_SUBMIT, idpMsgBean.getTransmitAt())){
                		IDPCustomerHelper.saveOnSubmitTransmitLogDetailsFromListener(idpMsgBean);
                    }else if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_DECISION, idpMsgBean.getTransmitAt())) {
                		IDPCustomerHelper.saveTransmitLogDetailsFromListener(idpMsgBean);
                    }else if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_PREQAUL_SUBIT, idpMsgBean.getTransmitAt())){
                		IDPCustomerHelper.saveOnPreqaulTransmitLogDetailsFromListener(idpMsgBean);
                	}
                    
                    String postURL = idpMsgBean.getPostURL();
                    //System.out.println(postURL);
                    
                    if(StringUtils.equalsIgnoreCase(MatrixConstants.ANSWER_YES, idpMsgBean.getSslCertFlag())){
                        System.setProperty("javax.net.ssl.trustStore",AppConfig.getValue(SSL_TRUSTSTORE_URL));
                        System.setProperty("javax.net.ssl.trustStorePassword", AppConfig.getValue(SSL_TRUSTSTORE_PWD));
                        System.setProperty("https.protocols", AppConfig.getValue(HTTPS_PROTOCOL));
                    }
                    
                    httpclient=HttpClients.createSystem();
                    HttpPost httpPost = new HttpPost(postURL);
                    
                    //Setting authorization header
                    String authorization = getAuthorization(idpMsgBean);
                    if(!StringUtils.isBlank(authorization)){
                        httpPost.addHeader("Authorization", "Basic " + authorization);
                    }
                    
                  //Adding HTTP Post headers if available
                    if(StringUtils.isNotBlank(idpMsgBean.getExternalId())){
                        String[] headerList = idpMsgBean.getExternalId().split(";");
                        for (String headerString : headerList) {
                            String[] headerKeyval = headerString.split("=");
                            if(headerKeyval!=null && headerKeyval.length==2){
                                httpPost.addHeader(headerKeyval[0].trim(),headerKeyval[1].trim());
                            }
                        }
                    }

                    try {
                        if(StringUtils.equals(idpMsgBean.getTransmitType(), MatrixConstants.IDP_TRANSMIT_TYPE_DIRECT)){
                            idpMsgBean = new IDPCustomerHelper().getCustomerInformation(idpMsgBean);
                            if(idpMsgBean.getResponseType()!=null 
                                    && (StringUtils.equals(IDPConstants.CUSTOMERDATA ,idpMsgBean.getResponseType())
                                            || StringUtils.equals(IDPConstants.DECDATA ,idpMsgBean.getResponseType())
                                            || StringUtils.equals(IDPConstants.ALL ,idpMsgBean.getResponseType()))){
                                httpPost.addHeader("Content-Type", "application/xml; charset=UTF-8");
                                httpPost = directPostPair(httpPost,idpMsgBean);
                            }else{
                                httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                                httpPost = directPostPairDecandCus(httpPost,idpMsgBean);
                            }
                        }else{
                            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                            httpPost = authorizationPostPair(httpPost,idpMsgBean);
                        }
                        response = httpclient.execute(httpPost);
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
                        isExecuted=false;
                    }
                    catch (ClientProtocolException e) {
                        e.printStackTrace();
                        AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
                        isExecuted=false;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
                        isExecuted=false;
                    }
                }
            }
        }
        catch (JMSException e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
            isExecuted=false;
        }
        catch (DataAccessException e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
            isExecuted=false;
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
            isExecuted=false;
        }
        finally{
            try {
                if(response!=null){
                    
                    if(StringUtils.equals(idpMsgBean.getTransmitType(), MatrixConstants.IDP_TRANSMIT_TYPE_DIRECT) && 
                            response.getStatusLine().getStatusCode()==200){
                        if(StringUtils.equals(idpMsgBean.getResponseCode(),WsErrorMessageConstants.SUCCESS)){
                        	if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_SUBMIT, idpMsgBean.getTransmitAt())){
                        		IDPCustomerHelper.saveOnSubmitTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_YES);
                        	}else if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_DECISION, idpMsgBean.getTransmitAt())) {
                        		IDPCustomerHelper.saveTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_YES);
                        	}else if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_PREQAUL_SUBIT, idpMsgBean.getTransmitAt())){
                        		IDPCustomerHelper.saveOnPrequalTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_YES);
                        	}
                            //Code change for BEC-496
                            IDPCustomerHelper.saveCreditReqTransmitDetails(MatrixConstants.ANSWER_YES, idpMsgBean.getRequestId());
                        }else{
                            isExecuted=false;
                        }
                    }else if(response.getStatusLine().getStatusCode()>=400){
                        idpMsgBean.setResponseCode(WsErrorMessageConstants.NOT_FOUND);
                        isExecuted=false;
                    }
                    AppLogger.log(AppLogger.INFO, response.getStatusLine().getStatusCode()+"");
                }else{
                	isExecuted=false;
                    System.out.println(" response null...");
                }
                if(!isExecuted){
                    if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_SUBMIT, idpMsgBean.getTransmitAt())){
                		IDPCustomerHelper.saveOnSubmitTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_NO);
                    } else if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_DECISION, idpMsgBean.getTransmitAt())) {
                		IDPCustomerHelper.saveTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_NO);
                    }else if(StringUtils.equals(MatrixConstants.IDP_TRANSMIT_AT_PREQAUL_SUBIT, idpMsgBean.getTransmitAt())){
                		IDPCustomerHelper.saveOnPrequalTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_NO);
                	}
                    //Code change for BEC-496
                    IDPCustomerHelper.saveCreditReqTransmitDetails(MatrixConstants.ANSWER_NO, idpMsgBean.getRequestId());
                    
                    System.out.println("Response code::"+response.getStatusLine().getStatusCode()+"   Resp Message :: "+response.getStatusLine().getReasonPhrase());
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
            }
        }
        
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the queue.
     */
    public Queue getQueue() {
        return queue;
    }

    /**
     * @param queue
     *            The queue to set.
     */
    public void setQueue(Queue queue) {
        this.queue = queue;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    private static  HttpPost directPostPairDecandCus(HttpPost httpPost,IDPMsgBean idpMsgBean) throws UnsupportedEncodingException{
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        
        if (StringUtils.isNotBlank(idpMsgBean.getResponseData())) {
            params.add(new BasicNameValuePair("customerData", String
                    .valueOf(idpMsgBean.getResponseData())));
        }
        if(StringUtils.isNotBlank(idpMsgBean.getResponseDecisionData())){
            params.add(new BasicNameValuePair("decisionData",
                    String.valueOf(idpMsgBean.getResponseDecisionData())));
        }
        
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        return httpPost;
    }
    
    private static  HttpPost directPostPair(HttpPost httpPost, IDPMsgBean idpMsgBean){
        StringBuffer responseData = new StringBuffer();
        if (StringUtils.isNotBlank(idpMsgBean.getResponseData())) {
            responseData.append(idpMsgBean.getResponseData());
            responseData.append("\n");
            
        }
        if(StringUtils.isNotBlank(idpMsgBean.getResponseDecisionData())){
            responseData.append(idpMsgBean.getResponseDecisionData());
        }
        if(StringUtils.isNotBlank(idpMsgBean.getResponseCustomerAndDecisionData())){
            responseData.append(idpMsgBean.getResponseCustomerAndDecisionData());
        }
        StringEntity customerEntity=new StringEntity(responseData.toString(), ContentType.APPLICATION_XML);
        httpPost.setEntity(customerEntity);
        return httpPost;
    }
    
    private static  HttpPost authorizationPostPair(HttpPost httpPost,IDPMsgBean idpMsgBean) throws UnsupportedEncodingException{
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("supplierId",
                String.valueOf(idpMsgBean.getSupplierId())));
        params.add(new BasicNameValuePair("groupId",
                String.valueOf(idpMsgBean.getGroupId())));
        params.add(new BasicNameValuePair("requestId",
                String.valueOf(idpMsgBean.getRequestId())));
        params.add(new BasicNameValuePair("postType",
                String.valueOf(idpMsgBean.getPostType())));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        return httpPost;
    }
    private String getAuthorization(IDPMsgBean idpMsgBean) throws Exception {
        if(StringUtils.isBlank(idpMsgBean.getUserID())
                || StringUtils.isBlank(idpMsgBean.getPassCode())
                || StringUtils.isBlank(idpMsgBean.getMysalt())){
            return null;
        }
        String uidpwd = idpMsgBean.getUserID() + ":" 
        + PassCodeHelper.decryptCode(idpMsgBean.getPassCode(), idpMsgBean.getMysalt());
        // Encode the user ID and password
        byte[] inputBytes = uidpwd.getBytes(Charset.defaultCharset());
        Base64 encoder = new Base64();
        return encoder.encodeToString(inputBytes);
      }
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
