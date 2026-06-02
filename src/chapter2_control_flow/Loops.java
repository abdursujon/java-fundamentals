import java.util.Arrays;

public class Loops {
  public static void main(String[] args) {

    // 1. for loop
    int[] nums = {3, 6, 12, 24, 48, 96, 192, 384, 768};
    int[] nums2 = new int[nums.length + 1];

    for (int i = 0; i < nums.length; i++) {
      nums2[i] = nums[i] / 2;
    }

    System.out.println(Arrays.toString(nums2));

    // 2. enhanced for loop
    for (int n : nums2) {
      System.out.print(n + " \n");
    }

    // 3. while loop
    int j = 0;
    while (j < nums2.length) {
      System.out.println(nums2[j]);
      j++;
    }

    // 4. do while loop
    j = 0;
    do {
      System.out.println(nums2[j]);
      j++;
    } while (j < nums2.length);
  }
}
