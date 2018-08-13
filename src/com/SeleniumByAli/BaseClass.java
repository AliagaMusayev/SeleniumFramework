package com.SeleniumByAli;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass <T extends WebDriver> {

      protected static WebDriver _driver;

       public BaseClass(T typeOfBrowser){
           this._driver = typeOfBrowser;
       }


    public void Login(By elementForUsernameFiled, By elementForPasswordField, String username, String password, By elementForSubmitForm){
        _driver.findElement(elementForUsernameFiled).clear();
        _driver.findElement(elementForUsernameFiled).sendKeys(username);

        _driver.findElement(elementForPasswordField).clear();
        _driver.findElement(elementForPasswordField).sendKeys(password);

        _driver.findElement(elementForSubmitForm).click();
    }

    public void gotoURL(String url){
           _driver.get(url);
    }

    public void FocusOn(String window){
        _driver.switchTo().window(window);
    }

    public void FocusOn(String window, int frameIndex){
        _driver.switchTo().window(window);
        _driver.switchTo().frame(frameIndex);
    }

    public void waitWhileElementVisible(By selector, int seconds){
        WebDriverWait wait = new WebDriverWait(_driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(_driver.findElement(selector)));
    }

    public void waitWhileElementClickable(By selector, int seconds){
        WebDriverWait wait = new WebDriverWait(_driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    public void waitWhileWebPageCompletelyReady(int pageLoadTimeout){
        new WebDriverWait(_driver, pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) _driver).executeScript("return document.readyState").equals("complete"));
    }

    public void selectValueFromDropdownByText(By selectionCriteria, String ByText){
        Select select = new Select(_driver.findElement(selectionCriteria));
        select.selectByVisibleText(ByText);
    }

    public void selectValueFromDropdownByValue(By selectionCriteria, String ByValue){
        Select select = new Select(_driver.findElement(selectionCriteria));
        select.selectByValue(ByValue);
    }

    public void selectValueFromDropdownByIndex(By selectionCriteria, int index){
        Select select = new Select(_driver.findElement(selectionCriteria));
        select.selectByIndex(index);
    }

    public void clickButton(By selector){
           _driver.findElement(selector).click();
    }

    public void SendKeysInSelectedTextField(String text, By... selectors){
           if(selectors.length==1){
               _driver.findElement(selectors[0]).clear();
               _driver.findElement(selectors[0]).sendKeys(text);
           }
           else {

               for(By element : selectors){
                   _driver.findElement(element).clear();
                   _driver.findElement(element).sendKeys(text);
               }
           }
    }

    public void ClickNeededChecbox(By selector, int indexOfCheckbox){
           _driver.findElements(selector).get(indexOfCheckbox).click();
    }

    public void ClickNeededRadioButton(By selector, int indexOfCheckbox){
        _driver.findElements(selector).get(indexOfCheckbox).click();
    }
}


