import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationSuccessful {
    /*@Test
    void testRegisterDataPostMethod()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/customer";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName","DonDon");
        requestParams.put("LastName","DickDick");
        requestParams.put("UserName","DickDick");
        requestParams.put("Password","DickDick");
        requestParams.put("Email","DickDick@gmail.com");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.POST,"/register");
        String responseBod = response.getBody().asString();
        System.out.println("Response Boy is :"+responseBod);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
        System.out.println("StatusCode is :"+statusCode);

        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode,"OPERATION_SUCCESS");
        System.out.println("SuccessCode is :"+successCode);

    }*/



    @Test
    void postDataIntoServer()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/customer";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName","Mansoon");
        requestParams.put("LastName","Aya");
        requestParams.put("UserName","SandeshaLaya");
        requestParams.put("Password","BoldoSabko");
        requestParams.put("Email","Mansonaya@gmail.com");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        //Response response = httpRequest.post("/register");
        Response response = httpRequest.request(Method.POST,"/register");
        String body = response.getBody().asString();
        System.out.println(body);

        int code = response.getStatusCode();
        System.out.println(code);
        Assert.assertEquals(code,201);

        String Successcode = response.jsonPath().get("SuccessCode");
        System.out.println(Successcode);
        Assert.assertEquals(Successcode,"OPERATION_SUCCESS");


    }
}
