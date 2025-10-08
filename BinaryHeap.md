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
