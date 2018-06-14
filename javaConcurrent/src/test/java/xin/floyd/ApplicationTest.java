package xin.floyd;

import org.junit.Test;
import xin.floyd.javascheduling.SimpleScheduler;

public class ApplicationTest {

    @Test
    public void testApplication() {
        SimpleScheduler simpleScheduler = new SimpleScheduler();
        simpleScheduler.scheduleTask();
    }
}
