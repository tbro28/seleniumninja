package com.letskodeit.teachable.ch18switchwindow;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GenericMethods;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import com.codeinb8a.java.utilities.WaitTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Different ways to find windows and popups (18).
 *
 */
public class SwitchWindow {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Firefox";
    private GenericMethods gm;
    private WaitTypes wt;

    private LocalDate localDate = LocalDate.now();

    @BeforeEach
    public void setUp() {
        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);
        gm = new GenericMethods(driver);
        wt = new WaitTypes(driver);
        driver.get(KODE_URL);
        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        //driver.close();
        driver.quit();
    }

    /**
     * Test to switch window.
     * Get all window handles and find the one that isn't the parent.
     */
    @Test
    public void testSwitchWindow() throws InterruptedException {
        String parentHandle = driver.getWindowHandle();
        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for(String windowHandle : windowHandles) {
            System.out.println(windowHandle);
            if(!windowHandle.equals(parentHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebElement searchBox = driver.findElement(By.id("search-courses"));
        searchBox.sendKeys("Python");
        driver.findElement(By.id("search-course-button"));
        assertTrue(driver.findElement(By.xpath("//div[@title='Learn Python 3 from scratch']")).isDisplayed());
        GlobalActions.waitForSeconds(3);
        driver.close();

        driver.switchTo().window(parentHandle);
        assertTrue(driver.findElement(By.xpath("//legend[text()='Switch Window Example']")).isDisplayed());
    }

    /**
     * Test to switch to iFrame.
     */
    @Test
    public void testIFrameWindow() throws InterruptedException {

        /**
         * If for some reason the frame is extremely difficult to find,
         * then try using the frame number:
         *
         * driver.switchTo().frame(0);
         *
         * */

        /**Find by Id.*/
        driver.switchTo().frame("courses-iframe");
        WebElement webElement = driver.findElement(By.id("search-courses"));
        webElement.sendKeys("Python");
        assertTrue(driver.findElement(By.xpath("//div[@title='Learn Python 3 from scratch']")).isDisplayed());

        driver.switchTo().defaultContent();
        assertTrue(driver.findElement(By.xpath("//legend[text()='Switch Window Example']")).isDisplayed());
        GlobalActions.waitForSeconds(3);

        /**Find by Name.*/
        driver.switchTo().frame("iframe-name");
        webElement = driver.findElement(By.id("search-courses"));
        webElement.clear();
        webElement.sendKeys("Python");
        assertTrue(driver.findElement(By.xpath("//div[@title='Learn Python 3 from scratch']")).isDisplayed());
    }

    /**
     * Test Javascript Alert and Confirm pop-ups.
     * Items that you can't find, because they aren't html.
     * Find the JS script that is being called.
     */
    @Test
    public void testJavascriptPopup() throws InterruptedException {

        /**JS Alert.*/
        driver.findElement(By.id("name")).sendKeys("Tim");
        driver.findElement(By.id("alertbtn")).click();
        GlobalActions.waitForSeconds(3);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        /**JS Alert.*/
        driver.findElement(By.id("name")).sendKeys("Tim");
        driver.findElement(By.id("confirmbtn")).click();
        GlobalActions.waitForSeconds(3);
        alert = driver.switchTo().alert();
        alert.accept();
    }
}