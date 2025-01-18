package com.SeleniumTesting.ex14_Selenium_Exception;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium40_Selenium_TimeOutException {
    
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify TimeOut Exception")
    @Test
    public void test_Selenium_TimeOutException() {
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

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='APjFqb']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='abc']")));

            WebElement search_inputbox1  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
            search_inputbox1.sendKeys("thetestingacademy"+ Keys.ENTER);
    } catch (TimeoutException e) {
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
