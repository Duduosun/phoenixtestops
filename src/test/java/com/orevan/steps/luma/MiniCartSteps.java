package com.orevan.steps.luma;

import com.orevan.pages.luma.LumaMiniCartPage;
import com.orevan.pages.luma.LumaPDPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * Created by tolaf on 20/08/2016.
 */
public class MiniCartSteps {

    @Steps
    LumaMiniCartPage lumaMiniCartPage;

    @Steps
    LumaPDPage lumaPDPage;

    @When("^User Trigger Mini Cart$")
    public void userTriggerMiniCart() throws Throwable {
        lumaMiniCartPage.openMiniCart();

    }

    @Then("^Mini Cart remain Open$")
    public void miniCartRemainOpen() throws Throwable {
        lumaMiniCartPage.emptyMiniCart();
    }

    @When("^User Close Mini Cart$")
    public void userCloseMiniCart() throws Throwable {
        lumaMiniCartPage.closeMiniCart();
    }

    @Then("^Mini Cart is Closed$")
    public void miniCartIsClosed() throws Throwable {
        lumaMiniCartPage.noMiniCart();
    }

    @Then("^Product \"([^\"]*)\" is Visible in Mini Cart$")
    public void productIsVisibleInMiniCart(String aproduct) throws Throwable {
        Assert.assertTrue(lumaMiniCartPage.miniCartProducts().contains(aproduct));
    }

    @And("^Remove Product \"([^\"]*)\" in Mini Cart$")
    public void removeProductInMiniCart(String aproduct) throws Throwable {
        lumaMiniCartPage.removeProduct();
    }

    @Then("^Mini Cart is Empty$")
    public void miniCartIsEmpty() throws Throwable {
        lumaMiniCartPage.emptyMiniCart();
    }

    @And("^Update Product Quantity with \"([^\"]*)\"$")
    public void updateProductQuantityWith(Integer cqty) throws Throwable {
        lumaMiniCartPage.updateProductQuantity(cqty);
    }

    @Then("^Product \"([^\"]*)\" Quantity is Updated to \"([^\"]*)\"$")
    public void productQuantityIsUpdatedTo(String cproduct, String nqty) throws Throwable {
        Assert.assertTrue(lumaMiniCartPage.miniCartProducts().contains(cproduct));
        Assert.assertEquals(lumaMiniCartPage.totalMiniBasket(),lumaMiniCartPage.totalMiniItems());
        Assert.assertEquals(lumaMiniCartPage.totalMiniBasket(),nqty);
        Assert.assertEquals(lumaMiniCartPage.totalMiniItems(),nqty);
        Assert.assertTrue(lumaMiniCartPage.totalMiniBasket().contains(nqty));
        Assert.assertTrue(lumaMiniCartPage.totalMiniItems().contains(nqty));
    }

    @And("^Edit Product with Quantity \"([^\"]*)\"$")
    public void editProductWithQuantity(Integer nqty) throws Throwable {
        lumaMiniCartPage.editProduct();
        lumaPDPage.updatePDPQuantity(nqty);
        lumaPDPage.clickUpdateCart();
        lumaMiniCartPage.openMiniCart();
    }

    @And("^Edit Product with Swatch \"([^\"]*)\"$")
    public void editProductWithSwatch(String color) throws Throwable {
        lumaMiniCartPage.editProduct();
        lumaPDPage.clickSizeSwatchIndex(2);
        lumaPDPage.clickColorSwatchIndex(2);
        lumaPDPage.clickUpdateCart();
        lumaMiniCartPage.openMiniCart();
    }

    @Then("^Product \"([^\"]*)\" Swatch is Updated to \"([^\"]*)\"$")
    public void productSwatchIsUpdatedTo(String cproduct, String color) throws Throwable {
        Assert.assertTrue(lumaMiniCartPage.miniCartProducts().contains(cproduct));
        Assert.assertTrue(lumaMiniCartPage.miniConfigProductDetails().contains(color));
    }



}
