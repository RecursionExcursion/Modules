package com.foofinc.mods.selenium.nav_ex;

import org.openqa.selenium.WebElement;

public abstract class NavigationTask {

    public NavigationTask(WebElement e) {
        this.e = e;
    }

    protected WebElement e;

   protected abstract void execute();
}
