package com.letskodeit.teachable.ch26.testngadvancedfeatures;

import com.letskodeit.teachable.ch25.testngannoasserts.SomeClassToTest;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Really this shouldn't be done, because the order of the tests should not matter.
 * They need to be completely independent.
 */
public class TestNG_Priority {

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


    @Test(priority=100)
    public void testSumOfZero() {
        int result = 0;
        result = someClassToTest.sumNumbers(-1, 1);

        Assert.assertEquals(0, result);
    }

    @Test(priority=100)
    public void testNegativeSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, -2);

        Assert.assertEquals(-1, result);
    }

    @Test(priority=50)
    public void testPositiveSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, 2);

        Assert.assertEquals(3, result);
    }

    @Test(priority=50)
    public void testAddEmptyStrings() {
        String result = null;
        result = someClassToTest.addStrings("", "");

        Assert.assertTrue(result.equals(" "));
    }

    @Test(priority=1)
    public void testAddSingleCharacterStrings() {
        String result = null;
        result = someClassToTest.addStrings("a", "b");

        Assert.assertTrue(result.equals("a b"));
    }

    @Test(priority=1)
    public void testArray() {
        int[] result = {1, 2, 3};

        Assert.assertEquals(result, someClassToTest.getArray());
    }

}
