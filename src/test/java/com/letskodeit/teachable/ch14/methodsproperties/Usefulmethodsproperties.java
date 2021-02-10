package com.letskodeit.teachable.ch14.methodsproperties;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GenericMethods;
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

import static com.codeinb8a.java.utilities.GlobalVariables.HOMEKODE_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Usefulmethodsproperties {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";
    private GenericMethods gm;

    @BeforeEach
    public void setUp() {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        gm = new GenericMethods(driver);

        //Action
        driver.get(KODE_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    /**
     *
     * Test page.
     *
     */
    @Test
    public void Usefulmethodsproperties() throws InterruptedException {


        WebElement buttonElement = driver.findElement(By.id("opentab"));

        System.out.println(buttonElement.getText());

        GlobalActions.waitForSeconds(3);

    }

    /**
     *
     * Test page.
     *
     */
    @Test
    public void UsefulmethodspropertiesAttributes() throws InterruptedException {


        WebElement element = driver.findElement(By.id("name"));

        System.out.println(element.getAttribute("class"));
        System.out.println(element.getAttribute("type"));

        GlobalActions.waitForSeconds(3);

    }

    /**
     *
     * Test page.
     *
     */
    @Test
    public void UsefulmethodspropertiesGenericMethods() throws InterruptedException {

        WebElement element = gm.getElement("name", "id");

        System.out.println(element.getAttribute("class"));
        System.out.println(element.getAttribute("type"));

        GlobalActions.waitForSeconds(3);

        List<WebElement> webElementList;

        webElementList = gm.getElementList("//input[@type='text']", "xpath");

        System.out.println(webElementList.size());

        GlobalActions.waitForSeconds(3);

    }


    /**
     *
     * Test page.
     *
     */
    @Test
    public void UsefulmethodspropertiesPresent() throws InterruptedException {

        boolean result = gm.isElementPresent("name", "id");

        System.out.println(result);

        GlobalActions.waitForSeconds(3);

    }



    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

