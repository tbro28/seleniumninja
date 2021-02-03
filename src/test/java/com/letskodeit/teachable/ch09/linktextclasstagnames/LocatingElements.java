package com.letskodeit.teachable.ch09.linktextclasstagnames;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.HOMEKODE_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocatingElements {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";

    @BeforeEach
    public void setUp() {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        //Action
        driver.get(HOMEKODE_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    /**
     *
     * Test navigation page.
     *
     */
    @Test
    public void testDropDownElements() throws InterruptedException {

        WebElement loginLink = driver.findElement(By.linkText("Login"));

        loginLink.click();
        GlobalActions.waitForSeconds(2);

        WebElement forgotPassword = driver.findElement(By.partialLinkText("got"));

        forgotPassword.click();
        GlobalActions.waitForSeconds(2);

        assertEquals("Reset Password", (driver.findElement(By.cssSelector(".content-box > h1:nth-child(1)")).getText()));

    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

