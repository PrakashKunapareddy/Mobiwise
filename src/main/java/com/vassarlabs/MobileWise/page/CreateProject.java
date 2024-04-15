package com.vassarlabs.MobileWise.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.awt.*;
import java.time.Duration;


public class CreateProject {
    WebDriver driver;

    private By createProjectButton = By.xpath("//button[contains(@class,'mdc-button')]/span[text()=' Create Project ']");
    private By matCreateProjectButton = By.xpath("//div[contains(@class,'row')]/div/mat-card/span[text()='Create Project']");
    private By addProjectHeading = By.xpath("//div/app-new-project/h1[text()='Add Project']");

    private By projectName = By.xpath("//input[contains(@class,'mat-mdc-input-element ng-tns')]");
    private By projectDesc = By.xpath("//textarea[@placeholder='Project Description']");
    private By unchangedProjectName = By.xpath("//div/mat-card/mat-card-content/mat-card-title");
    private By saveButton = By.xpath("//span[text()='Save']");
    private By cancelButton = By.xpath("//span[text()='Cancel']");
    //    private By newProjectName = By.xpath("");
    private By editProjectHeading = By.xpath("//div/app-new-project/h1[text()='Edit Project']");
    private By errorProjectExists = By.xpath("//div/mat-hint[text()='This project name already exists!']");
    private By errorProjectRequired = By.xpath("//div/mat-error[text()=' Project name is required. ']");
    private By editLogoButton = By.xpath("//div[contains(@class,'mat-ripple icon-img-container')]/input");
    private String logoPath1 = "D:\\MobileWise\\Logo\\Logoimage.jpg";
    private String logoPath2 = "D:\\MobileWise\\Logo\\logo2.webp";

    private String invalidlogoPath = "D:\\MobileWise\\Logo\\stanley.png";

    private By errorMessageInvalidLogo = By.xpath("//div/p/small[text()='The selected image does not conform to recommended standards, which may impact the rendering of the icon within the app.']");

    private By deleteProjectPopupYes = By.xpath("//button/span[text()='Yes']");
    private By deleteProjectPopupNo = By.xpath("//button/span[text()='No']");
    private By toasterProjectDelete = By.xpath("//div[text()=' Sucessfully Deleted Project ']");
    //    private By errorMessageNullProjectName = By.xpath("//div[contains(@class,'mat-mdc-form-field-error-wrapper')]/mat-error[text()='");
//    private By errorMessageExistingProject = By.xpath("//div[contains(@class,'mat-mdc-form-field-hint-wrapper')]/mat-hint[text()='");
    private boolean flag = true;
    private boolean flagError = true;
    boolean notClickSave = true;
    private boolean flag1 = false;
    private boolean flag2 = false;
    private boolean flag3 = false;
    private boolean flag4 = false;
    private boolean flag5 = true;
    private boolean flag6 = false;
    private boolean flag7 = false;

    private boolean flag8 = false;

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
            Thread.sleep(5000);
            driver.findElement(matCreateProjectButton).click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(addProjectHeading));
        String AddProjectHeading = "Add Project";
        String addProjectHeadingVerify = driver.findElement(addProjectHeading).getText();
        Thread.sleep(2000);
        Assert.assertEquals(AddProjectHeading, addProjectHeadingVerify, "Expected Error Message " + AddProjectHeading + " But Found : " + addProjectHeadingVerify);

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
        driver.findElement(projectDesc).click();
        Thread.sleep(3000);
        if (driver.findElements(errorProjectExists).size() > 0) {
            System.out.println("Project name is exists error");
            flag = false;
            String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-hint-wrapper')]/mat-hint[text()='" + error_message + "']")).getText();
            Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
        }
        Thread.sleep(3000);
        if (driver.findElements(errorProjectRequired).size() > 0) {
            System.out.println("Project name is required error");
            flag = false;
            String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-error-wrapper')]/mat-error[text()=' " + error_message + " ']")).getText();
            Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
        }
        if (flag) {
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
        }


    }

    public void clickSaveButton(String error_message) throws Throwable {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(4000);
        if (driver.findElement(projectName).getAttribute("value").isEmpty() && error_message.contains("This project name already exists!")) {
            notClickSave = false;
        }
        if (flag) {
            Thread.sleep(5000);
            if (notClickSave) {
                driver.findElement(saveButton).click();
                flag1 = true;
            }
        }
    }

//    public void clickEnterKey() {
//        r.keyPress(KeyEvent.VK_ENTER);
//        r.keyRelease(KeyEvent.VK_ENTER);
//    }

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
        if (flag1) {
            Thread.sleep(3000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            String createdProjectName = driver.findElement(By.xpath("//mat-card[contains(@class,'mat-mdc-card mdc-card mat-ripple')]/div/following-sibling::mat-card-content/mat-card-title[text()='" + project_name + "']")).getText();
            Assert.assertEquals(project_name, createdProjectName, "Expected Error Message " + project_name + " But Found : " + createdProjectName);
        }
    }


    public void editProjectName(String project_name, String new_project_name, String error_message, String new_project_description, String error_message_image) throws Throwable {
        Thread.sleep(3000);
        if (driver.findElements(By.xpath("//mat-card-title[text()='" + project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions//button//span[text()='Edit']")).size() > 0 && (project_name != null)) {
            driver.findElement(By.xpath("//mat-card-title[text()='" + project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions//button//span[text()='Edit']")).click();
            Thread.sleep(2000);
            String EditProjectHeading = "Edit Project";
            Thread.sleep(2000);
            String editProjectHeadingVerify = driver.findElement(editProjectHeading).getText();
            Assert.assertEquals(EditProjectHeading, editProjectHeadingVerify, "Expected Error Message " + EditProjectHeading + " But Found : " + editProjectHeadingVerify);
            String project_nameVerify = project_name;
            String Projectname = driver.findElement(projectName).getAttribute("value");
            System.out.println(Projectname);
            Assert.assertEquals(Projectname, project_nameVerify, "Expected Error Message " + Projectname + " But Found : " + project_nameVerify);
            driver.findElement(projectName).clear();
            driver.findElement(projectName).sendKeys(new_project_name);
            String projDesc = driver.findElement(projectDesc).getAttribute("value");
            Thread.sleep(2000);
            driver.findElement(editProjectHeading).click();
            if (new_project_name.equals(Projectname) && new_project_description.equals(projDesc)) {
                Thread.sleep(1000);
                clickCancleButton();
            } else if (driver.findElements(errorProjectRequired).size() > 0) {
                System.out.println("Project name is required error");
                Thread.sleep(1000);
                String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-error-wrapper')]/mat-error[text()=' " + error_message + " ']")).getText();
                Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
                clickCancleButton();
            } else if (driver.findElements(errorProjectExists).size() > 0) {
                Thread.sleep(1000);
                String errormessage = driver.findElement(By.xpath("//div[contains(@class,'mat-mdc-form-field-hint-wrapper')]/mat-hint[text()='" + error_message + "']")).getText();
                Assert.assertEquals(error_message, errormessage, "Expected Error Message " + error_message + " But Found : " + errormessage);
                clickCancleButton();
            } else {
                editProjectDescription(project_name, new_project_name, new_project_description, error_message, error_message_image);
            }
        }
    }

    public void editProjectDescription(String project_name, String new_project_name, String new_project_description, String error_message, String error_message_image) throws Throwable {
        Thread.sleep(2000);
        driver.findElement(projectDesc).clear();
        driver.findElement(projectDesc).sendKeys(new_project_description);
        driver.findElement(editLogoButton).sendKeys(invalidlogoPath);
        if (driver.findElements(errorMessageInvalidLogo).size() > 0) {
            Thread.sleep(1000);
            String errormessage = driver.findElement(errorMessageInvalidLogo).getText();
            Assert.assertEquals(error_message_image, errormessage, "Expected Error Message " + error_message_image + " But Found : " + errormessage);
            flag6 = true;
        }
        if (flag6) {
            driver.findElement(editLogoButton).sendKeys(logoPath1);
            driver.findElement(saveButton).click();
            flag3 = true;
        }
    }


    public void deleteProjectNo(String new_project_name, String project_name) throws Throwable {
        if (flag3 && flag) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(6000);
            if (driver.findElements(By.xpath("//mat-card-title[text()='" + new_project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).size() > 0) {
                driver.findElement(By.xpath("//mat-card-title[text()='" + new_project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).click();
                driver.findElement(deleteProjectPopupNo).click();
            } else if (driver.findElements(By.xpath("//mat-card-title[text()='" + project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).size() > 0) {
                driver.findElement(By.xpath("//mat-card-title[text()='" + project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).click();
                driver.findElement(deleteProjectPopupNo).click();
            }
        }
    }

    public void deleteProjectYes(String new_project_name, String project_name) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (flag3 && flag) {
            Thread.sleep(6000);
            if (driver.findElements(By.xpath("//mat-card-title[text()='" + new_project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).size() > 0) {
                driver.findElement(By.xpath("//mat-card-title[text()='" + new_project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).click();
                driver.findElement(deleteProjectPopupYes).click();
            } else if (driver.findElements(By.xpath("//mat-card-title[text()='" + project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).size() > 0) {
                driver.findElement(By.xpath("//mat-card-title[text()='" + project_name + "']/parent::mat-card-content/following-sibling::mat-card-actions/button/span[text()=' Delete']")).click();
                driver.findElement(deleteProjectPopupYes).click();
            }
            validateDeletedProject(new_project_name);
        }

    }

    public void validateDeletedProject(String new_project_name) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (driver.findElements(toasterProjectDelete).size() > 0) {
//            boolean projectDeletedflag = !(driver.findElement(By.xpath("//mat-card[contains(@class,'mat-mdc-card mdc-card mat-ripple')]/div/following-sibling::mat-card-content/mat-card-title[text()='" + new_project_name + "']")).isDisplayed());
//            Assert.assertTrue(projectDeletedflag);
            String toaster = "Sucessfully Deleted Project";
            String deleteToaster = driver.findElement(toasterProjectDelete).getText().trim();
            Assert.assertEquals(toaster, deleteToaster, "Expected Error Message " + toaster + " But Found : " + deleteToaster);
        }
    }
}
