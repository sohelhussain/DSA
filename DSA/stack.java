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
