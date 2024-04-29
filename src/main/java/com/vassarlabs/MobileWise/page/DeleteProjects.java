package com.vassarlabs.MobileWise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteProjects {
    WebDriver driver;

    public DeleteProjects(WebDriver driver) {
        this.driver = driver;
    }

    private By projectToDelete = By.xpath("//mat-card-title");
    private By deleteIcon = By.xpath("//span[text()=' Delete']/..");

    public void deleteProjects(String project) throws InterruptedException {
        List<WebElement> projects = driver.findElements(projectToDelete);
        int size = projects.size();
        for (int i = size - 1; i >= 0; i--) {
            String name = projects.get(i).getText().trim();
            if (project.equals(name)) {
                driver.findElements(deleteIcon).get(i).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='No']/..")).click();
            } else {
                driver.findElements(deleteIcon).get(i).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='Yes']/..")).click();
            }
        }
        if(projects.size()>1)
        {
            System.out.println("Projects are not Deleted");
        }
    }

}