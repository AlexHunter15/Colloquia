import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

class RepeatingThreadPoolExecutorTest {

    @Repeat(3)
    static class RepeatedRunnable implements Runnable {
        static int count = 0;
        @Override
        public void run() {
            count++;
        }
    }

    @Test
    void testRepeatedTaskExecution() throws InterruptedException {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 1000;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        RepeatingThreadPoolExecutor executor = new RepeatingThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, workQueue);

        RepeatedRunnable.count = 0;

        executor.execute(new RepeatedRunnable());

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        assertEquals(3, RepeatedRunnable.count, "Task should have executed 3 times");
    }

    @Test
    void testNonRepeatedTaskExecution() throws InterruptedException {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 1000;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        RepeatingThreadPoolExecutor executor = new RepeatingThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, workQueue);

        RepeatedRunnable.count = 0;

        executor.execute(() -> {
            RepeatedRunnable.count++;
        });

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        assertEquals(1, RepeatedRunnable.count, "Task should have executed only once");
    }
}
