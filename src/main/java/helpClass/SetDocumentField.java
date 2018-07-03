package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

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


        String nameMethod = InitializePOJO.getSetDocumentFieldResult();


        URLMethods methods = new URLMethods();
        String urlSetDocumentField = methods.getUrlSetDocumentField(documantsGuid,fieldGuid,fieldValue);
        System.out.println(urlSetDocumentField);

        // Запрос вместе с подставленной cookie
        Response setDocumentComment = given().cookie(String.valueOf(cookies)).when().get(urlSetDocumentField);
        GSONparser jsoNparseSetDocumentField = new GSONparser(setDocumentComment, nameMethod);
        InitializePOJO pojoSetDocumentField = jsoNparseSetDocumentField.parser();


        return pojoSetDocumentField;
    }




}
