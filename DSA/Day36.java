package DSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class Day36 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // Result list to store the final level order traversal.
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: if the root is null, return an empty list.
        if (root == null) {
            return result;
        }

        // Queue to facilitate breadth-first traversal.
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // Add the root node to the queue.

        // Process nodes until the queue is empty.
        while (!q.isEmpty()) {
            // Get the current size of the queue (number of nodes at the current level).
            int size = q.size();

            // List to store the values of nodes at the current level.
            List<Integer> currentLevel = new ArrayList<>();

            // Iterate over all nodes at the current level.
            while (size-- > 0) {
                // Poll the front node from the queue.
                TreeNode front = q.poll();

                // Add the value of the node to the current level list.
                currentLevel.add(front.val);

                // If the left child exists, add it to the queue.
                if (front.left != null) {
                    q.offer(front.left);
                }

                // If the right child exists, add it to the queue.
                if (front.right != null) {
                    q.offer(front.right);
                }
            }

            // Add the current level list to the result.
            result.add(currentLevel);
        }

        // Return the final level order traversal.
        return result;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree:
        //         3
        //        / \
        //       9  20
        //          /  \
        //         15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Perform level-order traversal.
        List<List<Integer>> result = levelOrder(root);

        // Print the result.
        System.out.println(result);
    }
}