class Solution {
  public static void main(String[] args) {

        //876. Middle of the Linked List
        public ListNode middleNode(ListNode head) {
        if(head==null || head.next == null) return head; // but we not need becuse constraint say at least one node is present;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }




  
  }
}
