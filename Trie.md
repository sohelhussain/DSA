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
