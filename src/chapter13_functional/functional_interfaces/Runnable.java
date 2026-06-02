package functional_interfaces;

/**
 * Runnable: a task that runs with no input and no return value (void).
 * Unlike Callable, it returns nothing and cannot throw checked exceptions.
 * Originally for threads, but usable anywhere we need a "do this" action.
 */
@FunctionalInterface
public interface Runnable {
    void run();
}