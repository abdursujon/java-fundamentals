package functional_applications;

public class Person implements Comparable<Person>{

    private int age;

    Person(int age){
        this.age = age;
    }

    public int compareTo(Person differentPerson){
        return Integer.compare(this.age, differentPerson.age);
    }

    public static void main(String[] args){
        Person older = new Person(44);
        Person middleAge = new Person(33);
        Person younger = new Person(18);
        Person younger2 = new Person(18);
        System.out.println(older.compareTo(younger)); // 1 when p1 > p2
        System.out.println(younger.compareTo(middleAge)); // -1 when p1 < p2
        System.out.println(younger.compareTo(younger2)); // 0 when p1 = p2
    }
}
