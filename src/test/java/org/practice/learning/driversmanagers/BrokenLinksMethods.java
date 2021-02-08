package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksMethods {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void testdata11() throws InterruptedException, IOException {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://freecrm.com");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
        driver.findElement(By.name("email")).sendKeys("patelparita67@yahoo.com");

        driver.findElement(By.name("password")).sendKeys("Pp10031991");

        driver.findElement(By.xpath("//div[text()='Login']")).click();

        //a for links
        //img for images

        //1--> get the list of all the links and images.
        List<WebElement> list = driver.findElements(By.tagName("a"));
        list.addAll(driver.findElements(By.tagName("img")));

        System.out.println("size of full links and images -->" + list.size());

        List<WebElement> activeLinks = new ArrayList<>();

        //2 and 3 not working

        //2--> itearte linklist -- list stores values on the basis of indexes.
        //exclude all the links/images- doesnt have any href attribute

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAttribute("href") != null && (!list.get(i).getAttribute("href").contains("javascript"))) {

                activeLinks.add(list.get(i));
                //get the size of active links list :
                System.out.println("size of active links and images-->" + activeLinks.size());

                //3 check the href url , with httpconnection api:

                HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(i).getAttribute("href")).openConnection();
                connection.connect();
                String response = connection.getResponseMessage();
                connection.disconnect();
                System.out.println(activeLinks.get(i).getAttribute("href") + "-->" + response);
            }
        }
    }
        @AfterSuite
        public void tearDown () {
            //      driver.quit();
        }
    }
