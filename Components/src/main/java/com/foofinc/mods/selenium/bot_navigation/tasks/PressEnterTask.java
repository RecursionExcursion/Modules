package com.foofinc.mods.selenium.bot_navigation.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import selenium.bot_navigation.NavigationTask;

public class PressEnterTask extends NavigationTask {


    PressEnterTask(WebElement e) {
        super(e);
    }

    @Override
    public void execute() {
        e.sendKeys(Keys.ENTER);
    }
}
