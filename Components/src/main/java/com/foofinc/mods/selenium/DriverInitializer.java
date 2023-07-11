package com.foofinc.mods.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class DriverInitializer {


    public static WebDriver initialize(String url) {
        WebDriver driver = getRandomWebDriver();
        if (driver == null) System.exit(0);
        driver.manage().deleteAllCookies();

        driver.get(url);

        int refreshAttempt = 0;

        boolean pagedLoadedSuccefull = false;
        while (!pagedLoadedSuccefull) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("div")));
                pagedLoadedSuccefull = true;
            } catch (Exception e) {
                if (++refreshAttempt >= 3) {
                    throw new RuntimeException(String.format("Could not load %s", url));
                }
                driver.navigate().refresh();
            }
        }

        return driver;
    }


    private static WebDriver getRandomWebDriver() {
        Random r = new Random();

        switch (r.nextInt(3) + 1) {
            case 1 -> {
                return new ChromeDriver();
            }
            case 2 -> {
                return new FirefoxDriver();
            }
            case 3 -> {
                return new EdgeDriver();
            }
            default -> {
                return null;
            }
        }
    }

}
