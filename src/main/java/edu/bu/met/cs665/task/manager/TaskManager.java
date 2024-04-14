package edu.bu.met.cs665.task.manager;

import edu.bu.met.cs665.task.basic.ComplexTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:54
 * File Name: TaskManager.java
 * Description: TaskManager is used to submit tasks
 */
public class TaskManager {
    private final ExecutorService threadPool;

    /**
     * init a thread pool
     *
     * @param numberOfThreads the number of thread in pool
     */
    public TaskManager(int numberOfThreads) {
        this.threadPool = Executors.newFixedThreadPool(numberOfThreads);
    }

    /**
     * submit a new task
     *
     * @param task runnable task
     */
    public void submitTask(ComplexTask task) {
        threadPool.execute(task);
    }

    /**
     * shutdown actively
     */
    public void shutdown() {
        threadPool.shutdown();
    }
}
