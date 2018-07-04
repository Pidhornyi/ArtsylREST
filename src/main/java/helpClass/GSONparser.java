package helpClass;


import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import main.java.pojo.InitializePOJO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class GSONparser {
    private String nameMethood;
    private Response response;
    Map<String, String> map = new HashMap<String, String>();
    Map<String, Map<String, String>> mapMap = new HashMap<String, Map<String, String>>();

    public GSONparser(Response response, String nameMethood) {
        this.response = response;
        this.nameMethood = nameMethood;

    }

    public InitializePOJO parser() {
        // System.out.println(response.getBody().asString());
        InitializePOJO pojo = new InitializePOJO();
        try {
            System.out.println("Start parse ");
            // JsonParser parser = new JsonParser();

            Map<String, String> mapForJson = new HashMap<String, String>();

           // InputStream stream = response.getBody().asInputStream();

            System.out.println("response from server = " + response.getBody().asString());
          //  System.out.println(stream);
            JSONObject jsonObject0 = new JSONObject(response.getBody().asString());

            JSONObject jsonObject1 = jsonObject0.getJSONObject(nameMethood);


            if (jsonObject1 instanceof JSONObject) {
                // System.out.println(jsonObject2.get("DocAlphaResponseCode"));
                System.out.println(" Doc Response = " + jsonObject1.get("DocAlphaResponseCode").toString());
                pojo.setDocAlphaResponseCode(jsonObject1.get("DocAlphaResponseCode").toString());
                //  System.out.println(jsonObject2.get("DocAlphaResponseCode").toString());
                pojo.setMessage(jsonObject1.get("Message").toString());
                //System.out.println("returnedValue = " + jsonObject1.get("ReturnedValue").toString());
                pojo.setReturnedValue(jsonObject1.get("ReturnedValue").toString());
                pojo.setCookie(response.getDetailedCookies());


                if (jsonObject1.get("ReturnedValue").toString() != ("{}")) {


                    if (jsonObject1.get("ReturnedValue") instanceof JSONObject) {

                        map = objectMap(jsonObject1.getJSONObject("ReturnedValue"));
                        pojo.setMap(map);
                    } else if (jsonObject1.get("ReturnedValue") instanceof JSONArray) {
                        Map<String, Map<String, String>> tempMapMap = new HashMap<String, Map<String, String>>();
                        int q = ((JSONArray) jsonObject1.get("ReturnedValue")).length();
                        System.out.println(" length = " + q);
                        //первый ключь - это индекс массива
                        for (Integer i = 0; i < q; i++) {
                            Map<String, String> tempMap;
                            JSONObject temp = ((JSONArray) jsonObject1.get("ReturnedValue")).getJSONObject(i);
                            tempMap = objectMap(temp);
                            String key = String.valueOf(i);
                            mapMap.put(key, tempMap);

                        }
                        pojo.setMapMap(mapMap);
                    }

                }

            }

        }
            catch (Exception e ){
            System.err.println("Exception !!!" );
                System.err.println(e);
            }

            return pojo;
        }


    public Map objectMap(JSONObject jsonObject) {

        Map<String, String> tempMap = new HashMap<String, String>();
        Iterator<String> keysItr = jsonObject.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            String value = jsonObject.get(key).toString();

            tempMap.put(key, value);
        }
        return tempMap;
    }

}
