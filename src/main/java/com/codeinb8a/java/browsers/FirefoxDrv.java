package com.codeinb8a.java.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import static com.codeinb8a.java.utilities.GlobalVariables.APP_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.DRIVER_PATH;


public class FirefoxDrv {

    public static WebDriver initialize(boolean headless) {

        //Setup
        WebDriver driver;
        System.setProperty("webdriver.firefox.driver", DRIVER_PATH + "geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        if(headless) {
            firefoxOptions.addArguments("--headless");
        }

        //Create
        driver = new FirefoxDriver(firefoxOptions);

        return driver;
    }
}
