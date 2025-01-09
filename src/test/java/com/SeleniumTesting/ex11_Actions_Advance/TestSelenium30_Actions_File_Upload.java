package com.SeleniumTesting.ex11_Actions_Advance;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSelenium30_Actions_File_Upload {
    
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify File upload")
    @Test
    public void test_windows() throws InterruptedException {
        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement uploadFileInput= driver.findElement(By.id("fileToUpload"));
        String working_dir=System.getProperty("user.dir");
        System.out.println(working_dir);

        uploadFileInput.sendKeys(working_dir+"/src/test/java/com/SeleniumTesting/ex11_Actions_Advance/DataUpload.txt");
        driver.findElement(By.name("submit")).click();
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
