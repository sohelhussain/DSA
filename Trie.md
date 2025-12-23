# 1. Implement Trie (Prefix Tree) [solve here](https://leetcode.com/problems/implement-trie-prefix-tree/)
```
class Trie {
    Trie[] children;
    boolean isEnd;
    Trie root;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
        root = this;
    }

    public void insert(String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Trie();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) return false;
            cur = cur.children[idx];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.children[idx] == null) return false;
            cur = cur.children[idx];
        }
        return true;
    }
}

```
# 2. Longest Common Prefix [solve here](https://leetcode.com/problems/longest-common-prefix/)
```
class Solution {
    class Node {
        Node children[];
        boolean isEnd;
        int countOfChildren;
        Node() {
            children = new Node[26];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            isEnd = false;
            countOfChildren = 0;
        }    
    }
    Node root = new Node();

    void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new Node();
                cur.countOfChildren++;
            }
            if(word.length() - 1 == i) cur.children[idx].isEnd = true;
            cur = cur.children[idx];
        }
    }

    String lcp(String word) {
        Node cur = root;
        String ans = "";
        for(int i = 0; i < word.length(); i++) {
            if(cur.countOfChildren == 1) {
                ans = ans + word.charAt(i);
                int idx = word.charAt(i) - 97;
                cur = cur.children[idx];
            }else break;

            if(cur.isEnd) break;
        }
        return ans;
    }

    public String longestCommonPrefix(String[] strs) {
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() == 0) return "";
            insert(strs[i]);
        }
        return lcp(strs[0]);
    }
}
```
