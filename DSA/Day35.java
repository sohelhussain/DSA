package DSA;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}



public class Day35 {

    static Scanner sc;
    static int i = 0;

    static{
        sc = new Scanner(System.in);
    }


    //!bulding a Tree by node
    private static TreeNode buildNode(){
        System.out.println("Enter val");
        int val = sc.nextInt();
        if (val = -1) {
            return null;
        }
        TreeNode root = new TreeNode(val);
        System.out.println("Enter left for " + val);
        root.left = buildTree()
        System.out.println("Enter right for " + val);
        root.right = buildTree();
        return root;
    }
    //!build a Tree by array
    public static TreeNode buildTreeArray(int[]){
        if (i == arr.length) {
            return null;
        }
        int val = arr[i++];
        if (val == -1) {
            return null
        }
        TreeNode root = new TreeNode(val);
        root.left = buildTreeArray(arr);
        root.right = buildTreeArray(arr);
        return root;
    }

    public static void dlr(TreeNode root){
        if (root == null) {
            return
        }
        System.out.println(root.val +" ");
        dlr(root.left);
        dlr(root.right);
    }
    public static void ldr(TreeNode root){
        if (root == null) {
            return
        }
        ldr(root.left);
        System.out.println(root.val+ " ");
        ldr(.right);
    }





    //! Build the tree from a preordered array.
    public static TreeNode buildTreeFromPreorder(int[] preordered){
        if (index == preordered.length) {
            return null;
        }
        int val = preordered[index++];
        if (val == -1) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        root.left = buildTreeFromPreorder(preordered);
        root.right = buildTreeFromPreorder(preordered);
        return root;
    }

    //! Find the height of the tree.
    public static int findHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //! Find the size of the tree.
    public static int findSize(TreeNode root){
        if (root == null) {
            return 0;
        }
        return 1 + findSize(root.left) + findSize(root.right);
    }

    //! Find the maximum value in the tree.
    public static int findMax(TreeNode root){
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    //! Find the minimum value in the tree.
    public static int findMin(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        return Math.min(root.val, Math.min(leftMin, rightMix));
    }



    public static void main(String[] args) {
        int arr[] = {10, 20, 30, -1, -1, -1, 25, 34, -1, 75, -1, -1, 86, -1, -1};
        // !builing a tree
        // TreeNode root = buildTreeArray(arr);

        // ! dlr
        // dlr(root);
        // System.out.println();
        // ldr(root);

        //! Build the tree from a preordered array.         
        // TreeNode root = buildTreeFromPreorder(preorder);

        //! Find the height of the tree.
        // System.out.println("Height of the tree: " + findHeight(root));

        //! Find the size of the tree.
        // System.out.println("Size of the tree: " + findSize(root));

         //! Find the maximum value in the tree.
        // System.out.println("Maximum value in the tree: " + findMax(root));

         //! Find the minimum value in the tree.
        // System.out.println("Minimum value in the tree: " + findMin(root));

    }
}
