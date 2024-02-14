package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.AddPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class AddPageSD {
    AddPage addPage = new AddPage(WebdriverInitializer.getDriver());

    public AddPageSD() throws Throwable {
    }

    @And("Verify Pages Module When Application Is opened {string}")
    public void VerifyPagesModuleWhenApplicationIsOpened(String pages) throws Throwable {
        addPage.verifyPagesModule(pages);
    }


    @And("Verify {string}")
    public void verifyDefault_pages(String default_pages)throws Throwable {
        addPage.verifyDefaultPages(default_pages);

    }

    @And("Add Page to The Application {string} {string} {string} {string} {string}")
    public void addPageToTheApplicationPage_name(String page_name, String error_message, String entity_name, String entity_error_message,String edit_entity_name) throws Throwable {
        addPage.addPageToApplication(page_name,error_message,entity_name,entity_error_message,edit_entity_name);

    }

    @And("verify added page {string}")
    public void verifyAddedPage(String page_name) throws Throwable {
        addPage.checkAddedPage(page_name);
    }

    @And("Edit added Page {string} {string} {string} {string} {string} {string}")
    public void editAddedPage(String edit_page_name, String page_name, String error_message, String entity_name, String entity_error_message, String edit_entity_name) throws Throwable {
        addPage.editAddedPage(edit_page_name,page_name,error_message,entity_name,entity_error_message,edit_entity_name);
    }

    @Then("Delete Added page {string} {string}")
    public void deleteAddedPageEdit_page_nameError_page_delete(String edit_page_name,String error_page_delete)throws Throwable {
        addPage.deletePage(edit_page_name,error_page_delete);
    }
}
