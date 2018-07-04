package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class GetBatchesForEditing {

    private Cookies cookies;
    public GetBatchesForEditing(Cookies cookies){
        this.cookies=cookies;
    }

    public InitializePOJO GetBatchesForEditingMethod() {
        System.out.println("Start GetBatchesForEditingTest Help Class");
        Reporter.log("Start GetBatchesForEditingTest Help Class");

        String nameMethod = InitializePOJO.getGetBatchesForEditingResult();


        URLMethods methods = new URLMethods();

        String url = methods.getUrlGetBatchesForEditing("0","0");
        System.out.println(url);
        Reporter.log(url);
        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End GetBatchesForEditing Help Class");
        Reporter.log("End GetBatchesForEditing Help Class");
        return pojo;
    }

}
