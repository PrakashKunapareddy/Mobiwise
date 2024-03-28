package com.vassarlabs.MobileWise.page;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class CreateAProject {
    WebDriver driver;
    Actions act;
    private By addComponentsButton = By.xpath("//span[text()=' Add Component ']");
    private By publishModule = By.xpath("//div[@class='smidemenu-container']/ul/li[5]");
    private By mobileAppHeadingInNavBar = By.xpath("//div[contains(@class,'app-Name')]/h4");
    private By clickActionSubmitPreviewToggle = By.xpath("//h4[text()='Preview']/../mat-slide-toggle/div/button");
    private By saveComponentForSubmit = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div/md-filled-button");
    private By navbarComponentNavIcon1 = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]/..//div//mat-toolbar/div[@class='toolbar-start']/button");
    private By navbarComponentNavtitle = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]/..//div//mat-toolbar/div[@class='toolbar-title']");
    private By navbarDisplayiconDropdown = By.xpath("//mat-label[text()='Display Icon']/../../../following-sibling::div//div/following-sibling::div");
    private By selectActionTypeDropdown = By.xpath("//mat-label[text()='Select Action Type']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By selctPageDropdownClickActions = By.xpath("//mat-label[text()='Select Page']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By saveButtonForClickActions = By.xpath("//mat-label[text()='Select Page']/../../../../../../../following-sibling::div/button/span[text()='Save']");
    private By saveButtonForPreviewAction = By.xpath("//div[text()='Submit']/../../../following-sibling::div//button/span[text()='Save']");
    private By navbarTitleField = By.xpath("//mat-panel-title[text()=' Nav Title Properties ']/../../following-sibling::div//input[@formcontrolname='label']");
    private By updateComponentButton = By.xpath("//button//span[text()='Update component']");
    private By clickActionsPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Click Actions']");
    private By publishMobileApp = By.xpath("//div[text()='Publish Mobile App']");
    private By publishPopUpNo = By.xpath("//span[text()='No']//parent::button");
    private By publishPopUpYes = By.xpath("//span[text()=' Yes ']//parent::button");
    private By publishAppPopUpHeading = By.xpath("//span[text()='Publish Resources']");
    private By publishApplicationCreatedSuccessfully = By.xpath("//div[text()=' Application Created Successfully! ']");
    private By PublishAppPopupSuggestionMessage = By.xpath("//p[text()='Are You Sure You Want To Publish?']");
    private By publishAppGenarationApkMessage = By.xpath("//div[@class='alert alert-warning mx-3 custom-background ng-star-inserted']");
    private By downloadApkButton = By.xpath("//span[text()=' Download APK ']/..");
    private By screenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]");
    PropertiesSideBar addProperties = new PropertiesSideBar(WebdriverInitializer.getDriver());
    MobileAppBuilderPagesAddComponents addComponentsToScreenBuilder = new MobileAppBuilderPagesAddComponents(WebdriverInitializer.getDriver());

    public CreateAProject() throws Throwable {
    }

    public CreateAProject(WebDriver driver) throws Throwable {
        this.driver = driver;
        act = new Actions(this.driver);
    }

    public void clickOnWorkPages(String work_page, String component_panel, String component, String properties, String panels, String values_comp, String page_name, String entity_name) throws Throwable {
        String[] pagesRotate = work_page.split(",");
        String[] components_panelsSelect = component_panel.split("~");
        String[] components = component.trim().split("~");
        addProperties.addPageForNavigation(page_name, entity_name);
        for (int j = 0; j < pagesRotate.length; j++) {
            if (pagesRotate[j].equals("Landing")) {
                Thread.sleep(3000);
                WebElement panelHeader = driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()='" + pagesRotate[j] + "']"));
                panelHeader.click();
                Thread.sleep(3000);
                driver.findElement(addComponentsButton).click();
                String[] components_panels = components_panelsSelect[j].split(",");
                String[] Component = components[j].split(",");
                for (int comp = 0; comp < components_panels.length; comp++) {
                    Thread.sleep(2000);
                    boolean expanded = Boolean.parseBoolean(driver.findElement(By.xpath("//span[text()='" + components_panels[comp] + "']/parent::mat-panel-title/parent::span/parent::mat-expansion-panel-header")).getAttribute("aria-expanded"));
                    if (!expanded) {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath("//span[text()='" + components_panels[comp] + "']")).click();
                        expanded = Boolean.parseBoolean(driver.findElement(By.xpath("//span[text()='" + components_panels[comp] + "']/parent::mat-panel-title/parent::span/parent::mat-expansion-panel-header")).getAttribute("aria-expanded"));
                    }
                    if (expanded) {
                        addComponentsToScreenBuilder.ComponentsVerifyForFields();
                        for (int i = 0; i < Component.length; i++) {
                            String ComponentPresent = Component[i];
                            if (addComponentsToScreenBuilder.Fields.get(components_panels[comp]).contains(ComponentPresent)) {
                                Thread.sleep(3000);
                                WebElement Source = driver.findElement(By.xpath("//div[text()='" + ComponentPresent + "']"));
                                Thread.sleep(5000);
                                WebElement Target = driver.findElement(screenBuilder);
                                Point initialTargetLocation = Target.getLocation();
                                int yOffsetValue = initialTargetLocation.getY() - 500;
                                act.moveToElement(Source).clickAndHold().perform();
                                act.moveToElement(Target).moveByOffset(0, yOffsetValue).release().perform();
                                System.out.println(ComponentPresent);
                            }
                        }
                    }
                    WebElement Source = driver.findElement(By.xpath("//div[text()='Navbar']"));
                    Thread.sleep(5000);
                    WebElement Target = driver.findElement(screenBuilder);
                    Point initialTargetLocation = Target.getLocation();
                    int yOffsetValue = initialTargetLocation.getY() - 500;
                    act.moveToElement(Source).clickAndHold().perform();
                    act.moveToElement(Target).moveByOffset(0, yOffsetValue).release().perform();
                    System.out.println("Added Navbar");
                }
                if (driver.findElements(navbarComponentNavtitle).size() > 0) {
                    driver.findElement(navbarComponentNavIcon1).click();
                    Thread.sleep(2000);
                    driver.findElement(navbarComponentNavIcon1).click();
                    driver.findElement(navbarDisplayiconDropdown).click();
                    driver.findElement(By.xpath("//mat-option[@value='menu']")).click();
                    Thread.sleep(2000);
                    driver.findElement(updateComponentButton).click();
                    driver.findElement(navbarComponentNavtitle).click();
                    driver.findElement(navbarTitleField).clear();
                    driver.findElement(navbarTitleField).sendKeys("Homepage");
                    Thread.sleep(2000);
                    driver.findElement(updateComponentButton).click();
                }
                addProperties.editPropertiesOfComponent(properties, panels, values_comp, component, page_name, work_page, component_panel, entity_name);
            } else {
                WebElement panelHeader = driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()='" + pagesRotate[j] + "']"));
                panelHeader.click();
                Thread.sleep(2000);
                if (driver.findElements(By.xpath("//span[text()='" + pagesRotate[j] + "']/../../../following-sibling::div/div//label/span[text()='Disable Navbar']/../../button")).size() > 0) {
                    driver.findElement(By.xpath("//span[text()='" + pagesRotate[j] + "']/../../../following-sibling::div/div//label/span[text()='Disable Navbar']/../../button")).click();
                }
                Thread.sleep(3000);
                driver.findElement(By.xpath("//mat-panel-title//span[text()='" + pagesRotate[j] + "']/../../../following-sibling::div//button//span[text()=' Add Component ']")).click();
                String[] components_panels = components_panelsSelect[j].split(",");
                String[] Component = components[j].split(",");
                for (int comp = 0; comp < components_panels.length; comp++) {
                    Thread.sleep(2000);
                    boolean expanded = Boolean.parseBoolean(driver.findElement(By.xpath("//span[text()='" + components_panels[comp] + "']/parent::mat-panel-title/parent::span/parent::mat-expansion-panel-header")).getAttribute("aria-expanded"));
                    if (!expanded) {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath("//span[text()='" + components_panels[comp] + "']")).click();
                        expanded = Boolean.parseBoolean(driver.findElement(By.xpath("//span[text()='" + components_panels[comp] + "']/parent::mat-panel-title/parent::span/parent::mat-expansion-panel-header")).getAttribute("aria-expanded"));
                    }
                    if (expanded) {
                        addComponentsToScreenBuilder.ComponentsVerifyForFields();
                        for (int i = 0; i < Component.length; i++) {
                            String ComponentPresent = Component[i];
                            if (addComponentsToScreenBuilder.Fields.get(components_panels[comp]).contains(ComponentPresent)) {
                                Thread.sleep(3000);
                                WebElement Source = driver.findElement(By.xpath("//div[text()='" + ComponentPresent + "']"));
                                Thread.sleep(5000);
                                WebElement Target = driver.findElement(screenBuilder);
                                Point initialTargetLocation = Target.getLocation();
                                int yOffsetValue = initialTargetLocation.getY() - 500;
                                act.moveToElement(Source).clickAndHold().perform();
                                act.moveToElement(Target).moveByOffset(0, yOffsetValue).release().perform();
                                System.out.println(ComponentPresent);
                            }
                        }
                    }
                }
                addProperties.editPropertiesOfComponent(properties, panels, values_comp, component, page_name, work_page, component_panel, entity_name);
                if (driver.findElements(By.xpath("//span[text()='" + pagesRotate[j] + "']/../../../following-sibling::div/div//label/span[text()='Enable Navbar']/../../button")).size() > 0) {
                    driver.findElement(By.xpath("//span[text()='" + pagesRotate[j] + "']/../../../following-sibling::div/div//label/span[text()='Enable Navbar']/../../button")).click();
                }
                if (pagesRotate[j].equals("Page1")) {
                    if (driver.findElements(navbarComponentNavtitle).size() > 0) {
                        driver.findElement(navbarComponentNavIcon1).click();
                        driver.findElement(navbarComponentNavIcon1).click();
                        driver.findElement(navbarDisplayiconDropdown).click();
                        driver.findElement(By.xpath("//mat-option[@value='arrow_back']")).click();
                        addProperties.clickOnUpdateComponentButton();
                        driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Click Actions']")).click();
                        if (driver.findElements(selectActionTypeDropdown).size() > 0) {
                            Thread.sleep(3000);
                            driver.findElement(selectActionTypeDropdown).click();
                            driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' Navigation']")).click();
                            driver.findElement(selctPageDropdownClickActions).click();
                            if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='Landing']")).size() > 0) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='Landing']")).click();
                                driver.findElement(saveButtonForClickActions).click();
                            }
                        }
                        driver.findElement(navbarComponentNavtitle).click();
                        driver.findElement(navbarTitleField).clear();
                        driver.findElement(navbarTitleField).sendKeys("Add User");
                        addProperties.clickOnUpdateComponentButton();
                    }
                }
                if (pagesRotate[j].equals("Page2")) {
                    if (driver.findElements(navbarComponentNavtitle).size() > 0) {
                        driver.findElement(navbarComponentNavIcon1).click();
                        driver.findElement(navbarComponentNavIcon1).click();
                        driver.findElement(navbarDisplayiconDropdown).click();
                        driver.findElement(By.xpath("//mat-option[@value='arrow_back']")).click();
                        addProperties.clickOnUpdateComponentButton();
                        driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Click Actions']")).click();
                        if (driver.findElements(selectActionTypeDropdown).size() > 0) {
                            driver.findElement(selectActionTypeDropdown).click();
                            driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' Navigation']")).click();
                            driver.findElement(selctPageDropdownClickActions).click();
                            if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='Page1']")).size() > 0) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='Page1']")).click();
                                driver.findElement(saveButtonForClickActions).click();
                            }
                        }
                        driver.findElement(navbarComponentNavtitle).click();
                        driver.findElement(navbarTitleField).clear();
                        driver.findElement(navbarTitleField).sendKeys("Address Details User");
                        addProperties.clickOnUpdateComponentButton();
                        driver.findElement(saveComponentForSubmit).click();
                        if (driver.findElements(clickActionsPanel).size() > 0) {
                            driver.findElement(clickActionsPanel).click();
                            Thread.sleep(1000);
                            driver.findElement(selectActionTypeDropdown).click();
                            driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' Submit']")).click();
                            Thread.sleep(3000);
                            driver.findElement(clickActionSubmitPreviewToggle).click();
                            driver.findElement(saveButtonForPreviewAction).click();
                        }
                    }
                }
                if (pagesRotate[j].equals("Page3")) {
                    if (driver.findElements(navbarComponentNavtitle).size() > 0) {
                        driver.findElement(navbarComponentNavIcon1).click();
                        driver.findElement(navbarComponentNavIcon1).click();
                        driver.findElement(navbarDisplayiconDropdown).click();
                        driver.findElement(By.xpath("//mat-option[@value='arrow_back']")).click();
                        addProperties.clickOnUpdateComponentButton();
                        driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Click Actions']")).click();
                        if (driver.findElements(selectActionTypeDropdown).size() > 0) {
                            driver.findElement(selectActionTypeDropdown).click();
                            driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' Navigation']")).click();
                            driver.findElement(selctPageDropdownClickActions).click();
                            if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='Landing']")).size() > 0) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='Landing']")).click();
                                driver.findElement(saveButtonForClickActions).click();
                            }
                        }
                        driver.findElement(navbarComponentNavtitle).click();
                        driver.findElement(navbarTitleField).clear();
                        driver.findElement(navbarTitleField).sendKeys("User Details");
                        addProperties.clickOnUpdateComponentButton();
                    }
                }
            }
        }
    }

    public void clickOnPublishButton() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(publishModule).click();
        Thread.sleep(2000);
        driver.findElement(publishMobileApp).click();
        driver.findElement(publishPopUpNo).click();
        Thread.sleep(2000);
        driver.findElement(publishMobileApp).click();
        if (driver.findElements(publishAppPopUpHeading).size() > 0) {
            Thread.sleep(2000);
            String message = driver.findElement(publishAppPopUpHeading).getText().trim();
            String text = "Publish Resources";
            Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
        }
        if (driver.findElements(PublishAppPopupSuggestionMessage).size() > 0) {
            String message = driver.findElement(PublishAppPopupSuggestionMessage).getText().trim();
            String text = "Are You Sure You Want To Publish?";
            Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
        }
        Thread.sleep(2000);
        driver.findElement(publishPopUpYes).click();
        String[] mess = driver.findElement(publishAppGenarationApkMessage).getText().split("\n");
        String message1 = "**Generating Your App**";
        System.out.println(message1 + " " + mess[0]);
        String message2 = "Please wait while we create your personalized experience. This process should take no more than 10-12 minutes. You can navigate away and check back later. We'll notify you once your app is ready.";
        System.out.println(message2 + " " + mess[2]);
        String message3 = "Thank you for your patience!";
        System.out.println(message3 + " " + mess[4]);
        String text = driver.findElement(By.xpath("//span[text()='Genarating the mobile APK']")).getText().trim();
        String message4 = "Genarating the mobile APK";
        Assert.assertEquals(mess[0], message1, "Expected Error Message " + mess[0] + " But Found : " + message1);
        Assert.assertEquals(mess[2], message2, "Expected Error Message " + mess[2] + " But Found : " + message2);
        Assert.assertEquals(mess[4], message3, "Expected Error Message " + mess[4] + " But Found : " + message3);
        Assert.assertEquals(text, message4, "Expected Error Message " + text + " But Found : " + message4);
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
        wait.until(ExpectedConditions.elementToBeClickable(downloadApkButton));
        String AppName = driver.findElement(mobileAppHeadingInNavBar).getText().trim() + ".apk";
        if (driver.findElements(publishApplicationCreatedSuccessfully).size() > 0) {
            String text1 = driver.findElement(publishApplicationCreatedSuccessfully).getText().trim();
            String message5 = "Application Created Successfully!";
            Assert.assertEquals(text1, message5, "Expected Error Message " + text1 + " But Found : " + message5);
        }
        driver.findElement(downloadApkButton).click();
        Thread.sleep(30000);
        File downloadedFile = new File("C:\\Users\\user\\Downloads\\" + AppName);
        String fileName = downloadedFile.getName();
        System.out.println(fileName);
        Assert.assertEquals(fileName, AppName, "Expected Error Message " + AppName + " But Found : " + fileName);

    }

}