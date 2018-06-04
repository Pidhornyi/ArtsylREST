package tests.positive;

import helpClass.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

public class LoadBatchByGuidTest {


    static Initialize initialize ;
    static InitializePOJO pojo ;

    static GetWorkflows getWorkflows;
    static InitializePOJO getWorkflowPOJO;

    static GetBatches getBatches;
    static InitializePOJO getBathcesPOJO;

    static LoadBatchByGuid loadBatchByGuid;
    static InitializePOJO loadBatchByGuidPOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void Initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

        getWorkflows = new GetWorkflows(pojo.getCookie());
        getWorkflowPOJO = getWorkflows.getWorkflowsMethod();

        getBatches = new GetBatches(pojo.getCookie(),getWorkflowPOJO.getMap().get("TEST_REST_API").get("Guid"));
        getBathcesPOJO = getBatches.getBatchesMethod("0","0");


    }

    @Test
    public void GetBatchesForEditing(){


        // необходимо указать id батча готового к редактированию (get("2"))
       loadBatchByGuid = new LoadBatchByGuid(pojo.getCookie(),getBathcesPOJO.getMap().get("2").get("BatchGuid"));
       loadBatchByGuidPOJO = loadBatchByGuid.LoadBatchByGuidMethod();
        Assert.assertEquals(loadBatchByGuidPOJO.getDocAlphaResponseCode(),"101");


    }


    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize = new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("End Deinitialize at : " + new Date());

    }


}
