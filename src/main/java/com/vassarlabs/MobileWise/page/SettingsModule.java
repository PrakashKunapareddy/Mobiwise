package com.vassarlabs.MobileWise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SettingsModule {
    WebDriver driver;


    private By settingsModule = By.xpath("//div[@class='smidemenu-container']/ul/li[5]");
    private By mobileAppHeading = By.xpath("//div[@class='app-name']/h3");
    private By mobileAppHeadingInNavBar = By.xpath("//div[contains(@class,'app-Name')]/h4");
    private By mobileNameBreadcrumb = By.xpath("//ol[contains(@class,'breadcrumb builder-breadcrumb')]/li[contains(@class,'breadcrumb-item active')]");
    private By editToggleButton = By.xpath("//label[text()='Edit ']/../button");
    private By nameTextField = By.xpath("//mat-label[text()='Name']/../../../following-sibling::div/input");
    private By descriptionTextField = By.xpath("//mat-label[text()='Description']/../../../following-sibling::div/textarea");
    private By descriptionCount = By.xpath("//mat-hint[contains(@class,'mat-mdc-form-field-hint mat-mdc-form-field-bottom-align')]");
    private By logoUpdate = By.xpath("//input[@type='file']");
    private By saveChangesButton = By.xpath("//span[text()='Save Changes']/..");
    boolean flag = false;

    public SettingsModule(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProject(String project) throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//mat-card-title[text()='" + project + "']/../..")).click();
    }

    public void clickOnMobileAppAndClickOnSettingsModule(String mobile_app) throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()=' " + mobile_app + " ']")).click();
        Thread.sleep(4000);
        driver.findElement(settingsModule).click();
    }

    public void verifyMobileAppAndClickOnEditButton(String mobile_app) throws Throwable {
        Thread.sleep(3000);
        String text = driver.findElement(mobileAppHeading).getText().trim();
        Assert.assertEquals(text, mobile_app, "Expected Error Message " + mobile_app + " But Found : " + text);
        Thread.sleep(2000);
        driver.findElement(editToggleButton).click();
        flag = true;
    }

    public void editFields(String new_mobile_name, String description) throws Throwable {
        Thread.sleep(2000);
        driver.findElement(nameTextField).clear();
        driver.findElement(nameTextField).sendKeys(new_mobile_name);
        driver.findElement(descriptionTextField).clear();
        driver.findElement(descriptionTextField).sendKeys(description);
        driver.findElement(logoUpdate).sendKeys("D:\\MobileWise\\Logo\\Logoimage.jpg");
        String text = driver.findElement(nameTextField).getAttribute("value").trim();
        Assert.assertEquals(text, new_mobile_name, "Expected Error Message " + new_mobile_name + " But Found : " + text);
        String text1 = driver.findElement(descriptionCount).getText().trim().split("/")[0];
        String mes = String.valueOf(description.length());
        Assert.assertEquals(text1, mes, "Expected Error Message " + mes + " But Found : " + text1);
    }
    public void verifyChangedName(String new_mobile_name)throws Throwable{
        Thread.sleep(3000);
        driver.findElement(saveChangesButton).click();
        Thread.sleep(5000);
        String [] text = {driver.findElement(mobileNameBreadcrumb).getText().trim(),driver.findElement(mobileAppHeading).getText().trim(),driver.findElement(mobileAppHeadingInNavBar).getText().trim()};
        int i = 2;
        while(i>=0) {
            Assert.assertEquals(text[i], new_mobile_name, "Expected Error Message " + new_mobile_name + " But Found : " + text[i]);
            i--;
        }
    }
}
