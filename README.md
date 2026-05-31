# learn-java

A practical guide to learning Java from basic to advanced. Every topic is a small, self-contained, runnable `.java` file you can read, edit, and execute. Use it as a step-by-step course or as a quick reference.

## Requirements

- JDK 21+
- Any IDE (IntelliJ IDEA recommended) or just `javac` / `java` from the terminal

## Run an example

Files live directly under each chapter folder with no package declaration, so run them from the file's own directory:

```bash
cd fundamentals/chapter1_basics
javac Variables.java
java Variables
```

In IntelliJ, open the `fundamentals` folder, mark each chapter as a source root if needed, and run any file with a `main` method.

## Curriculum

> Legend: ✅ available · ⬜ planned

### chapter1_basics/
✅ Variables · PrimitiveDataTypes · Operators · TypeCasting · NamingConventions · MainMethod · VarInJava (`var`) · WrapperClasses (autoboxing/unboxing)

**java.lang (auto-imported) classes** — ✅ String, Object, Math, Integer, Long, Double, Boolean, Character, Float, Byte, Short, StringBuilder, StringBuffer, Number, Enum, Record · ⬜ System, Thread, Runnable, Exception, RuntimeException, Error, ClassLoader

### chapter2_control_flow/
✅ ConditionalStatements · TernaryOperator · Loops · InstanceofKeyword

### chapter3_arrays/
✅ OneDimensionalArray · TwoDimensionalArray · JavaArraysClass

### chapter4_strings/
✅ Strings · StringBuilders (StringBuilder & StringBuffer) · RegularExpressions

### chapter5_methods/
✅ Methods (recursion, varargs, default/static methods)

### chapter6_input_output/
✅ Scanners · InputOutput · PrintFormatting · DateTimeAPI

### chapter7_utility_classes/
✅ Maths · Randoms · Numbers · Systems

### chapter8_typeof_classes/
✅ PublicClass / DefaultClass · Abstracts · InterfaceInJava · Enums · NestedPublicProtectedAndPrivateClass · AnonymousClassInJava · Records

### chapter9_collections_and_java_useful_classes/
✅ BuiltInClass · ClassLoaders · CollectionsHelperClassOfCollection · Iterators · ObjectBuiltInJavaUniversalClass · ObjectsHelperClassOfObject · Streams

### chapter10_object_behavior/
✅ EqualsHashCode · CompareContentOfObjectByOverridingObjectMethods · NullPointerExceptions · CloningInJava · Immutability

### chapter11_oop/
✅ Encapsulation · AccessModifiers (static/final/super) · inheritance/ · polymorphism/ · abstraction/

### chapter12_exceptions/
**Must-know:** ✅ TryCatchFinally · CheckedVsUnchecked · ThrowVsThrows · CommonRuntimeExceptions · TryWithResources · CommonCheckedCompileTimeExceptions · ⬜ ThrowableHierarchy · ExceptionPropagation

**Important:** ✅ custom_checked_exception/ · custom_unchecked_exceptions/ · ThrowAndWrap · ExceptionChaining · ⬜ MultiCatch

**Good to know / Niche:** ⬜ FinallyPitfalls · ExceptionsInLambdas · ExceptionsInConstructors · ExceptionsInOverriding · ExceptionsInThreads · SuppressedExceptions · AssertionsVsExceptions

> **ExceptionPropagation:** an unhandled exception travels up the call stack. If `c()` calls `b()` calls `a()` and none handle it, the JVM walks `a → b → main`; if `main` doesn't handle it either, the JVM's default handler throws it as an unchecked (runtime) exception and terminates the program.

### chapter13_functional/
✅ generics/ · ⬜ Lambda · Comparable · Comparator · Runnable · Callable · Predicate · Consumer · Supplier · Method References · Optional

### chapter14_file_handling/
⬜ FileHandling · Serialization · NIO

### chapter15_advanced/
✅ concurrency/Threads · ⬜ Annotations · GarbageCollection · Reflection · and more concurrency:
- Runnable / Callable, `synchronized`, `volatile`
- ExecutorService / ThreadPool, Future / CompletableFuture
- Race conditions / deadlocks, `wait()` / `notify()`
- Lock / ReentrantLock

## License

See [LICENSE](LICENSE).
