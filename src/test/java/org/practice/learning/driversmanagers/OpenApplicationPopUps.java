package org.practice.learning.driversmanagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenApplicationPopUps {

    /*
    This popups is for the one when we open any application and
    it's asking us to give username and password to go further, without providing their requirements
    we can not go further.
     */

    public static void main(String[] args) {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\updatedchromeversion\\chromedriver.exe");
        driver=new ChromeDriver();

       /*
        format for that kind of popups
        http://username:password@test.com
        driver.get("http://the-internet.herokuapp.com/basic_auth");this is the url
        here we have username and password is admin ,admin
        if you don't enter username and password,then it will ask over there.
        and there you can not enter anything overthere.

        */

        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
