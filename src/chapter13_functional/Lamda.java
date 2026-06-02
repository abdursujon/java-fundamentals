import functional_interfaces.BinaryOperator;
import functional_interfaces.Callable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lamda is shorthand for implementing a functional interface in java. More specifically one abstract method.
 * Lamda works with functional interfaces which has exactly one abstract method. Lamda does not work on interface that has
 * more than one abstract method.
 * The interface can have more than one other
 * For example:
 *   - Runnable — java.lang (no import needed since java.land is auto imported in java)
 *   - Comparator<T> — java.util
 *   - Predicate<T> — java.util.function
 *   - Function<T,R> — java.util.function
 *   - Consumer<T> — java.util.function
 *   - Supplier<T> — java.util.function
 */
public class Lamda {
    public static void main(String[] args) throws Exception {
        // 1. Runnable - no args, does not return anything
        Runnable greet = () -> System.out.println("This is lamda implementing runnable interface");
        greet.run(); // run static method of Runnable

        // 2. Comparator - sort a list with lamda instead of using anonymous class
        List<String> names = new ArrayList<>(List.of("Sujon", "Ryan", "Ikaras", "Kiamas"));
        names.sort((a, b) -> a.length() - b.length()); // sort is default method of list interface
        System.out.println(names);
        List<Integer> nums = new ArrayList<>(List.of(1, 6, 9, 203, 4));
        // if n1 < n2 (e.g - 2) n1 before n2 if n1 = n2 no change if n1 > n2 n1 after n2
        nums.sort((n1, n2) -> n1 - n2);
        System.out.println(nums);
        nums.sort((n1, n2) -> Integer.compare(n1, n2));
        System.out.println(nums);
        nums.sort((Comparator.naturalOrder())); // naturalOrder() static method of Comparator
        System.out.println(nums);

        // 3. Predicate<T> - takes T, returns boolean
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        System.out.println(isOdd.test(89)); // test is abstract method of Predicate

        // 4. Function<T, R> - takes T, returns R
        Function<String, Integer> sLen = s -> s.length();
        System.out.println(sLen.apply("Lamda")); //  apply abstract method of Function interface

        // 5. Consumer<T> - takes T, returns nothing
        Consumer<String> print = s -> System.out.println(s.toUpperCase());
        print.accept("hi how do u do?"); // accept is abstract method of Consumer interface

        // 6. Supplier<T> - n args, supplies a T
        Supplier<Double> randomValue = () -> Math.floor(10 * Math.random());
        System.out.println(randomValue.get()); // get is an abstract method of Supplier interface

        // 7. BinaryOperator
        BinaryOperator<Integer> addTwoItems = (a, b) -> a + b;
        System.out.println(addTwoItems.apply(1, 5));

        // 8. Callable
        Callable<Integer> sumOfFirstHundredNumber = () -> {
            int total = 0;
            for(int i = 1; i <= 100; i++){
                total+=i;
            }
            return total;
        };
        System.out.println(sumOfFirstHundredNumber.call());

    }
}
