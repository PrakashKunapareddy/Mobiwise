package stepdefinitions;

import com.vassarlabs.projectname.driver.WebdriverInitializer;
import com.vassarlabs.projectname.page.ThemesModule;
import com.vassarlabs.projectname.page.UserProfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

public class ThemesModuleSD {
    ThemesModule themesModule = new ThemesModule(WebdriverInitializer.getDriver());

    public ThemesModuleSD() throws Throwable {
    }


    @And("Verify BreadCrumb {string}")
    public void verifyBreadCrumb(String expected_output) throws Throwable {
        themesModule.verifyBreadcrumb(expected_output);
    }

    @And("Click on the Themes Module")
    public void clickOnTheThemesModule() throws Throwable {
        themesModule.clickOnThemesModule();
    }


    @And("Verify Themes {string} and Click on Apply Button and Reset Button {string}")
    public void verifyThemesThemes_changeAndClickOnApplyButtonAndResetButton(String themes_change, String toaster_message_themes_apply)throws Throwable {
        themesModule.selectTheme(themes_change,toaster_message_themes_apply);
    }
}
