package com.foofinc.mods.selenium.nav_ex;

import org.openqa.selenium.WebElement;

public class ButtonClickTask extends NavigationTask {

    public ButtonClickTask(WebElement e) {
        super(e);
    }

    @Override
    public void execute() {
        e.click();
    }
}
