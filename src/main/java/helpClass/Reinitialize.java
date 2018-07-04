package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class Reinitialize {
    private String ReturnedValue;
    private Cookies cookies;
    public Reinitialize(Cookies cookies, String ReturnedValue){
        this.ReturnedValue=ReturnedValue;
        this.cookies=cookies;
    }

    public InitializePOJO reinitializeMethod(){
        System.out.println("Start Reinitialize Help Class");
        Reporter.log("Start Reinitialize Help Class");
        String nameMethod = InitializePOJO.getReinitializeResult();

        URLMethods methods = new URLMethods();
        String url = methods.getUrlReinitialize(ReturnedValue);
        System.out.println(url);
        Reporter.log(url);

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);
        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End Reinitialize Help Class");
        Reporter.log("End Reinitialize Help Class");
        return pojo;
    }
}
