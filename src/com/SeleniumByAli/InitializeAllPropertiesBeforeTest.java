package com.SeleniumByAli;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitializeAllPropertiesBeforeTest <T> {

    public InitializeAllPropertiesBeforeTest(T typeOfBrowser) throws Exception {
        if(T instanceof FirefoxDriver){
            System.setProperty("webdriver.gecko.driver","");
        }
        else if (T instanceof ChromeDriver){
            System.setProperty("webdriver.chrome.driver","");
        }

        else {
            throw  new Exception("Please select true browser type and then Re-run tests");
        }


    }
}
