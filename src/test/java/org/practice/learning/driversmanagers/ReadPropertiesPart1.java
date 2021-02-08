package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

    public class ReadPropertiesPart1 {

        //how to read properties file:
        public static void main(String[] args) {

            WebDriver driver = null;

            Properties prop = new Properties();
            FileInputStream ip = null;
            try {
                ip = new FileInputStream("C:\\FirstFramework\\practiseproject\\src\\test\\java\\config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                prop.load(ip);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            System.out.println(prop.getProperty("browser"));
            String browserName = prop.getProperty("browser");

            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
                driver = new ChromeDriver();

            } else if (browserName.equals("FF")) {
                driver = new FirefoxDriver();

            } else if (browserName.equals("EDGE")) {
                driver = new EdgeDriver();

            }else if (browserName.equals("OPERA")) {
                driver = new OperaDriver();

            }
            else {
                System.out.println("no browser value is given");
            }
            driver.get(prop.getProperty("url"));
            driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
            driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));


        }

        public static class HandleFileUploadPopUp {

            // for the upload the file in any browse we can use this method

            //don't use click method for uploading

            private WebDriver driver;

            // driver.findelement(by.xpath of browse or upload button).sendkeys("path of the file which we r going to upload")








        }
    }

