package com.orevan.steps.luma;

import com.orevan.pages.luma.LumaBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * Created by tolaf on 23/07/2016.
 */
public class LumaHomePageSteps {

    @Steps
    LumaBasePage lumaBasePage;

    @When("^User Interact with Luma Website$")
    public void userInteractWithLumaWebsite() throws Throwable {
        lumaBasePage.verifyHeader();
        lumaBasePage.verifyHomePageBody();
        lumaBasePage.verifyFooter();
    }

    @Then("^Luma Module for Guest \"([^\"]*)\" is available$")
    public void lumaModuleForGuestIsAvailable(String guser) throws Throwable {
        Assert.assertTrue(lumaBasePage.guestUser().contains(guser));
        lumaBasePage.currentUserMode(guser);
    }

    @But("^Luma Modules for Registered \"([^\"]*)\" is not available$")
    public void lumaModulesForRegisteredIsNotAvailable(String ruser) throws Throwable {
        Assert.assertFalse(lumaBasePage.guestUser().contains(ruser));
        lumaBasePage.currentUserMode(ruser);
    }

    @And("^Luma Recovery Scenario$")
    public void lumaRecoveryScenario() throws Throwable {
        //lumaBasePage.goHome();
        lumaBasePage.waitForAngularRequestsToFinish();
        Assert.assertTrue(lumaBasePage.guestUser().contains("Sign In"));
        lumaBasePage.currentUserMode("Create an Account");
    }
}
