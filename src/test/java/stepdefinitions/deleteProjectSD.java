package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.DeleteProjects;
import io.cucumber.java.en.And;

public class deleteProjectSD {
    DeleteProjects delete = new DeleteProjects(WebdriverInitializer.getDriver());
    @And("Delete the {string}")
    public void deleteTheProject(String project) throws InterruptedException {
        delete.deleteProjects(project);
    }
}
