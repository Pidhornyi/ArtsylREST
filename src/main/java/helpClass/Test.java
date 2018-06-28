package helpClass;


import com.jayway.restassured.response.Response;
import pojo.InitializePOJO;

import java.util.*;

import static com.jayway.restassured.RestAssured.get;


public class Test {

    public static void main(String args[]){



        HashSet<String> myHashSet = new HashSet<String>();
        myHashSet.add("Россия");
        myHashSet.add("Франция");
        myHashSet.add("Гондурас");
        myHashSet.add("Кот-Д'Ивуар"); // любимая страна всех котов

        // Получим размер HashSet
        myHashSet.iterator();



        // check set values
        System.out.println("Set values: " + myHashSet.iterator());
        System.out.println("Set values: " + myHashSet);

    }
}
