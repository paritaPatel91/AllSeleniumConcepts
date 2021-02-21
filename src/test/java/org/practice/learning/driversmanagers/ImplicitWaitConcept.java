package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitConcept {

//    Implicitwait is dynamic wait
//    Thread.sleep is static wait

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void testTimeOut() {
         // This is steps you should performs for every class

        driver.get("https://jqueryui.com/droppable");//enter Url(1)
        driver.manage().window().maximize();//maximize window(2)
        driver.manage().deleteAllCookies();//delete all cookies(3)

        //This both are dynamic wait

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //(4)Maximum timeout for Pageload ,
        // if pageload happened within 5 second ,then rest of the seconds will be ignored

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//(5)This wait is for all elements.
        // Both this are globalwait . this wait should be putting after URL so wait time can start from there
        //This allow page to wait for all elemets to load completely and then perform actions within this time period ,
        // if elements perfoms its actons within 5seconds then rest of time will be ignored.

        //Thread.sleep is staic wait :not used it pause all time and wait until finish all timesecond if actions already performs

        //fluentwair is also implicitwaits.
        //Implicitwait is consider as BAD (But are good as compare to Thread.sleep)
        //Explicitwait is consider as Good wait.
        //This both waits are on the driver level so whenever we use driver.findelement we can have wait overther.

        //Do not use implicitwait ,so question is what we can use then.
        //we can use WebdriverWait class and make it object of it.(ExplicitWait is the webdriverWait)




    }

        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);

            driver.quit();
        }
    }





