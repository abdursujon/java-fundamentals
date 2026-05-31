package generics;

import java.util.Arrays;

public class CustomArrayList<E> {
    private Object[] element;
    private int size = 0;

    public CustomArrayList(){
        element = new Object[10];
    }

    private void growArray(){
        int newCapacity = element.length * 2;
        element = Arrays.copyOf(element, newCapacity);
    }

    public int size(){
        return size;
    }

    public void add(E item){
        if(size == element.length){
            growArray();
        }
        element[size] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) element[index];
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(element, size));
    }

    public static void main(String[] args){
        CustomArrayList<String> cr = new CustomArrayList<>();
        cr.add("Sujon");
        cr.add("Ryan");
        System.out.println(cr);

        CustomArrayList<Integer> in = new CustomArrayList<>();
        in.add(5);
        System.out.println(in);
    }
}
