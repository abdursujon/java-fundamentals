public class NullPointerExceptions {
    public static void main(String[] args) {
        String str = null;
        if (str != null) {
            System.out.println(str.length()); // NullPointerException
        }
        System.out.println(str.length());
    }
}
