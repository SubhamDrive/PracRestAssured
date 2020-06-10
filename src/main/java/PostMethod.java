import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostMethod {

    @Test
    public void performPostRequest()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/customer";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParam = new JSONObject();
        requestParam.put("FirstName","Subham");
        requestParam.put("LastName","Choudhary");
        requestParam.put("UserName","choudharysubham47");
        requestParam.put("Pasword","subham123");
        requestParam.put("Email","choudhary@gmail.com");

        httpRequest.body(requestParam.toJSONString());
        Response response = httpRequest.post("/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201,"Not matched ");
        String succesCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals("Correct Success code was returned",succesCode, "OPERATION_SUCCESS");
    }

}
