package xin.floyd.javaconcurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SimpleTaskExecutor {

  private final ExecutorService executorService;
  private final int execCount;

  /* 赋值,类似file io操作，给个盒子，随意摇 */
  /* 给个壳子，像轿车 */
  public SimpleTaskExecutor(ExecutorService executorService,
      int execCount) {
    super();
    this.executorService = executorService;
    this.execCount = execCount;
  }

  /* 给个收集结果的容器 */
  public void executeTask() throws InterruptedException {
    Collection<Future<String>> results = new ArrayList<>(execCount);
    long start = System.currentTimeMillis();
    /* 指定线程要执行的任务 ，想想IO的文件操作 */
    SimpleTask task = new SimpleTask();
    for (int idx = 0; idx < execCount; idx++) {
      results.add(executorService.submit(task));
    }

    /* 不再接受新的submit，对应IO的close */
    executorService.shutdown();
    /* block，等待所有线程执行完，flush*/
    executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);

    results.forEach(result -> {
      try {
        /* 得到执行结果 */
        System.out.println(result.get());
      } catch (InterruptedException | ExecutionException exception) {
        System.out.println(exception.getLocalizedMessage());
      }
    });
    System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
  }
}
