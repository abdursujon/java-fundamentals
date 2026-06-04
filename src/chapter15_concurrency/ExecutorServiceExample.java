import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorService: a thread pool that manages threads, instead of creating
 * and starting Thread objects by hand. We submit tasks, it reuses a fixed set of
 * threads to run them.
 *
 * creating a new Thread per task is expensive and uncontrolled - 1000
 * tasks = 1000 threads. A pool reuses a few threads, so we  control how many run at once.
 * This is how real apps run background work.
 *
 * 1. Executors.newFixedThreadPool(n) - pool with n reusable threads
 * 2. pool.execute(runnable) - run a fire-and-forget task (no result)
 * 3. pool.submit(callable) - run a task that returns a Future
 * 4. future.get() - blocks until that task's result is ready
 * 5. pool.shutdown() - stop accepting new tasks, finish the queued ones
 */
public class ExecutorServiceExample {
    public static void main(String[] args) throws Exception {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 2. fire-and-forget tasks - 5 tasks share 3 threads
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            pool.execute(() ->
                    System.out.println("Task " + taskId + " on " + Thread.currentThread().getName()));
        }

        // 3. task that returns a value
        Future<Integer> future = pool.submit(() -> {
            int total = 0;
            for (int i = 1; i <= 100; i++) total += i;
            return total;
        });

        // 4. wait for and print the result
        System.out.println("Sum result: " + future.get());

        // 5. shut the pool down
        pool.shutdown();
    }
}
