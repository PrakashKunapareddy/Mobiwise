package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.CreateMobApplicationWebAppliation;
import com.vassarlabs.projectname.page.MobileAppBuilderPagesAddComponents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;



public class MobileAppBuilderPagesAddComponentSD {
    MobileAppBuilderPagesAddComponents mobileAppBuilderPagesAddComponents = new MobileAppBuilderPagesAddComponents(WebdriverInitializer.getDriver());



    @And("Click on the Pages Module, Click on the Landing Page and click on the Add Component Button")
    public void clickOnThePagesModuleClickOnTheLandingPageAndClickOnTheAddComponentButton() throws Throwable {
        mobileAppBuilderPagesAddComponents.clickOnLandingPageAndClickOnAddComponentsButton();

    }


    @And("Click on the {string} and drag the {string} to the screen builder")
    public void clickOnTheComponents_panelAndDragTheComponentToTheScreenBuilder(String components_panel, String component) {
        mobileAppBuilderPagesAddComponents.addComponentToScreenBuilder(components_panel, component);
    }

    @Then("Verify the {string} on the screen builder")
    public void verifyTheComponentOnTheScreenBuilder(String component) throws InterruptedException {
        mobileAppBuilderPagesAddComponents.verifyAddedComponent(component);
    }

    @And("Enter {string} {string} {string} and Click next {string} {string} {string} {string} and Click on Next")
    public void enterApp_nameApplication_name_field_messageApp_descAndClickNextThemes_dropdownHeadings_dropdownBody_dropdownSuggestion_messageAndClickOnNext(String app_name, String application_name_field_message, String app_desc,String themes_dropdown, String headings_dropdown,String body_dropdown,String suggestion_message) throws Throwable {
        mobileAppBuilderPagesAddComponents.addRandomProjects(app_name,application_name_field_message,app_desc, themes_dropdown,  headings_dropdown,  body_dropdown,  suggestion_message);

    }
}

