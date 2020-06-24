import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticePost {
    @Test
    void postRequest()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/customer";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName","Deepak");
        requestParams.put("LastName","Sen");
        requestParams.put("UserName","DeepakSen");
        requestParams.put("Password","deepak213");
        requestParams.put("Email","Deepak@gmail.com");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST,"/register");
        int sCode = response.getStatusCode();
        System.out.println("StatusCode Is :"+sCode);
        Assert.assertEquals(sCode,201);

        String resBody = response.getBody().asString();
        System.out.println(resBody);

        String succode = response.jsonPath().getString("SuccessCode");
        System.out.println(succode);
        Assert.assertEquals(succode,"OPERATION_SUCCESS");


    }
}
