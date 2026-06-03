import java.util.*;
/**
 * Creation/ Info
 * 1. length()
 * 2. isEmpty() / isBlank()
 * 3. charAt(index)
 * 4. indexOf(str) / lastIndexOf(str)
 * 5. contains(str)
 *
 * Comparison
 * 6. equals(str) / equalsIgnoreCase(str)
 * 7. compareTo(str) / compareToIgnoreCase(str)
 * 8. startsWith(str) / endsWith(str)
 * 9. matches(regex)
 *
 * Transformation
 * 10. toUpperCase() / toLowerCase()
 * 11. trim() / strip()
 * 12. replace(old, new) / replaceAll(regex, new)
 * 13. substring(from) / substring(from, to)
 * 14. repeat(n)
 * 15. String.format(template, args)
 *
 * Split / join
 * 16. split(regex)
 * 17. String.join(delimiter, elements)
 * 18. toCharArray()
 *
 * Conversion
 * 19. String.valueOf(x)
 * 20. Integer.parseInt(str) / Double.parseDouble(str)
 */
public class Strings {
    public static void main(String[] args) {

        // 1. length()
        String s = "I love Factorio";
        System.out.println(s.length());

        // 2. isEmpty() / isBlank()
        System.out.println(s.isEmpty());
        System.out.println(" ".isBlank());

        // 3. charAt(index)
        System.out.println(s.charAt(2));

        // 4. indexOf(str) / lastIndexOf(str)
        System.out.println(s.indexOf("F"));
        System.out.println(s.lastIndexOf("o"));

        // 5. contains(str)
        System.out.println(s.contains(" "));
        System.out.println(s.contains("x"));

        // 6. equals(str) / equalsIgnoreCase(str)
        System.out.println("h".equals(s));
        System.out.println("I love Factorio".equals(s));
        System.out.println("I LOVE FACTORIO".equalsIgnoreCase(s));

        // 7. compareTo(str) / compareToIgnoreCase(str)
        System.out.println(s.compareTo("I"));
        List<String> names = Arrays.asList("Sujon", "Ryan", "Rakib", "Aloha", "Alex", "Rupai");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(names);
        names.sort((a, b) -> a.length() - b.length() ); // negative = a is first, positive b is first
        System.out.println(names);
        names.sort((a, b) -> b.compareTo(a));
        System.out.println(names);
        // Given a string of array reverse the string list
        String[] arr = {"Apple", "Orange", "Banana", "Grape"};
        List<String> fruits = new ArrayList<>(Arrays.asList(arr));
        fruits.sort((a, b) -> b.compareTo(a));
        System.out.println(fruits);
        System.out.println(s.compareToIgnoreCase("I LOVE FACTORIO")); // 0 cause they match


        // 8. startsWith(str) / endsWith(str)
        System.out.println(s.startsWith("I"));
        System.out.println(s.endsWith("I"));
        System.out.println(s.endsWith("o"));

        // 9. matches(regex)
        System.out.println(s.matches("[a-zA-Z0-9 ]+"));

        // 10. toUpperCase() / toLowerCase()
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());

        // 11. trim() / strip()
        String s1 = " HELL WORLD ";
        System.out.println(s1.trim());
        String s2 = "\u2005Hello World\u2005";
        System.out.println(s2.strip());
        String[] arr2 = { "\u2005Hello World\u2005", "\u2005I love CS2\u2005"};
        List<String> list2 = new ArrayList<>();
        for(String n: arr2){
           list2.add(n.strip());
        }
        list2.sort((a, b) -> b.compareTo(a));
        System.out.println(list2);

        // 12. replace(old, new) / replaceAll(regex, new)
        System.out.println(s.replace("Factorio", "Cricket"));
        System.out.println(s.replaceAll("[oO]+", "t"));

        // 13. substring(from) / substring(from, to)
        System.out.println(s.substring(7));
        System.out.println(s.substring(0, 11));

        // 14. repeat(n)
        System.out.println(s.repeat(4));
        // print a given string 100 times without creating a for loop
        String s5 = "I don't like to repeat myself. ";
        int i = 0;
        while(i < s5.length()){
            System.out.println(s5.repeat(i));
            i++;
        }

        // 15. String.format(template, args)
        System.out.println(String.format("%.2f", 5.5556777));
        System.out.println(String.format("%s is %d", "age", 33));

        // 16. split(regex)
        String csv = "one,two,three,four";
        String[] csvFormatter = csv.split(",");
        System.out.println(Arrays.toString(csvFormatter));
        System.out.println(csvFormatter[0]);
        String[] experiment = {"ABC#TC", "CBD#TC", "BCD#TC", "ABC#TC", "ABC#TC"};
        String[] uniqueEx = new String[experiment.length];
        Set<String> result = new HashSet<>();
        for(int j = 0; j < experiment.length; j++){
            // [0] means just grab the first element of the split result.
            uniqueEx[j] = experiment[j].split("#")[0];
            if(!result.contains(uniqueEx[j])){
                result.add(uniqueEx[j]);
            }
        }
        System.out.println(Arrays.toString(uniqueEx));
        System.out.println(result);

        // 17. String.join(delimiter, elements)
        System.out.println(String.join(" | " , csvFormatter));
        // print array value with custom style
        System.out.println(String.join(" : ", uniqueEx));

        // 18. toCharArray()
        char[] charArray = s.toCharArray();
        System.out.println(Arrays.toString(charArray));

        // 19. String.valueOf(x) - use to turn any data type to string
        System.out.println(String.valueOf(55));
        System.out.println(String.valueOf('c'));

        // 20. Integer.parseInt(str) / Double.parseDouble(str)
        int parseIntFromString = Integer.parseInt("90");
        System.out.println(parseIntFromString);

        double parseDoubleFromString = Double.parseDouble("90.88");
        System.out.println(parseDoubleFromString);

        boolean parseBooleanFromString = Boolean.parseBoolean("true");
        System.out.println(parseBooleanFromString);
    }
}
