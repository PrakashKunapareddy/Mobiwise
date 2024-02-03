package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.CreateMobApplicationWebAppliation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class CreateMobAppWebAppSteps {


    CreateMobApplicationWebAppliation createMobAppWebApp = new CreateMobApplicationWebAppliation(WebdriverInitializer.getDriver());

    public CreateMobAppWebAppSteps() throws AWTException {
    }


    @And("Clicked on the Project")
    public void clickedOnTheProject() throws Throwable {
        createMobAppWebApp.clickProjectMatButton();
    }


    @And("Click on the {string}")
    public void clickOnTheApplication_type(String application_type) throws InterruptedException {
        createMobAppWebApp.clickApplicationType(application_type);
    }

    @And("Enter {string} {string} {string} Upload Logo and Click on Next")
    public void enterApp_nameApp_descUploadLogoAndClickOnNext(String app_name, String application_name_field_message, String app_desc) throws InterruptedException {
        createMobAppWebApp.updateNameFields(app_name, application_name_field_message, app_desc);
        createMobAppWebApp.clickNextToThemes();
    }

    @Then("Validate Application Created {string} {string}")
    public void validateApplicationCreatedToaster_message(String toaster_message, String app_name) throws Throwable {
        createMobAppWebApp.validateToasterMessage(toaster_message, app_name);

    }

    @And("Update {string} {string} {string} {string} and Click on Next {string}")
    public void updateThemes_dropdownHeadings_dropdownBody_dropdownAndClickOnNext(String themes_dropdown, String headings_dropdown, String body_dropdown, String suggestion_message, String all_themes ) throws Throwable {
        createMobAppWebApp.updateThemeAndClickNext(themes_dropdown, headings_dropdown, body_dropdown, suggestion_message,all_themes);
        createMobAppWebApp.clickNextforBranding();
    }

    @And("Click on Breadcrumb {string}")
    public void clickOnBreadcrumb(String homepage_validation_text) throws Throwable {
        createMobAppWebApp.clickHomeOnBreadcrumb(homepage_validation_text);
        createMobAppWebApp.clickApplicationPageBreadcrumb();
    }

    @And("Create A Project")
    public void createAProject() throws Throwable {
        createMobAppWebApp.createRandomProjects();
    }
}

