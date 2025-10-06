# Insertion Operation
1. Add the new element at the end of the heap (the next empty index).
2. Compare the new element with its parent.
3. Parent index = index / 2
4. If the new element is greater than its parent, swap them.
5. Repeat step 2 and 3 until the element is smaller than its parent or it becomes the root.
6. Heap property is now maintained.
```
Insert 54
Initial: [30]
Add 54 at end → [30, 54]
54 > 30 → swap → [54, 30]
```

# Deletion Operation
1. Replace the root with the last element in the heap.
2. Reduce heap size by 1.
3. Compare the new root with its two children.
4. If one of the children is larger than the root, swap with the larger child.
5. Repeat step 3 and 4 until the heap property is satisfied (no child is greater).

```
Insert 54
Initial: [30]
Add 54 at end → [30, 54]
54 > 30 → swap → [54, 30]
```

```
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
            if (nums[parent] < nums[index]) {
                swap(nums, index, parent);
                index = parent;
            }else return;
        }
    }

void deletion() {
    nums[1] = nums[size];
    size--;
    int index = 1;
    while (index * 2 <= size) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int larger = left;
        if (right <= size && nums[right] > nums[left]) {
            larger = right;
        }
        if (nums[larger] > nums[index]) {
            swap(nums, larger, index);
            index = larger;
        } else return;
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
    ```
}
