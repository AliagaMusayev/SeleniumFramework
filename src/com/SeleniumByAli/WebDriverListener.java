package com.SeleniumByAli;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListener extends AbstractWebDriverEventListener {

    public void beforeAlertAccept(WebDriver driver) {
        // Do nothing.
    }

    public void afterAlertAccept(WebDriver driver) {
        // Do nothing.
    }

    public void afterAlertDismiss(WebDriver driver) {
        // Do nothing.
    }

    public void beforeAlertDismiss(WebDriver driver) {
        // Do nothing.
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Requested URL Loading..., Please wait for a while");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        // Do nothing.
    }

    public void beforeNavigateBack(WebDriver driver) {
        // Do nothing.
    }

    public void afterNavigateBack(WebDriver driver) {
        // Do nothing.
    }

    public void beforeNavigateForward(WebDriver driver) {
        // Do nothing.
    }

    public void afterNavigateForward(WebDriver driver) {
        // Do nothing.
    }

    public void beforeNavigateRefresh(WebDriver driver) {
        // Do nothing.
    }

    public void afterNavigateRefresh(WebDriver driver) {
        // Do nothing.
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        // Do nothing.
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        // Do nothing.
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        // Do nothing.
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        // Do nothing.
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // Do nothing.
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // Do nothing.
    }

    public void beforeScript(String script, WebDriver driver) {
        // Do nothing
    }

    public void afterScript(String script, WebDriver driver) {
        // Do nothing
    }

    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        // Do nothing
    }

    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        // Do nothing
    }

    public void onException(Throwable throwable, WebDriver driver) {
        // Do nothing
    }

    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        // Do nothing
    }

    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        // Do nothing
    }

    public void beforeGetText(WebElement element, WebDriver driver) {
        // Do nothing
    }

    public void afterGetText(WebElement element, WebDriver driver, String text) {
        // Do nothing
    }
}
