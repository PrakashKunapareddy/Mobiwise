package com.vassarlabs.MobileWise.page;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataListDummy {
    WebDriver driver;


    public DataListDummy(WebDriver driver) throws Throwable {
        this.driver = driver;
    }

    PropertiesSideBar addProperties = new PropertiesSideBar(WebdriverInitializer.getDriver());
    DataList dataList = new DataList(WebdriverInitializer.getDriver());
    CreateAProject createAProject = new CreateAProject(WebdriverInitializer.getDriver());

    private By Mobileapp = By.xpath("//div[text()=' Demo Mobile 274   ']");
    private By page3 = By.xpath("//span[text()='Page3']");
    private By DataListOnScreenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div");
    public void clickonmobileappandpage() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(Mobileapp).click();
        Thread.sleep(5000);
        driver.findElement(page3).click();
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
