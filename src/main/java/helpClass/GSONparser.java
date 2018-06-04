package helpClass;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.response.Response;


import org.json.JSONObject;
import pojo.InitializePOJO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GSONparser {
    private String nameMethood;
    private Response response;

    public GSONparser(Response response,String nameMethood) {
        this.response = response;
        this.nameMethood=nameMethood;

    }

    public InitializePOJO parser()  {
       // System.out.println(response.getBody().asString());
        System.out.println("Start parse ");
        JsonParser parser = new JsonParser();
        InitializePOJO pojo = new InitializePOJO();

        //String element = response.getBody().toString();
        System.out.println("response test = " + response.getBody().asString());
        JSONObject jsonObject1 = new JSONObject(response.getBody().asString());
        JsonElement jsonTree =  parser.parse(String.valueOf(jsonObject1));


      //  System.out.println(jsonTree.isJsonObject());
      //  System.out.println(jsonTree);


        if (jsonTree.isJsonObject()) {
            JsonObject jsonObject = jsonTree.getAsJsonObject();

            pojo.setCookie(response.getDetailedCookies());

            JsonElement returnedValue = jsonObject.get(nameMethood);
          //  System.out.println("nameMethood = "+ nameMethood);

            if (returnedValue.isJsonObject()) {

               // System.out.println("returnedValue = "+ returnedValue + " ***  returnedValue.toString = " + returnedValue.toString());
                JsonObject jsonObject2 = returnedValue.getAsJsonObject();

               // System.out.println(jsonObject2.get("DocAlphaResponseCode"));
                pojo.setDocAlphaResponseCode(jsonObject2.get("DocAlphaResponseCode").toString());
              //  System.out.println(jsonObject2.get("DocAlphaResponseCode").toString());
                pojo.setMessage(jsonObject2.get("Message").toString());
                System.out.println("returnedValue = " + jsonObject2.get("ReturnedValue").toString()  );
                pojo.setReturnedValue(jsonObject2.get("ReturnedValue").toString());



                try {
                    //String temp = jsonObject2.get("ReturnedValue").toString().replaceAll("\\[" + "\\]","");
                    JsonElement returnedValueReturnedValue = jsonObject2.get("ReturnedValue");
                    System.out.println("isJsonArray = " + returnedValueReturnedValue.isJsonArray() );


                    if(returnedValueReturnedValue.isJsonArray()){
                        JsonArray jsonArray = returnedValueReturnedValue.getAsJsonArray();
                        Iterator itr = jsonArray.iterator();
                        Map<String,Map<String,String>> mapPojo =new HashMap<String, Map<String, String>>();


                        JsonParser parserw = new JsonParser();
                        JsonObject jsonObjectItr;


                        while(itr.hasNext()){

                            Object element = itr.next();

                            //JsonParser parserw = new JsonParser();
                            jsonObjectItr = parserw.parse(element.toString()).getAsJsonObject();

                            //JsonObject jsonObjectItr = ValueItr.getAsJsonObject();
                            //System.out.println(element + " ");

                            Map<String,String> mapForJson = new HashMap<String, String>();

                            if(jsonObjectItr.get("Name")!=null) {
                                mapForJson.put("Name", jsonObjectItr.get("Name").toString().replaceAll("\"", ""));
                                //System.out.println("Name = "  + mapForJson.get("Name"));
                                mapForJson.put("Guid", jsonObjectItr.get("Guid").toString().replaceAll("\"", ""));
                                mapForJson.put("__type", jsonObjectItr.get("__type").toString().replaceAll("\"", ""));
                                mapPojo.put(jsonObjectItr.get("Name").toString().replaceAll("\"", ""), mapForJson);
                            }
                           if(jsonObjectItr.get("WorkflowName")!=null){
                               mapForJson.put("WorkflowName", jsonObjectItr.get("WorkflowName").toString().replaceAll("\"", ""));
                               //System.out.println("Name = "  + mapForJson.get("Name"));
                               mapForJson.put("BatchGuid", jsonObjectItr.get("BatchGuid").toString().replaceAll("\"", ""));
                               mapForJson.put("BatchId", jsonObjectItr.get("BatchId").toString().replaceAll("\"", ""));
                               mapPojo.put(jsonObjectItr.get("BatchId").toString().replaceAll("\"", ""), mapForJson);

                           }

                        }
                        pojo.setMap(mapPojo);

                        //System.out.println("ForRestApi = "  + pojo.getMap().get("ForRestAPI").toString());


                    }
                }
                catch(NullPointerException e){
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!" + e);
                }

            }


        }
        System.out.println("End parse pojo = "+ pojo.getMap() );

        return pojo;
    }
}
