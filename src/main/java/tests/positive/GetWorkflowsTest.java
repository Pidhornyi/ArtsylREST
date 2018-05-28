package tests.positive;

import com.jayway.restassured.response.Response;
import helpClass.Deinitialize;
import helpClass.GSONparser;
import helpClass.Initialize;
import helpClass.URLMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

import static com.jayway.restassured.RestAssured.given;

public class GetWorkflowsTest {

    @Test
    public void getWorkflowMethood() {
        System.out.println("Start Workflow Test at " + new Date());
        String nameMethood = "GetWorkflowsResult";

        Initialize initialize = new Initialize();
        InitializePOJO pojo = initialize.InitializeHelpMethod();

        URLMethods methods = new URLMethods();
        String urlWorkflow = methods.getUrlGetWorkflows();

        // Запрос вместе с подставленной cookie
        Response getworkflow = given().cookie(String.valueOf(pojo.getCookie())).when().get(urlWorkflow);
        GSONparser jsoNparseWorkflow = new GSONparser(getworkflow, nameMethood);
        InitializePOJO pojoWorkflow = jsoNparseWorkflow.parser();
        System.out.println("Message " + pojoWorkflow.getMessage());
        System.out.println("responseCode " + pojoWorkflow.getDocAlphaResponseCode());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(),"101");
        System.out.println("End Workflow Test at " + new Date());
        System.out.println("Test passed ");
        //System.out.println(pojoWorkflow.getMap().get("ForRestAPI").get("Guid"));

        System.out.println("Start Deinitialize at : " + new Date());
        Deinitialize deinitialize = new Deinitialize(pojo.getCookie());
        deinitialize.deinitialize();
        System.out.println("End Deinitialize at : " + new Date());


    }
}