package com.codeinb8a.java.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

import static com.codeinb8a.java.utilities.GlobalVariables.APP_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.DRIVER_PATH;


public class EdgeDrv {

    public static WebDriver initialize (boolean headless) {

        //Setup
        WebDriver driver;
        System.setProperty("webdriver.edge.driver", DRIVER_PATH + "msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();

        //Headless doesn't work.
        if(headless) {
            //EdgeDriverService edgeDriverService = new EdgeDriverService(); //Microsoft.Edge.SeleniumTools.EdgeDriverService.CreateChromiumService();
            edgeOptions.setCapability("headless", "headless");
            edgeOptions.setCapability("disable-gpu", "disable-gpu");
            System.out.println(edgeOptions.getCapabilityNames());
            //edgeOptions.getCapabilityNames().forEach();
        }
        else {
            edgeOptions.setPageLoadStrategy("normal");//.PageLoadStrategy = PageLoadStrategy.Normal;
        }

        //Create
        driver = new EdgeDriver(edgeOptions);

        return driver;
    }

}
