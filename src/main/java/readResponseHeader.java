import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class readResponseHeader {
    @Test
    public void getResponseHeaders()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        String contentTpye = response.getContentType();
        System.out.println(contentTpye);

        String server = response.header("Server");
        System.out.println(server);

        String accLang = response.header("Content-Encoding");
        System.out.println(accLang);
    }

    @Test
    public void verifyContentType()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        String contentType = response.getContentType();
        Assert.assertEquals(contentType,"application/json","Did not match");
    }

    @Test
    public void verifyServer()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("Hyderabad");

        String server = response.header("Server");
        Assert.assertEquals(server,"nginx","Did not match the sever");
    }

    @Test
    public void verifyLang()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("Hyderabad");

        String conLang = response.header("Content-Encoding");
        Assert.assertEquals(conLang,"gzip","Did not match the Language");

    }

}
