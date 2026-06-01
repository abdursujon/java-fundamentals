import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i <= 15; i++){
            nums.add(i);
            if(i > 8){
                nums.add(i);
            }
        }
        System.out.println(nums);
        Stream<Integer> numStream = nums.stream();

        // 1. filter()    - keeps elements matching a Predicate
        System.out.println(nums.stream().filter(n -> n % 2 == 0).toList());

        // 2. map()       - transforms each element with some operation and change the value
        System.out.println(nums.stream().map(n -> n * n).toList());

        // 3. flatMap()   - flattens nested streams into one
        System.out.println(Stream.of(List.of(1, 8), List.of(55, 66), List.of(89, 33, 55)).flatMap(List::stream).toList());

        // 4. forEach()   - runs an action on each element (terminal)
        nums.stream().forEach(n -> result.add(n * 10));
        System.out.println(result);

        // 5. collect()   - gathers elements into a collection
        System.out.println(nums.stream().collect(Collectors.toSet()));

        // 6. reduce()    - combines all elements into one value
        System.out.println(nums.stream().reduce(0, Integer::sum)); // where the sum method came from

        // 7. sorted()    - sorts the stream
        System.out.println(nums.stream().sorted(Comparator.reverseOrder()).toList());

        // 8. distinct()  - removes duplicates
        System.out.println(nums.stream().distinct().collect(Collectors.toList()));

        // 9. limit()     - keeps first N elements
        System.out.println(nums.stream().limit(4).toList());

        // 10. skip()     - drops first N elements
        System.out.println(nums.stream().skip(5).toList());

        // 11. count()    - counts elements (terminal)
        System.out.println(nums.stream().count());

        // 12. findFirst()- first element as Optional
        System.out.println(nums.stream().findFirst());

        // 13. findAny()  - any element as Optional
        System.out.println(nums.stream().findAny());

        // 14. anyMatch() - true if any element matches
        System.out.println(nums.stream().anyMatch(n -> n == 8));
        System.out.println(nums.stream().anyMatch(n -> n > 90));

        // 15. allMatch() - true if all elements match
        System.out.println(nums.stream().allMatch(n -> n < 90));
        System.out.println(nums.stream().allMatch(n -> n % 2 == 0));

        // 16. noneMatch()- true if no element matches
        System.out.println(nums.stream().noneMatch(n -> n % 6 == 0));
        System.out.println(nums.stream().noneMatch(n -> n % 2 == 1.3));

        // 17. min()      - smallest element as Optional
        System.out.println(nums.stream().min(Integer::compareTo)); // what compareTo does

        // 18. max()      - largest element as Optional
        System.out.println(nums.stream().max(Integer::compareTo));

        // 19. toList()   - elements into an immutable List
        System.out.println(nums.stream().toList());
        List<Integer> s = nums.stream().toList();

        // 20. peek()     - inspects each element without consuming
        nums.stream().peek(result::add).toList();
        System.out.println(result);
    }
}