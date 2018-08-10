package com.SeleniumByAli;

import com.SeleniumByAli.CustomExceptions.NoSuchTypeBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitializeAllPropertiesBeforeTest <T extends WebDriver> {


    public  InitializeAllPropertiesBeforeTest(T typeOfBrowser) throws Exception {

           // boolean test = typeOfBrowser.equals(new FirefoxDriver());

        if(typeOfBrowser instanceof FirefoxDriver){
            // path for gecko driver will be taken from settings.xml file
            System.setProperty("webdriver.gecko.driver","");
        }

        else if (typeOfBrowser instanceof ChromeDriver){
            System.setProperty("webdriver.chrome.driver","");
        }

        else if (typeOfBrowser instanceof InternetExplorerDriver){
            System.setProperty("webdriver.IE.driver","");
        }

        else {
            throw new NoSuchTypeBrowserException("Please select true browser type and then Re-run tests");
        }


    }
}
