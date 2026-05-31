import java.util.Comparator;
import java.util.Objects;

/**
 * Objects utility class (java.util.Objects)
 * 1. Objects.equals(a, b)
 * 2. Objects.hash(fields...)
 * 3. Objects.toString(obj)
 * 4. Objects.toString(obj, default)
 * 5. Objects.requireNonNull(obj)
 * 6. Objects.requireNonNull(obj, message)
 * 7. Objects.isNull(obj)
 * 8. Objects.nonNull(obj)
 * 9. Objects.compare(a, b, comparator)
 */
public class ObjectsHelperClassOfObject {
    public static void main(String[] args){
        String s1 = "I am not null";
        String s2 = null;

        // 1. Objects.equals(a, b)
        System.out.println(Objects.equals(s1, s2));

        // 2. Objects.hash(fields...) generate hashCode from multiple fields
        System.out.println(Objects.hash("Sujon", 22, "Engineer"));

        // 3. Objects.toString(obj) null safe toString
        System.out.println(Objects.toString(s2));

        // 3. toString - null safe toString
        System.out.println(Objects.toString(s1));
        System.out.println(Objects.toString(s2));

        // 4. toString with default
        System.out.println(Objects.toString(s2, "The object you are trying to access is null"));

        // 5. requireNonNull - throws NullPointerException if null
        try {
            System.out.println(Objects.requireNonNull(s2));
        } catch (NullPointerException e) {
            System.out.println("Object trying to access was null");
        }

        // 6. requireNonNull with message
        try {
            Objects.requireNonNull(s2, "s2 cannot be null");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        // 7. isNull
        System.out.println(Objects.isNull(s1));
        System.out.println(Objects.isNull(s2));

        // 8. nonNull
        System.out.println(Objects.nonNull(s1));
        System.out.println(Objects.nonNull(s2));

        // 9. compare
        System.out.println(Objects.compare("apple", "banana", (Comparator<String>) String::compareTo)); // - 1
        System.out.println(Objects.compare("Orange", "Orange", (Comparator<String>) (a, b) -> s1.compareTo(s2))); // 0
    }
}
