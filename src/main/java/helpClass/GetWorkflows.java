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

    public InitializePOJO getWorkflowsMethod(){

        String nameMethod = InitializePOJO.getGetWorkflowsResult();


        URLMethods methods = new URLMethods();
        String urlWorkflow = methods.getUrlGetWorkflows();
        System.out.println(urlWorkflow);
        // Запрос вместе с подставленной cookie
        Response getworkflows = given().cookie(String.valueOf(cookies)).when().get(urlWorkflow);
        GSONparser jsoNparseWorkflow = new GSONparser(getworkflows, nameMethod);
        InitializePOJO pojoWorkflows = jsoNparseWorkflow.parser();


        return pojoWorkflows;
    }
}
