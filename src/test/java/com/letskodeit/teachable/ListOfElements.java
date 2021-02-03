package com.letskodeit.teachable;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;

public class ListOfElements {

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

    /**
     *
     * Test navigation page.
     *
     */
    @Test
    public void testListOfElements() throws InterruptedException {

        String title = "";

        //  //input[contains(@type, 'radio') and contains(@name, 'cars')]

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type, 'radio') and contains(@name, 'cars')]"));

        for(WebElement rButton : radioButtons) {
            System.out.println(rButton.getAttribute("id"));
            rButton.click();

            GlobalActions.waitForSeconds(3);
        }

        for(WebElement rButton : radioButtons) {
            System.out.println(rButton.getTagName());
            rButton.click();

            GlobalActions.waitForSeconds(3);
        }

        //assertTrue(driver.getTitle().contains("Home"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

