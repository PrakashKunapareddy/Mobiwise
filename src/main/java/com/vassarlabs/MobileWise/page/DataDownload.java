package com.vassarlabs.MobileWise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DataDownload {
    WebDriver driver;
    private By submissionDropdown = By.xpath("//mat-label[text()='Submissions']/parent::label/parent::div/parent::div/following::div/mat-select/div/div/following-sibling::div[contains(@class,'mat-mdc-select-arrow-wrapper')]");
    private By selectEntityDropDown = By.xpath("//mat-label[text()='Select Entity']/parent::label/parent::div/parent::div/following-sibling::div/mat-select/div/div/following-sibling::div[contains(@class,'mat-mdc-select-arrow-wrapper')]");
    private By dataDownloadButton = By.xpath("//mat-label[text()='Download Data']/../..");
    private By errorMessageDataDownload = By.xpath("//div[text()=' There is no data to download! ']");
    private By dateFrom = By.xpath("//mat-label[text()='Date From']/../../../following-sibling::div//button[@aria-label='Open calendar']");
    private By dateTo = By.xpath("//mat-label[text()='Date To']/../../../following-sibling::div//button[@aria-label='Open calendar']");
    private By Mobileapp = By.xpath("//div[text()=' Demo Application 314 ']");
    private By dataDownloadModule = By.xpath("//div[@class='smidemenu-container']/ul/li[7]");
    private By yearInCalnder = By.xpath("//div[@class='mat-calendar-controls']/button[@class='mat-calendar-period-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']");
    private By yearInRange = By.xpath("//div[@class='mat-calendar-controls']/button[@class='mat-calendar-period-button mdc-button mat-mdc-button mat-unthemed mat-mdc-button-base']//span//span");
    private By previousYears = By.xpath("//div[@class='mat-calendar-controls']/button[@class='mat-calendar-previous-button mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base']");
    private By nextYears = By.xpath("//div[@class='mat-calendar-controls']/button[@class='mat-calendar-next-button mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base']");
    private By fromDateValues = By.xpath("//input[@formcontrolname='fromDate']");
    private By toDateValues = By.xpath("//input[@formcontrolname='toDate']");

    boolean flag = false;

    public DataDownload(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMobileAppAndClickOnDataDownloadModule() throws Throwable {
        Thread.sleep(5000);
        driver.findElement(Mobileapp).click();
        Thread.sleep(5000);
        driver.findElement(dataDownloadModule).click();
    }

    public void clickOnEntityDropDownAndSelectAnEntity(String entity) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(selectEntityDropDown).click();
        if (driver.findElements(By.xpath("//span[text()=' " + entity + " ']/parent::mat-option")).size() > 0) {
            driver.findElement(By.xpath("//span[text()=' " + entity + " ']/parent::mat-option")).click();
            flag = true;
        }
    }

    public void clickOnTheSubmissionDropDownAndSelectMethod(String submission_type) throws Throwable {
        if (flag) {
            Thread.sleep(2000);
            String[] Method = submission_type.split(",");
            driver.findElement(submissionDropdown).click();
            if (driver.findElements(By.xpath("//span[text()=' " + Method[0] + " ']/parent::mat-option")).size() > 0) {
                driver.findElement(By.xpath("//span[text()=' " + Method[0] + " ']/parent::mat-option")).click();
                if (Method[0].equals("Custom")) {
                    Thread.sleep(2000);
                    calanderHandlingMethods(Method[1]);
                }
            }
        }
    }

    public void calanderHandlingMethods(String Dates) throws Throwable {
        Thread.sleep(2000);
        String[] Date = Dates.split("-");
        driver.findElement(dateFrom).click();
        fromdateHandling(Date[0]);
        Thread.sleep(2000);
        if (driver.findElements(fromDateValues).size() > 0) {
            Thread.sleep(2000);
            String[] date = driver.findElement(fromDateValues).getAttribute("value").trim().split("/");
            Assert.assertEquals(date[date.length - 1], Date[0].split("/")[0], "Expected Error Message " + Date[0].split("/")[0] + " But Found : " + date[date.length - 1]);
            Assert.assertEquals(date[date.length - 2], Date[0].split("/")[2], "Expected Error Message " + Date[0].split("/")[2] + " But Found : " + date[date.length - 2]);
            Assert.assertEquals(date[0], Date[0].split("/")[1], "Expected Error Message " + Date[0].split("/")[1] + " But Found : " + date[0]);
        }
        Thread.sleep(5000);
        driver.findElement(dateTo).click();
        toDateHandling(Date[1]);
        if (driver.findElements(toDateValues).size() > 0) {
            String[] date = driver.findElement(toDateValues).getAttribute("value").trim().split("/");
            Assert.assertEquals(date[date.length - 1], Date[1].split("/")[0], "Expected Error Message " + Date[1].split("/")[0] + " But Found : " + date[date.length - 1]);
            Assert.assertEquals(date[date.length - 2], Date[1].split("/")[2], "Expected Error Message " + Date[1].split("/")[2] + " But Found : " + date[date.length - 2]);
            Assert.assertEquals(date[0], Date[1].split("/")[1], "Expected Error Message " + Date[1].split("/")[1] + " But Found : " + date[0]);
        }
    }

    public void fromdateHandling(String Date) throws Throwable {
        String[] FromDate = Date.split("/");
        driver.findElement(yearInCalnder).click();
        while (true) {
            String[] datefromYear = driver.findElement(yearInRange).getText().split("–");
            if (Integer.parseInt(FromDate[0].trim()) < Integer.parseInt(datefromYear[0].trim())) {
                Thread.sleep(2000);
                driver.findElement(previousYears).click();
            } else if (Integer.parseInt(FromDate[0].trim()) > Integer.parseInt(datefromYear[1].trim())) {
                Thread.sleep(2000);
                driver.findElement(nextYears).click();
            } else {
                break;
            }
        }
        driver.findElement(By.xpath("//button[@aria-label='" + FromDate[0] + "']")).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        int val = Integer.parseInt(FromDate[1].trim());
        int row = (val - 1) / 4 + 1;
        int col = (val - 1) % 4 + 1;
        driver.findElement(By.xpath("//tbody[@class='mat-calendar-body']/tr[@role='row'][" + row + "]/td[" + col + "]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=' " + FromDate[2] + " ']/parent::button")).click();
    }

    public void toDateHandling(String Date) throws Throwable {
        String[] ToDate = Date.split("/");
        driver.findElement(yearInCalnder).click();
        while (true) {
            String[] datefromYear = driver.findElement(yearInRange).getText().split("–");
            if (Integer.parseInt(ToDate[0].trim()) < Integer.parseInt(datefromYear[0].trim())) {
                Thread.sleep(2000);
                driver.findElement(previousYears).click();
            } else if (Integer.parseInt(ToDate[0].trim()) > Integer.parseInt(datefromYear[1].trim())) {
                Thread.sleep(2000);
                driver.findElement(nextYears).click();
            } else {
                break;
            }
        }
        driver.findElement(By.xpath("//button[@aria-label='" + ToDate[0] + "']")).click();
        Thread.sleep(2000);
        int val = Integer.parseInt(ToDate[1].trim());
        int row = (val - 1) / 4 + 1;
        int col = (val - 1) % 4 + 1;
        driver.findElement(By.xpath("//tbody[@class='mat-calendar-body']/tr[@role='row'][" + row + "]/td[" + col + "]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=' " + ToDate[2] + " ']/parent::button")).click();
    }

    public void clickOnDataDownloadButton(String error_message) throws Throwable {
        Thread.sleep(4000);
        driver.findElement(dataDownloadButton).click();
        if (driver.findElements(errorMessageDataDownload).size() > 0) {
            String text = driver.findElement(errorMessageDataDownload).getText().trim();
            Assert.assertEquals(text, error_message, "Expected Error Message " + error_message + " But Found : " + text);
        }
    }

}
