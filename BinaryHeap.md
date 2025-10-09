1. heap is a complite binary tree excapt last lelvel.
```
        5
       / \
      2   6  ✔️ 
    /   \
    7    4
```
3. every time insert a node from left side
```
        5
       / \
      2   6       ❌ first we fill left side then fill right
       \    \
        4    7
```
Max Heap → Parent ≥ Children\
Min Heap → Parent ≤ Children
```
               50
             /    \
          30        40   max heap
         /  \      /  \
       10    5   20    30
```
---
# 1046. Last Stone Weight? [solve here](https://leetcode.com/problems/last-stone-weight/)
- First we create a max heap.
- Take two elements and subtract them. After this, we can put them again and also run the loop until we are left with only one element in the array.
```
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones) pq.offer(stone);

        while(pq.size() != 1) {
            int y = pq.poll();
            int x = pq.poll();

            int diff = Math.abs(y - x);
            pq.offer(diff);
        }
        return pq.poll();
    }
}
```
---
# 215. Kth Largest Element in an Array? [solve here](https://leetcode.com/problems/kth-largest-element-in-an-array/)
```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums) pq.offer(num);

        while(k-- > 0) {
            int front = pq.poll();
            if(k == 0) {
                return front;
            }
        }
        return -1;
    }
}
```
```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) pq.poll();
        }

        return pq.poll();
    }
}
```
---
# 703. Kth Largest Element in a Stream. [solve here](https://leetcode.com/problems/kth-largest-element-in-a-stream/)
- First insert val into pq.
- Then remove the element until the pq size is not equal to k.
- Return the top element.
```
class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    public KthLargest(int k, int[] nums) {
        for(int num: nums) pq.offer(num);
        this.k = k;
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() != k) {
            pq.poll();
        }
        return pq.peek();
    }
}
```
---
# 347. Top K Frequent Elements. [solve here](https://leetcode.com/problems/top-k-frequent-elements/)
we can also write this part.
```
     public int compareTo(Pair that) {
            return this.freq - that.freq; // min-heap based on frequency
        }
```

```
class Solution {
    class Pair implements Comparable<Pair> {
        int ele, freq;
        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }

        public int compareTo(Pair that) {
            return this.freq > that.freq ? 1 : -1;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        for(int key: map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
            if(pq.size() > k) pq.poll();
        }

        int[] temp = new int[k];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = pq.poll().ele;
        }
        return temp;
    }
}
```
