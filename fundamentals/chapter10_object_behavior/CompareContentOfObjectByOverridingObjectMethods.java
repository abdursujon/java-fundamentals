import java.util.Objects;

/**
 * If we are given two object for example personA and personB we have no way of knowing if those object is the same person.
 * We can compare content of person to determine if both object are same by overriding equals and hashcode from java Object class.
 */
public class CompareContentOfObjectByOverridingObjectMethods {
    class Person{
        String name;
        int age;
        Person(String name, int age){
            this.name = name;
            this.age = age;
        }


        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(!(obj instanceof Person)) return false;
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }

        @Override
        public int hashCode(){
            return Objects.hash(name, age);
        }
    }

    public static void main(String[] args){
        CompareContentOfObjectByOverridingObjectMethods compare = new CompareContentOfObjectByOverridingObjectMethods();
        Person person = compare.new Person("Susan", 32);
        Person person2 = compare.new Person("Susan", 32);
        Person person3 = compare.new Person("Iron", 25);
        System.out.println(person.equals(person2));
        System.out.println(person2.equals(person2));
        System.out.println(person2.equals(person3));
    }
}
