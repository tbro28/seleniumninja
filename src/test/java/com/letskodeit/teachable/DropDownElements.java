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

import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;

public class DropDownElements {

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
    public void testDropDownElements() throws InterruptedException {

        WebElement dropDown = driver.findElement(By.id("carselect"));

        Select select = new Select(dropDown);

        System.out.println(select.toString());

        select.selectByValue("benz");
        GlobalActions.waitForSeconds(3);

        select.selectByIndex(2);
        GlobalActions.waitForSeconds(3);

        select.selectByVisibleText("BMW");
        GlobalActions.waitForSeconds(3);

        List<WebElement> options = select.getOptions();

        for(WebElement option : options)
            System.out.println(option.getText());

        System.out.println();

    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

