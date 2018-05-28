package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class GetWorkflows {

    private Cookies cookies;
    public GetWorkflows(Cookies cookies){

        this.cookies=cookies;
    }

    public InitializePOJO InitializeHelpMethod(){

        String nameMethood = "GetWorkflowsResult";


        URLMethods methods = new URLMethods();
        String urlWorkflow = methods.getUrlGetWorkflows();

        // Запрос вместе с подставленной cookie
        Response getworkflow = given().cookie(String.valueOf(cookies)).when().get(urlWorkflow);
        GSONparser jsoNparseWorkflow = new GSONparser(getworkflow, nameMethood);
        InitializePOJO pojoWorkflow = jsoNparseWorkflow.parser();


        return pojoWorkflow;
    }
}
