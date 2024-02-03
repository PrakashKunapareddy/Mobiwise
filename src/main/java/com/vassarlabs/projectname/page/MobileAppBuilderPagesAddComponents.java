package com.vassarlabs.projectname.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;


public class MobileAppBuilderPagesAddComponents {

    WebDriver driver;
    private By appNameField = By.xpath("//input[@placeholder='App Name']");
    private By shortDescField = By.xpath("//textarea[@formcontrolname='applicationDescription']");
    private By editLogo = By.xpath("//div[@class='mat-ripple icon-img-container']/input");
    private String logoPath = "D:\\MobileWise\\Logo\\logo2.webp";
    private By nextButtonSettings = By.xpath("//span[text()='Next']");
    private By hintProjectAvailable = By.xpath("//div/div/mat-hint[text()='Application name available.']");
    private By themesDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Select Themes']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By suggestionForDropdown = By.xpath("//mat-hint[text()='This is required field!']");
    private By headingsDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Headings']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By bodyDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Body']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");

    private By themesDropdownValue = By.xpath("//h3[text()='Theme']/parent::form/mat-form-field/div/div/div/following-sibling::div/mat-select/div/div/span/span");

    private By nextButtonBranding = By.xpath("//span[text()='Next']");

    private By mobileWidget = By.xpath("//div[@class='row ng-star-inserted']/div/following-sibling::div/mat-card");
    private By landingPanel = By.xpath("//span[text()='Landing']");
    private By addComponentsButton = By.xpath("//span[text()=' Add Component ']");
    private By addPageButton = By.xpath("//button/span[text()=' Add Page']");
    private By addPageTextfield = By.xpath("//input[@placeholder='Page Name']");
    private By addPageEntityTextfield = By.xpath("//input[@placeholder='Entity Name']");
    private By addPageSaveButton = By.xpath("//button/span[text()='Save']");


    private By screenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]");
    private By componentOnTheScreenBuilder = By.xpath("//div[contains(@class,'cdk-drop-list mb-section-container')]/div/div/lib-widget-filter/div/md-filled-button");
    private boolean flag3 = false;
    private boolean flag4 = false;

    private Actions act;
    Random ra = new Random();
    int rand_int = ra.nextInt(1000);


    public MobileAppBuilderPagesAddComponents(WebDriver driver) {
        this.driver = driver;
    }

    public void addRandomProjects(String app_name, String application_name_field_message, String app_desc, String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message) throws Throwable {
        Thread.sleep(3000);
        driver.findElement(appNameField).sendKeys(app_name +" "+ rand_int);
        if (driver.findElements(hintProjectAvailable).size() > 0) {
            driver.findElement(shortDescField).sendKeys(app_desc  +" "+ rand_int);
            driver.findElement(editLogo).sendKeys(logoPath);
            Thread.sleep(3000);
            driver.findElement(nextButtonSettings).click();
            flag3 = true;
        } else {
            driver.findElement(appNameField).sendKeys(app_name + rand_int + "" + rand_int);
            addRandomProjects(app_name, application_name_field_message, app_desc, themes_dropdown, headings_dropdown, body_dropdown, suggestion_message);
        }
        if (flag3) {
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
                Thread.sleep(3000);
                driver.findElement(nextButtonBranding).click();
            }
        }
    }

    public void clickOnLandingPageAndClickOnAddComponentsButton() throws Throwable {
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(addPageButton).click();
        Thread.sleep(3000);
        driver.findElement(addPageTextfield).sendKeys("Demo");
        driver.findElement(addPageEntityTextfield).sendKeys("Demo");
        flag4=true;
        if(flag4){
            Thread.sleep(3000);
            driver.findElement(addPageSaveButton).click();
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Demo']")).click();
        Thread.sleep(3000);
       driver.findElement(addComponentsButton).click();
    }

    public void addComponentToScreenBuilder(String components_panel, String component) {
        driver.findElement(By.xpath("//span[text()='" + components_panel + "']")).click();
        WebElement Source = driver.findElement(By.xpath("//span[text()='" + component + "']"));
        WebElement Target = driver.findElement(screenBuilder);
        act.dragAndDrop(Source, Target).build().perform();
    }

    public void verifyAddedComponent(String component) throws InterruptedException {
        Thread.sleep(3000);
        String component_name = driver.findElement(componentOnTheScreenBuilder).getText();
        Assert.assertEquals(component, component_name, "Expected Error Message " + component + " But Found : " + component_name);
    }

}



