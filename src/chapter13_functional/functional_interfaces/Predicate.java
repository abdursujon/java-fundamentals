package functional_interfaces;

/**
 * Predicate: takes one input of type T and returns a boolean — a yes/no test.
 * Use it to check a condition: is this even? is this string empty? is age > 18?
 * Commonly passed to filter().
 *
 * @param <T> the type of the input being tested
 */
@FunctionalInterface
public interface Predicate<T>{
    boolean test(T t);
}