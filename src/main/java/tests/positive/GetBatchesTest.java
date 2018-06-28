package tests.positive;

import helpClass.Deinitialize;
import helpClass.GetBatches;
import helpClass.GetWorkflows;
import helpClass.Initialize;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class GetBatchesTest {

    static  Initialize initialize;
    static InitializePOJO pojo;
    static GetWorkflows getWorkflows;
    static InitializePOJO getWorkflowsPojo;

    static GetBatches getBatches;
    static InitializePOJO getBatchesPOJO;


    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;

    @BeforeMethod
    public void Intitalize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();
        getWorkflows =new GetWorkflows(pojo.getCookie());
        getWorkflowsPojo =getWorkflows.getWorkflowsMethod();

    }


    @Test
    public void GetBatches(){
        // необходимо указать параметры Name и Guid для конкретного Workflow
        // Attention!!!!! Customs parameters
        getBatches = new GetBatches(pojo.getCookie(),getWorkflowsPojo.getMapMap().get("1").get("WorkflowGuid"));
        getBatchesPOJO = getBatches.getBatchesMethod("0","1");
       Assert.assertEquals(getBatchesPOJO.getDocAlphaResponseCode(),"101");
        System.out.println("getBatchesPOJO = " + getBatchesPOJO.toString());


    }

    //Deinitialize
    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(), "101");
        // System.out.println("End Deinitialize at " + new Date());
    }

}