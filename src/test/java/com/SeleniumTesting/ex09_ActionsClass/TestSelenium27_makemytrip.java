package com.SeleniumTesting.ex09_ActionsClass;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestSelenium27_makemytrip {
    
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify actions")
    @Test
    public void test_actions() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[@data-cy='closeModal']")));

        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

         WebElement from_city = driver.findElement(By.id("fromCity"));


        // move to element
        // click
        // sendkeys - BLR
        Actions actions = new Actions(driver);
        actions
                .moveToElement(from_city)
                .click()
                .build().perform();

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait1.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//input[@placeholder='From']")));
        WebElement from= driver.findElement(By.xpath("//input[@placeholder='From']"));
        actions
                .moveToElement(from)
                .sendKeys("del")
                .build().perform();

        Thread.sleep(3000);

        actions
                .moveToElement(from)
                .keyDown(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .build().perform();

        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

        for(WebElement e : list_auto_complete){
            if(e.getText().contains("New Delhi")){
                e.click();
                break;
            }
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
