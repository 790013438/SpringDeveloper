package cn.pzhu.async.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

  private static final int SIMULATE_IO = 1000;

  @Async("customTaskExecutor")
  public Future<String> call(int parameter) throws InterruptedException {
    String threadName = Thread.currentThread().getName();

    Thread.sleep(SIMULATE_IO);
    if ((parameter & 1) == 0) {
      throw new UnsupportedOperationException(threadName + " threw exception");
    }
    return new AsyncResult<String>(threadName + " have parameter " + parameter);
  }
}
