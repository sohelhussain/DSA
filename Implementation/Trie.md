```
package Trie;

public class Trie {
    class Node {
        Node children[];
        boolean isEnd;
        Node() {
            children = new Node[26];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            isEnd = false;
        }    
    }
    Node root = new Node();

    void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            if(word.length() - 1 == i) cur.children[idx].isEnd = true;
            cur = cur.children[idx];
        }
    }

    boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null) {
                return false;
            }
            if(word.length() - 1 == i && cur.children[idx].isEnd == false) return false;
            cur = cur.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        String[] s = {"apply", "the", "app", "those", "apple", "an"};
        for (int i = 0; i < s.length; i++) {
            obj.insert(s[i]);
        }
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("appl"));
        System.out.println(obj.search("the"));
    }
}
```
