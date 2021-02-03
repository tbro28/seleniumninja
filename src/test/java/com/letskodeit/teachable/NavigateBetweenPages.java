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

public class NavigateBetweenPages {

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
    public void testNavigationLogin() throws InterruptedException {

        String title = "";
        title = driver.getTitle();
        System.out.println(title);

        String url = "";
        url = driver.getCurrentUrl();
        System.out.println(url);

        String currentUrl = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";

        driver.navigate().to(currentUrl);
        currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        GlobalActions.waitForSeconds(3);

        driver.navigate().back();
        GlobalActions.waitForSeconds(3);
        driver.navigate().forward();
        GlobalActions.waitForSeconds(3);

        driver.navigate().refresh();
        driver.get(url);

        GlobalActions.waitForSeconds(3);

        //Page source
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        assertTrue(driver.getTitle().contains("Home"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

