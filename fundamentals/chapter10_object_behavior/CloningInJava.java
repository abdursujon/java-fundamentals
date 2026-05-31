// here implements Clonable interface tells Object class that this class is clonable
// if we do not implement that interface it will through CloneNotSupportedException
public class CloningInJava implements Cloneable{
    String name;

    CloningInJava(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloningInJava c1 = new CloningInJava ("Sujon");
        CloningInJava c2 = (CloningInJava) c1.clone();
    }
}
