### left node is smaller to right side of node.
inorder is become sorted.

```
package bst;

import Tree.TreeBasics;
import Tree.TreeNode;

public class BinarySearchTree {
    public static TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        }else if(val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        int data[] = {25, 7, 13, 30, 28, 35, 5, 9, 45, 15};
        TreeNode root = null;
        for (int val: data) {
            root = insert(root, val);
        }
        TreeBasics.moriseLDR(root); // ans -> 5 -> 7 -> 9 -> 13 -> 15 -> 25 -> 28 -> 30 -> 35 -> 45 
    }
}

```
