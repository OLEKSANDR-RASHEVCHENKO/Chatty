package integration.tests.feedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.authApi.AuthApi;
import integration.feedback.Feedback;
import integration.schemas.FeedbackReq;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class UserCanSendFeedback {
    AuthApi authApi;
    Feedback feedback;

    @Epic(value = "Send Feedback")
    @Feature(value = "Sending Feedback")
    @Story(value = "User can send Feedback with role admin")
    @Description(value = "User can send Feedback")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "User can send Feedback")
    public void userCanUpdatePost() throws JsonProcessingException {
        String email = "alexberr9501@gmail.com";
        String password = "123qwert";
        String name = "Alex";
        String content = "Hello Qa";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);

        FeedbackReq feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(email);
        feedbackReq.setContent(content);

        feedback = new Feedback(token);
        feedback.sendFeedback(feedbackReq, 201);
    }
}