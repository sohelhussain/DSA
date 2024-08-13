package DSA;

import java.util.ArrayList;
import java.util.List;

public class day7 {
    public static void main(String[] args) {
        // List<Integer> list = new ArrayList<>();
        MyArrayList list = new MyArrayList();
        list.add(54);
        list.add(74);
        list.add(96);
        System.out.println(list);
        System.out.println(list.size());
        list.add(1, 24);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());
    }
}
