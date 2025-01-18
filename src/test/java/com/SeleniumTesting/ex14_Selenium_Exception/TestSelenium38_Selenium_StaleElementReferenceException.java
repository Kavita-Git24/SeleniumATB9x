package com.SeleniumTesting.ex14_Selenium_Exception;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class TestSelenium38_Selenium_StaleElementReferenceException {
    
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify Selenium NoSuchElement")
    @Test
    public void test_Selenium_Exception() {
        String URL = "https://google.com";
        driver.get(URL);
        driver.manage().window().maximize();
        try {
        WebElement search_inputbox  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        driver.navigate().refresh();
        // HTML Page (DOM) is not refreshed,
        // Driver will think that, element may or may not available now.
        // I have found the element before refresh.

        // Refresh, Navigate other Page, change in DOM elements (Ajax Calls) - VueJS, AngularJS

        search_inputbox.sendKeys("thetestingacademy"+ Keys.ENTER);
    } catch (StaleElementReferenceException e) {
        System.out.println(e.getMessage());
    }
    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
