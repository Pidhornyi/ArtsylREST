package tests.REST.positive;

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
3)GetBatchesForEditing
4)Deinitialize
 */

public class GetBatchesForEditingTest {


    static Initialize initialize ;
    static InitializePOJO pojo ;

    static GetWorkflows getWorkflows;
    static InitializePOJO getWorkflowPOJO;

    static GetBatchesForEditing getBatchesForEditing;
    static InitializePOJO getBatchesForEditingPOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

        getWorkflows = new GetWorkflows(pojo.getCookie());
        getWorkflowPOJO = getWorkflows.getWorkflowsMethod();


    }

    @Test
    public void getBatchesForEditing(){

        getBatchesForEditing = new GetBatchesForEditing(pojo.getCookie());
        getBatchesForEditingPOJO = getBatchesForEditing.GetBatchesForEditingMethod();
        Assert.assertEquals(getBatchesForEditingPOJO.getDocAlphaResponseCode(),"101");


    }


    @AfterMethod
    public void deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize = new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("End Deinitialize at : " + new Date());

    }

}
