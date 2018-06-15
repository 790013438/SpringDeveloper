package cn.pzhu.async.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class Caller {

  private final AsyncTask asyncTask;

  @Autowired
  public Caller(AsyncTask asyncTask) {
    this.asyncTask = asyncTask;
  }

  public void kickOffAsyncTasks(int execCount) throws InterruptedException {
    Collection<Future<String>> results =new ArrayList<>(execCount);

    long start = System.currentTimeMillis();
    for (int idx = 0; idx < execCount; idx++) {
      results.add(asyncTask.call(idx));
    }

    results.forEach(result -> {
      try {
        System.out.println(result.get());
      } catch (InterruptedException | ExecutionException e) {
        System.out.println(e.getLocalizedMessage());
      }
    });
    System.out.println("Elapsed time: " + (System.currentTimeMillis() - start) +
        " ms");
  }
}
