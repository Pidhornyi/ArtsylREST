package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import pojo.InitializePOJO;

import java.util.Date;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class Deinitialize {
    private Cookies cookies;
    public Deinitialize(Cookies cookies){
        this.cookies=cookies;
    }

     public InitializePOJO deinitializeMethod() {
         System.out.println("Start Deinitialize Help Class");

        String nameMethod = "DeinitializeResult";


        URLMethods methods = new URLMethods();
        String url = methods.getUrlDeinitialize();


        Response response = given().cookie(String.valueOf(cookies)).when().get(url);
         GSONparser gsoNparser = new GSONparser(response,nameMethod);
         InitializePOJO pojo = gsoNparser.parser();
         System.out.println("End Deinitialize Help Class");
        return pojo;


    }
}
