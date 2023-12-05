import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerExample {
    private static final int BUFFER_SIZE = 5;
    private static final Queue<Object> buffer = new LinkedList<>();
    private static final Lock lock = new ReentrantLock();
    private static final Condition bufferNotFull = lock.newCondition();
    private static final Condition bufferNotEmpty = lock.newCondition();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                produceData(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                consumeData();
            }
        });

        producer.start();
        consumer.start();
    }

    private static void produceData(Object data) {
        lock.lock();
        try {
            while (buffer.size() == BUFFER_SIZE) {
                System.out.println("Buffer is full. Producer is waiting...");
                bufferNotFull.await();
            }
            buffer.add(data);
            System.out.println("Produced: " + data);
            bufferNotEmpty.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    private static void consumeData() {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                System.out.println("Buffer is empty. Consumer is waiting...");
                bufferNotEmpty.await();
            }
            Object data = buffer.poll();
            System.out.println("Consumed: " + data);
            bufferNotFull.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
