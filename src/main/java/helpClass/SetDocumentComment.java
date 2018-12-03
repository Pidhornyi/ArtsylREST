package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class SetDocumentComment {



    private String documantsGuid;
    private Cookies cookies;
    private String comment;
    public SetDocumentComment(Cookies cookies, String documentsGuid, String comment){
        this.comment=comment;
        this.cookies=cookies;
        this.documantsGuid=documentsGuid;
    }

    public InitializePOJO setDocumentCommentMethod(){

        System.out.println("Start SetDocumentComment Help Class");
        Reporter.log("Start SetDocumentComment Help Class");

        String nameMethod = InitializePOJO.getSetDocumentCommentResult();


        URLMethods methods = new URLMethods();
        String urlSetDocumentComment = methods.getUrlSetDocumentComment(documantsGuid, comment);
        System.out.println(urlSetDocumentComment);
        Reporter.log(urlSetDocumentComment);

        // Запрос вместе с подставленной cookie
        Response setDocumentComment = given().cookie(String.valueOf(cookies)).when().get(urlSetDocumentComment);
        GSONparser jsoNparsesetDocumentComment = new GSONparser(setDocumentComment, nameMethod);
        InitializePOJO pojoSetDocumentComment = jsoNparsesetDocumentComment.parser();

        System.out.println("End SetDocumentComment Help Class");
        Reporter.log("End SetDocumentComment Help Class");
        return pojoSetDocumentComment;
    }




}
