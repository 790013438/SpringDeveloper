package xin.floyd.javascheduling;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimpleScheduler {

  public void scheduleTask() {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledExecutorService.scheduleAtFixedRate(scheduledTask, 0L, 1, TimeUnit.SECONDS);
  }
}
