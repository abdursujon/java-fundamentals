// When we don't declare any access modifier such as public private protected the class is call default access
// Default access class can only be access inside the same package. Therefor it is called package private
class DefaultClass{
    String name;
    String age;
    DefaultClass(){}
    // rest of the things are identical as normal public, private or protected class
    protected class D{

    }
}

