
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
         // Result list to store the final level order traversal.
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: if the root is null, return an empty list.
        if(root == null){
            return result;
        }

        // Queue to facilitate breadth-first traversal.
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // Add the root node to the queue.

        // Process nodes until the queue is empty.
        while(!q.isEmpty()){
            // Get the current size of the queue (number of nodes at the current level).
            int size = q.size();

            // List to store the values of nodes at the current level
            List<Integer> currentLevel = new ArrayList<>();

            // Iterate over all nodes at the current level.
            while(size-- > 0){
                // Poll the front node from the queue.
                TreeNode front = q.poll();

                // Add the value of the node to the current level list.
                currentLevel.add(front.val);

                // If the left child exists, add it to the queue.
                if(front.left != null){
                    q.offer(front.left);
                }

                // If the right child exists, add it to the queue.
                if(front.right != null){
                    q.offer(front.right);
                }
            }
            // Add the current level list to the result.
            result.add(currentLevel);
        }
        // Return the final level order traversal.
        return result;
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
