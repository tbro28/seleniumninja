package com.letskodeit.teachable.ch21.elementexceptions;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GenericMethods;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import com.codeinb8a.java.utilities.WaitTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import com.codeinb8a.java.browsers.BrowserSetup;
        import com.codeinb8a.java.utilities.GenericMethods;
        import com.codeinb8a.java.utilities.GlobalActions;
        import com.codeinb8a.java.utilities.GlobalVariables;
        import com.codeinb8a.java.utilities.WaitTypes;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.*;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
        import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Different ways to find windows and popups (18).
 *
 */
public class NoSuchElementException {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Firefox";
    private GenericMethods gm;
    private WaitTypes wt;
    JavascriptExecutor jse;

    private LocalDate localDate = LocalDate.now();

    @BeforeEach
    public void setUp() {
        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);
        gm = new GenericMethods(driver);
        wt = new WaitTypes(driver);
        driver.get(KODE_URL);

        jse = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        //driver.close();
        driver.quit();
    }

    /**
     * Test reasons for no such element found.
     *
     * Hidden Element
     * Timing issues
     * Element is in an iFrame
     *
     */
    @Test
    public void testNoSuchElement() throws InterruptedException {

        /**Setup.*/
        driver.get("https://letskodeit.teachable.com/");

        //Timing issues
        //Needs an implicit wait time.
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();

        WebElement emailField = driver.findElement(By.id("user_email"));
        emailField.sendKeys("testing");

        //Or use an explicit wait
        driver.findElement(By.xpath("//img[@alt=\"Let's Kode It\"]")).click();
        if (DEBUG) GlobalActions.waitForSeconds(3);
        driver.findElement(By.xpath("//a[contains(@href,'/sign_in')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        emailField2.sendKeys("testing2");

        if (DEBUG) GlobalActions.waitForSeconds(3);

        //Element in an iFrame
    }

    /**
     * Test reasons for element not clickable.
     *
     * Tricky to solve.
     *
     */
    @Test
    public void testElementNotClickable() throws InterruptedException {

        /**Setup.*/

        /*
        See OneNote
        Element is overlapped by another element, so you either:
        Wait for the overlapping element to become invisible, so that you
        can click the element you want.
        OR you can use JS to execute the click.

        The first option is more realistic.
        */
    }

    /**
     * Test reasons for stale element exception.
     *
     * Basically you find an element(s).
     * Do some other interactions that cause the DOM to change or reload.
     * When you try and access the previously found elements, they are now stale.
     *
     */
    @Test
    public void testStaleElementException() throws InterruptedException {

        /**Setup.*/
        //driver.get("https://letskodeit.teachable.com/");

        //Timing issues
        //Needs an implicit wait time.

        WebElement checkboxElement = driver.findElement(By.id("bmwcheck"));
        driver.get(driver.getCurrentUrl());
        checkboxElement = driver.findElement(By.id("bmwcheck"));
        checkboxElement.click();

        if (DEBUG) GlobalActions.waitForSeconds(3);

        //Element in an iFrame
    }



}
