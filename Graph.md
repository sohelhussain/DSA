# 1. BFS of graph [solve here](https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/0)
![IMG_0130](https://github.com/user-attachments/assets/73e9fd5e-bec7-4430-9cff-161cd84a217c)
```
class Solution {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[adj.size()];
        
        // Start from node 0
        queue.offer(0);
        isVisited[0] = true; 
        
        while (!queue.isEmpty()) {
            int frontNodeVal = queue.poll();
            list.add(frontNodeVal);
            
            for (int i = 0; i < adj.get(frontNodeVal).size(); i++) {
                int neighbor = adj.get(frontNodeVal).get(i);
                if (!isVisited[neighbor]) {
                    queue.offer(neighbor);
                    isVisited[neighbor] = true;
                }
            }
        }
        return list;
    }
}

```
---
# 2. DFS of Graph [solve here](https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1)
![IMG_0129](https://github.com/user-attachments/assets/f27dd44f-c4bb-4b65-a94a-9e4ca9c36854)
```
class Solution {
    void solve(int node, ArrayList<ArrayList<Integer>> adj, boolean[] isVis, ArrayList<Integer> list) {
        isVis[node] = true;
        list.add(node); 

        for (int neighbor : adj.get(node)) {
            if (!isVis[neighbor]) {
                solve(neighbor, adj, isVis, list); 
            }
        }
    }


    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isVis = new boolean[adj.size()];
        solve(0, adj, isVis, list);
        return list;
    }
}
```
---
# 3. Undirected Graph Cycle [solve here](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)

![IMG_0125](https://github.com/user-attachments/assets/161a7c83-c4f4-4ab1-b9e5-a748c622caf2)

```
class Solution {
    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] isVis, int parent) {
        isVis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!isVis[neighbor]) {
                if (dfs(neighbor, adj, isVis, node)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }
        
        boolean[] isVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVis[i]) {
                if (dfs(i, adj, isVis, -1)) return true;
            }
        }

        return false;
    }
}

```
# 4. Directed Graph Cycle [solve here](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)

![IMG_0126](https://github.com/user-attachments/assets/f0dafcb9-fd82-40d5-a5a9-ec1cd0ca3682)

```
class Solution {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, boolean[] recursiveStack) {
        isVisited[node] = true;
        recursiveStack[node] = true;
        
        for(int neighbor: adj.get(node)) {
            if(!isVisited[neighbor]) {
                if(dfs(neighbor, adj, isVisited, recursiveStack)) return true;;
            }else if(recursiveStack[neighbor]) {
                return true;
            }
        }
        
        recursiveStack[node] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        boolean[] isVisited = new boolean[V];
        boolean[] recursiveStack = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(dfs(i, adj, isVisited, recursiveStack)) return true;
        }
        return false;
    }
}
```
---

# 5. Topological sort [solve here](https://practice.geeksforgeeks.org/problems/topological-sort/1)

![IMG_0127](https://github.com/user-attachments/assets/c93cbb94-b080-45bb-b90a-1bd94af7a43b)
```
class Solution {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, Stack<Integer> stack) {
        isVisited[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (!isVisited[neighbor]) {
                dfs(neighbor, adj, isVisited, stack);
            }
        }
        stack.push(node);
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); 
        }

        boolean[] isVisited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                dfs(i, adj, isVisited, stack);
            }
        }

        
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }
}
```
---
# 6. Topological sort Using BFS (Kahn's Algorithm) [solve here](https://practice.geeksforgeeks.org/problems/topological-sort/1)
```
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); 
        }

        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }
    
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            list.add(cur);

            for (int neighbor : adj.get(cur)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return list;
    }
}

```
---

# 797. All Paths From Source to Target. [solve here](https://leetcode.com/problems/all-paths-from-source-to-target/)
#### notise this line in question ``` find all possible paths from node 0 to node n - 1 ```
#### that why we using this condition ``` if(node == graph.length - 1) ```

```
class Solution {
    private void dfs(int node, int[][] graph, List<List<Integer>> list, List<Integer> cur) {

        cur.add(node);
        if(node == graph.length - 1) {
            list.add(new ArrayList<>(cur));
        }else {
            for(int neighbor: graph[node]) {
                dfs(neighbor, graph, list, cur);
            }
        }
        
        cur.remove(cur.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        dfs(0, graph, list, cur);
        return list;
    }
}
```
---
# Dijkstra Algorithm [solve here](https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1)

### Algorithm (Easy Step-by-Step Explanation)

1. We create a distance[] array and fill it with infinity (Integer.MAX_VALUE) because at the start, we don’t know any shortest paths.

2. Then we set the source node’s distance = 0, because the distance from itself is zero.

3. We push the source (node, distance) → (2, 0) into a min-heap (priority queue) which always gives us the node with the smallest distance.

4. Now we start our loop.

    a. We poll (remove) the top of the min-heap → that’s the node with the smallest distance.

    b. First time, it’s (2, 0).

5. From node 2, we check where we can go:

    a. We can go to node 1 with weight 3 → total distance = 0 + 3 = 3.

      I. This is smaller than infinity → update distance[1] = 3 and push (1, 3) into heap.

    b. We can also go to node 0 with weight 6 → total distance = 0 + 6 = 6.

     II. Update distance[0] = 6 and push (0, 6) into heap.

    c. Now heap = [(1, 3), (0, 6)].

6. Next, we poll again → (1, 3) comes out (smallest distance).

    a. From node 1, we can go to:

    b. node 0 with weight 1.

      I. Current distance to node 1 = 3, so 3 + 1 = 4.

     II. Compare with old distance of node 0 (6). 4 is smaller → update distance[0] = 4 and push (0, 4) in heap.

    c. node 2 → already visited with smaller distance, skip.

    d. Now heap = [(0, 4), (0, 6)].

7. Next, we poll (0, 4) → from node 0:

    a. Neighbors are 1 and 2, but both already have smaller distances, so skip them.

8. The heap still has (0, 6) but it’s old (distance already smaller = 4), so skip it too.

9. Now the heap is empty, algorithm ends.

10. Final distance[] = [4, 3, 0].

```
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
            
            if(d > distance[node]) continue;
            
            for(int[] neighbor: graph.get(node)) {
                int nextDestination = neighbor[0];
                int weight = neighbor[1];
                
                if(distance[node] + weight < distance[nextDestination]) {
                    distance[nextDestination] = distance[node] + weight;
                    pq.offer(new int[]{nextDestination, distance[nextDestination]});
                }
            }
        }
        return distance;
    }
}
```
---
# Bellman-Ford algorithm [solve here](https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1)
1. We first make a distance array of size V and fill it with a big number (1e8) — means infinite.

2. Set the distance of the source node as 0 because we start from there.

3. Now, we run a loop V times (number of vertices).

4. Inside this loop, we check every edge (u, v, wt) — means from u to v with weight wt.

5. If we already know the shortest distance to u and
going from u to v gives a smaller distance than current dist[v],
then we update dist[v] = dist[u] + wt.

6. On the Vth time, if any distance is still changing, that means there is a negative weight cycle,
so we return [-1].

7. After finishing all loops, our dist[] array has the shortest distance from source to all nodes.

8. Finally, return dist.
```
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
         int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        // Relaxation of all the edges V times, not (V - 1) as we  
        // need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    
                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V - 1)
                        return new int[]{-1};
                    
                    // Update shortest distance to node v
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }
}

```
---
# Minimum Spanning Tree [solve here](https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1)
```
class Solution {
    static class Pair implements Comparable<Pair> {
        int v, wt;
        
        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
        
        public int compareTo(Pair that) {
            return this.wt - that.wt;
        }
    }

    public int spanningTree(int V, int[][] edges) {
        // Build adjacency list
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            graph.get(u).add(new int[]{v, wt});
            graph.get(v).add(new int[]{u, wt});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[V];
        pq.offer(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int v = temp.v;
            int wt = temp.wt;

            if (isVisited[v]) continue;

            isVisited[v] = true;
            sum += wt;

            for (int[] neighbor : graph.get(v)) {
                int adjNode = neighbor[0];
                int adjWt = neighbor[1];
                if (!isVisited[adjNode]) {
                    pq.offer(new Pair(adjNode, adjWt));
                }
            }
        }

        return sum;
    }
}

```
