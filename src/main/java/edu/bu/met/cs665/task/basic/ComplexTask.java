package edu.bu.met.cs665.task.basic;

import edu.bu.met.cs665.task.config.TaskConfig;
import edu.bu.met.cs665.task.observer.TaskObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:17
 * File Name: ComplexTask.java
 * Description: ComplexTask is a runnable class, implement Task
 */

public class ComplexTask implements Task, Runnable {
    // task id
    private final int taskId;
    // can this task be logged
    private boolean loggingEnabled = true;
    // the max times to retry
    private int maxAttempts = 1;
    // task will be ended if time out
    private long timeout = -1;
    // notify observers when task complete
    private final List<TaskObserver> observers = new ArrayList<>();

    // add config to this Task
    public void addConfig(TaskConfig config) {
        config.applyConfig(this);
    }

    // add new observers to this task
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    // notify observers
    private void notifyObservers(String result) {
        for (TaskObserver observer : observers) {
            observer.onTaskCompleted(taskId, result);
        }
    }

    // init a complex task
    public ComplexTask(int taskId, TaskConfig[] configs) {
        this.taskId = taskId;
        if (configs != null) {
            for (TaskConfig config : configs) {
                config.applyConfig(this);
            }
        }
    }

    public void setLoggingEnabled(boolean enabled) {
        this.loggingEnabled = enabled;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    // true execute logic
    @Override
    public void execute() {
        if (loggingEnabled) {
            System.out.println("Starting task " + taskId);
        }

        int attempts = 0;
        boolean success = false;
        long startTime = System.currentTimeMillis();

        // attempt and retry if failed
        while (attempts < maxAttempts && !success) {
            try {
                // mock fail logic
                if (attempts < 3) {
                    Thread.sleep(1000);
                    System.out.printf("mock fail: Task-%d fail %d times\n", taskId, attempts + 1);
                } else {
                    success = true;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task " + taskId + " was interrupted");
                break;
            }
            attempts++;

            // check if time out
            if (timeout > 0 && System.currentTimeMillis() - startTime > timeout) {
                System.out.println("Task " + taskId + " timed out.");
                break;
            }
        }

        // print log if enabled
        if (success && loggingEnabled) {
            System.out.println("Task " + taskId + " completed successfully.");
        } else if (!success) {
            System.out.println("Task " + taskId + " failed to complete.");
        }

        // notify observers with the result
        notifyObservers(success ? "success" : "fail");
    }

    @Override
    public void run() {
        this.execute();
    }
}
