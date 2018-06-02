package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;

import pojo.InitializePOJO;


import java.io.*;



import static com.jayway.restassured.RestAssured.given;

public class AddBatchImage {



    private Cookies cookies;
    private String guidWorkflow;
    public FileInputStream file;
    String test ="" ;
    File length;
    public AddBatchImage(Cookies cookies, String guidWorkflow){
        this.cookies=cookies;
        this.guidWorkflow = guidWorkflow;
    }

    public InitializePOJO AddBatchImageMethod() {
        System.out.println("AddBatchImage Help Class");

        String nameMethod = "AddBatchImageResult";
        String batchName = "TestPDF.Pdf";
        int readBytes;



        try {
            file = new FileInputStream("src/main/resources/TestPDF.Pdf");
           readBytes=file.read();
            while(readBytes!=-1){
                test += readBytes;
                readBytes = file.read();
            }
            System.err.println("test = " + test);

           // OutputStream data = new ByteArrayOutputStream(String.valueOf(file)));


        } catch (IOException e) {
            System.err.println("Error: Test file is missed!");
        }

        URLMethods methods = new URLMethods();

        String url = methods.getUrlAddBatchImage(test,batchName);
        System.out.println("))))))))))))))))))))))) " + String.valueOf(file));

        Response response = given().cookie(String.valueOf(cookies)).when().get(url);
        System.out.println("))))))))))))))))))))))) " + response.toString());

        GSONparser gsoNparser = new GSONparser(response,nameMethod);
        InitializePOJO pojo = gsoNparser.parser();
        System.out.println("End AddBatchImage Help Class");
        return pojo;
    }


}
