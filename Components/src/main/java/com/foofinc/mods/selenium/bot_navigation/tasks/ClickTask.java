package com.foofinc.mods.selenium.bot_navigation.tasks;

import org.openqa.selenium.WebElement;
import selenium.bot_navigation.NavigationTask;

public class ClickTask extends NavigationTask {

    ClickTask(WebElement e) {
        super(e);
    }

    @Override
    public void execute() {
        e.click();
    }
}
