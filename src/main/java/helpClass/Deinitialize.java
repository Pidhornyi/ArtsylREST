package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;

import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class Deinitialize {
    private Cookies cookies;
    public Deinitialize(Cookies cookies){
        this.cookies=cookies;
    }
     public InitializePOJO deinitializeMethod() {
         System.out.println("Start Deinitialize Help Class");
         Reporter.log("Start Deinitialize Help Class");
         String nameMethod = InitializePOJO.getDeinitializeResult();

        URLMethods methods = new URLMethods();
        String url = methods.getUrlDeinitialize();
        Reporter.log(url);
         System.out.println(url);

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);
         GSONparser gsoNparser = new GSONparser(response,nameMethod);
         InitializePOJO pojo = gsoNparser.parser();

         Reporter.log("End Deinitialize Help Class");
         System.out.println("End Deinitialize Help Class");
        return pojo;


    }
}
