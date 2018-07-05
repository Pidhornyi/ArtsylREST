package tests.positive;

import helpClass.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import main.java.pojo.InitializePOJO;

import java.util.Date;



/*
            Success = 101,
            Created = 102,
            Failed = 103,
            InvalidInput = 104,
            Forbidden = 105,
            Authorized = 106

Steps:
1)Initialize
2)GetSessionGuid
3)Deinitialize
 */
public class GetSessionGuidTest {

    static Initialize initialize;
    static InitializePOJO pojo;

    static GetSessionGuid getSessionGuid;
    static InitializePOJO getSessionGuidPOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void intitalize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

    }

    //getSessionGuid
    @Test
    public void getSessionGuid() {

        System.out.println("Start GetSessionGuid Test at : " + new Date());

        //String returnedValue = pojo.getReturnedValue().replaceAll("\"","");
        getSessionGuid = new GetSessionGuid(pojo.getCookie());
        getSessionGuidPOJO = getSessionGuid.GetSessionGuidMethod();
        System.out.println(getSessionGuidPOJO.getReturnedValue());
        System.out.println("massage = " + getSessionGuidPOJO.getMessage());
        Assert.assertEquals(getSessionGuidPOJO.getDocAlphaResponseCode(), "101");
        System.out.println("End GetSessionGuid Test at : " + new Date());



    }


    //Deinitialize
    @AfterMethod
    public void deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(), "101");
        System.out.println("End Deinitialize at " + new Date());
    }

}
