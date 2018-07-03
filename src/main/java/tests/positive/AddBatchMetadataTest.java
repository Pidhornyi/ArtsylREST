package tests.positive;




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
4)AddBatchMetadata
5)Deinitialize
 */


import helpClass.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

public class AddBatchMetadataTest {



    static Initialize initialize ;
    static InitializePOJO pojo ;

    static GetWorkflows getWorkflows;
    static InitializePOJO getWorkflowPOJO;

    static CreateBatch createBatch;
    static InitializePOJO createBatchPOJO;

    static AddBatchMetadata addBatchMetadata;
    static InitializePOJO addBatchMetadataPOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void Initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

        getWorkflows = new GetWorkflows(pojo.getCookie());
        getWorkflowPOJO = getWorkflows.getWorkflowsMethod();

        createBatch = new CreateBatch(pojo.getCookie(),getWorkflowPOJO.getMapMap().get("1").get("WorkflowGuid"));
        createBatchPOJO = createBatch.createBatchMethod();


    }

    @Test
    public void AddBatchMetadataTestMethod(){

        addBatchMetadata = new AddBatchMetadata(pojo.getCookie(),"testName", "testValue");
        addBatchMetadataPOJO= addBatchMetadata.AddBatchMetadataMethod();
        Assert.assertEquals(addBatchMetadataPOJO.getDocAlphaResponseCode(),"101");

    }



    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize = new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("End Deinitialize at : " + new Date());

    }



}
