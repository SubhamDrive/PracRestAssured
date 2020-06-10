import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteMethod {
    @Test
    public void performDeleteMethod()
    {
        int empid= 15410;
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        Response response = httpRequest.delete("/delete/"+empid);

        int statuscode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statuscode,200,"Not Correct");
        String jsonString =response.asString();
        Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);


    }
}
