import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: a manual lock that does the same job as synchronized, but with more
 * control - you decide exactly when to lock and unlock.
 *
 * Why it matters: synchronized auto-locks for a whole block and you can't customise it.
 * ReentrantLock lets you try to lock, time out, or unlock in a different place - useful
 * when you need flexibility. "Reentrant" = the same thread can lock it again without
 * deadlocking itself.
 *
 * 1. lock.lock() - acquire the lock (waits if another thread holds it)
 * 2. try/finally - always unlock in finally so it's released even if the code throws
 * 3. lock.unlock() - release the lock
 * 4. count++ is now safe because only one thread holds the lock at a time
 */
public class LockReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void incrementCountSafely() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        LockReentrantLockExample counter = new LockReentrantLockExample();

        Runnable job = () -> {
            for (int i = 0; i < 10000; i++) counter.incrementCountSafely();
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
