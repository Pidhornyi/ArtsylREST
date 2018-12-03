package helpClass;

import com.jayway.restassured.internal.RestAssuredResponseImpl;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;

import org.omg.CORBA.Request;
import pojo.InitializePOJO;
import org.testng.Reporter;


import java.io.*;



import static com.jayway.restassured.RestAssured.given;

public class AddBatchImage {



    private Cookies cookies;

    public File file;

    public AddBatchImage(Cookies cookies){
        this.cookies=cookies;

    }

    public InitializePOJO AddBatchImageMethod() {
        System.out.println("AddBatchImage Help Class");
        Reporter.log("AddBatchImage Help Class");

        String nameMethod = InitializePOJO.getAddBatchImage();
        String fileName = "TestPDF.pdf";
        URLMethods methods = new URLMethods();

        String url = methods.getUrlAddBatchImage() + fileName;
        System.out.println(url);
        Reporter.log(url);
        try {

            file = new File("src/main/resources/TestPDF.Pdf");

            } catch (Exception e) {
            System.err.println("Error: Test file is missed !   " + e);
            Reporter.log("Error: Test file is missed !   " + e);
        }



        Response response = given().cookie(String.valueOf(cookies)).multiPart(file).when().post(url);


        System.out.println("AddImage response " + response.toString());
        Reporter.log("AddImage response " + response.toString());

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End AddBatchImage Help Class");
        Reporter.log("End AddBatchImage Help Class" );
        return pojo;
    }


}
