package com.orevan.steps.luma;

import com.orevan.pages.luma.LumaBasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by tolaf on 25/07/2016.
 */
public class BasePageSteps {

    LumaBasePage lumaBasePage;

    @When("^User Trigger Top Level Entry \"([^\"]*)\"$")
    public void userTriggerTopLevelEntry(String tcat) throws Throwable {
        lumaBasePage.clickTopCat(tcat);
        //lumaBasePage.clickIndexTopCat(tcat);
        //lumaBasePage.clickFacadeTopCat(tcat);
    }

    @Then("^Page \"([^\"]*)\" Header and Footer Elements are Interactive$")
    public void pageHeaderAndFooterElementsAreInteractive(String bpage) throws Throwable {
        lumaBasePage.verifyBasePage(bpage);
        lumaBasePage.verifyHeader();
        lumaBasePage.verifyFooter();
    }

    @And("^Complete LHS and Promo Module is Visible$")
    public void lhsAndPromoModuleIsVisible() throws Throwable {
        lumaBasePage.vpLHS();
        Assert.assertTrue((lumaBasePage.countLHSHeading()) >= 1);
        Assert.assertTrue((lumaBasePage.countLHSHeading()) <= 3);
        Assert.assertTrue((lumaBasePage.countLHSItems()) >= 3);
        Assert.assertTrue((lumaBasePage.countLHSItems()) <= 13);
        lumaBasePage.vpPromo();
        Assert.assertTrue((lumaBasePage.countPromoNodes()) >= 3);
        Assert.assertTrue((lumaBasePage.countPromoNodes()) <= 7);
    }

    @And("^Product List is Displayed with \"([^\"]*)\"$")
    public void productListIsDisplayedWith(String eproduct) throws Throwable {
        lumaBasePage.verifyProductEspot(eproduct);
        Assert.assertTrue((lumaBasePage.countProductNodes()) <= 4);
        Assert.assertTrue(lumaBasePage.espotProducts(eproduct).equals(eproduct));
    }


    @And("^Single LHS and Promo Module is Visible$")
    public void promoModuleIsVisible() throws Throwable {
        lumaBasePage.vpSingleLHS();
        lumaBasePage.vpPromo();
        Assert.assertTrue((lumaBasePage.countPromoNodes()) >= 3);
        Assert.assertTrue((lumaBasePage.countPromoNodes()) <= 7);
    }

    @And("^Empty LHS and Promo Module is Visible$")
    public void gearLHSAndPromoModuleIsVisible() throws Throwable {
        lumaBasePage.vpEmptyLHS();
        Assert.assertTrue((lumaBasePage.countLHSHeading()) >= 1);
        Assert.assertTrue((lumaBasePage.countLHSHeading()) <= 3);
        Assert.assertTrue((lumaBasePage.countLHSItems()) >= 3);
        Assert.assertTrue((lumaBasePage.countLHSItems()) <= 13);
        lumaBasePage.vpPromo();
        Assert.assertTrue((lumaBasePage.countPromoNodes()) >= 3);
        Assert.assertTrue((lumaBasePage.countPromoNodes()) <= 7);
    }
}