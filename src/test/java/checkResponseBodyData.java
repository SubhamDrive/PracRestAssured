import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkResponseBodyData {
    @Test
    public void validateResponseBody()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/Delhi");
        String Body = response.getBody().asString();
        System.out.println(Body);

        Assert.assertEquals(Body.contains("Delhi"),true);

    }
}
