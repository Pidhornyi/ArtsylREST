package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class GetBatches {


    private String workFlowGuid;
    private Cookies cookies;
    public GetBatches(Cookies cookies, String guid){

         this.cookies=cookies;
         this.workFlowGuid=guid;
    }

    public InitializePOJO getBatchesMethod(String takeFrom, String count){
        System.out.println("Start GetBatches Help Class");
        Reporter.log("Start GetBatches Help Class");
        String nameMethod = InitializePOJO.getGetBatchesResult();


        URLMethods methods = new URLMethods();
        String urlGetBatches = methods.getUrlGetBatches( takeFrom, count, workFlowGuid);
        System.out.println(urlGetBatches);
        Reporter.log(urlGetBatches);

        // Запрос вместе с подставленной cookie
        Response getBatches = given().cookie(String.valueOf(cookies)).when().get(urlGetBatches);
        GSONparser jsoNparseGetBatches = new GSONparser(getBatches, nameMethod);
        InitializePOJO pojoGetBatches = jsoNparseGetBatches.parser();

        Reporter.log("End GetBatches Help Class");
        return pojoGetBatches;
    }


}
