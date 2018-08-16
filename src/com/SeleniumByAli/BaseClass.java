package com.SeleniumByAli;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass <T extends WebDriver> {

      protected static WebDriver _driver;
      EventFiringWebDriver driver = null;
      WebDriverListener listener = new WebDriverListener();

       public BaseClass(T typeOfBrowser){
           this._driver = typeOfBrowser;
           driver = new EventFiringWebDriver(_driver);
           driver.register(listener);
       }




    public void Login(By elementForUsernameFiled, By elementForPasswordField, String username, String password, By elementForSubmitForm){
        driver.findElement(elementForUsernameFiled).clear();
        driver.findElement(elementForUsernameFiled).sendKeys(username);

        driver.findElement(elementForPasswordField).clear();
        driver.findElement(elementForPasswordField).sendKeys(password);

        driver.findElement(elementForSubmitForm).click();
    }

    public void gotoURL(String url){
        driver.get(url);
    }

    public void FocusOn(String window){
        driver.switchTo().window(window);
    }

    public void FocusOn(String window, int frameIndex){
        driver.switchTo().window(window);
        driver.switchTo().frame(frameIndex);
    }

    public void waitWhileElementVisible(By selector, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selector)));
    }

    public void waitWhileElementClickable(By selector, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    public void waitWhileWebPageCompletelyReady(int pageLoadTimeout){
        new WebDriverWait(driver, pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void selectValueFromDropdownByText(By selectionCriteria, String ByText){
        Select select = new Select(driver.findElement(selectionCriteria));
        select.selectByVisibleText(ByText);
    }

    public void selectValueFromDropdownByValue(By selectionCriteria, String ByValue){
        Select select = new Select(driver.findElement(selectionCriteria));
        select.selectByValue(ByValue);
    }

    public void selectValueFromDropdownByIndex(By selectionCriteria, int index){
        Select select = new Select(driver.findElement(selectionCriteria));
        select.selectByIndex(index);
    }

    public void clickButton(By selector){
        driver.findElement(selector).click();
    }

    public void SendKeysInSelectedTextField(String text, By... selectors){
           if(selectors.length==1){
               driver.findElement(selectors[0]).clear();
               driver.findElement(selectors[0]).sendKeys(text);
           }
           else {

               for(By element : selectors){
                   driver.findElement(element).clear();
                   driver.findElement(element).sendKeys(text);
               }
           }
    }

    public void ClickNeededChecbox(By selector, int indexOfCheckbox){
        driver.findElements(selector).get(indexOfCheckbox).click();
    }

    public void ClickNeededRadioButton(By selector, int indexOfCheckbox){
        driver.findElements(selector).get(indexOfCheckbox).click();
    }
}


