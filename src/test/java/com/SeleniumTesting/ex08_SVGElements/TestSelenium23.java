package com.SeleniumTesting.ex08_SVGElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium23 {
    @Description("Verify SVG Element on Flipkart")
    @Test
    public void test_SVGElement() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        //*[name()='svg']
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("macmini");
        List<WebElement> svgElements=driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(0).click();
        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }
}
