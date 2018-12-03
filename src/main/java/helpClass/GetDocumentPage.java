package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;
import org.testng.Reporter;

import java.io.*;

import static com.jayway.restassured.RestAssured.get;
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

        public String getDocumentPageMethod(){
            System.out.println("Start GetDocumentPage Help Class");
            Reporter.log("Start GetDocumentPage Help Class");

            String nameMethod = InitializePOJO.getGetDocumentPageResult();


            URLMethods methods = new URLMethods();
            String urlGetDocumentPage = methods.getUrlGetDocumentPage(documantsGuid, page);
            //System.out.println(urlGetDocumentPage);
            Reporter.log(urlGetDocumentPage);
            // Запрос вместе с подставленной cookie

            Response getGetDocumentPage = given().cookie(String.valueOf(cookies)).when().get(urlGetDocumentPage);
            //getGetDocumentPage.contentType().getBytes();
           InputStream f = getGetDocumentPage.getBody().asInputStream();
          // String headers= getGetDocumentPage.headers().toString();
          String length = String.valueOf(getGetDocumentPage.headers().get("Content-Length")).replaceFirst("(?i)^.*Content-Length=\"?([^\"]+)\"?.*$", "$1");
           String filiname = String.valueOf(getGetDocumentPage.headers().get("Content-Disposition")).replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
            System.out.println(length);
            System.out.println(filiname);

            FileOutputStream fos = null;
            try {
                int nRead;
                int i=0;
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();

                byte[] data = new byte[Integer.valueOf(length)];
                while ((nRead = f.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                fos = new FileOutputStream(new File("someFile.png"));

                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //GSONparser jsoNparseGetDocumentPage = new GSONparser(getGetDocumentPage, nameMethod);
            //InitializePOJO pojoGetDocumentPage = jsoNparseGetDocumentPage.parser();

            //System.out.println(headers);

            System.out.println("End GetDocumentPage Help Class");
            Reporter.log("End GetDocumentPage Help Class");
            return "test";
        }


}
