package org.practice.learning.driversmanagers.webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SafariClass {

    //safari is class which implementing webdriver interface
    //driver reference variable


    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
       System.setProperty("webdriver.ie.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\IEDriverServer.exe");
       driver= new InternetExplorerDriver();

    }

    @Test
    public void TC_1_1(){
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        driver.quit();
    }
}

