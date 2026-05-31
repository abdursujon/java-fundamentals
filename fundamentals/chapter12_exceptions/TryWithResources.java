import java.io.*;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Demonstrates Java's try-with-resources statement (Java 7+).
 *
 * <p><b>What it does:</b> Any resource declared inside {@code try (...)} has its
 * {@code close()} method called automatically when the block exits — whether
 * normally, via {@code return}, or via an exception. No manual {@code finally}
 * needed.
 *
 * <p><b>Why we need it:</b>
 * <ul>
 *   <li><b>Prevents resource leaks.</b> Files, sockets, DB connections, and
 *       streams must be closed or the program eventually runs out of OS handles.
 *       Try-with-resources guarantees cleanup even if an exception is thrown.</li>
 *   <li><b>Replaces verbose boilerplate.</b> The pre-Java-7 pattern needed a
 *       null-check + nested try/catch inside {@code finally} for every resource.
 *       Try-with-resources collapses that into one line.</li>
 *   <li><b>Preserves the real exception.</b> If both the body and {@code close()}
 *       throw, the body's exception is primary and {@code close()}'s is attached
 *       via {@code getSuppressed()} — old {@code finally} blocks silently
 *       overwrote the original error.</li>
 * </ul>
 *
 * <p><b>Requirements:</b> The resource type must implement {@link AutoCloseable}
 * (or {@link java.io.Closeable}). All standard I/O, JDBC, and networking classes
 * already do. For custom resource classes, implement {@code AutoCloseable} so
 * callers get this behavior for free.
 *
 * <p>
 *   <li>Multiple resources can be declared in one {@code try (...)}, separated
 *       by semicolons; they are closed in <i>reverse</i> order of declaration.</li>
 *   <li>Since Java 9, an effectively final variable declared outside the try
 *       can be used directly: {@code try (existingVar) { ... }}.</li>
 * <p>
 *
 * <p>
 * Use {@code try (...)} for anything with a {@code close()}
 * method. It's the standard idiom in modern Java for safe resource handling.
 * </p>
 */
public class TryWithResources {

    static class MyResource implements AutoCloseable{
        private final String name;

        MyResource(String name){
            this.name = name;
            System.out.println("opening " + name);
        }

        void use(){
            System.out.println("using" + name);
        }

        @Override
        public void close(){
            System.out.println("closing " + name);
        }
    }


    public static void main(String[] args) throws URISyntaxException {

        // 1. Basic try-with-resources -> resource is auto-closed at end of block
        // Works for any class that implements AutoCloseable / Closeable
        try (BufferedReader br = new BufferedReader(new StringReader("Hello There"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println(e);
        }  // br.close() is called automatically here, even if an exception was thrown


        String dir = new File(
                TryWithResources.class.getProtectionDomain()
                        .getCodeSource().getLocation().toURI()
        ).getPath(); // create file in out directory


        // 2. Multiple resources in one try -> separated by semicolons
        // Closed in reverse order of declaration (writer first, then reader)
        try (
                BufferedReader br = new BufferedReader(new StringReader("I am line 1\nI am line 2"));
                BufferedWriter bw = new BufferedWriter(new FileWriter(dir + "/out.text"))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }


        // 3. try-with-resources + catch + finally still runs after the resource is auto-closed
        try (Scanner sc = new Scanner("42 hello")) {
            System.out.println(sc.nextInt());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally still runs after auto-close");
        }


        // 4. Custom resource -> any class implementing AutoCloseable can be used
        try(MyResource mr = new MyResource("Db connection")){
            mr.use();
        }

    }
}
