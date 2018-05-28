package pojo;

import com.jayway.restassured.response.Cookies;

import java.util.Map;


public class InitializePOJO {
    private String DocAlphaResponseCode;
    private String ReturnedValue;
    private String Message;
    private Cookies Cookie;

// CustomWorkflow
    private String GuId;
    private String Name;
    private String __type;
    private Map<String,Map<String,String>> map;

    @Override
    public String toString() {
        return "InitializePOJO{" +
                "DocAlphaResponseCode='" + DocAlphaResponseCode + '\'' +
                ", ReturnedValue='" + ReturnedValue + '\'' +
                ", Message='" + Message + '\'' +
                ", Cookie=" + Cookie +
                ", GuId='" + GuId + '\'' +
                ", Name='" + Name + '\'' +
                ", __type='" + __type + '\'' +
                ", map=" + map +
                '}';
    }

    public Map<String, Map<String, String>> getMap() {
        return map;
    }

    public void setMap(Map<String, Map<String, String>> map) {
        this.map = map;
    }

    public String get__type() {
        return __type;
    }

    public void set__type(String __type) {
        this.__type = __type;
    }

    public String getGuId() {
        return GuId;
    }

    public void setGuId(String guId) {
        GuId = guId;
    }

    public String getName() { return Name; }
    public void setName(String name) {
        Name = name;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getDocAlphaResponseCode() {
        return DocAlphaResponseCode;
    }

    public void setDocAlphaResponseCode(String docAlphaResponseCode) {
        DocAlphaResponseCode = docAlphaResponseCode;
    }

    public String getReturnedValue() {
        return ReturnedValue;
    }

    public void setReturnedValue(String returnedValue) {
        ReturnedValue = returnedValue;
    }

    public Cookies getCookie() {
        return Cookie;
    }

    public void setCookie(Cookies cookie) {
        this.Cookie = cookie;
    }
}
