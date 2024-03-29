package com.vassarlabs.MobileWise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    private By userName = By.xpath("//input[@placeholder='Username/Email']");
    private By passWord = By.xpath("//input[@placeholder='Password']");
    private By signInButton = By.xpath("//button//span[text()=' Sign In ']/parent::button");
    private By successMessage = By.xpath("//div[@class='page-header']/div/h2[text()='Projects']");
    private By errorMessageIncorrectPassword = By.xpath("//div/mat-hint[text()='Incorrect Password!']");
    private By errorMessageIncorrectUsername = By.xpath("//div/mat-hint[text()='Invalid Username!']");
    private By forgotPassword = By.xpath(" //span[text()=' Forgot Password? ']");
    private By forgotPasswordUsername = By.xpath("//mat-label[text()='Username']/../../../following-sibling::div/input");
    private By forgotPasswordSubmit = By.xpath("//span[text()=' Submit ']/parent::button");
    private By noaccessForResorsesLogin = By.xpath("//h3[text()='List Of Applications & Resources']");
    private boolean flag = true;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) throws InterruptedException {
        Thread.sleep(1000);
        WebElement un = driver.findElement(userName);
        un.sendKeys(username);
    }

    public void enterPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        WebElement pw = driver.findElement(passWord);
        pw.sendKeys(password);
    }

    public void clickSignInButton() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        boolean Enabledcondition = Boolean.parseBoolean(driver.findElement(signInButton).getAttribute("disabled"));
//        boolean Enabledcondition =  driver.findElement(signInButton).isEnabled();
        System.out.println("................" + Enabledcondition);

        if (!(driver.findElement(signInButton).isEnabled())) {
            flag = false;
        } else {
            driver.findElement(signInButton).click();
        }

    }

    public void validateLogin(String expected_output) throws Throwable {
        if (flag) {
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            if (driver.findElements(errorMessageIncorrectPassword).size() > 0) {
                String error = driver.findElement(errorMessageIncorrectPassword).getText();
                Assert.assertEquals(expected_output, error, "Expected Error Message " + expected_output + " But Found : " + error);
//                forgotPassword(valid_username);
            }
            if (driver.findElements(errorMessageIncorrectUsername).size() > 0) {
                String error = driver.findElement(errorMessageIncorrectUsername).getText();
                Assert.assertEquals(expected_output, error, "Expected Error Message " + expected_output + " But Found : " + error);
//                forgotPassword(valid_username);
            }
            if (driver.findElements(successMessage).size() > 0) {
                String success = driver.findElement(successMessage).getText();
                System.out.println(success);
                Assert.assertEquals(expected_output, success, "Expected Error Message " + expected_output + " But Found : " + success);
                if(driver.findElements(noaccessForResorsesLogin).size()>0){
                    String noAccess = driver.findElement(noaccessForResorsesLogin).getText().trim();
                    Assert.assertEquals(expected_output, noAccess, "Expected Error Message " + expected_output + " But Found : " + noAccess);
                }
            }
        } else {
            System.out.println("Empty Username Or Password field");
        }
    }
}
