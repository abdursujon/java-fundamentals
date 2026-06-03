/**
 * wait() / notify(): let threads coordinate by pausing and signalling each other, so
 * one thread waits until another says "the condition you need is now true."
 *
 * Significance of WaitNotify: without this a waiting thread would have to loop and burn CPU checking
 * a condition (busy-waiting). wait() releases the lock and sleeps until notify() wakes it,
 * so threads hand off work efficiently. Classic use: producer-consumer.
 *
 * 1. wait() / notify() must be called inside synchronized on the same lock object
 * 2. wait() - releases the lock and pauses until notified
 * 3. notify() - wakes one waiting thread (notifyAll() wakes all)
 * 4. always wait() inside a while loop, not if - guards against spurious wake-ups
 */
public class WaitNotifyExample {

    private static final Object lock = new Object();
    private static boolean ready = false;

    public static void main(String[] args) {

        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                while (!ready) {
                    try {
                        System.out.println("Waiter: waiting for ready");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Waiter: ready is true, continuing");
            }
        });

        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                ready = true;
                System.out.println("Notifier: set ready, notifying");
                lock.notify();
            }
        });

        waiter.start();
        notifier.start();
    }
}
