import java.util.concurrent.TimeUnit;

public class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // Логика потока
            try {
                TimeUnit.SECONDS.sleep(2); // Пример длительной операции
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Состояние до запуска: " + thread.getState());

        thread.start();
        System.out.println("Состояние после запуска: " + thread.getState());

        // Даем потоку время на выполнение
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Состояние во время выполнения: " + thread.getState());

        // Ожидаем завершения потока
        thread.join();
        System.out.println("Состояние после завершения: " + thread.getState());
    }
}
