import java.net.URL;


/**
 * ClassLoader - loads classes dynamically at runtime
 * 1. getClass().getClassLoader()          - get current class loader
 * 2. loadClass(className)                 - load a class by name
 * 3. getResourceAsStream(name)            - load a resource file as stream
 * 4. getResource(name)                    - get URL of a resource
 * 5. getSystemClassLoader()               - get system class loader
 * 6. getParent()                          - get parent class loader
 */
public class ClassLoaders {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. getClass().getClassLoader() - get current class loader
        ClassLoader classLoader =  ClassLoaders.class.getClassLoader();
        System.out.println(classLoader);

        // 2. loadClass(className)  - load a class by name
       Class<?> loadedClass = classLoader.loadClass("java.util.ArrayList");
        System.out.println(loadedClass.getName());

        // 3. getResourceAsStream(name)  - load a resource file as stream only works when the project has resource directory
        var stream = classLoader.getResourceAsStream("/test_data/large.csv");
        System.out.println(stream != null? "File found" : "File not found");

        // 4. getResource(name) - only works when project has resource directory
        URL resource = classLoader.getResource("/test_data/large.csv");
        System.out.println(resource);

        // 5. getSystemClassLoader()
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 6. getParent()
        System.out.println(classLoader.getParent());
    }
}
