import java.util.Arrays;

public class TwoDimensionalArray {

    public static void main(String[] args) {

        int[][] priceList = new int[4][5];
        int even = 2;
        int odd = 1;
        for (int i = 0; i < priceList.length; i++) {
            for (int j = 0; j < priceList[i].length; j++) {
                if (i < 2) {
                    priceList[i][j] = even;
                    even += 2;
                }
                if (i > 1) {
                    priceList[i][j] = odd;
                    odd += 2;
                }
            }
        }
        System.out.println(Arrays.deepToString(priceList));

        String[][] items = {{"Cup", "Bottle"}, {"Spoon", "Mug", "Jar"}};
        System.out.println(Arrays.deepToString(items));
        if (items[0][0].equals("Cup")) {
            items[0][0] = "I love a cup of tea";
        }
        System.out.println(Arrays.deepToString(items));

        // by doing new String[][] we auto declare the size of the array
        String[][] cricket = new String[][]
                {{"6 balls = an over", "If the ball is over the waist height, it is a no ball"},
                {"Jos Butler is my favourite player", "Virat Kohli is a good player too"}};
        System.out.println(Arrays.deepToString(cricket));

    }
}