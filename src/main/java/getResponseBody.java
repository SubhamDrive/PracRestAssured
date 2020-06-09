import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class getResponseBody {
    @Test
    public void getResponseBodyData()
    {
        RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        String Data = response.getBody().asString();
        System.out.println(Data);
    }
}
