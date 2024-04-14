package edu.bu.met.cs665;

import edu.bu.met.cs665.task.basic.ComplexTask;
import edu.bu.met.cs665.task.config.*;
import edu.bu.met.cs665.task.manager.TaskManager;
import edu.bu.met.cs665.task.observer.TaskObserverImpl1;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(10);

        ComplexTask complexTask = new ComplexTask(1, new TaskConfig[]{
                new RetryConfig(4),
                new ObserverConfig(new TaskObserverImpl1("ob1"), new TaskObserverImpl1("ob2")),
                new TimeoutConfig(5000),
        });
        taskManager.submitTask(complexTask);
    }
}
