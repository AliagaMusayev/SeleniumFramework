package com.SeleniumByAli;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BaseClass <T extends WebDriver> implements LogInOut, IBaseClass{


    // NOTE: Either you can use Base Class methods, or you can implement IBaseClass and write method's body as you think
      protected static WebDriver _driver;
      EventFiringWebDriver driver = null;
      WebDriverListener listener = new WebDriverListener();

       public BaseClass(T typeOfBrowser){
           this._driver = typeOfBrowser;
           driver = new EventFiringWebDriver(_driver);
           driver.register(listener);
       }



    @Override
    public void Login(By elementForUsernameFiled, By elementForPasswordField, String username, String password, By elementForSubmitForm){
        driver.findElement(elementForUsernameFiled).clear();
        driver.findElement(elementForUsernameFiled).sendKeys(username);

        driver.findElement(elementForPasswordField).clear();
        driver.findElement(elementForPasswordField).sendKeys(password);

        driver.findElement(elementForSubmitForm).click();
    }

    @Override
    public void LogOut(By selector) {
        driver.findElement(selector).click();
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

    public void ClickNeededCheckbox(By selector, int indexOfCheckbox){
        driver.findElements(selector).get(indexOfCheckbox).click();
    }

    public void ClickNeededRadioButton(By selector, int indexOfCheckbox){
        driver.findElements(selector).get(indexOfCheckbox).click();
    }

    public void executeJavascript(String nameOfJavascriptMethod){
        ((JavascriptExecutor)driver).executeScript(nameOfJavascriptMethod);
    }

    @Override
    public <T> boolean AssertResult(T value1, T value2) {
        if(value1 == value2)
            return true;
        else return false;
    }

    @Override
    public <T> void AssertTrue(T value1, T value2) {
        Assert.assertTrue(value1 == value2,"Error: "+value1 +" != "+value2+". But they must be equal");
    }

    @Override
    public <T> void AssertFalse(T value1, T value2) {
        Assert.assertFalse(value1 == value2, "Error: "+value1 +" = "+value2+". But they must be different");
    }
}


