package com.vassarlabs.projectname.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;
import java.util.Random;


public class CreateProject {
    WebDriver driver;

    private By createProjectButton = By.xpath("//button[contains(@class,'mdc-button')]/span[text()=' Create Project ']");
    private By matCreateProjectButton = By.xpath("//div[contains(@class,'row')]/div/mat-card/span[text()='Create Project']");

    private By projectName = By.xpath("//input[contains(@class,'mat-mdc-input-element ng-tns')]");
    private By unchangedProjectName = By.xpath("//div/mat-card/mat-card-content/mat-card-title");

    private By projectDesc = By.xpath("//textarea[@placeholder='Project Description']");
    private By saveButton = By.xpath("//span[text()='Save']");
    private By cancelButton = By.xpath("//span[text()='Cancel']");
    //    private By newProjectName = By.xpath("");
    private By errorProjectExists = By.xpath("//div/mat-hint[text()='This project name already exists!']");
    private By errorProjectRequired = By.xpath("//div/mat-error[text()=' Project name is required. ']");
    private By editLogoButton = By.xpath("//div[contains(@class,'mat-ripple icon-img-container')]/input");
    private String logoPath1 = "D:\\MobileWise\\Logo\\Logoimage.jpg";
    private String logoPath2 = "D:\\MobileWise\\Logo\\logo2.webp";

    private String invalidlogoPath = "D:\\MobileWise\\Logo\\stanley.png";

    private By errorMessageInvalidLogo = By.xpath("//div/p/small[text()='The selected image does not conform to recommended standards, which may impact the rendering of the icon within the app.']");

    private By deleteProjectPopupYes = By.xpath("//button/span[text()='Yes']");
    private By deleteProjectPopupNo = By.xpath("//button/span[text()='No']");
    //    private By errorMessageNullProjectName = By.xpath("//div[contains(@class,'mat-mdc-form-field-error-wrapper')]/mat-error[text()='");
//    private By errorMessageExistingProject = By.xpath("//div[contains(@class,'mat-mdc-form-field-hint-wrapper')]/mat-hint[text()='");
    private boolean flag = false;
    private boolean flag1 = false;
    private boolean flag2 = false;
    private boolean flag3 = false;
    private boolean flag4 = false;
    private boolean flag5 = true;
    private boolean flag6 = false;
    private boolean flag7 = false;


    Robot r = new Robot();


    public CreateProject(WebDriver driver) throws AWTException {
        this.driver = driver;
    }

    public void clickCreateProjectButton() throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (driver.findElements(createProjectButton).size() > 0) {
            Thread.sleep(3000);
            driver.findElement(createProjectButton).click();
        } else {
            driver.findElement(matCreateProjectButton).click();
        }
    }

    public void negitiveTestForSave() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (!(driver.findElement(saveButton).isEnabled())) {
            String emptyProjectName = driver.findElement(projectName).getText();
            String Empty = null;
            Assert.assertEquals(emptyProjectName, Empty, "Expected Error Message " + emptyProjectName + " But Found : " + Empty);
        }
    }

    public void enterProjectnameProjectdescription(String project_name, String project_description, String error_message, String error_message_image) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(projectName).sendKeys(project_name);
        if (driver.findElement(projectName).getText().equals(null)) {
            String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-error-wrapper')]/mat-error[text()='" + error_message + "']")).getText();
            Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
            Thread.sleep(3000);
            flag = false;
        } else if (driver.findElements(errorProjectExists).size() > 0) {
            String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-hint-wrapper')]/mat-hint[text()='" + error_message + "']")).getText();
            Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
            Thread.sleep(3000);
            flag = false;
        } else if (driver.findElements(errorProjectRequired).size() > 0) {
            String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-error-wrapper')]/mat-error[text()='" + error_message + "']")).getText();
            Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
            Thread.sleep(3000);
            flag = false;
        } else {
            driver.findElement(projectDesc).sendKeys(project_description);
            driver.findElement(editLogoButton).sendKeys(invalidlogoPath);
            if (driver.findElements(errorMessageInvalidLogo).size() > 0) {
                Thread.sleep(3000);
                String errormessage = driver.findElement(errorMessageInvalidLogo).getText();
                Assert.assertEquals(error_message_image, errormessage, "Expected Error Message " + error_message_image + " But Found : " + errormessage);
                flag6 = true;
            }
            if (flag6) {
                driver.findElement(editLogoButton).sendKeys(logoPath1);
                flag = true;
            }

            String nullData = driver.findElement(projectName).getText();
            if (nullData.length() > 0) {
                flag = true;
            }
        }
        if (driver.findElement(projectName).getText().length() > 0) {
            if (driver.findElements(errorProjectExists).size() > 0) {
                String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-error-wrapper')]/mat-error[text()='" + error_message + "']")).getText();
                Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
                Thread.sleep(3000);
            } else {
                String s = driver.findElement(projectName).getText();
                System.out.println(s);
                flag = true;
            }
        }

    }

    public void clickSaveButton(String project_name, String error_message) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (flag) {
            Thread.sleep(3000);
            driver.findElement(saveButton).click();
            flag1 = true;
        }
    }

    public void clickEnterKey() {
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }

    public void clickCancleButton() throws Throwable {
        Thread.sleep(2000);
        if (driver.findElement(cancelButton).isEnabled()) {
            driver.findElement(cancelButton).click();
        }
    }

//    public void clickEscKey() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        r.keyPress(KeyEvent.VK_ESCAPE);
//        r.keyRelease(KeyEvent.VK_ESCAPE);
//    }

    public void checkCreatedProject(String project_name) throws Throwable {
        if (flag) {
            Thread.sleep(3000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            String createdProjectName = driver.findElement(By.xpath("//mat-card[contains(@class,'mat-mdc-card mdc-card mat-ripple')]/div/following-sibling::mat-card-content/mat-card-title[text()='" + project_name + "']")).getText();
            Assert.assertEquals(project_name, createdProjectName, "Expected Error Message " + project_name + " But Found : " + createdProjectName);
        }
    }


    public void editProjectName(String project_name, String new_project_name, String error_message) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String unchanged = driver.findElements(unchangedProjectName).get(0).getText();
        Thread.sleep(2000);
        if (flag1) {
            driver.findElement(By.xpath("//mat-card-title[text()='" + project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions//button//span[text()='Edit']")).click();
            Thread.sleep(2000);
            driver.findElement(projectName).clear();
            Thread.sleep(2000);
            driver.findElement(projectName).sendKeys(new_project_name);
            if (driver.findElement(projectName).getText().equals(null)) {
                String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-error-wrapper')]/mat-error[text()='" + error_message + "']")).getText();
                Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
            }
            if (driver.findElements(errorProjectExists).size() > 0) {
                String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-hint-wrapper')]/mat-hint[text()='" + error_message + "']")).getText();
                Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
            }

            if ((driver.findElement(projectName).getText().equals(unchanged))) {

                flag5 = false;
            }

            if (flag5) {
                Thread.sleep(2000);
                clickSaveButton(new_project_name, error_message);
            }
        }
    }

    public void editProjectDescription(String project_name, String new_project_name, String new_project_description, String error_message, String error_message_image) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        if (flag5) {
            driver.findElement(By.xpath("//mat-card-title[text()='" + new_project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions//button//span[text()='Edit']")).click();
        }
        driver.findElement(projectDesc).clear();
        driver.findElement(projectDesc).sendKeys(new_project_description);

        driver.findElement(editLogoButton).sendKeys(invalidlogoPath);
        if (driver.findElements(errorMessageInvalidLogo).size() > 0) {
            Thread.sleep(3000);
            String errormessage = driver.findElement(errorMessageInvalidLogo).getText();
            Assert.assertEquals(error_message_image, errormessage, "Expected Error Message " + error_message_image + " But Found : " + errormessage);
            flag6 = true;
        }
        if (flag6) {
            driver.findElement(editLogoButton).sendKeys(logoPath1);
            flag7 = true;
        }
        if (flag7) {
            clickSaveButton(project_name, error_message);
            flag3 = true;
        }

    }

    public void deleteProjectNo(String new_project_name) throws Throwable {
        if (flag3) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(3000);
            driver.findElement(By.xpath("//mat-card-title[text()='"+new_project_name+"']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).click();
            driver.findElement(deleteProjectPopupNo).click();
        }
    }

    public void deleteProjectYes(String new_project_name) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (flag3) {
            if (driver.findElement(By.xpath("//mat-card-title[text()='" + new_project_name + "']")).getText().equals("New Demo")) {
                flag4 = true;
            }
            if (!(flag4)) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(By.xpath("//mat-card-title[text()='" + new_project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span/following-sibling::mat-icon/following-sibling::span[text()=' Delete']")).click();
                driver.findElement(deleteProjectPopupYes).click();
            }
        }
    }
}
