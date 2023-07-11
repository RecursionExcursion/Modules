package com.foofinc.mods.selenium.bot_navigation.tasks;

import org.openqa.selenium.WebElement;
import selenium.bot_navigation.NavigationTask;

public class TaskFactory {

    public static ClickTask createClickTask(WebElement webElement) {
        return (ClickTask) createTask(ClickTask.class, webElement);
    }

    public static PressEnterTask createPressEnterTask(WebElement webElement) {
        return (PressEnterTask) createTask(PressEnterTask.class, webElement);
    }

    public static WriteInElementTask createWriteInElementTask(WebElement webElement, String s) {
        return (WriteInElementTask) createTask(WriteInElementTask.class, webElement, s);
    }

    private static NavigationTask createTask(Class<? extends NavigationTask> clazz, Object... args) {
        try {
            if (clazz == ClickTask.class) {
                return new ClickTask((WebElement) args[0]);
            } else if (clazz == PressEnterTask.class) {
                return new PressEnterTask((WebElement) args[0]);
            } else if (clazz == WriteInElementTask.class) {
                return new WriteInElementTask((WebElement) args[0], (String) args[1]);
            } else throw new ClassNotFoundException("Class not found");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
