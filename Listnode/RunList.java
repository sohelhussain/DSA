import java.util.*;

public class RunList {
    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        // MyList list = new MyList();
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.addFirst(1);
        System.out.println(list);
        list.removeFirst();
    }
}
