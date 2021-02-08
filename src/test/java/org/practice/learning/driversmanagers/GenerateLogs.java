package org.practice.learning.driversmanagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.log4testng.Logger;


    public class GenerateLogs {


        public static void main(String[] args) {

//select org testng log4testng here ,there are so many loggers ,not works all.

            Logger logger = Logger.getLogger(org.practice.learning.driversmanagers.GenerateLogs.class);

            System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();

            logger.info("launching browser");

            driver.get("http://www.google.com");
            logger.info("google url has been launched");

            String title = driver.getTitle();
            System.out.println("title value is :" + title);

            logger.info("title value is :" + title);

            if (title.equals("Google")){
                System.out.println("correct title is Google");
                logger.info("correct title is Google and test cases is passed");
            }else {
                System.out.println("correct title is not Google");
                logger.info("correct title is not Google and test cases is failed");
            }


        }

    }


