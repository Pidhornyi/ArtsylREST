package helpClass;


import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
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

    public InitializePOJO AddBatchImageMethod(String name) {
        System.out.println("AddBatchImage Help Class");
        Reporter.log("AddBatchImage Help Class");

        String nameMethod = InitializePOJO.getAddBatchImage();
        String fileName = name;
        URLMethods methods = new URLMethods();

        String url = methods.getUrlAddBatchImage();
        System.out.println(url);
        Reporter.log(url);
        try {

            file = new File("src/main/resources/AllFormats/" + fileName);

            } catch (Exception e) {
            System.err.println("Error: Test file is missed !   " + e);
            Reporter.log("Error: Test file is missed !   " + e);
        }


        Response response = given().cookie(String.valueOf(cookies)).multiPart(file).when().post(url);


      // Response responsee =  given().cookie(String.valueOf(cookies)).put("test", )

        System.out.println("AddImage response " + response.toString());
        Reporter.log("AddImage response " + response.toString());

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End AddBatchImage Help Class");
        Reporter.log("End AddBatchImage Help Class" );
        System.out.println(response.getStatusCode());
        System.out.println("*************************************");
        if(response.getStatusCode() == 200){
        return pojo;}
        return null;
    }

    public InitializePOJO AddBatchImageMethod() {
        System.out.println("AddBatchImage Help Class");
        Reporter.log("AddBatchImage Help Class");

        String nameMethod = InitializePOJO.getAddBatchImage();
        String fileName = "01_Supplier_Invoice_AJ_Dukes_0_0.bmp";
        URLMethods methods = new URLMethods();

        String url = methods.getUrlAddBatchImage();
        System.out.println(url);
        Reporter.log(url);
        try {

            file = new File("src/main/resources/01_Supplier_Invoice_AJ_Dukes_0_0.bmp");

        } catch (Exception e) {
            System.err.println("Error: Test file is missed !   " + e);
            Reporter.log("Error: Test file is missed !   " + e);
        }


        Response response = given().cookie(String.valueOf(cookies)).multiPart(file).when().post(url);


        // Response responsee =  given().cookie(String.valueOf(cookies)).put("test", )

        System.out.println("AddImage response " + response.toString());
        Reporter.log("AddImage response " + response.toString());
        System.out.println(response.getStatusCode());
        System.out.println("*************************************");

       // if(response.getStatusCode() == 200) {
            GSONparser gsoNparser = new GSONparser(response, nameMethod);
            InitializePOJO pojo = gsoNparser.parser();
            System.out.println("End AddBatchImage Help Class");
            Reporter.log("End AddBatchImage Help Class");
            return pojo;
      //  return null;
    }


}
