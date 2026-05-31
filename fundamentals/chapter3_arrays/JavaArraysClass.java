import java.util.Arrays;

/**
 * 1. Arrays.sort(array)
 * 2. Arrays.toString(array)
 * 3. Arrays.deepToString(array)
 * 4. Arrays.equals(arr1, arr2)
 * 5. Arrays.fill(array, value)
 * 6. Arrays.copyOf(array, length)
 * 7. Arrays.copyOfRange(array, from, to)
 * 8. Arrays.binarySearch(array, key)
 * 9. Arrays.stream(array)
 */
public class JavaArraysClass{
    public static void main(String[] args){
        int[] arr = {1, 3, 4, 65, 33, 12};
        int[] arr1 = {1, 3, 4, 65, 33, 12};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        int[] arr3 = new int[10];
        int[] arr4 = new int[10];

        Arrays.sort(arr);
        Arrays.sort(arr1);

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.deepToString(arr2));

        System.out.println(Arrays.equals(arr, arr1));

        Arrays.fill(arr3, 89);
        System.out.println(Arrays.toString(arr3));
        Arrays.fill(arr4, 0, 5, 67);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = Arrays.copyOf(arr, 9);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = Arrays.copyOfRange(arr5, 2, 8);
        System.out.println(Arrays.toString(arr6));

        // return index of an element#
        Arrays.sort(arr6);
        System.out.println(Arrays.toString(arr6));
        System.out.println(Arrays.binarySearch(arr6, 65));

        int sum = Arrays.stream(arr6).sum();
        int max = Arrays.stream(arr6).max().getAsInt();
        int min = Arrays.stream(arr6).min().getAsInt();
        System.out.println("Sum: " + sum + "\nMax: " + max + "\nMin: " + min);
    }
}