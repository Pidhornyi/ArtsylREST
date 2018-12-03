package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class AddBatchMetadata {

    private Cookies cookies;
    private String name;
    private String value;
    public AddBatchMetadata(Cookies cookies, String name, String value){
        this.cookies=cookies;
        this.name=name;
        this.value=value;
    }


    public InitializePOJO AddBatchMetadataMethod() {
        System.out.println(" Start AddBatchMetadata Help Class");
        Reporter.log(" Start AddBatchMetadata Help Class");

        String nameMethod = InitializePOJO.getAddBatchMetadataResult();


        URLMethods methods = new URLMethods();
        String url = methods.getUrlAddBatchMetadata(name , value);
        Reporter.log(url);
        System.out.println(url);

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        Reporter.log("End AddBatchMetadata Help Class");
        System.out.println("End AddBatchMetadata Help Class");
        return pojo;
    }



}
