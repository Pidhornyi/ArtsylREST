package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class GetSessionGuid {

    private Cookies cookies;
    public GetSessionGuid(Cookies cookies){
        this.cookies=cookies;
    }

    public InitializePOJO GetSessionGuidMethod() {
        System.out.println("Start GetSessionGuid Help Class");
        Reporter.log("Start GetSessionGuid Help Class");
        String nameMethod = InitializePOJO.getGetSessionGuidResult();


        URLMethods methods = new URLMethods();
        String url = methods.getUrlGetSessionGuid();
        System.out.println(url);
        Reporter.log(url);

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End GetSessionGuid Help Class");
        Reporter.log("End GetSessionGuid Help Class");
        return pojo;
    }
}
