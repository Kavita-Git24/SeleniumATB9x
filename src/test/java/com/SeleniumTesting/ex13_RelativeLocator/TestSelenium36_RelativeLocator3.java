package com.SeleniumTesting.ex13_RelativeLocator;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TestSelenium36_RelativeLocator3 {
    
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
        String URL = "https://www.aqi.in/real-time-most-polluted-city-ranking";
        driver.get(URL);
        driver.manage().window().maximize();


        List<WebElement> locations=driver.findElements(By.cssSelector("div.location-name>p"));
        
        for(WebElement e:locations){
            System.out.println(e.getText());
            String rank=driver.findElement(with(By.tagName("p")).toLeftOf(e)).getText();
            String AQI=driver.findElement(with(By.tagName("div")).toRightOf(e)).getText();

            System.out.println("| +" + rank +" | " + e.getText() + " | " + AQI + " | ");
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
