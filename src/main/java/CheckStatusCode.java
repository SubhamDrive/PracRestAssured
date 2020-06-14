import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckStatusCode {

    @Test
    public void checkStatusCode()
    {
        RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        int code = response.getStatusCode();
        Assert.assertEquals(code,200,"Wrong Code");
        System.out.println("Correct");
    }

    @Test
    public void checkWrongStatusCode()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyd");
        int SCode = response.getStatusCode();
        Assert.assertEquals(SCode,200,"Wrong Code");
        System.out.println("UnCorrect");
    }

    @Test
    public void printResponse()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        String Data = response.getStatusLine();
        System.out.println(Data);
        Assert.assertEquals(Data,"HTTP/1.1 200 OK","Data Same");

    }

    @Test
    public void getStatus()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        String data = response.body().asString();
        System.out.println(data);
    }



}
