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
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PropertiesSideBar {
    WebDriver driver;
    private By backArrowPropertiesBar = By.xpath("//mat-toolbar[contains(@class,'mat-toolbar sidemenu-toolbar')]//button//mat-icon[text()='arrow_back']/parent::button");
    private By componentSideBarHeading = By.xpath("//mat-toolbar[contains(@class,'mat-toolbar sidemenu-toolbar')]//button//mat-icon[text()='arrow_back']//following::span[contains(@class,'title')]");
    private By componentOnTheScreenBuilder = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div");
    private By displayTypeDropdown = By.xpath("//mat-label[text()='Display Type']/parent::label/parent::div/parent::div/following::div/mat-select/div/div//span/span/../../following-sibling::div[contains(@class,'mat-mdc-select-arrow-wrapper')]");
    private By displayTypeDropdownValue = By.xpath("//mat-label[text()='Display Type']/../../../following-sibling::div/mat-select/div/div/span/span");
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
    private By dataTypeDropdownValue = By.xpath("//mat-label[text()=' Data Type']/../../../following-sibling::div//div/div/span/span");
    private By placeHolderTextField = By.xpath("//input[@formcontrolname='placeholder']");
    private By radioButtonComponent = By.xpath("//div[contains(@class,'mobile-canvas-container')]//div[contains(@class,'mobile-canvas ng-star-inserted')]//div//div[contains(@class,'cdk-drop-list')]//lib-widget-filter/div/label/following-sibling::div[@role='radiogroup']");
    private By radioButtonTitleTextField = By.xpath("//mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title[text()=' Input Properties ']/../../following-sibling::div//input[@formcontrolname='title']");
    private By radioButtonValuesTextField = By.xpath("//mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title[text()=' Input Properties ']/../../following-sibling::div//mat-label[text()='Label']/../../../following-sibling::div/input");
    private By radioButtonAddValue = By.xpath("//button//span[text()=' Add Value ']//parent::button");
    private By radioButtonDeleteValues = By.xpath("//mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title[text()=' Input Properties ']/../../following-sibling::div//mat-label[text()='Label']/../../../following-sibling::div/mat-icon[text()='delete']");
    private By fileTypedropdown = By.xpath("//mat-label[text()='Files types']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By maxSizeTextField = By.xpath("//input[@formcontrolname='maxSize']");
    private By previewToggle = By.xpath("//span[text()='Preview File']/../../button[@role='switch']");
    private By previewToggleImagePickerImage = By.xpath("//span[text()='Preview Image']/../../button[@role='switch']");
    private By previewVideoImagePicker = By.xpath("//span[text()='Preview Video']/../../button[@role='switch']");
    private By videoCompressionToggleImagePicker = By.xpath("//span[text()='Video Compression']/../../button[@role='switch']");
    private By imageCompressionImagePicker = By.xpath("//span[text()='Image Compression']/../../button[@role='switch']");
    private By autoRotatetoggleImagePicker = By.xpath("//span[text()='Auto-rotate']/../../button[@role='switch']");
    private By fileCompressiontoggle = By.xpath("//span[text()='File Compression']/../../button[@role='switch']");
    private By uploadTypeDropDown = By.xpath("//mat-label[text()='Upload Type']/../../../following-sibling::div//div/following-sibling::div");
    private By allowedImageType = By.xpath("//mat-label[text()='Allowed Image Types']//parent::label//parent::div/../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By allowedVideoType = By.xpath("//mat-label[text()='Allowed Video Types']//parent::label//parent::div/../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By maxVideoSizeImagePicker = By.xpath("//input[@formcontrolname='maxVideoSize']");
    private By maxImageSizeImagePicker = By.xpath("//input[@formcontrolname='maxImageSize']");
    private By minDateRangeRangePicker = By.xpath("//mat-label[text()='Minimum Date Range (in days)']/../../../following-sibling::div/input[@type='number']");
    private By maxDateRangeRangePicker = By.xpath("//mat-label[text()='Maximum Date Range (in days)']/../../../following-sibling::div/input[@type='number']");
    private By selectDateFormatDropdown = By.xpath("//mat-label[text()='Select Date Format:']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By thicknessSeparator = By.xpath("//input[@formcontrolname='thickness']");
    private By selectGeofenceTypeDropDown = By.xpath("//mat-label[text()='Select Geofence Types:']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By selectGeofenceShapeDropdown = By.xpath("//mat-label[text()='Select Geofence Shape:']/../../../following-sibling::div/mat-select/div/div/following-sibling::div");
    private By selectPanelInputProperties = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/div/div");
    private By selectPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title");
    private By clickActionsPanelAndValidationPanel = By.xpath("//mat-expansion-panel-header[contains(@class,'mat-expansion-panel-header mat-focus-indicator')]/span/mat-panel-title/span");
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

    public void editPropertiesOfComponent(String properties, String panels, String values_comp, String component) throws Throwable {
        Thread.sleep(3000);
        if (panelsarePresentFlag) {
            String[] Component = component.split(",");
            String[] values = values_comp.split("~");
            for (int c = 0; c <= Component.length - 1; c++) {
                String[] fields = properties.split(",");
                String[] panelsToExpand = panels.split(",");
                int len = panelsToExpand.length - 1;
                for (int i = 0; i <= driver.findElements(selectPanel).size() - 1; i++) {
                    if (panelsToExpand[0].equals("Input Properties") || panelsToExpand[0].equals("Address Properties")) {
                        if (driver.findElements(selectPanelInputProperties).get(i).getText().trim().equals(panelsToExpand[0])) {
                            editRadioButtonComponent(values[c], component);
                            thicknessTextFieldSeparator(values[c]);
                            editFilePickerComponent(values[c], component);
                            uploadTyppeDropdownImagePicker(values[c], component);
                            editDisplayTypeDropdowns(values[c]);
                            editLabelTextfield(values[c], Component[c]);
                            editImageForImageComponent();
                            editTextTextfield(values[c], component);
                            editPositionDropdown(values[c]);
                            editPlaceHolderTextField(values[c]);
                            editDataTypeDropDown(values[c]);
                            editTopMarginTextField(values[c], Component[c]);
                            editSelectDateFormatDropdownAndDateRanges(values[c], component);
                            editGeofenceShapeandGeofenceTypedropdowns(values[c], component);
                            editFormattingStyles(values[c], component);
                        }
                    } else {
                        if (driver.findElements(selectPanel).get(i).getText().trim().equals(panelsToExpand[0])) {
                            editRadioButtonComponent(values[c], component);
                            thicknessTextFieldSeparator(values[c]);
                            editFilePickerComponent(values[c], component);
                            uploadTyppeDropdownImagePicker(values[c], component);
                            editDisplayTypeDropdowns(values[c]);
                            editLabelTextfield(values[c], Component[c]);
                            editImageForImageComponent();
                            editTextTextfield(values[c], component);
                            editPositionDropdown(values[c]);
                            editPlaceHolderTextField(values[c]);
                            editDataTypeDropDown(values[c]);
                            editTopMarginTextField(values[c], Component[c]);
                            editSelectDateFormatDropdownAndDateRanges(values[c], component);
                            editGeofenceShapeandGeofenceTypedropdowns(values[c], component);
                            editFormattingStyles(values[c], component);
                        }

                    }
                }
                if (len >= 1) {
                    for (int i = 1; i <= len; i++) {
                        if (driver.findElement(clickActionsPanelAndValidationPanel).getText().trim().equals(panelsToExpand[i])) {

                        }
                    }

                }
            }


        }
    }


    public void editNavbarComponentStylingButtonAndTitle(String values, String component) throws Throwable {
        Thread.sleep(2000);
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Navbar")) {
//                driver.findElement()
            }
        }

    }

    public void editDisplayTypeDropdowns(String values) throws Throwable {
        Thread.sleep(3000);
        if (!(driver.findElements(displayTypeDropdown).isEmpty())) {
            Thread.sleep(3000);
            driver.findElement(displayTypeDropdown).click();
            String[] value = values.split(",");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//mat-option[@value='" + value[0] + "']")).click();
            String message = driver.findElement(displayTypeDropdownValue).getText().trim().toLowerCase();
            Assert.assertEquals(value[0], message, "Expected Error Message " + value[0] + " But Found : " + message);
        }
    }

    public void editLabelTextfield(String values, String component) throws Throwable {
        Thread.sleep(3000);
        if (!(driver.findElements(labelTextField).isEmpty())) {
            Thread.sleep(3000);
            String[] value = values.split(",");
            driver.findElement(labelTextField).clear();
            String[] Component = component.split(",");
            for (int c = 0; c <= Component.length - 1; c++) {
                if (Component[c].equals("Check Box") || Component[c].equals("Geofence") || Component[c].equals("Geotag")) {
                    driver.findElement(labelTextField).sendKeys(value[0]);
                    Thread.sleep(2000);
                    String message = driver.findElement(labelTextField).getAttribute("value");
                    Assert.assertEquals(value[0], message, "Expected Error Message " + value[0] + " But Found : " + message);
                } else {
                    driver.findElement(labelTextField).sendKeys(value[1]);
                    Thread.sleep(2000);
                    String message = driver.findElement(labelTextField).getAttribute("value");
                    Assert.assertEquals(value[1], message, "Expected Error Message " + value[1] + " But Found : " + message);
                }
            }
        }

    }

    public void editTopMarginTextField(String values, String component) throws Throwable {
        Thread.sleep(3000);

        if (!(driver.findElements(topMarginTextField).isEmpty())) {
            Thread.sleep(3000);
            String[] value = values.split(",");
            driver.findElement(topMarginTextField).clear();
            String[] Component = component.split(",");
            for (int c = 0; c <= Component.length - 1; c++) {
                if (Component[c].equals("Separator")) {
                    driver.findElement(topMarginTextField).sendKeys(value[value.length - 1]);
                    Thread.sleep(2000);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[value.length - 1], message, "Expected Error Message " + value[value.length - 1] + " But Found : " + message);
                }
                if (Component[c].equals("Save") || Component[c].equals("Text") || Component[c].equals("Check Box") || Component[c].equals("Radio Button")) {
                    driver.findElement(topMarginTextField).sendKeys(value[value.length - 3]);
                    Thread.sleep(2000);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[value.length - 3], message, "Expected Error Message " + value[value.length - 3] + " But Found : " + message);
                }
                if (Component[c].equals("Scanner") || Component[c].equals("Image") || Component[c].equals("Text Field") || Component[c].equals("Date Picker") || Component[c].equals("Address") || Component[c].equals("Geotag")) {
                    driver.findElement(topMarginTextField).sendKeys(value[value.length - 2]);
                    Thread.sleep(2000);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[value.length - 2], message, "Expected Error Message " + value[value.length - 2] + " But Found : " + message);
                }
                if (Component[c].equals("Drop Down")) {
                    driver.findElement(topMarginTextField).sendKeys(value[3]);
                    Thread.sleep(2000);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[3], message, "Expected Error Message " + value[3] + " But Found : " + message);
                }
                if (Component[c].equals("Geofence")) {
                    driver.findElement(topMarginTextField).sendKeys(value[1]);
                    Thread.sleep(2000);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[1], message, "Expected Error Message " + value[1] + " But Found : " + message);
                }
                if (Component[c].equals("File Picker") || Component[c].equals("Image Picker") || Component[c].equals("Range Picker")) {
                    driver.findElement(topMarginTextField).sendKeys(value[2]);
                    Thread.sleep(2000);
                    String message = driver.findElement(topMarginTextField).getAttribute("value");
                    Assert.assertEquals(value[2], message, "Expected Error Message " + value[2] + " But Found : " + message);
                }

            }
        }
    }

    public void editImageForImageComponent() throws Throwable {
        Thread.sleep(3000);
        if (driver.findElements(editbuttonForImageUpload).size() > 0) {
            driver.findElement(editbuttonForImageUpload).sendKeys("D:\\MobileWise\\Logo\\logo2.webp");
        }
    }

    public void editTextTextfield(String values, String component) throws Throwable {
        Thread.sleep(3000);
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Text")) {
                if (!(driver.findElements(textTextfield).isEmpty())) {
                    Thread.sleep(3000);
                    String[] value = values.split(",");
                    driver.findElement(textTextfield).clear();
                    driver.findElement(textTextfield).sendKeys(value[0]);
                    Thread.sleep(2000);
                    String message = driver.findElement(textTextfield).getAttribute("value");
                    Assert.assertEquals(value[0], message, "Expected Error Message " + value[0] + " But Found : " + message);
                }
            }
            if (Component[c].equals("Save")) {
                if (!(driver.findElements(textTextfield).isEmpty())) {
                    Thread.sleep(3000);
                    String[] value = values.split(",");
                    driver.findElement(textTextfield).clear();
                    driver.findElement(textTextfield).sendKeys(value[1]);
                    Thread.sleep(2000);
                    String message = driver.findElement(textTextfield).getAttribute("value");
                    Assert.assertEquals(value[1], message, "Expected Error Message " + value[1] + " But Found : " + message);
                }
            }
        }
    }

    public void editPositionDropdown(String values) throws Throwable {
        Thread.sleep(3000);
        if (!(driver.findElements(positionDropdown).isEmpty())) {
            Thread.sleep(3000);
            driver.findElement(positionDropdown).click();
            String[] value = values.split(",");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//mat-option[@value='" + value[1] + "']")).click();
            String message = driver.findElement(positionDropDownValue).getText().trim().toLowerCase();
            Assert.assertEquals(value[1], message, "Expected Error Message " + value[1] + " But Found : " + message);
        }
    }

    public void editFormattingStyles(String values, String component) throws Throwable {
        Thread.sleep(3000);
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Save") || Component[c].equals("Text")) {
                if (!(driver.findElements(formattingStylesBoldIcon).isEmpty())) {
                    Thread.sleep(3000);
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

    public void editDataTypeDropDown(String values) throws Throwable {
        Thread.sleep(3000);
        if (driver.findElements(dataTypeDropdown).size() > 0) {
            driver.findElement(dataTypeDropdown).click();
            String[] value = values.split(",");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//mat-option[@value='" + value[2] + "']")).click();
            String message = driver.findElement(dataTypeDropdownValue).getText().trim().toLowerCase();
            Assert.assertEquals(value[2], message, "Expected Error Message " + value[2] + " But Found : " + message);
        }
    }

    public void editPlaceHolderTextField(String values) throws Throwable {
        Thread.sleep(3000);
        if (!(driver.findElements(placeHolderTextField).isEmpty())) {
            Thread.sleep(3000);
            String[] value = values.split(",");
            driver.findElement(placeHolderTextField).clear();
            driver.findElement(placeHolderTextField).sendKeys(value[3]);
            Thread.sleep(2000);
            String message = driver.findElement(placeHolderTextField).getAttribute("value");
            Assert.assertEquals(value[3], message, "Expected Error Message " + value[3] + " But Found : " + message);
        }

    }

    public void editFilePickerComponent(String values, String component) throws Throwable {
        Thread.sleep(3000);
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
        Thread.sleep(3000);
        String[] Component = component.split(",");
        String[] value = values.split(",");
        String[] type = value[3].split("-");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("File Picker")) {
                if (driver.findElements(fileTypedropdown).size() > 0) {
                    Thread.sleep(3000);
                    driver.findElement(fileTypedropdown).click();
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
        Thread.sleep(3000);
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Image Picker")) {
                String[] Value = values.split(",");
                String[] prop = Value[3].split("_");
                driver.findElement(uploadTypeDropDown).click();
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
                    Thread.sleep(2000);
                    driver.findElement(maxImageSizeImagePicker).sendKeys(prop[2]);
                    boolean PreviewImage = Boolean.parseBoolean(prop[3]);
                    boolean ImageCompression = Boolean.parseBoolean(prop[4]);
                    boolean AutoRotateImage = Boolean.parseBoolean(prop[5]);
                    boolean StatusPreviewImage = Boolean.parseBoolean(driver.findElement(previewToggleImagePickerImage).getAttribute("aria-checked"));
                    boolean StatusImageCompression = Boolean.parseBoolean(driver.findElement(imageCompressionImagePicker).getAttribute("aria-checked"));
                    boolean StatusAutoRotateImage = Boolean.parseBoolean(driver.findElement(autoRotatetoggleImagePicker).getAttribute("aria-checked"));
                    if (!(PreviewImage == StatusPreviewImage)) {
                        driver.findElement(previewToggleImagePickerImage).click();
                    }
                    if (!(ImageCompression == StatusImageCompression)) {
                        driver.findElement(imageCompressionImagePicker).click();
                    }
                    if (!(AutoRotateImage == StatusAutoRotateImage)) {
                        driver.findElement(autoRotatetoggleImagePicker).click();
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
                    driver.findElement(maxVideoSizeImagePicker).sendKeys(prop[2]);
                    boolean PreviewVideo = Boolean.parseBoolean(prop[3]);
                    boolean VideoCompression = Boolean.parseBoolean(prop[4]);
                    boolean StatusPreviewVideo = Boolean.parseBoolean(driver.findElement(previewVideoImagePicker).getAttribute("aria-checked"));
                    boolean StatusVideoCompression = Boolean.parseBoolean(driver.findElement(videoCompressionToggleImagePicker).getAttribute("aria-checked"));
                    if (!(PreviewVideo == StatusPreviewVideo)) {
                        driver.findElement(previewVideoImagePicker).click();
                    }
                    if (!(VideoCompression == StatusVideoCompression)) {
                        driver.findElement(videoCompressionToggleImagePicker).click();
                    }
                }
                if (prop[0].equals("imgDirection")) {
                    driver.findElement(By.xpath("//mat-option[@value='" + prop[0] + "']")).click();
                }
            }
        }
    }

    public void editSelectDateFormatDropdownAndDateRanges(String values, String component) throws Throwable {
        Thread.sleep(3000);
        String[] Component = component.split(",");
        String[] value = values.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Range Picker")) {
                if (driver.findElements(selectDateFormatDropdown).size() > 0) {
                    driver.findElement(selectDateFormatDropdown).click();
                    if (driver.findElements(By.xpath("//mat-option[@role='option']/span[text()='" + value[3] + "']")).size() > 0) {
                        driver.findElement(By.xpath("//mat-option[@role='option']/span[text()='" + value[3] + "']")).click();
                    }
                }
                if (driver.findElements(minDateRangeRangePicker).size() > 0) {
                    driver.findElement(minDateRangeRangePicker).sendKeys(value[4]);
                }
                if (driver.findElements(maxDateRangeRangePicker).size() > 0) {
                    driver.findElement(maxDateRangeRangePicker).sendKeys(value[5]);
                }
            }
        }
    }

    public void editMaxSizeTextfield(String values, String component) throws Throwable {
        Thread.sleep(3000);
        String[] value = values.split(",");
        if (driver.findElements(maxSizeTextField).size() > 0) {
            driver.findElement(maxSizeTextField).clear();
            String[] Component = component.split(",");
            for (int c = 0; c <= Component.length - 1; c++) {
                if (Component[c].equals("File Picker")) {
                    driver.findElement(maxSizeTextField).sendKeys(value[4]);
                    Thread.sleep(2000);
                    String message = driver.findElement(maxSizeTextField).getAttribute("value");
                    Assert.assertEquals(value[4], message, "Expected Error Message " + value[4] + " But Found : " + message);
                }
                if (Component[c].equals("Image Picker")) {
                    driver.findElement(maxSizeTextField).sendKeys(value[5]);
                    Thread.sleep(2000);
                    String message = driver.findElement(maxSizeTextField).getAttribute("value");
                    Assert.assertEquals(value[5], message, "Expected Error Message " + value[5] + " But Found : " + message);
                }

            }
        }

    }

    public void thicknessTextFieldSeparator(String values) throws Throwable {
        String[] value = values.split(",");
        Thread.sleep(1000);
        if (driver.findElements(thicknessSeparator).size() > 0) {
            driver.findElement(thicknessSeparator).clear();
            driver.findElement(thicknessSeparator).sendKeys(value[0]);
        }

    }

    public void editTogglesFilePicker(String values, String component) throws Throwable {
        Thread.sleep(3000);
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
        Thread.sleep(3000);
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


    public void editRadioButtonComponent(String values, String component) throws Throwable {
        Thread.sleep(3000);
        String[] Component = component.split(",");
        for (int c = 0; c <= Component.length - 1; c++) {
            if (Component[c].equals("Radio Button")) {
                if (driver.findElements(radioButtonComponent).size() > 0) {
                    driver.findElement(radioButtonComponent).click();
                    String[] value = values.split(",");
                    driver.findElement(radioButtonTitleTextField).clear();
                    driver.findElement(radioButtonTitleTextField).sendKeys(value[0]);
                    String[] radioLables = value[1].split("-");
                    for (int d = 2; d <= radioLables.length - 1; d++) {
                        String[] deleteIconsClick = radioLables[d].split("_");
                        int countLables = radioLables.length - 1;
                        if (countLables > 1) {
                            for (int i = 2; i <= countLables; i++) {
                                driver.findElement(radioButtonAddValue).click();
                                driver.findElements(radioButtonValuesTextField).get(i).sendKeys("value");
                            }
                        }
                        for (int j = 1; j <= deleteIconsClick.length - 1; j = j + 2) {
                            boolean clickDeleteIcon = Boolean.parseBoolean(deleteIconsClick[j]);
                            for (int i = 0; i <= radioLables.length - 1; i++) {
                                if (i == 0 || i == 1) {
                                    Thread.sleep(1000);
                                    driver.findElements(radioButtonValuesTextField).get(i).clear();
                                    driver.findElements(radioButtonValuesTextField).get(i).sendKeys(radioLables[i]);
                                } else {
                                    for (int Del = 0; Del <= deleteIconsClick.length - 1; Del = Del + 2) {
                                        Thread.sleep(1000);
                                        driver.findElements(radioButtonValuesTextField).get(i).clear();
                                        driver.findElements(radioButtonValuesTextField).get(i).sendKeys(deleteIconsClick[Del]);
                                    }
                                }
                                if (!(clickDeleteIcon) && i >= 2) {
                                    driver.findElement(radioButtonDeleteValues).click();
                                }
                            }


                        }
                    }
                }
            }
        }
    }


    public void clickOnUpdateComponentButton() throws Throwable {
//        boolean disabled = Boolean.parseBoolean(driver.findElement(updateComponentButton).getAttribute("disabled"));
//        if (!disabled) {
        Thread.sleep(3000);
        driver.findElement(updateComponentButton).click();
//        }
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






