package edu.bu.met.cs665.task.config;

import edu.bu.met.cs665.task.basic.ComplexTask;
import edu.bu.met.cs665.task.observer.TaskObserver;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:08
 * File Name: ObserverConfig.java
 * Description: add observer config to notify observer when task completed
 */
public class ObserverConfig implements TaskConfig {
    private final TaskObserver[] observer;

    /**
     * add task observers
     */
    public ObserverConfig(TaskObserver... observer) {
        this.observer = observer;
    }

    @Override
    public void applyConfig(ComplexTask task) {
        for (TaskObserver taskObserver : observer) {
            task.addObserver(taskObserver);
        }
    }
}

