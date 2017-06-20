package com.orevan.steps.luma;

import com.orevan.pages.luma.LumaBasePage;
import com.orevan.pages.luma.LumaCatPage;
import com.orevan.pages.luma.LumaPDPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * Created by tolaf on 17/08/2016.
 */
public class CartSteps {

    @Steps
    LumaCatPage lumaCatPage;

    @Steps
    LumaBasePage lumaBasePage;

    @Steps
    LumaPDPage lumaPDPage;

    @And("^User Add One of Listed Products \"([^\"]*)\" to Cart$")
    public void userAddOneOfListedProductsToCart(String aproduct) throws Throwable {
        lumaCatPage.addListedProductToCart(aproduct);
        lumaCatPage.waitForAngularRequestsToFinish();
    }

    @Then("^Product \"([^\"]*)\" is added to Cart$")
    public void productIsAddedToCart(String aproduct) throws Throwable {
        lumaCatPage.waitForAllTextToAppear(aproduct);
        Assert.assertTrue(lumaCatPage.successMessage().contains("You added"));
        Assert.assertTrue(lumaCatPage.successMessage().contains("to your shopping cart."));
        Assert.assertTrue(lumaCatPage.successMessage().contains(aproduct));

    }

    @And("^User Add PDP Product \"([^\"]*)\" to Cart$")
    public void userAddPDPProductToCart(String sproduct) throws Throwable {
        lumaCatPage.addPDProductToCart(sproduct);
    }

    @And("^User Select Random Swatch Options$")
    public void userSelectRandomSwatchOptions() throws Throwable {
        lumaPDPage.clickColorSwatchIndex(1);
        lumaPDPage.clickSizeSwatchIndex(1);
    }
}