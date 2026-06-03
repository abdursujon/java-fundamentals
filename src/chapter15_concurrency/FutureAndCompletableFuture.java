import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future vs CompletableFuture: both represent a result that isn't ready yet because
 * it's being computed on another thread.
 *
 * Why it matters: when you run work in the background you need a handle to get its
 * result later. Future is the basic handle; CompletableFuture is the modern upgrade
 * that lets you chain steps and react when the result arrives, without blocking.
 *
 * 1. Future.get() - BLOCKS the current thread until the result is ready
 * 2. CompletableFuture.supplyAsync(supplier) - run a task in the background, returns a result
 * 3. .thenApply(function) - transform the result when it arrives (non-blocking chain)
 * 4. .thenAccept(consumer) - do something with the final result, still non-blocking
 * 5. .join() - like get() but no checked exception
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