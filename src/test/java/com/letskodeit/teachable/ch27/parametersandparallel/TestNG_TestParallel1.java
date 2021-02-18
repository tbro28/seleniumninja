package com.letskodeit.teachable.ch27.parametersandparallel;

import com.codeinb8a.java.utilities.GlobalActions;
import com.letskodeit.teachable.ch25.testngannoasserts.SomeClassToTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_TestParallel1 {

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

    @Test
    public void test1() throws InterruptedException {
        int result = 0;
        System.out.println("Test Class 1 - Test 1");
        GlobalActions.waitForSeconds(5);
        result = someClassToTest.sumNumbers(-1, 1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test2() throws InterruptedException {
        int result = 0;
        System.out.println("Test Class 1 - Test 2");
        GlobalActions.waitForSeconds(2);
        result = someClassToTest.sumNumbers(-1, 1);
        Assert.assertEquals(0, result);
    }


}
