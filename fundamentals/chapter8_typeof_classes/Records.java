/**
 * when we declare a class as record java auto gives us
 * 1. private final fields  (e.g. private final String name)
 * 2. auto generates constructor for the class with all fields
 * 3. override toString() method to print the objects
 * 4. equals() method to check if two object is equal
 * 5. hashCode() method
 * 6. auto generates getter and setters for fields
 * 7. record class can have body as well
 */
public record Records(String name, int age){
    public Records {
        if( age < 0){
            throw new IllegalArgumentException("age must be >= 0");
        }
    }

    public static void main(String[] args){
        Records r = new Records("Sujon", 22);
        System.out.println(r);
    }
}