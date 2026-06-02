package generics;

import java.util.Arrays;

public class GenericsAndHowItIsUsedInArrayList<E> {
    private Object[] element;
    private int size = 0;

    public GenericsAndHowItIsUsedInArrayList(){
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
        GenericsAndHowItIsUsedInArrayList<String> cr = new GenericsAndHowItIsUsedInArrayList<>();
        cr.add("Sujon");
        cr.add("Ryan");
        System.out.println(cr);

        GenericsAndHowItIsUsedInArrayList<Integer> in = new GenericsAndHowItIsUsedInArrayList<>();
        in.add(5);
        System.out.println(in);
    }
}
