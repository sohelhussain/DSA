// 232. Implement Queue using Stacks
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




//225. Implement Stack using Queues

//using one queue

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

// ---------------- using a two queue -------------------

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

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */





//find the next grater element(gfg). imp

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




//901. Online Stock Span

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






// 84. Largest Rectangle in Histogram
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



    // 85. Maximal Rectangle

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
    

}

