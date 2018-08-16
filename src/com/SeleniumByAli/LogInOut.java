package com.SeleniumByAli;

import org.openqa.selenium.By;

public interface LogInOut {
    void Login(By elementForUsernameFiled, By elementForPasswordField, String username, String password, By elementForSubmitForm);
    void LogOut(By selector);
}
