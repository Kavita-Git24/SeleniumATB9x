package com.SeleniumTesting.ex07_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/*Login - https://awesomeqa.com/hr/web/index.php/auth/login

Username : admin

Password : Hacker@4321

URL -

https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList*/
public class TestTask3Dec_employee {
    WebDriver driver;
    @Description("Login Employee")
    @BeforeTest
    public void test_employee_Login() throws Exception {

        driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        WebElement usernameInputBox=driver.findElement(By.name("username"));
        usernameInputBox.sendKeys("admin");
        WebElement passwordInputBox=driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

    }
    @Description("Verify Employee table")
    @Test
    public void test_employee_table() throws Exception {

        //div[contains(@class,'employee-list')]//div[contains(@class,'table-card')]
        Thread.sleep(5000);
        WebElement webtable=driver.findElement(By.xpath("//div[contains(@class,'employee-list')]/div[2]"));
        List<WebElement> row_table=webtable.findElements(By.tagName("div"));
        for(int i =0; i<row_table.size();i++){
            List<WebElement> col=row_table.get(i).findElements(By.tagName("div"));
            for(WebElement data:col){
                String col_data= data.getText();
                /*if(col_data.contains("Terminated")){
                    System.out.println(data.getText());
                }*/
            }
        }

    }
    @Description("Verify close browser")
    @AfterTest
    public void test_close_browser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
