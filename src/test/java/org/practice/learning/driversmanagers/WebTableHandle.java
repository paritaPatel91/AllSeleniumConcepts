package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

    //not working this code

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\updatedchromeversion\\chromedriver.exe");
        driver=new ChromeDriver();

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        /*
        x-path of all the Rows
        Here tr means table Rows
        and td means table Column

        //*[@id="customers"]/tbody/tr[2]/td[1]
        //*[@id="customers"]/tbody/tr[3]/td[1]
        //*[@id="customers"]/tbody/tr[4]/td[1]
        //*[@id="customers"]/tbody/tr[5]/td[1]
        //*[@id="customers"]/tbody/tr[6]/td[1]
        //*[@id="customers"]/tbody/tr[7]/td[1]


         */

      String beforeX_path="//*[@id='customers']/tbody/tr[";
      String afterX_path = "]/td[1]";

        //*[@id="customers"]/tbody/tr[2]/td[2]
        //*[@id="customers"]/tbody/tr[1]/th[2]

        for (int i = 2; i <=7 ; i++) {
            String actaulX_path = beforeX_path + afterX_path;
            String companyName = driver.findElement(By.xpath(actaulX_path)).getText();
            System.out.println(companyName);

        }




    }


}
