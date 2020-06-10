import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class googleApiCall {
    @Test
    public void testGoogleApi() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.
                param("location", "-33.8670522,151.1957362").
                param("radius", "500").
                param("types", "food").
                param("key", "AIzaSyDXR2YGnRu3-112ttezUsQ-T2zOkb6aafE").
                when().
                get("/maps/api/place/nearbysearch/json");

        System.out.println("Response Body is =>  " + response.asString());
    }
}
