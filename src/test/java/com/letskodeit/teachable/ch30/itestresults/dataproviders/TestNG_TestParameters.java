package com.letskodeit.teachable.ch30.itestresults.dataproviders;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import com.letskodeit.teachable.ch25.testngannoasserts.SomeClassToTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.HOMEKODE_URL;


public class TestNG_TestParameters {

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
    public void beforeTest() {
        System.out.println("**********Before test.");
        System.out.println("Browser to use: " + "Firefox");
        driver = BrowserSetup.setBrowserDetails("Firefox", headless);

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

}
