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

import java.util.Date;

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
        getWorkflowsPojo =getWorkflows.InitializeHelpMethodGetWorkflows();

    }


    @Test
    public void GetBatches(){

        getBatches = new GetBatches(pojo.getCookie(),getWorkflowsPojo.getMap().get("TEST_REST_API").get("Guid"));
        System.out.println(getWorkflowsPojo.getMap().get("TEST_REST_API").get("Guid"));

        getBatchesPOJO = getBatches.getBatchesMethood("0","1");
       // Assert.assertEquals(getBatchesPOJO.getDocAlphaResponseCode(),"101");
        //System.out.println("getBatchesPOJO = " + getBatchesPOJO.toString());


    }




    //Deinitialize
    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitialize();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(), "101");
        // System.out.println("End Deinitialize at " + new Date());
    }

}
