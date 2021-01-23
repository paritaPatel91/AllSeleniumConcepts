package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

            clickOn(driver, driver.findElement(By.id("use id here")),20 );

        }

        public static void clickOn(WebDriver driver, WebElement locator ,int timeOut){
            new WebDriverWait(driver,timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
        }
// when there are some of the application click does not work we can use this method
    //There are so many methods availble we can use it(for all click options), this is only for clickable method



    @AfterMethod
    public void tearDown() {
        //      driver.quit();


    }
}
