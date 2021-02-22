package org.practice.learning.driversmanagers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonPatternDesignPart2 {

    public static String browserName = "chrome";
    public static String url = "https://www.google.com";


    @BeforeMethod
    public void setUp(){
        SingletonPatternDesignPart1.intialize();//calling the method
    }

    @Test
    public void TC_1(){
        //anytestcase we can do it here ,like doing in the framework
    }
    @BeforeMethod
    public void tearDown(){
        SingletonPatternDesignPart1.quit();//calling quit method
        SingletonPatternDesignPart1.close();//calling close method
    }

}

