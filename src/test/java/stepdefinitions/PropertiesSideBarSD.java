package stepdefinitions;

import com.vassarlabs.MobileWise.driver.WebdriverInitializer;
import com.vassarlabs.MobileWise.page.MobileAppBuilderPagesAddComponents;
import com.vassarlabs.MobileWise.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PropertiesSideBarSD {
    PropertiesSideBar propertiesSidebar = new PropertiesSideBar(WebdriverInitializer.getDriver());

    public PropertiesSideBarSD() throws Throwable {
    }

    @And("Verify {string} sidebar and Validate Back button Functionality")
    public void verifyComponentSidebarAndValidateBackButtonFunctionality(String component) throws Throwable {
        propertiesSidebar.verifyComponentSidebarofComponent(component);
        propertiesSidebar.validateBackButtonFucntionality();
    }

    @And("Verify Panels in the Properties side bar {string}")
    public void verifyPanelsInThePropertiesSideBarPanels(String panels) throws Throwable {
        propertiesSidebar.panelsInTheComponentSideBar(panels);
    }



    @And("Edit {string} Of the components in different panels and click on Update Component Button {string} {string} {string}")
    public void editPropertiesOfTheComponentsInDifferentPanelsAndClickOnUpdateComponentButton(String properties, String panels, String values_comp, String component) throws Throwable {
        propertiesSidebar.editPropertiesOfComponent(properties, panels, values_comp, component);
        propertiesSidebar.clickOnUpdateComponentButton();
    }


}
