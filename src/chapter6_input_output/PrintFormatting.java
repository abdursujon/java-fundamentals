import java.io.*;

/**
 * 1. System.out.print()
 * 2. System.out.println()
 * 3. System.out.printf()
 * 4. String.format()
 * 5. PrintWriter
 * 6. Format specifiers
 */
public class PrintFormatting {
    public static void main(String[] args) throws IOException {
        // 1. System.out.print()
        System.out.print("I love");
        System.out.print(" Factorio\n");

        // 2. System.out.println()
        System.out.println("I love cricket");

        // 3. System.out.printf()
        System.out.printf("Name %s, Age: %d\n", "Sujon", 25);
        System.out.printf("Height %.2f\n", 1.78999);
        System.out.printf("Balance %,d\n", 10000000);

        // 4. String.format()
        String result = String.format("%-15s | %15s | %-10d | %.2f", "Abdur", "Sujon", 24555666699999L, 5.988888888);
        System.out.println(result);

        // 5. PrintWriter - write formatted output to file
        PrintWriter pw = new PrintWriter(new FileWriter("fundamentals/chapter6_input_output/files/output2.txt"));
        pw.printf("Name: %s%n", "Sujon");
        pw.printf("Age: %d%n", 25);
        pw.println("I love Factorio");
        pw.close();

        // 6. Format specifier
        System.out.printf("%s%n", "I am a string");// string
        System.out.printf("%d%n", 999999999);      // integer
        System.out.printf("%.3f%n", 5.66908999 );  // float and double
        System.out.printf("%10d%n", 99);           // right align, width 10
        System.out.printf("%-10d hi%n", 99);          // left align, width 10
        System.out.printf("%05d%n", 99);           // zero padded
        System.out.printf("%,d%n", 1000000);       // comma separated
        System.out.printf("%b%n", true);           // boolean
        System.out.printf("%c%n", 'A');            // character

    }
}
