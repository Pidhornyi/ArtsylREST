package helpClass;

import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import org.testng.Assert;
import org.testng.annotations.Test;


import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;


public class Initialize {


  public  InitializePOJO InitializeHelpMethod() {
        String nameMethood = "InitializeResult";
        URLMethods methodsUrl = new URLMethods();
        String url = methodsUrl.getUrlInitialize();
        System.out.println("Start Initialize Help Class");

        Response response = get(url);
        GSONparser gsoNparser = new GSONparser(response,nameMethood);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("Response Code = " + pojo.getReturnedValue());
        System.out.println("End Initialize Help Class/  pojo = " +  pojo);
        return pojo;
       // Assert.assertEquals(pojo.getDocAlphaResponseCode(),"101");

        //Test Workflow



    }
}
