# 1046. Last Stone Weight [solve here](https://leetcode.com/problems/last-stone-weight/)
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
