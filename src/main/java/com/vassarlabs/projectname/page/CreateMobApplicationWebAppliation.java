package com.vassarlabs.projectname.page;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.security.PrivateKey;
import java.time.Duration;
import java.util.Random;

public class CreateMobApplicationWebAppliation {


    WebDriver driver;


    private By projectMatBuutton = By.xpath("//div/mat-card/mat-card-content/mat-card-title");  //use find eles
    private By appNameField = By.xpath("//input[@placeholder='App Name']");
    private By shortDescFieldlabel = By.xpath("//mat-label[text()='Short Description']");
    private By shortDescField = By.xpath("//textarea[@placeholder='Write here...']");
    private By editLogo = By.xpath("//div[@class='mat-ripple icon-img-container']/input");
    private By nextButtonSettings = By.xpath("//span[text()='Next']");
    private By themesDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Select Themes']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By themesDropdownValue = By.xpath("//h3[text()='Theme']/parent::form/mat-form-field/div/div/div/following-sibling::div/mat-select/div/div/span/span");
    private By suggestionForDropdown = By.xpath("//mat-hint[text()='This is required field!']");
    private By headingsDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Headings']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By bodyDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Body']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By nextButtonBranding = By.xpath("//span[text()='Next']");
    //    private By toasterMessage = By.xpath("//div[text()=' Sucessfully Created Application ']");
    private String logoPath = "D:\\MobileWise\\Logo\\Logoimage.jpg";
    private By errorProjectExists = By.xpath("//mat-hint[text()='This Application name already exists!']");
    private By toasterMessages = By.xpath("//div[@id='toast-container']/div/div");
    private By breadcrumbHome = By.xpath("//div/nav/ol/li[text()='Home']");
    private By breadcrumbApplicationpage = By.xpath("//div/nav/ol/li[contains(@class,'breadcrumb-item active')]");
    private boolean flag = false;
    private boolean flag1 = false;


    Random ra = new Random();
    int rand_int = ra.nextInt(1000);

    public CreateMobApplicationWebAppliation(WebDriver driver) throws AWTException {
        this.driver = driver;
    }

    public void clickProjectMatButton() {
        driver.findElements(projectMatBuutton).get(0).click();
        flag = true;
    }

    public void clickHomeOnBreadcrumb() throws InterruptedException {
        if(flag){
            Thread.sleep(3000);
            driver.findElement(breadcrumbHome).click();
            Thread.sleep(3000);
            clickProjectMatButton();
        }
    }
    public void  clickApplicationPageBreadcrumb() throws InterruptedException {
        if(flag){
            Thread.sleep(3000);
           if(driver.findElement(breadcrumbApplicationpage).isDisplayed()){
               flag1=true;
           }
        }
    }

    public void clickApplicationType(String application_type) {
        if(flag1){
            driver.findElement(By.xpath("//div[text()='" + application_type + "']")).click();
        }
    }
    public void updateNameFields(String app_name, String app_desc) {
        driver.findElement(appNameField).sendKeys(app_name);
        driver.findElement(shortDescFieldlabel).click();
        driver.findElement(shortDescField).sendKeys(app_desc);
        driver.findElement(editLogo).sendKeys(logoPath);
    }

    public void clickNextToThemes() {
        driver.findElement(nextButtonSettings).click();
    }

    public void updateThemeAndClickNext(String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message) throws Throwable {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(themesDropdown)));
        driver.findElement(themesDropdown).click();
        driver.findElement(By.xpath("//div[contains(@class,'ng-trigger ng-trigger-transformPanel')]/mat-option/span[text()='" + themes_dropdown + "']")).click();
        if (driver.findElement(themesDropdownValue).getText().equals("Custom Theme")) {
            String actual_suggestion_message_heading = driver.findElements(suggestionForDropdown).get(0).getText();
            String actual_suggestion_message_body = driver.findElements(suggestionForDropdown).get(1).getText();
            Assert.assertEquals(suggestion_message, actual_suggestion_message_heading, "Expected Error Message " + suggestion_message + " But Found : " + actual_suggestion_message_heading);
            Assert.assertEquals(suggestion_message, actual_suggestion_message_body, "Expected Error Message " + suggestion_message + " But Found : " + actual_suggestion_message_body);
            driver.findElement(headingsDropdown).click();
            driver.findElement(By.xpath("//mat-option[contains(@class,'mat-mdc-option mdc-list-item')]/span[text()='" + headings_dropdown + "']")).click();
            driver.findElement(bodyDropdown).click();
            driver.findElement(By.xpath("//mat-option[contains(@class,'mat-mdc-option mdc-list-item')]/span[text()='" + body_dropdown + "']")).click();
            driver.findElement(nextButtonBranding).click();
        } else {
            driver.findElement(nextButtonBranding).click();
        }

    }

    public void validateToasterMessage(String toaster_message, String app_name) {
        if (driver.findElements(By.xpath(toasterMessages + "[text()=' " + toaster_message + " ']")).size() > 0) {
            String toaster = driver.findElement(By.xpath(toasterMessages + "[text()=' " + toaster_message + " ']")).getText();
            Assert.assertEquals(toaster_message, toaster, "Expected Error Message " + toaster_message + " But Found : " + toaster);
        }
        if (driver.findElements(errorProjectExists).size() > 0) {
            driver.findElement(appNameField).clear();
            driver.findElement(appNameField).sendKeys(app_name + "" + rand_int);
            clickNextToThemes();
        } else {
            System.out.println("Error in The Code");
        }

    }


}
