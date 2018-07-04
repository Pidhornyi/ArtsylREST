package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import main.java.pojo.InitializePOJO;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.given;

public class GetDocumentPage {



        private String documantsGuid;
        private Cookies cookies;
        private String page;
        public GetDocumentPage(Cookies cookies, String documentsGuid, String page){
            this.page=page;
            this.cookies=cookies;
            this.documantsGuid=documentsGuid;
        }

        public InitializePOJO getDocumentPageMethod(){
            System.out.println("Start GetDocumentPage Help Class");
            Reporter.log("Start GetDocumentPage Help Class");

            String nameMethod = InitializePOJO.getGetDocumentPageResult();


            URLMethods methods = new URLMethods();
            String urlGetDocumentPage = methods.getUrlGetDocumentPage(documantsGuid, page);
            //System.out.println(urlGetDocumentPage);
            Reporter.log(urlGetDocumentPage);
            // Запрос вместе с подставленной cookie
            Response getGetDocumentPage = given().cookie(String.valueOf(cookies)).when().get(urlGetDocumentPage);

            GSONparser jsoNparseGetDocumentPage = new GSONparser(getGetDocumentPage, nameMethod);
            InitializePOJO pojoGetDocumentPage = jsoNparseGetDocumentPage.parser();

            System.out.println("End GetDocumentPage Help Class");
            Reporter.log("End GetDocumentPage Help Class");
            return pojoGetDocumentPage;
        }


}
