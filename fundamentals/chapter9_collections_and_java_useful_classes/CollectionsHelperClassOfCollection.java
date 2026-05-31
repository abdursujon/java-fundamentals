import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class CollectionsHelperClassOfCollection {
    // Given an array of items, return reverse of the list with non-repeating items
    public static List<Integer> nonRepeatingReverseList(int[] items){
        Set<Integer> set = new HashSet<>();

        for(int i: items){
            set.add(i);
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(set);

        Collections.reverse(list);

        return list;
    }

    // Given an array of items, return a list with same items but in random orders each time
    public static List<Integer> randomListWithSameItems(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int n: nums){
            list.add(n);
        }
        Collections.shuffle(list);

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        return list;
    }

    // Given an array of item and a target k, return the frequency of k
    public static int frequencyOfTargetElement(int[] nums, int target){
        List<Integer> list = new ArrayList<>();
        for(int n: nums){
            list.add(n);
        }
        return Collections.frequency(list, target);
    }

    // Given list of items, override item of list with give list
    public static List<Integer> overrideList(List<Integer> con){
        List<Integer> list = new ArrayList<>(Collections.nCopies(con.size(), 0));
        Collections.copy(list, con );
        Collections.copy(list , con );
        return list;
    }

    // search target element if found return true else false
    public static boolean itemExist(int[] nums, int target){
        List<Integer> list = new ArrayList<>();
        for(int i: nums){
            list.add(i);
        }
        Collections.sort(list);
        return Collections.binarySearch(list, target) >= 0;
    }

    // given an array of item return a list which is unmodifiable
    public static List<Integer> unModifiableList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int n: nums){
            list.add(n);
        }
        return new ArrayList<>(Collections.unmodifiableList(list));
    }

    class Person{
        String name;
        int age;
        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString(){
            return "Name: " + name + " Age: " + age;
        }
    }

    public static void main(String[] args) {
        System.out.println(nonRepeatingReverseList(new int[]{1, 2, 3, 4 ,5 , 6, 7}));

        System.out.println(randomListWithSameItems(new int[]{1, 2, 3, 4 ,5 , 6, 7}));

        System.out.println(frequencyOfTargetElement(new int[]{1, 2, 3, 4 ,5 , 6, 7, 5, 3, 5}, 5));

        System.out.println(overrideList(new ArrayList<>(List.of(1, 4, 5))));

        System.out.println("Target element found: " + itemExist(new int[]{1, 2, 3, 4 ,5 , 6, 7, 5, 3, 5}, 0));
        System.out.println("Target element found: " + itemExist(new int[]{1, 2, 3, 4 ,5 , 6, 7, 5, 3, 5}, 6));

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));

        // 1. sort
        Collections.sort(list);
        System.out.println(list);

        // 2. reverse
        Collections.reverse(list);
        System.out.println(list);

        // 3. shuffle
        Collections.shuffle(list);
        System.out.println(list);

        // 4. max / min
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        // 5. frequency
        System.out.println(Collections.frequency(list, 2));

        // 6. fill
        Collections.fill(list, 0);
        System.out.println(list);

        // 7. copy (needs destination list size)
        List<Integer> dest = new ArrayList<>(Arrays.asList(1,1,1,1,1));
        System.out.println(dest);
        Collections.copy(dest, list);
        System.out.println(dest);

        // 8. binarySearch (list must be sorted)
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, 2));
        System.out.println(Collections.binarySearch(list, 0));

        // 9. replaceAll
        Collections.replaceAll(list, 0, 99);
        System.out.println(list);

        // 10. unmodifiableList
        List<Integer> readOnly = Collections.unmodifiableList(list);
        // readOnly.add(89); will lead to -> Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(readOnly);

        // 11. singletonList (create a list with exactly one item)
        List<Integer> single = Collections.singletonList(10);
        CollectionsHelperClassOfCollection c = new CollectionsHelperClassOfCollection();
        Person p = c.new Person("Sujon", 55);
        Object o = p;
        List<Object> singleObject = Collections.singletonList(o);

        System.out.println(single);
        System.out.println(singleObject);
    }
}