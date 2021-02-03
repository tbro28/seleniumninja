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

public class MultipleSelectElements {

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
    public void testMultipleSelectElements() throws InterruptedException {

        WebElement multiSelect = driver.findElement(By.id("multiple-select-example"));

        Select select = new Select(multiSelect);

        System.out.println(select.getOptions().get(1));

        System.out.println("Select orange.");
        select.selectByValue("orange");
        GlobalActions.waitForSeconds(2);

        select.deselectByValue("orange");
        GlobalActions.waitForSeconds(2);

        select.selectByIndex(2);
        select.selectByVisibleText("Apple");

        List<WebElement> selectedOptionsList = select.getAllSelectedOptions();

        for(WebElement optionList : selectedOptionsList)
            System.out.println(optionList.getText());
        GlobalActions.waitForSeconds(2);

        select.deselectAll();
        GlobalActions.waitForSeconds(2);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

