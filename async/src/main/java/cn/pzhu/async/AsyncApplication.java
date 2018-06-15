package cn.pzhu.async;

import cn.pzhu.async.task.Caller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@ComponentScan(basePackageClasses = Caller.class)
@EnableAsync
@SpringBootApplication
public class AsyncApplication {

  @Autowired
  public AsyncApplication(Caller caller) {
    this.caller = caller;
  }

  @Bean
  public Executor customTaskExecutor() {
    return Executors.newWorkStealingPool();
  }

  public static void main(String[] args) {
    SpringApplication.run(AsyncApplication.class, args);
  }

  private final Caller caller;

  @Bean
  public CommandLineRunner info() {
    return args -> {
      caller.kickOffAsyncTasks(10);
    };
  }
}
