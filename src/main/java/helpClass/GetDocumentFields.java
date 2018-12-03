package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class GetDocumentFields {

    private String documantsGuid;
    private Cookies cookies;
    public GetDocumentFields(Cookies cookies, String documentsGuid){

        this.cookies=cookies;
        this.documantsGuid=documentsGuid;
    }

    public InitializePOJO getDocumentFieldsMethod(){
        System.out.println("Start GetDocumentFields Help Class");
        Reporter.log("Start GetDocumentFields Help Class");

        String nameMethod = InitializePOJO.getGetDocumentFieldsResult();


        URLMethods methods = new URLMethods();
        String urlGetDocumentFields = methods.getUrlGetDocumentFields( documantsGuid);
        System.out.println(urlGetDocumentFields);

        Reporter.log(urlGetDocumentFields);

        // Запрос вместе с подставленной cookie
        Response getGetDocumentFields = given().cookie(String.valueOf(cookies)).when().get(urlGetDocumentFields);
        GSONparser jsoNparseGetDocumentFields = new GSONparser(getGetDocumentFields, nameMethod);
        InitializePOJO pojoGetDocumentFields = jsoNparseGetDocumentFields.parser();

        System.out.println("End GetDocumentFields Help Class");
        Reporter.log("End GetDocumentFields Help Class");
        return pojoGetDocumentFields;
    }



}
