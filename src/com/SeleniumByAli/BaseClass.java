package com.SeleniumByAli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass <T extends WebDriver> {

      protected T t;
      protected WebDriver _driver;

       public BaseClass(T t){
          this.t = t;
           this._driver = this.t;
       }


    protected void Login(By elementForUsernameFiled, By elementForPasswordField, String username, String password, By elementForSubmitForm){
        _driver.findElement(elementForUsernameFiled).clear();
        _driver.findElement(elementForUsernameFiled).sendKeys(username);

        _driver.findElement(elementForPasswordField).clear();
        _driver.findElement(elementForPasswordField).sendKeys(password);

        _driver.findElement(elementForSubmitForm).click();
    }

    protected void FocusOn(String window){
        _driver.switchTo().window(window);
    }

    protected void FocusOn(String window, int frameIndex){
        _driver.switchTo().window(window);
        _driver.switchTo().frame(frameIndex);
    }

    protected void waitWhileElementVisible(By selector, int seconds){
        WebDriverWait wait = new WebDriverWait(_driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(_driver.findElement(selector)));
    }

    protected void waitWhileElementClickable(By selector, int seconds){
        WebDriverWait wait = new WebDriverWait(_driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    protected void selectValueFromDropdownByText(By selectionCriteria, String ByText){
        Select select = new Select(_driver.findElement(selectionCriteria));
        select.selectByVisibleText(ByText);
    }

    protected void selectValueFromDropdownByValue(By selectionCriteria, String ByValue){
        Select select = new Select(_driver.findElement(selectionCriteria));
        select.selectByValue(ByValue);
    }

    protected void selectValueFromDropdownByIndex(By selectionCriteria, int index){
        Select select = new Select(_driver.findElement(selectionCriteria));
        select.selectByIndex(index);
    }

    protected void clickButton(By selector){
           _driver.findElement(selector).click();
    }

    protected void SendKeysInSelectedTextField(String text, By... selectors){
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

    protected void ClickNeededChecbox(By selector, int indexOfCheckbox){
           _driver.findElements(selector).get(indexOfCheckbox).click();
    }

    protected void ClickNeededRadioButton(By selector, int indexOfCheckbox){
        _driver.findElements(selector).get(indexOfCheckbox).click();
    }
}


