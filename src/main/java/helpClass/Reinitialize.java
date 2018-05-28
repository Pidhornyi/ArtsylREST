package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class Reinitialize {
    private String ReturnedValue;
    private Cookies cookies;
    public Reinitialize(Cookies cookies, String ReturnedValue){
        this.ReturnedValue=ReturnedValue;
        this.cookies=cookies;
    }

    public InitializePOJO reinitialize(){
        System.out.println("Start Reinitialize Help Class");
        String nameMethood = "ReinitializeResult";


        String url = URLMethods.getUrlReinitialize(ReturnedValue);
        System.out.println(url);

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);
        GSONparser gsoNparser = new GSONparser(response,nameMethood);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End Reinitialize Help Class");
        return pojo;
    }
}
