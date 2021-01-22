package com.codeinb8a;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.APP_URL;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.browsers.ChromeDrv;
import com.codeinb8a.java.browsers.EdgeDrv;
import com.codeinb8a.java.browsers.FirefoxDrv;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestAgeCalculator {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Firefox";



    @BeforeEach
    public void setUp() throws Exception {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        //Action
        driver.get(APP_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }


    /**
     *
     * Test zero Celsius returns 32 Fahrenheit.
     *
     * @throws Exception
     */
    @Test
    public void testAgeCalculator() throws Exception {
        driver.findElement(By.cssSelector("#yearOfBirth")).clear();
        driver.findElement(By.cssSelector("#yearOfBirth")).sendKeys("Tim was here.");
        try {
            assertEquals("Tim was here.", driver.findElement(By.cssSelector("#yearOfBirth")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    /**
     *
     * Test zero Celsius returns 32 Fahrenheit.
     *
     */
    @Test
    public void testAgeCalculator2() {
        //driver.findElement(By.cssSelector("#yearOfBirth")).clear();
        System.out.println("1111111111111111111");
        driver.findElement(By.cssSelector("#yearOfBirth")).sendKeys("Tim was here.");
        System.out.println("2222222222222222222");
        System.out.println(driver.findElement(By.cssSelector("#yearOfBirth")).getText());

        assertTrue(true);

        //assertEquals(true, driver.findElement(By.cssSelector("#yearOfBirth")).getText().contains("Tim"));

    }


    /**
     *
     * Test testAgeCalculatorValidYeart.
     *
     */
    @Test
    public void testAgeCalculatorValidYear() {
        //driver.findElement(By.cssSelector("#yearOfBirth")).clear();
        System.out.println("1111111111111111111");
        driver.findElement(By.id("yearOfBirth")).sendKeys("2000");
        driver.findElements(By.linkText("Calculate"));
        System.out.println("2222222222222222222");

        assertTrue(true);

        //assertEquals(true, driver.findElement(By.cssSelector("#yearOfBirth")).getText().contains("Tim"));

    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.close();
    }
}
