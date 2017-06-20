package com.orevan.pages.luma;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tolaf on 22/07/2016.
 */
//@DefaultUrl("http://magento2-demo.nexcess.net/")
public class LumaBasePage extends PageObject {
    /**
     * Home Page
     * Whats New
     * Top Level Category
     * Marketing Page
     */
    //private String luma = "http://magento2.nublue.co.uk/";
    private String luma = "http://magento2-demo.nexcess.net/";
    //private String luma = "http://magento2.nublue.co.uk/?_ga=1.162718655.222142942.1469213708";

    private WebDriver fDriver;
    private String homePage = "Home Page";
    private String whatsNewPage = "What's New";
    private String womenPage = "Women";
    private String menPage = "Men";
    private String gearPage = "Gear";
    private String trainingPage = "Training";
    private String salePage = "Sale";

    //header
    private By panelHeader = By.cssSelector(".panel.header");
    private By headerContent = By.cssSelector(".header.content");
    private By lumaLogo = By.cssSelector(".logo>img");
    private By signInNodes = By.cssSelector(".authorization-link>a"); // return 2 matching nodes
    private By signOutNodes = By.cssSelector(".authorization-link>a"); // 4 matching nodes
    private By createAccountNodes = By.cssSelector(".header.links>li>a[href*=create]"); // return 2 matching nodes
    private By activeUserNodes = By.cssSelector(".customer-name>span"); // 2 matching nodes
    private By searchInput = By.cssSelector("#search");
    private By miniBasket = By.cssSelector(".minicart-wrapper");
    private By pageHeader = By.cssSelector(".page-header"); // block of all of the above
    private By topCatBlock = By.cssSelector("#ui-id-2");
    private By topCatNodes = By.cssSelector("#ui-id-2>li>a"); // #ui-id-2>li

    //footer
    private By footerContent = By.cssSelector(".footer.content");
    private By footerLinks = By.cssSelector(".nav.item>a");
    private By newsletter = By.cssSelector("#newsletter");
    private By subscribe = By.cssSelector(".action.subscribe.primary");
    private By pageFooter = By.cssSelector(".page-footer"); // block of all of the above
    private By copyRight = By.cssSelector(".copyright");

    //Body
    private By homeBody = By.cssSelector(".cms-home.cms-index-index.page-layout-1column");
    private By homeMainPromo = By.cssSelector(".block-promo.home-main");
    private By whiteContent = By.cssSelector(".content.bg-white");
    private By btnShopYoga  = By.cssSelector(".action.more.button");
    private By trendingContent = By.cssSelector(".content-heading");
    private By productNodes = By.cssSelector(".product-item-info");
    private By productLinkNodes = By.cssSelector(".product-item-name>a"); // .product-item-name>a  .product-item-link

    //Base page
    private By breadcrumbs = By.cssSelector(".breadcrumbs");
    private By pageHeading = By.cssSelector(".base");
    private By topLHS = By.cssSelector(".sidebar.sidebar-main");
    private By subLHSNodes = By.cssSelector(".categories-menu>strong");
    private By itemsLHSNodes = By.cssSelector(".categories-menu>ul>li");
    private By bottomLHS = By.cssSelector(".sidebar.sidebar-additional");
    private By promoBlock = By.cssSelector(".blocks-promo");
    private By promoNodes = By.cssSelector(".block-promo");
    private By anchorPromoNodes = By.cssSelector(".blocks-promo>a");
    private By divPromoNodes = By.cssSelector(".blocks-promo>div");
    private By contentNodes = By.cssSelector(".content");

    //methods
    public void verifyHomePageBody(){
        shouldBeVisible(homeBody);
        shouldBeVisible(topCatBlock);
        shouldBeVisible(topCatNodes);
        shouldBeVisible(promoBlock);
        shouldBeVisible(homeMainPromo);
        shouldBeVisible(promoNodes);
        shouldBeVisible(whiteContent);
        shouldBeVisible(btnShopYoga);
        shouldBeVisible(trendingContent);
        shouldBeVisible(productNodes);
    }
    public void closeLuma(){
        fDriver.close();
    }
    public void goToLuma(){
        openAt(luma);
    }
    public void clearBrowserCache(){
        fDriver.manage().deleteAllCookies();
    }
    public void goHome(){
        clickOn(element(lumaLogo));
        verifyHeader();
        verifyHomePageBody();
        verifyFooter();
    }
    public void verifyHomeLogo(){
        waitForTitleToAppear(homePage);
        shouldBeVisible(lumaLogo);
    }
    public void verifyHeader(){
        shouldBeVisible(pageHeader);
        shouldBeVisible(headerContent);
        shouldBeVisible(searchInput);
        shouldBeVisible(miniBasket);
    }
    public void verifyFooter(){
        shouldBeVisible(pageFooter);
        shouldBeVisible(footerContent);
        shouldBeVisible(footerLinks);
        shouldBeVisible(newsletter);
        shouldBeVisible(subscribe);
        shouldBeVisible(copyRight);
    }
    public Integer countFooterLinks(){
        List<WebElement> sfooterLinks = thenReturnElementList(footerLinks);
        sfooterLinks.get(0).isDisplayed();
        return sfooterLinks.size();
    }
    public void clickSignIn(){
        List<WebElement> signIn = thenReturnElementList(signInNodes);
        signIn.get(0).click();
    }
    public void clickSignOut() throws InterruptedException {
        List<WebElement> sActiveUser = thenReturnElementList(activeUserNodes);
        sActiveUser.get(0).click();
        List<WebElement> signOut = thenReturnElementList(signOutNodes);
        signOut.get(0).click();
        waitForTitleToAppear(homePage);
    }
    public void clickCreateAccount(){
        List<WebElement> createAccount = thenReturnElementList(createAccountNodes);
        createAccount.get(0).click();
    }

    @FindBy(css = ".panel.header") private WebElementFacade sPanelHeader;
    public String currentUserMode(String ocurrent){
        String cUser = null;
        shouldBeVisible(panelHeader);

        if(sPanelHeader.getText().contains(ocurrent)){
            cUser = sPanelHeader.getText();
        }
        return cUser;
    }
    public String guestUser(){
        shouldBeVisible(panelHeader);
        waitForAnyTextToAppear(sPanelHeader, "welcome");
        return sPanelHeader.getText();
    }
    public String registeredUser(){
        shouldBeVisible(panelHeader);
        waitForAnyTextToAppear(sPanelHeader, "Welcome");
        return sPanelHeader.getText();
    }
    public String espotProducts(String eproduct) {
        List<WebElement> sProductNodes = thenReturnElementList(productLinkNodes);
        String espot = null;
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getAttribute("title").equals(eproduct)) {
                espot = iProduct.getText();
            }
        }
        return espot;
    }

    public Integer countTopCatNodes(){
        List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
        sTopCatNodes.get(0).isDisplayed();
        return sTopCatNodes.size();
    }
    public Integer countPromoNodes(){
        List<WebElement> sPromoNodes = thenReturnElementList(promoNodes);
        sPromoNodes.get(0).isDisplayed();
        return sPromoNodes.size();
    }
    public Integer countContent(){
        List<WebElement> sContent = thenReturnElementList(contentNodes);
        sContent.get(5).isDisplayed();
        return sContent.size();
    }
    public Integer countWhiteContent(){
        List<WebElement> sWhiteContent = thenReturnElementList(whiteContent);
        sWhiteContent.get(0).isDisplayed();
        return sWhiteContent.size();
    }
    public Integer countProductNodes(){
        List<WebElement> sProductNodes = thenReturnElementList(productNodes);
        sProductNodes.get(2).isDisplayed();
        return sProductNodes.size();
    }
    public Integer countLHSHeading(){
        List<WebElement> sLHSHeading = thenReturnElementList(subLHSNodes);
        sLHSHeading.get(0).isDisplayed();
        return sLHSHeading.size();
    }
    public Integer countLHSItems(){
        List<WebElement> sLHSItems = thenReturnElementList(itemsLHSNodes);
        sLHSItems.get(2).isDisplayed();
        return sLHSItems.size();
    }

    public void clickIndexTopCat(Integer tcat){
        List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
        sTopCatNodes.get(tcat).click();
    }
    public void clickTopCat(String tcat) {
        List<WebElement> sTopCatNodes = thenReturnElementList(topCatNodes);
        for (WebElement iTopCat : sTopCatNodes) {
            if (iTopCat.getText().equals(tcat)) {
                iTopCat.click();
                break;
            }
        }
    }
    public void vpBreadcrumbs(){}
    public void vpPageHeading(){}
    public void vpLHS(){
        shouldBeVisible(topLHS);  // Training NA
        shouldBeVisible(bottomLHS);
        shouldBeVisible(subLHSNodes); // Gear NA
        shouldBeVisible(itemsLHSNodes); // Training NA
    }
    public void vpEmptyLHS(){
        shouldBeVisible(topLHS);
        shouldBeVisible(bottomLHS);
        isElementVisible(subLHSNodes); // Gear element is empty
        shouldBeVisible(itemsLHSNodes);
    }
    public void vpSingleLHS(){
        shouldBeVisible(bottomLHS);
    }
    public void vpPLPLHS(){
        shouldBeVisible(topLHS);
        shouldBeVisible(bottomLHS);
    }
    public void vpPromo(){
        shouldBeVisible(promoBlock);
        shouldBeVisible(promoNodes);
        shouldBeVisible(contentNodes);
    }
    public void verifyProductEspot(String eproduct) {
        List<WebElement> sProductNodes = thenReturnElementList(productLinkNodes);
        for (WebElement iProduct : sProductNodes) {
            if (iProduct.getText().equals(eproduct)) {
                iProduct.isDisplayed();
                iProduct.isEnabled();
                break;
            }
            shouldBeVisible(trendingContent);
        }
    }

    @FindBy(css = ".base") private WebElementFacade sPageHeading;
    @FindBy(css = ".breadcrumbs") private WebElementFacade sBreadcrumbs;
    public void verifyBasePage(String bpage){
        waitForTitleToAppear(bpage);
        waitForAnyTextToAppear(sPageHeading, bpage);
        waitForAnyTextToAppear(sBreadcrumbs, "Home");
        waitForAnyTextToAppear(sBreadcrumbs, bpage);
    }

}

//(fuelLevel > 0) ? 'Y': 'N';
//Serenity Style Object Capture
//find(By.cssSelector(".foo")).getValue();
//findBy("#demo").then("#specialField").getValue(); //css selectors
//find(By.name("demo")).then(By.name("specialField")).getValue();