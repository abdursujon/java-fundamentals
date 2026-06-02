package functional_applications;

import functional_interfaces.Consumer;
import functional_interfaces.Function;
import java.util.Arrays;
import java.util.List;

/**
 * A method reference is shorthand for a lambda that does nothing but call one existing method. Syntax: Type::methodName.
 * If a lambda just forwards its argument to a method, we can replace it with the method's name:
 * s -> s.toUpperCase()      // lambda
 * String::toUpperCase       // method reference — performs same action
 */
public class MethodReference {
    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        System.out.println(sb.reverse());
        return sb.reverse().toString();
    }

    public static void main(String[] args){

        // 1. Static method (ClassName::staticMethod)
        Function<String, Integer> parse = Integer::parseInt; // s -> Integer.parseInt(s)
        int value = parse.apply("342");
        System.out.println(value);

        // 2. Instance method of a specific object (object::method)
        Consumer<String> print = MethodReference::reverseString;
        print.accept("I love java");

        // 3. Instance method of the parameter (ClassName::instanceMethod)
        Function<String, String> upper = String::toLowerCase; // s -> s.toLowerCase
        System.out.println(upper.apply("I LOVE JAVA"));

        // 4. Constructor (ClassName::new)
        List<String> names = List.of("Cricket", "Football", "Chess");
        String[] strArray = names.toArray(String[]::new);
        System.out.println(Arrays.toString(strArray));
    }
}
