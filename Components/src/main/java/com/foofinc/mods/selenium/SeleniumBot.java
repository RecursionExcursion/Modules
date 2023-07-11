package com.foofinc.mods.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.nav_ex.ButtonClickTask;
import selenium.nav_ex.NavigationExecutor;
import selenium.nav_ex.PressEnterTask;
import selenium.nav_ex.WriteInElementTask;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SeleniumBot {

    private static final NavigationExecutor executor = NavigationExecutor.getInstance();


    String un = "rloup15@gmail.com";
    String pw = "HelloBabes519";


    public void bot() {

        WebDriver driver = getRandomWebDriver();
        if(driver==null) System.exit(0);
        driver.manage().deleteAllCookies();

        driver.get("https://www.linkedin.com");

        boolean pagedLoadedSuccefull = false;
        while (!pagedLoadedSuccefull) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("session_key")));
                pagedLoadedSuccefull = true;
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        }

        Login.login(driver, un, pw);

        WebElement jobsElement = driver.findElement(By.linkText("Jobs"));

        executor.addTasks(new

                                  ButtonClickTask(jobsElement));
        executor.execute();


        //        WebElement jobDescriptionElement = driver.findElement(By.id("jobs-search-box-keyword-id-ember933"));
        WebElement jobDescriptionElement = driver.findElement(By.className("jobs-search-box__text-input"));
        executor.addTasks(new

                                  WriteInElementTask(jobDescriptionElement, "Junior Java Developer"));
        executor.addTasks(new

                                  PressEnterTask(jobDescriptionElement));

        executor.execute();
        List<WebElement> buttonElements = driver.findElements(By.tagName("button"));
        WebElement button;
        for (WebElement buttonElement : buttonElements) {
            if(buttonElement!=null){
                try {
                    String ariaLabel = buttonElement.getAttribute("aria-label");
                    String text = buttonElement.getText();

                    if (ariaLabel !=null && ariaLabel.contains("Show all filters")) {
                        executor.addTasks(new ButtonClickTask(buttonElement));
                        executor.execute();
                        break;  // Exit the loop once the specific fieldset element is found
                    }
                } catch (Exception ignore) {}
            }

        }

        List<WebElement> elements = driver.findElements(By.tagName("fieldset"));

        WebElement specificFieldsetElement = null;

        for (WebElement fieldSetElement : elements) {

            String  attrString = fieldSetElement.getAttribute("data-control-name");

//            WebElement legendElement = fieldSetElement.findElement(By.tagName("legend"));
//            String legendText = legendElement.getText();

//            if (legendText.contains("Easy Apply filter")) {
//                specificFieldsetElement = fieldSetElement;
//                break;  // Exit the loop once the specific fieldset element is found
//            }
            if (attrString.equalsIgnoreCase("filter_detail_select")) {
                specificFieldsetElement = fieldSetElement;

                break;  // Exit the loop once the specific fieldset element is found
            }
        }

//        if (specificFieldsetElement != null) {
//            WebElement inputElement = specificFieldsetElement.findElement(By.tagName("input"));
//            inputElement.click();
//            // Perform actions on the specific input element
//        } else {
//            // Handle the case when the specific fieldset element is not found
//        }


    }

    public static void restartDriver(WebDriver driver) {
        driver.manage().deleteAllCookies();         // Clear Cookies on the browser
        driver.quit();
        driver = null;
        driver = new ChromeDriver();
    }

    public static WebDriver getRandomWebDriver() {
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
