package com.letskodeit.teachable.ch26.testngadvancedfeatures;

import com.letskodeit.teachable.ch26.testngadvancedfeatures.SomeClassToTest;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Really this shouldn't be done, because the order of the tests should not matter.
 * They need to be completely independent.
 */
public class TestNG_Grouping {

    SomeClassToTest someClassToTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {

        someClassToTest = new SomeClassToTest();

        System.out.println("------TEST CLASS 1 --- Before method.");
    }

    private SomeClassToTest getSomeClassToTest() {
        return new SomeClassToTest();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("------TEST CLASS 1 --- After method.");
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.out.println("-TEST CLASS 1 --- Before class.");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        System.out.println("-TEST CLASS 1 --- After class.");
    }


    @Test(groups={"addition", "smoke"})
    public void testSumOfZero() {
        int result = 0;
        result = someClassToTest.sumNumbers(-1, 1);

        Assert.assertEquals(0, result);
    }

    @Test(groups={"addition"})
    public void testNegativeSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, -2);

        Assert.assertEquals(-1, result);
    }

    @Test(groups={"addition"})
    public void testPositiveSum() {
        int result = 0;
        result = someClassToTest.sumNumbers(1, 2);

        Assert.assertEquals(3, result);
    }

    @Test(groups={"string", "smoke"})
    public void testAddEmptyStrings() {
        String result = null;
        result = someClassToTest.addStrings("", "");

        Assert.assertTrue(result.equals(" "));
    }

    @Test(groups={"string"})
    public void testAddSingleCharacterStrings() {
        String result = null;
        result = someClassToTest.addStrings("a", "b");

        Assert.assertTrue(result.equals("a b"));
    }

    @Test(groups={"array", "smoke"})
    public void testArray() {
        int[] result = {1, 2, 3};

        Assert.assertEquals(result, someClassToTest.getArray());
    }

}
