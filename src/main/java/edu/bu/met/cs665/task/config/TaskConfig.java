package edu.bu.met.cs665.task.config;

import edu.bu.met.cs665.task.basic.ComplexTask;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 15:49
 * File Name: TaskConfig.java
 * Description: task config interface
 */
public interface TaskConfig {
    /**
     * apply config to the task
     *
     * @param task source task
     */
    void applyConfig(ComplexTask task);
}
