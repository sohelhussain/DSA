import java.util.Scanner;

public class TreeBasics {
    static Scanner sc;
    static {
         sc = new Scanner(System.in);
    }
    private static TreeNode buildTree() {
        System.out.println("Enter data");
        int val = sc.nextInt();
        if (val == -1) {
            return null;
        }
        TreeNode root = new TreeNode(val);
        System.out.println("Enter left for " + val);
        root.left = buildTree();
        System.out.println("Enter right for " + val);
        root.right = buildTree();
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = buildTree();
        printLDR(root);
    }

    private static void printLDR(TreeNode root) {
        if(root == null) {
            return;
        }
        printLDR(root.left);
        System.out.println(root.val);
        printLDR(root.right);
    }
}
