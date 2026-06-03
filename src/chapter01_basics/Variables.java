public class Variables {
    // 1. Instance variables
    String name = "Football";
    int year = 2026;

    // 2. Static variables belongs to class not a method
    static int numberOfBallsCount = 6;

    // 3. Final variables, value cannot change and a class constant
    static final String COMPANY_NAME = "Google";

    // 4. Final variables constant value can not change
    final double PI = 3.14159;

    /**
     5. Volatile variable - in multithreading instead of each task reading state from its own cache this allows us them to read from
     main memory (RAM) so updates are noticed in all tasks. (used in multithreading)
     */
    volatile boolean isRunning = true;

    /**
     * 6. Transient variable - skipped during serialization. Works as a information hiding mechanices.
     * Serialization = converting an object into a savable/sendable format (like bytes or a file), so you can store it or
     * send it over a network.
     * ObjectBuiltInJavaUniversalClass only exist in RAM — when your program stops, they're gone. Serialization lets you persist them and send them over to other networks.
     */
    transient String password = "password123";

    // 7. Method parameter - passed a variable into a method
    public String greetEmployee(String name){

        // 8. Local variable
        int increasedSalaryAmount = 4000;
        return "Congratulation you have got the promotion Mr " + name + ". Your salary will increase by £" +  increasedSalaryAmount;

    }

    public static void main(String[] args){
        Variables v = new Variables();

        System.out.println("Name: " + v.name);
        System.out.println("Year: " + v.year);
        System.out.println("Balls count: " + numberOfBallsCount);
        System.out.println("Company: " + COMPANY_NAME);
        System.out.println("PI: " + v.PI);
        System.out.println("Is running: " + v.isRunning);
        System.out.println("Password: " + v.password);
        System.out.println(v.greetEmployee("Sujon"));
    }
}