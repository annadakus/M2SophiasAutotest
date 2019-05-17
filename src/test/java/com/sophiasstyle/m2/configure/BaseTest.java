package com.sophiasstyle.m2.configure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {

    @Before
    public void setUp (){
        Configuration.timeout = 50000;
    }


    @After
    public void clearLocalStorage(){
        Selenide.executeJavaScript("localStorage.clear()");
    }

    @After
    public void clearCache(){
        clearBrowserCache();
    }

    @After
    public void clearCookieTest() {

        clearBrowserCookies();
    }

    @After
    public void tearDown() throws IOException {
        File lastSelenideScreenshot = Screenshots.getLastScreenshot();
        if (lastSelenideScreenshot != null) {
            screenshot(Files.toByteArray(lastSelenideScreenshot));
        }
    }

    @Attachment(type = "image/png")
    public static byte[] screenshot(byte[] dataForScreenshot) {

        return dataForScreenshot;
    }

}
