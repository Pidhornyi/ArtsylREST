package tests.REST.positive;


import helpClass.Deinitialize;
import helpClass.Initialize;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.InitializePOJO;

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

public class DeinitializeTest {

    static Initialize initialize;
    static InitializePOJO pojo;
    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void intitalize(){

        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

    }

    @Test
    public void deinitialize(){

        System.out.println("Start Deinitialize Test at : " + new Date());


        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(deinitializePOJO.getDocAlphaResponseCode(), "101");
        System.out.println((char)27 + "[31m"  + "End Deinitialize Test at : " + new Date() + (char)27 + "[0m" );

    }
}
