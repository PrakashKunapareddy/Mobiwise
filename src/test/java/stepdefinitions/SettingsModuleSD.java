package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.SettingsModule;
import io.cucumber.java.en.And;

public class SettingsModuleSD {
    SettingsModule settingsModule = new SettingsModule(WebdriverInitializer.getDriver());
    @And("Clicked on the {string}")
    public void clickedOnTheProject(String project) throws Throwable {
        settingsModule.clickOnProject(project);
    }


    @And("Click On the {string} and Click on the Settings Module")
    public void clickOnTheMobile_appAndClickOnTheSettingsModule(String mobile_app) throws Throwable {
        settingsModule.clickOnMobileAppAndClickOnSettingsModule(mobile_app);
    }

    @And("Verify {string} and Click on the Edit Button")
    public void verifyMobile_appAndClickOnTheEditButton(String mobile_app) throws Throwable {
        settingsModule.verifyMobileAppAndClickOnEditButton(mobile_app);
    }

    @And("Enter {string} and {string} and Validate Description Count And Edit Logo")
    public void enterNew_mobile_nameAndDescriptionAndValidateDescriptionCountAndEditLogo(String new_mobile_name,String description) throws Throwable {
        settingsModule.editFields(new_mobile_name,description);
    }

    @And("Click On Save Changes Button And Verify BreadCrumb and Mobile App Name And Heading {string}")
    public void clickOnSaveChangesButtonAndVerifyBreadCrumbAndMobileAppNameAndHeadingNew_mobile_name(String new_mobile_name) throws Throwable {
        settingsModule.verifyChangedName(new_mobile_name);
    }
}
