import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckingResponseBody {
    @Test
    public void checkResponseBody()
    {
        RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        String data = response.body().asString();
        System.out.println(data);
        Assert.assertEquals(data.contains("Hyderabad"),true,"Response body has hyderabad");
        Assert.assertEquals(data.toLowerCase().contains("hyderabad"),true,"Body contains Hyderabad");
    }

    @Test
    public void checkRes()
    {
        RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        int Data = response.getStatusCode();
        System.out.println(Data);
        Assert.assertEquals(Data,200,"Correct Response");

    }
    @Test
    public void usingJsonPath()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("Hyderabad");
        JsonPath jsonpathEva = response.jsonPath();
        String city = jsonpathEva.get("City");
        System.out.println(city);
        Assert.assertEquals(city,"Hyderabad","correct json path data ");
    }
}
