package functional_interfaces;

/**
 * BinaryOperator: takes two values of the same type T and combines them into
 * one result, also of type T. Both inputs and the output share the same type.
 * Used to merge two things into one — sum two ints, join two strings, max of two.
 * Commonly passed to stream reduce().
 *
 * @param <T> the type of both operands and the result
 */
@FunctionalInterface
public interface BinaryOperator<T>{
    T apply (T t1, T t2);
}