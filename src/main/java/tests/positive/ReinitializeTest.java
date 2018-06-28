package tests.positive;

import helpClass.Deinitialize;
import helpClass.Initialize;
import helpClass.Reinitialize;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.InitializePOJO;

import java.util.Date;

public class ReinitializeTest {

    static Initialize initialize ;
    static InitializePOJO pojo ;

    static Reinitialize reinitialize;
    static InitializePOJO reinitializePOJO;

    static Deinitialize deinitialize;
    static InitializePOJO deinitializePOJO;

    //Initialize
    @BeforeMethod
    public void Initialize(){
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
    public void Deinitialize(){
        System.out.println("Start Deinitialize at " + new Date());
        deinitialize= new Deinitialize(pojo.getCookie());
        deinitializePOJO = deinitialize.deinitializeMethod();
        System.out.println("massage = " + deinitializePOJO.getMessage());
        Assert.assertEquals(pojo.getDocAlphaResponseCode(), "101");
        System.out.println("End Deinitialize at " + new Date());
    }
}
