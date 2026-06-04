import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future vs CompletableFuture: both represent a result that isn't ready yet because
 * it's being computed on another thread.
 *
 * Future is the basic handle, offering only a blocking get() to retrieve the result.
 * CompletableFuture adds chaining and callbacks, so a result can be transformed and
 * passed along as it becomes available rather than retrieved by blocking.
 *
 * 1. Future.get() - blocks the current thread until the result is ready
 * 2. CompletableFuture.supplyAsync(supplier) - runs a task in the background and produces a result
 * 3. .thenApply(function) - transforms the result when it arrives, without blocking
 * 4. .thenAccept(consumer) - consumes the final result, without blocking
 * 5. .join() - returns the result like get(), without a checked exception
 */
public class FutureAndCompletableFuture {
    public static void main(String[] args) throws Exception {

        // Future: must call get() and wait for the result
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Integer> future = pool.submit(() -> 2 + 3);
        System.out.println("Future result: " + future.get());
        pool.shutdown();

        // CompletableFuture: chain the steps, no manual blocking
        CompletableFuture
                .supplyAsync(() -> 2 + 3)
                .thenApply(sum -> sum * 10)
                .thenAccept(result -> System.out.println("CompletableFuture result: " + result));

        Thread.sleep(100);
    }
}