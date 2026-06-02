package functional_interfaces;

/**
 * Supplier: takes no input and supplies (returns) a value of type T.
 * The opposite of Consumer — produces a value instead of consuming one.
 * Use it for lazy/deferred values: generate, create, or fetch on demand.
 *
 * @param <T> the type of value supplied
 */
@FunctionalInterface
public interface Supplier<T>{
    T get();
}