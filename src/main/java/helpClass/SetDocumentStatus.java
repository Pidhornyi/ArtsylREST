package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class SetDocumentStatus {




    private String documantsGuid;
    private String flagValue;
    private Cookies cookies;
    private String statusValue;

    public SetDocumentStatus(Cookies cookies, String documentsGuid, String flagValue, String statusValue){

        this.flagValue=flagValue;
        this.cookies=cookies;
        this.documantsGuid=documentsGuid;
        this.statusValue=statusValue;
    }

    public InitializePOJO SetDocumentStatusMethod(){


        String nameMethod = InitializePOJO.getSetDocumentStatusResult();


        URLMethods methods = new URLMethods();
        String urlSetDocumentStatus = methods.getUrlSetDocumentStatus(documantsGuid,flagValue,statusValue);
        System.out.println(urlSetDocumentStatus);

        // Запрос вместе с подставленной cookie
        Response setDocumentStatus = given().cookie(String.valueOf(cookies)).when().get(urlSetDocumentStatus);
        GSONparser jsoNparseSetDocumentStatus = new GSONparser(setDocumentStatus, nameMethod);
        InitializePOJO pojoSetDocumentStatus = jsoNparseSetDocumentStatus.parser();


        return pojoSetDocumentStatus;
    }



}
