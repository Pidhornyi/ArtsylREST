package helpClass;




//Can be called only to new batch

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class PostponeBatch {

    private Cookies cookies;

    public PostponeBatch(Cookies cookies) {
        this.cookies = cookies;

    }


    public InitializePOJO postponeBatchMethod() {
        System.out.println("Start PostponeBatch Help Class");
        Reporter.log("Start PostponeBatch Help Class");

        String nameMethod = InitializePOJO.getPostponeBatchResult();


        URLMethods methods = new URLMethods();
        String url = methods.getUrlPostponeBatch();
        Reporter.log(url);
        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End PostponeBatch Help Class");
        Reporter.log("End PostponeBatch Help Class");
        return pojo;
    }
}
