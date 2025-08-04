# 1. Tower Of Hanoi.

1. First, we move n - 1 plates to the auxiliary rod.
(To do this, we can make the auxiliary rod the temporary destination for a shorter time.)

2. After this, we can move the n-th plate to the destination.


```
public static void towerOfHanoi(int s, int aux, int d, int n){
        if(n==1){
            System.out.println(s + ' -> ' + d);
            return
        }
        //n - 1 plates are gose source to aux.
        towerOfHanoi(s, d, aux, n - 1);
        System.out.println(s + ' -> ' + d);
        towerOfHanoi(aux, s, d, n - 1);
    }

public static void main(String[] args) {
        int n = 3; // plates
        tow(1, 2, 3, n);
    }
```

![towerofhanoi](https://github.com/user-attachments/assets/b91896d3-b2d2-4ae2-b7c0-3fb79d79363d)

---

# 1823. Find the Winner of the Circular Game.

1. We create a circular ArrayList and find the index of the person to be eliminated using the formula:
(i + k - 1) % size, where i is the current index, k is the step count, and size is the number of remaining people.

**why we're using this formula** => [Learn more](https://github.com/sohelhussain/DSA/blob/main/why.md#scenario-josephus-problem)

```
class Solution {
    private int alive(List<Integer> people, int i, int k) {
        if(people.size() == 1) return people.get(0);
        int killPerson = (i + k - 1) % people.size();
        people.remove(killPerson);
       return alive(people, killPerson, k);
    }

    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        return alive(list, 0, k);
    }
}

```

![circular array](https://github.com/user-attachments/assets/0c965ea0-f0ca-415d-be8b-b74145e5917c)


---

# Subset powerset **Imp.**


### 1. powerSet
```
class Solution {
public static void subsetString(String s, String cur, List<String> ans, int i) {
    if(i == s.length()) {  // O(1)
        if (cur.length() > 0) {  // O(1)
            ans.add(cur);  // O(n) making a new string
        }
        return;
    }

    //choose
    subsetString(s, cur + s.charAt(i), ans, i + 1); // O(2^n)
    
    // not choose
    subsetString(s, cur, ans, i + 1); // O(2^n)
  } 

    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = new ArrayList<>();
        subsetString(s, "", ans, 0);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
```

Time Complexity: O(n × 2ⁿ)
Space Complexity: O(n × 2ⁿ)


### 2. 78 subSet [solve here](https://leetcode.com/problems/subsets/submissions/1410588368/)


```
class Solution {
    // Recursive method to generate subsets
    public static void powerKaSetArrayWala(int[] arr, int i, List<Integer> cur, List<List<Integer>> ans) {
        // Base case: If we have processed all elements, add the current subset to the result
        if(i == arr.length) {
            ans.add(new ArrayList<>(cur));  // Add a copy of the current subset
            return;
        }
        
        // Include the current element and move to the next element
        cur.add(arr[i]);
        powerKaSetArrayWala(arr, i+1, cur, ans);
        
        // Backtrack: Remove the last element and move to the next element (not including this one)
        cur.remove(cur.size() - 1);  // Use remove(size - 1) to remove the last element
        
        // Exclude the current element and move to the next element
        powerKaSetArrayWala(arr, i+1, cur, ans);
    }

    // Main function for LeetCode problem
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();  // This will hold all subsets
        List<Integer> cur = new ArrayList<>();  // This is the current subset being built
        
        // Start the recursion
        powerKaSetArrayWala(nums, 0, cur, ans);
        
        return ans;
    }
}
```

#### Time Complexity

we are making a copy that hold O(n)
and we calling a 2^n calls

so final Complexity is ``` O(n * 2^n) ```
