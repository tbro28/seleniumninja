package com.codeinb8a.java.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeinb8a.java.utilities.GlobalVariables.*;



public class ChromeDrv {

    public static WebDriver initialize(boolean headless) {

        //Setup
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();

        if(headless) {
            chromeOptions.addArguments("headless");
            chromeOptions.addArguments("disable-gpu");
            chromeOptions.addArguments("disable-extensions");
        }
        else {

            chromeOptions.addArguments("disable-gpu");
            chromeOptions.addArguments("disable-extensions");
        }

        //Create
        driver = new org.openqa.selenium.chrome.ChromeDriver(chromeOptions);

        return driver;
    }
}
