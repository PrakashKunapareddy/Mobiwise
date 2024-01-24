package com.vassarlabs.projectname.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Random;

public class CreateProject {
    WebDriver driver;

    private By createProjectButton = By.xpath("//span[text()='Create Project']");
    private By firstCreateProjectButton = By.xpath("//span[text()=' Create Project ']");

    private By projectName = By.xpath("//input[contains(@class,'mat-mdc-input-element ng-tns')]");
    private By projectDesc = By.xpath("//textarea[contains(@class,'mat-mdc-input-element ng-tns')]");
    private By saveButton = By.xpath("//span[text()='Save']");
    private By newProjectName = By.xpath("//mat-card[contains(@class,'mat-mdc-card mdc-card mat-ripple')]/div/following-sibling::mat-card-content/mat-card-title");
    private By errorProjectExists = By.xpath("//mat-hint[contains(@class,'mat-mdc-form-field-hint')]");
    private By editButton = By.xpath("//mat-card-title[text()='Demo']/../following-sibling::mat-card-actions/button/following-sibling::button/span[text()='Edit']");

    // private By editButton = By.xpath("//mat-card-title[text()='Demo']/../following-sibling::mat-card-actions/button/following-sibling::button/span/following-sibling::mat-icon");
    private By editLogoButton = By.xpath("//div[text()='App Icon (1024px × 1024px)']/../div[1]/div/mat-icon");
    private String logoPath = "D:\\MobileWise\\Logo\\Logoimage.jpg";


    Random rand = new Random();
    int rand_int = rand.nextInt(1000);


    public CreateProject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateProjectButton() {
        if (driver.findElements(firstCreateProjectButton).size() > 0) {
            driver.findElement(firstCreateProjectButton).click();
        } else {
            driver.findElement(createProjectButton).click();
        }

    }

    public void enterProjectnameProjectdescription(String project_name, String project_description) {


        driver.findElement(projectName).sendKeys(project_name);
        driver.findElement(projectDesc).sendKeys(project_description);

    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void checkProject(String project_name) {
        if (driver.findElements(errorProjectExists).size() > 0) {
            driver.findElement(projectName).sendKeys(project_name + rand_int);
            String createdProjectName = driver.findElement(newProjectName).getText();
            Assert.assertEquals(project_name, createdProjectName, "Expected Error Message " + project_name + " But Found : " + createdProjectName);
        } else {
            String createdProjectName = driver.findElement(newProjectName).getText();
            Assert.assertEquals(project_name, createdProjectName, "Expected Error Message " + project_name + " But Found : " + createdProjectName);
        }
    }

    public void editProject(String new_project_name, String new_project_description) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (driver.findElements(editButton).size() > 0) ;
        {
            System.out.println("....");
//        driver.findElement(editButton).click();
            wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
            driver.findElement(projectName).sendKeys(new_project_name);
            driver.findElement(projectDesc).sendKeys(new_project_description);
            driver.findElement(editLogoButton).sendKeys(logoPath);
            clickSaveButton();
        }


    }


}
