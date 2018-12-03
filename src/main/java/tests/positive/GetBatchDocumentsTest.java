package tests.positive;


import helpClass.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

/*
            Success = 101,
            Created = 102,
            Failed = 103,
            InvalidInput = 104,
            Forbidden = 105,
            Authorized = 106

Steps:
1)Initialize
2)GetWorkflow
3)CreateBatch
4)AddBatchImage
5)SendBatch
5.1) 5-7 seconds waiting
5.2) GetBatches
6)LoadBatch (тот который был создан (последний))
7)GetBatchDocuments
 */
public class GetBatchDocumentsTest {


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
            Thread.sleep(10000);
        }catch (Exception e){
            System.err.println("Exception !!!");
            System.err.println(e);

        }

        getBatches = new GetBatches(pojo.getCookie(),getWorkflowPOJO.getMapMap().get("1").get(InitializePOJO.getWorkflowGuid()));
        getBatchesPOJO = getBatches.getBatchesMethod("0","0");

        //взять последний созданный батч (в Мар он под номером 0)


        loadBatchByGuid = new LoadBatchByGuid(pojo.getCookie(),getBatchesPOJO.getMapMap().get("0").get(InitializePOJO.getBatchGuid()));
        loadBatchByGuidPOJO = loadBatchByGuid.LoadBatchByGuidMethod();
    }


    @Test
    public void getBatchDocuments(){
        System.out.println("Start SendBatch Test at : " + new Date());

        getBatchDocuments = new GetBatchDocuments(pojo.getCookie());
        getBatchDocumentsPOJO = getBatchDocuments.GetBatchDocumentsMethod();

        System.out.println("massage = " + getBatchDocumentsPOJO.getMessage());
        Assert.assertEquals(getBatchDocumentsPOJO.getDocAlphaResponseCode(), "101");
        System.out.println("End Reinitialize Test at : " + new Date());
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
