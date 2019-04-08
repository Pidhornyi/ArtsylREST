

package helpClass;
/*
            Success = 101,
            Created = 102,
            Failed = 103,
            InvalidInput = 104,
            Forbidden = 105,
            Authorized = 106
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class URLMethods {
    private  String user;
    private String password ;

    //Create a session and return its guid
    private  String urlInitialize;

    //GetSessionGuid get your session id
    private  String urlGetSessionGuid;

    //ReinitializeTest session for user, using specified identificator.
    private  String urlReinitialize;

    //Deinitialize session.
    private  String urlDeinitialize;

    //Return description of workflows. (in JSON)
    private  String urlGetWorkflows;

    //Return description of batches Id of which are taken from 'takeFrom' with amount of 'amount'. (string takeFrom, string count)
    private  String urlGetBatch;

    //Return description of batches enabled for editing Id of which are taken from 'takeFrom' with amount of 'amount'.(string takeFrom, string count)
    private  String urlGetBatchesForEditing;

    //Return batch that was created (String workflowGuid)
    private  String urlCreateBatch;

    //Load batch by specified guid and return it. (String batchGuid)
    private  String urlLoadBatchByGuid ;

    //Return true if batch metadata were added successfully and false if not.
    private  String urlAddBatchMetadata;

    //Return true if batch image was loaded successfully and false if not.
    private String getUrlAddBatchImage;

    //Send current batch to the server and return it.
    private String urlSendBatch;

    // Return the description of all of the documents of current batch.
    private  String urlGetBatchDocuments ;

    //Pospone current batch.
    private  String urlPostponeBatch ;

    //Return fields of selecred document.
    private  String urlGetDocumentFields ;

    //Return a stream of selected document page.
    private  String urlGetDocumentPage ;

    //Set comment for document with specified guid.
    private  String urlSetDocumentComment;

    //Set field value for document with specified guid.
    private  String urlSetDocumentField ;

    //Set document flag status for document with specified guid.
    private String urlSetDocumentStatus ;

    private String urlGetAvailiableStatuses;


    public FileInputStream fis;
   public URLMethods() {

        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/URLData.properties");
            property.load(fis);

            this.user = property.getProperty("dAUser");
            this.password = property.getProperty("dAPassword");
            this.urlInitialize = property.getProperty("dAurlInitialize");
            this.urlGetSessionGuid = property.getProperty("dAurlGetSessionGuid");
            this.urlReinitialize = property.getProperty("dAurlReinitialize");
            this.urlDeinitialize = property.getProperty("dAurlDeinitialize");
            this.urlGetWorkflows = property.getProperty("dAurlGetWorkflows");
            this.urlGetBatch= property.getProperty("dAurlGetBatch");
            this.urlGetBatchesForEditing = property.getProperty("dAurlGetBatchesForEditing");
            this.urlCreateBatch = property.getProperty("dAurlCreateBatch");
            this.urlLoadBatchByGuid = property.getProperty("dAurlLoadBatchByGuid");
            this.getUrlAddBatchImage = property.getProperty("dAurlAddBatchImage");
            this.urlAddBatchMetadata = property.getProperty("dAurlAddBatchMetadata");
            this.urlSendBatch = property.getProperty("dAurlSendBatch");
            this.urlGetBatchDocuments = property.getProperty("dAurlGetBatchDocuments");
            this.urlPostponeBatch = property.getProperty("dAurlPostponeBatch");
            this.urlGetDocumentFields = property.getProperty("dAurlGetDocumentFields");
            this.urlGetDocumentPage = property.getProperty("dAurlGetDocumentPage");
            this.urlSetDocumentComment = property.getProperty("dAurlSetDocumentComment");
            this.urlSetDocumentField = property.getProperty("dAurlSetDocumentField");
            this.urlSetDocumentStatus = property.getProperty("dAurlSetDocumentStatus");
            this.urlGetAvailiableStatuses = property.getProperty("dAurlGetAvailiableStatuses");


        } catch (IOException e) {
            System.err.println("Error: properties file is missed!");
        }

    }




    public String getUrlInitialize(){
        String result = urlInitialize + "user=" + user + "&password=" + password;
        return result;
    }

    public String getUrlGetSessionGuid(){
        String result = urlGetSessionGuid;
        return result;
    }

    public  String getUrlReinitialize ( String identificator){
        String result = urlReinitialize + "user=" + user + "&password=" + password + "&identificator=" + identificator;
        return result;
    }

    public String getUrlDeinitialize () {
        String result = urlDeinitialize;
        return result;
    }

    public String getUrlGetWorkflows () {
        String result = urlGetWorkflows;
        return result;
    }

    public String getUrlGetBatches(String takeFromValue, String countValue, String guid){
        String result = urlGetBatch + "takeFrom=" + takeFromValue + "&count=" + countValue + "&guid=" + guid;
        return result;

    }

    public String getUrlGetBatchesForEditing(String takeFromValue, String countValue){
        String result = urlGetBatchesForEditing + "takeFrom=" + takeFromValue + "&count=" + countValue;
        return result;
    }

    public String getUrlGetBatchesForEditing(String takeFromValue, String countValue, String guidWorkflow){
        String result = urlGetBatchesForEditing + "takeFrom=" + takeFromValue + "&count=" + countValue;
        return result;
    }

    public String getUrlCreateBatch (String workflowGuid) {
        String result = urlCreateBatch + "workflowGuid=" + workflowGuid;
        return result;
    }

    public String getUrlLoadBatchByGuid (String batchGuid) {
        String result = urlLoadBatchByGuid + "batchGuid=" + batchGuid;
        return result;

    }

    public String getUrlAddBatchImage(){
        String result = getUrlAddBatchImage;
        return result;
    }

    public String getUrlAddBatchMetadata(String BatchName, String value){
        String result = urlAddBatchMetadata + "name=" + BatchName + "&value=" + value;
        return result;
    }

    public String getUrlSendBatch(){
        String result = urlSendBatch;
        return result;
    }

    public String getUrlGetBatchDocuments () {
        String result = urlGetBatchDocuments;
        return result;
    }

    public String getUrlPostponeBatch(){
        String result = urlPostponeBatch;
        return result;
    }

    public String getUrlGetDocumentFields(String guid){
        String result = urlGetDocumentFields + "guid=" + guid;
        return result;
    }

    public String getUrlGetDocumentPage(String guid, String pageValue){
        String result = urlGetDocumentPage + "guid=" + guid + "&page=" + pageValue;
        return result;

    }

    public String getUrlSetDocumentComment(String guid, String commentValue){
        String result = urlSetDocumentComment + "guid=" + guid + "&comment=" + commentValue;
        return result;
    }

    public String getUrlSetDocumentField(String docGuidValue, String fieldGuidValue, String value){
        String result = urlSetDocumentField + "docGuid=" + docGuidValue + "&fieldGuid=" + fieldGuidValue + "&value=" + value;
        return result;
    }

    public String getUrlSetDocumentStatus(String guid, String flagValue, String statusValue){
        String result = urlSetDocumentStatus + "guid=" + guid + "&flag=" + flagValue + "&status=" + statusValue;
        return result;
    }

    public String getUrlGetAvailiableStatuses(){
        String result = urlGetAvailiableStatuses;
        return result;
    }

}
