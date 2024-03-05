package com.vassarlabs.MobileWise.page;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;

public class CreateAProject {
    WebDriver driver;
    Actions act;
    private By addComponentsButton = By.xpath("//span[text()=' Add Component ']");
    private By navbarComponentNavIcon1 = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]/..//div//mat-toolbar/div[@class='toolbar-start']/button");
    private By navbarComponentNavtitle = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]/..//div//mat-toolbar/div[@class='toolbar-title']");
    private By navbarDisplayiconDropdown = By.xpath("//mat-label[text()='Display Icon']/../../../following-sibling::div//div/following-sibling::div");
    private By selectActionTypeDropdown = By.xpath("//mat-label[text()='Select Action Type']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By selctPageDropdownClickActions = By.xpath("//mat-label[text()='Select Page']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By saveButtonForClickActions = By.xpath("//mat-label[text()='Select Page']/../../../../../../../following-sibling::div/button/span[text()='Save']");
    private By navbarTitleField = By.xpath("//mat-panel-title[text()=' Nav Title Properties ']/../../following-sibling::div//input[@formcontrolname='label']");
    private By updateComponentButton = By.xpath("//button//span[text()='Update component']");
    private By screenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]");
    PropertiesSideBar addProperties = new PropertiesSideBar(WebdriverInitializer.getDriver());
    MobileAppBuilderPagesAddComponents addComponentsToScreenBuilder = new MobileAppBuilderPagesAddComponents(WebdriverInitializer.getDriver());

    public CreateAProject() throws Throwable {
    }

    public CreateAProject(WebDriver driver) throws Throwable {
        this.driver = driver;
        act = new Actions(this.driver);
    }

    public void clickOnWorkPages(String work_pages, String component_panel, String component, String properties, String panels, String values_comp, String page_name, String entity_name) throws Throwable {
        String[] pagesRotate = work_pages.split(",");
        String[] components_panelsSelect = component_panel.split("~");
        String[] components = component.trim().split("~");
        addProperties.addPageForNavigation(page_name, entity_name);
        for (int j = 0; j < pagesRotate.length; j++) {
            if (pagesRotate[j].equals("Landing")) {
                Thread.sleep(3000);
                WebElement panelHeader = driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()='" + pagesRotate[j] + "']"));
                panelHeader.click();
                Thread.sleep(2000);
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
                        for (int i = 0; i < Component.length; i++){
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
                    driver.findElement(updateComponentButton).click();
                    driver.findElement(navbarComponentNavtitle).click();
                    driver.findElement(navbarTitleField).clear();
                    driver.findElement(navbarTitleField).sendKeys("Homepage");
                    Thread.sleep(2000);
                    driver.findElement(updateComponentButton).click();
                }
                addProperties.editPropertiesOfComponent(properties, panels, values_comp, component, page_name);
            } else {
                WebElement panelHeader = driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()='" + pagesRotate[j] + "']"));
                panelHeader.click();
                Thread.sleep(2000);
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
                        for (int i = 0; i < Component.length; i++){
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
                addProperties.editPropertiesOfComponent(properties, panels, values_comp, component, page_name);
                driver.findElement(By.xpath("//span[text()='" + pagesRotate[j] + "']/../../../following-sibling::div/div//label/span[text()='Enable Navbar']/../../button")).click();
                if (pagesRotate[j].equals("Page1")) {
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
}