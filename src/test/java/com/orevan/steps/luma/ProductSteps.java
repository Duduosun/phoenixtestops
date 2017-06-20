package com.orevan.steps.luma;

import com.orevan.pages.luma.LumaBasePage;
import com.orevan.pages.luma.LumaCatPage;
import com.orevan.pages.luma.LumaPDPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by tolaf on 26/07/2016.
 */
public class ProductSteps {

    LumaCatPage lumaCatPage;
    LumaBasePage lumaBasePage;
    LumaPDPage lumaPDPage;


    @When("^User Trigger Top Level \"([^\"]*)\" then Sub Category Level \"([^\"]*)\"$")
    public void userTriggerTopLevelThenSubCategoryLevel(String tcat, String scat) throws Throwable {
        lumaCatPage.clickSecondCat(tcat, scat);
    }

    @Then("^Simple Products \"([^\"]*)\" are Displayed in Grid View$")
    public void simpleProductsAreDisplayedInGridView(String sproduct) throws Throwable {
        Assert.assertTrue(lumaCatPage.countBreadcrumbs().equals(3));
        Assert.assertTrue((lumaCatPage.countProducts()) > 3);
        Assert.assertTrue((lumaCatPage.countProducts()) <= 9);
        lumaBasePage.vpPLPLHS();
        Assert.assertTrue((lumaCatPage.countFilterOptions()) >= 2);
        Assert.assertTrue((lumaCatPage.countFilterOptions()) <= 8);
        Assert.assertTrue(lumaCatPage.countToolbarNodes().equals(2));
        lumaCatPage.verifyPLPGridView();
        Assert.assertTrue(lumaCatPage.verifySimpleProduct(sproduct).equals(sproduct));
    }

    @Then("^Configurable Products \"([^\"]*)\" are Displayed in Grid View$")
    public void configurableProductsAreDisplayedInGridView(String cproduct) throws Throwable {
        Assert.assertTrue(lumaCatPage.countBreadcrumbs().equals(3));
        Assert.assertTrue((lumaCatPage.countProducts()) > 3);
        Assert.assertTrue((lumaCatPage.countProducts()) <= 9);
        lumaBasePage.vpPLPLHS();
        Assert.assertTrue((lumaCatPage.countFilterOptions()) >= 2);
        Assert.assertTrue((lumaCatPage.countFilterOptions()) <= 8);
        Assert.assertTrue(lumaCatPage.countToolbarNodes().equals(2));
        lumaCatPage.verifyPLPGridView();
        lumaCatPage.verifyConfigurableProduct(cproduct);
        Assert.assertTrue(lumaCatPage.verifyConfigurableProduct(cproduct).equals(cproduct));
    }

    @And("^User Click Switch View CTA$")
    public void userClickSwitchViewCTA() throws Throwable {
        lumaCatPage.switchToListView();
    }

    @Then("^Simple Products \"([^\"]*)\" are Displayed in List View$")
    public void simpleProductsAreDisplayedInListView(String sproduct) throws Throwable {
        Assert.assertTrue(lumaCatPage.countBreadcrumbs().equals(3));
        Assert.assertTrue((lumaCatPage.countProducts()) > 3);
        Assert.assertTrue((lumaCatPage.countProducts()) <= 10);
        lumaBasePage.vpPLPLHS();
        Assert.assertTrue((lumaCatPage.countFilterOptions()) >= 2);
        Assert.assertTrue((lumaCatPage.countFilterOptions()) <= 8);
        Assert.assertTrue(lumaCatPage.countToolbarNodes().equals(2));
        lumaCatPage.verifyPLPListView();
        Assert.assertTrue(lumaCatPage.verifySimpleProduct(sproduct).equals(sproduct));
    }

    @Then("^Configurable Products \"([^\"]*)\" are Displayed in List View$")
    public void configurableProductsAreDisplayedInListView(String cproduct) throws Throwable {
        Assert.assertTrue(lumaCatPage.countBreadcrumbs().equals(3));
        Assert.assertTrue((lumaCatPage.countProducts()) > 3);
        Assert.assertTrue((lumaCatPage.countProducts()) <= 10);
        lumaBasePage.vpPLPLHS();
        Assert.assertTrue((lumaCatPage.countFilterOptions()) >= 2);
        Assert.assertTrue((lumaCatPage.countFilterOptions()) <= 8);
        Assert.assertTrue(lumaCatPage.countToolbarNodes().equals(2));
        lumaCatPage.verifyPLPListView();
        Assert.assertTrue(lumaCatPage.verifyConfigurableProduct(cproduct).equals(cproduct));
    }

    @And("^User Click Simple Product \"([^\"]*)\"$")
    public void userClickSimpleProduct(String sproduct) throws Throwable {
        lumaCatPage.clickProduct(sproduct);
    }

    @Then("^PDP for Simple Product \"([^\"]*)\" is Displayed$")
    public void pdpForSimpleProductIsDisplayed(String sproduct) throws Throwable {
        lumaPDPage.verifyPDP(sproduct);
        Assert.assertTrue((lumaPDPage.countFotorama()) >= 1);
        Assert.assertTrue((lumaPDPage.countFotorama()) <= 4);
        Assert.assertTrue(lumaPDPage.simpleOrconfigurable().equals(false));
        Assert.assertFalse(lumaPDPage.simpleOrconfigurable().equals(true));
    }

    @And("^User Click Configurable Product \"([^\"]*)\"$")
    public void userClickConfigurableProduct(String cproduct) throws Throwable {
        lumaCatPage.clickProduct(cproduct);
    }

    @Then("^PDP for Configurable Product \"([^\"]*)\" is Displayed$")
    public void pdpForConfigurableProductIsDisplayed(String cproduct) throws Throwable {
        lumaPDPage.verifyPDP(cproduct);
        Assert.assertTrue((lumaPDPage.countFotorama()) >= 4);
        Assert.assertTrue((lumaPDPage.countFotorama()) <= 6);
        Assert.assertTrue(lumaPDPage.simpleOrconfigurable().equals(true));
        Assert.assertFalse(lumaPDPage.simpleOrconfigurable().equals(false));
    }

    @When("^User Search Luma with String \"([^\"]*)\"$")
    public void userSearchLumaWithString(String search) throws Throwable {
        lumaCatPage.searchProduct(search);
    }

    @Then("^Search Results for \"([^\"]*)\" are Displayed in Grid View$")
    public void searchResultsForAreDisplayedInGridView(String product) throws Throwable {
        lumaBasePage.verifyHeader();
        lumaBasePage.verifyFooter();
        Assert.assertTrue(lumaCatPage.countBreadcrumbs().equals(2));
        Assert.assertTrue((lumaCatPage.countProducts()) > 1);
        Assert.assertTrue((lumaCatPage.countProducts()) <= 10);
        lumaBasePage.vpPLPLHS();
        Assert.assertTrue(lumaCatPage.countToolbarNodes().equals(2));
        lumaCatPage.verifyPLPGridView();
        Assert.assertTrue(lumaCatPage.verifySimpleProduct(product).equals(product));
    }

    @Then("^Search Results for \"([^\"]*)\" are Displayed in List View$")
    public void searchResultsForAreDisplayedInListView(String product) throws Throwable {
        Assert.assertTrue(lumaCatPage.countBreadcrumbs().equals(2));
        Assert.assertTrue((lumaCatPage.countProducts()) > 1);
        Assert.assertTrue((lumaCatPage.countProducts()) <= 10);
        lumaBasePage.vpPLPLHS();
        Assert.assertTrue(lumaCatPage.countToolbarNodes().equals(2));
        lumaCatPage.verifyPLPListView();
        Assert.assertTrue(lumaCatPage.verifySimpleProduct(product).equals(product));
    }

    @Then("^Empty Search Result \"([^\"]*)\" is Displayed$")
    public void emptySearchResultIsDisplayed(String message) throws Throwable {
        lumaBasePage.verifyHeader();
        lumaBasePage.verifyFooter();
        Assert.assertTrue(lumaCatPage.countBreadcrumbs().equals(2));
        lumaBasePage.vpSingleLHS();
        lumaCatPage.emptyResultMessage(message);
    }
}