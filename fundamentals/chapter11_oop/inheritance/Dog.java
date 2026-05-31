package inheritance;

interface Animal{
    public void speak();
}

class Cat implements Animal{
    @Override
    public void speak(){
        System.out.println("Meow Meow");
    }
}

public class Dog implements Animal{
    @Override
    public void speak() {
        System.out.println("Woof Woof");
    }

    public static void main(String[] args){
        Dog d = new Dog();
        d.speak();
        Cat c = new Cat();
        c.speak();
    }
}
