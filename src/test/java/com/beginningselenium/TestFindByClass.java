package com.beginningselenium;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.LINK_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFindByClass {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";



    @BeforeEach
    public void setUp() throws Exception {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);
        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }


    /**
     *
     * Test testKodeItFindByClass.
     *
     * @throws Exception
     */
    @Test
    public void testKodeItFindByClass() throws Exception {

        List<WebElement> elementList;

        //Action
        driver.get(KODE_URL);

        elementList = driver.findElements(By.className("btn-style"));

        System.out.println(elementList.size());

        for (WebElement element : elementList) {

            System.out.println(element.getText());
            if(element.getText() == "Alert")
                element.click();
        }

        GlobalActions.waitForSeconds(10);

        assertTrue(true);

    }


    /**
     *
     * Test testKodeItFindByTagName.
     *
     * @throws Exception
     */
    @Test
    public void testKodeItFindByTagName() throws Exception {

        List<WebElement> elementList;

        //Action
        driver.get(KODE_URL);

        elementList = driver.findElements(By.tagName("a"));

        System.out.println(elementList.size());

        for (WebElement element : elementList) {

            System.out.println(element.getText());
            if(element.getText().contains("Tab"))
                element.click();
        }

        GlobalActions.waitForSeconds(5);
//Doesn't switch tabs.

        driver.getWindowHandles();

        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl() == "https://letskodeit.teachable.com/courses");

    }





    @AfterEach
    public void tearDown() throws Exception {
        driver.close();
    }
}
