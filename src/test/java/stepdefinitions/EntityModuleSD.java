package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.EntityModule;
import io.cucumber.java.en.And;

public class EntityModuleSD {
    EntityModule entityModule = new EntityModule(WebdriverInitializer.getDriver());

    public EntityModuleSD() throws Throwable {
    }

    @And("Click on the Mobile Application and Click On Entity Module Click on Add Entity button")
    public void clickOnTheMobileApplicationAndClickOnEntityModuleClickOnAddEntityButton() throws Throwable{
        entityModule.clickOnEntityModule();
        entityModule.clickOnAddEntityButton();
    }

    @And("Enter an {string} and add {string}")
    public void enterAnEntity_nameAndAddMapped_pages(String entity_names,String mapped_pages) throws Throwable {
        entityModule.validateAddEntityPopUp(entity_names);
        entityModule.validateMappedpagesPanel(entity_names,mapped_pages);
    }

    @And("Add {string} to the {string}")
    public void addRelated_entityToTheEntity_name(String related_entity,String entity_names) throws Throwable {
        entityModule.validateRelatedEntityPanel(entity_names,related_entity);
    }

    @And("Edit {string} and delete Mapped pages {string}")
    public void editEntity_nameAndDeleteMappedPagesNew_entity_name(String entity_names , String new_entity_names) throws Throwable {
        entityModule.validateEditEntityPopUp(entity_names,new_entity_names);
    }
    @And("Click on Update Association Button {string}")
    public void clickOnUpdateAssociationButtonNew_entity_name(String new_entity_names) throws Throwable {
        entityModule.clickOnUpdateAssociationButton(new_entity_names);
    }

    @And("Delete Added Entity {string} {string}")
    public void deleteAddedEntityNew_entity_name(String new_entity_names,String entity_names) throws Throwable {
        entityModule.validateDeleteFucntionality(new_entity_names,entity_names);
    }


}
