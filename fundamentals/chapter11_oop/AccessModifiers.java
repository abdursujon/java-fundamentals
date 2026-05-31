// StaticKeyword, FinalKeyword, SuperKeyword, OverloadingOverriding
public class AccessModifiers {

    // Static field belongs to class, can not be access directly, it is shared by all instantiated object
    public static String name;

    // Must be set once, and can not be change again
    public final String gender;

    public AccessModifiers(String name, String gender) {
        AccessModifiers.name = name;
        this.gender = gender;
    }

    // Will be overridden by subclass
    public void showInfo() {
        System.out.println("Access Modifier Class");
        System.out.println("Name: " + name);
        System.out.println("Gender" + gender);
    }

    // overloading, same method name but with different parameters
    public void showInfo(String message) {
        System.out.println("Overloading message: " + message);
    }

}

class Person extends AccessModifiers {
    String[] hobbies;

    Person(String[] hobbies) {
        // access the constructor of parent class by using super keyword
        super("Sujon", "Male");
        this.hobbies = hobbies;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Person class");
        System.out.println("Hobbies: " + String.join(", ",  hobbies));
    }

    public static void main(String[] args){
        Person p = new Person(new String[]{"Cricket", "Football", "Music", "Gaming"});
        p.showInfo();
        p.showInfo("I love chess too");
    }

}

