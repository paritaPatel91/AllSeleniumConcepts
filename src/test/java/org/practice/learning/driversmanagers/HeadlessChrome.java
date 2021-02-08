package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HeadlessChrome {
    /*
    1. chrome version should be greater than 60 on windows
    2.window size should be = 1400,800
    3.This headless chrome means code is working , gives its result with chrome launch but we cannot able to open it.
    4.It is so much fast.
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");

        //to make headless chrome browser
        //use this codes
//********************************************************
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

//************************************************************
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://freecrm.com");
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
        driver.findElement(By.name("email")).sendKeys("patelparita67@yahoo.com");

        driver.findElement(By.name("password")).sendKeys("Pp");

        WebElement loginbtn = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
        loginbtn.click();


    }
}