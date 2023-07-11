package com.foofinc.mods.selenium.nav_ex;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PressEnterTask extends NavigationTask{


    public PressEnterTask(WebElement e) {
        super(e);
    }

    @Override
    public void execute() {
        e.sendKeys(Keys.ENTER);
    }
}
