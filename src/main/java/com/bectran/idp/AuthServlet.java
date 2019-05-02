/**
 * Bectran Solutions. All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.bectran.idp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.bectran.b2b.constants.MatrixConstants;
import com.bectran.b2b.constants.WsErrorMessageConstants;
import com.bectran.b2b.enterprise.beans.EnterpriseAccountByGroupBean;
import com.bectran.b2b.enterprise.beans.EnterpriseIntgServiceBean;
import com.bectran.b2b.enterprise.dao.EnterpriseAccountByGroupDAO;
import com.bectran.b2b.supplier.beans.GroupAccountBean;
import com.bectran.b2b.supplier.beans.GroupAccountRuleBean;
import com.bectran.b2b.supplier.dao.GroupAccountDAO;
import com.bectran.b2b.supplier.dao.GroupAccountRuleDAO;
import com.bectran.idp.beans.IDPConstants;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.PassCodeHelper;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.framework.idp.IDPMsgBean;

/**
 * @author shanmu
 * @date 28-May-2016 10:31:57 pm
 */
public class AuthServlet extends HttpServlet {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 6959928355050591746L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>AuthServlet</code>
     */
    public AuthServlet() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String responseData = "";
        String responseDecisionData = "";
        IDPMsgBean idpMsgBean = new IDPMsgBean();
        boolean isExecuted = true;
        try {
            String userId = req.getParameter("username");
            String passcode = req.getParameter("password");
            String groupId = StringUtils.trim(req.getParameter("groupId"));
            /*if (StringUtils.isBlank(groupId) && !StringUtils.isNumeric(groupId)) {
                isExecuted = false;
                return;
            }*/
            
            String requestId = StringUtils.trim(req.getParameter("requestId"));
            String supplierId = StringUtils.trim(req.getParameter("supplierId"));
            String postType = StringUtils.trim(req.getParameter("postType"));
            boolean validParams = verifyAndSetRequestParams(requestId,
                    supplierId, postType, groupId, userId, idpMsgBean);
            
           
            EnterpriseAccountByGroupBean bean = null;
            GroupAccountRuleBean ruleBean = new GroupAccountRuleDAO().find(idpMsgBean.getSupplierId());
            if(ruleBean!=null && ruleBean.isIntegrationScopeIsGlobal()){
                //Getting primary group bean
                GroupAccountBean primaryGroup = new GroupAccountDAO().getPrimaryGroup(idpMsgBean.getSupplierId());
                bean = new EnterpriseAccountByGroupDAO().find(primaryGroup.getId().longValue());
            }else{
                bean = new EnterpriseAccountByGroupDAO().find(idpMsgBean.getGroupId());
            }
            
            if (bean == null) {
                responseData = WsErrorMessageConstants.errorDescription(WsErrorMessageConstants.INVALID_PARAMETERS);
                idpMsgBean.setResponseCode(WsErrorMessageConstants.INVALID_PARAMETERS);
                isExecuted = false;
                sendRepsoneData(responseData, resp);
                return;
            }
            
            // User ID and Password validation
            boolean verifyPassword = verifyWSAccess(bean, passcode);
            if (!verifyPassword) {
                responseData = WsErrorMessageConstants.errorDescription(WsErrorMessageConstants.AUTHENTICATION_ERROR);
                idpMsgBean.setResponseCode(WsErrorMessageConstants.AUTHENTICATION_ERROR);
                isExecuted = false;
            }
            else if (!validParams) {
                responseData = WsErrorMessageConstants.errorDescription(WsErrorMessageConstants.INVALID_PARAMETERS);
                idpMsgBean.setResponseCode(WsErrorMessageConstants.INVALID_PARAMETERS);
                isExecuted = false;
            }
            else {
                EnterpriseIntgServiceBean idpServiceBean = bean.getIntgIdpService();
                if (idpServiceBean != null && idpServiceBean.getIdpServiceBean()!=null) {
                    //Setting Response Type and Attribute list to IDPMsgBean
                    idpMsgBean.setResponseType(idpServiceBean.getIdpServiceBean().getResponseType());
                    idpMsgBean.setIdpAttributeSet(idpServiceBean.getIdpServiceBean().getIdpAttributeSet());
                }
                
                idpMsgBean = new IDPCustomerHelper().getCustomerInformation(idpMsgBean);
                
                if(StringUtils.equals(IDPConstants.CUSTOMERDATA ,idpMsgBean.getResponseType())
                        || StringUtils.equals(IDPConstants.DECDATA ,idpMsgBean.getResponseType())
                        || StringUtils.equals(IDPConstants.ALL ,idpMsgBean.getResponseType())){
                    
                    if(StringUtils.equals(IDPConstants.CUSTOMERDATA ,idpMsgBean.getResponseType())){
                        responseData = idpMsgBean.getResponseData();
                    }else if(StringUtils.equals(IDPConstants.DECDATA ,idpMsgBean.getResponseType())){
                        responseData = idpMsgBean.getResponseDecisionData();
                    }else if(StringUtils.equals(IDPConstants.ALL ,idpMsgBean.getResponseType())){
                        responseData = idpMsgBean.getResponseCustomerAndDecisionData();
                    }
                    
                }else{
                    responseData = idpMsgBean.getResponseData();
                    responseDecisionData = idpMsgBean.getResponseDecisionData();
                }
                
            }
            
            if(StringUtils.isNotBlank(responseDecisionData)){
                resp.addHeader("decisionData", responseDecisionData);
            }
            
            sendRepsoneData(responseData, resp);
        }
        catch (DataAccessException e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
            idpMsgBean.setResponseCode(WsErrorMessageConstants.SYSTEM_ERROR);
            isExecuted = false;
        }
        catch (Exception e) {
            e.printStackTrace();
            AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
            idpMsgBean.setResponseCode(WsErrorMessageConstants.SYSTEM_ERROR);
            isExecuted = false;
        }
        finally {
            try {
                if (!isExecuted) {
                    IDPCustomerHelper.saveTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_NO);
                    //Code change for BEC-496
                    IDPCustomerHelper.saveCreditReqTransmitDetails(MatrixConstants.ANSWER_NO, idpMsgBean.getRequestId());
                }
                else {
                    if (StringUtils.equals(idpMsgBean.getResponseCode(), WsErrorMessageConstants.SUCCESS)) {
                        IDPCustomerHelper.saveTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_YES);
                        //Code change for BEC-496
                        IDPCustomerHelper.saveCreditReqTransmitDetails(MatrixConstants.ANSWER_YES, idpMsgBean.getRequestId());
                    }else{
                        IDPCustomerHelper.saveTransmitLogDetails(idpMsgBean, MatrixConstants.ANSWER_NO);
                        //Code change for BEC-496
                        IDPCustomerHelper.saveCreditReqTransmitDetails(MatrixConstants.ANSWER_NO, idpMsgBean.getRequestId());
                    }
                }
            }
            catch (DataAccessException e) {
                e.printStackTrace();
                AppLogger.log(AppLogger.ERROR, e.getLocalizedMessage());
            }
        }
    }

    /**
     * @param data
     * @param response
     * @throws IOException
     */
    private void sendRepsoneData(String data, HttpServletResponse response)
            throws IOException {
        
        String charset = "UTF-8";
        response.setCharacterEncoding(charset);
        response.setContentType("text/xml;charset=" + charset);
        if(StringUtils.isNotBlank(data)){
            data = URLEncoder.encode(data,charset);
            OutputStream output = response.getOutputStream();
            output.write(data.getBytes(Charset.forName(charset)));
            output.close();
        }
       
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    /**
     * @param bean
     * @param request
     * @return
     * @throws Exception
     */
    private boolean verifyWSAccess(EnterpriseAccountByGroupBean bean,
                                   String passcode) throws Exception {
        //
        //
        EnterpriseIntgServiceBean idpServiceBean = bean.getIntgIdpService();
        if (idpServiceBean != null) {
            String clearPasscode = PassCodeHelper.decryptCode(idpServiceBean
                    .getPassCode().trim(), idpServiceBean.getMysalt());
            String requestPasscode = passcode;
            if (!clearPasscode.trim().equals(requestPasscode.trim())) {
                return false;
            }
        }
        else {
            return false;
        }
        return true;
    }

    private boolean verifyAndSetRequestParams(String requestId,
                                              String supplierId,
                                              String postType, String groupId,
                                              String userId,
                                              IDPMsgBean idpMsgBean) {
        if (StringUtils.isNumeric(requestId)
                && StringUtils.isNumeric(supplierId)
                && StringUtils.isNotEmpty(postType)
                && StringUtils.isNumeric(groupId)) {
            idpMsgBean.setRequestId(Long.parseLong(requestId));
            idpMsgBean.setGroupId(Long.parseLong(groupId));
            idpMsgBean.setSupplierId(Long.parseLong(supplierId));
            idpMsgBean.setPostType(postType);
            idpMsgBean.setUserID(userId);
            return true;
        }
        return false;
    }
    
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
