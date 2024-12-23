package com.SeleniumTesting.ex04_Selenium_Options_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium16 {
    @Description("Options Class")
    @Test
    public void test_Selenium01() throws Exception{
        // EdgeOptions, ChromeOptions, FirefoxOptions, SafariOptions
        EdgeOptions edgeOptions = new EdgeOptions();



        edgeOptions.addArguments("--window-size=1280,720");
        edgeOptions.addExtensions(new File("src/test/java/com/SeleniumTesting/ex04_Selenium_Options_Locators/adblocker.crx"));

//      Proxy proxy = new Proxy();
//      proxy.setHttpProxy("188.255.245.205:1080");
//      edgeOptions.setCapability("proxy", proxy);

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");

        Thread.sleep(35000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }
}
