package functional_applications;

import java.util.Optional;

public class OptionalUseCase {
    public static void main(String[] args) {

        // Optional.of / ofNullable / empty — all static methods of the Optional class (called on the class)
        // of(): wraps a non-null value (throws if null)
        Optional<String> name = Optional.of("Sujon");
        System.out.println(name);

        // ofNullable(): allows null. Would be empty if null
        Optional<String> nameTwo = Optional.ofNullable("");
        System.out.println(nameTwo);

        // empty(): static, creates an Optional holding nothing
        Optional<String> emptyOptionalField = Optional.empty();

        // map() — instance method of Optional. Argument is a Function; map calls that Function's apply() internally.
        // s -> s.length() is a Function<String,Integer>
        Optional<Integer> length = name.map(s -> s.length());
        // get(): instance method of Optional, unwraps the value → 5
        System.out.println(length.get());

        // filter() — instance method of Optional. Argument is a Predicate; filter calls its test() internally.
        // filter→Optional, isPresent()→Optional → true
        System.out.println(name.filter(s -> s.length() > 3).isPresent());
        // s -> s.length() > 10 is a Predicate → false
        System.out.println(name.filter(s -> s.length() > 10).isPresent());

        // ifPresent() — instance method of Optional. Argument is a Consumer; ifPresent calls its accept() internally.
        // s -> is a Consumer<String> → Hi Sujon
        name.ifPresent(s -> System.out.println("Hi " + s));
        // empty → Consumer never called → (nothing)
        emptyOptionalField.ifPresent(s -> System.out.println("Hi " + s));

        // orElse() — instance method of Optional. Takes a plain value (NOT a lambda), returns it if empty.
        // orElse()→Optional → default
        System.out.println(emptyOptionalField.orElse("default"));

        // orElseGet() — instance method of Optional. Argument is a Supplier; orElseGet calls its get() only if empty.
        // () -> ... is a Supplier → computed default
        System.out.println(emptyOptionalField.orElseGet(() -> "computed default"));
    }
}