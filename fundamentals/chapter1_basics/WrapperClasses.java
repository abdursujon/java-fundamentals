/**
 * Wrapper Classes - object representation of primitive types
 * Each wrapper class provides utility methods for its primitive type
 *
 * Integer   -> int
 * Long      -> long
 * Double    -> double
 * Boolean   -> boolean
 * Character -> char
 * Float     -> float
 * Byte      -> byte
 * Short     -> short
 */
public class WrapperClasses {

    public static void main(String[] args) {

        System.out.println("--- Byte ---");
        System.out.println(Byte.parseByte("127"));
        System.out.println(Byte.valueOf((byte) 127));
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.compare((byte) 10, (byte) 5));
        System.out.println(Byte.toString((byte) 127));
        System.out.println(Byte.toUnsignedInt((byte) -1));
        System.out.println(Byte.toUnsignedLong((byte) -1));

        System.out.println("--- Short ---");
        System.out.println(Short.parseShort("32767"));
        System.out.println(Short.valueOf((short) 32767));
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.compare((short) 10, (short) 5));
        System.out.println(Short.toString((short) 32767));
        System.out.println(Short.toUnsignedInt((short) -1));
        System.out.println(Short.reverseBytes((short) 256));

        System.out.println("--- Integer ---");
        System.out.println(Integer.parseInt("42"));
        System.out.println(Integer.valueOf(42));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toHexString(255));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // -1 if neg, 1 if pos, 0 if equal
        System.out.println(Integer.compare(5, 10));
        System.out.println(Integer.sum(5, 10));

        System.out.println("--- Float ---");
        System.out.println(Float.parseFloat("3.14"));
        System.out.println(Float.valueOf(3.14f));
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.isNaN(Float.NaN));
        System.out.println(Float.isInfinite(1.0f / 0.0f));
        System.out.println(Float.compare(3.14f, 2.71f));
        System.out.println(Float.sum(3.14f, 2.71f));

        System.out.println("--- Double ---");
        System.out.println(Double.parseDouble("3.14"));
        System.out.println(Double.valueOf(3.14));
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.isNaN(Double.NaN));
        System.out.println(Double.isInfinite(1.0 / 0.0));
        System.out.println(Double.compare(3.14, 2.71));
        System.out.println(Double.sum(3.14, 2.71));

        System.out.println("--- Long ---");
        System.out.println(Long.parseLong("123456789"));
        System.out.println(Long.valueOf(123456789L));
        System.out.println(Long.toBinaryString(10L));
        System.out.println(Long.toHexString(255L));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.compare(5L, 10L));
        System.out.println(Long.sum(5L, 10L));

        System.out.println("--- Boolean ---");
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Boolean.parseBoolean("false"));
        System.out.println(Boolean.valueOf(true));
        System.out.println(Boolean.toString(true));
        // true = 1 && false = 0 there for 1 - 0 = 1
        System.out.println(Boolean.compare(true, false));
        System.out.println(Boolean.logicalAnd(true, false));
        System.out.println(Boolean.logicalOr(true, false));
        System.out.println(Boolean.logicalXor(true, false));

        System.out.println("--- Character ---");
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isDigit('5'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('A'));
        System.out.println(Character.getNumericValue('D'));
        System.out.println(Character.getNumericValue('9'));
        System.out.println(Character.isLetterOrDigit('a'));
    }
}