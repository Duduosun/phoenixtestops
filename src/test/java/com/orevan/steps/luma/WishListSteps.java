package com.orevan.steps.luma;

import com.orevan.pages.luma.LumaAccountPage;
import com.orevan.pages.luma.LumaBasePage;
import com.orevan.pages.luma.LumaCatPage;
import com.orevan.pages.luma.LumaCustomerPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * Created by tolaf on 06/08/2016.
 */
public class WishListSteps {

    @Steps
    LumaCatPage lumaCatPage;

    @Steps
    LumaCustomerPage lumaCustomerPage;

    @Steps
    LumaBasePage lumaBasePage;

    @Steps
    LumaAccountPage lumaAccountPage;

    @When("^User Trigger Wish List Entry Point CTA$")
    public void userTriggerWishListEntryPointCTA() throws Throwable {
        Assert.assertTrue((lumaCatPage.countWishListNodes()) > 4);
        lumaCatPage.clickAddToWishList();
    }

    @Then("^Registered User Entry Point is Displayed$")
    public void registeredUserEntryPointIsDisplayed() throws Throwable {
        lumaCustomerPage.customerLoginPage();
        Assert.assertTrue(lumaBasePage.guestUser().contains("Default"));
        Assert.assertFalse(lumaBasePage.guestUser().contains("Duduosun"));
    }

    @And("^User Add One of Listed Products \"([^\"]*)\" to Wish List$")
    public void userAddProductToWishList(String wproduct) throws Throwable {
        lumaCatPage.clickAddToWishList(wproduct);
        Assert.assertTrue(lumaCatPage.successMessage().contains(wproduct));
        Assert.assertTrue(lumaCatPage.successMessage().contains("has been added to your Wish List"));
    }

    @And("^User Add PDP Product \"([^\"]*)\" to Wish List$")
    public void userAddPDPProductToWishList(String wproduct) throws Throwable {
        lumaCatPage.addPDProductToWishList(wproduct);
        Assert.assertTrue(lumaCatPage.successMessage().contains(wproduct));
        Assert.assertTrue(lumaCatPage.successMessage().contains("has been added to your Wish List"));
    }

    @When("^User Remove Product \"([^\"]*)\" from Sidebar Wish List$")
    public void userRemoveProductFromWishList(String wproduct) throws Throwable {
        lumaCatPage.removeProductFromWishList(wproduct);
        lumaCatPage.goToWishList();
    }

    @Then("^Product \"([^\"]*)\" is not Visible in My Wish List$")
    public void productIsNotVisibleInMyWishList(String wproduct) throws Throwable {
        Assert.assertFalse(lumaAccountPage.wishListProducts().contains(wproduct));
    }

    @When("^User Remove Product \"([^\"]*)\" from My Wish List Dasboard$")
    public void userRemoveProductMyWishListDasboard(String wproduct) throws Throwable {
        lumaAccountPage.removeProductFromMyWishList(wproduct);
    }
}
