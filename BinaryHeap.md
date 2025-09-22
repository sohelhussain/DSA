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
