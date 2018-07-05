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
2)Reinitialize
3)Deinitialize
 */

public class ReinitializeTest {

    static Initialize initialize ;
    static InitializePOJO pojo ;

    static Reinitialize reinitialize;
    static InitializePOJO reinitializePOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;

    //Initialize
    @BeforeMethod
    public void initialize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();
    }

    //Reinitialize
    @Test
    public void reinitialize() {

        System.out.println("Start Reinitialize Test at : " + new Date());


        //String returnedValue = pojo.getReturnedValue().replaceAll("\"","");
        reinitialize = new Reinitialize(pojo.getCookie(),pojo.getReturnedValue());
        reinitializePOJO = reinitialize.reinitializeMethod();
        System.out.println("massage = " + reinitializePOJO.getMessage());
        Assert.assertEquals(reinitializePOJO.getDocAlphaResponseCode(), "101");
        System.out.println("End Reinitialize Test at : " + new Date());



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
