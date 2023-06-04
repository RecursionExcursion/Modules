package com.foofinc.mods.concurrency;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public  class DelayableThreadPool {
    private final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private long millisecondWait;

    public DelayableThreadPool(long millisecondWait) {
        this.millisecondWait = millisecondWait;
    }

    public void addTasks(Runnable... runnables){
        tasks.addAll(List.of(runnables));
    }

    public void addAllTasks(Collection<Runnable> c){
        tasks.addAll(c);
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public void invokeAll() {
        if (!tasks.isEmpty()) {
            final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
            synchronized (singleThreadExecutor) {
                while (!tasks.isEmpty()) {
                    singleThreadExecutor.submit(tasks.poll());
                    try {
                        singleThreadExecutor.wait(millisecondWait);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            singleThreadExecutor.shutdown();
        }
    }

    public void setMillisecondWait(long millisecondWait) {
        this.millisecondWait = millisecondWait;
    }
}