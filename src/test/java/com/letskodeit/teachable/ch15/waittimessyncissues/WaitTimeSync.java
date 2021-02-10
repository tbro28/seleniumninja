package com.letskodeit.teachable.ch15.waittimessyncissues;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GenericMethods;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import com.codeinb8a.java.utilities.WaitTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;

public class WaitTimeSync {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";
    private GenericMethods gm;
    private WaitTypes wt;

    @BeforeEach
    public void setUp() {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        gm = new GenericMethods(driver);


        wt = new WaitTypes(driver);

        //Action
        driver.get(KODE_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    /**
     *
     * Test page.
     *
     */
    @Test
    public void WaitTimeSync() throws InterruptedException {


        driver.findElement(By.linkText("Login")).click();
//        driver.findElement(By.id("user_email")).wait(5000);
        driver.findElement(By.id("user_email")).sendKeys("test");

        GlobalActions.waitForSeconds(3);

    }

    /**
     *
     * Test page.
     *
     */
    @Test
    public void ExplicitWaits() throws InterruptedException {

        driver.findElement(By.linkText("Login")).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);

        WebElement emailField = wait.until((ExpectedConditions
                .visibilityOfElementLocated(By.id("user_email"))));

        emailField.sendKeys("test");

        GlobalActions.waitForSeconds(3);
    }

    /**
     *
     * Test page.
     *
     */
    @Test
    public void ExplicitWaitGeneric() throws InterruptedException {

        driver.findElement(By.linkText("Login")).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField = wt.waitForElement(By.id("user_email"), 3);
        emailField.sendKeys("test");

        wt.clickWhenReady(By.id(""), 3);

        GlobalActions.waitForSeconds(3);
    }


    /**
     *
     * Test page.
     *
     */
    @Test
    public void ClickWhenReadyGeneric() throws InterruptedException {


        driver.findElement(By.linkText("Login")).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField = wt.waitForElement(By.id("user_email"), 3);
        emailField.sendKeys("test");


        wt.clickWhenReady(By.name("commit"), 3);

        GlobalActions.waitForSeconds(3);
    }





    @AfterEach
    public void tearDown() {
        //driver.close();
    }

}

