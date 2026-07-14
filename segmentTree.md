


---
```
  s e  <- fixed point on normal arr
1,2,3,4
10,3,7,1,2,3,4 
l      m     r   <- moving pointer
```
# [pointUpdate & rangeSum, solve here](https://www.geeksforgeeks.org/problems/range-sum-queries2353/1)

```
class Sol {
    // arr : given array
    // n : size of arr
    // index : need to update
    // new_val : given value to which we need to update index
    // st : constructed segment-tree

    // Function to update a value in input array and segment tree.
    static void updateValue(int arr[], long st[], int n, int index, int val) {
        // Your code here
        pointUpdateValue(0, 0, n - 1, index, val, st, arr);
    }
    
    static void pointUpdateValue(int i, int left, int right, int idx, int val, long[] st, int[] arr) {
        if(left == right) {
            st[i] = val;
            return;
        }
        
        int mid = left + (right - left) / 2;
        
        if(idx <= mid) {
            pointUpdateValue(2 * i + 1, left, mid, idx, val, st, arr);
        }else {
            pointUpdateValue(2 * i + 2, mid + 1, right, idx, val, st, arr);
        }
        
        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }

    // Function to return sum of elements in range from index qs (query start)
    // to qe (query end).
    public static long getSum(long st[], int n, int l, int r) {
        // Your code here
        return rangeSumQuerie(0, 0, n - 1, l, r, st);
    }
    
    public static long rangeSumQuerie(int i, int left, int right, int start, int end, long[] st) {
        if(right < start || end < left) return 0;
        
        if(start <= left && right <= end) {
            return st[i];
        }
        int mid = left + (right - left) / 2;
        
        long l = rangeSumQuerie(2 * i + 1, left, mid, start, end, st);
        long r = rangeSumQuerie(2 * i + 2, mid + 1, right, start, end, st);
        return st[i] = l + r;
    }
}
```
