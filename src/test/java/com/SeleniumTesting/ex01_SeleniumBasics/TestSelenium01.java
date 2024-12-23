package com.SeleniumTesting.ex01_SeleniumBasics;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Test
    public void test_Selenium()
    {
        EdgeDriver edgeDriver=new EdgeDriver();
        edgeDriver.get("https://app.vwo.com");
        System.out.println(edgeDriver.getTitle());
    }


}
