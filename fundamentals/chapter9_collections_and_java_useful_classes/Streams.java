import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void streamImplicitImplementation() {
        List<Integer> nums = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);

        // 1. filter()
        List<Integer> even = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> odd = nums.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());

        System.out.println(even);
        System.out.println(odd);

        // 2. map()
        List<Integer> triple = nums.stream().map(n -> n * 3).collect(Collectors.toList());
        System.out.println(triple);

        // 3. flatMap()
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(2, 4, 6),
                Arrays.asList(1, 3, 5),
                Arrays.asList(7, 9, 11),
                Arrays.asList(8, 10, 12)
        );

        List<Integer> flatList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flatList);

        // 4. forEach()
        nums.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 5. collect()
        List<Integer> collected = nums.stream().collect(Collectors.toList());
        System.out.println(collected);

        // 6. reduce()
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println("Sum of all list items: " + sum);

        // 7. sorted()
        List<Integer> sorted = nums.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted list: " + sorted);

        // 8. distinct()
        List<Integer> distinct = Arrays.asList(1, 1, 2, 2, 3, 3)
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique item list: " + distinct);

        // 9. limit()
        List<Integer> limited = nums.stream().limit(5).collect(Collectors.toList());
        System.out.println(limited);

        // 10. skip()
        List<Integer> skipped = nums.stream().skip(5).collect(Collectors.toList());
        System.out.println("Skipped first five element of the nums list, now the list is: " + skipped);

        // 11. count()
        long count = nums.stream().count();
        System.out.println("Number of items in the nums list is : " + count);

        // 12. findFirst()
        System.out.println(nums.stream().findFirst().orElse(null));

        // 13. findAny()
        System.out.println(nums.stream().findAny().orElse(null));

        // 14. anyMatch()
        System.out.println(nums.stream().anyMatch(n -> n > 8));

        // 15. allMatch()
        System.out.println(nums.stream().allMatch(n -> n > 0));

        // 16. noneMatch()
        System.out.println(nums.stream().noneMatch(n -> n < 0));

        // 17. min()
        System.out.println(nums.stream().min(Integer::compareTo).orElse(null));

        // 18. max()
        System.out.println(nums.stream().max(Integer::compareTo).orElse(null));

        // 19. toList()
        System.out.println(nums.stream().toList());

        // 20. peek()
        List<Integer> peeked = nums.stream()
                .peek(n -> System.out.print("peek:" + n + " "))
                .collect(Collectors.toList());

        System.out.println();
    }

    public static void streamExplicitImplementation() {
        streamImplicitImplementation();

        List<Integer> nums = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

        // 1. filter()
        Stream<Integer> stream1 = nums.stream();
        Predicate<Integer> isEven = (n -> n % 2 == 0);
        Stream<Integer> evenStream = stream1.filter(isEven);
        List<Integer> even = evenStream.collect(Collectors.toList());
        System.out.println(even);

        Stream<Integer> stream2 = nums.stream();
        Predicate<Integer> isOdd = (n -> n % 2 != 0);
        List<Integer> odd = stream2.filter(isOdd).collect(Collectors.toList());
        System.out.println(odd);

        // 2. map()
        Stream<Integer> stream3 = nums.stream();
        Function<Integer, Integer> tripleFunction = (n -> n * 3);
        Stream<Integer> mappedStream = stream3.map(tripleFunction);
        List<Integer> triple = mappedStream.collect(Collectors.toList());
        System.out.println(triple);

        // 3. flatMap()
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(2, 4, 6),
                Arrays.asList(1, 3, 5),
                Arrays.asList(7, 9, 11),
                Arrays.asList(8, 10, 12)
        );

        Stream<List<Integer>> nestedStream = nestedList.stream();
        Function<List<Integer>, Stream<Integer>> flattener = (list -> list.stream());
        Stream<Integer> flatStream = nestedStream.flatMap(flattener);
        List<Integer> flatList = flatStream.collect(Collectors.toList());
        System.out.println(flatList);

        // 4. forEach()
        Stream<Integer> stream4 = nums.stream();
        Consumer<Integer> printConsumer = (n -> System.out.print(n + " "));
        stream4.forEach(printConsumer);
        System.out.println();

        // 5. collect()
        Stream<Integer> stream5 = nums.stream();
        List<Integer> collected = stream5.collect(Collectors.toList());
        System.out.println(collected);

        // 6. reduce()
        Stream<Integer> stream6 = nums.stream();
        BinaryOperator<Integer> sumOp = (a, b ) -> a + b;
        int sum = stream6.reduce(0, sumOp);
        System.out.println(sum);

        // 7. sorted()
        Stream<Integer> stream7 = nums.stream();
        Comparator<Integer> naturalOrder = Comparator.naturalOrder();
        List<Integer> sorted = stream7.sorted(naturalOrder).collect(Collectors.toList());
        System.out.println(sorted);

        // 8. distinct()
        Stream<Integer> stream8 = Arrays.asList(1, 1, 2, 2, 3, 3).stream();
        List<Integer> distinct = stream8.distinct().collect(Collectors.toList());
        System.out.println(distinct);

        // 9. limit()
        Stream<Integer> stream9 = nums.stream();
        List<Integer> limited = stream9.limit(5).collect(Collectors.toList());
        System.out.println(limited);

        // 10. skip()
        Stream<Integer> stream10 = nums.stream();
        List<Integer> skipped = stream10.skip(5).collect(Collectors.toList());
        System.out.println(skipped);

        // 11. count()
        Stream<Integer> stream11 = nums.stream();
        long count = stream11.count();
        System.out.println(count);

        // 12. findFirst()
        Stream<Integer> stream12 = nums.stream();
        Optional<Integer> first = stream12.findFirst();
        System.out.println(first.orElse(null));

        // 13. findAny()
        Stream<Integer> stream13 = nums.stream();
        Optional<Integer> any = stream13.findAny();
        System.out.println(any.orElse(null));

        // 14. anyMatch()
        Stream<Integer> stream14 = nums.stream();
        Predicate<Integer> greaterThan8 = (n -> n > 8);
        boolean anyMatch = stream14.anyMatch(greaterThan8);
        System.out.println(anyMatch);

        // 15. allMatch()
        Stream<Integer> stream15 = nums.stream();
        Predicate<Integer> greaterThan0 = (n -> n > 0);
        boolean allMatch = stream15.allMatch(greaterThan0);
        System.out.println(allMatch);

        // 16. noneMatch()
        Stream<Integer> stream16 = nums.stream();
        Predicate<Integer> lessThan0 = (n -> n < 0);
        boolean noneMatch = stream16.noneMatch(lessThan0);
        System.out.println(noneMatch);

        // 17. min()
        Stream<Integer> stream17 = nums.stream();
        Comparator<Integer> compMin = Comparator.naturalOrder();
        Optional<Integer> min = stream17.min(compMin);
        System.out.println(min.orElse(null));

        // 18. max()
        Stream<Integer> stream18 = nums.stream();
        Comparator<Integer> compMax = Comparator.naturalOrder();
        Optional<Integer> max = stream18.max(compMax);
        System.out.println(max.orElse(null));

        // 19. toList()
        Stream<Integer> stream19 = nums.stream();
        List<Integer> toList = stream19.toList();
        System.out.println(toList);

        // 20. peek()
        Stream<Integer> stream20 = nums.stream();
        Consumer<Integer> peekConsumer = (n -> System.out.print("peek:" + n + " "));
        List<Integer> peeked = stream20.peek(peekConsumer).collect(Collectors.toList());
        System.out.println();
    }

    public static void main(String[] args) {
        streamImplicitImplementation();
        streamExplicitImplementation();
    }
}