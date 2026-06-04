import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Modern file handling with java.nio.file: shorter, plus directory/copy/attribute power.
 * <p>
 * Key methods used, in order of appearance:
 * 1. Path.of("src/resource/file_handling/modern-file-system.txt"), build a Path (the file's address)
 * 2. Files.write(path, List.of(Strings), write lines to a file (overwrites existing content)
 * 3. Files.readAllLines(path), read whole file into a List, one entry per line
 * 4. Files.writeString(path, str, APPEND), write/append a String; StandardOpenOption.APPEND adds to end
 * 5. Files.readString(path), read whole file into one String
 * 6. Files.exists(path), true if the file exists
 * 7. Files.size(path), file size in bytes
 * 8. Files.copy(src, dest, REPLACE_EXISTING) — copy file; StandardCopyOption.REPLACE_EXISTING overwrites dest
 * </p>
 */
public class NIOModernWayOfFileHandling {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("src/resource/file_handling/modern-file-system.txt");

        // Write and read in one line each
        Files.write(file, List.of("Ice Cream", "Mushroom", "Orange Juice"));
        List<String> listOfLines = Files.readAllLines(file);
        System.out.println(listOfLines);

        // Append a line of text in existing written file
        Files.writeString(file, "Added: Biscuit", StandardOpenOption.APPEND);

        // Read the whole file as one string, we can store that string to operate any operation
        System.out.println(Files.readString(file));
        String s = Files.readString(file);
        System.out.println("File strings are: \n" + s + "\nFile string length: " + s.length());

        // Check if a file exists
        System.out.println("Does the modern-file-system.txt exists? " + Files.exists(file));
        System.out.println("Size of the modern-file-system.txt file in bytes is: " + Files.size(file) + " bytes");
        Files.copy(file, Path.of("src/resource/file_handling/modern-file-system-copy.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}
