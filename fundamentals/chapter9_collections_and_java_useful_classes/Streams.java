import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void streamExplicitImplementation() {

        // 1. filter()    - keeps elements matching a Predicate
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 9, 10));
        Stream<Integer> stream1 = list1.stream();
        Predicate<Integer> isOdd= n -> n % 2 != 0;
        Stream<Integer> oddStream = stream1.filter(isOdd);
        List<Integer> oddList = oddStream.collect(Collectors.toList());
        System.out.println(oddList);

        // 2. map()       - transforms each element 1-to-1
        // 3. flatMap()   - flattens nested streams into one
        // 4. forEach()   - runs an action on each element (terminal)
        // 5. collect()   - gathers elements into a collection
        // 6. reduce()    - combines all elements into one value
        // 7. sorted()    - sorts the stream
        // 8. distinct()  - removes duplicates
        // 9. limit()     - keeps first N elements
        // 10. skip()     - drops first N elements
        // 11. count()    - counts elements (terminal)
        // 12. findFirst()- first element as Optional
        // 13. findAny()  - any element as Optional
        // 14. anyMatch() - true if any element matches
        // 15. allMatch() - true if all elements match
        // 16. noneMatch()- true if no element matches
        // 17. min()      - smallest element as Optional
        // 18. max()      - largest element as Optional
        // 19. toList()   - elements into an immutable List
        // 20. peek()     - inspects each element without consuming (intermediate)
    }


    public static void streamImplicitImplementation() {
        // 1. filter()    - keeps elements matching a Predicate
        // 2. map()       - transforms each element 1-to-1
        // 3. flatMap()   - flattens nested streams into one
        // 4. forEach()   - runs an action on each element (terminal)
        // 5. collect()   - gathers elements into a collection
        // 6. reduce()    - combines all elements into one value
        // 7. sorted()    - sorts the stream
        // 8. distinct()  - removes duplicates
        // 9. limit()     - keeps first N elements
        // 10. skip()     - drops first N elements
        // 11. count()    - counts elements (terminal)
        // 12. findFirst()- first element as Optional
        // 13. findAny()  - any element as Optional
        // 14. anyMatch() - true if any element matches
        // 15. allMatch() - true if all elements match
        // 16. noneMatch()- true if no element matches
        // 17. min()      - smallest element as Optional
        // 18. max()      - largest element as Optional
        // 19. toList()   - elements into an immutable List
        // 20. peek()     - inspects each element without consuming (intermediate)
    }

    public static void main(String[] args) {
        streamImplicitImplementation();
        streamExplicitImplementation();
    }
}