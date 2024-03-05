package com.vassarlabs.MobileWise.page;

import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DataList {
    WebDriver driver;
    Actions act;

    public DataList(WebDriver driver) throws Throwable {
        this.driver = driver;
        act = new Actions(this.driver);
    }

    private By dataListPropertiesPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/div/div[text()=' Data List Properties']");
    private By dataListTypeDropdown = By.xpath("//mat-label[text()='Data List Type']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By entityDropdown = By.xpath("//mat-label[text()='Entity']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By cardDesignPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/div/div[text()=' Card Design']");
    private By lhsAddField = By.xpath("//h6[text()='LHS']/parent::div//button");
    private By lhsFielddeleteButton = By.xpath("//h6[text()='LHS']/../div/div/div/button");
    private By rhsAddField = By.xpath("//h6[text()='RHS']/parent::div//button");
    private By rhsFielddeleteButton = By.xpath("//h6[text()='RHS']/../div/div/div/button");
    private By lhsSelectField = By.xpath("//mat-label[text()='Select Field']/../parent::div/parent::div/parent::div/parent::div/parent::mat-form-field/parent::div/parent::div/parent::div/h6[text()='LHS']/parent::div/div//div/following-sibling::div/mat-select/div/div/following-sibling::div");
    private By rhsSelectField = By.xpath("//mat-label[text()='Select Field']/../parent::div/parent::div/parent::div/parent::div/parent::mat-form-field/parent::div/parent::div/parent::div/h6[text()='RHS']/parent::div/div//div/following-sibling::div/mat-select/div/div/following-sibling::div");
    private By dataListDisplayViewPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/div/div[text()='Data List Display View']");
    private By createDataListViewPage = By.xpath("//span[text()='Create Data List View Page']/parent::button");
    private By noFieldInEntityError = By.xpath("//mat-error[text()='No attributes found in the entity']");

    public void displayListProperties(String values_comp) throws Throwable {
        String[] values = values_comp.split("//?");
        Thread.sleep(3000);
        boolean expected = Boolean.parseBoolean(driver.findElement(dataListPropertiesPanel).getAttribute("aria-expanded"));
        System.out.println(expected);
        if (!expected) {
            System.out.println("i am clicking");
            driver.findElement(dataListPropertiesPanel).click();
            Thread.sleep(3000);
            driver.findElement(dataListPropertiesPanel).click();
            expected = Boolean.parseBoolean(driver.findElement(dataListPropertiesPanel).getAttribute("aria-expanded"));
            System.out.println(expected+" - inside if");
        }
//        if (expected) {
        if (driver.findElements(dataListTypeDropdown).size()>0) { ///check with devloper
            dataListType(values[values.length - 1]);
            dataListEntity(values[values.length - 1]);
            cardDesignPanel(values[values.length - 1]);
            dataListDisplayPanel(values[values.length - 1]);
            createDataListViewPage(values[values.length - 1]);
        }
    }

    public void dataListType(String values) throws Throwable {
        Thread.sleep(3000);
        driver.findElement(dataListTypeDropdown).click();
        Thread.sleep(1000);
        String[] value = values.split(",");
        driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + value[0] + "']")).click();
    }

    public void dataListEntity(String values) throws Throwable {
        Thread.sleep(3000);
        driver.findElement(entityDropdown).click();
        Thread.sleep(1000);
        String[] value = values.split(",");
        driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + value[1] + "']")).click();
    }

    public void cardDesignPanel(String values) throws Throwable {
        Thread.sleep(3000);
        boolean expected = Boolean.parseBoolean(driver.findElement(cardDesignPanel).getAttribute("aria-expanded"));
        if (expected == false) {
            driver.findElement(cardDesignPanel).click();
            expected = Boolean.parseBoolean(driver.findElement(cardDesignPanel).getAttribute("aria-expanded"));
        }
        if (expected) {
            addFieldandSelectFieldLHSandRHS(values);
        }
    }

    public void addFieldandSelectFieldLHSandRHS(String values) throws Throwable {
        Thread.sleep(3000);
        String[] value = values.split(",");
        String[] totalFields = value[2].split("@");
        String[] lhsFields = totalFields[0].split("_");
        String[] rhsFields = totalFields[1].split("_");
        if (!(driver.findElements(By.xpath("//h6[text()='LHS']/parent::div//button[@disabled='true']")).size() > 0)) {
            for (int i = 0; i <= totalFields.length - 1; i++) {
                for (int j = 0; j <= lhsFields.length - 1; j++) {
                    Thread.sleep(3000);
                    driver.findElement(lhsAddField).click();
                    driver.findElement(lhsSelectField).click();
                    if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + lhsFields[j] + "']")).size() > 0) {
                        driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + lhsFields[j] + "']")).click();
                    } else {
                        Thread.sleep(2000);
                        Point startPoint = driver.findElement(lhsSelectField).getLocation();
                        int xOffset = 30;
                        int yOffset = 0;
                        Thread.sleep(3000);
                        act.moveToElement(driver.findElement(lhsSelectField)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
                        driver.findElements(lhsFielddeleteButton).get(j).click();
                    }
                }
                for (int j = 0; j <= rhsFields.length - 1; j++) {
                    Thread.sleep(3000);
                    driver.findElement(rhsAddField).click();
                    driver.findElement(rhsSelectField).click();
                    if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + rhsFields[j] + "']")).size() > 0) {
                        driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + rhsFields[j] + "']")).click();
                    } else {
                        Thread.sleep(2000);
                        Point startPoint = driver.findElement(rhsSelectField).getLocation();
                        int xOffset = 30;
                        int yOffset = 0;
                        Thread.sleep(3000);
                        act.moveToElement(driver.findElement(rhsSelectField)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
                        driver.findElements(rhsFielddeleteButton).get(j).click();
                    }
                }
            }
        }
    }

    public void dataListDisplayPanel(String values) throws Throwable {
        boolean expected = Boolean.parseBoolean(driver.findElement(dataListDisplayViewPanel).getAttribute("aria-expanded"));
        if (expected == false) {
            driver.findElement(dataListDisplayViewPanel).click();
            expected = Boolean.parseBoolean(driver.findElement(dataListDisplayViewPanel).getAttribute("aria-expanded"));
        }
        if (expected) {
            dataListDisplayViewToggles(values);
        }

    }

    public void dataListDisplayViewToggles(String values) throws Throwable {
        Thread.sleep(3000);
        String[] value = values.split(",");
        String[] toggles = value[3].split("-");
        for (int i = 0; i <= toggles.length - 1; i++) {
            if (driver.findElements(By.xpath("//p[text()='" + toggles[i].split("_")[0] + "']/parent::div//button")).size() > 0) {
                boolean expected = Boolean.parseBoolean(toggles[i].split("_")[1]);
                if (expected) {
                    driver.findElement(By.xpath("//p[text()='" + toggles[i].split("_")[0] + "']/parent::div//button")).click();
                }
            }
        }
    }

    public void createDataListViewPage(String values) throws Throwable {
        Thread.sleep(3000);
        if (!(driver.findElements(noFieldInEntityError).size() > 0)) {
            driver.findElement(createDataListViewPage).click();
        }
    }
}
