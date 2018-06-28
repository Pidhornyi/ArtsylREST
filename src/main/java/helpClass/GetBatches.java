package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class GetBatches {


    private String workFlowGuid;
    private Cookies cookies;
    public GetBatches(Cookies cookies, String guid){

         this.cookies=cookies;
         this.workFlowGuid=guid;
    }

    public InitializePOJO getBatchesMethod(String takeFrom, String count){


        String nameMethod = InitializePOJO.getGetBatchesResult();


        URLMethods methods = new URLMethods();
        String urlGetBatches = methods.getUrlGetBatches( takeFrom, count, workFlowGuid);
        System.out.println(urlGetBatches);

        // Запрос вместе с подставленной cookie
        Response getBatches = given().cookie(String.valueOf(cookies)).when().get(urlGetBatches);
        GSONparser jsoNparseGetBatches = new GSONparser(getBatches, nameMethod);
        InitializePOJO pojoGetBatches = jsoNparseGetBatches.parser();


        return pojoGetBatches;
    }


}
