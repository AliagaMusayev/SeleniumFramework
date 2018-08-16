package com.SeleniumByAli;

import com.SeleniumByAli.CustomExceptions.CookieUnavailableException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

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
}
