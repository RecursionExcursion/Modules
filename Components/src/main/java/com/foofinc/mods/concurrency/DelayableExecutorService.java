package com.foofinc.mods.concurrency;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayableExecutorService {
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private long delay;

    public DelayableExecutorService(long delayInMilliseconds) {
        delayInMilliseconds = delay;
    }

    public void addTasks(Runnable... runnables) {
        tasks.addAll(List.of(runnables));
    }

    public void addAllTasks(Collection<Runnable> c) {
        tasks.addAll(c);
    }

    public void invokeAll() {
        if (!tasks.isEmpty()) {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            int i = 0;
            for (Runnable task : tasks) {
                executor.schedule(task, delay + (delay * i++), TimeUnit.MILLISECONDS);
            }
            executor.shutdown();
        }
    }

    public void setMillisecondWait(long delayInMilliseconds) {
        delay = delayInMilliseconds;
    }
}