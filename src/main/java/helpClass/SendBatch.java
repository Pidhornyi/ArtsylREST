package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class SendBatch {


    private Cookies cookies;

    public SendBatch(Cookies cookies) {
        this.cookies = cookies;

    }


    public InitializePOJO sendBatchMethod() {
        System.out.println("Start SendBatch Help Class");
        Reporter.log("Start SendBatch Help Class");

        String nameMethod = InitializePOJO.getSendBatchResult();


        URLMethods methods = new URLMethods();
        String url = methods.getUrlSendBatch();
        System.out.println(url);
        Reporter.log(url);
        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End SendBatch Help Class");
        Reporter.log("End SendBatch Help Class");
        return pojo;
    }

}
