package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadiobuttonAndCheckboxesPart2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Checkboxes and radio buttons can be selected by using click().
        //isDisplayed() - to verify whether the element is displayed on the web page.
        //isEnabled() - to verify whether the element is enabled to perform action on it.
        //isSelected() - to validate whether the element is selected or not.

        driver.get("https://www.goibibo.com/flights");

       // driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();


        System.out.println("is displayed " + driver.findElement(By.id("roundTrip")).isDisplayed());
        System.out.println("is enabled " + driver.findElement(By.id("roundTrip")).isEnabled());

        driver.findElement(By.id("roundTrip")).click();
        Thread.sleep(2000);
        System.out.println("is selected " + driver.findElement(By.id("roundTrip")).isSelected());

        driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Delhi,India(DEL)");


       // Thread.sleep(2000);


      //  Thread.sleep(2000);
    }

    }
