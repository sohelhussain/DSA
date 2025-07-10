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
