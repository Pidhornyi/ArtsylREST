package helpClass;


import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.get;


public class Test {

    public static void main(String args[]){

        URLMethods methods = new URLMethods();
        String dein = methods.getUrlDeinitialize();

        Response res = get(dein);

        GSONparser gsoNparser = new GSONparser(res,"DeinitializeResult");
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println( pojo);

    }
}
