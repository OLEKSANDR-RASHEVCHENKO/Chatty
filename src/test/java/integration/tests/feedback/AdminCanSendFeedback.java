package integration.tests.feedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.authApi.AuthApi;
import integration.feedback.Feedback;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class AdminCanSendFeedback {
    AuthApi authApi;
    Feedback feedback;

    @Epic(value = "Send Feedback")
    @Feature(value = "Sending Feedback")
    @Story(value = "User can send Feedback with role admin")
    @Description(value = "User can send Feedback")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "User can send Feedback")
    public void adminCanSendFeedback() throws JsonProcessingException {
        String email = "alewwx@gmail.com";
        String password = "Gazmanov1234";
        String name = "Alex";
        String content = "hallo";
        authApi = new AuthApi();
        String token = authApi.login(email, password, 200);
        feedback = new Feedback(token);
        feedback.sendFeedback(name, email, content, 201);
    }
}
