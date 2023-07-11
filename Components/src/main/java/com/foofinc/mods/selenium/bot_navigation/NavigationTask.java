package com.foofinc.mods.selenium.bot_navigation;

import org.openqa.selenium.WebElement;

public abstract class NavigationTask {

    protected NavigationTask(WebElement e) {
        this.e = e;
    }

    protected WebElement e;

    protected abstract void execute();
}
