package com.orevan.pages.luma;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tolaf on 20/08/2016.
 */
public class LumaMiniCartPage extends PageObject {

    private By miniCart = By.cssSelector("#ui-id-1");
    private By emptyCart = By.cssSelector(".subtitle.empty>span");
    private By miniCartItems = By.cssSelector(".minicart-items-wrapper");
    private By miniProductDetailsNodes = By.cssSelector("#ui-id-1>div>div>div>ol>li>div>div");
    private By miniProductNodes = By.cssSelector(".item.product.product-item>div>div>strong>a");
    private By miniEditNodes = By.cssSelector(".product.actions>div>a.action.edit");
    private By miniDeleteNodes = By.cssSelector(".product.actions>div>a.action.delete");
    private By miniUpdateNodes = By.cssSelector(".details-qty.qty>button");
    private By miniCheckout = By.cssSelector("#top-cart-btn-checkout");
    private By viewEditCart = By.cssSelector(".action.viewcart>span>span");
    private By miniClose = By.cssSelector("#btn-minicart-close");
    private By showMiniCart = By.cssSelector(".action.showcart");
    private By removePopupOkay = By.cssSelector(".action-primary.action-accept");
    private By miniBasketCount = By.cssSelector(".counter-number");
    private By miniQTYNodes = By.cssSelector(".details-qty.qty>input");
    private By miniItemCount = By.cssSelector(".count");
    private By configToggleNodes = By.cssSelector(".toggle");

    //methods
    public String miniCartProducts(){
        return element(miniCart).waitUntilVisible().getText();
    }
    public String totalMiniBasket() {
        element(miniBasketCount).waitUntilVisible();
        return element(miniBasketCount).getText().trim();
    }
    public String totalMiniItems() throws InterruptedException {
        element(miniItemCount).waitUntilVisible();
        return element(miniItemCount).getText().trim();
    }
    public String miniConfigProductDetails(){
        List<WebElement> sConfigToggleNodes = thenReturnElementList(configToggleNodes);
        List<WebElement> sMiniProductDetailsNodes = thenReturnElementList(miniProductDetailsNodes);
        sConfigToggleNodes.get(0).click();
        sMiniProductDetailsNodes.get(0).isDisplayed();
        return sMiniProductDetailsNodes.get(0).getText();
    }

    public void emptyMiniCart(){
        shouldBeVisible(miniCart);
        shouldBeVisible(emptyCart);
        Assert.assertTrue(element(emptyCart).getText().contains("You have no items in your shopping cart"));
    }
    public void verifyMiniCart(){
        shouldBeVisible(miniCart);
        shouldBeVisible(viewEditCart);
        shouldBeVisible(miniCheckout);
    }

    @FindBy(css = ".action.showcart") private WebElementFacade sShowMiniCart;
    public void openMiniCart(){
        clickOn(sShowMiniCart);
        waitABit(2000);
    }

    @FindBy(css = "#btn-minicart-close") private WebElementFacade sMiniClose;
    public void closeMiniCart(){
        clickOn(sMiniClose);
    }
    public void goToCheckout(){
        clickOn(element(miniCheckout));
    }
    public void goToBasket(){
        clickOn(element(viewEditCart));
    }
    public void noMiniCart(){
        shouldNotBeVisible(miniCart);
        shouldNotBeVisible(miniCheckout);
    }
    public void removeProduct(){
        List<WebElement> sMiniDeleteNodes = thenReturnElementList(miniDeleteNodes);
        sMiniDeleteNodes.get(0).click();
        clickOn(element(removePopupOkay));
        waitABit(2000);
    }
    public void updateProductQuantity(Integer cqty){
        List<WebElement> sMiniQtYNodes = thenReturnElementList(miniQTYNodes);
        List<WebElement> sMiniUpdateNodes = thenReturnElementList(miniUpdateNodes);
        sMiniQtYNodes.get(0).clear();
        sMiniQtYNodes.get(0).sendKeys(cqty.toString());
        sMiniUpdateNodes.get(0).click();
        waitABit(5000);
    }
    public void editProduct(){
        List<WebElement> sMiniEditNodes = thenReturnElementList(miniEditNodes);
        sMiniEditNodes.get(0).click();
    }
}