package com.foofinc.mods;

import com.foofinc.mods.selenium.WebDriverInitializer;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {

        Bot.run();

    }
}

class Bot {

    public static void run() {


        WebDriver driver = WebDriverInitializer.initialize("https://scrapeme.live/shop/");


    }


}
