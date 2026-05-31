import java.util.Arrays;
import java.util.regex.*;

/**
 * Regular Expressions in Java
 * <p>
 * Pattern & Matcher
 * 1. Pattern.compile(regex)
 * 2. matcher.matches()       - entire string must match
 * 3. matcher.find()          - finds match anywhere in string
 * 4. matcher.group()         - returns matched text
 * 5. matcher.replaceAll()    - replace all matches
 * 6. matcher.replaceFirst()  - replace first match
 * 7. String.matches(regex)   - shorthand for full match
 * 8. String.split(regex)     - split by pattern
 * <p>
 * Common Regex Patterns
 * [a-z]        - lowercase letter
 * [A-Z]        - uppercase letter
 * [0-9] or \d  - digit
 * \w           - word character (a-z, A-Z, 0-9, _)
 * \s           - whitespace
 * .            - any character
 * +            - one or more
 * *            - zero or more
 * ?            - zero or one
 * ^            - start of string
 * $            - end of string
 */
public class RegularExpressions {
    public static void main(String[] args) {
        // 1. Pattern.compile(regex)
        Pattern p1 = Pattern.compile("[a-zA-Z]+");
        Pattern p2 = Pattern.compile("[a-zA-Z0-9]+");
        Pattern p3 = Pattern.compile("\\d+\\.?\\d*");

        // 2. matcher.matches() - entire string must match
        Matcher m1 = p1.matcher("HelloWorld");
        System.out.println(m1.matches());
        String[] arr = {"Hello190", "World123", "90", "&", "$", "World123"};
        System.out.println("Hello190".matches("[a-zA-Z0-9]+"));
        System.out.println(arr[1].matches("[a-zA-Z0-9]+"));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].matches("[a-zA-Z0-9]+")) {
                System.out.println("Matching pattern found in index: " + i);
            }
        }

        // 3. matcher.find() - finds match anywhere in string
        Matcher m2 = p3.matcher("I love the number 88, 89.7 and 11.88");
        while (m2.find()) {
            System.out.println(m2.group()); // 4. group() returns matched text
        }

        // 5. matcher.replaceAll()
        String s = "I love the number 88, 89.7 and 11.88";
        Matcher m3 = p3.matcher(s);
        String s2 = m3.replaceAll("#");
        System.out.println(s2);

        // 6. matcher.replaceFirst()
        Matcher m4 = p1.matcher(s);
        String s3 = m4.replaceFirst("We");
        System.out.println(s3);

        // 7. String.split(regex)
        String[] arr2 = "Monday0Tuesday1Wednesday2Thursday3Friday4Saturday5Sunday6".split("\\d");
        System.out.println(Arrays.toString(arr2));

        // practical example
        String email = "sujon_abdur@hotmail.com";
        String phone = "07874383989";
        String pass = "Secret139!444444444";
        String emailRegex = "^[\\w.]+@[\\w.]+\\.[a-zA-Z]{2,}$";
        String phoneRegex = "^07\\d{9}$";
        /**
         * (?=.*[A-Z])  - must contain at least one uppercase letter somewhere
         * (?=.*\d)     - must contain at least one digit somewhere
         * (?=.*[!@#])  - must contain at least one special character somewhere
         * .{14,}$      - must be at least 14 character or more
         */
        String passRegex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!&@%£$]).{14,}$";

        if (email.matches(emailRegex)) {
            System.out.println("Valid email address.");
            if (phone.matches(phoneRegex)) {
                System.out.println("Valid phone number");
                if (pass.matches(passRegex)) {
                    System.out.println("Valid Password");
                }
                if (!pass.matches(passRegex)) {
                    System.out.println("Invalid Password");
                }
            }
            if (!phone.matches(phoneRegex)) {
                System.out.println("Invalid Phone Number");
            }
        } else {
            System.out.println("Invalid email address.");
        }

    }
}
