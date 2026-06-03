
/**
 *  = is assignment — it sets a value
 *  == is comparison — it checks equality, returns true or false
 * 1. Arithmetic -> + - * / %
 * 2. Assignment -> = += -= *= /= %=
 * 3. Comparison -> == != > < >= <=
 * 4. Logical -> && || !
 * 5. Increment/Decrement -> ++ --
 * 6. Bitwise -> & | ^ ~ << >>
 */
public class Operators{
    public static void main(String [] args){
        int a = 10;
        int b = 3;

        // 1. Arithmetic
        System.out.println(a + b);   // 13
        System.out.println(a - b);   // 7
        System.out.println(a * b);   // 30
        System.out.println(a / b);   // 3
        System.out.println(a % b);   // 1

        // 2. Assignment
        int c = 10;
        c += 5;   // c = c + 5 -> 15
        c -= 3;   // c = c - 3 -> 12
        c *= 2;   // c = c * 2 -> 24
        c /= 4;   // c = c / 4 -> 6
        c %= 4;   // c = c % 4 -> 2
        System.out.println(c);

        // 3. Comparison
        System.out.println(a == b);  // false
        System.out.println(a != b);  // true
        System.out.println(a > b);   // true
        System.out.println(a < b);   // false
        System.out.println(a >= b);  // true
        System.out.println(a <= b);  // false

        // 4. Logical
        System.out.println(true && false);  // false
        System.out.println(true || false);  // true
        System.out.println(!true);          // false

        // 5. Increment / Decrement
        int x = 5;
        System.out.println(x++);  // prints 5, then becomes 6
        System.out.println(++x);  // becomes 7, then prints 7
        System.out.println(x--);  // prints 7, then becomes 6
        System.out.println(--x);  // becomes 5, then prints 5

        // 6. Bitwise
        System.out.println(5 & 3);   // 1  (AND)
        System.out.println(5 | 3);   // 7  (OR)
        System.out.println(5 ^ 3);   // 6  (XOR)
        System.out.println(~5);      // -6 (NOT)
        System.out.println(5 << 1);  // 10 (left shift)
        System.out.println(5 >> 1);  // 2  (right shift)
    }
}