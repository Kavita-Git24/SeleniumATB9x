package com.SeleniumTesting.ex15_DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenTesting_Parallel {
    @DataProvider(name = "LoginData",parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass124"}
        };
    }
    @Test(dataProvider = "LoginData")
    public void loginTest(String email,String password)
    {
        System.out.println(email +" | "+password);
    }

    @DataProvider(name = "LoginData1",parallel = true)
    public Object[][] getData1() {
        return new Object[][]{
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass124"}
        };
    }
    @Test(dataProvider = "LoginData1")
    public void loginTest1(String email,String password)
    {
        System.out.println(email +" | "+password);
    }
}
