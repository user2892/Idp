/**
 * 
 */
package com.bectran.rackspacecloud.client;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.apache.http.HttpException;

import com.bectran.b2b.customer.beans.TaxExemptCertBean;
import com.bectran.b2b.customer.blo.CustomerDocsBLO;
import com.bectran.b2b.supplier.beans.SupplierCompanyBean;
import com.bectran.matrix.framework.AppConfig;
import com.bectran.matrix.framework.AppLogger;
import com.bectran.matrix.framework.exception.DataAccessException;
import com.bectran.matrix.framework.exception.ResourceLoadException;
import com.rackspacecloud.client.cloudfiles.FilesCDNContainer;
import com.rackspacecloud.client.cloudfiles.FilesClient;

/**
 * @author LOUIS IFEGUNI
 * @date Apr 21, 2012 : 11:40:08 PM
 */
public class RackFileContainerHelper {
    public static String getCDNUrl(String corpId) throws ResourceLoadException,
            IOException, HttpException, DataAccessException {
        FilesClient client = getLogin();
        String container = validateContainer(client, corpId.trim());
        FilesCDNContainer info = client.getCDNContainerInfo(container);
        //
        // String cdnUrl = info.getCdnURL();
        String cdnUrl = info.getSSLURL();
        //
        return cdnUrl;
    }

    public static String validateContainer(String corpId)
            throws ResourceLoadException, IOException, HttpException,
            DataAccessException {
        FilesClient client = new FilesClient();
        boolean success = client.login();
        if (!success) {
            // login failed
            String excpmessage = "LOGIN TO RACKSPACE CLOUD FILES FAILED  . . . .";
            AppLogger.log(AppLogger.ERROR, excpmessage);
            throw new DataAccessException(excpmessage);
        }
        String prefix = AppConfig
                .getValue(AppConfig.RACKCLOUD_CONTAINER_NAME_PREFIX);
        String container = prefix.trim() + "_" + corpId;
        //
        if (!client.containerExists(container)) {
            client.createContainer(container);
        }
        if (!client.isCDNEnabled(container)) {
            client.cdnEnableContainer(container);
        }
        //
        return container;
    }

    private static String validateContainer(FilesClient client, String corpId)
            throws ResourceLoadException, IOException, HttpException,
            DataAccessException {
        String prefix = AppConfig
                .getValue(AppConfig.RACKCLOUD_CONTAINER_NAME_PREFIX);
        String container = prefix.trim() + "_" + corpId;
        //
        if (!client.containerExists(container)) {
            client.createContainer(container);
        }
        if (!client.isCDNEnabled(container)) {
            client.cdnEnableContainer(container);
        }
        //
        return container;
    }

    public static void saveFile(SupplierCompanyBean supplier, String fileName,
                                HashMap<String, String> meta,
                                byte[] fileContent)
            throws ResourceLoadException, IOException, HttpException,
            DataAccessException {
        //
        FilesClient client = getLogin();
        String container = validateContainer(client,
                supplier.getCorpID().trim());
        //
        client.storeObject(container, fileContent, "application/octet-stream",
                fileName, meta);
    }
    /*
     * public static void saveFile(CustomerDocsBean docBean) throws Exception{
     * // FilesClient client = getLogin(); String container =
     * validateContainer(client, docBean.getSupplierCorpID().trim()); // byte[]
     * fileContent = docBean.getFileImage(); String fileName =
     * docBean.getDocFileSystemName().trim(); // HashMap<String, String> meta =
     * new HashMap<String, String>(); meta.put("docFullName",
     * docBean.getDocName().trim()); meta.put("acctNum",
     * docBean.getAcctNum().trim()); meta.put("supplierId",
     * docBean.getSupplierId().toString()); // client.storeObject(container,
     * fileContent, "application/octet-stream", fileName, meta); // String
     * documentUrl = CustomerDocsBLO.documentURL(fileName,
     * docBean.getSupplierCorpID().trim()); testReadFile(documentUrl); } S
     * public static void saveFile(PaperCreditAppBean docBean) throws Exception{
     * // FilesClient client = getLogin(); String container =
     * validateContainer(client, docBean.getSupplierCorpID().trim()); // byte[]
     * fileContent = docBean.getFileImage(); String fileName =
     * docBean.getDocFileSystemName().trim(); // HashMap<String, String> meta =
     * new HashMap<String, String>(); meta.put("docFullName",
     * docBean.getDocName().trim()); meta.put("acctNum",
     * docBean.getAcctNum().trim()); meta.put("supplierId",
     * docBean.getSupplierId().toString()); // client.storeObject(container,
     * fileContent, "application/octet-stream", fileName, meta); // String
     * documentUrl = CustomerDocsBLO.documentURL(fileName,
     * docBean.getSupplierCorpID().trim()); testReadFile(documentUrl); } public
     * static void saveFile(DocumentUploadMgtBean docBean) throws Exception{ //
     * FilesClient client = getLogin(); String container =
     * validateContainer(client, docBean.getCorpId().trim()); // byte[]
     * fileContent = docBean.getFileImage(); String fileName =
     * docBean.getDocFileSystemName().trim(); // HashMap<String, String> meta =
     * new HashMap<String, String>(); meta.put("docFullName",
     * docBean.getName().trim()); //meta.put("acctNum",
     * docBean.getAcctNum().trim()); meta.put("supplierId",
     * docBean.getSupplierId().toString()); // client.storeObject(container,
     * fileContent, "application/octet-stream", fileName, meta); // String
     * documentUrl = CustomerDocsBLO.documentURL(fileName,
     * docBean.getCorpId().trim()); testReadFile(documentUrl); }
     */

    private static FilesClient getLogin() throws ResourceLoadException,
            IOException, HttpException, DataAccessException {
        FilesClient client = new FilesClient();
        boolean success = client.login();
        if (!success) {
            // login failed
            String excpmessage = "LOGIN TO RACKSPACE CLOUD FILES FAILED  . . . .";
            AppLogger.log(AppLogger.ERROR, excpmessage);
            throw new DataAccessException(excpmessage);
        }
        //
        return client;
    }

    public static void saveFile(TaxExemptCertBean certBean) throws Exception {
        //
        FilesClient client = getLogin();
        String container = validateContainer(client,
                certBean.getSupplierCorpID().trim());
        //
        byte[] fileContent = certBean.getCertImage();
        String fileName = certBean.getDocFileSystemName().trim();
        //
        HashMap<String, String> meta = new HashMap<String, String>();
        meta.put("docFullName", "Tax Exempt Cert");
        meta.put("acctNum", certBean.getAcctNum());
        meta.put("supplierId", certBean.getSupplierId().toString());
        //
        client.storeObject(container, fileContent, "application/octet-stream",
                fileName, meta);
        //
        String documentUrl = CustomerDocsBLO.documentURL(fileName,
                certBean.getSupplierCorpID().trim());
        testReadFile(documentUrl);
    }

    private static void testReadFile(String documentUrl) throws Exception {
        URL url = new URL(documentUrl);
        // URL url = new
        // URL("http://layoutsparks.com/1/56178/castle-stone-window-grey.jpg");
        url.openStream();
    }

    /**
     * @param args
     * @throws Exception
     * @throws IOException
     * @throws ResourceLoadException
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // SupplierCompanyBean supplier = SupplierCompanyDAO.findCompany(1);
        // String url= validateContainer(supplier.getCorpID().trim());
        testReadFile("");
        // System.out.println("cdnURL ---> "+supplier.getCorpID().trim());
        // System.out.println("cdnURL ---> "+getCDNUrl("TN20060903007"));
        System.out.println("===============end=============");
    }
}
