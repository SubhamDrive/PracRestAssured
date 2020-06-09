import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getStatusLine {
    @Test
    public void fetchStatusLine()
    {
        RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        String sLine = response.getStatusLine();
        System.out.println(sLine);
        Assert.assertEquals(sLine,"HTTP/1.1 200 OK","Matches the string");
        System.out.println("Runs");
    }

    @Test
    public void getWrongStatusLine()
    {
        RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderaba");
        String SL = response.getStatusLine();
        System.out.println(SL);
        Assert.assertEquals(SL,"HTTP/1.1 200 OK","Wrong Status Line");
    }
}
