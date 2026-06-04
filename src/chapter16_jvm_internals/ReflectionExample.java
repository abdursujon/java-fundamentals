package chapter16_jvm_internals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * Reflection: inspecting and using a class at runtime - its fields, methods, constructors -
 * without knowing them at compile time.
 *
 * This is how frameworks create objects and call methods they have never seen at compile
 * time (Spring building beans, JUnit finding @Test methods, Gson reading an object's fields).
 * It is rarely written by hand, but it explains how those libraries work internally.
 *
 * 1. obj.getClass() - gets the Class object describing a type
 * 2. getDeclaredFields() - lists the fields
 * 3. getDeclaredMethods() - lists the methods
 * 4. setAccessible(true) - bypasses private access to read or set a field
 * 5. method.invoke(obj, args) - calls a method by reflection
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
