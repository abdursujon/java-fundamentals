/**
 1. toString()
 2. equals(Object obj)
 3. hashCode()
 4. getClass()
 5. clone()
 7. wait()
 8. wait(long timeout)
 9. wait(long timeout, int nanos)
 10. notify()
 11. notifyAll()
 */
public class ObjectBuiltInJavaUniversalClass {
    private class Person implements Cloneable{
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString(){
            return "Name:" + name + ", Age: " + age;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(!(obj instanceof Person)) return false;
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }

        @Override
        public Person clone() throws CloneNotSupportedException{
            return (Person) super.clone();
        }

    }
    public static void main(String[] args) throws CloneNotSupportedException{
        ObjectBuiltInJavaUniversalClass o = new ObjectBuiltInJavaUniversalClass();
        Person p1 = o.new Person("Sujon", 22);

        // 1. toString()
        System.out.println(p1.toString());

        // 2. equals(Object obj)
        Person p2 = p1;
        System.out.println(p1.equals(p2));
        Person p3 = o.new Person("Rakib", 22);
        System.out.println(p2.equals(p3));

        // 3. hashCode()
        System.out.println(p1.hashCode());

        // 4. getClass()
        System.out.println(p1.getClass());

        // 5. clone()
        Person p4 =  p1.clone();
        System.out.println(p4);

        // 7. wait()
        // 8. wait(long timeout)
        // 9. wait(long timeout, int nanos)
        // 10. notify()
        // 11. notifyAll()
    }
}