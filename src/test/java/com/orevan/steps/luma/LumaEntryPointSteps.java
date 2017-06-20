package com.orevan.steps.luma;

import com.orevan.pages.luma.LumaBasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by tolaf on 22/07/2016.
 */

public class LumaEntryPointSteps {

    @Steps
    LumaBasePage lumaBasePage;

    @Given("^Luma Home Page$")
    public void lumaHomePage() throws Throwable {
        lumaBasePage.goToLuma();
    }

    @When("^User Explores Home Page$")
    public void userExploresHomePage() throws Throwable {
        lumaBasePage.verifyHomeLogo();
    }

    @Then("^Header Elements are Interactive$")
    public void headerElementsAreInteractive() throws Throwable {
        lumaBasePage.verifyHeader();
    }

    @Then("^Footer Elements are Interactive$")
    public void footerElementsAreInteractive() throws Throwable {
        lumaBasePage.verifyFooter();
    }
}