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
    @Story(value = "User can send Feedback with role user")
    @Description(value = "User can send Feedback")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "User can send Feedback")
    public void userCanSendFeedback() throws JsonProcessingException {
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

    @Epic(value = "Send Feedback")
    @Feature(value = "Sending Feedback")
    @Story(value = "User can't send Feedback with role user")
    @Description(value = "User can't send Feedback")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "User can't send Feedback")
    public void userCanNotSendFeedback() throws JsonProcessingException {
        String email = "alexberr9501@gmail.com";
        String password = "123qwert";
        String emailField = "alexberr9501gmail.com";
        String name = "Qa";
        String content = "invalid data";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);

        FeedbackReq feedbackReq = new FeedbackReq();
        feedbackReq.setName(name);
        feedbackReq.setEmail(emailField);
        feedbackReq.setContent(content);

        feedback = new Feedback(token);
        feedback.sendFeedback(feedbackReq, 400);
    }
}