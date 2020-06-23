import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusCode {

    @Test
    void validateStatusCodeAndStatusLine()
    {
        //Specify base URI
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        //Response object
        Response response = httpRequest.get("/Hyderabad");
        int StatusCode = response.statusCode();
        Assert.assertEquals(StatusCode,200);
        System.out.println(StatusCode);
        String StatusLine = response.statusLine();
        Assert.assertEquals(StatusLine,"HTTP/1.1 200 OK");
        System.out.println(StatusLine);
    }

}
