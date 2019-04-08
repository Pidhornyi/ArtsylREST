package helpClass;

import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import org.testng.Reporter;
import pojo.InitializePOJO;

import static com.jayway.restassured.RestAssured.given;

public class GetAvailiableStatuses {

        private Cookies cookies;
        public GetAvailiableStatuses(Cookies cookies){

            this.cookies=cookies;
        }

        public InitializePOJO getAvailiableStatusesMethod(){
            System.out.println("Start GetAvailiableStatuses Help Class");
            Reporter.log("Start GetAvailiableStatuses Help Class");

            String nameMethod = InitializePOJO.getGetAvailiableStatuses();


            URLMethods methods = new URLMethods();
            String urlGetAvailiableStatuses = methods.getUrlGetAvailiableStatuses();
            System.out.println(urlGetAvailiableStatuses);
            Reporter.log(urlGetAvailiableStatuses);
            // Запрос вместе с подставленной cookie
            Response getAvailiableStatuses = given().cookie(String.valueOf(cookies)).when().get(urlGetAvailiableStatuses);
            GSONparser jsoNparseAvailiableStatuses= new GSONparser(getAvailiableStatuses, nameMethod);
            InitializePOJO pojoAvailiableStatuses = jsoNparseAvailiableStatuses.parser();


            System.out.println("End GetAvailiableStatuses Help Class");
            Reporter.log("End GetAvailiableStatuses Help Class");

            return pojoAvailiableStatuses;
        }
}
