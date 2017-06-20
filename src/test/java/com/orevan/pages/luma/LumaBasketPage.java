package com.orevan.pages.luma;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Created by tolaf on 20/08/2016.
 */
public class LumaBasketPage extends PageObject {

    protected By basketQTY = By.cssSelector(".control.qty>input");
    protected By basketCheckout = By.cssSelector(".cart-summary>ul>li>button.action.primary.checkout");
}
