package functional_interfaces;

/**
 * Callable: a task that runs, returns a result of type V, and may throw a checked exception.
 * Like Runnable, but Runnable returns nothing and can't throw checked exceptions —
 * Callable returns V via call() and is allowed to throw. Used with ExecutorService/threads.
 *
 * @param <V> the type of result returned by call()
 */
@FunctionalInterface
public interface Callable<V>{
    V call() throws Exception;
}