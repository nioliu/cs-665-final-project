package edu.bu.met.cs665.task.observer;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:52
 * File Name: TaskObserverImpl1.java
 * Description: basic subclass of TaskObserverImpl
 */
public class TaskObserverImpl1 extends TaskObserverImpl {
    public TaskObserverImpl1(String observerId) {
        super(observerId);
    }

    @Override
    public void onTaskCompleted(int taskId, String result) {
        super.onTaskCompleted(taskId, result);
        System.out.printf("And impl1-%s observer can will do some other logics after this...%n", observerId);
    }
}
