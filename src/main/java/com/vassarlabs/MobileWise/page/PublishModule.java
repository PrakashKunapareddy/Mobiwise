package com.vassarlabs.MobileWise.page;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PublishModule {
    WebDriver driver;
    Actions act;
    private By landingPanel = By.xpath("//span[text()='Landing']");
    private By pagesModule = By.xpath("//div[@class='smidemenu-container']/ul/li[2]");

    public PublishModule(WebDriver driver) throws Throwable {
        this.driver = driver;
        act = new Actions(this.driver);

    }

    private By screenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]");
    private By textComponentOnScreenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div/div/h2[text()='Text']");

    private By deleteIconForTextComponent = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div/div/h2[text()='Text']/../../../../div/button");
    PropertiesSideBar addProperties = new PropertiesSideBar(WebdriverInitializer.getDriver());
    DataList dataList = new DataList(WebdriverInitializer.getDriver());
    CreateAProject createAProject = new CreateAProject(WebdriverInitializer.getDriver());

    private By Mobileapp = By.xpath("//div[text()=' Demo Mobile 315 ']");
    private By page3 = By.xpath("//span[text()='Page3']");
    private By DataListOnScreenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div");

    public void clickonmobileappandpage() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(Mobileapp).click();
        Thread.sleep(5000);
        driver.findElement(page3).click();
    }

    public void clickOnThePagesModuleAndClickOnTheLandingPage() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(pagesModule).click();
        Thread.sleep(3000);
        driver.findElement(landingPanel).click();
        Point startPoint = driver.findElement(landingPanel).getLocation();
        int xOffset = 1500;
        int yOffset0 = 0;
        act.moveToElement(driver.findElement(landingPanel)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset0).click().build().perform();
        driver.findElement(By.xpath("//span[text()='Form Fields']")).click();
        WebElement Source = driver.findElement(By.xpath("//div[text()='Text']"));
        Thread.sleep(5000);
        WebElement Target = driver.findElement(screenBuilder);
        Point initialTargetLocation = Target.getLocation();
        int yOffset = initialTargetLocation.getY();
//                    int yOffset = initialTargetLocation.getY();
        act.moveToElement(Source).clickAndHold().perform();
        act.moveToElement(Target).moveByOffset(0, yOffset).release().perform();
        Thread.sleep(5000);
        driver.findElement(textComponentOnScreenBuilder).click();
        Thread.sleep(2000);
        driver.findElement(deleteIconForTextComponent).click();
    }

    public void clickonthemobilebuilderandeditproperties(String values_comp) throws Throwable {
        Thread.sleep(3000);
        driver.findElement(DataListOnScreenBuilder).click();
        boolean var = dataList.displayListProperties(values_comp);
        addProperties.clickOnUpdateComponentButton();
        if (var) {
            addProperties.createNavigationForDataListPage();
        }
        createAProject.clickOnPublishButton();
    }
}
