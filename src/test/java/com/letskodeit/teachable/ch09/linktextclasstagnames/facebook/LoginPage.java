package com.letskodeit.teachable.ch09.linktextclasstagnames.facebook;

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

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;


/**
 *
 * Find By:
 *
 * id
 *
 * name
 * xpath
 * css selector
 *
 * classname
 * linktext
 * tagname
 *
 */
public class LoginPage {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";

    @BeforeEach
    public void setUp() {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        //Action
        driver.get(KODE_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    // //input[contains(@class, 'inputtext _55r1 _6luy') and contains(@id, 'email')]
    // //*[@id="u_e_s"]
    // //*[@id='email']

    /**
     *
     * Test navigation page.
     *
     */
    @Test
    public void findElements() throws InterruptedException {

        String url = "https://www.facebook.com";
        driver.navigate().to(url);


    }


}
