package com.vassarlabs.MobileWise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;

public class ThemesModule {
    CreateMobApplicationWebAppliation createMobApplicationWebAppliation = new CreateMobApplicationWebAppliation(WebdriverInitializer.getDriver());

    WebDriver driver;


    private By homeBreadCrumb = By.xpath("//nav[@aria-label='breadcrumb']/ol/li[text()='Home']");
    private By applicationPageBreadCrumb = By.xpath("//nav[@aria-label='breadcrumb']/ol/li[2]");
    private By mobileAppBreadCrumb = By.xpath("//nav[@aria-label='breadcrumb']/ol/li[3]");
    private By mobileApplicationName = By.xpath("//div[@class='app-Name ng-star-inserted']/h4");
    private By projectNameinApplicationpage = By.xpath("//div[@class='header-start']/h2");
    private By projectNameinHomepage = By.xpath("//div[@class='page-header']/div/h2[text()='Projects']");
    private By projectMatButton = By.xpath("//div/mat-card/mat-card-content/mat-card-title");
    private By mobileWidgit = By.xpath("//mat-card[@class= 'mat-mdc-card mdc-card mat-ripple mat-custom-card mat-card-device mobile']");
    private By themesModule = By.xpath("//div[@class='smidemenu-container']/ul/li[1]");
    private By themesDropdown = By.xpath("//mat-label[text()='Theme']/parent::label/parent::div/parent::div/following-sibling::div/mat-select/div/div/following-sibling::div");
    private By themesDropdownValue = By.xpath(" //div[@class='mdc-notched-outline__notch']/../following-sibling::div/mat-select/div/div/span");
    private By headingsDropdown = By.xpath("//mat-label[text()='Headings']/parent::label/parent::div/parent::div/following-sibling::div/mat-select/div/div/following-sibling::div");
    private By bodyDropdown = By.xpath("//mat-label[text()='Body']/parent::label/parent::div/parent::div/following-sibling::div/mat-select/div/div/following-sibling::div");
    private By applyButton = By.xpath("//span[text()='Apply']");
    private By resetButton = By.xpath("//span[text()='Reset']");
    private By primaryColor = By.xpath("//div[@for='primaryColor']/div/div[@class='value']");
    private By OnPrimary = By.xpath("//div[@for='secondaryColor']/div/div[@class='value']");
    private By backgroundColor = By.xpath("//div[@for='defaultBackgroundColor']/div/div[@class='value']");
    private By bodyTextColor = By.xpath("//div[@for='defaultTextColor']/div/div[@class='value']");
    private By headingsDropdownValue = By.xpath("//mat-select[@placeholder='Select Heading Font']/div/div/span/span");
    private By bodyDropdownValue = By.xpath("//mat-select[@placeholder='Select Body Font']/div/div/span/span");
    private By toasterForThemesApplied = By.xpath("//div[text()=' Applied Sucessfully ']");
    ArrayList<String> previousTheme = new ArrayList<>();
    ArrayList<String> presentTheme = new ArrayList<>();


    boolean verificationBreadcrumbFlag = false;


    public ThemesModule(WebDriver driver) throws AWTException {
        this.driver = driver;
    }

    //Verify the Breadcrumb from Mobile Applicatiom to Home page
    public void verifyBreadcrumb(String expected_output) throws Throwable {
        Thread.sleep(3000);
        verifyMobileApplicationNameOnBreadcrumb();
        clickOnApplicationPageOnBreadcrumb();
        clickHomeOnBreadcrumb(expected_output);
        goBackToMobileApplicationPage();
        verificationBreadcrumbFlag = true;
    }

    public void verifyMobileApplicationNameOnBreadcrumb() throws Throwable {
        Thread.sleep(5000);
        String mobApplicationName = driver.findElement(mobileApplicationName).getText().trim();
        Thread.sleep(3000);
        String text = driver.findElement(mobileAppBreadCrumb).getText().trim();
        Assert.assertEquals(mobApplicationName, text, "Expected Error Message " + mobApplicationName + " But Found : " + text);
    }

    public void clickOnApplicationPageOnBreadcrumb() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(applicationPageBreadCrumb).click();
        String ProjectName = driver.findElement(applicationPageBreadCrumb).getText().trim();
        String text = driver.findElement(projectNameinApplicationpage).getText().trim();
        Assert.assertEquals(ProjectName, text, "Expected Error Message " + ProjectName + " But Found : " + text);
    }

    public void clickHomeOnBreadcrumb(String expected_output) throws Throwable {
        Thread.sleep(3000);
        driver.findElement(homeBreadCrumb).click();
        Thread.sleep(3000);
        String text = driver.findElement(projectNameinHomepage).getText();
        Assert.assertEquals(expected_output, text, "Expected Error Message " + expected_output + " But Found : " + text);
        Thread.sleep(3000);
    }

    //Traversing back to mobile application
    public void goBackToMobileApplicationPage() throws Throwable {
        Thread.sleep(3000);
        driver.findElements(projectMatButton).get(0).click();
        Thread.sleep(3000);
        driver.findElement(mobileWidgit).click();
        verifyMobileApplicationNameOnBreadcrumb();
    }

    public void clickOnThemesModule() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(themesModule).click();
    }

    public void selectTheme(String themes_change, String toaster_message_themes_apply) throws Throwable {
        createMobApplicationWebAppliation.compareThemesFromExcel();
        selectThemeFromThemeDropdown(themes_change, toaster_message_themes_apply);
    }

    public void selectThemeFromThemeDropdown(String themes_change, String toaster_message_themes_apply) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(themesDropdown).click();
        if (!(driver.findElements(themesDropdownValue).get(0).getText().equals("Select Theme"))) {
            themeIsNotCustomTheme(themes_change, toaster_message_themes_apply);
        } else {
            themeIsCustomTheme(themes_change, toaster_message_themes_apply);
        }
    }

    public void themeIsCustomTheme(String themes_change, String toaster_message_themes_apply) throws Throwable {
        driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/mat-option/span[text()='" + themes_change + "']")).click();
        ArrayList<String> uiCompare = new ArrayList<>();//Array list for Ui values
        Thread.sleep(3000);
        uiCompare.add(driver.findElement(primaryColor).getText());
        uiCompare.add(driver.findElement(OnPrimary).getText());
        uiCompare.add(driver.findElement(backgroundColor).getText());
        uiCompare.add(driver.findElement(bodyTextColor).getText());
        uiCompare.add(driver.findElement(headingsDropdownValue).getText());
        uiCompare.add(driver.findElement(bodyDropdownValue).getText());
        clickApplyButton(toaster_message_themes_apply);
        for (int i = 0; i <= uiCompare.size() - 1; i++) {
            String UiText = uiCompare.get(i);
            for (int j = 0; j <= uiCompare.size() - 1; j++) {
                String HashmapText = createMobApplicationWebAppliation.Headers.get("Select Themes").get(themes_change).get(j);//taken values from Global hashmap
                if (UiText.equals(HashmapText)) {
                    Assert.assertEquals(UiText, HashmapText, "Expected Error Message " + UiText + " But Found : " + HashmapText);
                    break;
                }
            }
        }
    }

    public void themeIsNotCustomTheme(String themes_change, String toaster_message_themes_apply) throws Throwable {
        previousTheme.add(driver.findElement(primaryColor).getText());
        previousTheme.add(driver.findElement(OnPrimary).getText());
        previousTheme.add(driver.findElement(backgroundColor).getText());
        previousTheme.add(driver.findElement(bodyTextColor).getText());
        previousTheme.add(driver.findElement(headingsDropdownValue).getText());
        previousTheme.add(driver.findElement(bodyDropdownValue).getText());
        driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']/div/mat-option/span[text()='" + themes_change + "']")).click();
        ArrayList<String> uiCompare = new ArrayList<>();//Array list for Ui values
        Thread.sleep(3000);
        uiCompare.add(driver.findElement(primaryColor).getText());
        uiCompare.add(driver.findElement(OnPrimary).getText());
        uiCompare.add(driver.findElement(backgroundColor).getText());
        uiCompare.add(driver.findElement(bodyTextColor).getText());
        uiCompare.add(driver.findElement(headingsDropdownValue).getText());
        uiCompare.add(driver.findElement(bodyDropdownValue).getText());
        for (int i = 0; i <= uiCompare.size() - 1; i++) {
            String UiText = uiCompare.get(i);
            for (int j = 0; j <= uiCompare.size() - 1; j++) {
                String HashmapText = createMobApplicationWebAppliation.Headers.get("Select Themes").get(themes_change).get(j);//taken values from Global hashmap
                if (UiText.equals(HashmapText)) {
                    Assert.assertEquals(UiText, HashmapText, "Expected Error Message " + UiText + " But Found : " + HashmapText);
                    break;
                }
            }
        }
        storePresetThemeData();
        driver.findElement(By.xpath("//mat-label[text()='Headings']/../../../following-sibling::div/mat-select/div/div[contains(@class,'mat-mdc-select-arrow-wrapper')]")).click();
        driver.findElement(By.xpath("//span[text()='Rock 3D']")).click();
        clickResetButton();
        comparePreviousThemeAfterReset();

    }
    public void storePresetThemeData(){
        presentTheme.add(driver.findElement(primaryColor).getText());
        presentTheme.add(driver.findElement(OnPrimary).getText());
        presentTheme.add(driver.findElement(backgroundColor).getText());
        presentTheme.add(driver.findElement(bodyTextColor).getText());
        presentTheme.add(driver.findElement(headingsDropdownValue).getText());
        presentTheme.add(driver.findElement(bodyDropdownValue).getText());
        System.out.println(presentTheme);
    }

    public void comparePreviousThemeAfterReset() {
        for (int i = 0; i <= presentTheme.size() - 1; i++) {
            String presentText = presentTheme.get(i);
            for (int j = 0; j <= previousTheme.size() - 1; j++) {
                String previousText = previousTheme.get(j);
                if (presentTheme.get(i).contains(previousTheme.get(j))) {
                    Assert.assertEquals(presentText, previousText, "Expected Error Message " + presentText + " But Found : " + previousText);
                    break;
                }
            }
        }
    }

    public void clickApplyButton(String toaster_message_themes_apply) throws Throwable {
        Thread.sleep(3000);
        if (driver.findElements(applyButton).size() > 0) {
            driver.findElement(applyButton).click();
            validateThemeApplied(toaster_message_themes_apply);
        }
    }

    public void validateThemeApplied(String toaster_message_themes_apply) throws Throwable {
        Thread.sleep(3000);
        if (driver.findElements(toasterForThemesApplied).size() > 0) {
            String message = driver.findElement(toasterForThemesApplied).getText().trim();
            Assert.assertEquals(message, toaster_message_themes_apply, "Expected Error Message " + message + " But Found : " + toaster_message_themes_apply);
        }
    }

    public void clickResetButton() throws Throwable {
        Thread.sleep(3000);
        if (driver.findElements(resetButton).size() > 0) {
            driver.findElement(resetButton).click();
        }
    }

}
