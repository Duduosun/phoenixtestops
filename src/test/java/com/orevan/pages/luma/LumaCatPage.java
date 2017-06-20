package com.orevan.pages.luma;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by tolaf on 22/07/2016.
 */
public class LumaCatPage extends PageObject {
    /**
     * 2nd Level Cat
     * 3rd Level Cat
     * Search Results
     * Compare Products
     */

    private By topCatNodes = By.cssSelector("#ui-id-2>li>a");
    private By secondCatNodes = By.cssSelector("#ui-id-2>li>ul>li>a");
    private By womenTops = By.cssSelector("#ui-id-9");
    private By womenBottoms = By.cssSelector("#ui-id-10");
    private By menTops = By.cssSelector("#ui-id-17");
    private By menBottoms = By.cssSelector("#ui-id-18");
    private By bags = By.cssSelector("#ui-id-25");
    private By fitnessEquipment = By.cssSelector("#ui-id-26");
    private By watches = By.cssSelector("#ui-id-27");
    private By videoDownload = By.cssSelector("#ui-id-28");
    private By productNodes = By.cssSelector(".product-item");
    private By productLinkNodes = By.cssSelector(".product-item-link");
    private By breadcrumbsNodes = By.cssSelector(".breadcrumbs>ul>li");
    private By pageHeading = By.cssSelector(".base");
    private By shoppingOptions = By.cssSelector(".block-subtitle.filter-subtitle");
    private By filterOptionNodes = By.cssSelector(".filter-options-title");
    private By productToolbarNodes = By.cssSelector(".toolbar.toolbar-products");
    private By activeGridSwitchNodes = By.cssSelector(".modes-mode.active.mode-grid");
    private By inactiveGridSwitchNodes = By.cssSelector("#mode-grid");
    private By activeListSwitchNodes = By.cssSelector(".modes-mode.active.mode-list");
    private By inactiveListSwitchNodes = By.cssSelector("#mode-list");
    private By colorSwatchNodes = By.cssSelector(".swatch-attribute.color");
    private By sizeSwatchNodes = By.cssSelector(".swatch-attribute.size");
    private By searchProduct = By.cssSelector("#search");
    private By emptySearchNotice = By.cssSelector(".message.notice");
    private By baseString = By.cssSelector(".base");
    private By actionToWishListNodes = By.cssSelector(".action.towishlist");
    private By actionToCompareNodes = By.cssSelector(".action.tocompare");
    private By wishListProductNodes = By.cssSelector(".product-item>div>div>div>div>a.action.towishlist");
    private By fullProductNodes = By.cssSelector(".product-items.widget-product-grid>li");
    private By successMessage = By.cssSelector(".message-success.success.message");
    private By plpProductNodes = By.cssSelector(".products.list.items.product-items>li");
    private By pdpWishList = By.cssSelector(".product-info-main>div>div>a.action.towishlist");
    private By removeFromWishList = By.cssSelector("#wishlist-sidebar>li>div>div>div>div>a.btn-remove.action.delete");
    private By sidebarWishListNodes = By.cssSelector("#wishlist-sidebar>li");
    private By goToWishList = By.cssSelector(".action.details");
    private By compareSidebarBlock = By.cssSelector(".block.block-compare");
    private By compareHeaderLink = By.cssSelector(".compare.wrapper>li>a.action.compare");
    private By compareSidebarLink = By.cssSelector(".action.compare.primary");
    private By compareCounter = By.cssSelector(".action.compare>span.counter.qty");
    private By pdpCompare = By.cssSelector(".product-info-main>div>div>a.action.tocompare");
    private By comparedProductNodes = By.cssSelector(".cell.product.info");
    private By clearAllCompare = By.cssSelector("#compare-clear-all");
    private By removeCompareSidbarNodes = By.cssSelector(".block.block-compare>div>ol>li");
    private By compareSidebar = By.cssSelector(".action.compare.primary");
    private By comparisonProductNodes = By.cssSelector("#product-comparison>tbody>tr");
    private By removeComparisonProductNodes = By.cssSelector("#product-comparison>thead>tr>td>a");
    private By pdpAddToCart = By.cssSelector("#product-addtocart-button");

    //methods
    public Integer countProducts() {
        List<WebElement> sProductNodes = thenReturnElementList(productNodes);
        sProductNodes.get(2).isDisplayed();
        return sProductNodes.size();
    }
    public Integer countBreadcrumbs() {
        List<WebElement> sBreadcrumbsNodes = thenReturnElementList(breadcrumbsNodes);
        sBreadcrumbsNodes.get(1).isDisplayed();
        return sBreadcrumbsNodes.size();
    }
    public Integer countFilterOptions() {
        shouldBeVisible(shoppingOptions);
        List<WebElement> sFilterOptionNodes = thenReturnElementList(filterOptionNodes);
        sFilterOptionNodes.get(1).isDisplayed();
        return sFilterOptionNodes.size();
    }
    public Integer countToolbarNodes() {
        List<WebElement> sToolbarNodes = thenReturnElementList(productToolbarNodes);
        sToolbarNodes.get(0).isDisplayed();
        sToolbarNodes.get(1).isDisplayed();
        return sToolbarNodes.size();
    }
    public Integer countWishListNodes() {
        List<WebElement> sWishListNodes = thenReturnElementList(actionToWishListNodes);
        sWishListNodes.get(0).isDisplayed();
        return sWishListNodes.size();
    }
    public Integer countCompareNodes() {
        List<WebElement> sCompareNodes = thenReturnElementList(actionToCompareNodes);
        sCompareNodes.get(0).isDisplayed();
        return sCompareNodes.size();
    }

    public String pageHeading(){return element(pageHeading).getText();}
    public String successMessage() {
        element(successMessage).waitUntilVisible();
        return element(successMessage).getText();
    }
    public String compareSidebar() {
        return element(compareSidebarBlock).getText();
    }
    public String comparedProductQTY() {
        return element(compareCounter).getText();
    }
    public String verifySimpleProduct(String sproduct) {
        shouldNotBeVisible(colorSwatchNodes);
        shouldNotBeVisible(sizeSwatchNodes);

        List<WebElement> sProductNodes = thenReturnElementList(productLinkNodes);
        String espot = null;
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getText().equals(sproduct)) {
                espot = iProduct.getText();
            }
        }
        return espot;
    }
    public String verifyConfigurableProduct(String cproduct) {
        shouldBeVisible(colorSwatchNodes);
        shouldBeVisible(sizeSwatchNodes);

        List<WebElement> sProductNodes = thenReturnElementList(productLinkNodes);
        String espot = null;
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getText().equals(cproduct)) {
                espot = iProduct.getText();
            }
        }
        return espot;
    }
    public String comparedProducts(){
        List<WebElement> sComparedProductNodes = thenReturnElementList(comparedProductNodes);
        return sComparedProductNodes.get(0).getText();
    }

    public void clickSecondCatINT(Integer tcat) {
        List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
        withAction().moveToElement(sTopCatNodes.get(tcat)).perform();
        List<WebElement> sSecondCatNodes = thenReturnElementList(secondCatNodes);
        sSecondCatNodes.get(0).click();
    }
    public void clickSecondCat(String tcat, String scat) {
        List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
        for (WebElement iTopCat : sTopCatNodes) {
            if (iTopCat.getText().equals(tcat)) {
                withAction().moveToElement(iTopCat).perform();
            }
        }

        switch (scat) {
            case "Women Tops":
                String wtop = element(womenTops).getText();
                element(womenTops).click();
                element(pageHeading).getText().equals(wtop);
                break;
            case "Women Bottoms":
                String wbottom = element(womenBottoms).getText();
                element(womenBottoms).click();
                element(pageHeading).getText().equals(wbottom);
                break;

            case "Men Tops":
                String mtop = element(menTops).getText();
                element(menTops).click();
                element(pageHeading).getText().equals(mtop);
                break;
            case "Men Bottoms":
                String mbottom = element(menBottoms).getText();
                element(menBottoms).click();
                element(pageHeading).getText().equals(mbottom);
                break;

            case "Bags":
                String bag = element(bags).getText();
                element(bags).click();
                element(pageHeading).getText().equals(bag);
                break;
            case "Fitness Equipment":
                String fitness = element(fitnessEquipment).getText();
                element(fitnessEquipment).click();
                element(pageHeading).getText().equals(fitness);
                break;
            case "Watches":
                String watch = element(watches).getText();
                element(watches).click();
                element(pageHeading).getText().equals(watch);
                break;

            case "Video Download":
                String video = element(videoDownload).getText();
                element(videoDownload).click();
                element(pageHeading).getText().equals(video);
                break;
        }
    }
    public void vpCompareListedProduct() {
        shouldBeVisible(compareHeaderLink);
        shouldBeVisible(compareSidebarBlock);
    }
    public void vpComparePDProduct() {
        shouldBeVisible(compareHeaderLink);
    }
    public void verifyPLPGridView() {
        List<WebElement> sActiveGridSwitch = thenReturnElementList(activeGridSwitchNodes);
        List<WebElement> sInactiveListSwitch = thenReturnElementList(inactiveListSwitchNodes);
        shouldBeVisible(sActiveGridSwitch.get(0));
        shouldNotBeVisible(inactiveGridSwitchNodes);
        shouldBeVisible(sInactiveListSwitch.get(0));
        shouldNotBeVisible(activeListSwitchNodes);
    }
    public void verifyPLPListView() {
        List<WebElement> sActiveListSwitch = thenReturnElementList(activeListSwitchNodes);
        List<WebElement> sInactiveGridSwitch = thenReturnElementList(inactiveGridSwitchNodes);
        shouldBeVisible(sActiveListSwitch.get(0));
        shouldNotBeVisible(inactiveListSwitchNodes);
        shouldBeVisible(sInactiveGridSwitch.get(0));
        shouldNotBeVisible(activeGridSwitchNodes);
    }
    public void switchToListView() {
        clickOn(element(inactiveListSwitchNodes));
    }
    public void switchToGridView() {
        clickOn(element(inactiveGridSwitchNodes));
    }
    public void clickProduct(String eproduct) {
        List<WebElement> sProductNodes = thenReturnElementList(productLinkNodes);
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getText().equals(eproduct)) {
                iProduct.click();
                break;
            }
        }
    }
    public void searchProduct(String search) {
        String searchConstant = "Search results for: ";
        String completeSearch = searchConstant + "'" + search + "'";
        element(searchProduct).sendKeys(search);
        element(searchProduct).sendKeys(Keys.ENTER);
        waitForTextToAppear(element(baseString), completeSearch);
        waitForTextToAppear(element(baseString), completeSearch);
        waitForTitleToAppear(completeSearch);
    }

    @FindBy(css = ".message.notice") private WebElementFacade sEmptySearchNotice;
    public void emptyResultMessage(String message) {
        shouldBeVisible(emptySearchNotice);
        shouldNotBeVisible(productLinkNodes);
        shouldNotBeVisible(productNodes);
        shouldNotBeVisible(productToolbarNodes);
        waitForTextToAppear(sEmptySearchNotice, message);
    }
    public void clickAddToWishList() {
        List<WebElement> sWishList = thenReturnElementList(actionToWishListNodes);
        clickOn(sWishList.get(0));
    }
    public void clickAddToWishList(String wproduct) {
        List<WebElement> sProductNodes = thenReturnElementList(productNodes);
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getText().contains(wproduct)) {
                moveTo(By.linkText(wproduct));
                iProduct.findElement(By.linkText("WISH LIST")).click();
                break;
            }
        }
    }
    public void addPDProductToWishList(String wproduct) {
        clickOn(element(pdpWishList));
    }
    public void removeProductFromWishList(String wproduct) {
        List<WebElement> sWishListNodes = thenReturnElementList(sidebarWishListNodes);
        for (WebElement iWishList : sWishListNodes) {
            if (iWishList.getText().contains(wproduct)) {
                //moveTo(By.linkText(wproduct));
                iWishList.findElement(By.linkText("REMOVE THIS ITEM")).click();
                break;
            }
        }
    }
    public void goToWishList() {
        clickOn(element(goToWishList));
    }
    public void clickAddToCompareProduct() {
        List<WebElement> sCompareProduct = thenReturnElementList(actionToCompareNodes);
        clickOn(sCompareProduct.get(0));
    }
    public void clickAddToCompareProduct(String cproduct) {
        List<WebElement> sProductNodes = thenReturnElementList(productNodes);
        for (WebElement iProductNodes : sProductNodes) {
            if (iProductNodes.getText().contains(cproduct)) {
                moveTo(By.linkText(cproduct));
                iProductNodes.findElement(By.linkText("COMPARE")).click();
                break;
            }
        }
    }
    public void addPDProductToCompare(String cproduct) {
        clickOn(element(pdpCompare));
    }
    public void clickCompareHeader() {
        clickOn(element(compareHeaderLink));
    }
    public void productComparison(String aproduct, String bproduct, String cproduct, String dproduct) {
        List<WebElement> sCompareProductNodes = thenReturnElementList(comparedProductNodes);
        for (WebElement iCompareProductNodes : sCompareProductNodes) {
            if (iCompareProductNodes.getText().equals(aproduct)) {
                Assert.assertTrue(iCompareProductNodes.isDisplayed());
            }
        }
        for (WebElement iCompareProductNodes : sCompareProductNodes) {
            if (iCompareProductNodes.getText().equals(bproduct)) {
                Assert.assertTrue(iCompareProductNodes.isDisplayed());
            }
        }
        for (WebElement iCompareProductNodes : sCompareProductNodes) {
            if (iCompareProductNodes.getText().equals(cproduct)) {
                Assert.assertTrue(iCompareProductNodes.isDisplayed());
            }
        }
        for (WebElement iCompareProductNodes : sCompareProductNodes) {
            if (iCompareProductNodes.getText().equals(dproduct)) {
                Assert.assertTrue(iCompareProductNodes.isDisplayed());
            }
        }
    }
    public void removeOneCompare(String cproduct){
        List<WebElement> sRemoveCompareNodes = thenReturnElementList(removeCompareSidbarNodes);
        for (WebElement iRemoveCompareNodes:sRemoveCompareNodes){
            if (iRemoveCompareNodes.getText().contains(cproduct)){
                iRemoveCompareNodes.findElement(By.linkText("Remove This Item")).click();
                break;
            }
        }
    }
    public void removeAllCompare(){
        clickOn(element(clearAllCompare));
    }
    public void removeComparisonOneByOne(){
        List<WebElement> sRemoveComparison = thenReturnElementList(removeComparisonProductNodes);
            sRemoveComparison.get(0).click();
    }
    public void addListedProductToCart(String aproduct){
        List<WebElement> sProductNodes = thenReturnElementList(productNodes);
        for(WebElement iProductNodes : sProductNodes){
            if(iProductNodes.getText().contains(aproduct)){
                moveTo(By.linkText(aproduct));
                iProductNodes.findElement(By.className("actions-primary")).click();
                break;
            }
        }
    }
    public void addPDProductToCart(String aproduct){
        clickOn(element(pdpAddToCart));
    }
}