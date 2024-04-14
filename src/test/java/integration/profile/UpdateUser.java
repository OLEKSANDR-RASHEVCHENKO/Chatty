package integration.profile;

import integration.ApiBase;
import io.qameta.allure.Step;

public class UpdateUser extends ApiBase {

    @Step("Update user with Id{}")
    public String undateUser(String userId);
}
