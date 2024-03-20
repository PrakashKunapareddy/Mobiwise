package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.CreateAProject;
import com.vassarlabs.MobileWise.page.PublishModule;
import io.cucumber.java.en.And;

public class PublishModuleSD {
    PublishModule publishModule = new PublishModule(WebdriverInitializer.getDriver());
    CreateAProject createAProject = new CreateAProject(WebdriverInitializer.getDriver());

    public PublishModuleSD() throws Throwable {
    }

    @And("Click on the Mobile Application and Click On Page panel")
    public void clickOnTheMobileApplicationAndClickOnPagePanel() throws InterruptedException {
        publishModule.clickonmobileappandpage();
    }


    @And("Click on the data List and edit properties {string}")
    public void clickOnTheDataListAndEditPropertiesValues_comp(String values_comp) throws Throwable {
        publishModule.clickonthemobilebuilderandeditproperties(values_comp);
    }


    @And("Click on Publish Module and click on publish apk button")
    public void clickOnPublishModuleAndClickOnPublishApkButton() throws Throwable {
        createAProject.clickOnPublishButton();
    }

    @And("Click on pages Module and click on Landing Page And Add Component and delete the Component")
    public void clickOnPagesModuleAndClickOnLandingPageAndAddComponentAndDeleteTheComponent() throws Throwable {
        publishModule.clickOnThePagesModuleAndClickOnTheLandingPage();
    }


}


