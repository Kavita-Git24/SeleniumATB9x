package com.SeleniumTesting.ex07_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium22 {
    @Description("Verify Dynamic Web Table having incomplete columns")
    @Test
    public void test_webtable() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        // Find the xPath for the WebTable
        // -> //table[@summary="Sample Table"]
        WebElement table=driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        // rows and columns
        List<WebElement> row_tables=table.findElements(By.tagName("tr"));
        for(int i=0;i<row_tables.size();i++)
        {
            List<WebElement> col=row_tables.get(i).findElements(By.tagName("td"));
            for(WebElement data:col){
                System.out.println(data.getText());
            }
        }

        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }
}
