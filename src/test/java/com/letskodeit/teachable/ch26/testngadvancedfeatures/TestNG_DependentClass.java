package com.letskodeit.teachable.ch26.testngadvancedfeatures;

import com.letskodeit.teachable.ch25.testngannoasserts.SomeClassToTest;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Really this shouldn't be done, because the order of the tests should not matter.
 * They need to be completely independent.
 */
public class TestNG_DependentClass {

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
    @Test(dependsOnMethods = {"testPositiveSum", "testNegativeSum"})
    public void testSumOfZero() {
        int result = 0;
        result = someClassToTest.sumNumbers(-1, 1);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testNegativeSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, -2);

        Assert.assertEquals(1, result);
    }

    /**
     * This one is still ran because of the alwaysTrue flag.
     */
    @Test(dependsOnMethods = {"testNegativeSum"}, alwaysRun = true)
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
