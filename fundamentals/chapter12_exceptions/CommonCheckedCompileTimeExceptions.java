import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonCheckedCompileTimeExceptions {
    public String name = "Sujon";

    public static void main(String[] args) {

        // 1. FileNotFoundException -> file path does not exist (subclass of IOException)
        try {
            FileReader fr = new FileReader("does_not_exist.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e);
        }

        // 2. IOException -> any I/O failure (reading, writing, closing a stream, etc.)
        try {
            BufferedReader br = new BufferedReader(new FileReader("does_not_exist.txt"));
            br.readLine(); // could fail with IOException
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        // 3. ClassNotFoundException -> class is not found on the classpath at runtime
        try {
            Class.forName("com.java.NotARealClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e);
        }

        // 4. NoSuchMethodException -> reflective lookup for a method that doesn't exist
        try {
            // Method m = String.class.getMethod("equals", Object.class); valid version
            Method m2 = String.class.getMethod("equals()", Object.class);
            System.out.println(m2);
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException: " + e);
        }

        // 5. NoSuchFieldException -> reflective lookup for a field that doesn't exist
        try {
            Field f = String.class.getField("fieldThatDoesNotExist");
        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException: " + e);
        }

        // 6. InterruptedException -> a thread was interrupted while waiting/sleeping
        // schedule another thread to interrupt 'main' after 10 ms
        Thread main = Thread.currentThread();
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {

            }
            main.interrupt(); // wakes main out of sleep early
        }).start();

        try {
            Thread.sleep(5000); // would sleep 5s, but gets interrupted ~10ms in
            System.out.println("slept the full time"); // won't reach this
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e + " -------");
        }

        // 7. ParseException -> input string does not match the expected format
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            Date d = sdf.parse("2024-13-40");// wrong format
        } catch (ParseException e) {
            System.out.println("ParseException: " + e);
        }

        // 8. MalformedURLException -> URL string is not a legal URL (subclass of IOException)
        try {
            URL url = new URL("htp:/bad url"); // bad protocol + spaces
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e);
        }

        // 9. URISyntaxException -> URI string violates RFC 2396 syntax
        try {
            URI uri = new URI("http://example.com/some path"); // unencoded space
        } catch (URISyntaxException e) {
            System.out.println("URISyntaxException: " + e);
        }

        // 10. SQLException -> database access error (driver missing, bad URL, etc.)
        try {
            Connection con = DriverManager.getConnection("jdbc:fake://localhost/db");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        // 11. CloneNotSupportedException -> calling clone() on a class that does not implement Cloneable
        try {
            NotCloneable obj = new NotCloneable();
            obj.doClone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException: " + e);
        }

        System.out.println("All common checked exceptions demonstrated.");
    }

    // helper class for #11
    static class NotCloneable {
        // does NOT implement Cloneable, so clone() throws CloneNotSupportedException
        public Object doClone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
