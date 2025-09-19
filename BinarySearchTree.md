# 1. Validate Binary Search Tree [solve here](https://leetcode.com/problems/validate-binary-search-tree/)

```
class Solution {
    private boolean bst(TreeNode root, long minVal, long maxVal) {
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        boolean left = bst(root.left, minVal, root.val);
        boolean right = bst(root.right, root.val, maxVal);
        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
       return bst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
```
```
class Solution {
    private boolean bst(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min || max != null && root.val >=  max) {
            return false;
        }
        boolean left = bst(root.left, min, root.val);
        boolean right = bst(root.right, root.val, max);
        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
       return bst(root, null, null);
    }
}
```
---
# 2. Lowest Common Ancestor of a Binary Search Tree [solve here](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
```
time complexity => O(longN)
---
# 3. Convert Sorted Array to Binary Search Tree [solve here](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
```
class Solution {
    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
}
```
---
# 4. Kth Smallest Element in a BST [solve here](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
you goo leftmost, when we found the null then backtrak and minus k and also chek it becom zero then we save root value into the ans then retrun eather we go to the right.
### recursive approach
```
class Solution {
    int ans;
    int k;
    private void smallest(TreeNode root) {
        if(root.left != null) {
            smallest(root.left);
        }
        if(--k == 0) {
            ans = root.val;
            return;
        }
        if(root.right != null) {
            smallest(root.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        ans = root.val;
        smallest(root);
        return ans;
    }
}
```
### iterative approach
```
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            if(--k == 0) {
                return top.val;
            }
            root = top.right;
        }
        return root.val;
    }
}
```
---
# 5. Delete Node in a BST [solve here](https://leetcode.com/problems/delete-node-in-a-bst/)
we are going to write becuse we know left maximum element i can found in rightMost in bst.
```
  while(root.right != null) {
            root = root.right;
        }


3 node tree, max node is rightest Most (mins 4)

        5
       / \
      3   6
     / \    \
    2   4    7

```
```
class Solution {
    private TreeNode max(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }else if(key == root.val) {
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }

            int max = max(root.left).val;
            root.val = max;
            root.left = deleteNode(root.left, max);
            return root;
        }

        return root;
    }
}
```
