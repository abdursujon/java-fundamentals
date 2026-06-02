final class Immutability {
    private final String name;
    private final int age;

    Immutability(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    // cannot do
    //  public void setName(String name) { this.name = name; }
    public int getAge() { return age; }

    public static void main(String[] args){
        Immutability im = new Immutability("Sujon", 45);
        System.out.println(im.getName());
        // can not set  System.out.println(im.setName());
    }
}
