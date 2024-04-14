package edu.bu.met.cs665.task.observer;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:54
 * File Name: TaskObserver.java
 * Description: TaskObserver interface
 */
public interface TaskObserver {
    // do things when task completed
    void onTaskCompleted(int taskId, String result);
}
