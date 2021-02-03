package com.letskodeit.teachable.ch13.profilesandoptions;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;

public class Firefox {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Firefox";

    @BeforeEach
    public void setUp() {

        /*
        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        //Action
        driver.get(KODE_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        */
    }

    /**
     * Identifying hidden values as either hidden or destroyed.
     * <p>
     * There are a bunch of different methods to hide items.
     * Or completely be removed.
     */
    @Test
    public void testProfilesFirefox() throws InterruptedException {

        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile firefoxProfile = profile.getProfile("seleniumtest");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

        WebDriver d2 = new FirefoxDriver(opt);

        //profile
        driver = d2;

        //headless

    }
}