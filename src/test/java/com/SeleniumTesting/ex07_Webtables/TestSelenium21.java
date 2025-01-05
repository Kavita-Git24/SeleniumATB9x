package com.SeleniumTesting.ex07_Webtables;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21 {
    @Description("Verify Static Web Table ")
    @Test
    public void test_webtable() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();
        //table[@id='customers']/tbody/tr[2]
        int row=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
        /*System.out.println(row);
        System.out.println(col);*/

        //xpath - //table[@id="customers"]/tbody/tr[
        // i
        // ]/td[
        // j
        // ]

        String first="//table[@id='customers']/tbody/tr[";
        String second="]/td[";
        String third="]";
        for(int i=2;i<=row;i++){
            for(int j=1;j<=col;j++){
                String dynamic_path=first+i+second+j+third;
                //System.out.println(dynamic_path);
                String data=driver.findElement(By.xpath(dynamic_path)).getText();
               // System.out.println(data);
                if(data.contains("Helen Bennett")){
                    //table[@id='customers']/tbody/tr[5]/td[2]/following-sibling::td
                    String country_path=dynamic_path+"/following-sibling::td";
                    String country_text=driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("Helen Bennett is in - " +country_text);
                }
            }
        }


        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }
}
