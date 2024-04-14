package integration.user;

import integration.ApiBase;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetUser extends ApiBase {

    public GetUser(String token) {
        super(token);
    }

    @Step("Get user")
    public String getUser(int code) {
        String endPoint = "/api/me";
        Response response = getRequest(endPoint, code);

        switch (response.getStatusCode()) {
            case 200:
                JsonPath jsonPath = response.jsonPath();
                assert jsonPath.getString("id") != null : "ID is missing";
                assert jsonPath.getString("email") != null : "Name is missing";
                assert jsonPath.getString("role") != null : "Surname is missing";
                break;
            case 400:
                System.err.println("Bad Request: " + response.asString());
                break;
            case 401:
                System.err.println("Unauthorized: " + response.asString());
                break;
            default:
                System.err.println("Unexpected status code: " + response.getStatusCode() + " Response Body: " + response.asString());
        }
        return response.asString();
    }
}