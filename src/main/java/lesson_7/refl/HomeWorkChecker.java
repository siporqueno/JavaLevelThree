package lesson_7.refl;

//import org.junit.runner.JUnitCore;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.HOURS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HomeWorkChecker {
//    JUnitCore jUnitCore =
    public static void main(String[] args) {
        new HomeWorkChecker().beepForAnHour();
    }

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        Runnable beeper = () -> System.out.println("beep");
        ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        Runnable canceller = () -> beeperHandle.cancel(true);
        scheduler.schedule(canceller, 1, HOURS);
    }
}
