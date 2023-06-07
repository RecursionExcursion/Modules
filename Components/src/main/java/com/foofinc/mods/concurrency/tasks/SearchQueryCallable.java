package com.foofinc.mods.concurrency.tasks;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class SearchQueryCallable implements Callable<List<Map.Entry<Long, String>>> {

    private final String searchString;

    public SearchQueryCallable(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public List<Map.Entry<Long, String>> call() {
        return null;
    }
}
