package polymorphism;

public class AccessAnimalBehaviour {
    public static void main(String[] args){
        // We can access classes through the interface they implement,
        // however we can only access the methods that the interface has.
        Animal cat = new Cat();
        cat.speak();
        Animal human = new Human();
        human.speak();

        Sleep c = new Cat();
        System.out.println(c.sleep());
        Sleep h = new Human();
        System.out.println(h.sleep());
    }
}
