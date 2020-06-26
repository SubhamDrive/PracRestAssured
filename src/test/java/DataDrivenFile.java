import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenFile {
    @Test(dataProvider = "empdataprovider")
    public void GetDataAndPerformPostRequest(String ename,String esal,String eage)
    {
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name",ename);
        requestParams.put("salary",esal);
        requestParams.put("age",eage);

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST,"/create");
        String gBody = response.getBody().asString();
        System.out.println(gBody);
        Assert.assertEquals(gBody.contains(ename),true);
        Assert.assertEquals(gBody.contains(esal),true);
        Assert.assertEquals(gBody.contains(eage),true);

        int scode = response.getStatusCode();
        System.out.println(scode);
        Assert.assertEquals(scode,200);
    }

    @DataProvider(name="empdataprovider")
    Object[] getData()
    {
        String empData[][] = {{"Ram","10000","21"},{"Sita","10000","19"},{"Laxman","10000","19"}};
        return empData;
    }
}
