package com.sophiasstyle.m2.tests;

import com.sophiasstyle.m2.page_factory.HomepagePage;
import org.junit.Test;

public class GuestCheckoutTest extends HomepagePage {

    @Test
    public void guestCheckoutTest() throws InterruptedException {
        openHomePage();
        goToCategoryPage();
        goToSecondProductPage();
        addProductToCart();
        goToShoppingCart();
        checkShoppingCart();
        goToCheckoutPage();
        fillOutShippingInfo("anna@ecomitize.com", "Anna", "Test",
                "7 Test street", "Test", "Nebraska", "68138",
                "United States", "123456789");
    }
}
