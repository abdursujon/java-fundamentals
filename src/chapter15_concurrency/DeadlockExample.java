/**
 * Deadlock: two threads each holding a lock the other needs, so both wait forever
 * and the program freezes. Happens when locks are acquired in different orders.
 *
 * Significance of knowing it: this is a real bug in concurrent code - no crash, no error, the app
 * just hangs. Understanding the cause (inconsistent lock ordering) is how you avoid it.
 *
 * This example forces the deadlock on purpose to show it:
 * 1. Thread 1 grabs lockA, then waits for lockB
 * 2. Thread 2 grabs lockB, then waits for lockA
 * 3. Neither releases its lock, so neither can proceed - frozen
 * 4. Fix: make every thread acquire locks in the same order (lockA then lockB)
 */
public class DeadlockExample {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();


    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1 holds lockA, wants lockB");
                sleep(100);
                synchronized (lockB) {
                    System.out.println("Thread 1 got both");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2 holds lockB, wants lockA");
                sleep(100);
                synchronized (lockA) {
                    System.out.println("Thread 2 got both");
                }
            }
        });

        t1.start();
        t2.start();
        // program hangs here - neither thread can finish there for program will never reach end of the calls
        // join() makes the calling thread wait until the thread we call it on finishes.
        t1.join();
        t2.join();
        System.out.println("Both threads finished");
    }

}