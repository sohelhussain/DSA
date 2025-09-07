```
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
```

# Traversal

## depth first search

### LDR -> Left Data Right

```
        printLDR(root.left);
        System.out.println(root.val);
        printLDR(root.right);
```
```
3 -> 16 -> 17 -> 24 -> 2 -> 9 -> 3
```

### DLR -> Data Left Right

```
        System.out.println(root.val);
        printLDR(root.left);
        printLDR(root.right);
```
```
24 -> 16 -> 3 -> 17 -> 9 -> 2 -> 3
```

### LRD -> Left Right Data

```
        printLDR(root.left);
        printLDR(root.right);
        System.out.println(root.val);
```
```
3 -> 17 -> 16 -> 2 -> 3 -> 9 -> 24
```
