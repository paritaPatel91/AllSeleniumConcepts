package org.practice.learning.driversmanagers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebdriverMethods {
        private WebDriver driver;

        @BeforeSuite
        public void setUp() {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void testName() throws InterruptedException {
            driver.get("https://www.guess.com/ca/en/home/");
            Thread.sleep(2000);
            //this method is use to get ttile of the URL::

//       String title = driver.getTitle();
//        System.out.println(title);

            //      In Testcases we use aasert method to validate the method

            //  Assert.assertTrue(driver.getTitle().contains("Title of  any page"));

            //when assertion fails it complains otherwise it will not show any result


            //or we can do like this also

//       System.out.println(driver.getTitle());
//
//        //  validation point::by using if -else --
//
//        if (title.equals("Lifestyle Brand for Women, Men and Kids" )){
//            System.out.println("Incorrect tittle ");
//        }else {
//            System.out.println("correct tittle");
//        }
// This method use to get current URL ::
//
//        System.out.println(driver.getCurrentUrl());
//
//        // this method is use to get complete HTML page source of the url (useless method)
//        System.out.println(driver.getPageSource());

            driver.manage().window().fullscreen();

            // this method will make the page or to its setsize

            driver.manage().window().setSize(new Dimension(960,960));
            Thread.sleep(2000);

// this method will change its position to set value

            driver.manage().window().setPosition(new Point(200,200));
            Thread.sleep(2000);

            driver.manage().window().getPosition().getX();
            driver.manage().window().getPosition().getY();

            System.out.println(driver.manage().window().getSize().width);
            System.out.println(driver.manage().window().getSize().height);



            //This are webelements methods.
            // Submit() is used to submit any form in the application.
            WebElement form = driver.findElement(By.id("draggable"));
            form.submit();

            //To delete any input we are using clear()
            form.clear();

            System.out.println(form.getTagName());//gives tag name of the elements.

            System.out.println(form.getAttribute("id"));//shows value of the element.like id has this value
            //we can use it for any attribute or tag.


        }
        @AfterSuite
        public void tearDown() throws InterruptedException {

            //This one used to close the URL
            driver.quit();
        }
    }


