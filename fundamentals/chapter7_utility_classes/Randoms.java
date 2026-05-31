import java.util.Random;

/**
 * Random class methods
 * 1.  nextInt()
 * 2.  nextInt(bound)
 * 3.  nextDouble()
 * 4.  nextFloat()
 * 5.  nextLong()
 * 6.  nextBoolean()
 * 7.  nextGaussian()
 * 8.  ints(count)
 * 9.  doubles(count)
 * 10. longs(count)
 */
public class Randoms {
    public static void main(String[] args){

        Random random = new Random();

        System.out.println(random.nextInt());
        System.out.println(random.nextInt(30));
        System.out.println(random.nextDouble());
        System.out.println(random.nextDouble(20));
        System.out.println(random.nextFloat());
        System.out.println(random.nextFloat(5.5f));
        System.out.println(random.nextLong());
        System.out.println(random.nextLong(55L));
        System.out.println(random.nextBoolean());
        System.out.println(random.nextGaussian());
        random.ints(5).forEach(System.out::println);
        random.ints(5, -40, 40).forEach(System.out::println);
        random.doubles(5).forEach(System.out::println);
        random.doubles(4, -10, 10).forEach(System.out::println);
        random.longs(3).forEach(System.out::println);
        random.longs(10, -50, 50);

    }
}
