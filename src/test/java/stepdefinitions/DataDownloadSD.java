package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.DataDownload;
import io.cucumber.java.en.And;

public class DataDownloadSD {
    DataDownload datadownload = new DataDownload(WebdriverInitializer.getDriver());
    @And("Click on the Mobile Application and Click On Data Download Module")
    public void clickOnTheMobileApplicationAndClickOnDataDownloadModule() throws Throwable {
        datadownload.clickOnMobileAppAndClickOnDataDownloadModule();
    }

    @And("Click On the Entity DropDown and Select {string}")
    public void clickOnTheEntityDropDownAndSelectEntity(String entity) throws Throwable {
        datadownload.clickOnEntityDropDownAndSelectAnEntity(entity);
    }

    @And("Click on the Submission DropDown and Select {string}")
    public void clickOnTheSubmissionDropDownAndSelectSubmission_type(String submission_type) throws Throwable {
        datadownload.clickOnTheSubmissionDropDownAndSelectMethod(submission_type);
    }

    @And("Click on the Download Data button {string}")
    public void clickOnTheDownloadDataButtonError_message(String error_message) throws Throwable {
        datadownload.clickOnDataDownloadButton(error_message);
    }


}
