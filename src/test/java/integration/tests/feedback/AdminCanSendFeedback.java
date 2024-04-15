package integration.tests.feedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.authApi.AuthApi;
import integration.feedback.Feedback;
import integration.schemas.FeedbackReq;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class AdminCanSendFeedback {
    AuthApi authApi;
    Feedback feedback;

    @Epic(value = "Send Feedback")
    @Feature(value = "Sending Feedback")
    @Story(value = "Admin can send Feedback with role admin")
    @Description(value = "Admin can send Feedback")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "Admin can send Feedback")
    public void adminCanUpdatePost() throws JsonProcessingException {
        String email = "alewwx@gmail.com";
        String password = "Gazmanov1234";
        String name = "Alex";
        String content = "hallo";
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