import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Runnable vs Callable
 *
 * 1. Runnable - run() returns void, can't throw checked exceptions
 * 2. Callable - call() returns a value, can throw checked exceptions
 * 3. ExecutorService.submit(callable) - returns a Future
 * 4. future.get() - blocks until the result is ready
 * 5. pool.shutdown() - stops the executor accepting new tasks
 */
public class RunnableVsCallable {
    public static void main(String[] args) throws Exception {

        // 1. Runnable does the work but has no way to hand a result back to the caller
        Runnable countWithRunnable = () -> {
            int total = 0;
            for (int i = 1; i <= 100; i++) total += i;
            System.out.println("Runnable computed " + total + ", but can only print it");
        };
        Thread t = new Thread(countWithRunnable);
        t.start();
        t.join();

        // 2. Callable does the same work and returns the result to the caller
        Callable<Integer> countWithCallable = () -> {
            int total = 0;
            for (int i = 1; i <= 100; i++) total += i;
            return total;
        };

        // 3. submit runs the Callable on a worker thread and returns a Future immediately
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Integer> future = pool.submit(countWithCallable);
        System.out.println("Task submitted, main continues while it computes");

        // 4. get blocks until the Callable finishes, then returns its value
        int total = future.get();
        System.out.println("Callable returned " + total + ", now usable as a value, for example we can do total * 2 = " + (total * 2));

        // 5. shut the pool down
        pool.shutdown();
    }
}