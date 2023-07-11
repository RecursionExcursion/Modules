package com.foofinc.mods.selenium.nav_ex;

import org.openqa.selenium.WebElement;

import java.util.Random;

public class WriteInElementTask extends NavigationTask {

    private static final Random RAND = new Random();
    private final static int SLEEP_MIN = 120;

    private final String s;

    public WriteInElementTask(WebElement e, String s) {
        super(e);
        this.s = s;
    }

    @Override
    public void execute() {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            String s1 = String.valueOf(c);
            e.sendKeys(s1);
            randomSleep();
        }
    }

    private static void randomSleep() {
        try {
            Thread.sleep(RAND.nextInt(100) + SLEEP_MIN);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
