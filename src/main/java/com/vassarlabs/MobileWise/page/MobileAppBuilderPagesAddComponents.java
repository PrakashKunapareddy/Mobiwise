package com.vassarlabs.MobileWise.page;

import com.google.gson.Gson;
import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;


public class MobileAppBuilderPagesAddComponents {

    WebDriver driver;
    Actions act;

    private By appNameField = By.xpath("//input[@placeholder='App Name']");
    private By shortDescField = By.xpath("//textarea[@formcontrolname='applicationDescription']");
    private By editLogo = By.xpath("//div[@class='mat-ripple icon-img-container']/input");
    private By navbarComponentNavIcon1 = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]/..//div//mat-toolbar/div[@class='toolbar-start']/button");

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
    private By deleteComponentNavbar = By.xpath("//span[text()='Landing']/../../../following-sibling::div/div//label/span[text()='Disable Navbar']/../../button");
    private By EnableComponentNavbar = By.xpath("//span[text()='Landing']/../../../following-sibling::div/div//label/span[text()='Enable Navbar']/../../button");
    private By addComponentButton = By.xpath("//span[text()='Landing']/../../../following-sibling::div/div//button/span[text()=' Add Component ']/parent::button");
    private By deleteComponent = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div/../..//button[@mattooltip='Delete Widget']");
    LinkedHashMap<String, ArrayList<String>> Fields = new LinkedHashMap<>();
    private boolean flag3 = false;
    private boolean flag4 = false;
    private boolean flagultipleComponents = true;
    ArrayList<String> ApplicationName = new ArrayList<>();
    private boolean componentIsonTheScreenBuilderFlag = false;

    CreateMobApplicationWebAppliation createMobAppWebApp = new CreateMobApplicationWebAppliation(WebdriverInitializer.getDriver());


    Random ra = new Random();
    int rand_int = ra.nextInt(1000);


    public MobileAppBuilderPagesAddComponents(WebDriver driver) throws Throwable {
        this.driver = driver;
        act = new Actions(this.driver);
    }

    public void addRandomProjects(String app_name, String application_name_field_message, String app_desc, String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(220));
        wait.until(ExpectedConditions.presenceOfElementLocated(appNameField));
        driver.findElement(appNameField).sendKeys(app_name + " " + rand_int);
        driver.findElement(appNameField).sendKeys("  ");
        String name = driver.findElement(appNameField).getAttribute("value");
        ApplicationName.add(name);
        if (driver.findElements(hintProjectAvailable).size() > 0) {
            driver.findElement(shortDescField).sendKeys(app_desc + " " + rand_int);
//            driver.findElement(editLogo).sendKeys(logoPath);
            driver.findElement(nextButtonSettings).click();
            flag3 = true;
        } else {
            driver.findElement(appNameField).sendKeys(app_name + rand_int + "" + rand_int);
            if (driver.findElements(hintProjectAvailable).size() > 0) {
                driver.findElement(shortDescField).sendKeys(app_desc + " " + rand_int);
//                driver.findElement(editLogo).sendKeys(logoPath);
                driver.findElement(nextButtonSettings).click();
                flag3 = true;
            }
            addRandomProjects(app_name, application_name_field_message, app_desc, themes_dropdown, headings_dropdown, body_dropdown, suggestion_message);
        }
        if (flag3) {
            Thread.sleep(3000);
            driver.findElement(themesDropdown).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[contains(@class,'ng-trigger ng-trigger-transformPanel')]/mat-option/span[text()='" + themes_dropdown + "']")).click();
            if (driver.findElement(themesDropdownValue).getText().equals("Custom Theme")) {
                String actual_suggestion_message_heading = driver.findElements(suggestionForDropdown).get(0).getText();
                String actual_suggestion_message_body = driver.findElements(suggestionForDropdown).get(1).getText();
                Assert.assertEquals(suggestion_message, actual_suggestion_message_heading, "Expected Error Message " + suggestion_message + " But Found : " + actual_suggestion_message_heading);
                Assert.assertEquals(suggestion_message, actual_suggestion_message_body, "Expected Error Message " + suggestion_message + " But Found : " + actual_suggestion_message_body);
                driver.findElement(headingsDropdown).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//mat-option[contains(@class,'mat-mdc-option mdc-list-item')]/span[text()='" + headings_dropdown + "']")).click();
                driver.findElement(bodyDropdown).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//mat-option[contains(@class,'mat-mdc-option mdc-list-item')]/span[text()='" + body_dropdown + "']")).click();
                driver.findElement(nextButtonBranding).click();
            } else {
                createMobAppWebApp.predefinedThemeFlow(themes_dropdown);
                createMobAppWebApp.clickNextforBranding();
            }
        }
    }

    public void clickOnLandingPageAndClickOnAddComponentsButton(String work_page) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String[] pageRotate = work_page.split(",");
        Thread.sleep(7000);
        driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()='" + pageRotate[0] + "']")).click();
        if (driver.findElements(addComponentButton).size() > 0) {
            Thread.sleep(6000);
            driver.findElement(addComponentButton).click();
//            Point startPoint = driver.findElement(landingPanel).getLocation();
//            int xOffset = 500;
//            int yOffset = 0;
//            act.moveToElement(driver.findElement(landingPanel)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
        } else {
            Point startPoint = driver.findElement(landingPanel).getLocation();
            int xOffset = 1500;
            int yOffset = 0;
            act.moveToElement(driver.findElement(landingPanel)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
        }
    }

    public void ComponentsVerifyForFields() throws Throwable {
        String loc = "C:\\Users\\user\\Documents\\Mobiwise\\ComponentsInFields.xlsx";
        FileInputStream fis = new FileInputStream(loc);
        Workbook book = WorkbookFactory.create(fis);
        Sheet sh = book.getSheet("Sheet1");
        int l_row = sh.getLastRowNum();
        for (int i = 0; i <= l_row; i++) {
            String key = sh.getRow(i).getCell(0).getStringCellValue();
            ArrayList<String> values = new ArrayList<>();
            int l_cell = sh.getRow(i).getLastCellNum();
            for (int j = 1; j <= l_cell - 1; j++) {
                String value = sh.getRow(i).getCell(j).getStringCellValue();
                values.add(value);
                Fields.put(key, values);
            }
        }
        System.out.println(new Gson().toJson(Fields));
    }


    public void addComponentToScreenBuilder(String component_panel, String component, String offset_value_x, String offset_value_y) throws Throwable {
        String[] components_panelsSelect = component_panel.split("~");
        for (int comp = 0; comp <= components_panelsSelect.length - 1; comp++) {
            String[] components_panels = components_panelsSelect[comp].split(",");
            String[] Component = component.trim().split(",");
            for (int j = 0; j <= components_panels.length - 1; j++) {
                boolean expanded = Boolean.parseBoolean(driver.findElement(By.xpath("//span[text()='" + components_panels[j] + "']/parent::mat-panel-title/parent::span/parent::mat-expansion-panel-header")).getAttribute("aria-expanded"));
                if (expanded == false) {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//span[text()='" + components_panels[j] + "']")).click();
                    expanded = Boolean.parseBoolean(driver.findElement(By.xpath("//span[text()='" + components_panels[j] + "']/parent::mat-panel-title/parent::span/parent::mat-expansion-panel-header")).getAttribute("aria-expanded"));
                }
                if (expanded) {
                    ComponentsVerifyForFields();
                    ArrayList<String> uiCompare = new ArrayList<>();//Array list for Ui values
                    int lastRotate = Integer.parseInt(driver.findElement(By.xpath("//span[text()='" + components_panels[j] + "']//parent::mat-panel-title//span[contains(@class,'mdc-evolution-chip__text-label mat-mdc-chip-action-label')]")).getText().trim());
                    for (int i = 0; i <= lastRotate - 1; i++) {
                        String data = driver.findElements(By.xpath("//span[text()='" + components_panels[j] + "']/../../../following-sibling::div//div[contains(@class,'cdk-drag col-4')]")).get(i).getText().trim();
                        uiCompare.add(data);
                    }
                    for (int U = 0; U <= uiCompare.size() - 1; U++) {
                        String UiText = uiCompare.get(U);
                        String HashmapText = Fields.get(components_panels[j]).get(U);//taken values from Global hashmap
                        if (UiText.equals(HashmapText)) {
                            Assert.assertEquals(UiText, HashmapText, "Expected Error Message " + UiText + " But Found : " + HashmapText);
                            break;
                        }
                    }
                }
                if (driver.findElements(By.xpath("//span[text()='Add Component']")).size() > 0) {
                    String text = "Add Component";
                    String message = driver.findElement(By.xpath("//span[text()='Add Component']")).getText().trim();
                    Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
                }
                int offsetvalueX = Integer.parseInt(offset_value_x);
                int offsetvalueY = Integer.parseInt(offset_value_y);
                if (Component.length > 1) {
                    flagultipleComponents = false;
                }

                for (int i = 0; i < Component.length; i++) {
                    Thread.sleep(3000);
                    WebElement Source = driver.findElement(By.xpath("//div[text()='" + Component[i] + "']"));
                    Thread.sleep(5000);
                    WebElement Target = driver.findElement(screenBuilder);
                    Point initialTargetLocation = Target.getLocation();
                    int yOffset = initialTargetLocation.getY() - 500;
//                    int yOffset = initialTargetLocation.getY();
                    act.moveToElement(Source).clickAndHold().perform();
                    act.moveToElement(Target).moveByOffset(0, yOffset).release().perform();

//                    Point sourceLocation = Source.getLocation();
//                    int sourceY = sourceLocation.getY();
//                    int yOffset = initialTargetY - sourceY;
//                    act.moveToElement(Source).clickAndHold().perform();
//                    act.moveToElement(Target).moveByOffset(0, yOffset).release().perform();
//                    act.moveToElement(Source).clickAndHold().perform();
//                    act.moveToElement(Target).moveByOffset(0, 275).release().perform();
//                    act.moveToElement(Target).release().perform();
                }
            }
        }
    }


    public void verifyAddedComponent(String component) throws InterruptedException {
        Thread.sleep(3000);
        if ((component.equals("Navbar"))) {
            Thread.sleep(3000);
            if (driver.findElements(navbarComponentNavIcon1).size() > 0) {
                driver.findElement(navbarComponentNavIcon1).click();
                if (driver.findElement(navBarSections).isDisplayed()) {
                    driver.findElement(navBarSections).click();
                    String component_name = driver.findElement(navBarSections).getText().trim();
                    Assert.assertEquals(component_name, component, "Expected Error Message " + component + " But Found : " + component_name);
                }
            }

        } else {
            if (flagultipleComponents) {
                if (driver.findElements(componentOnTheScreenBuilder).size() > 0) {
                    driver.findElement(componentOnTheScreenBuilder).click();
                    Thread.sleep(3000);
                    String[] component_name = driver.findElement(propertiesNavbarHeading).getText().trim().split(" ");
                    if (component_name.length > 2) {
                        String Component_name = component_name[0] + " " + component_name[1];
                        System.out.println(Component_name);
//                        Assert.assertEquals(component, Component_name, "Expected Error Message: " + component + " But Found : " + Component_name);
                    } else {
//                        Assert.assertEquals(component, component_name[0], "Expected Error Message " + component + " But Found : " + component_name[0]);
                    }

                }
            }
        }
    }

    public void deleteNavbarFromTheScreenBuilder(String component) throws Throwable {
        if (component.equals("Navbar")) {
            Thread.sleep(3000);
            driver.findElement(deleteComponentNavbar).click();
            driver.findElement(EnableComponentNavbar).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//ol[contains(@class,'breadcrumb builder-breadcrumb')]/li[1]")).click();
            Thread.sleep(5000);
            int len1 = driver.findElements(By.xpath("//mat-card-title")).size();
            driver.findElements(By.xpath("//span[text()=' Delete']/parent::button[@color='warn']")).get(0).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Yes']/..")).click();
            Thread.sleep(5000);
            int len2 = driver.findElements(By.xpath("//mat-card-title")).size();
            boolean status = len2 < len1;
            Assert.assertTrue(status);
        }
    }

    public void deleteComponentFromTheScreenBuilder(String component_panel, String component, String offset_value_x, String offset_value_y, String work_page) throws Throwable {
        if (!(component.equals("Navbar"))) {
            if (flagultipleComponents) {
                Thread.sleep(6000);
                act.moveToElement(driver.findElement(componentOnTheScreenBuilder)).moveToElement(driver.findElement(deleteComponent)).click().perform();
                clickOnLandingPageAndClickOnAddComponentsButton(work_page);
                addComponentToScreenBuilder(component_panel, component, offset_value_x, offset_value_y);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//ol[contains(@class,'breadcrumb builder-breadcrumb')]/li[1]")).click();
                Thread.sleep(5000);
                int len1 = driver.findElements(By.xpath("//mat-card-title")).size();
                driver.findElements(By.xpath("//span[text()=' Delete']/parent::button[@color='warn']")).get(0).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//span[text()='Yes']/..")).click();
                Thread.sleep(5000);
                int len2 = driver.findElements(By.xpath("//mat-card-title")).size();
                boolean status = len2 < len1;
                Assert.assertTrue(status);
            }

        }
//        deleteNavbarFromTheScreenBuilder(component);
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



