package com.vassarlabs.projectname.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage{
    WebDriver driver;

    private By userName = By.xpath("//input[@id='username']") ;
    private By passWord = By.xpath("//input[@id='password']") ;
    private By signInButton = By.xpath("//span[text()=' Sign In ']");
    private By successMessage = By.xpath("//div//h2[text()='Projects']");
    private By errorMessage = By.xpath("//mat-hint[@id='mat-mdc-hint-0']");



    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterUsername(String username){
        WebElement un = driver.findElement(userName);
        un.sendKeys(username);
    }

    public void enterPassword(String password ){
        WebElement pw = driver.findElement(passWord);
        pw.sendKeys(password);
    }
    public void clickSignInButton(){
        WebElement Button = driver.findElement(signInButton);
        Button.click();
    }
    public void validateLogin(String expected_output) throws Throwable{
        Thread.sleep(2000);
        if (driver.findElements(errorMessage).size()>0){
            String error =  driver.findElement(errorMessage).getText();
             Assert.assertEquals(expected_output, error, "Expected Error Message " + expected_output + " But Found : " + error);
        }
        else if (driver.findElements(successMessage).size()>0){
            String success = driver.findElement(successMessage).getText();
            System.out.println(success);
            Assert.assertEquals(expected_output, success, "Expected Error Message " + expected_output + " But Found : " + success);
        }
        else{
            System.out.println("-----------------");
        }
    }
}
