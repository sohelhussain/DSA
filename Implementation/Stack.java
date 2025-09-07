public class Stack {
    private ListNode head;

    public Stack(ListNode head) {
        this.head = null;
    }

    public void push(int val) {
        ListNode node = new ListNode(val); 
            node.next = head;
            head = node;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }
        int val = head.data;
        head = head.next;
        return val;
    }
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }
}



// array stack



public class Stack {
    private int top, capacity;
    private int[] data;

    public Stack(int capacity) {
        top = -1;
        this.capacity = capacity;
        data = new int[capacity];
    }

    public void push(int val) {
        if(top + 1 == capacity) {
            System.out.println("overflow");
            return;
        }

        data[++top] = val;
    }

    public Integer pop(int val) {
        if(top == -1) {
            System.out.println("underFlow");
            return null;
        }

        return data[top];
    }

    
}
