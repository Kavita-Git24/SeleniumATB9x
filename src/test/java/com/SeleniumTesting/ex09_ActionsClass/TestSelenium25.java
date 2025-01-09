package com.SeleniumTesting.ex09_ActionsClass;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium25 {
    EdgeDriver driver;
    @Description("Verify Open Browser")
    @BeforeTest
    public void open_browser(){
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver=new EdgeDriver(edgeOptions);
    }

    @Description("Verify actions")
    @Test
    public void test_actions() {
        String url="https://awesomeqa.com/practice.html";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement firstname = driver.findElement(By.name("firstname"));

         // Keyboard
        // KeyDown + Shift -> Send Keys(type) -> Key Up
        Actions actions=new Actions(driver);
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstname,"Aman")
                .keyUp(Keys.SHIFT).build().perform();
    }

    @Description("Verify close Browser")
    @AfterTest
    public void close_browser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }
}
