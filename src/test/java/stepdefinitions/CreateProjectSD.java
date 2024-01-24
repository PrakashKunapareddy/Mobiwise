package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.CreateProject;
import com.vassarlabs.projectname.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectSD {

      CreateProject createProject = new CreateProject(WebdriverInitializer.getDriver());

    @When("Clicked on Create Project Button")
        public void clicked_on_create_project_button() {
                createProject.clickCreateProjectButton();
        }

    @And("Enter {string} {string}")
    public void enterProject_nameProject_description(String project_name, String project_description) {
        createProject.enterProjectnameProjectdescription(project_name,project_description);
    }

    @And("Clicked on save button")
    public void clickedOnSaveButton() {
        createProject.clickSaveButton();
    }

    @Then("Validate new project module")
    public void validateNewProjectModule() {

    }

    @Then("Edit Created Project {string} {string}")
    public void editCreatedProject(String new_project_name, String new_project_description){
        createProject.editProject(new_project_name,new_project_description);
    }
}
