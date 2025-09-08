
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
