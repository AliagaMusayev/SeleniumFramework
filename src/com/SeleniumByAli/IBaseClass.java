package com.SeleniumByAli;

import com.SeleniumByAli.CustomExceptions.CookieUnavailableException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Set;

public interface IBaseClass extends LogInOut {

    void gotoURL(String url);

    void FocusOn(String window);

    void FocusOn(String window, int frameIndex);

    void FocusOnlyFrame(String frame);

    void waitWhileElementVisible(By selector, int seconds);

    void waitWhileElementClickable(By selector, int seconds);

    void waitWhileWebPageCompletelyReady(int pageLoadTimeout);

    void selectValueFromDropdownByText(By selectionCriteria, String ByText);

    void selectValueFromDropdownByValue(By selectionCriteria, String ByValue);

    void selectValueFromDropdownByIndex(By selectionCriteria, int index);

    void clickButton(By selector);

    void SendKeysInSelectedTextField(String text, By... selectors);

    void ClickNeededCheckbox(By selector, int indexOfCheckbox);

    void ClickNeededRadioButton(By selector, int indexOfCheckbox);

    void executeJavascript(String nameOfJavascriptMethod);

    <T> boolean AssertResult(T value1, T value2);

    <T> void AssertTrue(T value1, T value2);

    <T> void AssertFalse(T value1, T value2);

    void DeleteAllCookies();

    void DeleteCookie(String cookie);

    Set<Cookie> getAllCookies() throws CookieUnavailableException;

    Cookie getCookie(String name);

    void addCookie(Cookie name);

    boolean IsElementPresent(By locator);

    void ResetDriverOptionsToDefault();

    Set<String> GetAllWindows();

    String GetSelectedWindowByIndex(int index);

    void AcceptAlert();

    void DismissAlert();

    String GetTextAlert();

    void SendKeysToAlert(String text);

    void DragElement(WebElement target, WebElement destination);

    void SlideElement(WebElement target, int xOffset, int yOffset);

    void ResizeElement(WebElement target, int xOffset, int yOffset);

    void SetAcceptUntrustedCertificatesOnFirefox(FirefoxOptions option, FirefoxProfile profile, WebDriver driver, boolean accept);
}
