package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class AddBatchMetadata {

    private Cookies cookies;
    private String name;
    private String value;
    public AddBatchMetadata(Cookies cookies, String nameBatch, String value){
        this.cookies=cookies;
        this.name=nameBatch;
        this.value=value;
    }


    public InitializePOJO AddBatchMetadataMethod() {
        System.out.println("AddBatchMetadata Help Class");

        String nameMethod = "AddBatchMetadataResult";


        URLMethods methods = new URLMethods();
        String url = methods.getUrlAddBatchMetadata(name , value);


        Response response = given().cookie(String.valueOf(cookies)).when().get(url);

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End AddBatchMetadata Help Class");
        return pojo;
    }



}
