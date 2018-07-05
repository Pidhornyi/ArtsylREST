package tests.positive;


import helpClass.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
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
2)Deinitialize
 */

public class InitializeTest {
static Initialize initialize;
static InitializePOJO pojo;
static Deinitialize deinitialize;
    @Test
    public void initialize(){
        Reporter.log("Start Initialize Test at : " + new Date());
        System.out.println("Start Initialize Test at : " + new Date());


        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();
        Assert.assertEquals(pojo.getDocAlphaResponseCode(),"101");
        System.out.println("Test passed");
        System.out.println("End Initialize Test at "+ new Date() );
        Reporter.log("End Initialize Test at "+ new Date());
        Reporter.log("Test passed");




    }

    @AfterMethod
    public void deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize = new Deinitialize(pojo.getCookie());
        deinitialize.deinitializeMethod();
        System.out.println("End Deinitialize at : " + new Date());

    }

}
