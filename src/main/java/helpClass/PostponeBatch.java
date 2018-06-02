package helpClass;




//Can be called only to new batch

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class PostponeBatch {

    private Cookies cookies;

    public PostponeBatch(Cookies cookies) {
        this.cookies = cookies;

    }


    public InitializePOJO postponeBatchMethod() {
        System.out.println("PostponeBatch Help Class");

        String nameMethod = "PostponeBatchResult";


        URLMethods methods = new URLMethods();
        String url = methods.getUrlPostponeBatch();

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End PostponeBatch Help Class");
        return pojo;
    }
}
