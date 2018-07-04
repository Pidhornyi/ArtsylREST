package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class GetBatchDocuments {

    private Cookies cookies;

    public GetBatchDocuments(Cookies cookies) {
        this.cookies = cookies;

    }


    public InitializePOJO GetBatchDocumentsMethod() {
        System.out.println("GetBatchDocuments Help Class");

        String nameMethod = InitializePOJO.getGetBatchDocumentsResult();


        URLMethods methods = new URLMethods();
        String url = methods.getUrlGetBatchDocuments();

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End GetBatchDocuments Help Class");
        return pojo;
    }



}
