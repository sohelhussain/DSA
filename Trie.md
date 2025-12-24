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
---
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
---
# 3. Word Search II [solve here](https://leetcode.com/problems/word-search-ii/)
```
class Solution {
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

    public void solve(char[][] board, int i, int j, List<String> list, boolean[][] isVis, Node curNode, String str) {
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || isVis[i][j] || curNode.children[board[i][j] - 'a'] == null) return ;
        isVis[i][j] = true;
        curNode = curNode.children[board[i][j] - 'a'];
        if(curNode.isEnd) {
            list.add(str + board[i][j]);
            curNode.isEnd = false;
        }
        solve(board, i, j - 1, list, isVis, curNode, str + board[i][j]);
        solve(board, i - 1, j, list, isVis, curNode, str + board[i][j]);
        solve(board, i, j + 1, list, isVis, curNode, str + board[i][j]);
        solve(board, i + 1, j, list, isVis, curNode, str + board[i][j]);
        isVis[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        boolean[][] isVis = new boolean[board.length][board[0].length];
        for(int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        Node cur = root;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int idx = board[i][j] - 'a';
                if(cur.children[idx] != null) {
                    solve(board, i, j, list, isVis, cur, "");
                }
            }
        }
        return list;
    }
}
```
---
# 4. Maximum XOR of Two Numbers in an Array [solve here](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)
```
class Solution {
    class Node {
        Node zero, one;
        Node() {
            this.zero = this.one = null;
        }
    }
    Node root = new Node();
    void insert(int num) {
        Node cur = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(bit == 0) {
                if(cur.zero == null) cur.zero = new Node();
                cur = cur.zero;
            }else {
                if(cur.one == null) cur.one = new Node();
                cur = cur.one;
            }
        }
    }
    int getMaxXor(int num) {
        int maxXor = 0;
        Node cur = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(bit == 0) {
                if(cur.one != null) {
                    maxXor += 1 << i;
                    cur = cur.one;
                }else cur = cur.zero;
            }else {
                if(cur.zero != null) {
                    maxXor += 1 << i;
                    cur = cur.zero;
                }else cur = cur.one;
            }
        }
        return maxXor;
    }
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for(int num: nums) {
            insert(num);
        }
        for(int num: nums) {
            ans = Math.max(ans, getMaxXor(num));
        }
        return ans;
    }
}
```
