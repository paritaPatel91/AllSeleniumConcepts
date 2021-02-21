package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StaleElementExceptionConcept {
    /*
    Stale means something is gone from the page, not available on the page now

    AJAX: means on the webpage sometimes ony one or two element got refresh eg. booking a flight
     only price is changing when we do refresh is call ajax component.

     our code is working fine before one min and all of sudden it is not working and showing statleelmenetexception
     cz of this Ajax component got refresh and and price or value is change over there.
     cz ajax compnonet created it's unique id over there which is change due to refesh of page,although we are not refresing
     page but it can refersh by own.

     in the dom all of sudden small component got refersh, id got change and showing this exception.

     */

    public static void main(String[] args) {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();//maximize window(2)
        driver.manage().deleteAllCookies();//delete all cookies(3)

        driver.get("https://freecrm.com");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();

        driver.findElement(By.name("email")).sendKeys("Parita");

        driver.findElement(By.name("password")).sendKeys("Parita");

    }

}
