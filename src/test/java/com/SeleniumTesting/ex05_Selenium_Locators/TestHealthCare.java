package com.SeleniumTesting.ex05_Selenium_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestHealthCare {
    @Description("Verify that current url")
    @Test
    public void test_url() throws Exception{
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement btn_appointment = driver.findElement(By.id("btn-make-appointment"));
        btn_appointment.click();

        WebElement usernameInputbox = driver.findElement(By.id("txt-username"));
        usernameInputbox.sendKeys("John Doe");


        WebElement passwordInputbox = driver.findElement(By.id("txt-password"));
        passwordInputbox.sendKeys("ThisIsNotAPassword");

        WebElement btnLogin=driver.findElement(By.id("btn-login"));
        btnLogin.click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://katalon-demo-cura.herokuapp.com/#appointment");

        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null

    }
}
