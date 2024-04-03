package com.vassarlabs.MobileWise.page;

import com.google.gson.Gson;
import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class PropertiesSideBar {
    DataList dataList = new DataList(WebdriverInitializer.getDriver());
    WebDriver driver;
    private By backArrowPropertiesBar = By.xpath("//mat-toolbar[contains(@class,'mat-toolbar sidemenu-toolbar')]//button//mat-icon[text()='arrow_back']/parent::button");
    private By componentSideBarHeading = By.xpath("//mat-toolbar[contains(@class,'mat-toolbar sidemenu-toolbar')]//button//mat-icon[text()='arrow_back']//following::span[contains(@class,'title')]");
    private By componentOnTheScreenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div");
    private By SaveComponentFilledButton = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div/md-filled-button");
    private By displayTypeDropdown = By.xpath("//mat-label[text()='Display Type']/parent::label/parent::div/parent::div/following::div/mat-select/div/div//span/span/../../following-sibling::div[contains(@class,'mat-mdc-select-arrow-wrapper')]");
    private By displayTypeDropdownValue = By.xpath("//mat-label[text()='Display Type']/../../../following-sibling::div/mat-select/div/div/span/span");
    private By dataListViewPage = By.xpath("//span[contains(text(),'Data List View Of')]/parent::mat-panel-title");
    private By labelTextField = By.xpath("//mat-label[text()='Label']/../../../following-sibling::div/input[@formcontrolname='label']");
    private By topMarginTextField = By.xpath("//mat-label[text()='Top Margin']/../../../following-sibling::div/input[@formcontrolname='marginTop']");
    private By updateComponentButton = By.xpath("//button//span[text()='Update component']");
    private By editbuttonForImageUpload = By.xpath("//mat-icon[text()='edit']/../../input");
    private By textTextfield = By.xpath("//mat-label[text()='Text']/../../../following-sibling::div/input");
    private By positionDropdown = By.xpath("//mat-label[text()='Position']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By positionDropDownValue = By.xpath("//mat-label[text()='Position']/../../../following-sibling::div/mat-select[@role='combobox']/div/div/span/span");
    private By formattingStylesBoldIcon = By.xpath("//mat-icon[text()='format_bold']/parent::button");
    private By formattingStylesUnderlineIcon = By.xpath("//mat-icon[text()='format_underlined']/parent::button");
    private By formattingStylesItalicIcon = By.xpath("//mat-icon[text()='format_italic']/parent::button");
    private By formattingStylesInput = By.xpath("//input[@id='fontSizeInput']");
    private By dataTypeDropdown = By.xpath("//mat-label[text()=' Data Type']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By dropdownTypeDropdown = By.xpath("//mat-label[text()='DropDown Type']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By dataTypeDropdownValue = By.xpath("//mat-label[text()=' Data Type']/../../../following-sibling::div//div/div/span/span");
    private By placeHolderTextField = By.xpath("//input[@formcontrolname='placeholder']");
    private By radioButtonComponent = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div/label/following-sibling::div[@role='radiogroup']");
    private By navbarComponentNavIcon1 = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]/..//div//mat-toolbar/div[@class='toolbar-start']/button");
    private By navbarComponentNavtitle = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]/..//div//mat-toolbar/div[@class='toolbar-title']");
    private By navbarComponentNavIcon2 = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]/..//div//mat-toolbar/div[@class='toolbar-end']");
    private By radioButtonTitleTextField = By.xpath("//mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title[text()=' Input Properties ']/../../following-sibling::div//input[@formcontrolname='title']");
    private By radioButtonValuesTextField = By.xpath("//mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title[text()=' Input Properties ']/../../following-sibling::div//mat-label[text()='Label']/../../../following-sibling::div/input");
    private By radioButtonAddValue = By.xpath("//button//span[text()=' Add Value ']//parent::button");
    private By radioButtonDeleteValues = By.xpath("//mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title[text()=' Input Properties ']/../../following-sibling::div//mat-label[text()='Label']/../../../following-sibling::div/mat-icon[text()='delete']");
    private By fileTypedropdown = By.xpath("//mat-label[text()='Files types']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By maxSizeTextField = By.xpath("//input[@formcontrolname='maxSize']");
    private By navbarTitleField = By.xpath("//mat-panel-title[text()=' Nav Title Properties ']/../../following-sibling::div//input[@formcontrolname='label']");
    private By previewToggle = By.xpath("//span[text()='Preview File']/../../button[@role='switch']");
    private By gallaryUploadToggleImagePickerImage = By.xpath("//span[text()='Gallery Upload']/../../button[@role='switch']");
    private By geoReferencetoggleImagePicker = By.xpath("//span[text()='Geo Reference']/../../button[@role='switch']");
    private By dateRangeToggle = By.xpath("//span[text()='Date Range']/../../button[@role='switch']");
    private By baringToggleImagePicker = By.xpath("//span[text()='Baring']/../../button[@role='switch']");
    private By gpsAccuracyfield = By.xpath("//input[@formcontrolname='gpsAccuracy']");
    private By previewVideoImagePicker = By.xpath("//span[text()='Preview Video']/../../button[@role='switch']");
    private By videoCompressionToggleImagePicker = By.xpath("//span[text()='Video Compression']/../../button[@role='switch']");
    private By imageCompressionImagePicker = By.xpath("//span[text()='Image Compression']/../../button[@role='switch']");
    private By fileCompressiontoggle = By.xpath("//span[text()='File Compression']/../../button[@role='switch']");
    private By uploadTypeDropDown = By.xpath("//mat-label[text()='Upload Type']/../../../following-sibling::div//div/following-sibling::div");
    private By navbarDisplayiconDropdown = By.xpath("//mat-label[text()='Display Icon']/../../../following-sibling::div//div/following-sibling::div");
    private By allowedImageType = By.xpath("//mat-label[text()='Allowed Image Types']//parent::label//parent::div/../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By allowedVideoType = By.xpath("//mat-label[text()='Allowed Video Types']//parent::label//parent::div/../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By maxSizeImageAndVideo = By.xpath("//input[@formcontrolname='maxSize']");
    private By futureDateRangeRangePicker = By.xpath("//input[@formcontrolname='futureDays']");
    private By historicDateRangeRangePicker = By.xpath("//input[@formcontrolname='historicalDays']");
    private By selectDateFormatDropdown = By.xpath("//mat-label[text()='Select Date Format:']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By thicknessSeparator = By.xpath("//input[@formcontrolname='thickness']");
    private By selectGeofenceTypeDropDown = By.xpath("//mat-label[text()='Select Geofence Types:']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By selectGeofenceShapeDropdown = By.xpath("//mat-label[text()='Select Geofence Shape:']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By selectPanelInputProperties = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/div/div");
    private By selectPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title");
    private By clickActionsPanelAndValidationPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span");
    private By selectActionTypeDropdown = By.xpath("//mat-label[text()='Select Action Type']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By addPageButton = By.xpath("//button/span[text()=' Add Page']");
    private By addPageTextfield = By.xpath("//input[@placeholder='Page Name']");
    private By addPageEntityTextfield = By.xpath("//input[@placeholder='Entity Name']");
    private By addPageSaveButton = By.xpath("//button/span[text()='Save']");
    private By validationsDropdown = By.xpath("//mat-label[text()='Validation Type']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By selctPageDropdownClickActions = By.xpath("//mat-label[text()='Select Page']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By saveButtonForClickActions = By.xpath("//mat-label[text()='Select Page']/../../../../../../../following-sibling::div/button/span[text()='Save']");
    private By messagefieldvalidations = By.xpath("//input[@formcontrolname='requiredMessage']");
    private By minAndmaxLengthFields = By.xpath("//input[@formcontrolname='validationValue']");
    private By addValidationbutton = By.xpath("//span[text()=' Add Validation ']//parent::button");
    private By manualdataLables = By.xpath("//span[text()=' Add Value ']/parent::button/preceding-sibling::form//div//input");
    private By addValueButton = By.xpath("//span[text()=' Add Value ']/parent::button");
    private By saveValueButton = By.xpath("//span[text()='Save Values']/parent::button");
    private By clickActionSubmitPreviewToggle = By.xpath("//h4[text()='Preview']/../mat-slide-toggle/div/button");
    private By selectFromExistingEntityRadio = By.xpath("//label[text()='Select from existing']");
    private By screenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]");
    private By validationpanelExpand = By.xpath("//span[text()=' Validation']/parent::mat-panel-title//parent::span//parent::mat-expansion-panel-header");
    private By clickActionsPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Click Actions']");
    private By validationsPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Validation']");
    private By radiobuttonselectstatus = By.xpath("//mat-radio-button[contains(@class,'mat-mdc-radio-checked')]/div/div/div/following::label[@class='mdc-label']");
    private By entityDropdown = By.xpath("//mat-select[@placeholder='Select Entity']/div/div/div");
    private By dataSourcePanelDropdownOnly = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Data Source']");
    private By dropdownTypeDataSorce = By.xpath("//mat-label[text()=' Drop Down Type']/../../../following-sibling::div/mat-select[@role='combobox']/div/div/following-sibling::div");
    private By createNewEntityRadio = By.xpath("//label[text()='Create new entity']");
    private boolean sideBarExistsFlag = false;
    private boolean panelsarePresentFlag = true;
    Actions act;
    public static int ittrator = 0;
    private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> ClickActions = new LinkedHashMap<>();
    private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> Validations = new LinkedHashMap<>();
    ArrayList<String> Panels = new ArrayList<>();


    public PropertiesSideBar(WebDriver driver) throws Throwable {
        this.driver = driver;
        act = new Actions(this.driver);
    }

    public void addPageForNavigation(String page_name, String entity_name) throws Throwable {
        String[] addPages = page_name.split(",");
        boolean flag = true;
        for (int i = 0; i <= addPages.length - 1; i++) {
            Thread.sleep(4000);
            driver.findElement(addPageButton).click();
            Thread.sleep(3000);
            driver.findElement(addPageTextfield).sendKeys(addPages[i]);
            Thread.sleep(4000);
            if (addPages[i].equals("Page2")) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(entityDropdown).click();
                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + entity_name + "']")).click();
                flag = false;
            }
            if (addPages[i].equals("Page3")) {
                driver.findElement(createNewEntityRadio).click();
                driver.findElement(addPageEntityTextfield).sendKeys("dummy");
                flag = false;
            }
            Thread.sleep(4000);
            if (driver.findElement(radiobuttonselectstatus).getText().trim().equals("Select from existing")) {
                Thread.sleep(4000);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(entityDropdown).click();
                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + entity_name + "']")).click();
                flag = false;
            }
            if (flag) {
                Thread.sleep(3000);
                driver.findElement(addPageEntityTextfield).sendKeys(entity_name);
            }
            driver.findElement(addPageSaveButton).click();
        }
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
            String[] Component = component.split(",");
            for (int i = 0; i <= Component.length - 1; i++) {
                if (Heading.contains(Component[i])) {
                    String text = component + " " + "Properties";
                    String message = driver.findElement(componentSideBarHeading).getText().trim();
                    Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
                    sideBarExistsFlag = true;
                }
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
        if (driver.findElements(componentOnTheScreenBuilder).size() > 0) {
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
    }

    public void editPropertiesOfComponent(String properties, String panels, String values_comp, String component, String page_name, String work_page, String component_panel, String entity_name) throws Throwable {
        Thread.sleep(3000);
        String[] Component1 = component.split("~");
        String[] values1 = values_comp.split("%");
        String[] panelsInPage = panels.split("%");
        for (int comp = ittrator; comp <= Component1.length - 1; comp++) {
            String[] Component = Component1[comp].split(",");
            for (int val = ittrator; val < values1.length; val++) {
                String[] values = values1[val].split("~");
                for (int panelcount = ittrator; panelcount < panelsInPage.length; panelcount++) {
                    String[] panel = panelsInPage[panelcount].split("~");
//                    int length = Component.length - 1;
//                    for (int c = 0; c <= length; c++) {
//                        if (Component[c].equals("Navbar")) {
//                            editNavbarComponentStylingButtonAndTitle(values[c], component, page_name);
//                            length = length - 1;
//                        }
//                    }
                    if (panelsarePresentFlag) {
                        int l = driver.findElements(componentOnTheScreenBuilder).size();
                        int COSB = l - 1; // Initialize COSB with the initial value
                        for (int c = 0; c < Component.length; c++) {
                            if (COSB >= 0) {
                                driver.findElements(componentOnTheScreenBuilder).get(COSB).click();
                                System.out.println("Clicked the " + COSB + " component On the Screen Builder From Last");
                                System.out.println(Component[c]);
                                switch (Component[c]) {
                                    case "Data List":
                                        boolean var = dataList.displayListProperties(values_comp);
                                        if (var) {
                                            createNavigationForDataListPage();
                                        }
                                        clickOnUpdateComponentButton();
                                        break;

                                    case "Radio Button":
                                        editRadioButtonComponent(values[c], component, panels);
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Scanner":
                                        editDisplayTypeDropdowns(values[c]);
                                        editLabelTextfield(values[c], Component[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;
                                    case "Printer":
                                        editDisplayTypeDropdowns(values[c]);
                                        editTextTextfield(values[c], component);
                                        ZPlFormat();
                                        editTopMarginTextField(values[c], Component[c]);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Text":
                                    case "Save":
                                        editTextTextfield(values[c], component);
                                        editPositionDropdown(values[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        editFormattingStyles(values[c], component);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Image":
                                        editImageForImageComponent();
                                        editTopMarginTextField(values[c], Component[c]);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Check Box":
                                    case "Geotag":
                                        editLabelTextfield(values[c], Component[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;
                                    case "Separator":
                                        thicknessTextFieldSeparator(values[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        clickOnUpdateComponentButton();
                                        break;

                                    case "File Picker":
                                        editDisplayTypeDropdowns(values[c]);
                                        editLabelTextfield(values[c], Component[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        editFilePickerComponent(values[c], component);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Media Upload":
                                        editDisplayTypeDropdowns(values[c]);
                                        editLabelTextfield(values[c], Component[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        uploadTyppeDropdownImagePicker(values[c], component);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;
                                    case "Date Picker":
                                        editDisplayTypeDropdowns(values[c]);
                                        editLabelTextfield(values[c], Component[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        editSelectDateFormatDropdownAndDateRanges(values[c], component);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Range Picker":
                                        editDisplayTypeDropdowns(values[c]);
                                        editLabelTextfield(values[c], Component[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        editSelectDateFormatDropdownAndDateRanges(values[c], component);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Geofence":
                                        editLabelTextfield(values[c], Component[c]);
                                        editTopMarginTextField(values[c], Component[c]);
                                        editGeofenceShapeandGeofenceTypedropdowns(values[c], component);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Text Field":
                                    case "Address":
                                        editDisplayTypeDropdowns(values[c]);
                                        editLabelTextfield(values[c], Component[c]);
                                        editDataTypeDropDown(values[c]);
                                        editPlaceHolderTextField(values[c], component);
                                        editTopMarginTextField(values[c], Component[c]);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;

                                    case "Drop Down":
                                        editDisplayTypeDropdowns(values[c]);
                                        editLabelTextfield(values[c], Component[c]);
                                        editDropdownType(values[c], component);
                                        editTopMarginTextField(values[c], Component[c]);
                                        clickOnUpdateComponentButton();
                                        clickActionsAndValidationsforAnyComponent(values[c], component, panels, page_name);
                                        break;
                                    default:
                                        System.out.println("Unexpected value for Component[" + c + "]: " + Component[c]);
                                        break;
                                }
                                COSB--;
                            }
                        }
                    }
                    break;
                }
                break;
            }
            ittrator++;
            break;
        }
        return;
    }

    //panels for next modules
    public void clickActionsAndValidationsforAnyComponent(String values, String component, String panels, String page_name) throws Throwable {
        String[] panelsInPage = panels.split("%");
        for (int panelcount = 0; panelcount < panelsInPage.length; panelcount++) {
            String[] panel = panelsInPage[panelcount].split("~");
            String[] Component = component.split(",");
            for (int c = 0; c <= panel.length - 1; c++) {
                if (driver.findElements(clickActionsPanel).size() > 0) {
                    System.out.println("Click Actions");
                    driver.findElement(clickActionsPanel).click();
                    clickActionsSelect(panel[c], component, values, page_name);
                }
                if (driver.findElements(validationsPanel).size() > 0) {
                    System.out.println("validations");
                    if (driver.findElement(validationsPanel).getText().trim().equals("Validation")) {
                        validationTypeSelect(values, panel[c], component);
                    }
                }
                if (driver.findElements(dataSourcePanelDropdownOnly).size() > 0) {
                    System.out.println("Data Source");
                    if (driver.findElement(dataSourcePanelDropdownOnly).getText().trim().equals("Data Source")) {
                        dropdownSourcedropdownManual(values, component);
                    }
                }
                break;
            }
            break;
        }

    }


    public void clickActionsSelect(String panel, String component, String values, String page_name) throws Throwable {
        Thread.sleep(2000);
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            String[] value = panel.split(",");
            String[] options = values.split(",");

            if (Component[c].equals("Radio Button")) {
                String[] action = options[3].split("-");
                for (int navopt = 0; navopt < action.length; navopt++) {
                    String[] navOptions = action[navopt].split("_");
                    if (navopt >= 1) {
                        driver.findElement(clickActionsPanel).click();
                    }
                    if (driver.findElements(selectActionTypeDropdown).size() > 0) {
                        driver.findElement(selectActionTypeDropdown).click();
                        if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).size() > 0) {
                            if (navOptions[0].equals("Navigation")) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).click();
                                selectPageForNavigation(page_name, navOptions[1]);
                            } else if (navOptions[0].equals("Submit")) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).click();
                                if (navOptions[1].equals("true")) {
                                    driver.findElement(clickActionSubmitPreviewToggle).click();
                                    driver.findElement(saveButtonForClickActions).click();
                                }
                            }
                        } else {
                            Point startPoint = driver.findElement(selectActionTypeDropdown).getLocation();
                            int xOffset = 0;
                            int yOffset = 25;
                            act.moveToElement(driver.findElement(selectActionTypeDropdown)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
                        }
                    }
                }
            } else if (Component[c].equals("Image") || Component[c].equals("Text") || Component[c].equals("Drop Down") || Component[c].equals("Save") || Component[c].equals("Printer")) {
                String[] action = options[options.length - 1].split("-");
                for (int navopt = 0; navopt < action.length; navopt++) {
                    String[] navOptions = action[navopt].split("_");
                    Thread.sleep(3000);
                    if (driver.findElements(selectActionTypeDropdown).size() > 0) {
                        driver.findElement(selectActionTypeDropdown).click();
                        if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).size() > 0) {
                            if (navOptions[0].equals("Navigation")) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).click();
                                selectPageForNavigation(page_name, navOptions[1]);
                            } else if (navOptions[0].equals("Submit")) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).click();
                                if (navOptions[1].equals("true")) {
                                    driver.findElement(clickActionSubmitPreviewToggle).click();
                                    driver.findElement(saveButtonForClickActions).click();
                                }
                            }
                        } else {
                            Point startPoint = driver.findElement(selectActionTypeDropdown).getLocation();
                            int xOffset = 0;
                            int yOffset = 20;
                            act.moveToElement(driver.findElement(selectActionTypeDropdown)).moveByOffset(xOffset, yOffset).click().build().perform();
                        }
                    }
                }
            } else if (Component[c].equals("Check Box")) {
                String[] action = options[2].split("-");
                for (int navopt = 0; navopt < action.length; navopt++) {
                    String[] navOptions = action[navopt].split("_");
                    if (navopt >= 1) {
                        driver.findElement(clickActionsPanel).click();
                    }
                    if (driver.findElements(selectActionTypeDropdown).size() > 0) {
                        driver.findElement(selectActionTypeDropdown).click();
                        if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).size() > 0) {
                            if (navOptions[0].equals("Navigation")) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).click();
                                selectPageForNavigation(page_name, navOptions[1]);
                            } else if (navOptions[0].equals("Submit")) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + navOptions[0] + "']")).click();
                                if (navOptions[1].equals("true")) {
                                    driver.findElement(clickActionSubmitPreviewToggle).click();
                                    driver.findElement(saveButtonForClickActions).click();
                                }
                            }
                        } else {
                            Point startPoint = driver.findElement(selectActionTypeDropdown).getLocation();
                            int xOffset = 0;
                            int yOffset = 25;
                            act.moveToElement(driver.findElement(selectActionTypeDropdown)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
                        }
                    }
                }
            }
            break;
        }
    }

    public void selectPageForNavigation(String page_name, String navOptions) throws Throwable {
        driver.findElement(selctPageDropdownClickActions).click();
        if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='" + navOptions + "']")).size() > 0) {
            driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + navOptions + "']")).click();
            driver.findElement(saveButtonForClickActions).click();
        } else {
            Point startPoint = driver.findElement(selctPageDropdownClickActions).getLocation();
            int xOffset = 0;
            int yOffset = 25;
            act.moveToElement(driver.findElement(selctPageDropdownClickActions)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
            driver.findElement(By.xpath("//span[text()='Cancel']//parent::button")).click();
        }
    }

    public void validationTypeSelect(String values, String panel, String component) throws Throwable {
        String[] Component = component.split(",");

        for (int c = 0; c <= Component.length - 1; c++) {
            if (!(Component[c].equals("Navbar") || (Component[c].equals("Drop Down") || Component[c].equals("Image") || Component[c].equals("Text") || Component[c].equals("Save") || Component[c].equals("Separator")))) {
                String[] value = panel.split(",");
                String[] options = values.split(",");
                if ((Component[c].equals("Check Box") || Component[c].equals("Radio Button"))) {
                    driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' " + value[2] + "']")).click();
                    validationTypedropdown(values);
                } else {
                    driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' " + value[1] + "']")).click();
                    validationTypedropdown(values);

                }
            } else if ((Component[c].equals("Drop Down"))) {
                String[] value = panel.split(",");
                String[] options = values.split(",");
                driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' " + value[1] + "']")).click();
                driver.findElement(validationsDropdown).click();
                String[] validations = options[4].split("_");
                if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + validations[0].split("_")[0] + "']")).size() > 0) {
                    driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + validations[0].split("_")[0] + "']")).click();
                    driver.findElement(messagefieldvalidations).sendKeys(validations[0].split("_")[1]);
                    driver.findElement(addValidationbutton).click();
                } else {
                    Point startPoint = driver.findElement(validationsDropdown).getLocation();
                    int xOffset = 0;
                    int yOffset = 25;
                    act.moveToElement(driver.findElement(validationsDropdown)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
                }

            }
            break;
        }
    }

    public void validationTypedropdown(String values) throws Throwable {
        boolean expanded = Boolean.parseBoolean(driver.findElement(validationpanelExpand).getAttribute("aria-expanded"));
        if (expanded == false) {
            driver.findElement(validationpanelExpand).click();
            expanded = Boolean.parseBoolean(driver.findElement(validationpanelExpand).getAttribute("aria-expanded"));
        }
        if (expanded) {
            Thread.sleep(2000);
            driver.findElement(validationsDropdown).click();
            String[] options = values.split(",");
            String[] validations = options[options.length - 1].split("-");
            for (int i = 0; i <= validations.length - 1; i++) {
                if (i >= 1) {
                    driver.findElement(validationsDropdown).click();
                }
                if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + validations[i].split("_")[0] + "']")).size() > 0) {
                    driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + validations[i].split("_")[0] + "']")).click();
                    if (validations[i].split("_")[0].equals("Required")) {
                        driver.findElement(messagefieldvalidations).sendKeys(validations[i].split("_")[1]);
                    } else {
                        driver.findElement(minAndmaxLengthFields).sendKeys(validations[i].split("_")[1]);
                    }
                    Thread.sleep(2000);
                    driver.findElement(addValidationbutton).click();
                    if (validations[i].split("_")[0].equals("Required")) {
                        String text = driver.findElement(By.xpath("//h6[text()='Required: True']")).getText();
                        String[] validationtext = text.split(" ");
                        boolean added = Boolean.parseBoolean(validationtext[1]);
                        Assert.assertTrue(added);
                    }
                } else {
                    Point startPoint = driver.findElement(validationsDropdown).getLocation();
                    int xOffset = 0;
                    int yOffset = 25;
                    act.moveToElement(driver.findElement(validationsDropdown)).moveByOffset(startPoint.getX() + xOffset, startPoint.getY() + yOffset).click().build().perform();
                }
            }
        }
    }

    public void dropdownSourcedropdownManual(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        String[] value = values.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Drop Down")) {
                String[] options = value[5].split("_");
                driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Data Source']")).click();
                driver.findElement(dropdownTypeDataSorce).click();
                if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='" + options[0] + "']")).size() > 0) {
                    driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + options[0] + "']")).click();
                    if (options[0].equals("Manual")) {
                        for (int o = 1; o <= options.length - 1; o++) {
                            Thread.sleep(700);
                            driver.findElement(manualdataLables).sendKeys(options[o]);
                            if (driver.findElement(manualdataLables).getAttribute("value").length() > 0) {
                                driver.findElement(addValueButton).click();
                            }
                        }
                        driver.findElement(saveValueButton).click();
                    }
                    if (options[0].equals("API")) {

                    }
                }

            }
        }

    }


    public void editNavbarComponentStylingButtonAndTitle(String values, String component, String page_name) throws Throwable {
        Thread.sleep(2000);
        String[] Component = component.split(",");
        String[] addPages = page_name.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Navbar")) {
                if (driver.findElements(navbarComponentNavtitle).size() > 0) {
                    driver.findElement(navbarComponentNavIcon1).click();
                    driver.findElement(navbarComponentNavIcon1).click();
                    String[] value = values.split(",");
                    driver.findElement(navbarDisplayiconDropdown).click();
                    driver.findElement(By.xpath("//mat-option[@value='" + value[0] + "']")).click();
                    clickOnUpdateComponentButton();
                    if (value[0].equals("arrow_back")) {
                        driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Click Actions']")).click();
                    }
                    String[] nav = value[1].split("_");
                    if (driver.findElements(selectActionTypeDropdown).size() > 0) {
                        driver.findElement(selectActionTypeDropdown).click();
                        if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + nav[0] + "']")).size() > 0) {
                            driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + nav[0] + "']")).click();
                            driver.findElement(selctPageDropdownClickActions).click();
                            if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='" + nav[1] + "']")).size() > 0) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + nav[1] + "']")).click();
                                driver.findElement(saveButtonForClickActions).click();
                            }
                        }
                    }
                    driver.findElement(navbarComponentNavtitle).click();
                    driver.findElement(navbarTitleField).clear();
                    driver.findElement(navbarTitleField).sendKeys(value[2]);
                    clickOnUpdateComponentButton();
                    String[] navicon2 = value[3].split("_");
                    boolean toggleExpected = Boolean.parseBoolean(navicon2[0]);
                    Thread.sleep(4000);
//                    boolean toggleNavicon2 = Boolean.parseBoolean(driver.findElement(By.xpath("//span[text()='Landing']/../../../following-sibling::div//p[text()='Nav Icon 2']/..//button")).getAttribute("aria-checked"));
                    if (toggleExpected && false) {
                        driver.findElement(By.xpath("//span[text()='Landing']/../../../following-sibling::div//p[text()='Nav Icon 2']/..//button")).click();
                        driver.findElement(navbarComponentNavIcon2).click();
                        driver.findElement(navbarDisplayiconDropdown).click();
                        driver.findElement(By.xpath("//mat-option[@value='" + navicon2[1] + "']")).click();
                        driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Click Actions']")).click();
                        if (driver.findElements(selectActionTypeDropdown).size() > 0) {
                            Thread.sleep(2500);
                            driver.findElement(selectActionTypeDropdown).click();
                            String[] ca = navicon2[2].split("-");
                            if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()=' " + ca[0] + "']")).size() > 0) {
                                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + ca[0] + "']")).click();
                                driver.findElement(selctPageDropdownClickActions).click();
                                if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='" + ca[1] + "']")).size() > 0) {
                                    driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + ca[1] + "']")).click();
                                    driver.findElement(saveButtonForClickActions).click();
                                }
                            }
                        }

                    }
                }
            }
        }

    }

    public void editDisplayTypeDropdowns(String values) throws Throwable {
        if (!(driver.findElements(displayTypeDropdown).isEmpty())) {
            driver.findElement(displayTypeDropdown).click();
            String[] value = values.split(",");
            int size = Integer.parseInt(String.valueOf(driver.findElements(By.xpath("//mat-option")).size()));
            if (size == 2) {
                Assert.assertEquals(size, 2, "Expected Error Message " + size + " But Found : " + 2);
            }
            driver.findElement(By.xpath("//mat-option[@value='" + value[0] + "']")).click();
            String message = driver.findElement(displayTypeDropdownValue).getText().trim().toLowerCase();
            Assert.assertEquals(value[0], message, "Expected Error Message " + value[0] + " But Found : " + message);
        }
    }

    public void editLabelTextfield(String values, String component) throws Throwable {
        if (!(driver.findElements(labelTextField).isEmpty())) {
            String[] value = values.split(",");
            driver.findElement(labelTextField).clear();
            String[] Component = component.split(",");
            for (int c = 0; c <= Component.length - 1; c++) {
                if (Component[c].equals("Check Box") || Component[c].equals("Geofence") || Component[c].equals("Geotag")) {
                    driver.findElement(labelTextField).sendKeys(value[0]);
                    String message = driver.findElement(labelTextField).getAttribute("value");
                    Assert.assertEquals(value[0], message, "Expected Error Message " + value[0] + " But Found : " + message);
                } else {
                    driver.findElement(labelTextField).sendKeys(value[1]);
                    String message = driver.findElement(labelTextField).getAttribute("value");
                    Assert.assertEquals(value[1], message, "Expected Error Message " + value[1] + " But Found : " + message);
                }
            }
        }

    }

    public void editTopMarginTextField(String values, String component) throws Throwable {
        if (!(driver.findElements(topMarginTextField).isEmpty())) {
            String[] value = values.split(",");
            Thread.sleep(3000);
            driver.findElement(topMarginTextField).clear();
            String[] Component = component.split(",");
            for (int c = 0; c <= Component.length - 1; c++) {
                if (Component[c].equals("Separator")) {
                    driver.findElement(topMarginTextField).sendKeys(value[value.length - 1]);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[value.length - 1], message, "Expected Error Message " + value[value.length - 1] + " But Found : " + message);
                }
                if ((Component[c].equals("Printer"))) {
                    driver.findElement(topMarginTextField).sendKeys("16");
                }
                if (Component[c].equals("Save") || Component[c].equals("Text") || Component[c].equals("Check Box") || Component[c].equals("Radio Button")) {
                    driver.findElement(topMarginTextField).sendKeys(value[value.length - 3]);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[value.length - 3], message, "Expected Error Message " + value[value.length - 3] + " But Found : " + message);
                }
                if (Component[c].equals("Image")) {
                    String tp = "16";
                    driver.findElement(topMarginTextField).sendKeys(tp);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(tp, message, "Expected Error Message " + tp + " But Found : " + message);
                }
                if (Component[c].equals("Scanner") || Component[c].equals("Text Field") || Component[c].equals("Range Picker") || Component[c].equals("Address") || Component[c].equals("Geotag")) {
                    driver.findElement(topMarginTextField).sendKeys(value[value.length - 2]);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[value.length - 2], message, "Expected Error Message " + value[value.length - 2] + " But Found : " + message);
                }
                if (Component[c].equals("Drop Down")) {
                    driver.findElement(topMarginTextField).sendKeys(value[3]);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[3], message, "Expected Error Message " + value[3] + " But Found : " + message);
                }
                if (Component[c].equals("Geofence")) {
                    driver.findElement(topMarginTextField).sendKeys(value[1]);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[1], message, "Expected Error Message " + value[1] + " But Found : " + message);
                }
                if (Component[c].equals("File Picker") || Component[c].equals("Media Upload") || Component[c].equals("Date Picker")) {
                    driver.findElement(topMarginTextField).sendKeys(value[2]);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[2], message, "Expected Error Message " + value[2] + " But Found : " + message);
                }

            }
        }
    }

    public void editImageForImageComponent() throws Throwable {
        if (driver.findElements(editbuttonForImageUpload).size() > 0) {
            driver.findElement(editbuttonForImageUpload).sendKeys("D:\\MobileWise\\Logo\\add-user-icon.webp");
        }
    }

    public void editTextTextfield(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Text")) {

                if (!(driver.findElements(textTextfield).isEmpty())) {
                    String[] value = values.split(",");
                    driver.findElement(textTextfield).clear();
                    driver.findElement(textTextfield).sendKeys(value[0]);
                    String message = driver.findElement(textTextfield).getAttribute("value");
                    Assert.assertEquals(value[0], message, "Expected Error Message " + value[0] + " But Found : " + message);
                }
            }
            if (Component[c].equals("Save")) {
                boolean exp = Boolean.parseBoolean(driver.findElement(By.xpath("//mat-panel-title[text()=' Button Styling ']/../..")).getAttribute("aria-expanded"));
                if (exp == false) {
                    driver.findElement(By.xpath("//mat-panel-title[text()=' Button Styling ']/../..")).click();
                    exp = true;
                }
                if (exp) {
                    if (!(driver.findElements(textTextfield).isEmpty())) {
                        String[] value = values.split(",");
                        driver.findElement(textTextfield).clear();
                        driver.findElement(textTextfield).sendKeys(value[1]);
                        String message = driver.findElement(textTextfield).getAttribute("value");
                        Assert.assertEquals(value[1], message, "Expected Error Message " + value[1] + " But Found : " + message);
                    }
                }
            }
        }
    }

    public void editPositionDropdown(String values) throws Throwable {
        if (!(driver.findElements(positionDropdown).isEmpty())) {
            driver.findElement(positionDropdown).click();
            String[] value = values.split(",");
            int size = Integer.parseInt(String.valueOf(driver.findElements(By.xpath("//mat-option")).size()));
            if (size == 3) {
                Assert.assertEquals(size, 3, "Expected Error Message " + size + " But Found : " + 3);
            }
            driver.findElement(By.xpath("//mat-option[@value='" + value[1] + "']")).click();
            String message = driver.findElement(positionDropDownValue).getText().trim().toLowerCase();
            Assert.assertEquals(value[1], message, "Expected Error Message " + value[1] + " But Found : " + message);
        }
    }

    public void editFormattingStyles(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Save") || Component[c].equals("Text")) {
                if (!(driver.findElements(formattingStylesBoldIcon).isEmpty())) {
                    String[] value = values.split(",");
                    String[] formating = value[3].split("-");
                    boolean B = Boolean.parseBoolean(formating[0]);
                    boolean I = Boolean.parseBoolean(formating[1]);
                    boolean U = Boolean.parseBoolean(formating[2]);
                    if (B) {
                        driver.findElement(formattingStylesBoldIcon).click();
                    }
                    if (I) {
                        driver.findElement(formattingStylesItalicIcon).click();
                    }
                    if (U) {
                        driver.findElement(formattingStylesUnderlineIcon).click();
                    }
                    driver.findElement(formattingStylesInput).clear();
                    driver.findElement(formattingStylesInput).sendKeys(formating[3]);
                }
            }
        }
    }

    public void editDropdownType(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Drop Down")) {
                String[] value = values.split(",");
                driver.findElement(dropdownTypeDropdown).click();
                driver.findElement(By.xpath("//mat-option[@value='" + value[2] + "']")).click();
            }
        }

    }

    public void editDataTypeDropDown(String values) throws Throwable {
        if (driver.findElements(dataTypeDropdown).size() > 0) {
            driver.findElement(dataTypeDropdown).click();
            String[] value = values.split(",");
            int size = Integer.parseInt(String.valueOf(driver.findElements(By.xpath("//mat-option")).size()));
            if (size == 3) {
                Assert.assertEquals(size, 3, "Expected Error Message " + size + " But Found : " + 3);
            }
            driver.findElement(By.xpath("//mat-option[@value='" + value[2] + "']")).click();
            String message = driver.findElement(dataTypeDropdownValue).getText().trim().toLowerCase();
            Assert.assertEquals(value[2], message, "Expected Error Message " + value[2] + " But Found : " + message);
        }
    }

    public void editPlaceHolderTextField(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Text Field")) {
                if (!(driver.findElements(placeHolderTextField).isEmpty())) {
                    String[] value = values.split(",");
                    driver.findElement(placeHolderTextField).clear();
                    driver.findElement(placeHolderTextField).sendKeys(value[3]);
                    String message = driver.findElement(placeHolderTextField).getAttribute("value");
                    Assert.assertEquals(value[3], message, "Expected Error Message " + value[3] + " But Found : " + message);
                }
            }
            if (Component[c].equals("Address")) {
                if (!(driver.findElements(placeHolderTextField).isEmpty())) {
                    String[] value = values.split(",");
                    driver.findElement(placeHolderTextField).clear();
                    String text = "Enter Address";
                    driver.findElement(placeHolderTextField).sendKeys(text);
                    String message = driver.findElement(placeHolderTextField).getAttribute("value");
                    Assert.assertEquals(text, message, "Expected Error Message " + text + " But Found : " + message);
                }
            }
        }

    }

    public void editFilePickerComponent(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("File Picker")) {
                editFileTypeDropdown(values, component);
                editMaxSizeTextfield(values, component);
                editTogglesFilePicker(values, component);
            }
        }
    }

    public void editFileTypeDropdown(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        String[] value = values.split(",");
        String[] type = value[3].split("-");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("File Picker")) {
                if (driver.findElements(fileTypedropdown).size() > 0) {
                    driver.findElement(fileTypedropdown).click();
                    int size = Integer.parseInt(String.valueOf(driver.findElements(By.xpath("//mat-option")).size()));
                    if (size == 4) {
                        Assert.assertEquals(size, 4, "Expected Error Message " + size + " But Found : " + 4);
                    }
                    for (int i = 0; i <= type.length - 1; i++) {
                        if (driver.findElements(By.xpath("//mat-option[@role='option']/mat-pseudo-checkbox/following-sibling::span[text()='" + type[i] + "']")).size() > 0) {
                            driver.findElement(By.xpath("//mat-option[@role='option']/mat-pseudo-checkbox/following-sibling::span[text()='" + type[i] + "']")).click();
                        }
                    }
                    driver.findElement(labelTextField).click();
                }
            }
        }
    }

    public void uploadTyppeDropdownImagePicker(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Media Upload")) {
                String[] Value = values.split(",");
                String[] prop = Value[3].split("_");
                driver.findElement(uploadTypeDropDown).click();
                int size = Integer.parseInt(String.valueOf(driver.findElements(By.xpath("//mat-option")).size()));
                if (size == 4) {
                    Assert.assertEquals(size, 4, "Expected Error Message " + size + " But Found : " + 4);
                }
                if (prop[0].equals("image")) {
                    driver.findElement(By.xpath("//mat-option[@value='" + prop[0] + "']")).click();
                    Thread.sleep(1000);
                    driver.findElement(allowedImageType).click();
                    String[] select = prop[1].split("-");
                    for (int i = 0; i <= select.length - 1; i++) {
                        if (driver.findElements(By.xpath("//mat-option/mat-pseudo-checkbox/following-sibling::span[text()='" + select[0] + "']")).size() > 0) {
                            driver.findElement(By.xpath("//mat-option/mat-pseudo-checkbox/following-sibling::span[text()='" + select[i] + "']")).click();
                        }
                    }
                    act.moveByOffset(0, 50).click().perform();
                    driver.findElement(maxSizeImageAndVideo).sendKeys(prop[2]);
                    boolean ImageCompression = Boolean.parseBoolean(prop[3]);
                    boolean GallaryUpload = Boolean.parseBoolean(prop[4]);
                    boolean GeoReference = Boolean.parseBoolean(prop[5]);
                    boolean StatusImageCompression = Boolean.parseBoolean(driver.findElement(imageCompressionImagePicker).getAttribute("aria-checked"));
                    boolean StatusGallaryUpload = Boolean.parseBoolean(driver.findElement(gallaryUploadToggleImagePickerImage).getAttribute("aria-checked"));
                    boolean StatusGeoReference = Boolean.parseBoolean(driver.findElement(geoReferencetoggleImagePicker).getAttribute("aria-checked"));
                    if (!(ImageCompression == StatusImageCompression)) {
                        driver.findElement(imageCompressionImagePicker).click();
                    }
                    if (!(GallaryUpload == StatusGallaryUpload)) {
                        driver.findElement(gallaryUploadToggleImagePickerImage).click();
                    }
                    if (!(GeoReference == StatusGeoReference)) {
                        driver.findElement(geoReferencetoggleImagePicker).click();
                        if (GeoReference) {
                            driver.findElement(baringToggleImagePicker).click();
                            driver.findElement(gpsAccuracyfield).sendKeys("20");
                        }
                    }
                }
                if (prop[0].equals("video")) {
                    driver.findElement(By.xpath("//mat-option[@value='" + prop[0] + "']")).click();
                    Thread.sleep(1000);
                    driver.findElement(allowedVideoType).click();
                    String[] select = prop[1].split("-");
                    for (int i = 0; i <= select.length - 1; i++) {
                        if (driver.findElements(By.xpath("//mat-option/mat-pseudo-checkbox/following-sibling::span[text()='" + select[0] + "']")).size() > 0) {
                            driver.findElement(By.xpath("//mat-option/mat-pseudo-checkbox/following-sibling::span[text()='" + select[i] + "']")).click();
                        }
                    }
                    act.moveByOffset(0, 50).click().perform();
                    Thread.sleep(2000);
                    driver.findElement(maxSizeImageAndVideo).sendKeys(prop[2]);
                    boolean VideoCompression = Boolean.parseBoolean(prop[3]);
                    boolean GallaryUpload = Boolean.parseBoolean(prop[4]);
                    boolean GeoReference = Boolean.parseBoolean(prop[5]);
                    boolean StatusVideoCompression = Boolean.parseBoolean(driver.findElement(videoCompressionToggleImagePicker).getAttribute("aria-checked"));
                    boolean StatusGallaryUpload = Boolean.parseBoolean(driver.findElement(gallaryUploadToggleImagePickerImage).getAttribute("aria-checked"));
                    boolean StatusGeoReference = Boolean.parseBoolean(driver.findElement(geoReferencetoggleImagePicker).getAttribute("aria-checked"));
                    if (!(VideoCompression == StatusVideoCompression)) {
                        driver.findElement(videoCompressionToggleImagePicker).click();
                    }
                    if (!(GallaryUpload == StatusGallaryUpload)) {
                        driver.findElement(gallaryUploadToggleImagePickerImage).click();
                    }
                    if (!(GeoReference == StatusGeoReference)) {
                        driver.findElement(geoReferencetoggleImagePicker).click();
                        if (GeoReference) {
                            driver.findElement(baringToggleImagePicker).click();
                            driver.findElement(gpsAccuracyfield).sendKeys("20");
                        }
                    }
                }
            }
        }
    }

    public void editSelectDateFormatDropdownAndDateRanges(String values, String component) throws Throwable {
        String[] value = values.split(",");
        if (driver.findElements(selectDateFormatDropdown).size() > 0) {
            driver.findElement(selectDateFormatDropdown).click();
            if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='" + value[3] + "']")).size() > 0) {
                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + value[3] + "']")).click();
            }
        }
        if (driver.findElements(dateRangeToggle).size() > 0) {
            boolean expected = Boolean.parseBoolean(value[4]);
            if (expected) {
                driver.findElement(dateRangeToggle).click();
                boolean exp = Boolean.parseBoolean(driver.findElement(dateRangeToggle).getAttribute("aria-checked"));
                if (exp) {
                    driver.findElement(historicDateRangeRangePicker).sendKeys(value[5]);
                    driver.findElement(futureDateRangeRangePicker).sendKeys(value[6]);
                }
            }
        }
    }


    public void editMaxSizeTextfield(String values, String component) throws Throwable {
        String[] value = values.split(",");
        if (driver.findElements(maxSizeTextField).size() > 0) {
            driver.findElement(maxSizeTextField).clear();
            String[] Component = component.split(",");
            for (int c = 0; c <= Component.length - 1; c++) {
                if (Component[c].equals("File Picker")) {
                    driver.findElement(maxSizeTextField).sendKeys(value[4]);
                    String message = driver.findElement(maxSizeTextField).getAttribute("value");
                    Assert.assertEquals(value[4], message, "Expected Error Message " + value[4] + " But Found : " + message);
                }
                if (Component[c].equals("Image Picker")) {
                    driver.findElement(maxSizeTextField).sendKeys(value[5]);
                    String message = driver.findElement(maxSizeTextField).getAttribute("value");
                    Assert.assertEquals(value[5], message, "Expected Error Message " + value[5] + " But Found : " + message);
                }

            }
        }

    }

    public void thicknessTextFieldSeparator(String values) throws Throwable {
        String[] value = values.split(",");
        if (driver.findElements(thicknessSeparator).size() > 0) {
            driver.findElement(thicknessSeparator).clear();
            driver.findElement(thicknessSeparator).sendKeys(value[0]);
        }

    }

    public void editTogglesFilePicker(String values, String component) throws Throwable {
        String[] value = values.split(",");
        boolean PreviewFile = Boolean.parseBoolean(value[5]);
        boolean FileCompression = Boolean.parseBoolean(value[6]);
        boolean StatusPreviewFile = Boolean.parseBoolean(driver.findElement(previewToggle).getAttribute("aria-checked"));
        boolean StatusFileCompression = Boolean.parseBoolean(driver.findElement(fileCompressiontoggle).getAttribute("aria-checked"));
        if (!(PreviewFile == StatusPreviewFile)) {
            driver.findElement(previewToggle).click();
        }
        if (!(FileCompression == StatusFileCompression)) {
            driver.findElement(fileCompressiontoggle).click();
        }
    }

    public void editGeofenceShapeandGeofenceTypedropdowns(String values, String component) throws Throwable {
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Geofence")) {
                String[] value = values.split(",");
                if (driver.findElements(selectGeofenceTypeDropDown).size() > 0) {
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                    driver.findElement(selectGeofenceTypeDropDown).click();
                    if (driver.findElements(By.xpath("//mat-option[@value='" + value[2] + "']")).size() > 0) {
                        driver.findElement(By.xpath("//mat-option[@value='" + value[2] + "']")).click();
                    } else {
                        driver.findElement(selectGeofenceTypeDropDown).click();
                    }
                }
                if (driver.findElements(selectGeofenceShapeDropdown).size() > 0) {
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                    driver.findElement(selectGeofenceShapeDropdown).click();
                    if (driver.findElements(By.xpath("//mat-option[@value='" + value[3] + "']")).size() > 0) {
                        driver.findElement(By.xpath("//mat-option[@value='" + value[3] + "']")).click();
                    } else {
                        driver.findElement(selectGeofenceShapeDropdown).click();
                    }
                }
            }
        }

    }

    public void ZPlFormat() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@formcontrolname='image']")).clear();
        String filePath = "C:\\Users\\user\\Documents\\Mobiwise\\ZPLCodePrinter.txt";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(filePath);
            // Wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // Read each line and append it to the StringBuilder.
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n"); // Append newline character if needed
            }
            // Close the BufferedReader after reading.
            bufferedReader.close();
        } catch (IOException e) {
            // Handle any potential IO exceptions.
            e.printStackTrace();
        }

        // Convert the StringBuilder to a String.
        String fileContent = stringBuilder.toString();

        // Print the content of the file as a String.
        System.out.println("Content of the file:");
        System.out.println(fileContent);
        driver.findElement(By.xpath("//textarea[@formcontrolname='image']")).sendKeys(fileContent);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//mat-hint[text()='ZPL Editor : ']/a")).click();
        Thread.sleep(4000);
        String title = driver.getTitle();
        if (title.contains("Labelary Online ZPL Viewer")) {
            Assert.assertTrue(true);
        }
        Set<String> windowHandles = driver.getWindowHandles();
        int length = windowHandles.toArray().length;
        System.out.println(length);
        String FirstWindow = (String) windowHandles.toArray()[0];
        driver.switchTo().window(FirstWindow);
    }


    public void editRadioButtonComponent(String values, String component, String panels) throws Throwable {

        String[] value = values.split(",");
        if (value.length < 2) {
            // Handle the case where there are not enough values in the 'values' parameter
            System.err.println("Error: Insufficient data in 'values' parameter");
            return;
        }

        String[] radioLabels = value[1].split("-");
        driver.findElement(radioButtonComponent).click();
        driver.findElement(radioButtonTitleTextField).clear();
        driver.findElement(radioButtonTitleTextField).sendKeys(value[0]);
        int var = 0;
        for (String radioLabel : radioLabels) {
            String[] radioLabelInfo = radioLabel.split("_");
            if (radioLabelInfo.length < 2) {
                // Handle the case where there are not enough values in the 'radioLabel' parameter
                System.err.println("Error: Insufficient data in 'radioLabel' parameter");
                return;
            }
            if (var < 2) {
                driver.findElements(radioButtonValuesTextField).get(var).clear();
            }
            driver.findElement(radioButtonAddValue).click();
            driver.findElements(radioButtonValuesTextField).get(var).sendKeys(radioLabelInfo[0]);
            var++;
            if (!Boolean.parseBoolean(radioLabelInfo[1])) {
                driver.findElement(radioButtonDeleteValues).click();
            }
        }

        clickOnUpdateComponentButton();
    }


//    public void editRadioButtonComponent(String values, String component, String panels) throws Throwable {
//        String[] panelsInPage = panels.split("%");
//        for (int panelcount = 0; panelcount < panelsInPage.length; panelcount++) {
//            String[] panel = panelsInPage[panelcount].split("~");
//            String[] Component = component.split(",");
//            for (int c = 0; c <= Component.length - 1; c++) {
//                if (Component[c].equals("Radio Button")) {
//                    if (driver.findElements(radioButtonComponent).size() > 0) {
//                        driver.findElement(radioButtonComponent).click();
//                        String[] value = values.split(",");
//                        driver.findElement(radioButtonTitleTextField).clear();
//                        driver.findElement(radioButtonTitleTextField).sendKeys(value[0]);
//                        String[] radioLables = value[1].split("-");
//                        for (int d = 2; d <= radioLables.length - 1; d++) {
//                            String[] deleteIconsClick = radioLables[d].split("_");
//                            int countLables = radioLables.length - 1;
//                            if (countLables > 1) {
//                                for (int i = 2; i <= countLables; i++) {
//                                    driver.findElement(radioButtonAddValue).click();
//                                    driver.findElements(radioButtonValuesTextField).get(i).sendKeys("value");
//                                }
//                            }
//                            for (int j = 1; j <= deleteIconsClick.length - 1; j = j + 2) {
//                                boolean clickDeleteIcon = Boolean.parseBoolean(deleteIconsClick[j]);
//                                for (int i = 0; i <= radioLables.length - 1; i++) {
//                                    if (i == 0 || i == 1) {
//                                        Thread.sleep(1000);
//                                        driver.findElements(radioButtonValuesTextField).get(i).clear();
//                                        driver.findElements(radioButtonValuesTextField).get(i).sendKeys(radioLables[i]);
//                                    } else {
//                                        for (int Del = 0; Del <= deleteIconsClick.length - 1; Del = Del + 2) {
//                                            Thread.sleep(1000);
//                                            driver.findElements(radioButtonValuesTextField).get(i).clear();
//                                            driver.findElements(radioButtonValuesTextField).get(i).sendKeys(deleteIconsClick[Del]);
//                                        }
//                                    }
//                                    if (!(clickDeleteIcon) && i >= 2) {
//                                        driver.findElement(radioButtonDeleteValues).click();
//                                    }
//                                }
//                                break;
//                            }
//                            if(countLables==d){
//                                break;
//                            }
//                        }
//                        clickOnUpdateComponentButton();
//                    }
//                }
//            }
//        }
//    }


    public void clickOnUpdateComponentButton() throws Throwable {
//        boolean disabled = Boolean.parseBoolean(driver.findElement(updateComponentButton).getAttribute("disabled"));
//        if (!disabled) {
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(updateComponentButton).click();
//        }
    }

    public void createNavigationForDataListPage() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(dataListViewPage).click();
        int xOffset = 500;
        int yOffset = 0;
        act.moveToElement(driver.findElement(dataListViewPage)).moveByOffset(xOffset, yOffset).click().build().perform();
        WebElement Source = driver.findElement(By.xpath("//div[text()='Navbar']"));
        Thread.sleep(5000);
        WebElement Target = driver.findElement(screenBuilder);
        Point initialTargetLocation = Target.getLocation();
        int yOffsetValue = initialTargetLocation.getY() - 500;
        act.moveToElement(Source).clickAndHold().perform();
        act.moveToElement(Target).moveByOffset(0, yOffsetValue).release().perform();
        driver.findElement(navbarComponentNavIcon1).click();
        driver.findElement(navbarDisplayiconDropdown).click();
        driver.findElement(By.xpath("//mat-option[@value='arrow_back']")).click();
        clickOnUpdateComponentButton();
        driver.findElement(By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span[text()=' Click Actions']")).click();
        if (driver.findElements(selectActionTypeDropdown).size() > 0) {
            Thread.sleep(3000);
            driver.findElement(selectActionTypeDropdown).click();
            driver.findElement(By.xpath("//mat-option[@role='option']/span[text()=' Navigation']")).click();
            driver.findElement(selctPageDropdownClickActions).click();
            if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='Page3']")).size() > 0) {
                driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='Page3']")).click();
                driver.findElement(saveButtonForClickActions).click();
                driver.findElement(navbarComponentNavtitle).click();
                driver.findElement(navbarTitleField).clear();
                driver.findElement(navbarTitleField).sendKeys("Data List Preview");
                clickOnUpdateComponentButton();
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

}






