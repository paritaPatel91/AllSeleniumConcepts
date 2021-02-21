package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Synchronization {
    public static void main(String[] args) {

        /*
        1.synchroniation means talking about implicitwaits and explicitwaits

        2.implicitwaits ::
        apply only globally--is availble for all the webelemnts
        1.This both waits are dynamic waits
        2.Thread.sleep is static wait
        3.it can be change anywhere and anytime in your code
         */


    WebDriver driver;

     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
    driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();//maximize window(2)
        driver.manage().deleteAllCookies();//delete all cookies(3)

        driver.get("https://freecrm.com");

        WebElement first = driver.findElement(By.name("firstname"));

        sendKeys(driver,first,10,"Tom");
    }

    //youtube method
    public static void sendKeys(WebDriver driver, WebElement element, int timeout , String value){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }
//for clicking the element
    public static void sendKeys22(WebDriver driver, WebElement element, int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /*
    Explicit wait:
    1. no explicit keyword or method
    2.availble with webdriverwait with some Expectedconditions
    3.specific to element
    4.dynamic in nature
    5.we should never use explicitwait and implicitwait together
    because selenium WD will wait for the element first bc of IMPLICIT WAIT and then EXPLICIT WAIT will be applied
    hence, total sync wait will be increased for each element.
     */
}
