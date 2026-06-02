package functional_interfaces;

/**
 * Function: takes one input of type T and returns a result of type R.
 * The most general functional interface — input and output can be different types.
 * Use it to transform/convert a value into another. Commonly passed to map().
 *
 * @param <T> the type of the input
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}