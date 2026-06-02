package functional_interfaces;

/**
 * Consumer: takes one input of type T and performs an action with it,
 * returning nothing (void). We can use it when we want to do something with a
 * value rather than compute a result — e.g. print it, store it, log it.
 * Commonly passed to forEach().
 *
 * @param <T> the type of input the action accepts
 */
@FunctionalInterface
public interface Consumer<T>{
    void accept(T t);
}