package xin.floyd.javaconcurrency;

import xin.floyd.javascheduling.SimpleScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

  private static final int EXEC_COUNT = 10;

  public static void main(String...args) throws InterruptedException {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(EXEC_COUNT);
    SimpleTaskExecutor executorFast = new SimpleTaskExecutor(fixedThreadPool, EXEC_COUNT);
    executorFast.executeTask();

    ExecutorService workStealingPool = Executors.newWorkStealingPool();
    SimpleTaskExecutor executorSlow = new SimpleTaskExecutor(workStealingPool, EXEC_COUNT);
    executorSlow.executeTask();

    SimpleScheduler simpleScheduler = new SimpleScheduler();
    simpleScheduler.scheduleTask();
  }
}
