package com.SeleniumTesting.ex15_DataDrivenTesting;

import org.testng.annotations.Test;

public class DataDrivenExcel {
    @Test(dataProvider = "getExcelData",dataProviderClass = UtilExcel.class)
    public void test_VWOLogin(String email,String password)
    {
        System.out.println("Email - "+email);
        System.out.println("Password - " +password);
    }

}