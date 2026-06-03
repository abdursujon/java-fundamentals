package chapter16_jvm_internals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Annotations: metadata you attach to code (@Override, @Deprecated, custom ones).
 * They don't run anything themselves - tools, the compiler, or your own reflection code
 * read them and act on them.
 *
 * Signifacance of annotations: frameworks like Spring and JUnit are driven by annotations (@Test,
 * @Autowired). Knowing how to declare one and read it at runtime shows how that "magic" works.
 *
 * 1. @Retention(RUNTIME) - keep the annotation available at runtime so reflection can read it
 * 2. @Target - where the annotation may be used (method, field, class...)
 * 3. declare a custom annotation with @interface
 * 4. read it at runtime with getAnnotation()
 */
public class AnnotationsExample {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Author {
        String name();
    }

    @Author(name = "Sujon")
    public void writeReport() {
        System.out.println("report written");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = AnnotationsExample.class.getMethod("writeReport");
        Author author = method.getAnnotation(Author.class);
        System.out.println("writeReport author: " + author.name()); // Sujon
    }
}

