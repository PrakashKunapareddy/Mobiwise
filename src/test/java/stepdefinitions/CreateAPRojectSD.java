package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.CreateAProject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateAPRojectSD {
    CreateAProject createAProject = new CreateAProject(WebdriverInitializer.getDriver());

    public CreateAPRojectSD() throws Throwable {
    }


    @And("Click on the Pages Module, Click on the desired {string} and click on the Add Component Button {string} {string} {string} {string} {string} {string} {string}")
    public void clickOnThePagesModuleClickOnTheDesiredWork_pageAndClickOnTheAddComponentButtonComponent_panelComponentPropertiesPanelsValues_compPage_nameEntity_name(String work_page, String component_panel, String component, String properties, String panels, String values_comp, String page_name, String entity_name) throws Throwable {
        createAProject.clickOnWorkPages(work_page, component_panel, component, properties, panels, values_comp, page_name, entity_name);
//        createAProject.clickOnPublishButton();
    }

    @Then("Verify Components In Preview page {string} {string}")
    public void verifyComponentsInPreviewPage(String entity_name,String input_components) throws Throwable {
        createAProject.verifyComponentsInPreviewPage(entity_name,input_components);
    }
}

