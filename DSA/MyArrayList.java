import java.util.Arrays;

public class MyArrayList {
    int[] data;
    int p;

    public MyArrayList() {
        data = new int[7];
        p = -1;
    }

    public MyArrayList(int initialCapacity) {
        data = new int[initialCapacity];
        p = -1;
    }

    private void ensureCapacity() {
        if (p + 1 == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    // Add method to add an element at the end
    public void add(int val) {
        ensureCapacity();
        data[++p] = val;
    }

    // Add method to add an element at a specific index
    public void add(int index, int val) {
        // Validate index
        if (index < 0 || index > p + 1) {
            throw new IndexOutOfBoundsException("at index: " + index + " for size: " + size());
        }
        // Ensure capacity
        ensureCapacity();

        // Shift elements to the right
        for (int i = p; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // Add the element
        data[index] = val;
        p++;
    }

    // Get the size of the list
    public int size() {
        return p + 1;
    }

    // Get the element at a specific index
    public int get(int index) {
        // Validate index
        if (index < 0 || index > p) {
            throw new IndexOutOfBoundsException("at index: " + index + " for size: " + size());
        }
        return data[index];
    }

    // Remove an element at a specific index
    public int remove(int index) {
        // Validate index
        if (index < 0 || index > p) {
            throw new IndexOutOfBoundsException("at index: " + index + " for size: " + size());
        }

        int remValue = data[index];

        // Shift elements to the left
        for (int i = index; i < p; i++) {
            data[i] = data[i + 1];
        }

        p--;
        return remValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= p; i++) {
            sb.append(data[i]);
            if (i < p) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}