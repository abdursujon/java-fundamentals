import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Iterator methods
 * 1. iterator()
 * 2. hasNext()
 * 3. next()
 * 4. remove()
 *
 * ListIterator methods (bidirectional)
 * 5. listIterator()
 * 6. hasNext()
 * 7. next()
 * 8. hasPrevious()
 * 9. previous()
 * 10. add()
 * 11. set()
 * 12. remove()
 * 13. nextIndex()
 * 14. previousIndex()
 */
public class Iterators {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        // 1. iterator(), 2. hasNext(), 3. next()
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        // 4. remove()
        iter = list.iterator(); // in previous while we iterated through all list items and removed items from iterator, so we must reassign
        while(iter.hasNext()){
            int val = iter.next();
            if(val == 3){
                iter.remove();
            }
        }
        System.out.println(list);

        // 5. listIterator(), 6. hasNext(), 7. next()
        ListIterator<Integer> listIter = list.listIterator();
        while(listIter.hasNext()){
            System.out.print(listIter.next() + " ");
        }
        System.out.println();

        // 8. hasPrevious(), 9. previous()
        while(listIter.hasPrevious()){
            System.out.print(listIter.previous() + " ");
        }
        System.out.println();

        // 10. add()
        listIter = list.listIterator();
        while(listIter.hasNext()){
            int val = listIter.next();
            if(val == 7){
                listIter.add(88);
            }
        }
        System.out.println(list);

        // 11. set()
        listIter = list.listIterator();
        while(listIter.hasNext()){
            int val = listIter.next();
            if(val == 5){
                listIter.set(89);
            }
        }
        System.out.println(list);

        // 12. remove()
        listIter = list.listIterator();
        while(listIter.hasNext()){
            int val = listIter.next();
            if(val == 88){
                listIter.remove();
            }
        }
        System.out.println(list);

        // 13. nextIndex()
        listIter = list.listIterator();
        while(listIter.hasNext()){
            System.out.print("Index: " + listIter.nextIndex() + ", Item: " + listIter.next() + "\n");
        }
        System.out.println();

        // 14. previousIndex()
        while(listIter.hasPrevious()){
            System.out.print("Index in reverse order: " + listIter.previousIndex() + ", Item: " + listIter.previous() + "\n");
        }
    }
}
