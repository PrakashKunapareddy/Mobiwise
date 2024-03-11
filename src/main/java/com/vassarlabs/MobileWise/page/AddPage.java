package com.vassarlabs.MobileWise.page;

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

public class AddPage {
    WebDriver driver;
    Actions act;

    public AddPage(WebDriver driver) {
        this.driver = driver;
        act = new Actions(this.driver);
    }


    private By pageModuleHeading = By.xpath("//mat-toolbar[@class='mat-toolbar sidemenu-toolbar mat-toolbar-single-row']/i/following-sibling::span");
    private By splashScreenPageHeading = By.xpath("//mat-toolbar[@class='mat-toolbar sidemenu-toolbar mat-toolbar-single-row']/following-sibling::mat-accordion/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/span[text()='Splash Screen']");
    private By loginPageHeading = By.xpath("//mat-toolbar[@class='mat-toolbar sidemenu-toolbar mat-toolbar-single-row']/following-sibling::mat-accordion/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/span[text()='Login']");
    private By landingPageHeading = By.xpath("//mat-toolbar[@class='mat-toolbar sidemenu-toolbar mat-toolbar-single-row']/following-sibling::mat-accordion/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/span[text()='Landing']");
    private By addPageButton = By.xpath("//button/span[text()=' Add Page']");
    private By addPagePopupHeading = By.xpath("//h2/span[text()='Add Page']");
    private By addPageTextfield = By.xpath("//input[@placeholder='Page Name']");
    private By addPageEntityTextfield = By.xpath("//input[@placeholder='Entity Name']");
    private By entityDropdown = By.xpath("//mat-select[@placeholder='Select Entity']/div/div/div");
    private By addPageSaveButton = By.xpath("//button/span[text()='Save']");
    private By emptyFieldMessage = By.xpath("//mat-hint[text()='Please fill the above textfield']");
    private By pageNameAlreadyExist = By.xpath("//mat-hint[text()='Page name already exists']");
    private By createNewEntityRadio = By.xpath("//label[text()='Create new entity']");
    private By selectFromExistingEntityRadio = By.xpath("//label[text()='Select from existing']");
    private By noEntityFoundErrorMessage = By.xpath("//mat-hint[text()='Entity not found. Please create an entity first']");
    private By radiobuttonselectstatus = By.xpath("//mat-radio-button[contains(@class,'mat-mdc-radio-checked')]/div/div/div/following::label[@class='mdc-label']");
    private By cancleButtonAddPagePopup = By.xpath("//span[text()='Cancel']");
    private By editPagePopupHeading = By.xpath("//h2/span[text()='Edit Page']");
    private By radioButtonCreateNewEntity = By.xpath("//label[text()='Create new entity']");
    private By radioButtonSelectFromExisting = By.xpath("//label[text()='Select from existing']");
    private By entityDropdownValue = By.xpath("//mat-select[@placeholder='Select Entity']/div/div/span[contains(@class,'mat-mdc-select-value-text')]/span[contains(@class,'mat-mdc-select-min-line')]");
    private By deleteErrorMessage = By.xpath("//div[@class='mat-mdc-dialog-surface mdc-dialog__surface']/div/div/mat-icon[text()='warning']/following-sibling::span");
    private By loginTypeDropdown = By.xpath("//mat-label[text()='Login Type']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By loginTypeDropdownOption = By.xpath("//mat-option[@role='option']/span[text()='Username & Password']");
    private By loginTypeDropdownvalue = By.xpath("//mat-label[text()='Login Type']/../../../following-sibling::div/mat-select/div/div/span/span");
    private By logoToggleButton = By.xpath("//span[text()='Logo']//parent::label//parent::div/button");
    private By forgotPasswordToggleButton = By.xpath("//span[text()='Forget Password']//parent::label//parent::div/button");
    private By biometricToggleButton = By.xpath("//span[text()='Biometrics']//parent::label//parent::div/button");
    private By listOfWidgetsOnScreenBuilder = By.xpath("//mat-panel-title/span[text()='Login']/../../../..//div[contains(@class,'mat-expansion-panel-content')]//mat-list-item/span/span");
    private By listOfWidgetsonScreenBuilderForSplashScreen = By.xpath("//mat-panel-title/span[text()='Splash Screen']/../../../..//div[contains(@class,'mat-expansion-panel-content')]//mat-list-item/span/span");


    private boolean pagesModuleFlag = false;
    private boolean addPagePopupFlag = false;
    private boolean editPagePopupFlag = false;
    private boolean noErrorAddingpageFlag = false;
    private boolean noErrorEditingpageFlag = false;
    private boolean noErrorAddingEntityFlag = false;
    private boolean pageAddedFlag = false;
    private boolean deleteIconIsClickedFlag = false;
    private boolean deleteCanBeClickedFlag = false;
    private boolean errorEditEntityFlag = true;


    //span[text()='Page Name']/../following-sibling::div/button/mat-icon[text()='delete']-------------delete Icon
    //span[text()='Page Name']/../following-sibling::div/button/mat-icon[text()='edit']--------------Edit Icon

    public void verifyPagesModule(String pages) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(pageModuleHeading)));
        String text = driver.findElement(pageModuleHeading).getText().trim();
        System.out.println(text + "web");
        System.out.println(pages + "feature");
        Assert.assertEquals(pages, text, "Expected Error Message " + pages + " But Found : " + text);
        pagesModuleFlag = true;
    }

    public void verifyDefaultPages(String default_pages) throws Throwable {
        if (pagesModuleFlag) {
            Thread.sleep(3000);
            String[] Defpages = default_pages.split(",");
            verifySplashScreen();
            String text = driver.findElement(splashScreenPageHeading).getText().trim();
            Assert.assertEquals(Defpages[0], text, "Expected Error Message " + Defpages[0] + " But Found : " + text);
            verifyDefaultLoginPage();
            String text1 = driver.findElement(loginPageHeading).getText().trim();
            Assert.assertEquals(Defpages[1], text1, "Expected Error Message " + Defpages[1] + " But Found : " + text);
            String text2 = driver.findElement(landingPageHeading).getText().trim();
            Assert.assertEquals(Defpages[2], text2, "Expected Error Message " + Defpages[2] + " But Found : " + text);

        }
    }

    public void verifyDefaultLoginPage() {
        driver.findElement(loginPageHeading).click();
        if (driver.findElements(loginTypeDropdown).size() > 0) {
            driver.findElement(loginTypeDropdown).click();
            driver.findElement(loginTypeDropdownOption).click();
            String text = driver.findElement(loginTypeDropdownvalue).getText().trim();
            String text2 = "Username & Password";
            Assert.assertEquals(text, text2, "Expected Error Message " + text2 + " But Found : " + text);
        }
        boolean expected = Boolean.parseBoolean(driver.findElement(logoToggleButton).getAttribute("aria-checked"));
        if (expected) {
            driver.findElement(logoToggleButton).click();
        }

        boolean expected1 = Boolean.parseBoolean(driver.findElement(forgotPasswordToggleButton).getAttribute("aria-checked"));
        if (expected1) {
            driver.findElement(forgotPasswordToggleButton).click();
        }

        boolean expected2 = Boolean.parseBoolean(driver.findElement(biometricToggleButton).getAttribute("aria-checked"));
        if (expected2) {
            driver.findElement(biometricToggleButton).click();
        }
        listOfWidgetsInLoginPage();
        driver.findElement(biometricToggleButton).click();
        listOfWidgetsInLoginPage();
        driver.findElement(biometricToggleButton).click();
        driver.findElement(forgotPasswordToggleButton).click();
        listOfWidgetsInLoginPage();
        driver.findElement(logoToggleButton).click();
        listOfWidgetsInLoginPage();
    }

    public void listOfWidgetsInLoginPage() {
        ArrayList<String> listOfWidgets = new ArrayList<>();
        List<String> widgetsToCheck = Arrays.asList("Biometrics", "Forget Password", "Logo");
        for (WebElement widget : driver.findElements(listOfWidgetsOnScreenBuilder)) {
            listOfWidgets.add(widget.getText().trim());
        }
        System.out.println(listOfWidgets);
        for (String widgetToCheck : widgetsToCheck) {
            if (listOfWidgets.contains(widgetToCheck)) {
                int index = listOfWidgets.indexOf(widgetToCheck);
                Assert.assertEquals(widgetToCheck, listOfWidgets.get(index), "Expected Error Message " + widgetToCheck + " But Found : " + listOfWidgets.get(index));
            }
        }

    }

    public void verifySplashScreen() {
        String text = driver.findElement(listOfWidgetsonScreenBuilderForSplashScreen).getText().trim();
        String text2 = "Image";
        Assert.assertEquals(text, text2, "Expected Error Message " + text2 + " But Found : " + text);
    }

    public void addPageToApplication(String page_name, String error_message, String entity_name, String entity_error_message, String edit_entity_name) throws Throwable {
        if (pagesModuleFlag) {
            Thread.sleep(3000);
            driver.findElement(addPageButton).click();
            clickCancleButton();
            driver.findElement(addPageButton).click();
            verifyAddPagePopup();
            if (addPagePopupFlag) {
                driver.findElement(addPageTextfield).sendKeys(page_name);
                driver.findElement(addPageEntityTextfield).click();
                if (driver.findElements(emptyFieldMessage).size() > 0) {
                    Thread.sleep(3000);
                    String text = driver.findElement(emptyFieldMessage).getText().trim();
                    Assert.assertEquals(error_message, text, "Expected Error Message " + error_message + " But Found : " + text);
                } else if (driver.findElements(pageNameAlreadyExist).size() > 0) {
                    Thread.sleep(3000);
                    String text = driver.findElement(pageNameAlreadyExist).getText().trim();
                    Assert.assertEquals(error_message, text, "Expected Error Message " + error_message + " But Found : " + text);
                } else {
                    noErrorAddingpageFlag = true;
                }
                checkRadioButtonsAndUpdateEntity(entity_name, entity_error_message, error_message, edit_entity_name);
                clickSavebutton();
            }
        }
    }

    public void verifyAddPagePopup() throws Throwable {
        Thread.sleep(3000);
        String text = driver.findElement(addPagePopupHeading).getText().trim();
        String Act = "Add Page";
        Assert.assertEquals(Act, text, "Expected Error Message " + Act + " But Found : " + text);
        addPagePopupFlag = true;
    }

    public void checkRadioButtonsAndUpdateEntity(String entity_name, String entity_error_message, String error_message, String edit_entity_name) throws Throwable {
        if (noErrorAddingpageFlag) {
            Thread.sleep(3000);
            driver.findElement(selectFromExistingEntityRadio).click();
            if (driver.findElement(radiobuttonselectstatus).getText().trim().equals("Select from existing")) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(entityDropdown).click();
                if (driver.findElements(addPagePopupHeading).size() > 0) {
                    driver.findElement(addPagePopupHeading).click();
                    if (driver.findElements(noEntityFoundErrorMessage).size() > 0) {
                        String text = driver.findElement(noEntityFoundErrorMessage).getText().trim();
                        Assert.assertEquals(entity_error_message, text, "Expected Error Message " + entity_error_message + " But Found : " + text);
                    }
                }
                if (driver.findElements(editPagePopupHeading).size() > 0) {
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//mat-option/span[text()='" + entity_name + "']")).click();
                    driver.findElement(editPagePopupHeading).click();
                    if (driver.findElements(noEntityFoundErrorMessage).size() > 0) {
                        String text = driver.findElement(noEntityFoundErrorMessage).getText().trim();
                        Assert.assertEquals(entity_error_message, text, "Expected Error Message " + entity_error_message + " But Found : " + text);
                    } else {
                        String text = driver.findElement(entityDropdownValue).getText().trim();
                        if (text.equals(entity_name)) {
                            Assert.assertEquals(text, entity_name, "Expected Error Message " + text + " But Found : " + entity_name);
                        }
                    }
                }

            }
            Thread.sleep(3000);
            driver.findElement(createNewEntityRadio).click();
            if (driver.findElement(radiobuttonselectstatus).getText().trim().equals("Create new entity")) {
                Thread.sleep(3000);
                if (driver.findElements(addPagePopupHeading).size() > 0) {
                    driver.findElement(addPageEntityTextfield).sendKeys(entity_name);
                    driver.findElement(addPagePopupHeading).click();
                    if (driver.findElements(emptyFieldMessage).size() > 0) {
                        String text = driver.findElement(emptyFieldMessage).getText().trim();
                        Assert.assertEquals(error_message, text, "Expected Error Message " + error_message + " But Found : " + text);
                    } else {
                        noErrorAddingEntityFlag = true;
                    }
                }
                if (driver.findElements(editPagePopupHeading).size() > 0) {
                    driver.findElement(addPageEntityTextfield).sendKeys(edit_entity_name);
                    driver.findElement(editPagePopupHeading).click();
                    if (driver.findElements(emptyFieldMessage).size() > 0) {
                        String text = driver.findElement(emptyFieldMessage).getText().trim();
                        Assert.assertEquals(error_message, text, "Expected Error Message " + error_message + " But Found : " + text);
                        errorEditEntityFlag = false;
                    } else {
                        noErrorAddingEntityFlag = true;
                        errorEditEntityFlag = true;
                    }
                }

            }
        }
    }

    public void clickSavebutton() throws Throwable {
        Thread.sleep(3000);
        if (noErrorAddingpageFlag && noErrorAddingEntityFlag) {
            driver.findElement(addPageSaveButton).click();
        }
    }

    public void clickCancleButton() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(cancleButtonAddPagePopup).click();
    }

    public void checkAddedPage(String page_name) throws Throwable {
        Thread.sleep(3000);
        if (noErrorAddingEntityFlag) {
            String text = driver.findElement(By.xpath("//mat-toolbar[@class='mat-toolbar sidemenu-toolbar mat-toolbar-single-row']/following-sibling::mat-accordion/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/span[text()='" + page_name + "']")).getText().trim();
            Assert.assertEquals(page_name, text, "Expected Error Message " + page_name + " But Found : " + text);
            pageAddedFlag = true;
        }
    }

    public void verifyEditPagePopup() throws Throwable {
        if (noErrorAddingEntityFlag) {
            Thread.sleep(5000);
            String text = driver.findElement(editPagePopupHeading).getText().trim();
            String Act = "Edit Page";
            Assert.assertEquals(Act, text, "Expected Error Message " + Act + " But Found : " + text);
            editPagePopupFlag = true;
        }
    }

    public void editAddedPage(String edit_page_name, String page_name, String error_message, String entity_name, String entity_error_message, String edit_entity_name) throws Throwable {
        Thread.sleep(3000);
        if (pageAddedFlag) {
            act.moveToElement(driver.findElement(By.xpath(" //span[text()='" + page_name + "']/../following-sibling::div/button/mat-icon[text()='edit']"))).click().perform();
            verifyEditPagePopup();
            if (editPagePopupFlag) {
                driver.findElement(addPageTextfield).clear();
                driver.findElement(addPageTextfield).sendKeys(edit_page_name);
                driver.findElement(editPagePopupHeading).click();
                if (driver.findElements(emptyFieldMessage).size() > 0) {
                    Thread.sleep(3000);
                    String text = driver.findElement(emptyFieldMessage).getText().trim();
                    Assert.assertEquals(error_message, text, "Expected Error Message " + error_message + " But Found : " + text);
                } else if (driver.findElements(pageNameAlreadyExist).size() > 0) {
                    Thread.sleep(3000);
                    String text = driver.findElement(pageNameAlreadyExist).getText().trim();
                    Assert.assertEquals(error_message, text, "Expected Error Message " + error_message + " But Found : " + text);
                } else {
                    noErrorEditingpageFlag = true;
                    checkRadioButtonsAndUpdateEntity(entity_name, entity_error_message, error_message, edit_entity_name);
                }
                if (noErrorAddingpageFlag) {
                    Thread.sleep(3000);
                    if (driver.findElement(addPageTextfield).getAttribute("value").equals(null)) {
                        deleteCanBeClickedFlag = false;
                    }
                    if (noErrorEditingpageFlag && errorEditEntityFlag) {
                        clickSavebutton();
                    }
                }
            }
        }


    }

    public void deletePage(String edit_page_name, String error_page_delete) throws Throwable {
        if (pageAddedFlag && noErrorEditingpageFlag && deleteCanBeClickedFlag) {
            Thread.sleep(3000);
            act.moveToElement(driver.findElement(By.xpath(" //span[text()='" + edit_page_name + "']/../following-sibling::div/button/mat-icon[text()='delete']"))).click().perform();
            deleteIconIsClickedFlag = true;
            deleteErrorpopup(edit_page_name, error_page_delete);

        }
    }

    public void deleteErrorpopup(String edit_page_name, String error_page_delete) throws Throwable {
        if (deleteIconIsClickedFlag) {
            String[] splitMessage = error_page_delete.split(",");
            String doubleQuotes1 = "\"";
            String doubleQuotes2 = "\"";
            String message = splitMessage[0] + doubleQuotes1 + edit_page_name + doubleQuotes2 + splitMessage[1];
            if (driver.findElements(By.xpath("//span[text()=' Unable to Delete " + edit_page_name + " Page']")).size() > 0) {
                String text = driver.findElement(deleteErrorMessage).getText().trim();
                Assert.assertEquals(message, text, "Expected Error Message " + message + " But Found : " + text);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='Ok']")).click();
            }
        }
    }
}
