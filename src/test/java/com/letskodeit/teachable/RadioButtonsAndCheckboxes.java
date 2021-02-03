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

import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.HOMEKODE_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RadioButtonsAndCheckboxes {

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
    public void testRadioButtonsAndCheckboxes() throws InterruptedException {

        String title = "";

        WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
        bmwRadio.click();
        System.out.println(bmwRadio.isSelected());

        GlobalActions.waitForSeconds(3);

        WebElement benzRadio = driver.findElement(By.id("benzradio"));
        benzRadio.click();
        System.out.println(benzRadio.isSelected());

        GlobalActions.waitForSeconds(3);

        WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
        bmwCheckBox.click();
        System.out.println(bmwCheckBox.isSelected());

        GlobalActions.waitForSeconds(3);

        WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
        benzCheckBox.click();
        System.out.println(benzCheckBox.isSelected());

        GlobalActions.waitForSeconds(3);

        System.out.println(benzRadio.isSelected());
        System.out.println(benzCheckBox.isSelected());

        WebElement hondaCheck = driver.findElement(By.id("hondacheck"));
        System.out.println(hondaCheck.isSelected());

        System.out.println("The End");

        //assertTrue(driver.getTitle().contains("Home"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

