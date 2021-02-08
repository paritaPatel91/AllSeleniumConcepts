package org.practice.learning.driversmanagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.api.Screen;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Sikuli {
    /*
   1) Sikuli is the tool to test the vido r images. foreg. there is one e-commerce application and
     we wants to test some image and vidio to playing or not.
   2)we can use sikuli or QTP but sikuli is very easy to learn. but we will learn QTP also
   3) for using sikulli we have to dowload either jar file or if we are using maven ,
   we have to add dependancy with 1.1.0 version or depending on the company/s requirements.
   4) Disadvantage:we can not open browser with it.with selenium we can able to open it.
   5) we don't need to learn complete sikulli - api until require.
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();//launch chrome

        driver.manage().window().maximize();//maximize window
        driver.manage().deleteAllCookies();//delete all the cookies

        //dynamic waits
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.get("https://www.youtube.com/watch?v=vTCZrgb2PWc");//enter URL

        //create thr object of screen class -import from sikulli script not from sun.
        Screen s = new Screen() {
            @Override
            public BufferedImage getScreenshot(int i, int i1, int i2, int i3) {
                return null;
            }

            @Override
            public Dimension getSize() {
                return null;
            }
        };


//        Pattern pauseimg = new Pattern("pause.png");
//        s.wait(pauseimg,2000);

//not working this code.

    }

}
