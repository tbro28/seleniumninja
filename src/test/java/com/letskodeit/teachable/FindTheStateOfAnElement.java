package com.letskodeit.teachable;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.HOMEKODE_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindTheStateOfAnElement {

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
     * Test navigation page.
     *
     */
    @Test
    public void staleElements() throws InterruptedException {

        String url = "https://www.google.com";
        driver.navigate().to(url);

        GlobalActions.waitForSeconds(3);

        //Disabled attribute tag is what to look for.
        //WebElement element = driver.findElement(By.id("gs_htif0"));
        //System.out.println("IsEnabled" + element.isEnabled());

        WebElement element2 = driver.findElement(By.name(("q")));
        System.out.println("IsEnabled" + element2.isEnabled());

        element2.sendKeys("codeinb8a");

        GlobalActions.waitForSeconds(3);

//        assertTrue(driver.getTitle().contains("Home"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

