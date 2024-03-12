package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.CreateProject;
import com.vassarlabs.MobileWise.page.DataListDummy;
import com.vassarlabs.MobileWise.page.LoginPage;
import io.cucumber.java.en.And;

public class dummy {
    DataListDummy dummy = new DataListDummy(WebdriverInitializer.getDriver());


    public dummy() throws Throwable {
    }

    @And("Click on the Mobile Application and Click On Page panel")
    public void clickOnTheMobileApplicationAndClickOnPagePanel() throws InterruptedException {
        dummy.clickonmobileappandpage();
    }


    @And("Click on the data List and edit properties {string}")
    public void clickOnTheDataListAndEditPropertiesValues_comp(String values_comp) throws Throwable {
        dummy.clickonthemobilebuilderandeditproperties(values_comp);
    }


}


