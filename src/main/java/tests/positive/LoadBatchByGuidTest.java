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

        for(int i=0;i<getWorkflowPOJO.getMapMap().size();i++){
            String temp = String.valueOf(i);
            System.out.println(" i = "+temp);
            System.out.println(" true/false = "+getWorkflowPOJO.getMapMap().get(temp).get("WorkflowName").equals("TEST_REST_API"));
            System.out.println(getWorkflowPOJO.getMapMap().get(temp).get("WorkflowName"));
            if(getWorkflowPOJO.getMapMap().get(temp).get("WorkflowName").equals("TEST_REST_API")){
                getBatches = new GetBatches(pojo.getCookie(),getWorkflowPOJO.getMapMap().get(temp).get("WorkflowGuid"));

                System.out.println(" ii = "+getWorkflowPOJO.getMapMap().get(temp).get("WorkflowGuid"));
            }

        }

        getBathcesPOJO = getBatches.getBatchesMethod("0","1");


    }

    @Test
    public void LoadBatchByGuid(){


        // необходимо указать id батча готового к редактированию (get("2"))
        for (int i =0;i<getBathcesPOJO.getMapMap().size();i++) {
            if (getBathcesPOJO.getMapMap().get(String.valueOf(i)).get(InitializePOJO.getBatchOwnerStationName()).equals("0")) {
               // System.out.println(getBathcesPOJO.getMapMap().get(String.valueOf(i)).get(InitializePOJO.getBatchOwnerStationName()));
               // System.out.println(getBathcesPOJO.getMapMap().get(String.valueOf(i)).get(InitializePOJO.getBatchId()));
              //  String temp = getBathcesPOJO.getMapMap().get(String.valueOf(i)).get(InitializePOJO.getBatchOwnerStationName());

                if ( getBathcesPOJO.getMapMap().get(String.valueOf(i)).get(InitializePOJO.getDocumentsCount())!="0") {
                    loadBatchByGuid = new LoadBatchByGuid(pojo.getCookie(), getBathcesPOJO.getMapMap().get(String.valueOf(i)).get("BatchGuid"));
                    break;
                }
            }
        }

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