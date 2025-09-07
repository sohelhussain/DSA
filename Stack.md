# 232. Implement Queue using Stacks [solve here]()
```
class MyQueue {
    Stack<Integer> st1, st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int ans = st2.pop();

        while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return ans;
    }
    
    public int peek() {
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        int ans = st2.peek();

        while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return st1.isEmpty() ? true : false;
    }
}
```



# 225. Implement Stack using Queues [solve here]()

### using one queue

```
class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();  
    }
    
    public void push(int x) {
              q.offer(x);
        int size = q.size();
        while (size-- > 1) {
            q.offer(q.poll());
        }
    }
    
    public int pop() {
 return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
```
### using a two queue
```

class MyStack {
    Queue<Integer> q1, q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int val = q1.poll(); // last pushed item

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return val;
    }

    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int val = q1.poll();
        q2.offer(val); // put it back after peeking

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return val;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
```
---

# find the next grater element(gfg). imp [solve here]()
```
class Solution {
    public int[] nextGreaterElement(int[] arr) {
        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<>(); 

        for (int i = arr.length - 1; i >= 0; i--) {
            // Pop elements that are less than or equal to the current element
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop(); // Remove smaller elements
            }

            // If the stack is empty, no greater element exists
            // Otherwise, the top of the stack is the next greater element
            ans[i] = st.isEmpty() ? -1 : st.peek();

            // Push the current element onto the stack
            st.push(arr[i]);
        }
        return ans; 
    }
}
```

---
# 901. Online Stock Span [solve here]()
```
    class StockSpanner {
    Stack<int[]> stack;
    int i = -1;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        ++i;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }
        int span;
        if(stack.isEmpty()) {
            span = i + 1;
        }else {
            span = i - stack.peek()[1];
        }

        stack.push(new int[] {price, i});
        return span;
    }
}
```

# 84. Largest Rectangle in Histogram [solve here]()
```
public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] NSL = new int[n]; // Nearest Smaller to Left
        int[] NSR = new int[n]; // Nearest Smaller to Right

        // Calculate NSL (Nearest Smaller to Left)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSL[i] = -1;
            } else {
                NSL[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear stack to reuse for NSR
        stack.clear();

        // Calculate NSR (Nearest Smaller to Right)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSR[i] = n;
            } else {
                NSR[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
```
---


# 85. Maximal Rectangle [solve here]()
```
    class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;    // Number of rows
        int m = matrix[0].length; // Number of columns
        int[] heights = new int[m]; // Histogram heights for each column
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            // Update heights array based on current row
            for (int j = 0; j < m; j++) {
                // If the matrix has a '1', increment the height; otherwise, reset to 0
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            
            // Calculate the maximum rectangle area for this row's heights
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // Function to calculate the largest rectangle in a histogram using NSL/NSR approach
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] NSL = new int[n]; // Nearest Smaller to Left
        int[] NSR = new int[n]; // Nearest Smaller to Right

        // Calculate NSL (Nearest Smaller to Left)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSL[i] = -1;
            } else {
                NSL[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear stack to reuse for NSR
        stack.clear();

        // Calculate NSR (Nearest Smaller to Right)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSR[i] = n;
            } else {
                NSR[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
```
---


# 155. Min Stack [solve here]()

```
    class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();    
        minStack = new Stack<>();    
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int top = stack.pop();
        if(top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
        
}
```
---

# 150. Evaluate Reverse Polish Notation [solve here]()
```
    public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < tokens.length; i++) {
        String ch = tokens[i];
        if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                if(ch.equals("+")) {
                    result = a + b;
                }else if(ch.equals("-")) {
                    result = a - b;
                }else if(ch.equals("*") ) {
                    result = a * b;
                }else {
                    result = a / b;
                }
                stack.push(result);
        }else {
            stack.push(Integer.parseInt(ch));
        }
    }
    return stack.pop();
}
```

---




# 22. Generate Parentheses [solve here]()
```
    private void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
    if(openN == closedN && openN == n) {
        res.add(stack.toString());
        return;
    }
    if(openN < n) {
        stack.append('(');
        backtrack(openN + 1, closedN, n, res, stack);
        stack.deleteCharAt(stack.length() - 1);
    }
    if(closedN < openN) {
        stack.append(')');
        backtrack(openN, closedN + 1, n, res, stack);
        stack.deleteCharAt(stack.length() - 1);
    }
}
public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    StringBuilder stack = new StringBuilder();
    backtrack(0, 0, n, list, stack);
    return list;
}
```

---

# 394. Decode String [solve here]()

```

	public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int k = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                k = (k * 10) + (ch - '0');
            }else if(ch == '[') {
                numStack.push(k);
                k = 0;
                stack.push("[");
            }else if(ch == ']') {
                StringBuilder temp = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    temp.insert(0, stack.pop());
                }
                // [ remove this
                stack.pop();

                int count = numStack.pop();
                StringBuilder repeated = new StringBuilder();

                for(int j = 0; j < count; j++) {
                    repeated.append(temp);
                }
                stack.push(repeated.toString());
            }else {
                stack.push(String.valueOf(ch));
            }
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

```
---
# 735. Asteroid Collision [solve here]()

```
	asteroids = [-1, 3, 2, -3];

	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            int a = asteroids[i];

            while(!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int diff = a + stack.peek();

                if(diff < 0) {
                    stack.pop();
                } else if(diff > 0) {
                    // when you found diff is positive then asteroids is destorye
                    a = 0;
                }else {
                    // when the diff is 0 then we destroye both of asteroids and stack top element
                    a = 0;
                    stack.pop();
                }
            }

            if(a != 0) {
                stack.add(a);
            }

            
        }


        return stack.stream().mapToInt(i -> i)

```
---

# 71. Simplify Path [solve here]()
```
public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for(int i = 0; i < paths.length; i++) {
            String ch = paths[i];

            if(ch.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }else if(!ch.equals("") && !ch.equals(".")) {
                stack.push(ch);
            }
        }

        return "/" + String.join("/", stack);

    }

}
```
