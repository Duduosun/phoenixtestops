package com.orevan.steps.luma;

import com.orevan.pages.luma.LumaAccountPage;
import com.orevan.pages.luma.LumaBasePage;
import com.orevan.pages.luma.LumaCatPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * Created by tolaf on 08/08/2016.
 */
public class CompareProductSteps {

    @Steps
    LumaBasePage lumaBasePage;

    @Steps
    LumaCatPage lumaCatPage;

    @Steps
    LumaAccountPage lumaAccountPage;

    @And("^User Compare One of Listed Products \"([^\"]*)\"$")
    public void userCompareOneOfListedProducts(String cproduct) throws Throwable {
        lumaCatPage.clickAddToCompareProduct(cproduct);
    }

    @Then("^Listed Product \"([^\"]*)\" is Added to Compare Products$")
    public void productIsAddedToCompareProducts(String cproduct) throws Throwable {
        Assert.assertTrue(lumaCatPage.comparedProductQTY().contains("item"));
        lumaCatPage.vpCompareListedProduct();
        Assert.assertTrue(lumaCatPage.compareSidebar().contains(cproduct));
        Assert.assertTrue(lumaCatPage.successMessage().contains(cproduct));
        Assert.assertTrue(lumaCatPage.successMessage().contains("You added product"));
        Assert.assertTrue(lumaCatPage.successMessage().contains("to the comparison list"));
    }

    @And("^User Compare PDP Product \"([^\"]*)\"$")
    public void userComparePDPProduct(String cproduct) throws Throwable {
        lumaCatPage.addPDProductToCompare(cproduct);
    }

    @Then("^PDP Product \"([^\"]*)\" is Added to Compare Products$")
    public void pdpProductIsAddedToCompareProducts(String cproduct) throws Throwable {
        Assert.assertTrue(lumaCatPage.comparedProductQTY().contains("item"));
        lumaCatPage.vpComparePDProduct();
        Assert.assertTrue(lumaCatPage.successMessage().contains(cproduct));
        Assert.assertTrue(lumaCatPage.successMessage().contains("You added product"));
        Assert.assertTrue(lumaCatPage.successMessage().contains("to the comparison list"));
    }

    @Then("^Products \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" are Displayed on Compare Product Module$")
    public void productsAreDisplayedOnCompareProductModule(String aproduct, String bproduct, String cproduct, String dproduct) throws Throwable {
        Assert.assertTrue(lumaCatPage.comparedProductQTY().contains("4 items"));
        lumaCatPage.vpCompareListedProduct();
        Assert.assertTrue(lumaCatPage.compareSidebar().contains(aproduct));
        Assert.assertTrue(lumaCatPage.compareSidebar().contains(bproduct));
        Assert.assertTrue(lumaCatPage.compareSidebar().contains(cproduct));
        Assert.assertTrue(lumaCatPage.compareSidebar().contains(dproduct));
        lumaCatPage.clickCompareHeader();
        lumaCatPage.waitForTitleToAppear("Products Comparison List - Magento Commerce");
        Assert.assertTrue(lumaCatPage.pageHeading().equals("Compare Products"));
        lumaCatPage.productComparison(aproduct, bproduct, cproduct, dproduct);
    }

    @When("^User Remove Compared Product \"([^\"]*)\" via Sidebar$")
    public void userRemoveComparedProductViaSidebar(String cproduct) throws Throwable {
        lumaCatPage.removeOneCompare(cproduct);
    }

    @Then("^Product \"([^\"]*)\" is not Visible in Compare Products$")
    public void productIsNotVisibleInCompareProducts(String cproduct) throws Throwable {
        lumaCatPage.waitForTitleToAppear("Products Comparison List - Magento Commerce");
        Assert.assertTrue(lumaCatPage.pageHeading().equals("Compare Products"));
        lumaCatPage.vpComparePDProduct();
        Assert.assertTrue(lumaCatPage.successMessage().contains(cproduct));
        Assert.assertTrue(lumaCatPage.successMessage().contains("You removed product"));
        Assert.assertTrue(lumaCatPage.successMessage().contains("from the comparison list"));
        Assert.assertFalse(lumaCatPage.comparedProducts().contains(cproduct));
    }

    @When("^User Trigger Compare Products CTA$")
    public void userTriggerCompareProductsCTA() throws Throwable {
        Assert.assertTrue(lumaCatPage.comparedProductQTY().contains("4 items"));
        lumaCatPage.clickCompareHeader();
    }

    @Then("^Compare Product Module is Displayed$")
    public void compareProductModuleIsDisplayed() throws Throwable {
        lumaCatPage.waitForTitleToAppear("Products Comparison List - Magento Commerce");
        Assert.assertTrue(lumaCatPage.pageHeading().equals("Compare Products"));
        lumaCatPage.vpComparePDProduct();
    }
    @When("^User Remove Compared Products via Compare Products Page$")
    public void userRemoveComparedProductsViaCompareProductsPage() throws Throwable {
        lumaCatPage.removeComparisonOneByOne();
        lumaCatPage.removeComparisonOneByOne();
        lumaCatPage.removeComparisonOneByOne();
        lumaCatPage.removeComparisonOneByOne();
    }

    @When("^User Remove all Compared Product$")
    public void userRemoveAllComparedProduct() throws Throwable {
        lumaCatPage.removeAllCompare();
    }

    @Then("^All Compared Products are not Visible in Compare Products$")
    public void allComparedProductsAreNotVisibleInCompareProducts() throws Throwable {
        Assert.assertTrue(lumaCatPage.successMessage().contains("You removed product"));
        Assert.assertTrue(lumaCatPage.successMessage().contains("from the comparison list"));
        lumaAccountPage.emptyComparisonPage();
    }

    @Then("^Compare Product Module is Cleared$")
    public void compareProductModuleIsCleared() throws Throwable {
        lumaAccountPage.myAccountPage();
        Assert.assertTrue(lumaCatPage.successMessage().contains("You cleared the comparison list"));
        lumaCatPage.waitForTitleToAppear("My Account");
        Assert.assertTrue(lumaCatPage.pageHeading().equals("My Dashboard"));
    }

    @And("^Luma Module for Guest remain available$")
    public void lumaModuleForGuestRemainAvailable() throws Throwable {
        lumaCatPage.clickCompareHeader();
        lumaCatPage.removeComparisonOneByOne();
        Assert.assertTrue(lumaBasePage.guestUser().contains("Sign In"));
        lumaBasePage.currentUserMode("Create an Account");
    }
}