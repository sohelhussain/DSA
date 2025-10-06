package heap;

public class BinaryHeap {
    int size = 0;
    int[] nums = new int[100];

    void insertion(int val) {
        size += 1;
        nums[size] = val;
        int index = size;
        while (index > 1) {
            int parent = index / 2;    // log(n)
            if (nums[parent] < nums[size]) {
                swap(nums, index, parent);
                index = parent;
            }else return;
        }
    }

    void deletion() {
        nums[1] = nums[size];
        size--;
        int index = 1;
        while (index < size) {
            int left = nums[2 * index];
            int right = nums[2 * index + 1];
            int larger = left > right ? left : right;
            if(nums[larger] > nums[index]) {
                swap(nums, larger, index);
            }else return;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void print() {
        for(int i = 1; i <= size; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        BinaryHeap obj = new BinaryHeap();
        obj.insertion(30);
        obj.insertion(54);
        obj.insertion(20);
        obj.insertion(50);
        obj.insertion(51);
        obj.print();
        obj.deletion();
        System.out.println();
        obj.print();
    }
}
