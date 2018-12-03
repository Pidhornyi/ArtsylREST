package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class CreateBatch {


    private Cookies cookies;
    private String guidWorkflow;
    public CreateBatch(Cookies cookies, String guidWorkflow){
        this.cookies=cookies;
        this.guidWorkflow = guidWorkflow;
    }

    public InitializePOJO createBatchMethod() {
        System.out.println(" Start CreateBatch Help Class");
        Reporter.log(" Start CreateBatch Help Class");
        String nameMethod = InitializePOJO.getCreateBatchResult();


        URLMethods methods = new URLMethods();
        String url = methods.getUrlCreateBatch(guidWorkflow);
        Reporter.log(url);
        System.out.println(url);


        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        Reporter.log("End CreateBatch Help Class");
        System.out.println("End CreateBatch Help Class");
        return pojo;
    }

}
