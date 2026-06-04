/**
 * Race condition: two threads read and write the same variable at the same time, and
 * their steps interleave, so updates get lost and the result is wrong.
 *
 * count++ looks like one step but is three - read, add, write. When two threads read the
 * same value before either writes back, one increment is lost. The bug is intermittent:
 * the result changes each run, which makes it hard to catch.
 *
 * 1. count++ is read-modify-write, not atomic
 * 2. Two threads each increment 10000 times - correct total is 20000
 * 3. No lock here, so the actual total is usually less than 20000
 * 4. Fix: synchronized, ReentrantLock, or AtomicInteger
 */
public class RaceConditionExample {

    private int count = 0;

    public void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        RaceConditionExample counter = new RaceConditionExample();

        Runnable job = () -> {
            for (int i = 0; i < 10000; i++) counter.increment();
        };

        Thread t1 = new Thread(job);
        Thread t2 = new Thread(job);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.count);
    }
}