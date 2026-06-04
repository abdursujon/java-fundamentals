import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: a manual lock that does the same job as synchronized, but with explicit
 * control over when locking and unlocking happen.
 *
 * synchronized locks an entire block automatically and cannot be customised. ReentrantLock
 * supports try-locking, timeouts, and unlocking at a different point than where the lock was
 * acquired. "Reentrant" means the same thread can acquire the lock again while already holding
 * it, without deadlocking against itself.
 *
 * 1. lock.lock() - acquires the lock, waiting if another thread holds it
 * 2. try/finally - unlocks in finally so the lock is released even if the code throws
 * 3. lock.unlock() - releases the lock
 * 4. count++ is safe here because only one thread holds the lock at a time
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
