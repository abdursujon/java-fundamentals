import java.util.ArrayList;
import java.util.List;

public class CommonRuntimeExceptions {
    public static void main(String[] args) {
        // 1. NullPointerException -> calling a method/field on a null reference
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // 2. ArrayIndexOutOfBoundsException -> accessing an invalid array index
        try {
            int[] nums = {1, 3, 4};
            System.out.println(nums[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // 3. StringIndexOutOfBoundsException -> invalid index inside a String
        try {
            String s = "I love Java";
            System.out.println(s.charAt(70));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // 4. ArithmeticException -> illegal math operation, e.g. integer divide by zero
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        // 5. NumberFormatException -> parsing a non-numeric string into a number
        try {
            String s = "my favourite number is 19";
            Integer num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println(e + " is not a pure number");
        }

        // 6. ClassCastException -> invalid cast between unrelated types at runtime
        try {
            Object str = "I am a string";
            Integer i = (Integer) str;
        } catch (ClassCastException e) {
            System.out.println(e);
        }

        // 7. IllegalArgumentException -> a method was called with an inappropriate argument
        try {
            Thread.sleep(-100); // negative time is not allowed
        } catch (IllegalArgumentException | InterruptedException e) {
            System.out.println(e);
        }

        // 8. IllegalStateException -> object is not in a valid state for the call
        try {
            List<Integer> list = new ArrayList<>(List.of(1, 2));
            var it = list.iterator();
            it.next();
            it.remove();
            it.remove(); // calling remove() twice without next() in between
        } catch (IllegalStateException e) {
            System.out.println(e + " remove was called without next");
        }


        // 9. UnsupportedOperationException -> operation not supported by this implementation
        try {
            List<Integer> list = List.of(1, 4, 5); // list is immutable
            list.add(6); // not supported as we try to modify immutable list
        } catch (UnsupportedOperationException e) {
            System.out.println(e + " tried to modify a immutable list");
        }

        // 10. ConcurrentModificationException -> structurally modifying a collection while iterating
        try {
            List<Integer> list = new ArrayList<>(List.of(3, 4, 56));
            for (Integer i : list) {
                if (i == 4) {
                    list.remove(i); // modifying during enhanced-for iteration
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println(e);
        }

        // 11. StackOverflowError -> not technically a RuntimeException but a common runtime crash
        // infinite recursion -> StackOverflowError
        recurse();

    }

    static void recurse() {
        recurse();
    }
}
