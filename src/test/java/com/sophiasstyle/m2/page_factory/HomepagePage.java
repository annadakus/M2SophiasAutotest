package com.sophiasstyle.m2.page_factory;

import com.codeborne.selenide.Condition;
import com.sophiasstyle.m2.configure.BaseTest;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.*;

public class HomepagePage extends BaseTest {

    @Step
    protected void openHomePage() {

        open("https://m2.sophiasstyle.com");
    }

    @Step
    protected void openCategoryPage() {
        $x("//*[@class='megamenu level-top-sectioned  level0 nav-3 category-item level-top parent ui-menu-item']").click();
        System.out.println("Category page is opened");
    }

    @Step
    protected void openProductPage() {
        $("#page-title-heading").scrollTo().$("pre-footer-content");
        $x("//*[@class='item product product-item'][2]").hover();
        $x("//*[@class='item product product-item'][2]//h2").click();
        System.out.println("Product page is opened");

    }

    @Step
    protected void addToCart() {
        $x("//*[@id='product-addtocart-button']").click();
        //$("message-success success message").waitUntil(Condition.visible, 15000).shouldHave(Condition.text("You added "));
        System.out.println("Product is added");
    }

    @Step
    protected void openShoppingCart() throws InterruptedException {
        Thread.sleep(10000);
        $x("//*[@class='minicart-wrapper']").click();
        $x("//*[@class='action viewcart']").hover().click();
    }

    @Step
    protected void checkShoppingCart() {
        $x("//*[@class='action showcart']/span[last()]").shouldHave(Condition.text("1"));
        $(".page-title").shouldHave(Condition.text("Shopping Cart"));
    }

    @Step
    protected void openCheckoutPage() {
        $x("//*[@class='item']/button").click();

    }

    @Step
    protected void fillOutShippingInfo(String... strings) {
        $x("//div[@class='control _with-tooltip']//input[@name='username']").setValue((strings[0]));
        $x("//input[@name='firstname']").setValue((strings[1]));
        $x("//input[@name='lastname']").setValue((strings[2]));
        $x("//input[@name='street[0]']").setValue((strings[3]));
        $x("//input[@name='city']").setValue((strings[4]));
        $x("//select[@name='region_id']").selectOption((strings[5]));
        $x("//input[@name='postcode']").setValue((strings[6]));
        $x("//select[@name='country_id']").selectOption((strings[7]));
        $x("//input[@name='telephone']").setValue((strings[8]));


    }
}
