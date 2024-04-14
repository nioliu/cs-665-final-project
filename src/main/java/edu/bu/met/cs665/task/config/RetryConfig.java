package edu.bu.met.cs665.task.config;

import edu.bu.met.cs665.task.basic.ComplexTask;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:57
 * File Name: RetryConfig.java
 * Description: Retry configuration
 */
public class RetryConfig implements TaskConfig {
    private int maxAttempts = 1;

    /**
     * set retry config, maxAttempts should be greater than 0
     *
     * @param maxAttempts the times you want to attempt
     */
    public RetryConfig(int maxAttempts) {
        if (maxAttempts < 1) {
            System.out.println("Max attempts must be greater than 0");
            return;
        }
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void applyConfig(ComplexTask task) {
        task.setMaxAttempts(maxAttempts);
    }
}
