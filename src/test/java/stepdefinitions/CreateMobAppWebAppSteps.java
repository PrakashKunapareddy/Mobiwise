package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.CreateMobApplicationWebAppliation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateMobAppWebAppSteps {


    CreateMobApplicationWebAppliation createMobAppWebApp = new CreateMobApplicationWebAppliation(WebdriverInitializer.getDriver());


    @And("Clicked on the Project")
    public void clickedOnTheProject() {
        createMobAppWebApp.clickProjectMatButton();
    }


    @And("Click on the {string}")
    public void clickOnTheApplication_type(String application_type){
        createMobAppWebApp.clickApplicationType(application_type);
    }

    @And("Enter {string} {string} Upload Logo and Click on Next")
    public void enterApp_nameApp_descUploadLogoAndClickOnNext(String app_name, String app_desc) {
        createMobAppWebApp.updateNameFields(app_name,app_desc);
        createMobAppWebApp.clickNextToThemes();
    }

    @Then("Validate Application Created {string}")
    public void validateApplicationCreatedToaster_message(String toaster_message, String app_name) {
        createMobAppWebApp.validateToasterMessage(toaster_message, app_name);

    }

    @And("Update {string} {string} {string} {string} and Click on Next")
    public void updateThemes_dropdownHeadings_dropdownBody_dropdownAndClickOnNext(String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message) throws Throwable {
        createMobAppWebApp.updateThemeAndClickNext(themes_dropdown,headings_dropdown,body_dropdown,suggestion_message);
    }
}

