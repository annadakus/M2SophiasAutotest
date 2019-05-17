package com.sophiasstyle.m2.page_factory;

import com.codeborne.selenide.Condition;
import com.sophiasstyle.m2.configure.BaseTest;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.*;

public class HomepagePage extends BaseTest {

    @Step
    protected void openHomePage(){

        open ("https://m2.sophiasstyle.com");
    }

    @Step
    protected void openCategoryPage(){
$x("//*[@class='megamenu level-top-sectioned  level0 nav-3 category-item level-top parent ui-menu-item']").click();
        System.out.println("Category page is opened");
}

@Step
protected void openProductPage(){
        $("#page-title-heading").scrollTo().$("pre-footer-content");
$x("//*[@class='item product product-item'][2]").hover();
$x("//*[@class='item product product-item'][2]//h2").click();
    System.out.println("Product page is opened");

}
@Step
protected void addToCart(){
$x("//*[@id='product-addtocart-button']").click();
//$("message-success success message").waitUntil(Condition.visible, 15000).shouldHave(Condition.text("You added "));
    System.out.println("Product is added");
}

@Step
protected void openShoppingCart(){
        $x("//*[@class='minicart-wrapper']").click();
        $("//*[@class='action viewcart']").click();
}

@Step
protected void checkShoppingCart(){
    $("counter-number").shouldHave(Condition.text("1"));
    $(".page-title").shouldHave(Condition.text("Shopping Cart"));
}
//@Step
//    protected void openCheckoutPage(){
//
//}
}
