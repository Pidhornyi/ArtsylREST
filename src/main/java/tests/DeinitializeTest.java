package tests;

import helpClass.Deinitialize;
import helpClass.Initialize;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

public class DeinitializeTest {

    static  Initialize initialize;
    static InitializePOJO pojo;
    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;


    @BeforeMethod
    public void Intitalize(){
        initialize = new Initialize();
        pojo = initialize.InitializeHelpMethod();

    }

    @Test
    public void Deinitialize(){

        System.out.println("Start Deinitialize Test at : " + new Date());


        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitialize();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(), "101");
        System.out.println("End Deinitialize Test at : " + new Date());

    }
}
