package com.letskodeit.teachable.ch25.testngannoasserts;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class TestNG_SoftAsserts {

    SomeClassToTest someClassToTest = new SomeClassToTest();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testSoftAssert() {
        int result = 0;
        result = someClassToTest.sumNumbers(-1, 1);

        softAssert.assertEquals(1, result);
        Assert.assertEquals(0, result);
        softAssert.assertAll();  //necessary to cause the test case to fail.

    }

    @Test
    public void testSoftAssertWithNoAssertAll() {
        int result = 0;
        result = someClassToTest.sumNumbers(-1, 1);

        softAssert.assertEquals(1, result);
        Assert.assertEquals(0, result);
        //softAssert.assertAll();  //necessary to cause the test case to fail.

    }

}
