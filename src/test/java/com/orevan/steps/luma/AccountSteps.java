package com.orevan.steps.luma;


import com.orevan.pages.luma.LumaAccountPage;
import com.orevan.pages.luma.LumaBasePage;
import com.orevan.pages.luma.LumaCatPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by tolaf on 29/07/2016.
 */
public class AccountSteps {

    LumaAccountPage lumaAccountPage;

    LumaBasePage lumaBasePage;

    LumaCatPage lumaCatPage;

    @And("^My Dashboard for Registered User \"([^\"]*)\" and \"([^\"]*)\" is Displayed$")
    public void myDashboardForRegisteredUserAndIsDisplayed(String ruser, String rusername) throws Throwable {
        lumaBasePage.verifyHeader();
        lumaBasePage.verifyFooter();
        lumaAccountPage.myAccountDashboard(ruser);
        lumaAccountPage.vpAccountDashboard(ruser, rusername);
        Assert.assertTrue((lumaAccountPage.countDashboardOrdersTable()) >=2);
        Assert.assertTrue((lumaAccountPage.countDashboardOrdersTable()) <=5);
    }

    @When("^User Trigger My Account \"([^\"]*)\" Tab$")
    public void userTriggerMyAccountTab(String acctab) throws Throwable {
        lumaAccountPage.navigateAccountTab(acctab);
    }

    @Then("^Account Information for Registered User \"([^\"]*)\" is Displayed$")
    public void accountInformationForRegisteredUserIsDisplayed(String rusername) throws Throwable {
        lumaAccountPage.vpAccountInformation();
        Assert.assertTrue(lumaAccountPage.accountInformationEmail(rusername).equals(rusername));
    }

    @Then("^Address Book for Registered User \"([^\"]*)\" is Displayed$")
    public void addressBookForRegisteredUserIsDisplayed(String ruser) throws Throwable {
        lumaAccountPage.vpAddressBook(ruser);
    }

    @Then("^Downloadable Products \"([^\"]*)\" is Displayed$")
    public void downloadableProductsIsDisplayed(String vproduct) throws Throwable {
        Assert.assertTrue((lumaAccountPage.countDownloadableProducts()) >=2);
        Assert.assertTrue((lumaAccountPage.countDownloadableProducts()) <=3);
        lumaAccountPage.vpMyDownloadableProducts(vproduct);
    }

    @Then("^Orders for Registered User \"([^\"]*)\" is Displayed$")
    public void ordersForRegisteredUserIsDisplayed(String ruser) throws Throwable {
        Assert.assertTrue((lumaAccountPage.countMyOrdersTable()) >=2);
        Assert.assertTrue((lumaAccountPage.countMyOrdersTable()) <=5);
        lumaAccountPage.vpMyOrders(ruser);
    }

    @Then("^Newsletter Subscriptions is Displayed$")
    public void newsletterSubscriptionsIsDisplayed() throws Throwable {
        lumaAccountPage.vpNewsletterSubscriptions();
    }

    @Then("^Billing Agreements is Displayed$")
    public void billingAgreementsIsDisplayed() throws Throwable {
        lumaAccountPage.vpBillingAgreements();
    }

    @Then("^My Product Reviews is Displayed$")
    public void myProductReviewsIsDisplayed() throws Throwable {
        lumaAccountPage.vpMyProductReviews();
    }

    @Then("^My Wish List \"([^\"]*)\" is Displayed$")
    public void myWishListIsDisplayed(String wproduct) throws Throwable {
        lumaAccountPage.vpMyWishList(wproduct);
        Assert.assertTrue((lumaAccountPage.countWishList()) >=1);
        Assert.assertTrue((lumaAccountPage.countWishList()) <=6);
    }
}