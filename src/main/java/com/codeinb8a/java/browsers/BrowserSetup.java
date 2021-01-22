package com.codeinb8a.java.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

        return driver;
    }
}
