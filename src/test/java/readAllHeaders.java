import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class readAllHeaders {

    @Test
    public void readHearders()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/Hyderabad");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        Headers allHeaders = response.headers();
        for(Header header:allHeaders)
        {
            System.out.println(header.getName()+"    "+header.getValue());
        }

    }
}

