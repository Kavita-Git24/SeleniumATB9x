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

public class TestSelenium39_Selenium_StaleElementReferenceException_AcutalFix {
    
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify Stale Element Reference Exception")
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

            // If you want to fix the stale element exp - refind the element after DOM changes)
            //search_inputbox  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        search_inputbox  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
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
