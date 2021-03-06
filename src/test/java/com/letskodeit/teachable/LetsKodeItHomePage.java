package com.letskodeit.teachable;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LetsKodeItHomePage {


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
    public void testNavigationPractice() throws InterruptedException {
        System.out.println(driver.getTitle());
        GlobalActions.waitForSeconds(3);

        assertTrue(driver.getTitle().contains("Home"));

        driver.findElement(By.xpath("//ul[starts-with(@class, 'nav')]//a[contains(@href, 'practice')]")).click();

        if(!driver.findElement(By.xpath("//h1[contains(text(), 'Practice')]")).isDisplayed())
            GlobalActions.waitForSeconds(1);

        assertTrue(driver.getTitle().contains("Practice"));

        driver.navigate().back();

        assertTrue(driver.getTitle().contains("Home"));


    }

    /**
     *
     * Test navigation page.
     *
     */
    @Test
    public void testNavigationLogin() throws InterruptedException {
        System.out.println(driver.getTitle());
        GlobalActions.waitForSeconds(3);

        assertTrue(driver.getTitle().contains("Home"));

        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();

        driver.findElement(By.id("user_email")).sendKeys("Tim");
        driver.findElement(By.id("user_email")).clear();

        GlobalActions.waitForSeconds(1);

        assertTrue(driver.findElement(By.id("user_email")).getText().isEmpty());

        driver.navigate().back();

        assertTrue(driver.getTitle().contains("Home"));


    }





    @AfterEach
    public void tearDown() {
        driver.close();
    }

}
