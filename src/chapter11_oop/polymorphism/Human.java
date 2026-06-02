package polymorphism;

public class Human extends Sleep implements Animal {

    public void speak(){
        System.out.println("According to human, they are the most advance speaker on earth.");
    }

    @Override
    public String sleep(){
        return "Human sleep more than one third of their life!.";
    }

}
