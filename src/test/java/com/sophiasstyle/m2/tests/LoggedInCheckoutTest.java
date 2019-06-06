package com.sophiasstyle.m2.tests;

import com.sophiasstyle.m2.page_factory.HomepagePage;
import org.junit.Test;

public class LoggedInCheckoutTest extends HomepagePage {

    @Test
    public void loggedInCheckoutTest() throws InterruptedException{
        openHomePage();
        goToLoginPage();
        login("anna@ecomitize.com", "1111abcd1111Q");
        checkUserIsLoggedIn();
        goToCategoryPage();
        goToSecondProductPage();
        addProductToCart();
        goToShoppingCart();
        checkShoppingCart();
        goToCheckoutPage();
        fillOutShippingInfo("Anna", "Test",
                "7 Test street", "Test", "Nebraska", "68138",
                "United States", "123456789");
    }
}
