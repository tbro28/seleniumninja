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

public class HiddenElementsElements {

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
     * Identifying hidden values as either hidden or destroyed.
     *
     * There are a bunch of different methods to hide items.
     * Or completely be removed.
     *
     */
    @Test
    public void testHiddenElementsElementsLetsKodeIt() throws InterruptedException {


//        WebElement travelers = driver.findElement(By.className("uitk-fake-input uitk-form-field-trigger"));
        WebElement textBox = driver.findElement(By.id("displayed-text"));
        System.out.println(textBox.isDisplayed());
        GlobalActions.waitForSeconds(2);

        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        hideButton.click();
        System.out.println(textBox.isDisplayed());
        GlobalActions.waitForSeconds(2);

        WebElement showButton = driver.findElement(By.id("show-textbox"));
        showButton.click();
        System.out.println(textBox.isDisplayed());
        GlobalActions.waitForSeconds(2);

        GlobalActions.waitForSeconds(2);
    }


    @Test
    public void testHiddenElementsElementsExpedia() throws InterruptedException {

        String url = "https://www.expedia.com";
        driver.navigate().to(url);

//        WebElement travelers = driver.findElement(By.className("uitk-fake-input uitk-form-field-trigger"));
//        WebElement travelers = driver.findElement(By.tagName("data-testid"));



        WebElement travXpath = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[1]/div[4]/div/figure/div[3]/div/div/div/div[1]/div/form/div[1]/div[3]/div/div/div[1]/button"));

        System.out.println(travXpath.isDisplayed());
        System.out.println(travXpath.isEnabled());

        travXpath.click();

/*
        WebElement travelers = driver.findElement(By.cssSelector(".uitk-fake-input"));
        WebElement travelers = driver.findElement(By.id("adaptive-menu"));
        travelers.click();
*/
        //*[@id="child-age-input-0-0"]

        GlobalActions.waitForSeconds(2);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

