package integration.feedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.ApiBase;
import integration.schemas.FeedbackReq;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class Feedback extends ApiBase {
    public Feedback(String token) {
        super(token);
    }

    @Step("Send feedback from user:{email}")
    public String sendFeedback(String name, String email, String content, int expectedStatusCode) throws JsonProcessingException {
        String endpoint = "/api/feedback";
        Object body = userCanSendRequest(name, email, content);
        Response response = postRequest(endpoint, expectedStatusCode, body);
        return response.asString();
    }

    public FeedbackReq userCanSendRequest(String name, String email, String content) {
        FeedbackReq feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(email);
        feedbackReq.setContent(content);
        return feedbackReq;
    }
}
