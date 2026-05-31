import java.util.Arrays;

public class  OneDimensionalArray{
    public static void main(String[] args){
        // 1
        int[] arr1 = new int[10];
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = i;
        }
        System.out.println(Arrays.toString(arr1));

        // 2
        int[] arr2 = {1, 3, 5, 7, 9};
        for(int i = 0; i < arr2.length; i++){
            int evenNum = arr2[i] + 1;
            System.out.println(evenNum);
        }

        // 3.  array with auto size declaration through amount of item on the list
        int[] arr3 = new int[] {1, 3, 5, 7, 9};
        System.out.println("array 3 length: " + arr3.length);

        // 4.
        int[] arr4 = new int[arr3.length * 2];
        System.arraycopy(arr3, 0, arr4, 0, arr3.length);
        System.arraycopy(arr3, 0, arr4, arr3.length, arr2.length);
        System.out.println(Arrays.toString(arr4));

        // 5.
        int[] arr5 = Arrays.copyOf(arr4, 20);
        System.out.println(Arrays.toString(arr5));
    }
}