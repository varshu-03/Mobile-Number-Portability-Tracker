package com.veritel.utils;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.veritel.tests.CSVDataReader;

import java.util.List;

public class LoginPage {
   
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        String filePath = "src/test/resources/data.csv";
        List<String[]> records = CSVDataReader.readCSV(filePath);

        Object[][] data = new Object[records.size()][3];
        for (int i = 0; i < records.size(); i++) {
            data[i][0] = records.get(i)[0]; 
            data[i][1] = records.get(i)[1]; // password
            data[i][2] = records.get(i)[2]; // expected result (Success/Failure)
        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedResult) {
        System.out.println("Testing login with Username: " + username + " | Password: " + password);

        String actualResult;
        if (username.equals("admin") && password.equals("admin123")) {
            actualResult = "Success";
        } else {
            actualResult = "Failure";
        }
 

        Assert.assertEquals(actualResult, expectedResult,
                "Login result mismatch for user: " + username);
    }
}

