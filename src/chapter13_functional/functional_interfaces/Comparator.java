package functional_interfaces;

/**
 * Comparator: an external rule for ordering two objects of type T.
 * Unlike Comparable (which lives inside the object and uses 'this'),
 * a Comparator takes both objects as arguments — so it works as a lambda.
 * Passed to sort(), TreeSet, TreeMap, etc.
 *
 * @param <T> the type of objects being compared
 */
@FunctionalInterface
public interface Comparator<T>{
    // negative: a before b | 0: equal | positive: a after b
    int compare(T a, T b);
}