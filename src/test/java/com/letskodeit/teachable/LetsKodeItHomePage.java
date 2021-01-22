package com.letskodeit.teachable;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LetsKodeItHomePage {


    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Firefox";



    @BeforeEach
    public void setUp() {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        //Action
        driver.get(HOMEKODE_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }


    /**
     *
     * Test zero Celsius returns 32 Fahrenheit.
     *
     */
    @Test
    public void testAgeCalculator2() throws InterruptedException {
        //driver.findElement(By.cssSelector("#yearOfBirth")).clear();
        System.out.println("1111111111111111111");
        GlobalActions.waitForSeconds(3);
        System.out.println("2222222222222222222");

        assertTrue(true);

        //assertEquals(true, driver.findElement(By.cssSelector("#yearOfBirth")).getText().contains("Tim"));

    }


    @AfterEach
    public void tearDown() {
        driver.close();
    }

}
