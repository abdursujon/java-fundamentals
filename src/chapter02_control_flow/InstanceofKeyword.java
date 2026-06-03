public class InstanceofKeyword{
    public static void main(String[] args){
        Object [] item = {"I am a string", 55, 99.9, false, true};
        for(Object i : item){
            if(i instanceof String){
                System.out.println(i);
            } else if(i instanceof Integer){
                System.out.println("Instance of integer number: " + i);
            } else if(i instanceof Double ){
                System.out.println("Instance of double number: " + i);
            } else if(i instanceof Boolean){
                System.out.println("Instance of boolean " + i);
            }
        }
    }
}