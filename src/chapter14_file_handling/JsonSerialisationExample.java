import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * JSON serialization with Gson library provided by google: it turns an object into JSON text (serialize) and
 * rebuilding it from that text (deserialize). Unlike Java's built-in serialization,
 * the output is human-readable text and works across languages — but it needs the
 * external Gson library (com.google.gson) added to the classpath; it is not in the java JDK.
 * <p>
 * How it works through the library:
 * Gson uses reflection to inspect the object's fields, writes each field as a
 * JSON key/value (toJson), and reverses that — reading keys back into a new
 * object's fields (fromJson). Do not require to implement Serializable.
 * <p>
 * Key methods used in this example class are:
 * 1. new Gson(), creates the Gson engine that does the converting
 * 2. gson.toJson(object), serialize object -> JSON String for example {"name":"Jasper","species":"Dog","color":"Black \u0026 White","age":2}
 * 3. Files.writeString(path, json), save that JSON text to a file
 * 4. Files.readString(path), read the JSON text back from the file
 * 5. gson.fromJson(text, Person.class), deserialize: JSON String -> a new Animal Object
 */
public class JsonSerialisationExample {
    static class Animal {
        String name;
        String species;
        String color;
        int age;

        Animal(String name, String color, String species, int age) {
            this.name = name;
            this.species = species;
            this.color = color;
            this.age = age;
        }

        public static void main(String[] args) throws IOException {
            Gson gson = new Gson();
            Animal animal = new Animal("Jasper", "Black & White", "Dog", 2);
            Path file = Path.of("src/resource/file_handling/animal.json");

            // Serialise - object -> json text -> file
            String serialiseAnimal = gson.toJson(animal);
            Files.writeString(file, serialiseAnimal);

            // Deserialize - file -> json text -> object
            String deserializeAnimal = Files.readString(file);
            Animal loadAnimalObject = gson.fromJson(deserializeAnimal, Animal.class);
            System.out.println("Animal name: " + loadAnimalObject.name + ", Species: " + loadAnimalObject.species
                    + ", Color: " + loadAnimalObject.color + ", Age: " + loadAnimalObject.age);
        }
    }
}
