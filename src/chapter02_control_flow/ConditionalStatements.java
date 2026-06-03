package ch5_control_flow;

/**
 * 1. if/else
 * 2. switch
 * 3. ternary
 */
public class ConditionalStatements {

    public static void compareNumbers(int a, int b) {
        if (a > b) {
            System.out.println("a is greater then b");
        } else if (a == b) {
            System.out.println("a is equal to b");
        } else {
            System.out.println("a is lesss than b");
        }
    }

    public static void whatDay(int dayNum) {
        int day[] = {0, 1, 2, 3, 4, 5, 6};

        if (dayNum >= 0 && dayNum < 7) {
            switch (day[dayNum]) {
                case 0:
                    System.out.println("Monday");
                    break;
                case 1:
                    System.out.println("Tuesday");
                    break;
                case 2:
                    System.out.println("Wednesday");
                    break;
                case 3:
                    System.out.println("Thursday");
                    break;
                case 4:
                    System.out.println("Friday");
                    break;
                case 5:
                    System.out.println("Saturday");
                    break;
                case 6:
                    System.out.println("Sunday");
                    break;
                default:
                    System.out.println("Invalid Day");
                    break;
            }
        } else {
            System.out.println("Invalid Day");
        }
    }

    public static void findMin(int n1, int n2) {
        int min = (n1 < n2) ? n1 : n2;
        System.out.println(min);
    }

    public static void main(String[] args) {
        compareNumbers(44, 56);
        whatDay(2);
        whatDay(33);
        findMin(33, 2);
    }
}