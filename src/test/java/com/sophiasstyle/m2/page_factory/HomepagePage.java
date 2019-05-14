package com.sophiasstyle.m2.page_factory;

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
$("megamenu level-top-sectioned active level0 nav-3").click();
        System.out.println("Category is opened");
}

protected void openProductPage(){
$x("//*[@class='item product product-item'][2]").hover();
$x("//*[@class='item product product-item'][2]//h2").click();
    System.out.println("Product page is opened");

}


}
