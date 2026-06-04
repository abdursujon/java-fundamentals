/**
 * volatile: forces every read and write of a variable to go to main memory, so all
 * threads always see the latest value instead of a stale cached copy.
 *
 * Each thread can cache a variable for speed. Without volatile, the worker thread may
 * keep reading its old cached 'running == true' and never notice main changed it to
 * false, so it loops forever. volatile guarantees the change is seen.
 *
 * 1. volatile boolean - all threads read and write it from main memory
 * 2. worker loops while running is true
 * 3. main sets running to false - worker sees it and stops
 * 4. volatile fixes visibility only, not atomic updates (count++ still needs synchronized)
 *
 * Note: main method itself is a thread in JVM
 */

public class VolatileExample {

    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            long loops = 0;
            while (running) {
                loops++;
            }
            System.out.println("worker stopped after " + loops + " loops");
        });
        worker.start();

        Thread.sleep(100);
        running = false;
        System.out.println("main asked worker to stop");

        worker.join();
        System.out.println("worker confirmed finished");
    }
}