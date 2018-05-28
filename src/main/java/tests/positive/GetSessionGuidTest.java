package tests.positive;

import helpClass.Deinitialize;
import helpClass.GetSessionGuid;
import helpClass.Initialize;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

public class GetSessionGuidTest {

    static Initialize initialize;
    static InitializePOJO pojo;

    static GetSessionGuid getSessionGuid;
    static InitializePOJO getSessionGuidPOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void Intitalize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

    }

    //getSessionGuid
    @Test
    public void GetSessionGuid() {

        System.out.println("Start GetSessionGuid Test at : " + new Date());

        String returnedValue = pojo.getReturnedValue().replaceAll("\"","");
        getSessionGuid = new GetSessionGuid(pojo.getCookie());
        getSessionGuidPOJO = getSessionGuid.GetSessionGuidMethud();
        System.out.println(getSessionGuidPOJO.getReturnedValue());
        System.out.println("massage = " + getSessionGuidPOJO.getMessage());
        Assert.assertEquals(getSessionGuidPOJO.getDocAlphaResponseCode(), "101");
        System.out.println("End GetSessionGuid Test at : " + new Date());



    }


    //Deinitialize
    @AfterMethod
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitialize();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(), "101");
        System.out.println("End Deinitialize at " + new Date());
    }

}
