package com.SeleniumByAli;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListener extends AbstractWebDriverEventListener {

    public void beforeAlertAccept(WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterAlertAccept(WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterAlertDismiss(WebDriver driver) {
        /// TODO : write generic method body
    }

    public void beforeAlertDismiss(WebDriver driver) {
        /// TODO : write generic method body.
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        // TODO : write generic method body
        System.out.println("Requested URL Loading..., Please wait for a while");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        // TODO : write generic method body
    }

    public void beforeNavigateBack(WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterNavigateBack(WebDriver driver) {
        // TODO : write generic method body
    }

    public void beforeNavigateForward(WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterNavigateForward(WebDriver driver) {
        /// TODO : write generic method body
    }

    public void beforeNavigateRefresh(WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterNavigateRefresh(WebDriver driver) {
        // TODO : write generic method body
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        // TODO : write generic method body
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        // TODO : write generic method body
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO : write generic method body
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO : write generic method body
    }

    public void beforeScript(String script, WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterScript(String script, WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        // TODO : write generic method body
    }

    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        // TODO : write generic method body
    }

    public void onException(Throwable throwable, WebDriver driver) {
        // TODO : write generic method body
    }

    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        // TODO : write generic method body
    }

    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        // TODO : write generic method body
    }

    public void beforeGetText(WebElement element, WebDriver driver) {
        // TODO : write generic method body
    }

    public void afterGetText(WebElement element, WebDriver driver, String text) {
        // TODO : write generic method body
    }
}
