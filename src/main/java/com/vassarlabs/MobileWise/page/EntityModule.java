package com.vassarlabs.MobileWise.page;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EntityModule {
    WebDriver driver;

    public EntityModule(WebDriver driver) {
        this.driver = driver;
    }

    private By Mobileapp = By.xpath("//div[text()=' Demo Application 314 ']");
    private By entityModule = By.xpath("//div[@class='smidemenu-container']/ul/li[3]");
    private By addNewEntity = By.xpath("//span[text()=' Add Entity ']/..");
    private By addEntityPopUpHeading = By.xpath("//span[text()='Add Entity']");
    private By editEntityPopUpHeading = By.xpath("//span[text()='Edit Entity']");
    private By addEntityTextField = By.xpath("//input[@placeholder='Entity Name']");
    private By addEntityCancelButton = By.xpath("//span[text()='Cancel']/..");
    private By addEntitySaveButton = By.xpath("//span[text()='Save']/..");
    private By addedEntityName = By.xpath("//span[text()='New Enity']");
    private By matpanelTitle = By.xpath("//mat-panel-title[contains(@class,'mat-expansion-panel-header-title')]/span");
    boolean entityCreatedFlag = false;
    boolean editedEntityFlag = false;

    public void clickOnEntityModule() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(Mobileapp));
        driver.findElement(Mobileapp).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(entityModule));
        driver.findElement(entityModule).click();
    }

    public void clickOnAddEntityButton() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(addNewEntity).click();
    }

    public void validateAddEntityPopUp(String entity_names) throws Throwable {
        Thread.sleep(2000);
        boolean flag = true;
        String[] entity = entity_names.split(",");
        for (int e = 0; e < entity.length; e++) {
            if (e > 0) {
                clickOnAddEntityButton();
            }
            Thread.sleep(3000);
            driver.findElement(addEntityCancelButton).click();
            Thread.sleep(3000);
            driver.findElement(addNewEntity).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.presenceOfElementLocated(addEntityPopUpHeading));
            String text = driver.findElement(addEntityPopUpHeading).getText().trim();
            String message = "Add Entity";
            Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
            driver.findElement(addEntityTextField).sendKeys(entity[e]);
            if (driver.findElements(By.xpath("//mat-hint[text()='Entity name already exist']")).size() > 0) {
                Thread.sleep(3000);
                String text1 = driver.findElement(By.xpath("//mat-hint[text()='Entity name already exist']")).getText().trim();
                String message1 = "Entity name already exist";
                Assert.assertEquals(text1, message1, "Expected Error Message " + text1 + " But Found : " + message1);
                flag = false;
            } else {
                if (!(driver.findElements(By.xpath("//span[text()='Save']/parent::button[@disabled='true']")).size() > 0)) {
                    Thread.sleep(3000);
                    driver.findElement(addEntitySaveButton).click();
                    entityCreatedFlag = true;
                }
            }
            if (flag) {
                if (driver.findElements(addedEntityName).size() > 0) {
                    Thread.sleep(3000);
                    if (driver.findElement(addedEntityName).getText().trim().equals(entity[e])) {
                        String text1 = driver.findElement(addedEntityName).getText().trim();
                        Assert.assertEquals(text1, entity[e], "Expected Error Message " + text + " But Found : " + entity[e]);
                    }
                }
            }
        }
    }

    public void validateEditEntityPopUp(String entity_names, String new_entity_names) throws Throwable {
        Thread.sleep(2000);
        String[] entity_name = entity_names.split(",");
        for (int e = 0; e < entity_name.length; e++) {
            if (entityCreatedFlag) {
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../..")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../..//div/button//mat-icon[text()='edit']/..")).click();
                Thread.sleep(3000);
                String text = driver.findElement(editEntityPopUpHeading).getText().trim();
                String message = "Edit Entity";
                Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
                Thread.sleep(3000);
                String text1 = driver.findElement(addEntityTextField).getAttribute("value");
                Assert.assertEquals(text1, entity_name[e], "Expected Error Message " + text + " But Found : " + entity_name[e]);
                driver.findElement(addEntityTextField).clear();
                driver.findElement(addEntityTextField).sendKeys(new_entity_names.split(",")[e]);
                if (driver.findElements(By.xpath("//mat-hint[text()='Entity name already exist']")).size() > 0) {
                    Thread.sleep(3000);
                    String text2 = driver.findElement(By.xpath("//mat-hint[text()='Entity name already exist']")).getText().trim();
                    String message1 = "Entity name already exist";
                    Assert.assertEquals(text2, message1, "Expected Error Message " + text2 + " But Found : " + message1);
                } else {
                    if (driver.findElements(By.xpath("//span[text()='Save']/parent::button[@disabled='true']")).isEmpty()) {
                        Thread.sleep(3000);
                        driver.findElement(addEntitySaveButton).click();
                        System.out.println("clicked save button");
                    }
                }
                if (driver.findElements(By.xpath("//div[text()=' entity is updated ']")).size() > 0) {
                    Thread.sleep(3000);
                    String text2 = driver.findElement(By.xpath("//div[text()=' entity is updated ']")).getText().trim();
                    String message1 = "entity is updated";
                    Assert.assertEquals(text2, message1, "Expected Error Message " + text2 + " But Found : " + message1);
                    editedEntityFlag = true;
                }
            }
        }
    }

    public void validateDeleteFucntionality(String new_entity_name,String entity_names) throws Throwable {
        if (editedEntityFlag && entityCreatedFlag) {
            Thread.sleep(2000);
            if(driver.findElements(By.xpath("//span[text()='" + new_entity_name + "']/../../..")).size()>0) {
                if(!(new_entity_name.equals("User Details"))) {
                    driver.findElement(By.xpath("//span[text()='" + new_entity_name + "']/../../..")).click();
                    driver.findElement(By.xpath("//span[text()='" + new_entity_name + "']/../..//div/button//mat-icon[text()='delete']/..")).click();
                }
            }
            else if(driver.findElements(By.xpath("//span[text()='" + entity_names + "']/../../..")).size()>0){
                driver.findElement(By.xpath("//span[text()='" + entity_names + "']/../../..")).click();
                driver.findElement(By.xpath("//span[text()='" + entity_names + "']/../..//div/button//mat-icon[text()='delete']/..")).click();
            }
        }

    }

    public void clickOnUpdateAssociationButton(String new_entity_names) throws Throwable {
        String[] new_entity_name = new_entity_names.split(",");
        for (int e = 0; e < new_entity_name.length; e++) {
            if (editedEntityFlag) {
                Thread.sleep(4000);
                driver.findElement(By.xpath("//span[text()='" + new_entity_name[e] + "']/../../../following-sibling::div/div/button/span[text()=' Update Association ']/..")).click();
            }
        }
    }

    public void validateMappedpagesPanel(String entity_names, String mapped_pages) throws Throwable {
        String[] entity_name = entity_names.split(",");
        for (int e = 0; e < entity_name.length; e++) {
            if (entityCreatedFlag) {
                Thread.sleep(3000);
                if (e > 0) {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../..")).click();
                }
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Mapped Pages']")).click();
                Thread.sleep(2000);
                String[] MappedPages = mapped_pages.split(",");
                for (int p = 0; p < MappedPages.length; p++) {
                    String[] Pages = MappedPages[p].split("_");
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Mapped Pages']/../../../following-sibling::div//button[@color='primary']")).click();
                    driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Mapped Pages']/../../../following-sibling::div//mat-select//div[contains(@class,'mat-mdc-select-arrow-wrapper')]")).click();
                    if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='" + Pages[0] + "']")).size() > 0) {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + Pages[0] + "']")).click();
                    } else {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Mapped Pages']/../../../following-sibling::div//mat-select//div[contains(@class,'mat-mdc-select-arrow-wrapper')]")).click();
                    }
                    boolean var = Boolean.parseBoolean(Pages[1]);
                    System.out.println(var);
                    if (var) {
                        if (driver.findElements(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Mapped Pages']/../../../following-sibling::div//span[text()='" + Pages[0] + "']/..//button[@color='warn']")).size() > 0) {
                            driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Mapped Pages']/../../../following-sibling::div//span[text()='" + Pages[0] + "']/..//button[@color='warn']")).click();
                        }
                    }
                }
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../following-sibling::div/div/button/span[text()=' Update Association ']/..")).click();

            }
        }
    }

    public void validateRelatedEntityPanel(String entity_names, String related_entity) throws Throwable {
        if (entityCreatedFlag) {
            String[] entity_name = entity_names.split(",");
            for (int e = 0; e < entity_name.length; e++) {
                Thread.sleep(3000);
                if (e > 0) {
                    driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../..")).click();
                }
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']")).click();
                driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-select//div[contains(@class,'mat-mdc-select-arrow-wrapper')]")).click();
                if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='" + related_entity + "']")).size() > 0) {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + related_entity + "']")).click();
                } else {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-select//div[contains(@class,'mat-mdc-select-arrow-wrapper')]")).click();
                }
                if (driver.findElements(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-form-field//div/div/div/label/mat-label[text()='Parent Entity Field']/../following-sibling::mat-select/div/div/following-sibling::div")).size() > 0) {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-form-field//div/div/div/label/mat-label[text()='Parent Entity Field']/../following-sibling::mat-select/div/div/following-sibling::div")).click();
                    if (driver.findElements(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-form-field//div/div/div/label/mat-label[text()='Parent Entity Field']/../../../../following-sibling::div//mat-hint[text()='No parent fields']")).size() > 0) {
                        Thread.sleep(3000);
                        String hint = driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-form-field//div/div/div/label/mat-label[text()='Parent Entity Field']/../../../../following-sibling::div//mat-hint[text()='No parent fields']")).getText().trim();
                        String mess = "No parent fields";
                        Assert.assertEquals(hint, mess, "Expected Error Message " + mess + " But Found : " + hint);
                    }
                    driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-form-field//div/div/div/label/mat-label[text()='Child Entity Field']/../following-sibling::mat-select/div/div/following-sibling::div")).click();
                    if (driver.findElements(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-form-field//div/div/div/label/mat-label[text()='Child Entity Field']/../../../../following-sibling::div//mat-hint[text()='No child fields']")).size() > 0) {
                        Thread.sleep(3000);
                        String hint = driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../..//mat-panel-title/span[text()='Related Entities']/../../../following-sibling::div//mat-form-field//div/div/div/label/mat-label[text()='Child Entity Field']/../../../../following-sibling::div//mat-hint[text()='No child fields']")).getText().trim();
                        String mess = "No child fields";
                        Assert.assertEquals(hint, mess, "Expected Error Message " + mess + " But Found : " + hint);
                    }
                }
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='" + entity_name[e] + "']/../../../following-sibling::div/div/button/span[text()=' Update Association ']/..")).click();
            }
        }
    }

}
