# 1. BFS of graph [solve here](https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/0)
```
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[adj.size()];
        
        // Start from node 0
        queue.offer(0);
        isVisited[0] = true; // mark visited when pushing to queue
        
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
        list.add(node); // use list (not ans)

        for (int neighbor : adj.get(node)) {
            if (!isVis[neighbor]) {
                solve(neighbor, adj, isVis, list); // don't create new boolean array each time
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isVis = new boolean[adj.size()]; // 'v' should be adj.size()
        solve(0, adj, isVis, list);
        return list;
    }
}
```
