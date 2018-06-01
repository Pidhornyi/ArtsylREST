package tests.positive;

import com.jayway.restassured.response.Response;
import helpClass.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

import static com.jayway.restassured.RestAssured.given;

public class GetWorkflowsTest {

    static Initialize initialize ;
    static InitializePOJO pojo ;

    static GetWorkflows getWorkflows;
    static InitializePOJO getWorkflowPOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;

    @BeforeMethod
    public void Initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();
    }

    @Test
    public void getWorkflowMethood() {
        System.out.println("Start Workflow Test at " + new Date());

        getWorkflows = new GetWorkflows(pojo.getCookie());
        getWorkflowPOJO = getWorkflows.InitializeHelpMethodGetWorkflows();

        System.out.println("Message " + getWorkflowPOJO.getMessage());
        System.out.println("responseCode " + getWorkflowPOJO.getDocAlphaResponseCode());
        Assert.assertEquals(getWorkflowPOJO.getDocAlphaResponseCode(),"101");

        System.out.println( "!!! getWorkflowPOJO =" + getWorkflowPOJO.toString());
        System.out.println( "!!! getWorkflowPOJO =" + getWorkflowPOJO.getDocAlphaResponseCode());
        System.out.println( "!!! getWorkflowPOJO =" + getWorkflowPOJO.getMessage());
        System.out.println( "!!! getWorkflowPOJO =" + getWorkflowPOJO.getReturnedValue());
        System.out.println( "!!! getWorkflowPOJO =" + getWorkflowPOJO.getMap().keySet());
        System.out.println( "!!! getWorkflowPOJO =" + getWorkflowPOJO.getMap().get("ForRestTest").get("Guid"));
        System.out.println( "!!! getWorkflowPOJO =" + getWorkflowPOJO.getDocAlphaResponseCode());
        System.out.println("End Workflow Test at " + new Date());
        System.out.println("Test passed ");

    }

    //Deinitialize
    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitialize();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(deinitializePOJO.getDocAlphaResponseCode(), "101");
        System.out.println("End Deinitialize at " + new Date());
    }
}