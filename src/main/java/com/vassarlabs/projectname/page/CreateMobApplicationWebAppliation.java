package com.vassarlabs.projectname.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.PrivateKey;

public class CreateMobApplicationWebAppliation {


    WebDriver driver;

    private By projectMatBuutton = By.xpath("//mat-card-title[contains(@class,'mat-mdc-card-title')]") ;
    private String  applicationWidget = "//div[text()='";   //give the xpath as mobile app or web app in condition statement
    private By appNameField = By.xpath("//mat-label[text()='App Name']");
    private By shortDescField = By.xpath("//mat-label[text()='Short Description']");
    private By editLogo = By.xpath("//mat-icon[text()='edit']");
    private By nextButtonSettings = By.xpath("//span[text()='Next']");
    private By themesDropdown = By.xpath("//mat-label[text()='select Themes']/../../../following-sibling::div/mat-select");  //use find elements get(0)
    private By headingsDropdown = By.xpath("//mat-label[text()='Headings']/../../../following-sibling::div/mat-select");
    private By bodyDropdown = By.xpath("//mat-label[text()='Body']/../../../following-sibling::div/mat-select");
    private By nextButtonBranding = By.xpath("//span[text()='Next']");
//    private By toasterMessage = By.xpath("//div[text()=' Sucessfully Created Application ']");
    private String logoPath = "D:\\MobileWise\\Logo\\Logoimage.jpg";
    private By errorProjectExists = By.xpath("//mat-hint[text()='This Application name already exists!']");
    private By toasterMessages = By.xpath("//div[@id='toast-container']/div/div");


    public CreateMobApplicationWebAppliation(WebDriver driver){
        this.driver = driver;
    }

    public void clickProjectMatButton(){
        driver.findElement(projectMatBuutton).click();
    }
    public void clickApplicationType(String application_type){
        driver.findElement(By.xpath(applicationWidget+application_type+"'")).click();
    }

    public void updateNameFieldsAndClickNext(String app_name, String app_desc){
        driver.findElement(appNameField).sendKeys(app_name);
        driver.findElement(shortDescField).sendKeys(app_desc);
        driver.findElement(editLogo).sendKeys(logoPath);
        driver.findElement(nextButtonSettings).click();
    }
    public void updateThemeAndClickNext(String themes_dropdown, String headings_dropdown, String body_dropdown) throws Throwable{

         driver.findElement(themesDropdown).click();
        driver.findElement(By.xpath("//div[contains(@class,'ng-trigger ng-trigger-transformPanel')]/mat-option/span[text()='"+themes_dropdown+"']")).click();
        driver.findElement(headingsDropdown).click();
        driver.findElement(By.xpath("//mat-option[contains(@class,'mat-mdc-option mdc-list-item')]/span[text()='"+headings_dropdown+"']")).click();
        driver.findElement(bodyDropdown).click();
        driver.findElement(By.xpath("//mat-option[contains(@class,'mat-mdc-option mdc-list-item')]/span[text()='"+body_dropdown+"']")).click();

    }
    public void validateToasterMessage(String toaster_message){
        if(driver.findElement(By.xpath(toasterMessages+"[text()=' "+toaster_message+" ']")).isDisplayed()){
            String toaster = driver.findElement(By.xpath(toasterMessages+"[text()=' "+toaster_message+" ']")).getText();
            Assert.assertEquals(toaster_message, toaster, "Expected Error Message " + toaster_message + " But Found : " + toaster);
        }
        if(driver.findElements(errorProjectExists).size()>0){
            String error = driver.findElement(errorProjectExists).getText();
            Assert.assertEquals(toaster_message, error, "Expected Error Message " + toaster_message + " But Found : " + error);
        }
        else{
            System.out.println("Error in The Code");
        }
        {

        }
    }













}
