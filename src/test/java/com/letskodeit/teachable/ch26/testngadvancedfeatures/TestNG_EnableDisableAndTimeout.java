package com.letskodeit.teachable.ch26.testngadvancedfeatures;

import com.letskodeit.teachable.ch25.testngannoasserts.SomeClassToTest;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Timeouts used for when a known bug is submitted, but not fixed.
 * As a result, the related tests are failing,
 * but you don't want them blocking / showing up in every report.
 *
 * So you need to temporarily disable the test case.
 *
 */
public class TestNG_EnableDisableAndTimeout {

    SomeClassToTest someClassToTest;

    @BeforeClass
    public void setUp() {
        someClassToTest = new SomeClassToTest();
        System.out.println("-TEST CLASS 1 --- Before class.");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("-TEST CLASS 1 --- After class.");
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("------TEST CLASS 1 --- Before method.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("------TEST CLASS 1 --- After method.");
    }


    /**
     * This gets skipped because testNegativeSum is failing.
     */
    @Test
    public void testSumOfZero() {
        int result = 0;
        result = someClassToTest.sumNumbers(-1, 1);

        Assert.assertEquals(0, result);
    }

    @Test(enabled=false)
    public void testNegativeSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, -2);

        Assert.assertEquals(1, result);
    }

    /**
     * This one is still ran because of the alwaysTrue flag.
     */
    @Test(dependsOnMethods = {"testNegativeSum"}, alwaysRun = true, enabled = false)
    public void testPositiveSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, 2);

        Assert.assertEquals(3, result);
    }

    /**
     * This should likely fail with a timeout of 10 milliseconds.
     */
    @Test(timeOut = 10)
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
