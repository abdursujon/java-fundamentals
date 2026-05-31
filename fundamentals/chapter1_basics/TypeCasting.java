public class TypeCasting {
    PrimitiveDataTypes prim = new PrimitiveDataTypes();
    float f = (float) prim.d;
    long l = (long) prim.f;
    int i = (int) prim.l;
    short s = (short) prim.i;
    byte b = (byte) prim.s;
    char c = 'a';
    int i2 = c; // implicit cast -> 97
    char c2 = (char) 97; // explicit cast -> 'a'

    public static void main (String[] args){
        TypeCasting t = new TypeCasting();
        System.out.println(t.f + "\n" + t.l + "\n" + t.i + "\n" + t.s + "\n" + t.b + "\n" + t.c + "\n" + t.i2 + "\n" + t.c2);
    }
}