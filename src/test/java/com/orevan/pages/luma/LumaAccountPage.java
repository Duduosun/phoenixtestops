package com.orevan.pages.luma;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tolaf on 22/07/2016.
 */
public class LumaAccountPage extends PageObject {
    /**
     * My Account Dashboard
     Account Information
     Address Book
     Add New Address
     Edit Address
     My Downloadable Products
     My Orders
     Newsletter Subscription
     Billing Agreements
     My Product Reviews
     My Wish List
     View Order
     Wish List Sharing
     */

    private String accountPage = "My Account";
    private String accountBody = ".account.customer-account-index.page-layout-2columns-left";
    private String messageThanks = "Thank you for registering with Main Website Store";
    private String dashboardMain = ".column.main";
    private String myDashboard = "My Dashboard";
    private String accountInformation = "Edit Account Information";
    private String addressBook = "Address Book";
    private String myDownloadableProducts = "My Downloadable Products";
    private String myOrders = "My Orders";
    private String newsletterSubscriptions = "Newsletter Subscription";
    private String billingAgreements = "Billing Agreements";
    private String myProductReviews = "My Product Reviews";
    private String myWishList = "My Wish List";

    private By message = By.cssSelector(".message-success.success.message");
    private By pageHeading = By.cssSelector(".base");
    private By accountLHSNodes = By.cssSelector("#block-collapsible-nav>ul>li");
    private By accountBottomLHSNodes = By.cssSelector(".sidebar.sidebar-additional>div");

    private By dasboardRecentOrders = By.cssSelector(".block.block-dashboard-orders");
    private By dashboardOrdersTableHead = By.cssSelector("#my-orders-table>thead");
    private By dashboardOrdersTableBodyNodes = By.cssSelector("#my-orders-table>tbody>tr");
    private By dashboardAccountInfo = By.cssSelector(".block.block-dashboard-info");
    private By dashboardAddress = By.cssSelector(".block.block-dashboard-addresses");

    private By saveButton = By.cssSelector(".action.save.primary");

    private By defaultAddress = By.cssSelector(".block.block-addresses-default");
    private By additionalAddress = By.cssSelector(".block.block-addresses-list");
    private By addNewAddressButton = By.cssSelector(".action.primary.add");

    private By downloadableTable = By.cssSelector(".table-wrapper.downloadable-products");
    private By downloadbleTableHead = By.cssSelector("#my-downloadable-products-table>thead");
    private By downloadableBodyNodes = By.cssSelector("#my-downloadable-products-table>tbody>tr");

    private By myOrdersHistory = By.cssSelector(".table-wrapper.orders-history");
    private By myOrdersTableHead = By.cssSelector("#my-orders-table>thead");
    private By myOrdersTableBodyNodes = By.cssSelector("#my-orders-table>tbody>tr");

    private By subscriptionModule = By.cssSelector("#form-validate>fieldset");
    private By checkGeneralSubscription = By.cssSelector("#subscription");

    private By emptyMessage = By.cssSelector(".message.info.empty");

    private By wishListBlock = By.cssSelector(".products-grid.wishlist");
    private By wishListNodes = By.cssSelector(".products-grid.wishlist>ol>li");
    private By wishListButtons = By.cssSelector("#wishlist-view-form>div>div>button");
    private By removeFromWishList = By.cssSelector(".products-grid.wishlist>ol>li>div>div>div>a.btn-remove.action.delete");
    private By messageInfoEmpty = By.cssSelector(".message.info.empty");

        //methods
    public Integer countDashboardOrdersTable(){
            List<WebElement> sDashboardOrderTableNodes = thenReturnElementList(dashboardOrdersTableBodyNodes);
            sDashboardOrderTableNodes.get(0).isDisplayed();
            return sDashboardOrderTableNodes.size();
    }
    public Integer countDownloadableProducts(){
        List<WebElement> sDownloadableTableNodes = thenReturnElementList(downloadableBodyNodes);
        sDownloadableTableNodes.get(0).isDisplayed();
        return sDownloadableTableNodes.size();
    }
    public Integer countMyOrdersTable(){
        List<WebElement> sMyOrderTableNodes = thenReturnElementList(myOrdersTableBodyNodes);
        sMyOrderTableNodes.get(0).isDisplayed();
        return sMyOrderTableNodes.size();
    }
    public Integer countWishList(){
        List<WebElement> sWishListNodes = thenReturnElementList(wishListNodes);
        sWishListNodes.get(0).isDisplayed();
        return sWishListNodes.size();
    }

    public String wishListProducts(){
        shouldBeVisible(wishListBlock);
        return element(wishListBlock).getText();
    }
    @FindBy(css = ".fieldset.info>div>div>input[id*=email]") private WebElementFacade sEmail;
    public String accountInformationEmail(String rusername){
        String vEmail = null;
        if (sEmail.getValue().equals(rusername)){
            vEmail = sEmail.getValue();
        }
        return vEmail;
    }

    public void myAccountPage(){
        waitForTitleToAppear(accountPage);
        waitForTextToAppear(myDashboard);
    }
    @FindBy(css =".column.main") private WebElementFacade sMyDashboard;

    @FindBy(css = ".base") private WebElementFacade sPageHeading;
    public void vpAccountDashboard(String ruser, String rusername){
        waitForTextToAppear(sPageHeading, myDashboard);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        waitForTextToAppear(element(dasboardRecentOrders),"Recent Orders");
        shouldBeVisible(dashboardOrdersTableHead);
        waitForTextToAppear(element(dashboardOrdersTableHead), "Order Total");
        waitForTextToAppear(element(dashboardAccountInfo), ruser);
        waitForTextToAppear(element(dashboardAccountInfo), rusername);
        waitForTextToAppear(element(dashboardAccountInfo), "Account Information");
        waitForTextToAppear(element(dashboardAddress), ruser);
        waitForTextToAppear(element(dashboardAddress), addressBook);
        waitForTextToAppear(element(dashboardAddress), "Default Billing Address");
        waitForTextToAppear(element(dashboardAddress), "Default Shipping Address");
    }
    public void newAccountDashboard(String ruser){
        waitForTitleToAppear(accountPage);
        waitForTextToAppear(myDashboard);
        waitForTextToAppear(messageThanks);
        waitForAnyTextToAppear(sMyDashboard, ruser);
    }
    public void myAccountDashboard(String ruser) {
        waitForTitleToAppear(accountPage);
        waitForTextToAppear(myDashboard);
        waitForAnyTextToAppear(sMyDashboard, ruser );
    }
    public void navigateAccountTab(String acctab){
        List<WebElement> sAccountLHSNodes = thenReturnElementList(accountLHSNodes);

        switch (acctab){
            case "Account Dashboard":
                clickOn(sAccountLHSNodes.get(0));
                break;
            case "Account Information":
                clickOn(sAccountLHSNodes.get(1));
                break;
            case "Address Book":
                clickOn(sAccountLHSNodes.get(2));
                break;
            case "My Downloadable Products":
                clickOn(sAccountLHSNodes.get(3));
                break;
            case "My Orders":
                clickOn(sAccountLHSNodes.get(4));
                break;
            case "Newsletter Subscriptions":
                clickOn(sAccountLHSNodes.get(5));
                break;
            case "Billing Agreements":
                clickOn(sAccountLHSNodes.get(6));
                break;
            case "My Product Reviews":
                clickOn(sAccountLHSNodes.get(7));
                break;
            case "My Wish List":
                clickOn(sAccountLHSNodes.get(8));
                break;
        }
    }
    public void vpAccountInformation(){
        waitForTextToAppear(sPageHeading, accountInformation);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        shouldBeVisible(sEmail);
        shouldBeVisible(saveButton);
    }
    public void vpAddressBook(String ruser){
        waitForTextToAppear(sPageHeading, addressBook);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        shouldBeVisible(defaultAddress);
        shouldBeVisible(additionalAddress);
        shouldBeVisible(addNewAddressButton);
        waitForTextToAppear(element(defaultAddress), "Default Billing Address");
        waitForTextToAppear(element(defaultAddress), "Default Shipping Address");
        waitForTextToAppear(element(defaultAddress), ruser);
        waitForTextToAppear(element(additionalAddress), ruser);
    }
    public void vpMyDownloadableProducts(String vproduct){
        waitForTextToAppear(sPageHeading, myDownloadableProducts);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        shouldBeVisible(downloadableTable);
        waitForTextToAppear(element(downloadbleTableHead), "Status");
        waitForTextToAppear(element(downloadableTable), vproduct);
    }
    public void vpMyOrders(String ruser){
        waitForTextToAppear(sPageHeading, myOrders);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        shouldBeVisible(myOrdersHistory);
        waitForTextToAppear(element(myOrdersTableHead), "Ship To");
        waitForTextToAppear(element(myOrdersHistory), ruser);
    }
    public void vpNewsletterSubscriptions(){
        waitForTextToAppear(sPageHeading, newsletterSubscriptions);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        shouldBeVisible(subscriptionModule);
        shouldBeVisible(checkGeneralSubscription);
        waitForTextToAppear(element(subscriptionModule), "Subscription option");
        waitForTextToAppear(element(subscriptionModule), "General Subscription");
        shouldBeVisible(saveButton);
    }
    public void vpBillingAgreements(){
        waitForTextToAppear(sPageHeading, billingAgreements);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        waitForTextToAppear(element(emptyMessage), "There are no billing agreements yet");
    }
    public void vpMyProductReviews(){
        waitForTextToAppear(sPageHeading, myProductReviews);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        waitForTextToAppear(element(emptyMessage), "You have submitted no reviews");
    }
    public void vpMyWishList(String wproduct){
        waitForTextToAppear(sPageHeading, myWishList);
        shouldBeVisible(accountLHSNodes);
        shouldBeVisible(accountBottomLHSNodes);
        waitForTextToAppear(element(wishListBlock), wproduct);
        shouldBeVisible(wishListButtons);
    }
    public void removeProductFromMyWishList(String wproduct){
        List<WebElement> sWishListNodes = thenReturnElementList(wishListNodes);
        for (WebElement iWishList : sWishListNodes) {
            if (iWishList.getText().contains(wproduct)) {
                moveTo(By.linkText(wproduct));
                iWishList.findElement(By.linkText("Remove")).click();
                break;
            }
        }
    }
    public void emptyComparisonPage(){
        shouldBeVisible(messageInfoEmpty);
    }
}