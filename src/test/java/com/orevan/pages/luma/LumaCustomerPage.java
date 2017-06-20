package com.orevan.pages.luma;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by tolaf on 22/07/2016.
 */
public class LumaCustomerPage extends PageObject {
    /**
     * Customer Login
     New Customer
     */

    private String newCustomerPage = "Create New Customer Account";
    private String customerLoginPage = "Customer Login";

    private By pageHeader = By.cssSelector(".base");
    private By emailAddress = By.cssSelector("#email");
    private By passWord = By.cssSelector("#pass");
    private By firstName = By.cssSelector("#firstname");
    private By lastName = By.cssSelector("#lastname");
    private By email = By.cssSelector("#email_address");
    private By nPassword = By.cssSelector("#password");
    private By cPassword = By.cssSelector("#password-confirmation");

        //methods
    @FindBy(css = ".base") private WebElementFacade sPageHeader;
    public void newCustomerPage(){
        waitForTitleToAppear(newCustomerPage);
        shouldBeVisible(pageHeader);
        waitForAnyTextToAppear(sPageHeader, newCustomerPage);
    }
    public void customerLoginPage(){
        waitForTitleToAppear(customerLoginPage);
        shouldBeVisible(pageHeader);
        waitForAnyTextToAppear(sPageHeader, customerLoginPage);
    }

    @FindBy(css = "#send2") private WebElementFacade sLogin;
    public void signIn(String uname, String pword){
        List<WebElement> sEmailAddress = thenReturnElementList(emailAddress);
        sEmailAddress.get(0).sendKeys(uname);
        List<WebElement> sPassword = thenReturnElementList(passWord);
        sPassword.get(0).sendKeys(pword);
        sLogin.click();
    }

    @FindBy(css = ".action.submit.primary") private WebElementFacade sCreateAccount;
    @FindBy(css = "#firstname") private WebElementFacade sFirstName;
    @FindBy(css = "#lastname") private WebElementFacade sLastName;
    @FindBy(css = "#email_address") private WebElementFacade sEmail;
    @FindBy(css = "#password") private WebElementFacade sNewPassword;
    @FindBy(css = "#password-confirmation") private WebElementFacade sConfirmPassword;
    public void registerUser(String fname, String lname, String email, String pword){
        waitFor(sFirstName).sendKeys(fname);
        waitFor(sLastName).sendKeys(lname);
        waitFor(sEmail).sendKeys(email);
        waitFor(sNewPassword).sendKeys(pword);
        waitFor(sConfirmPassword).sendKeys(pword);
        sCreateAccount.click();
    }
}