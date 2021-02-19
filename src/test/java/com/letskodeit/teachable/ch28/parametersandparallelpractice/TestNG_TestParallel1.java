package com.letskodeit.teachable.ch28.parametersandparallelpractice;

import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.browsers.BrowserSetup;

import com.codeinb8a.java.utilities.GlobalVariables;
import com.letskodeit.teachable.ch25.testngannoasserts.SomeClassToTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.HOMEKODE_URL;


public class TestNG_TestParallel1 {

    SomeClassToTest someClassToTest;

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = true;
    private String browserDriver = "Chrome";


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
    @Parameters({"browser"})
    public void beforeTest(String browser) {
        System.out.println("**********Before test.");
        System.out.println("Browser to use: " + browser);
        driver = BrowserSetup.setBrowserDetails(browser.strip(), headless);

        //Action
        driver.get(HOMEKODE_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

    }

    @AfterClass
    public void afterTest() {
        System.out.println("**********After test.");
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        int result = 0;

        driver.get("https://www.google.com");

        GlobalActions.waitForSeconds(2);

        result = someClassToTest.sumNumbers(-1, 1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test2() throws InterruptedException {
        int result = 0;

        driver.get("https://www.google.com");

        GlobalActions.waitForSeconds(2);

        result = someClassToTest.sumNumbers(-1, 1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test3() throws InterruptedException {
        int result = 0;

        driver.get("https://www.google.com");

        GlobalActions.waitForSeconds(2);

        result = someClassToTest.sumNumbers(-1, 1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test4() throws InterruptedException {
        int result = 0;

        driver.get("https://www.google.com");

        GlobalActions.waitForSeconds(2);

        result = someClassToTest.sumNumbers(-1, 1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test5() throws InterruptedException {
        int result = 0;

        driver.get("https://www.google.com");

        GlobalActions.waitForSeconds(2);

        result = someClassToTest.sumNumbers(-1, 1);
        Assert.assertEquals(0, result);
    }

}
