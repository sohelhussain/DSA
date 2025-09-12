
![IMG_0074](https://github.com/user-attachments/assets/f6ba37a9-ccf0-4eb5-a7a9-76ca770ce32f)
### LDR -> Left Data Right aka Inorder Traversal
```
3 -> 16 -> 17
```
### DLR -> Data Left Right aka Preorder Traversal
```
16 -> 3 -> 17
```
### LRD -> Left Right Data aka Postorder Traversal
```
3 -> 17 -> 16
```
---

# 1. Binary Tree Inorder Traversal [solve here](https://leetcode.com/problems/binary-tree-inorder-traversal/)
[solve without space by **morris traversal**](https://github.com/sohelhussain/DSA/blob/c6ed76ffd59e6fd6b231a11483e9a53b786bb4c1/BinaryTree.md#morris-traversal)
## Iterative approach
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;

        while(cur != null) {
            if(cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            }else {
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                }else {
                    list.add(cur.val);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}
```

## recursive approach
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    public void inorderHelper(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        inorderHelper(root.left, result); 
        result.add(root.val); 
        inorderHelper(root.right, result);
    }
}
```
---

# 2. Binary Tree Preorder Traversal [solve here](https://leetcode.com/problems/binary-tree-preorder-traversal/)
```
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    public void preorderHelper(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preorderHelper(root.left, result);
        preorderHelper(root.right, result);
    }
}
```
---

# 3. Binary Tree Postorder Traversal [slove here](https://leetcode.com/problems/binary-tree-postorder-traversal/)
```
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    public void postorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}
```
---

# 4. Maximum Depth | Maximum Height | Number Of Levels [solve here](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

```
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
```
# 5. Same Tree [solve here](https://leetcode.com/problems/same-tree/)

```
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
            return false;
    }
}
```
```
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        if(left == true && right == true && p.val == q.val) {
            return true;
        }else {
            return false;
        }
    }
}
```
```
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```
---

# 6. Symmetric Tree [solve here](https://leetcode.com/problems/symmetric-tree/)

```
class Solution {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root, root);
    }
}
```
---
# 7. Binary Tree Level Order Traversal aka BFS [solve here](https://leetcode.com/problems/binary-tree-level-order-traversal/)
```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            while(size-- > 0) {
                TreeNode frontNode = queue.poll();
                currentLevel.add(frontNode.val);
                if(frontNode.left != null) queue.offer(frontNode.left);
                if(frontNode.right != null) queue.offer(frontNode.right);
            }
            list.add(currentLevel);
        }
        return list;
    }
}
```

# 8. Path Sum [solve here](https://leetcode.com/problems/path-sum/)
![pathSum](https://assets.leetcode.com/uploads/2021/01/18/pathsum1.jpg)
```
 int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return helper(root, 0);

    }

    private boolean helper(TreeNode root, int sum){
        if(root == null) return false;
        sum += root.val;
        if(root.left == null && root.right == null){
            return sum == target;
        }
        boolean leftAns = helper(root.left, sum);
        boolean rightAns = helper(root.right, sum);

        return leftAns || rightAns;
    }
```
```
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && targetSum - root.val == 0){
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum- root.val);
    }
}
```
---
# 113. Path Sum II [solve here](https://leetcode.com/problems/path-sum-ii/description/)
```
```
---
# 226. Invert Binary Tree [solve here](https://leetcode.com/problems/invert-binary-tree/)
![invertBinary](https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg)
```
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
```
```
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
```
---
# 543. Diameter of Binary Tree [solve here](https://leetcode.com/problems/diameter-of-binary-tree/)
![diameter](https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg)
```
class Solution {
    int maxDiameater = 0;
    private int height(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        maxDiameater = Math.max(maxDiameater, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameater;
    }
}
```
```
class Solution {
    private int height(TreeNode root, int[] maxDiameater) {
        if(root == null) return 0;
        int leftHeight = height(root.left, maxDiameater);
        int rightHeight = height(root.right, maxDiameater);
        maxDiameater[0] = Math.max(maxDiameater[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameater = new int[1];
        height(root, maxDiameater);
        return maxDiameater[0];
    }
}
```
```
class Solution {
    private int[] fn(TreeNode root) {
        int[] ans = {0,0};
        if(root == null) return ans;

        int[] left = fn(root.left);
        int[] right = fn(root.right);

        ans[1] = Math.max(Math.max(left[1], right[1]), left[0] + right[0]);
        ans[0] = Math.max(left[0], right[0]) + 1;
        return ans;
    }
    public int diameterOfBinaryTree(TreeNode root) {
       return fn(root)[1]; 
    }
}
```

![IMG_0075](https://github.com/user-attachments/assets/641f14d7-b5d3-41f4-ae8c-d573760f00d4)

---
# Left View of Binary Tree [solve here](https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/)

### DFS -> dlr approach
#### TreeNode.java
```
package Tree;

public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

```
#### TreeBuild.java
```
package Tree;
import java.util.Scanner;

public class TreeBasics {
    static int index = 0;
    private static TreeNode buildTree(int[] data) {
        TreeNode root = null;
        if (data[index] == -1) {
            index++;
            return null;
        }
        root = new TreeNode(data[index++]);
        root.left = buildTree(data);
        root.right = buildTree(data);
        return root;
    }
    public static void main(String[] args) {
        int[] data = {70, 8, 12, 5, -1, -1, 7, -1, 9, 13, -1, -1, -1, 15, -1, -1, 4, -1, -1};
        TreeNode root = buildTree(data);
        LeftView.printLeftView(root);
    }
}
```
#### LeftView.java
```
package Tree;

import java.util.HashMap;
import java.util.Map;

public class LeftView {
    private static Map<Integer, Integer> leftView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map, 0);
        return map;
    }
    private static void dfs(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root == null) {
            return;
        }
        if(!map.containsKey(level)) { // if we remove not simbole then this print right view because it over right value
            map.put(level, root.val);
        }
        dfs(root.left, map, level + 1);
        dfs(root.right, map, level + 1);
    }
    public static void printLeftView(TreeNode root) {
        Map<Integer, Integer> map = leftView(root);
        System.out.println(map);
    }
}

```
### BFS approach
```
```
---
# Top View of Binary Tree [solve here]()
### DFS -> dlr approach
#### TreeNode.java
```
package Tree;

public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

```
#### TreeBuild.java
```
package Tree;

public class TreeBasics {
    static int index = 0;

    private static TreeNode buildTree(int[] data) {
        if (index >= data.length) return null;

        if (data[index] == -1) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(data[index++]);
        root.left = buildTree(data);
        root.right = buildTree(data);
        return root;
    }

    public static void main(String[] args) {
        int[] data = {70, 8, 12, 5, -1, -1, 7, -1, 9, 13, -1, -1, -1, 15, -1, -1, 4, -1, -1};
        TreeNode root = buildTree(data);
        TopView.printTopView(root);
    }
}

```
#### TopView.java
```
package Tree;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class TopView {
    private static void dfs(TreeNode root, Map<Integer, Integer> map, int hd) {
        if (root == null) return;
        if (!map.containsKey(hd)) {
            map.put(hd, root.val);
        }
        dfs(root.left, map, hd - 1);
        dfs(root.right, map, hd + 1);
    }

    public static void printTopView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map, 0);

        // sort by horizontal distance
        Map<Integer, Integer> sorted = new TreeMap<>(map);
        System.out.println(sorted.values());
    }
}
```
---
# morris traversal
without using any space inorder travers
```
 private static void moriseLDR(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val + " ");
                cur = cur.right;
            } else {
                TreeNode predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    predecessor.right = null;
                    System.out.println(cur.val + " ");
                    cur = cur.right;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] data = {70, 8, 12, 5, -1, -1, 7, -1, 9, 13, -1, -1, -1, 15, -1, -1, 4, -1, 17, 25, -1, -1, 28, -1, -1};
        TreeNode root = buildTree(data);
        moriseLDR(root);
```
![geeks-morris](https://media.geeksforgeeks.org/wp-content/uploads/20250203183040504282/Morris-traversal-for-Inorder-8.webp)

![IMG_0078](https://github.com/user-attachments/assets/5ad5513c-409f-4d73-a93e-c5b949823bc4)


---
# 114. Flatten Binary Tree to Linked List [solve here](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
```
class Solution {
    TreeNode next = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }
}
```
