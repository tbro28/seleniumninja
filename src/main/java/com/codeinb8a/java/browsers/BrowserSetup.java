package com.codeinb8a.java.browsers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import static com.codeinb8a.java.utilities.GlobalVariables.APP_URL;

public class BrowserSetup {

    public static WebDriver setBrowserDetails(String browserDriver, boolean headless) {

        WebDriver driver = null;

        if (browserDriver == "Chrome")
        {
            driver = ChromeDrv.initialize(headless);
        }
        else if (browserDriver == "Firefox")
        {
            driver = FirefoxDrv.initialize(headless);
        }
        else if (browserDriver == "Edge")
        {
            driver = EdgeDrv.initialize(headless);
        }
        else if (browserDriver == "IE")
        {
            driver = IEDrv.initialize(headless);
        }

        driver.manage().window().maximize();

        return driver;
    }
}
