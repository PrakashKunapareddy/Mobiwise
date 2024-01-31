package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.CreateProject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

public class CreateProjectSteps {

    CreateProject createProject = new CreateProject(WebdriverInitializer.getDriver());

    public CreateProjectSteps() throws AWTException {
    }

    @When("Clicked on Create Project Button")
    public void clicked_on_create_project_button() throws Throwable {
        createProject.clickCreateProjectButton();
        createProject.clickCancleButton();
        createProject.clickCreateProjectButton();
    }

    @And("Enter {string} {string} {string}")
    public void enterProject_nameProject_descriptionError_message(String project_name, String project_description, String error_message) throws Throwable {
        createProject.enterProjectnameProjectdescription(project_name, project_description, error_message);
    }

    @And("Clicked on save button or Enter in keyboard {string} {string}")
    public void clickedOnSaveButtonOrEnterInKeyboard(String project_name,String error_message) throws Throwable {
        createProject.clickSaveButton(project_name,error_message);
    }

    @Then("Validate new project module {string} {string}")
    public void validateNewProjectModule(String project_name, String error_message) throws Throwable {
        createProject.checkCreatedProject(project_name,error_message);
    }

    @Then("Edit Created Project name {string} {string} {string}")
    public void editCreatedProjectName(String project_name, String new_project_name,String error_message) throws Throwable {
        createProject.editProjectName(project_name, new_project_name,error_message);
    }


    @And("Save button should be in Disable mode by default")
    public void saveButtonShouldBeInDisableModeByDefault() {
        createProject.negitiveTestForSave();

    }

    @Then("Click on Delete Icon and Click on No button or ESC on Keyboard {string}")
    public void clickOnDeleteIconAndClickOnCancelButtonOrESCOnKeyboard(String new_project_name) {
        createProject.deleteProjectNo(new_project_name);
    }

    @And("Edit Created Project description {string} {string} {string} {string}")
    public void editCreatedProjectDescriptionProject_descriptionNew_project_description(String project_name, String new_project_name,String new_project_description,String error_message) throws Throwable {
        createProject.editProjectDescription(project_name,new_project_name, new_project_description,error_message);
    }

    @Then("Click on Delete Icon and Click on Yes button or ESC on Keyboard {string}")
    public void clickOnDeleteIconAndClickOnYesButtonOrESCOnKeyboardNew_project_name(String new_project_name) {
        createProject.deleteProjectYes(new_project_name);

    }
}

