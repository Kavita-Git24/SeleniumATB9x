package com.SeleniumTesting.ex06_Selenium_Xpath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Open the https://www.idrive360.com/enterprise/login

Enter the credentials

email - augtest_040823@idrive.com

password - 123456

Verify that the free trial message is visible.*/

public class TestSeleniumTask_31122024 {
    @Description("Verify that with valid email, pass, trial message is shown on the test_idrive_login ")
    @Test
    public void test_idrive_login() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");

        Thread.sleep(5000);
        WebElement inputbox_email= driver.findElement(By.xpath("//input[contains(@id,'username')]"));
        //WebElement inputbox_email= driver.findElement(By.id("username"));
        inputbox_email.sendKeys("augtest_040823@idrive.com");

        WebElement inputbox_password= driver.findElement(By.xpath("//input[contains(@id,'password')]"));
        inputbox_password.sendKeys("123456");

        Thread.sleep(3000);
        WebElement btn_Submit=driver.findElement(By.xpath("//button[text()='Sign in']"));
        btn_Submit.click();

        Thread.sleep(25000);

        WebElement h5_label=driver.findElement(By.xpath("//h5[text()='Your free trial has expired']"));

        Assert.assertEquals(h5_label.getText(),"Your free trial has expired");

        Thread.sleep(5000);
        driver.quit();
    }
}
