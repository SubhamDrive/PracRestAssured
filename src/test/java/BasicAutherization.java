import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAutherization {
    @Test
    void checkAuthentication()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";

        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("ToolsQA");
        authScheme.setPassword("TestPassword");

        RestAssured.authentication=authScheme;

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/");

        String body = response.getBody().asString();
        System.out.println(body);

        int sCode = response.getStatusCode();
        System.out.println(sCode);
        Assert.assertEquals(sCode,200);
    }


}
