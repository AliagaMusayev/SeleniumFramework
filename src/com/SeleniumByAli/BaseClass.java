package com.SeleniumByAli;

import com.SeleniumByAli.CustomExceptions.CookieUnavailableException;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.HashSet;
import java.util.Set;


public class BaseClass <T extends WebDriver> implements LogInOut, IBaseClass{


    // NOTE: Either you can use Base Class methods, or you can implement IBaseClass and write method's body as you think
      protected static WebDriver _driver;
      EventFiringWebDriver driver;
      WebDriverListener listener = new WebDriverListener();
      Actions myActions;
      FirefoxOptions options;
      FirefoxProfile profile;

       public BaseClass(T typeOfBrowser, boolean acceptUntrustedCertificates){

           if(typeOfBrowser instanceof FirefoxDriver){
               SetAcceptUntrustedCertificatesOnFirefox(options, profile, _driver, acceptUntrustedCertificates);
           }
           else{
               this._driver = typeOfBrowser;
           }

           driver = new EventFiringWebDriver(_driver);
           driver.register(listener);
           myActions = new Actions(driver);
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

    @Override
    public void gotoURL(String url){
        driver.get(url);
    }

    @Override
    public void FocusOn(String window){
        driver.switchTo().window(window);
    }

    @Override
    public void FocusOn(String window, int frameIndex){
        driver.switchTo().window(window);
        driver.switchTo().frame(frameIndex);
    }

    @Override
    public void FocusOnlyFrame(String frame){
           driver.switchTo().frame(frame);
    }

    @Override
    public void waitWhileElementVisible(By selector, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selector)));
    }

    @Override
    public void waitWhileElementClickable(By selector, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    @Override
    public void waitWhileWebPageCompletelyReady(int pageLoadTimeout){
        new WebDriverWait(driver, pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    @Override
    public void selectValueFromDropdownByText(By selectionCriteria, String ByText){
        Select select = new Select(driver.findElement(selectionCriteria));
        select.selectByVisibleText(ByText);
    }

    @Override
    public void selectValueFromDropdownByValue(By selectionCriteria, String ByValue){
        Select select = new Select(driver.findElement(selectionCriteria));
        select.selectByValue(ByValue);
    }

    @Override
    public void selectValueFromDropdownByIndex(By selectionCriteria, int index){
        Select select = new Select(driver.findElement(selectionCriteria));
        select.selectByIndex(index);
    }

    @Override
    public void clickButton(By selector){
        driver.findElement(selector).click();
    }

    @Override
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

    @Override
    public void ClickNeededCheckbox(By selector, int indexOfCheckbox){
        driver.findElements(selector).get(indexOfCheckbox).click();
    }

    @Override
    public void ClickNeededRadioButton(By selector, int indexOfCheckbox){
        driver.findElements(selector).get(indexOfCheckbox).click();
    }

    @Override
    public void executeJavascript(String nameOfJavascriptMethod){
        ((JavascriptExecutor)driver).executeScript(nameOfJavascriptMethod);
    }

    @Override
    public <T> boolean AssertResult(T value1, T value2) {
        if(value1 == value2)
            return true;
        else return false;
    }

    // TODO : There found a bug during testing of AssertTrue method. Fix it
    @Override
    public <T> void AssertTrue(T value1, T value2) {
        Assert.assertTrue(value1 == value2,"Error: "+value1 +" != "+value2+". But they must be equal");
    }

    @Override
    public <T> void AssertFalse(T value1, T value2) {
        Assert.assertFalse(value1 == value2, "Error: "+value1 +" = "+value2+". But they must be different");
    }

    @Override
    public void DeleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    @Override
    public void DeleteCookie(String cookie) {
           Cookie selectedCookie = driver.manage().getCookieNamed(cookie);
           driver.manage().deleteCookie(selectedCookie);
    }

    @Override
    public HashSet<Cookie> getAllCookies() throws CookieUnavailableException {
           HashSet<Cookie> cookieList;
           try{
               cookieList = (HashSet<Cookie>) driver.manage().getCookies();
           }
           catch (Exception ex){
               throw new CookieUnavailableException("Exception: For now it is impossible to get all cookies");
           }
        return cookieList;
    }

    @Override
    public Cookie getCookie(String name) {
        return driver.manage().getCookieNamed(name);
    }

    @Override
    public void addCookie(Cookie name)
    {
        driver.manage().addCookie(name);
    }

    @Override
    public boolean IsElementPresent(By locator) {
               int countOfElement = driver.findElements(locator).size();
               if (countOfElement>0) {
                   return true;
               } else { return false; }
    }

    @Override
    public void ResetDriverOptionsToDefault() {
        driver.switchTo().defaultContent();
    }

    @Override
    public Set<String> GetAllWindows() {
        return driver.getWindowHandles();
    }

    @Override
    public String GetSelectedWindowByIndex(int index) {
        return driver.getWindowHandles().toArray()[index].toString();
    }

    @Override
    public void AcceptAlert(){
         driver.switchTo().alert().accept();
    }

    @Override
    public void DismissAlert(){
           driver.switchTo().alert().dismiss();
    }

    @Override
    public String GetTextAlert(){
           return driver.switchTo().alert().getText();
    }

    @Override
    public void SendKeysToAlert(String text){
           driver.switchTo().alert().sendKeys(text);
    }

    @Override
    public void DragElement(WebElement target, WebElement destination) {
        myActions.dragAndDrop(target,destination);
    }

    @Override
    public void SlideElement(WebElement target, int xOffset, int yOffset) {
        myActions.dragAndDropBy(target,xOffset,yOffset);
    }

    @Override
    public void ResizeElement(WebElement target, int xOffset, int yOffset) {
        myActions.dragAndDropBy(target,xOffset,yOffset);
    }

    @Override
    public void SetAcceptUntrustedCertificatesOnFirefox(FirefoxOptions option, FirefoxProfile profile, WebDriver driver, boolean accept) {
        option = new FirefoxOptions();
        profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(accept);
        profile.setAssumeUntrustedCertificateIssuer(accept);
        option.setProfile(profile);
        driver = new FirefoxDriver(option);
    }
}


