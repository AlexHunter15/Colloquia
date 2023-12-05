import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Repeat {
    int value();
}

class RepeatingRunnable implements Runnable {
    private final Runnable delegate;
    private final int repetitions;

    RepeatingRunnable(Runnable delegate, int repetitions) {
        this.delegate = delegate;
        this.repetitions = repetitions;
    }

    @Override
    public void run() {
        for (int i = 0; i < repetitions; i++) {
            delegate.run();
        }
    }
}

class RepeatingThreadPoolExecutor extends ThreadPoolExecutor {
    public RepeatingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                       BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        if (command.getClass().isAnnotationPresent(Repeat.class)) {
            Repeat repeatAnnotation = command.getClass().getAnnotation(Repeat.class);
            int repetitions = repeatAnnotation.value();
            super.execute(new RepeatingRunnable(command, repetitions));
        } else {
            super.execute(command);
        }
    }
}

public class CustomThreadPoolExecutorExample {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 1000;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        RepeatingThreadPoolExecutor executor = new RepeatingThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, workQueue);

        Runnable repeatedRunnable = () -> {
            System.out.println("Executing repeated task");
        };

        // Пример использования аннотации Repeat
        @Repeat(3)
        class MyRepeatedTask implements Runnable {
            @Override
            public void run() {
                System.out.println("Executing repeated task annotated with @Repeat");
            }
        }

        executor.execute(repeatedRunnable); // Не будет повторяться
        executor.execute(new MyRepeatedTask()); // Будет выполнено 3 раза

        executor.shutdown();
    }
}
