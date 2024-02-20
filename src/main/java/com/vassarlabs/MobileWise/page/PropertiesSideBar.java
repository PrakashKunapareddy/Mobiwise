package com.vassarlabs.MobileWise.page;

import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PropertiesSideBar {
    WebDriver driver;
    private By backArrowPropertiesBar = By.xpath("//mat-toolbar[contains(@class,'mat-toolbar sidemenu-toolbar')]//button//mat-icon[text()='arrow_back']/parent::button");
    private By componentSideBarHeading = By.xpath("//mat-toolbar[contains(@class,'mat-toolbar sidemenu-toolbar')]//button//mat-icon[text()='arrow_back']//following::span[contains(@class,'title')]");
    private By componentOnTheScreenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div");
    private By displayTypeDropdown = By.xpath("//mat-label[text()='Display Type']/parent::label/parent::div/parent::div/following::div/mat-select/div/div//span/span/../../following-sibling::div[contains(@class,'mat-mdc-select-arrow-wrapper')]");
    private By displayTypeDropdownValue = By.xpath("//mat-label[text()='Display Type']/../../../following-sibling::div/mat-select/div/div/span/span");
    private boolean sideBarExistsFlag = false;
    private boolean panelsarePresentFlag = false;
    Actions act;
    private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> ClickActions = new LinkedHashMap<>();
    private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> Validations = new LinkedHashMap<>();
    ArrayList<String> Panels = new ArrayList<>();

    public PropertiesSideBar(WebDriver driver) throws Throwable {
        this.driver = driver;
        act = new Actions(this.driver);
    }

    public void verifyComponentSidebarofComponent(String component) throws Throwable {
        Thread.sleep(3000);
        if (!(driver.findElements(componentSideBarHeading).isEmpty())) {
            ArrayList<String> Heading = new ArrayList<>();
            String[] heading = driver.findElement(componentSideBarHeading).getText().trim().split(" ");
            for (int i = 0; i <= heading.length - 1; i++) {
                Heading.add(heading[i]);
            }
            System.out.println(Heading);
            if (Heading.contains(component)) {
                String text = component + " " + "Properties";
                String message = driver.findElement(componentSideBarHeading).getText().trim();
                Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
                sideBarExistsFlag = true;
            }
        }
    }

    public void validateBackButtonFucntionality() throws Throwable {
        if (sideBarExistsFlag) {
            Thread.sleep(3000);
            driver.findElement(backArrowPropertiesBar).click();
        }
    }

    public void panelsInTheComponentSideBar(String panels) throws Throwable {
        Thread.sleep(3000);
        driver.findElement(componentOnTheScreenBuilder).click();
        if (!(driver.findElements(componentSideBarHeading).isEmpty())) {
            String heading = driver.findElement(componentSideBarHeading).getText().trim();
            int size = driver.findElements(By.xpath("//span[text()='" + heading + "']//parent::mat-toolbar//following::div//mat-panel-title")).size();
            for (int i = 0; i <= size - 1; i++) {
                Panels.add(driver.findElements(By.xpath("//span[text()='" + heading + "']//parent::mat-toolbar//following::div//mat-panel-title")).get(i).getText().trim());
            }
            System.out.println(Panels);
            String[] panel = panels.split(",");
            for (int i = 0; i <= panel.length - 1; i++) {
                if (Panels.contains(panel[i])) {
                    Assert.assertEquals(panel[i], Panels.get(i), "Expected Error Message " + panel[i] + " But Found : " + Panels.get(i));
                    panelsarePresentFlag = true;
                }
            }
        }
    }

    public void editPropertiesOfComponent(String properties, String panels, String values) throws Throwable {
        Thread.sleep(3000);
        if (panelsarePresentFlag) {
            String heading = driver.findElement(componentSideBarHeading).getText().trim();
            int size = driver.findElements(By.xpath("//span[text()='" + heading + "']//parent::mat-toolbar//following::div//mat-panel-title")).size();
            String[] fields = properties.split(",");
            for (int i = 0; i <= size - 1; i++) {
                driver.findElements(By.xpath("//span[text()='" + heading + "']//parent::mat-toolbar//following::div//mat-panel-title")).get(i).click();
                driver.findElements(By.xpath("//span[text()='" + heading + "']//parent::mat-toolbar//following::div//mat-panel-title")).get(i).click();
                editDisplayTypeDropdowns(values);
            }
        }
    }
    public void clickActionFromExcel() throws Throwable {
        String loc = "C:\\Users\\user\\Documents\\Mobiwise\\ComponentsClickActions.xlsx";
        FileInputStream fs = new FileInputStream(loc);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        Sheet sh = workbook.getSheet("Sheet1");
        Row row = sh.getRow(0);
        int l_row = sh.getLastRowNum();
        int l_cell = row.getLastCellNum();

        String clickActions_key = sh.getRow(0).getCell(0).getStringCellValue();
        LinkedHashMap<String, ArrayList<String>> Component = new LinkedHashMap<>();
        for (int j = 1; j <= l_row; j++) {
            String Component_key = sh.getRow(j).getCell(0).getStringCellValue();

            ArrayList<String> values_list = new ArrayList<>();
            for (int k = 1; k <= l_cell - 1; k++) {
                String values = sh.getRow(j).getCell(k).getStringCellValue();
                if (values.length() > 1) {
                    values_list.add(values);
                }
            }
            Component.put(Component_key, values_list);
        }
        ClickActions.put(clickActions_key, Component);

        System.out.println(new Gson().toJson(ClickActions));
    }
    public void validationFromExcel() throws Throwable {
        String loc = "C:\\Users\\user\\Documents\\Mobiwise\\ComponentsValidations.xlsx";
        FileInputStream fs = new FileInputStream(loc);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        Sheet sh = workbook.getSheet("Sheet1");
        Row row = sh.getRow(0);
        int l_row = sh.getLastRowNum();
        int l_cell = row.getLastCellNum();

        String validations_key = sh.getRow(0).getCell(0).getStringCellValue();
        LinkedHashMap<String, ArrayList<String>> Component = new LinkedHashMap<>();
        for (int j = 1; j <= l_row; j++) {
            String Component_key = sh.getRow(j).getCell(0).getStringCellValue();

            ArrayList<String> values_list = new ArrayList<>();
            for (int k = 1; k <= l_cell - 1; k++) {
                String values = sh.getRow(j).getCell(k).getStringCellValue();
                if (values.length() > 1) {
                    values_list.add(values);
                }
            }
            Component.put(Component_key, values_list);
        }
        Validations.put(validations_key, Component);

        System.out.println(new Gson().toJson(Validations));
    }

    public void editDisplayTypeDropdowns(String values) throws Throwable {
        Thread.sleep(3000);
        if (!(driver.findElements(displayTypeDropdown).isEmpty())) {
            Thread.sleep(3000);
            driver.findElement(displayTypeDropdown).click();
            String[] value = values.split(",");
            Thread.sleep(2000);
            driver.findElement(By.xpath("////mat-option[@value='" + value[0] + "']"));
            String message = driver.findElement(displayTypeDropdownValue).getText().trim();
            Assert.assertEquals(value[0], message, "Expected Error Message " + value[0] + " But Found : " + message);
        }
    }
}






