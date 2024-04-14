package edu.bu.met.cs665.task.config;

import edu.bu.met.cs665.task.basic.ComplexTask;

/**
 * Name: Yulong Liu
 * Course: CS-665 Software Designs & Patterns
 * Date: 2024/4/14 16:57
 * File Name: LoggingConfig.java
 * Description: logging config
 */
public class LoggingConfig implements TaskConfig {
    private final boolean enable;

    public LoggingConfig(boolean enable) {
        this.enable = enable;
    }

    @Override
    public void applyConfig(ComplexTask task) {
        task.setLoggingEnabled(enable);
    }
}
