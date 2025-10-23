# 1. BFS of graph [solve here](https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/0)
![bfs](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700217/Web/Other/blobid0_1728648582.jpg)
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
