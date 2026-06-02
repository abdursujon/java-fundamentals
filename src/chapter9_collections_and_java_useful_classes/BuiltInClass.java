import java.util.Scanner;

public class BuiltInClass {

    interface Animals {
        void animalSound();
    }

    static class Dog implements Animals{
        public void animalSound(){
            System.out.println("Woof Woof");
        }
    }

    static class Cat implements Animals{
        public void animalSound(){
            System.out.println("Meow Meow");
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter animal type: ");
        String input = scan.nextLine();

       java.lang.Class<?> typeOfClass = java.lang.Class.forName("BuiltInClass$" + input);
       Animals animal = (Animals) typeOfClass.getDeclaredConstructor().newInstance();
       animal.animalSound();
    }
}
