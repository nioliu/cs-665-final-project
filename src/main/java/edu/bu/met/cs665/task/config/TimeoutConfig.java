package edu.bu.met.cs665.task.config;

import edu.bu.met.cs665.task.basic.ComplexTask;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:55
 * File Name: TimeoutConfig.java
 * Description: timeout config
 */
public class TimeoutConfig implements TaskConfig {
    private long timeout = -1;

    /**
     * set the timeout with milliseconds
     *
     * @param timeout millisecond
     */
    public TimeoutConfig(long timeout) {
        if (timeout <= 0) {
            System.out.println("Invalid timeout value: " + timeout);
            return;
        }
        this.timeout = timeout;
    }

    @Override
    public void applyConfig(ComplexTask task) {
        task.setTimeout(timeout);
    }
}
