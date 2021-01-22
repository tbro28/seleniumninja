package com.beginningselenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.APP_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.LINK_URL;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.browsers.ChromeDrv;
import com.codeinb8a.java.browsers.EdgeDrv;
import com.codeinb8a.java.browsers.FirefoxDrv;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestFindByLinkText {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";



    @BeforeEach
    public void setUp() throws Exception {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        //Action
        driver.get(LINK_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }


    /**
     *
     * Test zero Celsius returns 32 Fahrenheit.
     *
     * @throws Exception
     */
    @Test
    public void testDealsPage() throws Exception {

        driver.findElement(By.linkText("Deals")).click();

        GlobalActions.waitForSeconds(3);

        assertEquals("Out of money?", driver.findElement(By.id("mainInfo")).getText());

    }

    /**
     *
     * Test zero Celsius returns 32 Fahrenheit.
     *
     * @throws Exception
     */
    @Test
    public void testProductsPage() throws Exception {

        driver.findElement(By.linkText("Deals")).click();

        GlobalActions.waitForSeconds(3);

        driver.findElement(By.partialLinkText("products")).click();

        GlobalActions.waitForSeconds(3);

        assertTrue(driver.findElement(By.id("mainInfo")).getText().contains("stuff we sell"));

    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.close();
    }
}
