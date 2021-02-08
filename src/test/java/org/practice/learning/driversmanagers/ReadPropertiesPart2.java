package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesPart2 {

        static WebDriver driver;

        public static void main(String[] args) throws IOException {

            //config2.properties file use here


            Properties prop = new Properties();

            FileInputStream ip = new FileInputStream("C:\\FirstFramework\\practiseproject\\src\\test\\config2.properties");


            prop.load(ip);

            System.out.println(prop.getProperty("name"));
            System.out.println(prop.getProperty("age"));

            String url = prop.getProperty("URL");

            System.out.println(url);

            String browser = prop.getProperty("browser");
            System.out.println(browser);

            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");

                driver = new ChromeDriver();//launch chrome

            } else if (browser.equals("FF")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\geckodriver.exe");

                driver = new FirefoxDriver();//launch firefox


            } else if (browser.equals("IE")) {
                System.setProperty("webdriver.ie.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\InternetExplorer.exe");

                driver = new InternetExplorerDriver();//launch IE

            }
            driver.get(url);

            driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstname"));
            driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
            driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city"));



        }
    }

