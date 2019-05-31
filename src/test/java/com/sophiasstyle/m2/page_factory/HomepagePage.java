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
    protected void goToLoginPage() {
        $x("//div[@class='panel header']//li[@class='authorization-link']").click();
    }

    @Step
    protected void login(String email, String password) {
        $x("//input[@name='login[username]']").setValue(email);
        $x("//input[@name='login[password]']").setValue(password);
        $x("//button[@class='action login primary']").click();
    }

    @Step
    protected void checkUserIsLoggedIn(){
        $x("//div[@class='panel header']//li[@class='greet welcome']").shouldHave(Condition.text("Welcome, Anna Test!"));
    }

    @Step
    protected void goToCategoryPage() {
        $x("//ul[@class='ui-menu ui-widget ui-widget-content ui-corner-all']/li[3]").click();
        System.out.println("Category page is opened");
    }

    @Step
    protected void goToSecondProductPage() {
        $("#page-title-heading").scrollTo().$("pre-footer-content");
        $x("//*[@class='item product product-item'][2]").hover();
        $x("//*[@class='item product product-item'][2]//h2").click();
        System.out.println("Product page is opened");
    }

    @Step
    protected void addProductToCart() {
        $x("//*[@id='product-addtocart-button']").click();
        System.out.println("Product is added");
    }

    @Step
    protected void goToShoppingCart() throws InterruptedException {
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
    protected void goToCheckoutPage() {
        $x("//*[@class='item']/button").click();
    }

    @Step
    protected void fillOutShippingInfo(String... strings) {
        int x = strings.length;
        if(x==9){
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
        else{
            $x("//input[@name='firstname']").setValue((strings[0]));
            $x("//input[@name='lastname']").setValue((strings[1]));
            $x("//input[@name='street[0]']").setValue((strings[2]));
            $x("//input[@name='city']").setValue((strings[3]));
            $x("//select[@name='region_id']").selectOption((strings[4]));
            $x("//input[@name='postcode']").setValue((strings[5]));
            $x("//select[@name='country_id']").selectOption((strings[6]));
            $x("//input[@name='telephone']").setValue((strings[7]));
        }

    }
}
