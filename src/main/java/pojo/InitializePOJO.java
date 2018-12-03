package pojo;

import com.jayway.restassured.response.Cookies;

import java.util.Map;


public class InitializePOJO {



    private static String DocAlphaResponseCode="DocAlphaResponseCode";
    private static String Message="Message";
    private static String ReturnedValue="ReturnedValue";
    private static String __type="__type";
    private Cookies Cookie;

    // Methuds name 19
    private static String InitializeResult = "InitializeResult";
    private static String ReinitializeResult ="ReinitializeResult";
    private static String DeinitializeResult="DeinitializeResult";
    private static String GetWorkflowsResult="GetWorkflowsResult";
    private static String GetSessionGuidResult="GetSessionGuidResult";
    private static String GetBatchesForEditingResult="GetBatchesForEditingResult";
    private static String LoadBatchByGuidResult="LoadBatchByGuidResult";
    private static String CreateBatchResult="CreateBatchResult";
    private static String SendBatchResult="SendBatchResult";
    private static String GetDocumentFieldsResult="GetDocumentFieldsResult";
    private static String GetBatchDocumentsResult="GetBatchDocumentsResult";
    private static String GetBatchesResult="GetBatchesResult";
    private static String AddBatchImage="";
    private static String AddBatchMetadataResult="AddBatchMetadataResult";
    private static String PostponeBatchResult="PostponeBatchResult";
    private static String GetDocumentPageResult="GetDocumentPageResult";
    private static String SetDocumentCommentResult="SetDocumentCommentResult";
    private static String SetDocumentFieldResult="SetDocumentFieldResult";
    private static String SetDocumentStatusResult="SetDocumentStatusResult";

    //(ReturnedValue) GetWorkflowsResult
    private static String WorkflowGuid="WorkflowGuid";
    private static String WorkflowName="WorkflowName";

    //(ReturnedValue) GetBatchesResult , GetBatchesForEditingResult , CreateBatchResult , LoadBatchByGuidResult , SendBatchResult ,PostponeBatchResult
    private static String BatchGuid="BatchGuid";
    private static String BatchId="BatchId";
    private static String BatchOwnerStationName="BatchOwnerStationName";
    private static String BatchStatus="BatchStatus";
    private static String DocumentsCount="DocumentsCount";
    private static String LastStationChangeTime="LastStationChangeTime";
    private static String NodeType="NodeType";
    private static String PagesCount="PagesCount";
    private static String UserGroupName="UserGroupName";
    private static String UserName="UserName";
    private static String VersionedWorkflowName="VersionedWorkflowName";

    //(ReturnedValue) GetBatchDocumentsResult
    private static String Guid="Guid";
    private static String Name="Name";
    private static String ProfileName="ProfileName";

    //(ReturnedValue) GetDocumentFieldsResult
    private static String FieldGuid="FieldGuid";
    private static String Type="Type";
    private static String Value="Value";


    private Map<String,Map<String,String>> mapMap;
    private Map<String,String> map;


    public static String getInitializeResult() {
        return InitializeResult;
    }

    public static String getReinitializeResult() {
        return ReinitializeResult;
    }

    public static String getDeinitializeResult() {
        return DeinitializeResult;
    }

    public static String getGetWorkflowsResult() {
        return GetWorkflowsResult;
    }

    public static String getGetSessionGuidResult() {
        return GetSessionGuidResult;
    }

    public static String getGetBatchesForEditingResult() {
        return GetBatchesForEditingResult;
    }

    public static String getLoadBatchByGuidResult() {
        return LoadBatchByGuidResult;
    }

    public static String getCreateBatchResult() {
        return CreateBatchResult;
    }

    public static String getSendBatchResult() {
        return SendBatchResult;
    }

    public static String getGetDocumentFieldsResult() {
        return GetDocumentFieldsResult;
    }

    public static String getGetBatchDocumentsResult() {
        return GetBatchDocumentsResult;
    }

    public static String getGetBatchesResult() {
        return GetBatchesResult;
    }

    public static String getAddBatchImage() {
        return AddBatchImage;
    }

    public static String getAddBatchMetadataResult() {
        return AddBatchMetadataResult;
    }

    public static String getPostponeBatchResult() {
        return PostponeBatchResult;
    }

    public static String getGetDocumentPageResult() {
        return GetDocumentPageResult;
    }

    public static String getSetDocumentCommentResult() {
        return SetDocumentCommentResult;
    }

    public static String getSetDocumentFieldResult() {
        return SetDocumentFieldResult;
    }

    public static String getSetDocumentStatusResult() {
        return SetDocumentStatusResult;
    }

    public static String getDocAlphaResponseCode() {
        return DocAlphaResponseCode;
    }

    public static void setDocAlphaResponseCode(String docAlphaResponseCode) {
        DocAlphaResponseCode = docAlphaResponseCode;
    }

    public static String getMessage() {
        return Message;
    }

    public static void setMessage(String message) {
        Message = message;
    }

    public static String getReturnedValue() {
        return ReturnedValue;
    }

    public static void setReturnedValue(String returnedValue) {
        ReturnedValue = returnedValue;
    }

    public static String get__type() {
        return __type;
    }

    public static void set__type(String __type) {
        InitializePOJO.__type = __type;
    }

    public Cookies getCookie() {
        return Cookie;
    }

    public void setCookie(Cookies cookie) {
        Cookie = cookie;
    }

    public static String getWorkflowGuid() {
        return WorkflowGuid;
    }

    public static void setWorkflowGuid(String workflowGuid) {
        WorkflowGuid = workflowGuid;
    }

    public static String getWorkflowName() {
        return WorkflowName;
    }

    public static void setWorkflowName(String workflowName) {
        WorkflowName = workflowName;
    }

    public static String getBatchGuid() {
        return BatchGuid;
    }

    public static void setBatchGuid(String batchGuid) {
        BatchGuid = batchGuid;
    }

    public static String getBatchId() {
        return BatchId;
    }

    public static void setBatchId(String batchId) {
        BatchId = batchId;
    }

    public static String getBatchOwnerStationName() {
        return BatchOwnerStationName;
    }

    public static void setBatchOwnerStationName(String batchOwnerStationName) {
        BatchOwnerStationName = batchOwnerStationName;
    }

    public static String getBatchStatus() {
        return BatchStatus;
    }

    public static void setBatchStatus(String batchStatus) {
        BatchStatus = batchStatus;
    }

    public static String getDocumentsCount() {
        return DocumentsCount;
    }

    public static void setDocumentsCount(String documentsCount) {
        DocumentsCount = documentsCount;
    }

    public static String getLastStationChangeTime() {
        return LastStationChangeTime;
    }

    public static void setLastStationChangeTime(String lastStationChangeTime) {
        LastStationChangeTime = lastStationChangeTime;
    }

    public static String getNodeType() {
        return NodeType;
    }

    public static void setNodeType(String nodeType) {
        NodeType = nodeType;
    }

    public static String getPagesCount() {
        return PagesCount;
    }

    public static void setPagesCount(String pagesCount) {
        PagesCount = pagesCount;
    }

    public static String getUserGroupName() {
        return UserGroupName;
    }

    public static void setUserGroupName(String userGroupName) {
        UserGroupName = userGroupName;
    }

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static String getVersionedWorkflowName() {
        return VersionedWorkflowName;
    }

    public static void setVersionedWorkflowName(String versionedWorkflowName) {
        VersionedWorkflowName = versionedWorkflowName;
    }

    public static String getGuid() {
        return Guid;
    }

    public static void setGuid(String guid) {
        Guid = guid;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }

    public static String getProfileName() {
        return ProfileName;
    }

    public static void setProfileName(String profileName) {
        ProfileName = profileName;
    }

    public static String getFieldGuid() {
        return FieldGuid;
    }

    public static void setFieldGuid(String fieldGuid) {
        FieldGuid = fieldGuid;
    }

    public static String getType() {
        return Type;
    }

    public static void setType(String type) {
        Type = type;
    }

    public static String getValue() {
        return Value;
    }

    public static void setValue(String value) {
        Value = value;
    }

    public Map<String, Map<String, String>> getMapMap() {
        return mapMap;
    }

    public void setMapMap(Map<String, Map<String, String>> mapMap) {
        this.mapMap = mapMap;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
