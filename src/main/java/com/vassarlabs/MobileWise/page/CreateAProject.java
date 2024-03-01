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
                Thread.sleep(3000);
                Point startPoint = panelHeader.getLocation();
                int xOffset = 1500;
                int yOffset = 0;
                Actions act = new Actions(driver);
                act.moveToElement(panelHeader).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();

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
                        for (int i = Component.length - 1; i >= 0; i--) {
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
                                addProperties.verifyComponentSidebarofComponent(component);
                            }
                        }

                    }
                }
            } else {
                Thread.sleep(3000);
                driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()='" + pagesRotate[j] + "']")).click();
                Thread.sleep(3000);
                WebElement panelHeader = driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()='" + pagesRotate[j] + "']"));
                panelHeader.click();

                driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()='" + pagesRotate[j] + "']")).click();
                driver.findElement(By.xpath("//span[text()='" + pagesRotate[j] + "']/../../../following-sibling::div/div//label/span[text()='Disable Navbar']/../../button")).click();
                Thread.sleep(3000);
                Point startPoint = panelHeader.getLocation();
                int xOffset = 1500;
                int yOffset = 0;
                Actions act = new Actions(driver);
                act.moveToElement(panelHeader).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();

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
                        for (int i = Component.length - 1; i >= 0; i--) {
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
                                addProperties.verifyComponentSidebarofComponent(component);
                            }
                        }

                    }
                }
                Thread.sleep(2000);
                driver.findElement(By.xpath("//span[text()='" + pagesRotate[j] + "']/../../../following-sibling::div/div//label/span[text()='Enable Navbar']/../../button")).click();
            }
        }
    }
}


