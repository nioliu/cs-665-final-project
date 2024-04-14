package edu.bu.met.cs665.task.observer;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:53
 * File Name: TaskObserverImpl.java
 * Description: Basic implementation of TaskObserver interface
 */
public abstract class TaskObserverImpl implements TaskObserver {
    final String observerId;

    public TaskObserverImpl(String observerId) {
        this.observerId = observerId;
    }

    @Override
    public void onTaskCompleted(int taskId, String result) {
        System.out.printf((defaultTemplate()) + "%n", observerId, taskId, result);
    }

    public String defaultTemplate() {
        return "%s know task-%d has been completed with message %s!";
    }
}
