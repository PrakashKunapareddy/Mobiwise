package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.CreateMobApplicationWebAppliation;
import com.vassarlabs.projectname.page.MobileAppBuilderPagesAddComponents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MobileAppBuilderPagesAddComponentSD {
    MobileAppBuilderPagesAddComponents mobileAppBuilderPagesAddComponents = new MobileAppBuilderPagesAddComponents(WebdriverInitializer.getDriver());
    @And("Click on the Mobile Application")
    public void clickedOnTheMobileApplication(){
        mobileAppBuilderPagesAddComponents.clickOnTheMobileWidget();
    }

    @And("Click on the Pages Module, Click on the Landing Page and click on the Add Component Button")
    public void clickOnThePagesModuleClickOnTheLandingPageAndClickOnTheAddComponentButton() {

    }


    @And("Click on the {string} and drag the {string} to the screen builder")
    public void clickOnTheComponents_panelAndDragTheComponentToTheScreenBuilder() {
    }

    @Then("Verify the {string} on the screen builder")
    public void verifyTheComponentOnTheScreenBuilder(String component) {

    }
}

