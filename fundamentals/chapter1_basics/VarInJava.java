
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1. var -> lets Java infer the type automatically (Java 10+)
 * 2. Only works for local variables
 * 3. Cannot use for method parameters, return types, or fields
 */
public class VarInJava{
    public static void main(String [] args){

        // 1. Without var
        String name = "John";
        int age = 25;
        double price = 9.99;

        // 2. With var we can avoid declaring type, but it is not recommended
        var name2 = "John";      // String
        var age2 = 25;            // int
        var price2 = 9.99;        // double
        var list = new ArrayList<String>();  // ArrayList<String>

        System.out.println(name2);
        System.out.println(age2);
        System.out.println(price2);

        // 3. Var can be useful when type is long
        // without var
        HashMap<String, List<Integer>> map1 = new HashMap<>();
        // with var
        var map2 = new HashMap<String, List<Integer>>();

        // 4. Cannot do this
        // var x;          -> must assign a value
        // var y = null;   -> can't infer type from null
    }
}