package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class SetDocumentField {




    private String documantsGuid;
    private String fieldGuid;
    private Cookies cookies;
    private String fieldValue;

    public SetDocumentField(Cookies cookies, String documentsGuid, String fieldGuid, String fieldValue){

        this.fieldValue=fieldValue;
        this.cookies=cookies;
        this.documantsGuid=documentsGuid;
        this.fieldGuid=fieldGuid;
    }

    public InitializePOJO setDocumentFieldMethod(){

        System.out.println("Start SetDocumentField Help Class");
        Reporter.log("Start SetDocumentField Help Class");


        String nameMethod = InitializePOJO.getSetDocumentFieldResult();


        URLMethods methods = new URLMethods();
        String urlSetDocumentField = methods.getUrlSetDocumentField(documantsGuid,fieldGuid,fieldValue);
        System.out.println(urlSetDocumentField);
        Reporter.log(urlSetDocumentField);

        // Запрос вместе с подставленной cookie
        Response setDocumentComment = given().cookie(String.valueOf(cookies)).when().get(urlSetDocumentField);
        GSONparser jsoNparseSetDocumentField = new GSONparser(setDocumentComment, nameMethod);
        InitializePOJO pojoSetDocumentField = jsoNparseSetDocumentField.parser();

        System.out.println("End SetDocumentField Help Class");
        Reporter.log("End SetDocumentField Help Class");
        return pojoSetDocumentField;
    }




}
