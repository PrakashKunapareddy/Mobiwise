package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.UserProfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UserProfileSD {
    UserProfile userProfile = new UserProfile(WebdriverInitializer.getDriver());

    @Then("Check Username of the User {string}")
    public void checkUsernameOfTheUser(String username) throws Throwable {
        userProfile.checkUserName(username);
    }

    @And("Update password {string} {string} and click Submit {string} {string} {string}")
    public void updatePasswordNew_passwordConfirm_passwordAndClickSubmitNew_password_error_messageConfirm_password_errorPassword_suggestion_message(String new_password, String confirm_password, String new_password_error_message, String confirm_password_error, String password_suggestion_message) throws Throwable {
        userProfile.validateNewPasswordAndConfirmPassword(new_password, confirm_password, new_password_error_message, confirm_password_error, password_suggestion_message);

    }

    @Then("Validate Logout action {string}")
    public void validateLogoutActionVerify_logout(String verify_logout) throws Throwable {
        userProfile.validateLogout(verify_logout);

    }

    @And("Verify userprofile options {string} {string}")
    public void verifyUserprofileOptions(String list_option1, String list_option2) throws Throwable {
        userProfile.checkUserProfile(list_option1, list_option2);
    }


    @And("Verify Successful Password Change {string}")
    public void verifySuccessfulPasswordChange(String toaster_message) throws Throwable {
        userProfile.verifytoasterChangePassword(toaster_message);
    }

    @And("Login again with New Password {string} {string} {string}")
    public void loginAgainWithNewPasswordUsernameNew_passwordExpected_outputValid_username(String username, String new_password, String expected_output) throws Throwable {
        userProfile.loginAgain(username, new_password, expected_output);
    }
}
