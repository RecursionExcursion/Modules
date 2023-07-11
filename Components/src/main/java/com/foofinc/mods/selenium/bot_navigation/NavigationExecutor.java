package com.foofinc.mods.selenium.bot_navigation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import static selenium.Util.sleepHumanPageNavigation;


public class NavigationExecutor {

    private static NavigationExecutor instance;
    private final Queue<NavigationTask> taskQueue = new ArrayDeque<>();


    private NavigationExecutor() {
    }

    public static NavigationExecutor getInstance() {
        if (instance == null) {
            instance = new NavigationExecutor();
        }
        return instance;
    }

    public NavigationExecutor addTasks(NavigationTask... tasks) {
        taskQueue.addAll(Arrays.asList(tasks));
        return this;
    }


    public void execute() {
        sleepHumanPageNavigation();
        while (!taskQueue.isEmpty()) {
            taskQueue.poll().execute();
            sleepHumanPageNavigation();
        }
    }
}
