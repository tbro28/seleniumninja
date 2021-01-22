package com.codeinb8a.java.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeinb8a.java.utilities.GlobalVariables.APP_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.DRIVER_PATH;


public class IEDrv {

    public static WebDriver initialize(boolean headless) {

        //Setup
        WebDriver driver;
        System.setProperty("webdriver.ie.driver", DRIVER_PATH + "IEDriverServer.exe");

        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();

        //Create

        if(headless) {
            caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
            caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);

            //Doesn't work.
            internetExplorerOptions.setCapability("--headless", true);
            internetExplorerOptions.setCapability("headless", true);
        }
        else {
            caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
            caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        }

        //Create
        //driver = new InternetExplorerDriver(internetExplorerOptions);
        driver = new InternetExplorerDriver(caps);
        driver.manage().window().maximize();

        return driver;
    }
}
