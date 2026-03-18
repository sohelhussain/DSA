# 1. BFS
### identification

| Pattern Category            | Keywords / Clues                                      | What to Think        |
|----------------------------|------------------------------------------------------|----------------------|
| Shortest Path              | - minimum steps <br> - minimum moves <br> - shortest distance | Use BFS        |
| Level-by-Level Expansion   | - spread <br> - infection <br> - waves <br> - time passes in steps | BFS (levels) <br> - Each level = 1 unit of time / distance <br> - Rotten Oranges → minutes <br> - Map of Highest Peak → height levels |
| Multiple Starting Points   | - all sources <br> - nearest X <br> - distance from nearest | Multi-source BFS |
| Grid + Directions          | - up, down, left, right <br> - matrix traversal       | BFS/DFS on grid      |

### Question by pattern
  
[bfs](https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/0)
1. Multi-source BFS\
[01 Matrix](https://leetcode.com/problems/01-matrix/)\
[Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)\
[Map of Highest Peak](https://leetcode.com/problems/map-of-highest-peak/)

2. Single-source BFS
- Shortest path in grid
- Binary tree level order

3. BFS with state
- Word Ladder
- Knight moves
---

# 2. DFS
[dfs](https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1)\
[Undirected Graph Cycle](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1) need parent\
[Directed Graph Cycle](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1) need pathVisited\
[All Paths From Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/)\
[Number of Distinct Islands](https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1)
---


# 3. Topological sort Using BFS (Kahn's Algorithm)
### how to identify
- “dependencies”
- “order of execution”
- “can finish all tasks”
- “build order”\
👉 Think: Topological Sort (Kahn’s Algo)\

[Topological sort Using BFS (Kahn's Algorithm)](https://practice.geeksforgeeks.org/problems/topological-sort/1)\
[Course Schedule](https://leetcode.com/problems/course-schedule/)\
[Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)\
[Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/)
- Nodes that are not part of any cycle
- Reverse graph + Kahn’s Algo

[Minimum Time to Complete All Tasks](https://leetcode.com/problems/minimum-time-to-complete-all-tasks/)\
- Modify Kahn:
- Track max time to reach each node

Build a Matrix With Conditions(https://leetcode.com/problems/build-a-matrix-with-conditions/)
Longest Path in a Directed Acyclic Graph(https://www.geeksforgeeks.org/problems/longest-path-in-a-directed-acyclic-graph/1)
