package integration.feedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.ApiBase;
import integration.schemas.FeedbackReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class Feedback extends ApiBase {
    public Feedback(String token) {
        super(token);
    }

    @Step("Send feedback from user:{email}")
    public String sendFeedback(FeedbackReq feedbackReq, int expectedStatusCode) throws JsonProcessingException {
        String endpoint = "/api/feedback";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(feedbackReq);
        Response response = postRequest(endpoint, expectedStatusCode, jsonRequestBody);
        return response.asString();
    }
}
