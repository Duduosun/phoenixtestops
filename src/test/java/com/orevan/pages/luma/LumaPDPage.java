package com.orevan.pages.luma;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by tolaf on 22/07/2016.
 */
public class LumaPDPage extends PageObject {
    /**
     * PDP
     */

    private By gallery = By.cssSelector(".gallery-placeholder");
    private By fotoramaNodes = By.cssSelector(".fotorama__img");
    private By productRHS = By.cssSelector(".product-info-main");
    private By base = By.cssSelector(".base");
    private By reviewBlock = By.cssSelector(".product-reviews-summary");
    private By priceInfoBlock = By.cssSelector(".product-info-price");
    private By swatchOptionsBlock = By.cssSelector(".swatch-opt");
    private By swatchOptionsNodes = By.cssSelector(".swatch-opt>div");
    private By cartBoxBlock = By.cssSelector(".box-tocart");
    private By socialLinks = By.cssSelector(".product-social-links");
    private By tabListBlock = By.cssSelector(".product.data.items");
    private By swatchColorNodes = By.cssSelector(".swatch-option.color");
    private By swatchSizeNodes = By.cssSelector(".swatch-option.text");
    private By updateCart = By.cssSelector("#product-updatecart-button");
    private By pdpQuantity = By.cssSelector("#qty");

        //method
    public void verifyPDP(String eproduct){
        shouldBeVisible(gallery);
        shouldBeVisible(fotoramaNodes);
        shouldBeVisible(productRHS);
        shouldBeVisible(base);
        shouldBeVisible(reviewBlock);
        shouldBeVisible(priceInfoBlock);
        shouldBeVisible(cartBoxBlock); //out of stock product NA
        shouldBeVisible(socialLinks);
        shouldBeVisible(tabListBlock);
        element(base).getText().equals(eproduct); //boolean equals = element(base).getText().equals(eproduct);
    }
    public void clickColorSwatchIndex(Integer icolor){
        List<WebElement> aSwatchNodes = thenReturnElementList(swatchColorNodes);
        aSwatchNodes.get(icolor).click();
    }
    public void clickSizeSwatchIndex(Integer isize){
        List<WebElement> aSwatchNodes = thenReturnElementList(swatchSizeNodes);
        aSwatchNodes.get(isize).click();
    }
    public void updatePDPQuantity(Integer nqty){
        element(pdpQuantity).clear();
        element(pdpQuantity).sendKeys(nqty.toString());
    }
    public void clickUpdateCart(){
        clickOn(element(updateCart));
    }

    public Integer countFotorama(){
        List<WebElement> sFotoramaNodes = thenReturnElementList(fotoramaNodes);
        sFotoramaNodes.get(0).isDisplayed();
        return sFotoramaNodes.size();
    }
    public Boolean simpleOrconfigurable(){
        if (isElementVisible(swatchOptionsBlock).equals(true)){
            return true;
        } else  {
            return false;
        }

        //return isElementVisible(swatchOptionsBlock).equals(true);
    }
}