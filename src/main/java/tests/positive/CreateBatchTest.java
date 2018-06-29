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
4)Deinitialize
 */

public class CreateBatchTest {


    static Initialize initialize ;
    static InitializePOJO pojo ;

    static GetWorkflows getWorkflows;
    static InitializePOJO getWorkflowPOJO;

    static CreateBatch createBatch;
    static InitializePOJO createBatchPOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void Initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

        getWorkflows = new GetWorkflows(pojo.getCookie());
        getWorkflowPOJO = getWorkflows.getWorkflowsMethod();


    }

    @Test
    public void CreatBatch(){

       createBatch = new CreateBatch(pojo.getCookie(),getWorkflowPOJO.getMapMap().get("1").get("WorkflowGuid"));
       createBatchPOJO = createBatch.createBatchMethod();
        Assert.assertEquals(createBatchPOJO.getDocAlphaResponseCode(),"102");


    }


    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize = new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("End Deinitialize at : " + new Date());

    }



}
