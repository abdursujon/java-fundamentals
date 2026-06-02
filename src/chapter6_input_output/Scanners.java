import java.util.Scanner;

/**
 * 1. nextLine()
 * 2. next()
 * 3. nextInt()
 * 4. nextDouble()
 * 5. nextBoolean()
 * 6. hasNext()
 * 7. close()
 */
public class Scanners{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // 1. nextLine() - reads entire line including spaces
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello: " + name);

        // 2. next() reads only single word, stops at space
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.println("Your username: " + username);

        // 3. nextInt() handles integer
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Your age is: " + age);

        // 4. nextDouble() handles double
        System.out.print("Enter your height: ");
        double height = scanner.nextDouble();
        System.out.println("Your height is: " + height);

        // 5. nextBoolean() handles double
        System.out.print("Do you go to University? (True/False): ");
        boolean universityDetails = scanner.nextBoolean();
        System.out.println("Attend University: " + universityDetails);

        // 6. hasNext() check if there is more token after next
        Scanner scanner2 = new Scanner("1 2 3 4 5 6 7 8 9");
        while(scanner2.hasNext()){
            System.out.print(scanner2.nextInt() + " ");
        }

        // 7. close() scanner
        scanner.close();
        scanner2.close();
    }
}