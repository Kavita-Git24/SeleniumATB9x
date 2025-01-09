package com.SeleniumTesting.ex11_Actions_Advance;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1_07012024_Fileupload {
    
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
        String URL = "https://the-internet.herokuapp.com/upload";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement uploadFileInput= driver.findElement(By.id("file-upload"));
        String working_dir=System.getProperty("user.dir");
        System.out.println(working_dir);

        uploadFileInput.sendKeys(working_dir+"/src/test/java/com/SeleniumTesting/ex11_Actions_Advance/DataUpload.txt");
        driver.findElement(By.id("file-submit")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='File Uploaded!']")));
        String success_msg= driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
        Assert.assertEquals(success_msg,"File Uploaded!");
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
