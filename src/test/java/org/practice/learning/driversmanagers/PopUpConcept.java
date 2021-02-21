package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PopUpConcept {
    //This does  not work

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();//maximize window(2)
        driver.manage().deleteAllCookies();//delete all cookies(3)
    }

    @Test
    public void testTC2() throws InterruptedException {

        /*
        This pop up is called model pop-up
        sometimes codes works without touching it sometimes not , so we have to use this coe,
        sometimes don't need to use mouseover action ,with findelement code is working.
         */


        driver.get("https://freecrm.com");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();

        driver.findElement(By.name("email")).sendKeys("Parita");

        driver.findElement(By.name("password")).sendKeys("Parita");

//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath(""))).build().perform();
//
//        driver.findElement(By.xpath("")).click();
//
//        driver.findElement(By.xpath("")).click();//then login path

        Thread.sleep(2000);
        System.out.println(driver.getTitle());

    }

    @AfterMethod
    public void tearDown() {

    //    driver.quit();
    }
}