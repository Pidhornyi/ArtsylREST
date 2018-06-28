package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class LoadBatchByGuid {


    private Cookies cookies;
    private String guidBatch;
    public LoadBatchByGuid(Cookies cookies, String guidBatch){
        this.cookies=cookies;
        this.guidBatch = guidBatch;
    }

    public InitializePOJO LoadBatchByGuidMethod() {
        System.out.println("LoadBatchByGuid Help Class");

        String nameMethod = InitializePOJO.getLoadBatchByGuidResult();


        URLMethods methods = new URLMethods();
        String url = methods.getUrlLoadBatchByGuid(guidBatch);
        System.out.println(url);

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End LoadBatchByGuid Help Class");
        return pojo;
    }


}
