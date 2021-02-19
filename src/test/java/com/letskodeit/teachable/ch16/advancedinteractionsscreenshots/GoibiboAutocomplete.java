package com.letskodeit.teachable.ch16.advancedinteractionsscreenshots;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GenericMethods;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import com.codeinb8a.java.utilities.WaitTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;


public class GoibiboAutocomplete {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";
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
        String filename = getRandomString() + ".png";
        //driver.close();
    }

    private String getRandomString() {
        return "screenshot"+ localDate;
    }


    /**
     * Test page.
     */
    @Test
    public void testAutocomplete() throws InterruptedException {

        //  //div[@aria-label='February 25, 2021']
        //expedia
        //southwest
        //alaska
        //kayak
        //redfin
        //zillow

        String partialText = "Del";
        String textToSelect = "Delhi, India (DEL)";

        driver.get("https://www.goibibo.com/");

        //List of options


        WebElement textField = driver.findElement(By.id("gosuggest_inputSrc"));
        textField.sendKeys(partialText);

        //List of options
        WebElement uulElement = driver.findElement(By.id("react-autosuggest-1"));
        System.out.println(uulElement.getAttribute("innerHTML"));

        List<WebElement> liElements = uulElement.findElements(By.tagName("li"));

        for(WebElement element : liElements) {

            if(element.getText().contains(textToSelect)) {
                System.out.println(element.getText());
                element.click();
                break;
            }
        }

        //Specific option selected
        WebElement ulElement = driver.findElement(By.id("react-autosuggest-1-suggestion--0"));

        System.out.println(ulElement.getText());

        ulElement.click();

        GlobalActions.waitForSeconds(3);

    }

    public void testScreenshot() {

        String partialText = "Del";
        String textToSelect = "Delhi, India (DEL)";

        driver.get("https://www.goibibo.com/");

        //List of options


        WebElement textField = driver.findElement(By.id("gosuggest_inputSrc"));
        textField.sendKeys(partialText);

        //List of options
        WebElement uulElement = driver.findElement(By.id("react-autosuggest-1"));
        System.out.println(uulElement.getAttribute("innerHTML"));



    }
}