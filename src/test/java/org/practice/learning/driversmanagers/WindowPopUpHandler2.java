package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPopUpHandler2 {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // This Method is use when there is one pop-up coming to way and you want to close the popup window

// for this class we dont have proper page so i used random vaue plz dont use this site is not working,
        //this is for the example only.

        driver.get("https://www.walmart.ca/en");
        driver.findElement(By.id("accept-privacy-policies")).click();

        driver.findElement(By.linkText("Clothing")).click();// this is one path of window which we want to close

        // In set object there is no index value, so thats y we r using iterator
        //Iterator is pointing to top of the set object ,
        // to shift iterator from top to first value n then second value use next() method.
        //And store in string variable.


        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        String parentwin = iterator.next();
        System.out.println("Parent window id " +parentwin );

        String childwin = iterator.next();
        System.out.println("child window id" + childwin);

        driver.switchTo().window(childwin);
        Thread.sleep(2000);

        System.out.println(driver.getTitle());//title print

        driver.close();

        driver.switchTo().window(parentwin);
        Thread.sleep(2000);

        System.out.println(driver.getTitle());//title print

        driver.close();

//window id is uniq ,always diff value shows.






    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        driver.quit();
    }

}