package org.practice.learning.driversmanagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SingletonPatternDesignPart1 {
    //part 1 and 2 are interconnected ,works together
    //singleton pattern means intialize driver only once
    //singleton concept means how we created everything in the framework, is like that,same like page object model

    public static WebDriver driver = null;


    public static void intialize() {
        if (driver == null) {
            if (SingletonPatternDesignPart2.browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\updatedchromeversion\\chromedriver.exe");
                driver = new ChromeDriver();

            } else if (SingletonPatternDesignPart2.browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\Webdrivers\\geckodriver.exe");
                driver = new FirefoxDriver();

            }
            driver.manage().deleteAllCookies();//delete all cookies(3)
            driver.manage().window().maximize();//maximize window(2)
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }

    public static void quit() {
        System.out.println("quitting the browser");
        driver.quit();
        driver = null;

    }

    public static void close() {
        System.out.println("closing the browser");
        driver.close();
        driver = null;
    }
}
