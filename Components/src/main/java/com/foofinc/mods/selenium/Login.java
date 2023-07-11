package com.foofinc.mods.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.nav_ex.ButtonClickTask;
import selenium.nav_ex.NavigationExecutor;
import selenium.nav_ex.WriteInElementTask;


public class Login {

    private static final NavigationExecutor navigationExecutor = NavigationExecutor.getInstance();

    public static void login(WebDriver driver, String username, String password) {
        WebElement loginElement = driver.findElement(By.id("session_key"));
        WebElement passwordElement = driver.findElement(By.id("session_password"));
        WebElement submitButton = driver.findElement(By.className("sign-in-form__submit-btn--full-width"));

        System.out.println();

        navigationExecutor.addTasks(new WriteInElementTask(loginElement, username),
                                    new WriteInElementTask(passwordElement, password),
                                    new ButtonClickTask(submitButton));
        navigationExecutor.execute();
    }

}
