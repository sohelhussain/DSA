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
54, 51, 52, 50, 30, 20

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
51, 52, 50, 30, 20
```
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
        obj.insertion(52);
        obj.insertion(20);
        obj.insertion(50);
        obj.insertion(51);
        obj.print();
        obj.deletion();
        System.out.println();
        obj.print();
    }
}
```
---
# Heapify algo
##### that convert invalid heap to valid heap

#### Goal: Ensure every parent node is greater than its children, forming a valid max heap.

1. Start from the last non-leaf node (at index n/2) and move upward to the root. becuse after n/2(last childern) part is valid.
2. For each node, find its left and right child using left = 2*i and right = 2*i + 1.
3. Compare the parent with its children to find the largest value.
4. If any child is larger than the parent, swap them.
5. Recursively apply heapify on the swapped child node to maintain the heap property in the sub-tree.
6. Repeat until all nodes satisfy the max-heap condition.

# HeapSort Operation

#### Goal: Sort the array in ascending order by repeatedly removing the maximum element from the heap.

1. Swap the first element (root) with the last element in the heap.
2. Reduce the heap size by 1 (ignore the sorted part).
3. Call heapify() on the root to restore the heap property.
4. Repeat steps 1–3 until all elements are sorted.
5. The array is now sorted in ascending order.

```
package heap;

import java.util.Arrays;

public class BinaryHeap {

    void heapify(int[] nums, int n, int i) {
        int larger = i;
        int left = 2 * i, right = 2 * i + 1;
        if(left <= n && nums[left] > nums[larger]) {
            larger = left;
        }
        if(right <= n && nums[right] > nums[larger]) {
            larger = right;
        }
        if (larger != i) {
            swap(nums, i, larger);
            heapify(nums, n, larger);
        }
    }

   void heapSort(int[] nums, int n) {
        int size = n;
        while (size > 0) {
            swap(nums, size, 1);
            size--;
            heapify(nums, size, 1);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        BinaryHeap obj = new BinaryHeap();

        int[] nums = {-1, 12, 50, 60, 30, 10, 41};
        int n = 6; // this is size of array and we not count 0 index
        for(int i = n/2; i > 0; i--) { // run loop 60 to 12
            obj.heapify(nums, n, i);
        }
        System.out.println(Arrays.toString(nums));
        obj.heapSort(nums, n);
        System.out.println(Arrays.toString(nums));
    }
}

```
