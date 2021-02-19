package com.letskodeit.teachable.ch23.log4j2.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codeinb8a.java.utilities.GlobalVariables.*;


/**
 * Logging.
 *
 */
public class LoggingTestCase {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Firefox";
    private GenericMethods gm;
    private WaitTypes wt;
    JavascriptExecutor jse;
    private LocalDate localDate = LocalDate.now();
    private static final Logger log = LogManager.getLogger(LoggingTestCase.class.getName());

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
     * <p>
     * Hidden Element
     * Timing issues
     * Element is in an iFrame
     */
    @Test
    public void testNoSuchElement() throws InterruptedException {

        /**Logging test.*/
        log.trace("Tim's Trace messaged logged.");
        log.debug("Tim's Debug messaged logged.");
        log.info("Tim's Info messaged logged.");
        log.error("Tim's Error messaged logged.");
        log.fatal("Tim's Fatal messaged logged.");


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

}