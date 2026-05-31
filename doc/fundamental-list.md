# Java Fundamentals 

This dedicated to learn java fundamentals.  Anyone can use it as a guide to learn java crusial ground knowledge practically.

List of things that will be covered

## 1. Fundamentals of java

### chapter1_basics/
- Variables x
- DataTypes x
- Operators x
- TypeCasting x
- NamingConventions x
- MainMethod x
- Vars x
- Wrapper Classes x
- AutoboxingUnboxing x 

####  java.lang_auto_imported_classes
String x
Object x
Math x
System
Integer x
Long x
Double x
Boolean x
Character x
Float x
Byte x
Short x
StringBuilder x
StringBuffer x
Thread
Runnable
Exception
RuntimeException
Error
BuiltInClass
ClassLoader
Number
Enum x
Record x

### chapter2_control_flow/
- ConditionalStatements x
- TernaryOperator x
- Loops x
- InstanceOf x

### arrays/
- OneDimensionalArray x
- TwoDimensionalArray x
- JavaArraysClass x

### chapter4_strings/
- StringInJava x
- StringBuilder x
- StringBuffer x 
- RegularExpression x

### chapter5_methods/
- Methods x 
- Recursion x
- VarArgs x
- DefaultMethods x
- StaticMethods x

### chapter6_input_output/
- ScannerClass x
- InputOutput x
- PrintFormatting x
- DateTimeAPI x

### chapter7_utility_classes/
- Maths x
- Randoms x

### chapter8_typeof_classes/
- Build In Object BuiltInClass x
- Normal Classes x
- Abstract x
- Interfaces x
- Enums x
- Nested x
- Anonymous x
- Record x

### chapter9_collections_and_java_useful_classes/
- BuiltInClass x
- ClassLoader x
- Collections x
- Iterators x
- Object x
- Objects x
- Streams x

### chapter10_object_behavior
- EqualsHashCode x
- NullPointer x
- Cloning x
- Immutability x

### chapter11_oop_principles/
- Encapsulation x
- inheritance x
- Polymorphism x
- Abstraction x
- AccessModifiers, StaticKeyword, FinalKeyword, SuperKeyword, OverloadingOverriding x

### chapter12_exceptions/
Must-know (daily use)
1. TryCatchFinally x
2. CheckedVsUnchecked x
3. ThrowVsThrows x
4. CommonRuntimeExceptions x
5. TryWithResources x
6. ThrowableHierarchy
![img.png](assets/img.png)
7. CommonCheckedCompileTimeExceptions x
8. ExceptionPropagation
When exception is not handled, exception are propagated upward (spread upward). So if we have three methods calling each other.
For example, void a(){},  void b(){a()}, void c(){b()} here if c does not handle exception, jvm looks for exception in b, if not in 
b, it looks in a, if not in a, looks for the main function. If main does not handle the exception either, program reaches the JVM default
exceptions and through unchecked(Runtime) exception. 

Important (frequent)
9. CustomCheckedException x
10. CustomUncheckedException x
11. MultiCatch x
12. RethrowAndWrap x
13. ExceptionChaining x

Good to know 
14. FinallyPitfalls
15. ExceptionsInLambdas
16. ExceptionsInConstructors
17. ExceptionsInOverriding

Niche 
18. ExceptionsInThreads
19. SuppressedExceptions
20. AssertionsVsExceptions

### chapter13_functional/
1. Generics       
2. Lambda          
3. Comparable
4. Comparator
5. Runnable
6. Callable
7. Predicate
8. Consumer
9. Supplier
10. Method References
11. Optional

### chapter14_file_handling/
- FileHandling
- Serialization
- NIO

### chapter16_advanced/
- Annotations
- GarbageCollection
- Multithreading
- Reflection
- Concurrency
  Threads (creating, starting, stopping)
  Runnable / Callable
  synchronized keyword
  volatile keyword
  ExecutorService / ThreadPool
  Future / CompletableFuture
  Race conditions / deadlocks
  wait() / notify()
  Lock / ReentrantLock
