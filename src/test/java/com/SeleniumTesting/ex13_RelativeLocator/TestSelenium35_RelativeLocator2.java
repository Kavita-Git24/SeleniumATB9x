package com.SeleniumTesting.ex13_RelativeLocator;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TestSelenium35_RelativeLocator2 {
    
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify RelativeLocator")
    @Test
    public void test_RelativeLocator() throws InterruptedException {
        String URL = "https://codepen.io/AbdullahSajjad/full/LYGVRgK";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.switchTo().frame("result");
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();

        WebElement usernameinput=driver.findElement(By.id("username"));
        WebElement error_element = driver.findElement(with(By.tagName("small")).below(usernameinput));

        String error_text=error_element.getText();
        Assert.assertTrue(error_element.isDisplayed());
        Assert.assertEquals(error_text,"Username must be at least 3 characters");

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
