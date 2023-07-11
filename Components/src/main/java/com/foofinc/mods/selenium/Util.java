package com.foofinc.mods.selenium;

import java.util.Random;

public class Util {

    private static final Random RAND = new Random();

    public static void sleepHumanPageNavigation() {
        try {
            Thread.sleep(RAND.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
