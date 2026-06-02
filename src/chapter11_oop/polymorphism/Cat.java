package polymorphism;

public class Cat extends Sleep implements Animal {
    public void speak(){
        System.out.println("Meow Meow");
    }

    @Override
    public String sleep(){
        return "Cat loves to sleep. They sleep 14/16 hours a day.";
    }
}
