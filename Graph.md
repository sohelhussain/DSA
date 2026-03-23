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
                if(dfs(neighbor, adj, isVisited, recursiveStack)) return true;
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
# 207. Course Schedule [solve here](https://leetcode.com/problems/course-schedule/)
```
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[] isVisited = new boolean[numCourses];
        int[] inDegree = new int[numCourses];

        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int prerequi = prerequisite[1];
            adj.get(prerequi).add(course);
        }

        for(int i = 0; i < adj.size(); i++) {
            for(int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int frontVal = queue.poll();
            count++;
            for(int neighbor: adj.get(frontVal)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return count == numCourses;
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
            int wt = curr[1];
            
            if(wt > distance[node]) continue;
            
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
---
# Disjointsets data structure
```
public class Disjointsets {
    int[] rank, parent;

    public Disjointsets(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1]; // becuse we are using 1-based indexing that is why we have added one more element
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    void union(int u, int v) {
        int ultimateParent_U = parent[u];
        int ultimateParent_V = parent[v];
        if (rank[ultimateParent_U] < rank[ultimateParent_V]) { // chati rank ko badi rank me add karna
            parent[ultimateParent_U] = ultimateParent_V;
        }else if(rank[ultimateParent_U] > rank[ultimateParent_V]) {
            parent[ultimateParent_V] = ultimateParent_U; // bache ke upar parent ka naam likh do
        }else {
            parent[ultimateParent_V] = ultimateParent_U;
            rank[ultimateParent_U]++;
        }
    }

    int findParent(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = findParent(parent[u]);
    }
    public static void main(String[] args) {
        Disjointsets obj = new Disjointsets(7);
        obj.union(1, 2);
        obj.union(2, 3);
        obj.union(4, 5);
        obj.union(6, 7);
        obj.union(5, 7);
        if (obj.findParent(3) == obj.findParent(7)) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        obj.union(3, 7);
        if (obj.findParent(3) == obj.findParent(7)) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}

```
---
# kruskal's algorithm [solve here](https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1) [watch](https://youtu.be/JZBQLXgSGfs?si=tbQOgy6NFJXfKrWj) <img width="12" height="8" alt="image" src="https://github.com/user-attachments/assets/4755ba0c-f46a-4fe7-aa2c-34416d43eea9" />

- Initialize DSU (Disjoint Set Union).
- Sort all edges by weight (ascending).
- For each edge (u, v, w):
    - If find(u) ≠ find(v):
    - Add w to the total sum.
    - Union(u, v).

```Sort edges → pick smallest → if different sets → add + union.```
```
class Disjointsets {
    int[] rank, parent;

    public Disjointsets(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1]; // 1-based indexing
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int findParent(int u) {
        if (u == parent[u]) return u;
        return parent[u] = findParent(parent[u]); // path compression
    }

    void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return; // already in same set

        if (rank[pu] < rank[pv]) {  // chati rank ko badi rank me add karna
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) { // u greter u assing
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

// Kruskal’s Algorithm
class Solution {

    static class Pair implements Comparable<Pair> {
        int u, v, wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Pair that) {
            return this.wt - that.wt; // sort by weight
        }
    }

    static int kruskalsMST(int V, int[][] edges) {
        // Create list of edges
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            pq.offer(new Pair(u, v, wt));
        }

        Disjointsets obj = new Disjointsets(V);
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int u = temp.u;
            int v = temp.v;
            int wt = temp.wt;

            if (obj.findParent(u) != obj.findParent(v)) {
                sum += wt;
                obj.union(u, v);
            }
        }
        return sum;
    }
}
```
---
# 733. Flood Fill [solve here](https://leetcode.com/problems/flood-fill/)
```
class Solution {
    private void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if(image[sr][sc] != oldColor) return;

        image[sr][sc] = color;

        dfs(image, sr - 1, sc, color, oldColor);
        dfs(image, sr + 1, sc, color, oldColor);
        dfs(image, sr, sc - 1, color, oldColor);
        dfs(image, sr, sc + 1, color, oldColor);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        dfs(image, sr, sc, color, oldColor);
        return image;
    }
}
```
---
# 133. Clone Graph [solve here](https://leetcode.com/problems/clone-graph/)
```
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;


        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();


        map.put(node, new Node(node.val, new ArrayList<>()));
        queue.offer(node);


        while (!queue.isEmpty()) {
            Node frontNode = queue.poll();

            for (Node neighbor : frontNode.neighbors) {

                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }

                map.get(frontNode).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
```
---
# 547. Number of Provinces [solve here](https://leetcode.com/problems/number-of-provinces/)
```
class Solution {
    public class Disjointsets {
        int[] rank, parent;

        public Disjointsets(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1]; 
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int u, int v) {
            int ultimateParent_U = parent[u];
            int ultimateParent_V = parent[v];
            if (rank[ultimateParent_U] < rank[ultimateParent_V]) {
                parent[ultimateParent_U] = ultimateParent_V;
            } else if (rank[ultimateParent_U] > rank[ultimateParent_V]) {
                parent[ultimateParent_V] = ultimateParent_U;
            } else {
                parent[ultimateParent_V] = ultimateParent_U;
                rank[ultimateParent_U]++;
            }
        }

        int findParent(int u) {
            if (u == parent[u]) {
                return u;
            }
            return parent[u] = findParent(parent[u]);
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = n;
        Disjointsets obj = new Disjointsets(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && obj.findParent(i) != obj.findParent(j)) {
                    obj.union(i, j);
                    count--;
                }
            }
        }
        return count;
    }
}

```
---
#  Is Graph Bipartite? [solve here](https://leetcode.com/problems/is-graph-bipartite/) 
![IMG_0205](https://github.com/user-attachments/assets/9da8bccd-87b9-48ed-bf7c-de4e10cbe4ab)
### dfs approach
```
class Solution {
    private boolean dfs(int node, int color, int[] colorArr, int[][] graph) {
        colorArr[node] = color;

        for(int neighbor: graph[node]) {
            if(colorArr[neighbor] == -1) {
                if(!dfs(neighbor, 1 - color, colorArr, graph)) return false;
            }else if(colorArr[neighbor] == color) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] colorArr = new int[graph.length];
        Arrays.fill(colorArr, -1);

        for(int i = 0; i < graph.length; i++) {

            if(colorArr[i] == -1) {
                if(!dfs(i, 0, colorArr, graph)) return false;
            }
        }
        return true;
    }
}
```

### bfs approch

```
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colorArr = new int[graph.length];
        Arrays.fill(colorArr, -1);

        for(int i = 0; i < graph.length; i++) {

            if(colorArr[i] != -1) continue;


            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colorArr[i] = 0;


            while(!queue.isEmpty()) {
                int node = queue.poll();

                for(int neighbor: graph[node]) {
                    if(colorArr[neighbor] == -1) {
                        colorArr[neighbor] = 1 - colorArr[node];
                        queue.offer(neighbor); 
                    }else if(colorArr[neighbor] == colorArr[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
```
---
994. Rotting Oranges [solve here](https://leetcode.com/problems/rotting-oranges/)

```
class Solution {
    class Pair {
        int r, c, time;

        Pair(int _r, int _c, int _time) {
            this.r = _r;
            this.c = _c;
            this.time = _time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                }

                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            time = Math.max(time, cur.time);

            for(int i = 0; i < 4; i++) {
                int nr = cur.r + drow[i];
                int nc = cur.c + dcol[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new Pair(nr, nc, cur.time + 1));
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
```
