package tests.positive;

import helpClass.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

public class AddBatchImageTest {

    static Initialize initialize ;
    static InitializePOJO pojo ;

    static GetWorkflows getWorkflows;
    static InitializePOJO getWorkflowPOJO;

    static CreateBatch createBatch;
    static InitializePOJO createBatchPOJO;

    static AddBatchImage addBatchImage;
    static InitializePOJO addBatchImagePOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void Initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

        getWorkflows = new GetWorkflows(pojo.getCookie());
        getWorkflowPOJO = getWorkflows.getWorkflowsMethod();

        createBatch = new CreateBatch(pojo.getCookie(), getWorkflowPOJO.getMap().get("TEST_REST_API").get("Guid"));
        createBatchPOJO = createBatch.createBatchMethod();
    }

    @Test
    public void addBatchImageTestMethod(){

        addBatchImage = new AddBatchImage(pojo.getCookie(), getWorkflowPOJO.getMap().get("TEST_REST_API").get("Guid"));
        addBatchImagePOJO = addBatchImage.AddBatchImageMethod();

    }


    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize = new Deinitialize(pojo.getCookie());
        deinitialize.deinitializeMethod();
        System.out.println("End Deinitialize at : " + new Date());

    }

}
