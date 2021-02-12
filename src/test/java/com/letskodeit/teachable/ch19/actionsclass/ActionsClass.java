package com.letskodeit.teachable.ch19.actionsclass;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GenericMethods;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import com.codeinb8a.java.utilities.WaitTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;
import static com.codeinb8a.java.utilities.GlobalVariables.DEBUG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Different ways to find windows and popups (18).
 *
 */
public class ActionsClass {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Firefox";
    private GenericMethods gm;
    private WaitTypes wt;
    JavascriptExecutor jse;

    private LocalDate localDate = LocalDate.now();

    @BeforeEach
    public void setUp() {
        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);
        gm = new GenericMethods(driver);
        wt = new WaitTypes(driver);
        driver.get(KODE_URL);

        jse = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        //driver.close();
        driver.quit();
    }

    /**
     * Test needing to hover over a dynamic menu and select an element.
     */
    @Test
    public void testMouseHoverMenuWithSubElements() throws InterruptedException {

        jse.executeScript("window.scrollBy(0, 600)");

        WebElement mainElement = driver.findElement(By.xpath("//button[@id='mousehover']"));

        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        if(DEBUG) GlobalActions.waitForSeconds(3);

        WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
        action.moveToElement(subElement).click().perform();
        if(DEBUG) GlobalActions.waitForSeconds(3);
    }

    /**
     * Test drag and drop.
     */
    @Test
    public void testDragAndDrop() throws InterruptedException {

        driver.get("https://jqueryui.com/droppable/");
        if(DEBUG) GlobalActions.waitForSeconds(3);

        /**Setup.*/
        driver.switchTo().frame(0);
        WebElement fromElement = driver.findElement(By.id("draggable"));
        WebElement toElement = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);

        /**Drag and drop.
        It needs to build multiple actions and perform the drag and drop.*/
        action.dragAndDrop(fromElement, toElement).build().perform();

        if(DEBUG) GlobalActions.waitForSeconds(3);

        action.dragAndDropBy(fromElement, -50, -50).build().perform();

        if(DEBUG) GlobalActions.waitForSeconds(3);

        /**Click and hold, move to element, release, build and perform.
        More realistic.*/
        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
        if(DEBUG) GlobalActions.waitForSeconds(3);
        System.out.println(fromElement.getLocation());

        assertEquals("(171, 40)", fromElement.getLocation().toString());
    }

    /**
     * Test Javascript Alert and Confirm pop-ups.
     * Items that you can't find, because they aren't html.
     * Find the JS script that is being called.
     */
    @Test
    public void testSliders() throws InterruptedException {

        /**Setup.*/
        driver.get("https://jqueryui.com/slider/");
        driver.switchTo().frame(0);
        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));

        if(DEBUG) GlobalActions.waitForSeconds(3);
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, 100, 0).perform();


        if(DEBUG) GlobalActions.waitForSeconds(3);


    }
}