package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicWebTableHandle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://freecrm.com");
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
        driver.findElement(By.name("email")).sendKeys("patelparita67@yahoo.com");

        driver.findElement(By.name("password")).sendKeys("P91");
        driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

        driver.findElement(By.xpath("//*[@class='users icon']")).click();

        //This is the first method with absolute path

        //This is the absolute path of names available in the contact list.
        //*[@id="main-content"]/div/div[2]/div/table/tbody/tr[1]/td[2]/a
        //*[@id="main-content"]/div/div[2]/div/table/tbody/tr[2]/td[2]/a
        //*[@id="main-content"]/div/div[2]/div/table/tbody/tr[3]/td[2]/a

//        String before_xpath ="//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[";
//        String aftre_xpath = "]/td[2]/a";
//
//        for (int i = 1; i <=3; i++) {
//            String name = driver.findElement(By.xpath(before_xpath+i+aftre_xpath)).getText();
//            System.out.println(name);
//            if (name.contains("Parita Chirag Patel")){//i=3
//                //This the checkbox of name's absolute path
//                //*[@id="main-content"]/div/div[2]/div/table/tbody/tr[3]/td[1]/div/input
//
//                driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr["+i+"]/td[1]/div/input")).click();
//
//use method 2 not 1.
        //Method 2
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Chirag I Patel')]//parent::td//preceding-sibling::td//div//input")).click();
        Thread.sleep(2000);
    }

        }








