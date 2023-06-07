package com.foofinc.mods.concurrency.tasks;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.util.Map;

public class AddAppToWatchListTask extends Task<Object> {

    private final Map.Entry<Long, String> appMapEntry;
    private final ObservableList<Object> items;

    public AddAppToWatchListTask(Map.Entry<Long, String> appMapEntry, ObservableList<Object> items) {
        this.appMapEntry = appMapEntry;
        this.items = items;
    }

    @Override
    protected Object call() {
        return null;
    }
}
