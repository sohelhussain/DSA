package DSA;

import static java.lang.StringTemplate.STR;

@SuppressWarnings("unused")
public class MyArrayList {
    private int data[];
    private int last = 0;

    public MyArrayList() {
        data = new int[10];
    }

    public MyArrayList(int initialCapacity) {
        data = new int[initialCapacity];
    }

    public int size() {
        return last;
    }

    public void add(int element) {
        ensureCapacity();

        data[last++] = element;
    }

    private void ensureCapacity() {
        if (last == data.length) {
            int temp[] = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    public void add(int index, int element) {
        if(index < 0 || index > last)
            throw new IndexOutOfBoundsException(STR."\{index} out of bounds for \{last}");
        ensureCapacity();
        for (int i = last; i > index ; i--) {
            data[i] = data[i-1];
        }
        data[index] = element;
        last++;
    }

    public String toString() {
        //System.out.println(Arrays.toString(data));
        if (last == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < last; i++) {
            sb.append(STR."\{data[i]}, ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb + "]";

    }
}
