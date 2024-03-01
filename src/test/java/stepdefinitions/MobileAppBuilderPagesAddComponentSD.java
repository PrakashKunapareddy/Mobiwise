package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.MobileAppBuilderPagesAddComponents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class MobileAppBuilderPagesAddComponentSD {
    MobileAppBuilderPagesAddComponents mobileAppBuilderPagesAddComponents = new MobileAppBuilderPagesAddComponents(WebdriverInitializer.getDriver());

    public MobileAppBuilderPagesAddComponentSD() throws Throwable {
    }


    @And("Click on the Pages Module, Click on the {string} and click on the Add Component Button")
    public void clickOnThePagesModuleClickOnTheWork_pageAndClickOnTheAddComponentButton(String work_pages) throws Throwable {
        mobileAppBuilderPagesAddComponents.clickOnLandingPageAndClickOnAddComponentsButton(work_pages);
    }


    @And("Click on the {string} and drag the {string} to the screen builder {string} {string}")
    public void clickOnTheComponents_panelAndDragTheComponentToTheScreenBuilder(String component_panel, String component, String offset_value_x,String offset_value_y) throws Throwable {
        mobileAppBuilderPagesAddComponents.addComponentToScreenBuilder(component_panel, component,offset_value_x,offset_value_y);
    }

    @Then("Verify the {string} on the screen builder")
    public void verifyTheComponentOnTheScreenBuilder(String component) throws InterruptedException {
        mobileAppBuilderPagesAddComponents.verifyAddedComponent(component);
    }

    @And("Enter {string} {string} {string} and Click next {string} {string} {string} {string} and Click on Next")
    public void enterApp_nameApplication_name_field_messageApp_descAndClickNextThemes_dropdownHeadings_dropdownBody_dropdownSuggestion_messageAndClickOnNext(String app_name, String application_name_field_message, String app_desc, String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message) throws Throwable {
        mobileAppBuilderPagesAddComponents.addRandomProjects(app_name, application_name_field_message, app_desc, themes_dropdown, headings_dropdown, body_dropdown, suggestion_message);

    }

    @Then("Delete The component from The Screen Builder {string}")
    public void deleteTheComponentFromTheScreenBuilder(String component) throws Throwable {
        mobileAppBuilderPagesAddComponents.deleteComponentFromTheScreenBuilder(component);
        mobileAppBuilderPagesAddComponents.deleteNavbarFromTheScreenBuilder(component);

    }


}

