package helpClass;
/*
            Success = 101,
            Created = 102,
            Failed = 103,
            InvalidInput = 104,
            Forbidden = 105,
            Authorized = 106
 */

public class URLMethods {

    private static final String user = "Admin";
    private static final String password = "Artsyl";

    //Create a session and return its guid
    private static String urlInitialize = "http://localhost:8058/docAlphaExternalAccessRestApi.svc/Initialize?";

    //ReinitializeTest session for user, using specified identificator.
    private static String urlReinitialize = "http://localhost:8058/docAlphaExternalAccessRestApi.svc/Reinitialize?";

    //Deinitialize session.
    private static String urlDeinitialize = "http://localhost:8058/docAlphaExternalAccessRestApi.svc/Deinitialize" ;

    //Return description of workflows. (in JSON)
    private static String urlGetWorkflows = "http://localhost:8058/docAlphaExternalAccessRestApi.svc/GetWorkflows" ;

    //Return description of batches Id of which are taken from 'takeFrom' with amount of 'amount'. (string takeFrom, string count)
    private static String urlGetBatch = "http://localhost/docAlphaExternalAccessRestApi.svc/GetBatches?";

    //Return description of batches enabled for editing Id of which are taken from 'takeFrom' with amount of 'amount'.(string takeFrom, string count)
    private static String urlGetBatchesForEditing = "http://localhost/docAlphaExternalAccessRestApi.svc/GetBatchesForEditing?";

    //Return batch that was created (String workflowGuid)
    private static String urlCreateBatch = "http://localhost/docAlphaExternalAccessRestApi.svc/CreateBatch?";

    //Load batch by specified guid and return it. (String batchGuid)
    private static String urlLoadBatchByGuid = "http://localhost/docAlphaExternalAccessRestApi.svc/LoadBatchByGuid?";

    //Return true if batch metadata were added successfully and false if not.
    private static String urlAddBatchMetadata = "http://localhost/docAlphaExternalAccessRestApi.svc/AddBatchMetadata?";

    //Send current batch to the server and return it.
    private static String urlSendBatch = "http://localhost/docAlphaExternalAccessRestApi.svc/SendBatch";

    // Return the description of all of the documents of current batch.
    private static String urlGetBatchDocuments = "http://localhost/docAlphaExternalAccessRestApi.svc/GetBatchDocuments";

    //Pospone current batch.
    private static String urlPostponeBatch = "http://localhost/docAlphaExternalAccessRestApi.svc/PostponeBatch";

    //Return fields of selecred document.
    private static String urlGetDocumentFields = "http://localhost/docAlphaExternalAccessRestApi.svc/GetDocumentFields?";

    //Return a stream of selected document page.
    private static String urlGetDocumentPage = "http://localhost/docAlphaExternalAccessRestApi.svc/GetDocumentPage?";

    //Set comment for document with specified guid.
    private static String urlSetDocumentComment = "http://localhost/docAlphaExternalAccessRestApi.svc/SetDocumentComment?";

    //Set field value for document with specified guid.
    private static String urlSetDocumentField = "http://localhost/docAlphaExternalAccessRestApi.svc/SetDocumentField?";

    //Set document flag status for document with specified guid.
    private static String urlSetDocumentStatus ="http://localhost/docAlphaExternalAccessRestApi.svc/SetDocumentStatus?";

    public static String getUrlInitialize(){
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
