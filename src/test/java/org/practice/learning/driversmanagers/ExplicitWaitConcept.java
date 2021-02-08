package org.practice.learning.driversmanagers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitConcept {


    private WebDriverWait wait;
        private WebDriver driver;

        @BeforeSuite
        public void setUp () {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();

        }

        @Test
        public void testdata11 () throws InterruptedException {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.get("https://www.google.com");

            // clickOn(driver, driver.findElement(By.id("use id here")),20 );

            //Youtube method --use atin's method.


//        public static void clickOn(WebDriver driver, WebElement locator ,int timeOut){
//            new WebDriverWait(driver,timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
//            locator.click();
            //       }
// when there are some of the application click does not work we can use this method
            //There are so many methods availble we can use it(for all click options), this is only for clickable method


            //Atin's method

            // here we use time 20 sec for the waittime and we can add sleepmills 50 sec ,
            // otherwise it can take automate 25 secs, no need to add sometimes too this 50 sleepmilss.

            //This is the methods in Expectedconditions we can use here.
            //use according to requirements.
            //visibility one is using when the element is not visible n we wants visible it .
            //sometimes there are some elements which appears when we we click something or submit something.
            //presenceofelements() is used when theres is some pop up which come up after
            // application load properly which we click it.cz that element is not present in the dom
            // but which is added cz of the actions.

            WebDriverWait wait1 = new WebDriverWait(driver, 20, 50);
            WebElement until = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("x-path")));
            until.click();

        }

    @AfterMethod
    public void tearDown() {
        //      driver.quit();


    }
}
