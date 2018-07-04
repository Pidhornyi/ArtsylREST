package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class GetWorkflows {

    private Cookies cookies;
    public GetWorkflows(Cookies cookies){

        this.cookies=cookies;
    }

    public InitializePOJO getWorkflowsMethod(){
        System.out.println("Start GetWorkflows Help Class");
        Reporter.log("Start GetWorkflows Help Class");

        String nameMethod = InitializePOJO.getGetWorkflowsResult();


        URLMethods methods = new URLMethods();
        String urlWorkflow = methods.getUrlGetWorkflows();
        System.out.println(urlWorkflow);
        Reporter.log(urlWorkflow);
        // Запрос вместе с подставленной cookie
        Response getworkflows = given().cookie(String.valueOf(cookies)).when().get(urlWorkflow);
        GSONparser jsoNparseWorkflow = new GSONparser(getworkflows, nameMethod);
        InitializePOJO pojoWorkflows = jsoNparseWorkflow.parser();


        System.out.println("End GetWorkflows Help Class");
        Reporter.log("End GetWorkflows Help Class");

        return pojoWorkflows;
    }
}
