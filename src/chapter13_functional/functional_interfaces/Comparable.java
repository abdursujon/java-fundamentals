package functional_interfaces;

/**
 * Comparable interface in Java.
 * Technically functional (one abstract method) but we don't use lambdas here,
 * because compareTo compares 'this' (the object itself) to the argument —
 * a lambda has no 'this' to compare.
 *
 * @param <T> the type this object can be compared to
 */
public interface Comparable<T> {
    int compareTo(T o);
}
