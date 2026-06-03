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

        // 1. Runnable - returns nothing
        Runnable r = () -> System.out.println("Runnable ran, returns nothing");
        new Thread(r).start();

        // 2. Callable - returns a value
        Callable<Integer> c = () -> {
            int total = 0;
            for (int i = 1; i <= 100; i++) total += i;
            return total;
        };

        // 3. submit a Callable to a thread pool, get a Future back
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Integer> future = pool.submit(c);

        // 4. get() blocks until the Callable finishes
        System.out.println("Callable returned: " + future.get());

        // 5. shut the pool down
        pool.shutdown();
    }
}