import java.util.*;
import java.util.stream.Collectors;

public class CollectorsClassInJava {
    public static void main(String[] args){
        List<String> words = List.of("apple", "app", "ankle", "banana", "grape", "mango", "pineapple");
        List<Integer> nums = List.of(1, 3, 7, 8, 8);

        // 1. toList - gather into a list
        List<String> wordList = words.stream().collect(Collectors.toList());
        System.out.println(wordList);

        // 2. toSet - gather into a Set (no duplicates, unordered)
        Set<String> setList = words.stream().collect(Collectors.toSet());
        System.out.println(setList);

        // 3. joining - concatenate Strings (separator, prefix, suffix)
        String wordJoined = setList.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(wordJoined);

        // 4. counting - how many elements
        System.out.println(nums.stream().collect(Collectors.counting()));

        // 5. summingInt - add up an int extracted from each element
        Integer totalLen = words.stream().collect(Collectors.summingInt(String::length));
        System.out.println(totalLen);

        // 6. averagingInt - average of an int from each element
        Double averageLen = words.stream().collect(Collectors.averagingInt(String::length));
        System.out.println(averageLen);

        // 7. groupingBy - bucket elements by a key -> Map<key, List>
        Map<Character, List<String>> byFirstLetter = words.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println("groupingBy: " + byFirstLetter);
        // this is equivalent to
        Map<Character, List<String>> byFirstLetterTwo = new HashMap<>();

        for (String word : words) {
            Character key = word.charAt(0);          // 1. run function to get the key

            if (!byFirstLetterTwo.containsKey(key)) {   // 2. check if we first time seeing this key?
                byFirstLetterTwo.put(key, new ArrayList<>());  //    create an empty list for it
            }

            byFirstLetterTwo.get(key).add(word);        // 3. add the word to that key's list
        }

        // 8. partitioningBy - split into true/false buckets
        Map<Boolean, List<Integer>> evenAndOdd = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("partitioningBy: " + evenAndOdd);

        // 9. toMap - build a Map from each element (key, value)
        Map<String, Integer> wordToLength = words.stream().collect(Collectors.toMap(word -> word, String::length));
        System.out.println("toMap: " + wordToLength);

        // 10. groupingBy + counting - count per bucket (downstream collector)
        Map<Character, Long> countByFirstLetter = words.stream().collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));
        System.out.println("group+count:   " + countByFirstLetter);
        // this is equivalent to
        Map<Character, Long> groupCount = new HashMap<>();

        for (String word : words) {
            Character key = word.charAt(0);
            Long count = groupCount.getOrDefault(key, 0L);
            count++;
            groupCount.put(key, count);
        }
        System.out.println("group+count:   " + groupCount);
    }
}
