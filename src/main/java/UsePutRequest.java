import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class UsePutRequest {

    @Test
    public void usingPutrequestForModification()
    {
        int empId = 15410;
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject queryParam= new JSONObject();
        queryParam.put("name","Subham");
        queryParam.put("age",23);
        queryParam.put("salary","20000");

        Response response = httpRequest.put("/update/"+ empId);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

    }
}
