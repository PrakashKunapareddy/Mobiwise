package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefnitions {

    LoginPage loginPage = new LoginPage(WebdriverInitializer.getDriver());


    @Given("Entered a valid {string} {string}")
    public void entered_a_valid (String username,String password) throws Throwable {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("Clicked on the sign in button")
    public void clicked_on_the_sign_in_button() throws InterruptedException {
        loginPage.clickSignInButton();

    }

    @Then("Validate login {string}")
    public void validate_login_(String expected_output) throws Throwable {
        loginPage.validateLogin(expected_output);
    }


    @And("Click on the forgot password and enter {string}")
    public void clickOnTheForgotPasswordAndEnterValid_username(String valid_username) {

    }
}
