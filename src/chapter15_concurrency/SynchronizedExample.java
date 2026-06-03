/**
 * synchronized: only one thread at a time can run a synchronized method on the same
 * object, so shared data can't be corrupted by two threads at once.
 *
 * Why it matters: count++ is read-modify-write, not a single step. Without locking,
 * two threads read the same value and one update is lost (a race condition). synchronized
 * forces them to take turns, so every increment counts.
 */
public class SynchronizedExample {

    private int count = 0;

    public synchronized void incrementCountSafely() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedExample counter = new SynchronizedExample();

        Runnable job = () -> {
            for (int i = 0; i < 10000; i++) counter.incrementCountSafely();
        };

        Thread t1 = new Thread(job);
        Thread t2 = new Thread(job);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // 20000 with synchronized, less than 20000 without it
        System.out.println(counter.count);
    }
}