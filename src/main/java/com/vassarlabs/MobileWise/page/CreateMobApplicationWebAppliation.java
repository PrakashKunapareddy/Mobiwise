package com.vassarlabs.MobileWise.page;

import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.*;

public class CreateMobApplicationWebAppliation {


    WebDriver driver;


    private By projectMatBuutton = By.xpath("//div/mat-card/mat-card-content/mat-card-title[contains(@class,'mat-mdc-card-title mat-mdc-tooltip-trigger ellipsis-input')]");  //use find eles
    private By createProjectButton = By.xpath("//button[contains(@class,'mdc-button')]/span[text()=' Create Project ']");
    private By matCreateProjectButton = By.xpath("//div[contains(@class,'row')]/div/mat-card/span[text()='Create Project']");
    private By projectName = By.xpath("//input[contains(@class,'mat-mdc-input-element ng-tns')]");
    private By projectDesc = By.xpath("//textarea[@placeholder='Project Description']");
    private By saveButton = By.xpath("//span[text()='Save']");
    private By appNameField = By.xpath("//input[@placeholder='App Name']");
    private By requiredAppNameField = By.xpath("//div/div/mat-error[text()='Application name is required!']");
    private By atleast3LettersRequired = By.xpath("//div/div/mat-error[text()=' Application name must be atleast 3 characters.']");
    //    private By shortDescFieldlabel = By.xpath("//mat-label[text()='Short Description']");
    private By shortDescField = By.xpath("//textarea[@formcontrolname='applicationDescription']");
    private By editLogo = By.xpath("//div[@class='mat-ripple icon-img-container']/input");
    private By nextButtonSettings = By.xpath("//span[text()='Next']");
    private By themesDropdownValue = By.xpath("//h3[text()='Theme']/parent::form/mat-form-field/div/div/div/following-sibling::div/mat-select/div/div/span/span");

    private By themesDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Select Themes']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By suggestionForDropdown = By.xpath("//mat-hint[text()='This is required field!']");
    private By headingsDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Headings']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By bodyDropdown = By.xpath("//div[contains(@class,'mdc-notched-outline__notch')]/label/mat-label[text()='Body']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By nextButtonBranding = By.xpath("//span[text()='Next']/parent::button");
    private String logoPath = "D:\\MobileWise\\Logo\\logo2.webp";

    private String invalidlogoPath = "D:\\MobileWise\\Logo\\stanley.png";

    private By errorProjectExists = By.xpath("//div/div/mat-hint[text()='Application name already exists!']");
    private By hintProjectAvailable = By.xpath("//div/div/mat-hint[text()='Application name available.']");

    //    private By toasterMessages = By.xpath("//div[@id='toast-container']/div/div");
    private By breadcrumbHome = By.xpath("//div/nav/ol/li[text()='Home']");
    private By homepage_validation = By.xpath("//div[@class='page-header']/div/h2[text()='Projects']");
    private By breadcrumbApplicationpage = By.xpath("//div/nav/ol/li[contains(@class,'breadcrumb-item active')]");
    private By primaryColor = By.xpath("//div[@class='color-items']/label/div[@class='content']/div[text()='Primary Color']/following-sibling::div");
    private By secondaryColor = By.xpath("//div[@class='color-items']/label/div[@class='content']/div[text()='On Primary']/following-sibling::div");
    private By defaultBackgroundColor = By.xpath("//div[@class='color-items']/label/div[@class='content']/div[text()='Default Background Color']/following-sibling::div");
    private By defaultTextColor = By.xpath("//div[@class='color-items']/label/div[@class='content']/div[text()='Default Text Color']/following-sibling::div");
    private By headingsDropdownValue = By.xpath("//div/label/mat-label[text()='Headings']/../../../following-sibling::div/mat-select/div/div/span/span");
    private By bodyDropdownValue = By.xpath("//div/label/mat-label[text()='Body']/../../../following-sibling::div/mat-select/div/div/span/span");

    LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> Headers = new LinkedHashMap<>();
    private boolean flag = false;
    private boolean flag1 = true;
    private boolean flag2 = false;
    private boolean flag3 = false;
    private boolean flag4 = false;

    private boolean flagCreateProject = false;


    Random ra = new Random();
    int rand_int = ra.nextInt(1000);
    Robot r = new Robot();

    public CreateMobApplicationWebAppliation(WebDriver driver) throws AWTException {
        this.driver = driver;
    }

    public void createRandomProjects() throws Throwable {

        if (driver.findElements(createProjectButton).size()>0) {
            driver.findElement(createProjectButton).click();
            flagCreateProject = true;
        }
        if (driver.findElements(matCreateProjectButton).size()>0) {//size>0
            Thread.sleep(2000);
            driver.findElement(matCreateProjectButton).click();
            flagCreateProject = true;
        }
        if (flagCreateProject) {
            Thread.sleep(2000);
            driver.findElement(projectName).sendKeys("Project " + rand_int);
            driver.findElement(projectDesc).sendKeys("Project Description " + rand_int);
            driver.findElement(saveButton).click();
        }

    }

    public void clickProjectMatButton() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(projectMatBuutton)));
        driver.findElements(projectMatBuutton).get(0).click();
        flag = true;
    }

    public void clickHomeOnBreadcrumb(String homepage_validation_text) throws Throwable {
        if (flag) {
            Thread.sleep(3000);
            driver.findElement(breadcrumbHome).click();
            Thread.sleep(3000);
            String message = driver.findElement(homepage_validation).getText();
            Assert.assertEquals(homepage_validation_text, message, "Expected Error Message " + homepage_validation_text + " But Found : " + message);
            Thread.sleep(3000);
            clickProjectMatButton();
            flag1 = false;
        }
    }

    public void clickApplicationPageBreadcrumb() throws InterruptedException {
        if (flag) {
            Thread.sleep(3000);
            if (driver.findElement(breadcrumbApplicationpage).isDisplayed()) {
                flag1 = true;
            }
        }
    }

    public void clickApplicationType(String application_type) throws InterruptedException {
        if (flag1) {
            Thread.sleep(7000);
            driver.findElement(By.xpath("//div[text()='" + application_type + "']")).click();
        }
    }

    public void updateNameFields(String app_name, String application_name_field_message, String app_desc) throws InterruptedException {
        driver.findElement(appNameField).sendKeys(app_name);
//        driver.findElement(appNameField).sendKeys(" ");
//        driver.findElement(appNameField).click();
//        r.keyPress(KeyEvent.VK_BACK_SPACE);
        if (!driver.findElements(hintProjectAvailable).isEmpty()) {
            flag2 = true;
            String message = driver.findElement(hintProjectAvailable).getText();
            Assert.assertEquals(application_name_field_message, message, "Expected Error Message " + application_name_field_message + " But Found : " + message);
        }
        if (!driver.findElements(errorProjectExists).isEmpty()) {//size>0
            String message = driver.findElement(errorProjectExists).getText();
            Assert.assertEquals(application_name_field_message, message, "Expected Error Message " + application_name_field_message + " But Found : " + message);
        }
        if (flag2) {
            int len = app_desc.length()-1;
            driver.findElement(shortDescField).sendKeys(app_desc);
            if(driver.findElements(By.xpath("//mat-hint")).size()>0) {
                String [] shortDescLen = driver.findElement(By.xpath("//mat-hint")).getText().trim().split("/");
                Assert.assertEquals(shortDescLen[0], len, "Expected Error Message " + shortDescLen[0] + " But Found : " + len);
            }
            driver.findElement(editLogo).sendKeys(logoPath);
        } else {
            driver.findElement(shortDescField).click();
        }
        if (!driver.findElements(requiredAppNameField).isEmpty()) {//size>0
            String message = driver.findElement(requiredAppNameField).getText();
            Assert.assertEquals(application_name_field_message, message, "Expected Error Message " + application_name_field_message + " But Found : " + message);
            flag2 = false;
        }
        if (!driver.findElements(atleast3LettersRequired).isEmpty()) {//size>0
            String message = driver.findElement(atleast3LettersRequired).getText();
            message.trim();
            Assert.assertEquals(application_name_field_message, message, "Expected Error Message " + application_name_field_message + " But Found : " + message);
            flag2 = false;
        }

    }

    public void clickNextToThemes() throws InterruptedException {
        if (flag2) {
            Thread.sleep(3000);
            driver.findElement(nextButtonSettings).click();
        }
    }

    public void compareThemesFromExcel() throws Throwable {
        String loc = "C:\\Users\\user\\Documents\\Mobiwise\\MobiwiseThemes.xlsx";
        FileInputStream fs = new FileInputStream(loc);
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        Sheet sh = workbook.getSheet("Themes");
//        Sheet sh = book.getSheet("Themes");
        Row row = sh.getRow(0);
        int l_row = sh.getLastRowNum();
        int l_cell = row.getLastCellNum();

        for (int i = 0; i < l_cell - 1; i++) {
            String header_key = sh.getRow(0).getCell(0).getStringCellValue();
            LinkedHashMap<String, ArrayList<String>> Themes = new LinkedHashMap<>();
            for (int j = 1; j <= l_row - 1; j++) {
                String themes_key = sh.getRow(j).getCell(0).getStringCellValue();
                ArrayList<String> values_list = new ArrayList<>();
                for (int k = 1; k <= l_cell - 1; k++) {
                    String values = sh.getRow(j).getCell(k).getStringCellValue();
                    values_list.add(values);
                }
                Themes.put(themes_key, values_list);
            }
            Headers.put(header_key, Themes);
        }
        System.out.println(new Gson().toJson(Headers));
    }

    public void updateThemeAndClickNext(String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message) throws Throwable {
        if (flag2) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(themesDropdown)));
            Thread.sleep(3000);
            driver.findElement(themesDropdown).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[contains(@class,'ng-trigger ng-trigger-transformPanel')]/mat-option/span[text()='" + themes_dropdown + "']")).click();
            if (driver.findElement(themesDropdownValue).getText().equals("Custom Theme")) {
                customThemeFlow(themes_dropdown, headings_dropdown, body_dropdown, suggestion_message);
            } else {
                predefinedThemeFlow(themes_dropdown);
            }

        }
    }

    public void customThemeFlow(String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message) throws Throwable {
        Thread.sleep(3000);
        String actual_suggestion_message_heading = driver.findElements(suggestionForDropdown).get(0).getText();
        String actual_suggestion_message_body = driver.findElements(suggestionForDropdown).get(1).getText();
        Assert.assertEquals(suggestion_message, actual_suggestion_message_heading, "Expected Error Message " + suggestion_message + " But Found : " + actual_suggestion_message_heading);
        Assert.assertEquals(suggestion_message, actual_suggestion_message_body, "Expected Error Message " + suggestion_message + " But Found : " + actual_suggestion_message_body);
        Thread.sleep(3000);
        driver.findElement(headingsDropdown).click();
        driver.findElement(By.xpath("//mat-option[contains(@class,'mat-mdc-option mdc-list-item')]/span[text()='" + headings_dropdown + "']")).click();
        Thread.sleep(3000);
        driver.findElement(bodyDropdown).click();
        driver.findElement(By.xpath("//mat-option[contains(@class,'mat-mdc-option mdc-list-item')]/span[text()='" + body_dropdown + "']")).click();
        flag3 = true;
    }

    public void predefinedThemeFlow(String themes_dropdown) throws Throwable {
        Thread.sleep(3000);
        System.out.println("Predefined Theme Flow");
        compareThemesFromExcel();
        ArrayList<String> uiCompare = new ArrayList<>();//Array list for Ui values
        Thread.sleep(3000);
        uiCompare.add(driver.findElement(primaryColor).getText());
        uiCompare.add(driver.findElement(secondaryColor).getText());
        uiCompare.add(driver.findElement(defaultBackgroundColor).getText());
        uiCompare.add(driver.findElement(defaultTextColor).getText());
        uiCompare.add(driver.findElement(headingsDropdownValue).getText());
        uiCompare.add(driver.findElement(bodyDropdownValue).getText());
        System.out.println(uiCompare.size());
        System.out.println("Predefined Theme Flow");
        for (int i = 0; i <= uiCompare.size() - 1; i++) {
            String UiText = uiCompare.get(i);
            for (int j = 0; j <= uiCompare.size() - 1; j++) {
                String HashmapText = Headers.get("Select Themes").get(themes_dropdown).get(j);//taken values from Global hashmap
                if (UiText.equals(HashmapText)) {
                    Assert.assertEquals(UiText, HashmapText, "Expected Error Message " + UiText + " But Found : " + HashmapText);
                    break;
                }
            }

        }
        flag3 = true;
    }


    public void clickNextforBranding() throws Throwable {
        if (flag3 || flag2) {
            Thread.sleep(3000);
            driver.findElement(nextButtonBranding).click();
        }
    }

    public void validateToasterMessage(String toaster_message, String app_name) throws Throwable {
        if (flag3) {
            Thread.sleep(3000);
            if (driver.findElements(By.xpath("//div[@id='toast-container']/div/div[text()=' " + toaster_message + " ']")).size() > 0) {
                String toaster = driver.findElement(By.xpath("//div[@id='toast-container']/div/div[text()=' " + toaster_message + " ']")).getText();
                Assert.assertEquals(toaster_message, toaster, "Expected Error Message " + toaster_message + " But Found : " + toaster);
            }
        }

    }
}


