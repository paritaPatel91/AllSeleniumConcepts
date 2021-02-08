package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestngTestPart2 {

    //dependongroup/dependsonMethod both methods will depends other group or method ,
    // n it will only exceute if depending group execute properly , otherwise it will ignored.

    @Test
    public void googeTestTest(){
        System.out.println("priority 1");

    }

    @Test(dependsOnMethods = "mailTest")
    public void logoTest(){
        System.out.println("priority 2");
    }

    @Test
    public void mailTest(){
        System.out.println("priority 3");
        int i =9/0;
    }
}
