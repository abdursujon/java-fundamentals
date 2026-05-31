public enum Enums{
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}

enum Month {
    January, February, March, April, May, June,
    July, August, September, October, November, December
}

class TestEnums{

    public static String greetings(){

        Enums[] days = Enums.values();
        for (Enums day : days) {
            if (day == Enums.Monday) {
                return "It is Monday, I know time to go back to paid job :(";
            }
        }
        return "Have a good day";
    }

    public static void main(String [] args){
        Enums e = Enums.Thursday;
        System.out.println(e);

        // Access all enum value at once
        for(Enums en: Enums.values()){
            System.out.println(en);
        }

        System.out.println(greetings());

        // 1. values()
        Month[] months = Month.values();
        for(Month m: months){
            System.out.println(m);
        }

        // 2. valueOf("String") - Converts a string to the matching enum constant.
        Month m = Month.valueOf("January");
        System.out.println(m);

        // 3. name()
        System.out.println(Month.February.name());

        // 4. ordinal() returns index
        System.out.println(Month.December.ordinal());

        // 5. compareTo()
        System.out.println(Month.April.compareTo(Month.October));

        // 6. toString()
        System.out.println(Month.September.toString());

        // 7. getDeclaringClass()
        System.out.println(Month.June.getDeclaringClass());

        // 8. equals()
        System.out.println(Enums.Monday.equals(Enums.Monday));
        System.out.println(Month.January.equals(Enums.Monday));
    }
}