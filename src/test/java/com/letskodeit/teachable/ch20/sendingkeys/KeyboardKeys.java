package com.letskodeit.teachable.ch20.sendingkeys;

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
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.DEBUG;
import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Different ways to find windows and popups (18).
 *
 */
public class KeyboardKeys {

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
     * Test pressing keys, like Enter to log into a site.
     */
    @Test
    public void testPressingKeyboardKeys() throws InterruptedException {

        /**Setup.*/
        driver.get("https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1");

        if(DEBUG) GlobalActions.waitForSeconds(3);

        /**Fill in fields.*/
        driver.findElement(By.id("user_email")).sendKeys("Tim@Tim.com");
        driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
        if(DEBUG) GlobalActions.waitForSeconds(3);
        //assertTrue(driver.findElement(By.id("user_password"))..isSelected());

        driver.findElement(By.id("user_password")).sendKeys("12341234");
        if(DEBUG) GlobalActions.waitForSeconds(3);

        /**Press the enter key.*/
        driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);

        if(DEBUG) GlobalActions.waitForSeconds(3);
    }

    /**
     * Test 'Ctrl + a' to select everything.
     */
    @Test
    public void testKeyCombinations() throws InterruptedException {

        /**Setup.*/
        driver.get(KODE_URL);

        driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a");
        if(DEBUG) GlobalActions.waitForSeconds(3);

        driver.findElement(By.id("openwindow")).click();
        driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        if(DEBUG) GlobalActions.waitForSeconds(3);

        /**Can abstract 'selectAll' into a page object.*/
        String selectAll = Keys.chord(Keys.COMMAND, "a");
        driver.findElement(By.id("openwindow")).click();
        driver.findElement(By.id("openwindow")).sendKeys(selectAll);
        if(DEBUG) GlobalActions.waitForSeconds(3);


    }

    /**
     * Test key press using Action events.
     */
    @Test
    public void testKeyPressEvents() throws InterruptedException {

        /**Remember that keyDown holds the key down until you call keyUp.*/
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        if(DEBUG) GlobalActions.waitForSeconds(3);
    }

}