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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;

public class Chrome {

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
     * Adding in extensions.
     */
    @Test
    public void testProfilesChrome() throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\Tim\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\apdfllckaahabafndbhieahigkjlhalf\\14.5_0.crx"));
        //options.addExtensions(new File("/Users/Tim/AppData/Local/Google/Chrome/User Data/Default/Extensions/apdfllckaahabafndbhieahigkjlhalf/14.5_0.crx"));
        WebDriver driverProfile = new ChromeDriver(options);

        driverProfile.get("https://www.google.com");
    }
}