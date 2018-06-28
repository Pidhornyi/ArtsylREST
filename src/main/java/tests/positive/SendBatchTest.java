package tests.positive;

import helpClass.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

public class SendBatchTest {

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


    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;

    //Initialize
    @BeforeMethod
    public void Initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();


        getWorkflows = new GetWorkflows(pojo.getCookie());
        getWorkflowPOJO = getWorkflows.getWorkflowsMethod();

        createBatch = new CreateBatch(pojo.getCookie(), getWorkflowPOJO.getMapMap().get("1").get("WorkflowGuid"));
        createBatchPOJO = createBatch.createBatchMethod();

        addBatchImage = new AddBatchImage(pojo.getCookie());
        addBatchImagePOJO = addBatchImage.AddBatchImageMethod();
    }


    @Test
    public void SendBatch(){
        System.out.println("Start SendBatch Test at : " + new Date());

        sendBatch = new SendBatch(pojo.getCookie());
        sendBatchPOJO = sendBatch.sendBatchMethod();
        System.out.println("massage = " + sendBatchPOJO.getMessage());
        Assert.assertEquals(sendBatchPOJO.getDocAlphaResponseCode(), "101");
        System.out.println("End Reinitialize Test at : " + new Date());
    }




    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(), "101");
        System.out.println("End Deinitialize at " + new Date());
    }

}