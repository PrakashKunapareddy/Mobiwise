package com.vassarlabs.MobileWise.page;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserProfile {
    WebDriver driver;
    LoginPage newLogin = new LoginPage(WebdriverInitializer.getDriver());

    private By usernameInUserProfile = By.xpath("//div[@class='avatar']//parent::div");
    private By userProfileExpandIcon = By.xpath("//div[@class='buttons']/div/div/following-sibling::mat-icon");
    private By changePasswordUserProfile = By.xpath("//button[@role='menuitem']/span[text()='Change Password']");
    private By logOutUserProfile = By.xpath("//button[@role='menuitem']/span[text()=' Logout ']");
    private By changePasswordHeading = By.xpath("//h1[text()='Change Password']");
    private By changePasswordPopupSuggestion = By.xpath("//small[text()='Password should be 11 to 50 characters with at least 1 Upper Case, 1 Lower Case, 1 Special and 1 Numeric Character. Should not be Previous 5 Passwords.']");
    private By changePasswordField = By.xpath("//input[@placeholder='Enter New Password']");
    private By confirmPasswordField = By.xpath("//input[@placeholder='Confirm Password']");
    private By changePasswordFieldError = By.xpath("//mat-hint[@class= 'mat-mdc-form-field-hint mat-mdc-form-field-bottom-align text-danger ng-star-inserted']");
    private By confirmPasswordFieldError = By.xpath("//mat-hint[@class= 'mat-mdc-form-field-hint mat-mdc-form-field-bottom-align text-danger ng-star-inserted']");
    private By submitButtonChangePassword = By.xpath("//button/span[text()='Submit']");
    private By cancelButtonChangePassword = By.xpath("//button/span[text()='Cancel']");
    private By loginPageText = By.xpath("//div[@class='login-content']/div/h1[text()=' Welcome ']/following-sibling::p[text()='Sign In to Continue']");
    private By successfulToasterChangeOfPassword = By.xpath("//div[text()=' Password changed successfully ']");


    private boolean verifyUserFlag = false;
    private boolean UserProfileOptionsFlag = false;
    private boolean submitFlag = true;
    private boolean confirmPasswordFlag = true;


    private boolean succesfulChangePasswordFlag = false;
    private boolean loginFlag = false;


    public UserProfile(WebDriver driver) {
        this.driver = driver;
    }


    //Check username which is displayed on the Home page to verify it with logged-in username
    public void checkUserName(String username) throws Throwable {
        Thread.sleep(3000);
        String userProfileVerifyBigString = driver.findElement(usernameInUserProfile).getText();
        String[] userNameProfile = userProfileVerifyBigString.split("\n");
        String userVerify = userNameProfile[1];
        System.out.println(userVerify);
        Assert.assertEquals(userVerify, username, "Expected Error Message " + username + " But Found : " + userVerify);
        if (username.equals(userVerify)) {
            verifyUserFlag = true;
        }
    }

    // Check option in the User profile
    public void checkUserProfile(String list_option1, String list_option2) throws Throwable {
        if (verifyUserFlag) {
            Thread.sleep(6000);
            driver.findElement(userProfileExpandIcon).click();
            Thread.sleep(6000);
            String changePasswordTextInUserProfile = driver.findElement(changePasswordUserProfile).getText().trim();
            Thread.sleep(6000);
            Assert.assertEquals(list_option1, changePasswordTextInUserProfile, "Expected Error Message " + list_option1 + " But Found : " + changePasswordTextInUserProfile);
            Thread.sleep(6000);
            String logOutTextInUserProfile = driver.findElement(logOutUserProfile).getText().trim();
            Assert.assertEquals(list_option2, logOutTextInUserProfile, "Expected Error Message " + list_option2 + " But Found : " + logOutTextInUserProfile);
            UserProfileOptionsFlag = true;
        }
    }

    //validate the new password entered and confirm password
    public void validateNewPasswordAndConfirmPassword(String new_password, String confirm_password, String new_password_error_message, String confirm_password_error, String password_suggestion_message) throws Throwable {
        if (UserProfileOptionsFlag) {
            Thread.sleep(10000);
            driver.findElement(changePasswordUserProfile).click();
            cancleButtonChangePassword();
            Thread.sleep(3000);
            driver.findElement(userProfileExpandIcon).click();
            Thread.sleep(3000);
            driver.findElement(changePasswordUserProfile).click();
            Thread.sleep(3000);
            driver.findElement(changePasswordField).sendKeys(new_password);
//            String format = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=]).{8,}$";
//            Pattern pattern = Pattern.compile(format);
//            Matcher matcher = pattern.matcher(new_password);
            if (driver.findElements(changePasswordFieldError).size() > 0) {
                String message = driver.findElement(changePasswordFieldError).getText();
                Assert.assertEquals(new_password_error_message, message, "Expected Error Message " + new_password_error_message + " But Found : " + message);
                confirmPasswordFlag = false;
                submitFlag = false;
            }
            Thread.sleep(3000);
            if (confirmPasswordFlag) {
                String message;
                driver.findElement(confirmPasswordField).sendKeys(confirm_password);
                driver.findElement(changePasswordField).click();
                if (driver.findElements(confirmPasswordFieldError).size() > 0) {
                    if (driver.findElements(confirmPasswordFieldError).size() > 1) {
                        message = driver.findElements(confirmPasswordFieldError).get(1).getText();
                    } else {
                        message = driver.findElement(confirmPasswordFieldError).getText();
                    }
                    Thread.sleep(3000);
                    driver.findElement(changePasswordField).click();
                    Assert.assertEquals(confirm_password_error, message, "Expected Error Message " + confirm_password_error + " But Found : " + message);
                    submitFlag = false;
                }
                if (submitFlag) {
                    submitButtonChangePassword();
                }
            }
        }
    }

    //Cancle button for the change password popup
    public void cancleButtonChangePassword() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(cancelButtonChangePassword).click();
    }

    //Submit button for the change password popup
    public void submitButtonChangePassword() throws Throwable {
        Thread.sleep(3000);
        if (submitFlag) {
            driver.findElement(submitButtonChangePassword).click();
        }
    }

    //verify toster for successful password change
    public void verifytoasterChangePassword(String toaster_message) throws Throwable {
        if (submitFlag) {
            Thread.sleep(3000);
            if (driver.findElements(successfulToasterChangeOfPassword).size() > 0) {
                String message = driver.findElement(successfulToasterChangeOfPassword).getText().trim();
                Assert.assertEquals(toaster_message, message, "Expected Error Message " + toaster_message + " But Found : " + message);
                succesfulChangePasswordFlag = true;
                Thread.sleep(1000);
                driver.navigate().refresh();
                loginFlag = true;
                succesfulChangePasswordFlag = true;
            }
        }
    }

    public void loginAgain(String username, String new_password, String expected_output) throws Throwable {
        if (loginFlag && succesfulChangePasswordFlag) {
            newLogin.enterUsername(username);
            newLogin.enterPassword(new_password);
            newLogin.clickSignInButton();
            newLogin.validateLogin(expected_output);
        }
    }

    //Validate the logout option in the User Profile
    public void validateLogout(String verify_logout) throws Throwable {
        Thread.sleep(3000);
        if (driver.findElements(cancelButtonChangePassword).size() > 0) {
            cancleButtonChangePassword();
        }
        Thread.sleep(3000);
        driver.findElement(userProfileExpandIcon).click();
        if (!(driver.findElements(logOutUserProfile).isEmpty())) {
            Thread.sleep(3000);
            driver.findElement(logOutUserProfile).click();
            Thread.sleep(3000);
            String message = driver.findElement(loginPageText).getText();
            String logoutUrl = driver.getCurrentUrl();
            String url = "https://dev.mobilewise.vassardigital.ai/login";
            Assert.assertEquals(logoutUrl, url, "Expected Error Message " + url + " But Found : " + logoutUrl);
            Assert.assertEquals(verify_logout, message, "Expected Error Message " + verify_logout + " But Found : " + message);

        }
    }

    public void validateBackButton() throws Throwable {
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(2000);
        String logoutUrl = driver.getCurrentUrl();
        String url = "https://dev.mobilewise.vassardigital.ai/login";
        Assert.assertEquals(logoutUrl, url, "Expected Error Message " + url + " But Found : " + logoutUrl);
    }
}
