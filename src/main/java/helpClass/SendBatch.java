package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class SendBatch {


    private Cookies cookies;

    public SendBatch(Cookies cookies) {
        this.cookies = cookies;

    }


    public InitializePOJO sendBatchMethod() {
        System.out.println("SendBatch Help Class");

        String nameMethod = "SendBatchResult";


        URLMethods methods = new URLMethods();
        String url = methods.getUrlSendBatch();

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End SendBatch Help Class");
        return pojo;
    }

}
