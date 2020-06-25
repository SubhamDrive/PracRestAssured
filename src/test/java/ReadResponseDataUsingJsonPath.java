import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadResponseDataUsingJsonPath {
    @Test
    public void getDataUsingJsonPath()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/Bangalore");
        JsonPath jp = response.jsonPath();
        String city = jp.get("City");
        System.out.println(city);
        Assert.assertEquals(jp.get("City"),"Bengaluru");
    }
}
