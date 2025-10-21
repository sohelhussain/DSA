

#1. adjacent matrix


```
[0, 1, 1, 0, 0]
[1, 0, 1, 1, 0]
[1, 1, 0, 0, 1]
[0, 1, 0, 0, 1]
[0, 0, 1, 1, 0]
```

```
package graph;

import java.util.Arrays;

public class GraphImp {
    
    void graphByMatrix(int[][] mat, int u, int v, boolean isDiracted) {
        if (isDiracted) {
            mat[u][v] = 1;
        }else {
            mat[u][v] = 1;
            mat[v][u] = 1;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        
        int[][] mat = new int[v][v];

        GraphImp obj = new GraphImp(); // graphByMatrix this is not an static function that why we need to create an obj.

        obj.graphByMatrix(mat, 0, 1, false);
        obj.graphByMatrix(mat, 0, 2, false);
        obj.graphByMatrix(mat, 1, 2, false);
        obj.graphByMatrix(mat, 1, 3, false);
        obj.graphByMatrix(mat, 2, 4, false);
        obj.graphByMatrix(mat, 4, 3, false);


        for(int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}

```


#2. adjacent list.
```
[1, 2]
[0, 2, 3]
[0, 1, 4]
[1, 4]
[2, 3]
```

```
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphImp {


    void graphByList(List<List<Integer>> adjList, int u, int v, boolean isDiracted) {
        if (isDiracted) {
            adjList.get(u).add(v);
        }else {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        GraphImp obj = new GraphImp();


        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }


        obj.graphByList(adjList, 0, 1, false);
        obj.graphByList(adjList, 0, 2, false);
        obj.graphByList(adjList, 1, 2, false);
        obj.graphByList(adjList, 1, 3, false);
        obj.graphByList(adjList, 2, 4, false);
        obj.graphByList(adjList, 4, 3, false);


        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(adjList.get(i));
        }
    }
}

```


V be the number of vertices (nodes) in the graph.
E be the number of edges in the graph. 

Operation 	                  Adjacency Matrix	Adjacency List
Space                            (O(V^2))          (O(V+E))
Add Vertex                       (O(V^2))          (O(1))
Remove Vertex                    (O(V^2))          (O(V+E))
Add Edge                         (O(1))            (O(1))
Remove Edge                      (O(1))            (O(deg(v)))
Check for Edge                   (O(1))            (O(deg(v)))
Traverse Graph (BFS/DFS)         (O(V^2))          (O(V+E))
