import java.util.*;

/**
 * 1. Methods
 * 2. Recursion
 * 3. Varargs
 * 4. Default methods
 * 5. Static methods
 */
public class Methods {
    // 1. Regular methods
    public int sum(int[] nums){
        return Arrays.stream(nums).sum();
    }

    public void maxNum(int[] maxs){
        int max = Arrays.stream(maxs).max().getAsInt();
        System.out.println(max);
    }

    // 2. Recursion
    public int factorial(int n){
        if(n == 1) return 1;
        return n * factorial(n - 1);
    }

    // 3. Varargs double... means any number of arguments
    public double multiples(double... numbers){
        double total = 1;
        for(double n: numbers){
            total *= n;
        }
        return total;
    }

    // 4. Default method, the class which implements it does not need to implement this, they can access by default
    interface Animal{
        default String neuronsLevel(long neuronCount){
            if(neuronCount >= 86_000_000_000L){
                return "Human";
            } else{
                return "Inheritance.Animal";
            }
        }
    }

    class Human implements Animal{}

    // 5. Static method
    public static int minNum(int... numbers){
        int min = numbers[0];
        for(int n: numbers){
            min = Math.min(min, n);
        }
        return min;
    }

    public static void main(String[] args){
        Methods m = new Methods();
        System.out.println(m.sum(new int[]{44, 77, 22, 55}));
        m.maxNum(new int[]{44, 77, 22, 55});
        System.out.println(m.factorial(5));
        System.out.println(m.multiples(5.5, 3.1, 22.33, 9.6));
        Methods.Human human = m.new Human();
        System.out.println(human.neuronsLevel(86_000_000_000L));
        System.out.println(human.neuronsLevel(86_000_0_000L));
        System.out.println(minNum(90, 2, 44, 8, 77, 4, 44, 0));
    }
}
