package edu.bu.met.cs665.task.manager;

import edu.bu.met.cs665.task.basic.ComplexTask;
import edu.bu.met.cs665.task.basic.Task;
import edu.bu.met.cs665.task.config.ObserverConfig;
import edu.bu.met.cs665.task.config.RetryConfig;
import edu.bu.met.cs665.task.config.TaskConfig;
import edu.bu.met.cs665.task.config.TimeoutConfig;
import edu.bu.met.cs665.task.observer.TaskObserverImpl1;
import org.junit.Test;

public class TestTask {
    @Test
    public void testBasicTask() {
        Task task = new Task() {
            @Override
            public void execute() {
                System.out.println("do some basic logic");
            }
        };
        task.execute();
    }

    /**
     * This will create 10 threads pool to run the tread concurrently
     * and I add some configs into different task
     *
     * @throws InterruptedException
     */
    @Test
    public void testBasic() throws InterruptedException {
        TaskManager taskManager = new TaskManager(10);
        TaskObserverImpl1 ob1 = new TaskObserverImpl1("ob1");
        TaskObserverImpl1 ob2 = new TaskObserverImpl1("ob2");

        ComplexTask complexTask1 = new ComplexTask(1, new TaskConfig[]{
                new RetryConfig(4),
                new TimeoutConfig(5000),
        });

        taskManager.submitTask(complexTask1);

        ComplexTask complexTask2 = new ComplexTask(2, new TaskConfig[]{
                new RetryConfig(5),
                new ObserverConfig(ob1, ob2),
                new TimeoutConfig(5000),
        });
        taskManager.submitTask(complexTask2);

        ComplexTask complexTask3 = new ComplexTask(3, new TaskConfig[]{
                new RetryConfig(2),
                new ObserverConfig(ob2),
                new TimeoutConfig(10000),
        });
        taskManager.submitTask(complexTask3);

        ComplexTask complexTask4 = new ComplexTask(4, new TaskConfig[]{
                new RetryConfig(4),
                new ObserverConfig(ob1),
                new TimeoutConfig(5000),
        });
        taskManager.submitTask(complexTask4);

        Thread.sleep(9999999);
    }
}
