package tests.positive;


/*
            Success = 101,
            Created = 102,
            Failed = 103,
            InvalidInput = 104,
            Forbidden = 105,
            Authorized = 106

            List of possible statuses:

        IsRejected (change Boolean value to opposite)
        ToDelete (change Boolean value to opposite)
        IsApproved (change Boolean value to opposite)
        IsEscalated (set ‘status’ to flag)
        IsCommented (change Boolean value to opposite)
        StructureIssue (change Boolean value to opposite)
        MissingCriticalField (change Boolean value to opposite)
        ViolatingRules (change Boolean value to opposite)
        SupervisorAttention (change Boolean value to opposite)
        RejectOther (change Boolean value to opposite)
        IsForDesign (change Boolean value to opposite)
        IsSentToReviewer (set ‘status’ to flag)
        IsSentBackToApprover (change Boolean value to opposite)
        IsRedirected (set ‘status’ to flag)



Steps:

1)Initialize
2)GetWorkflow
3)CreateBatch
4)AddBatchImage
5)SendBatch
5.1) 5-7 seconds waiting
5.2) GetBatches
6)LoadBatch (тот который был создан (последний))
7)GetBatchDocuments (взять guid документа)
8)SetDocumentStatus
9)Deinitialize

 */



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;
import helpClass.*;
import java.util.Date;

public class SetDocumentStatusTest {


    static Initialize initialize ;
    static InitializePOJO pojo ;

    static GetWorkflows getWorkflows;
    static InitializePOJO getWorkflowPOJO;

    static CreateBatch createBatch;
    static InitializePOJO createBatchPOJO;

    static AddBatchImage addBatchImage;
    static InitializePOJO addBatchImagePOJO;

    static SendBatch sendBatch;
    static InitializePOJO sendBatchPOJO;

    static GetBatches getBatches;
    static InitializePOJO getBatchesPOJO;

    static LoadBatchByGuid loadBatchByGuid;
    static InitializePOJO loadBatchByGuidPOJO;

    static GetBatchDocuments getBatchDocuments;
    static InitializePOJO getBatchDocumentsPOJO;

    static SetDocumentStatus setDocumentStatus;
    static InitializePOJO setDocumentStatusPOJO;


    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;

    //Initialize
    @BeforeMethod
    public void initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();


        getWorkflows = new GetWorkflows(pojo.getCookie());
        getWorkflowPOJO = getWorkflows.getWorkflowsMethod();

        createBatch = new CreateBatch(pojo.getCookie(), getWorkflowPOJO.getMapMap().get("1").get(InitializePOJO.getWorkflowGuid()));
        createBatchPOJO = createBatch.createBatchMethod();

        addBatchImage = new AddBatchImage(pojo.getCookie());
        addBatchImagePOJO = addBatchImage.AddBatchImageMethod();

        sendBatch = new SendBatch(pojo.getCookie());
        sendBatchPOJO = sendBatch.sendBatchMethod();


// Важно указать время для распознавания !!!
        try {
            Thread.sleep(15000);
        }catch (Exception e){
            System.err.println("Exception !!!");
            System.err.println(e);

        }

        getBatches = new GetBatches(pojo.getCookie(),getWorkflowPOJO.getMapMap().get("1").get(InitializePOJO.getWorkflowGuid()));
        getBatchesPOJO = getBatches.getBatchesMethod("0","0");

        //взять последний созданный батч (в Мар он под номером 0)


        loadBatchByGuid = new LoadBatchByGuid(pojo.getCookie(),getBatchesPOJO.getMapMap().get("0").get(InitializePOJO.getBatchGuid()));
        loadBatchByGuidPOJO = loadBatchByGuid.LoadBatchByGuidMethod();

        getBatchDocuments = new GetBatchDocuments(pojo.getCookie());
        getBatchDocumentsPOJO = getBatchDocuments.GetBatchDocumentsMethod();
    }


    @Test
    public void setDocumentStatusMethod(){
        System.out.println("Start SetDocumentStatus Test at : " + new Date());

        setDocumentStatus = new SetDocumentStatus(pojo.getCookie(),getBatchDocumentsPOJO.getMapMap().get("0").get("Guid"),"IsRedirected","IsCommented");
        setDocumentStatusPOJO = setDocumentStatus.SetDocumentStatusMethod();
        System.out.println("massage = " + setDocumentStatusPOJO.getMessage());
        Assert.assertEquals(setDocumentStatusPOJO.getDocAlphaResponseCode(), "101");
        System.out.println("End SetDocumentStatus Test at : " + new Date());
    }




    @AfterMethod
    public void deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(), "101");
        System.out.println("End Deinitialize at " + new Date());
    }





}
