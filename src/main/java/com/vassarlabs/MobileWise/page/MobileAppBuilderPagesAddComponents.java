package com.vassarlabs.MobileWise.page;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;
import java.util.Random;


public class MobileAppBuilderPagesAddComponents {

    WebDriver driver;
    Actions act;

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
    private By propertiesNavbarHeading = By.xpath("//div[contains(@class,'sidecontent-option-container')]/mat-toolbar/span");
    private By screenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]");
    private By componentOnTheScreenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div");
    private By navbarComponentTitle = By.xpath("//mat-toolbar/div[text()='Title']");
    private By navBarSections = By.xpath("//span[text()='Landing']/../../../following-sibling::div//div//span/mat-panel-title[text()=' Navbar ']");
    private boolean flag3 = false;
    private boolean flag4 = false;
    CreateMobApplicationWebAppliation createMobAppWebApp = new CreateMobApplicationWebAppliation(WebdriverInitializer.getDriver());


    Random ra = new Random();
    int rand_int = ra.nextInt(1000);


    public MobileAppBuilderPagesAddComponents(WebDriver driver) throws Throwable {
        this.driver = driver;
        act = new Actions(this.driver);
    }

    public void addRandomProjects(String app_name, String application_name_field_message, String app_desc, String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message) throws Throwable {
        Thread.sleep(3000);
        driver.findElement(appNameField).sendKeys(app_name + " " + rand_int);
        driver.findElement(appNameField).sendKeys("  ");
        if (driver.findElements(hintProjectAvailable).size() > 0) {
            driver.findElement(shortDescField).sendKeys(app_desc + " " + rand_int);
            driver.findElement(editLogo).sendKeys(logoPath);
            Thread.sleep(3000);
            driver.findElement(nextButtonSettings).click();
            flag3 = true;
        } else {
            driver.findElement(appNameField).sendKeys(app_name + rand_int + "" + rand_int);
            addRandomProjects(app_name, application_name_field_message, app_desc, themes_dropdown, headings_dropdown, body_dropdown, suggestion_message);
        }
        if (flag3) {
            Thread.sleep(10000);
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
            } else {
                createMobAppWebApp.predefinedThemeFlow(themes_dropdown);
                createMobAppWebApp.clickNextforBranding();
            }
        }
    }

    public void clickOnLandingPageAndClickOnAddComponentsButton() throws Throwable {
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(landingPanel).click();

        Point startPoint = driver.findElement(landingPanel).getLocation();
        int xOffset = 200;
        int yOffset = 0;
        Thread.sleep(3000);
        act.moveToElement(driver.findElement(landingPanel)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
    }

    public void addComponentToScreenBuilder(String components_panel, String component) throws Throwable {
        Thread.sleep(3000);
        if (!(components_panel.equals("Navigation"))) {
            driver.findElement(By.xpath("//span[text()='" + components_panel + "']")).click();
        }
        if (driver.findElements(By.xpath("//span[text()='Add Component']")).size() > 0) {
            String text = "Add Component";
            String message = driver.findElement(By.xpath("//span[text()='Add Component']")).getText().trim();
            Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
        }
        Thread.sleep(3000);
        WebElement Source = driver.findElement(By.xpath("//div[text()='" + component + "']"));
        WebElement Target = driver.findElement(screenBuilder);
        act.moveToElement(Source).clickAndHold().perform();
        act.moveByOffset(500, 0).perform();
        act.moveToElement(Target).release().perform();
    }

    public void verifyAddedComponent(String component) throws InterruptedException {
        Thread.sleep(3000);
        if ((component.equals("Navbar"))) {
            Thread.sleep(3000);
            driver.findElement(navbarComponentTitle).click();
            if (driver.findElement(navBarSections).isDisplayed()) {
                driver.findElement(navBarSections).click();
                String component_name = driver.findElement(navBarSections).getText().trim();
                Assert.assertEquals(component_name, component, "Expected Error Message " + component + " But Found : " + component_name);
            } else {
                driver.findElement(navbarComponentTitle).click();
                String component_name = driver.findElement(navbarComponentTitle).getText().trim();
                String title = "Title";
                Assert.assertEquals(component_name, title, "Expected Error Message " + title + " But Found : " + component_name);

            }

        } else {
            driver.findElement(componentOnTheScreenBuilder).click();
            String[] component_name = driver.findElement(propertiesNavbarHeading).getText().trim().split(" ");
            if (component_name.length > 2) {
                String Component_name = component_name[0] + " " + component_name[1];
                Assert.assertEquals(component, Component_name, "Expected Error Message " + component + " But Found : " + Component_name);
            } else {
                Assert.assertEquals(component, component_name[0], "Expected Error Message " + component + " But Found : " + component_name[0]);

            }
        }
    }
//    WebElement shadowHost = driver.findElement(componentOnTheScreenBuilder);
//
//        // Execute JavaScript to get the shadow root
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
//
//        // Now, you can interact with elements inside the shadow root
//        WebElement elementInsideShadowRoot = shadowRoot.findElement(componentClickOnScreenBuilder);
//
//        // Example: Get the text of an element inside the shadow root
//        String component_name = elementInsideShadowRoot.getAttribute("label");

}



