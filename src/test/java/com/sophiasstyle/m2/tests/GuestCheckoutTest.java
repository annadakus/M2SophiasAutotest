package com.sophiasstyle.m2.tests;

import com.sophiasstyle.m2.page_factory.HomepagePage;
import org.junit.Test;

public class GuestCheckoutTest extends HomepagePage {

    @Test
    public void guestCheckoutTest() {
        openHomePage();
        openCategoryPage();
        openProductPage();
        addToCart();
        openShoppingCart();
        checkShoppingCart();
    }

}
