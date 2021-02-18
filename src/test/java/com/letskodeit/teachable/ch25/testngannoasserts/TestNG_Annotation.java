package com.letskodeit.teachable.ch25.testngannoasserts;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Annotation {

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

    @BeforeClass
    public void setUp() {
        System.out.println("-TEST CLASS 1 --- Before class.");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("-TEST CLASS 1 --- After class.");
    }


    @Test
    public void testSumOfZero() {
        int result = 0;
        result = someClassToTest.sumNumbers(-1, 1);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testNegativeSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, -2);

        Assert.assertEquals(-1, result);
    }

    @Test
    public void testPositiveSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, 2);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testAddEmptyStrings() {
        String result = null;
        result = someClassToTest.addStrings("", "");

        Assert.assertTrue(result.equals(" "));
    }

    @Test
    public void testAddSingleCharacterStrings() {
        String result = null;
        result = someClassToTest.addStrings("a", "b");

        Assert.assertTrue(result.equals("a b"));
    }

    @Test
    public void testArray() {
        int[] result = {1, 2, 3};

        Assert.assertEquals(result, someClassToTest.getArray());
    }

}
