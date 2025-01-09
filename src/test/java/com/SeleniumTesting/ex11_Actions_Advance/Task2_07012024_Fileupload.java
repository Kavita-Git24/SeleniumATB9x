package com.SeleniumTesting.ex11_Actions_Advance;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2_07012024_Fileupload {
    
    ChromeDriver driver;

    @BeforeTest
    public void openBrowser(){
       ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
       driver = new ChromeDriver(chromeOptions);

    }

    @Description("Verify File upload")
    @Test
    public void test_uploadfile() throws InterruptedException {

        String URL = "https://www.browserstack.com/users/sign_in";
        //String URL = "https://app-automate.browserstack.com/dashboard/v2/getting-started";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.id("user_email_login")).sendKeys("rinutesting21@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("Browser@10");
        driver.findElement(By.id("user_submit")).click();

        /*WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated
                                (By.xpath("//div[text()='Get Started']")));

        driver.findElement(By.xpath("//div[text()='Get Started']")).click();*/
        /*String URL = "https://app-automate.browserstack.com/dashboard/v2/getting-started";
        driver.get(URL);
        driver.manage().window().maximize();*/

        /*WebElement uploadFileInput=driver.findElement(By.id("file"));
        String working_dir=System.getProperty("user.dir");
        System.out.println(working_dir);
        //Task1_07012024_Fileupload

        uploadFileInput.sendKeys(working_dir+"/src/test/java/com/SeleniumTesting/ex11_Actions_Advance/example.apk");
      //  driver.findElement(By.id("file-submit")).click();

//        <div class="text-container">example.apk</div>

        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-container']")));
        String success_msg= driver.findElement(By.xpath("//div[@class='text-container']")).getText();
        Assert.assertEquals(success_msg,"example.apk");*/
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
