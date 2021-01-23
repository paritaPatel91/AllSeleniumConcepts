package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Navigations {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // to give time to pageload use pageloadtimeout



        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

//first method

   //     driver.get("https://www.facebook.com");

  //      driver.navigate().to("https://meet.voicemailtel.com");
//
//        driver.navigate().back();
//        Thread.sleep(2000);
//
//        driver.navigate().forward();
//        Thread.sleep(2000);
//
//        driver.navigate().refresh();
//
//        // navigate in one page with diff elemnts
//        driver.findElement(By)
//
// This is the second method for moving one page to other

        driver.get("https://www.walmart.ca/en");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("accept-privacy-policies")).click();

        WebElement element = driver.findElement(By.linkText("Clothing"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).pause(100).click(element).build().perform();
        Thread.sleep(2000);
        driver.close();

// IQ ::: diff between close and quit
// ans: close will close the window or tab
        //but quit will close the browser


    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
