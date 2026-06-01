/**
 * Java interface can only have public(no body), abstract, default, static, or private methods(Java 9+)
 */
public interface InterfaceInJava{
    // public with no body and abstract keyword does same job
    public void typeOfClass();
    public abstract void speak(); // everything specified
    public void speakTwo(); // abstract implied
    abstract void speakThree(); // public implied
    void speakFour(); // both public and abstract implied

    default int sum(int a, int b){return a + b;}
    private void makeNoise(){
        System.out.println("I am a private method");
    }
}