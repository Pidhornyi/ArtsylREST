package helpClass;

import com.jayway.restassured.response.Response;
import org.testng.Reporter;

import pojo.InitializePOJO;


import static com.jayway.restassured.RestAssured.get;



public class Initialize {


  public  InitializePOJO InitializeHelpMethod() {
        System.out.println("Start Initialize Help Class");
        Reporter.log("Start Initialize Help Class");
        String nameMethod = InitializePOJO.getInitializeResult();
        URLMethods methodsUrl = new URLMethods();
        String url = methodsUrl.getUrlInitialize();
        System.out.println(url);
        Reporter.log(url);



        Response response = get(url);
        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("Response Code = " + pojo.getReturnedValue());
        Reporter.log("Response Code = " + pojo.getReturnedValue());

        System.out.println("End Initialize Help Class" );
        Reporter.log("End Initialize Help Class");
        return pojo;


        //Test Workflow



    }
}
