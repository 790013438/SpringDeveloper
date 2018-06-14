package xin.floyd.javascheduling;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ScheduledTask implements Runnable {

  private final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS",
      Locale.getDefault());

  public void run() {
    System.out.println(dateFormat.format(new Date()) + " - job kicked off");
  }
}
