package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class Deinitialize {
    private Cookies cookies;
    public Deinitialize(Cookies cookies){
        this.cookies=cookies;
    }

     public InitializePOJO deinitialize() {
         System.out.println("Start Deinitialize Help Class");

        String nameMethood = "DeinitializeResult";


        URLMethods methods = new URLMethods();
        String url = methods.getUrlDeinitialize();


        Response response = given().cookie(String.valueOf(cookies)).when().get(url);
         GSONparser gsoNparser = new GSONparser(response,nameMethood);
         InitializePOJO pojo = gsoNparser.parser();
         System.out.println("End Deinitialize Help Class");
        return pojo;
    }
}
