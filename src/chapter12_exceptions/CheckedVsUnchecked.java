import java.io.FileReader;
import java.io.IOException;

public class CheckedVsUnchecked {
    public static void main(String[] args) {
        // Checked exception (Checked by compiler [javac])
        try {
            FileReader fr = new FileReader("missing.txt");
        } catch (IOException e) {
            System.out.println("Checked exception caught by javac: " + e);
        }

        // Unchecked exception (RuntimeException check by [JVM]) compiler does not force handle this exception it is only checked on
        try {
            String s = null;
            System.out.println(s.length()); // Only checked in runtime not by compiler
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception caught by jvm: " + e);
        }
    }
}
