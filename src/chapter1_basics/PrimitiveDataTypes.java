public class PrimitiveDataTypes {
    public byte b = 55;
    public short s = 5555;
    public int i = 555555555;
    public float f = 55555555.55f;
    public long l = 5555555555555555555L;
    public double d = 55555555555555555555555555555555d;
    public char c = 'a';
    public boolean bool = true;

    public static void main(String[] args){
        PrimitiveDataTypes prim = new PrimitiveDataTypes();
        System.out.println(prim.b + "\n" + prim.s + "\n" + prim.i + "\n" + prim.l + "\n" + prim.f + "\n" + prim.d + "\n" + prim.c + "\n" + prim.bool);
    }
}