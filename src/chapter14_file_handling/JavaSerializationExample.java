import java.io.*;

/**
 * Serialization: turning a live object into bytes (serialize) and rebuilding it later (deserialize).
 *
 * Purpose - persist or transmit an object's full state without hand-writing each field:
 * <p>
 *  Example use case are:
 *  - Save program state to disk (save a game, settings, a document)
 *  - Send objects across a network between programs
 *  - Caching (store computed objects, reload fast)
 *  - Deep copy (serialize then deserialize = fully independent clone)
 * </p>
 *
 * Requirement: the class must implement Serializable (a marker interface - no methods).
 *
 * Key calls example
 *   1. implements Serializable, marks the class as allowed to be serialized
 *   2. new FileOutputStream(path), opens the file to write bytes into
 *   3. new ObjectOutputStream(stream), wraps it; knows how to turn objects into bytes
 *   4. out.writeObject(obj)- Serialize: writes the whole object to the file
 *   5. new FileInputStream(path), opens the file to read bytes from
 *   6. new ObjectInputStream(stream), wraps it; knows how to turn bytes back into objects
 *   7. in.readObject(), Deserialize: rebuilds the object (cast back to its type)
 */
public class SerializationExample {

    static class Person implements Serializable {
        private static final long serialVersionUID = 1L; // version id, detects class changes between save and load
        String name;
        int age;

        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Person original = new Person("Sujon", 65);
        String file = "src/resource/file_handling/modern-file-system.ser";

        // Serialize - Object -> bytes -> file
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(original);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }
}
