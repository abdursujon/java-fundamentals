package chapter16_jvm_internals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * Reflection: inspecting and using a class at runtime - its fields, methods, constructors -
 * without knowing them at compile time.
 *
 * Why it matters: it's how frameworks create objects and call methods they've never seen
 * (Spring building beans, JUnit finding @Test methods, Gson reading your fields). You rarely
 * write it yourself, but understanding it demystifies how those libraries work.
 *
 * 1. obj.getClass() - get the Class object describing a type
 * 2. getDeclaredFields() - list the fields
 * 3. getDeclaredMethods() - list the methods
 * 4. setAccessible(true) - bypass private to read/set a field
 * 5. method.invoke(obj, args) - call a method by reflection
 */
public class ReflectionExample {

    static class Person {
        private String name = "Sujon";
        public void greet() { System.out.println("Hi, I'm " + name); }
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> type = person.getClass();

        System.out.println("Class: " + type.getSimpleName());

        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println("Field " + field.getName() + " = " + field.get(person));
        }

        Method greet = type.getMethod("greet");
        greet.invoke(person); // Hi, I'm Sujon
    }
}
