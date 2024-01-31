package com.vassarlabs.projectname.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MobileAppBuilderPagesAddComponents {
    WebDriver driver;
    private By mobileWidget = By.xpath("//div[@class='row ng-star-inserted']/div/following-sibling::div/mat-card");
    private By landingPanel = By.xpath("//span[text()='Landing']");
    private By addComponentsButton = By.xpath("//span[text()=' Add Component ']");
    private By componentpanel = By.xpath("//span[text()='");
    private By screenBuilder  = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]");
    private By componentToBeAdded= By.xpath("//span[text()='");
    private By componentOnTheScreenBuilder = By.xpath("//div[contains(@class,'cdk-drop-list mb-section-container')]/div/div/lib-widget-filter/div/md-filled-button");





    Actions act = new Actions(driver);

    public MobileAppBuilderPagesAddComponents(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnTheMobileWidget(){
        driver.findElement(mobileWidget).click();
    }
    public void clickOnLandingPageAndClickOnAddComponentsButton(String components_panel, String component){
        driver.findElement(landingPanel).click();
        driver.findElement(addComponentsButton).click();
        driver.findElement(By.xpath(componentpanel+components_panel+"']")).click();
        WebElement Source = driver.findElement(By.xpath(componentToBeAdded+component+"']"));
        WebElement Target = driver.findElement(screenBuilder);
        act.dragAndDrop(Source,Target).build().perform();

    }
    public void verifyAddedComponent(String component){
        String component_name = driver.findElement(componentOnTheScreenBuilder).getText();
        Assert.assertEquals(component, component_name, "Expected Error Message " + component + " But Found : " + component_name);
    }

}



