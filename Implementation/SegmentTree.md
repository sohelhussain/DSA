# implementaion
```
package SegmentTree;

import java.util.Arrays;

public class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int[] arr) {          
        n = arr.length;
        tree = new int[4 * n];        
        buildTree(arr, 0, 0, n - 1);
    }

    void buildTree(int[] arr, int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildTree(arr, 2 * i + 1, start, mid);
        buildTree(arr, 2 * i + 2, mid + 1, end);   
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4};
        SegmentTree obj = new SegmentTree(arr);
        System.out.println(Arrays.toString(obj.tree));
    }
}

```
