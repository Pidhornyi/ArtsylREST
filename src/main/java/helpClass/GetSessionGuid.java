package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class GetSessionGuid {

    private Cookies cookies;
    public GetSessionGuid(Cookies cookies){
        this.cookies=cookies;
    }

    public InitializePOJO GetSessionGuidMethud() {
        System.out.println("Start GetSessionGuid Help Class");

        String nameMethood = "GetSessionGuidResult";


        URLMethods methods = new URLMethods();
        String url = methods.getUrlGetSessionGuid();


        Response response = given().cookie(String.valueOf(cookies)).when().get(url);
        GSONparser gsoNparser = new GSONparser(response,nameMethood);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End Deinitialize Help Class");
        return pojo;
    }
}
