package chapter16_jvm_internals;

/**
 * Garbage collection: Java automatically frees memory for objects nothing references
 * anymore. You don't free memory by hand like in C - the GC does it.
 *
 * We never call free/delete in Java. Understanding that "unreachable =
 * eligible for collection" explains memory leaks (objects you accidentally keep referencing
 * never get freed) and why you can't force exactly when GC runs.
 *
 * 1. set a reference to null - the old object becomes unreachable, eligible for GC
 * 2. System.gc() - a REQUEST to run GC, not a guarantee
 * 3. finalize() is deprecated - don't rely on it for cleanup
 * 4. Runtime memory methods - inspect heap usage
 */
public class GarbageCollectionExample {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        String data = new String("big object");
        System.out.println("created: " + data);

        data = null; // nothing references the String now -> eligible for GC

        System.gc(); // ask the JVM to collect; it may or may not run now

        long usedBytes = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("approx used heap: " + usedBytes + " bytes");
    }
}