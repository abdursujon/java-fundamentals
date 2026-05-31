/**
 * Encapsulation is hiding internal data of a class and only exposing it through controlled methods (getters/setters).
 */
public class Encapsulation {
    private String name;
    private int id;

    Encapsulation( String name, int id){
        this.name = name;
        this.id = id;
    }


    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return name;
    }

    public void etId(int i){
        this.id = i;
    }

    public int getId() {
        return id;
    }
}

class AccessEncapsulatedClass{
    String name;
    int id;

    AccessEncapsulatedClass(Encapsulation personDetails){
        this.name = personDetails.getName();
        this.id = personDetails.getId();
    }

    @Override
    public String toString(){
        return "Person name: " + name + ", Id: " + id;
    }

    public static void main(String[] args){
        AccessEncapsulatedClass ac = new AccessEncapsulatedClass(new Encapsulation("Sujon", 55));
        System.out.println(ac);
    }
}
