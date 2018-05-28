

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
    private static String user;
    private static String password ;

    //Create a session and return its guid
    private static String urlInitialize;

    //ReinitializeTest session for user, using specified identificator.
    private static String urlReinitialize;

    //Deinitialize session.
    private static String urlDeinitialize;

    //Return description of workflows. (in JSON)
    private static String urlGetWorkflows;

    //Return description of batches Id of which are taken from 'takeFrom' with amount of 'amount'. (string takeFrom, string count)
    private static String urlGetBatch;

    //Return description of batches enabled for editing Id of which are taken from 'takeFrom' with amount of 'amount'.(string takeFrom, string count)
    private static String urlGetBatchesForEditing;

    //Return batch that was created (String workflowGuid)
    private static String urlCreateBatch;

    //Load batch by specified guid and return it. (String batchGuid)
    private static String urlLoadBatchByGuid ;

    //Return true if batch metadata were added successfully and false if not.
    private static String urlAddBatchMetadata;

    //Send current batch to the server and return it.
    private static String urlSendBatch;

    // Return the description of all of the documents of current batch.
    private static String urlGetBatchDocuments ;

    //Pospone current batch.
    private static String urlPostponeBatch ;

    //Return fields of selecred document.
    private static String urlGetDocumentFields ;

    //Return a stream of selected document page.
    private static String urlGetDocumentPage ;

    //Set comment for document with specified guid.
    private static String urlSetDocumentComment;

    //Set field value for document with specified guid.
    private static String urlSetDocumentField ;

    //Set document flag status for document with specified guid.
    private static String urlSetDocumentStatus ;


    public FileInputStream fis;
   public URLMethods() {

        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/URLData.properties");
            property.load(fis);

            this.user = property.getProperty("dAUser");
            this.password = property.getProperty("dAPassword");
            this.urlInitialize = property.getProperty("dAurlInitialize");
            this.urlReinitialize = property.getProperty("dAurlReinitialize");
            this.urlDeinitialize = property.getProperty("dAurlDeinitialize");
            this.urlGetWorkflows = property.getProperty("dAurlGetWorkflows");
            this.urlGetBatch= property.getProperty("dAurlGetBatch");
            this.urlGetBatchesForEditing = property.getProperty("dAurlGetBatchesForEditing");
            this.urlCreateBatch = property.getProperty("dAurlCreateBatch");
            this.urlLoadBatchByGuid = property.getProperty("dAurlLoadBatchByGuid");
            this.urlAddBatchMetadata = property.getProperty("dAurlAddBatchMetadata");
            this.urlSendBatch = property.getProperty("dAurlSendBatch");
            this.urlGetBatchDocuments = property.getProperty("dAurlGetBatchDocuments");
            this.urlPostponeBatch = property.getProperty("dAurlPostponeBatch");
            this.urlGetDocumentFields = property.getProperty("dAurlGetDocumentFields");
            this.urlGetDocumentPage = property.getProperty("dAurlGetDocumentPage");
            this.urlSetDocumentComment = property.getProperty("dAurlSetDocumentComment");
            this.urlSetDocumentField = property.getProperty("dAurlSetDocumentField");
            this.urlSetDocumentStatus = property.getProperty("dAurlSetDocumentStatus");


        } catch (IOException e) {
            System.err.println("Error: properties file is missed!");
        }

    }


    public String getUrlInitialize(){
        String result = urlInitialize + "user=" + user + "&password=" + password;
        return result;
    }

    public static String getUrlReinitialize ( String identificator){
        String result = urlReinitialize + "user=" + user + "&password=" + password + "&identificator=" + identificator;
        return result;
    }

    public static String getUrlDeinitialize () {
        String result = urlDeinitialize;
        return result;
    }

    public static String getUrlGetWorkflows () {
        String result = urlGetWorkflows;
        return result;
    }

    public static String getUrlGetBatch(String takeFromValue, String countValue){
        String result = urlGetBatch + "takeFrom=" + takeFromValue + "&count=" + countValue;
        return result;

    }

    public static String getUrlGetBatchesForEditing(String takeFromValue, String countValue){
        String result = urlGetBatchesForEditing + "takeFrom=" + takeFromValue + "&count=" + countValue;
        return result;
    }

    public static String getUrlCreateBatch (String workflowGuid) {
        String result = urlCreateBatch + "workflowGuid=" + workflowGuid;
        return result;
    }

    public static String getUrlLoadBatchByGuid (String batchGuid) {
        String result = urlLoadBatchByGuid + "batchGuid=" + batchGuid;
        return result;

    }

    public static String getUrlAddBatchMetadata(String BatchName, String value){
        String result = urlAddBatchMetadata + "name=" + BatchName + "&value=" + value;
        return result;
    }

    public static String getUrlSendBatch(){
        String result = urlSendBatch;
        return result;
    }

    public static String getUrlGetBatchDocuments () {
        String result = urlGetBatchDocuments;
        return result;
    }

    public static String getUrlPostponeBatch(){
        String result = urlPostponeBatch;
        return result;
    }

    public static String getUrlGetDocumentFields(String guid){
        String result = urlGetDocumentFields + "guid=" + guid;
        return result;
    }

    public static String getUrlGetDocumentPage(String guid, String pageValue){
        String result = urlGetDocumentPage + "guid=" + guid + "&page=" + pageValue;
        return result;

    }

    public static String getUrlSetDocumentComment(String guid, String commentValue){
        String result = urlSetDocumentComment + "guid=" + guid + "&comment=" + commentValue;
        return result;
    }

    public static String getUrlSetDocumentField(String docGuidValue, String fieldGuidValue, String value){
        String result = urlSetDocumentField + "docGuid=" + docGuidValue + "&fieldGuid=" + fieldGuidValue + "&value=" + value;
        return result;
    }

    public static String getUrlSetDocumentStatus(String guid, String flagValue, String statusValue){
        String result = urlSetDocumentStatus + "guid=" + guid + "&flag=" + flagValue + "&status=" + statusValue;
        return result;
    }

}
