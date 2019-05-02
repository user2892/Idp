/**
 * 
 */
package com.bectran.b2b.customer.blo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpException;

import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.bectran.rackspacecloud.client.RackFileContainerHelper;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 22, 2012 : 4:49:52 PM
 */
public class CustomerDocsBLO {
    /*
     * private static void populateDocBean(PastCreditAppBean creditApp,
     * CustomerDocsBean docBean, DocumentUploadMgtBean docModel) { //
     * docBean.setAcctNum(creditApp.getAcctNum());
     * docBean.setCustomerSupplierId(creditApp.getCustomerSupplierId());
     * docBean.setDocModelId(docModel.getId());
     * docBean.setDocName(docModel.getName());
     * docBean.setSupplierId(docModel.getSupplierId());
     * docBean.setLastUpdate(new Date());
     * docBean.setCusDocType(docModel.getDocType()); } public static void
     * setDocumentFileSysteName(CustomerDocsBean docBean){ String docName =
     * docBean.getDocName().trim(); String namePart = "";
     * if(docName.length()<11){ namePart = docName.trim().replaceAll(" ", "");
     * }else{ namePart = docName.trim().replaceAll(" ", "").substring(0,10); }
     * String timestampPart = DateUtility.timeStampLabel(); String
     * docPrefix="G"; // String name =
     * docPrefix+"_"+docBean.getAcctNum()+"_"+timestampPart+"_"+docBean.getId().
     * toString()+ namePart+"."+docBean.getFileExt(); //
     * docBean.setDocFileSystemName(name); } public static void
     * setDocumentFileSysteName(TaxExemptCertBean certBean){ String docName =
     * "TaxExCert"; String namePart = ""; if(docName.length()<11){ namePart =
     * docName.trim().replaceAll(" ", ""); }else{ namePart =
     * docName.trim().replaceAll(" ", "").substring(0,10); } String
     * timestampPart = DateUtility.timeStampLabel(); String docPrefix="T"; //
     * String name =
     * docPrefix+"_"+certBean.getAcctNum()+"_"+timestampPart+"_"+certBean.getId(
     * ).toString()+ namePart+"."+certBean.getFileExt(); //
     * certBean.setDocFileSystemName(name); } public static void
     * setDocumentFileSysteName(DocumentUploadMgtBean docBean){ String docName =
     * "DnLoad"; String namePart = docName; //if(docName.length()<11){ //
     * namePart = docName.trim().replaceAll(" ", ""); //}else{ // namePart =
     * docName.trim().replaceAll(" ", "").substring(0,10); // } String
     * timestampPart = DateUtility.timeStampLabel(); String docPrefix="DO"; //
     * String name =
     * docPrefix+"_"+docBean.getGroupId()+"_"+timestampPart+"_"+docBean.getId().
     * toString()+ namePart+"."+docBean.getFileExt(); //
     * docBean.setDocFileSystemName(name); }
     */
    public static String documentURL(String docFileSystemName, String corpId)
            throws ResourceLoadException, DataAccessException, IOException,
            HttpException {
        //
        String CDNUrl = RackFileContainerHelper.getCDNUrl(corpId);
        return CDNUrl + "/" + docFileSystemName;
    }

    public static String storeDocumentInLocalStore(String docFileSystemName,
                                                   String documentUrl)throws Exception {
        //
        String relativeFileName=null;
        OutputStream outputStream =null;
        try {
            URL url = new URL(documentUrl);
            relativeFileName = "/local-doc-store/" + docFileSystemName;
            String localFileName = AppConfig.getWebContentPath() + relativeFileName;
            File file = new File(localFileName);
            outputStream = new FileOutputStream(file);
            IOUtils.copy(url.openStream(), outputStream);
            
        }
        catch (Exception e) {
            throw e;
        }
        finally{
            if(outputStream!=null){
                outputStream.close();
            }
        }
        //
        return relativeFileName;
    }

    public static void main(String[] args) throws Exception {
        //
        // loadCreditTermModel(1l);
        // String data = "dat ";
        // DateUtility
        System.out.println("-------------start----------");
        // fixForDocUploadVisibilityFlag();
        System.out.println("-------------finish----------");
    }
}
