/**
 * Math utility class - all methods are static, no instantiation needed
 * 1.  Math.abs(x)
 * 2.  Math.max(a, b)
 * 3.  Math.min(a, b)
 * 4.  Math.pow(base, exponent)
 * 5.  Math.sqrt(x)
 * 6.  Math.ceil(x)
 * 7.  Math.floor(x)
 * 8.  Math.round(x)
 * 9.  Math.log(x)
 * 10. Math.log10(x)
 * 11. Math.random()
 * 12. Math.PI
 * 13. Math.E
 * 14. Math.sin(x)
 * 15. Math.cos(x)
 * 16. Math.tan(x)
 * 17. Math.hypot(a, b)
 * 18. Math.signum(x)
 */
public class Maths {
    public static void main(String[] args){
        System.out.println(Math.abs(-90));

        System.out.println(Math.min(45, 55.5));
        System.out.println(Math.max(993, 344.4));

        // first arg is the base
        System.out.println(Math.pow(2, 7));
        System.out.println(Math.sqrt(16));

        // round up
        System.out.println(Math.ceil(4.1));
        // round down
        System.out.println(Math.floor(4.9));
        // round to nearest
        System.out.println(Math.round(5.4));
        System.out.println(Math.round(5.5));

        System.out.println(Math.log(Math.E));
        System.out.println(Math.log10(300));
        System.out.println(Math.round(Math.random() * 5));

        System.out.println(Math.PI);
        System.out.println(Math.E);

        System.out.println(Math.sin(Math.PI / 5));
        System.out.println(Math.cos(0));
        System.out.println(Math.tan(Math.PI * 5));

        // hypotenuse sqrt(a^2 + b^2)
        System.out.println(Math.hypot(5, 6));

        // returns sign of number (-1, 0, 1)
        System.out.println(Math.signum(-5));
        System.out.println(Math.signum(0));
        System.out.println(Math.signum(5));
    }
}
