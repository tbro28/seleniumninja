package com.letskodeit.teachable.ch27.parametersandparallel;

import com.letskodeit.teachable.ch25.testngannoasserts.SomeClassToTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class TestNG_TestParameters {

    SomeClassToTest someClassToTest;

    @BeforeMethod
    public void beforeMethod() {
        someClassToTest = new SomeClassToTest();
        System.out.println("------TEST CLASS 1 --- Before method.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("------TEST CLASS 1 --- After method.");
    }

    @Parameters({"browser", "platform"})
    @BeforeClass
    public void setUp(String browser, String platform) {

        System.out.println("-TEST CLASS 1 --- Before class.");
        System.out.println("Parameters: " + browser);
        System.out.println("Parameters: " + platform);
    }

    @AfterClass
    public void tearDown() {
        System.out.println("-TEST CLASS 1 --- After class.");
    }


    @Test
    @Parameters({"response"})
    public void testSumOfZero(String response) {
        int result = 0;

        System.out.println("Parameters: " + response);

        result = someClassToTest.sumNumbers(-1, 1);

        Assert.assertEquals(0, result);
    }


}
