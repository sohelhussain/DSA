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


    //21. Merge Two Sorted Lists
    ==> // recusive
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         if(list1 == null){
                return list2;
            }

            if(list2 == null){
                return list1;
            }

            if(list1.val <= list2.val){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }

    }

  ==> //itrative approch
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
                temp = temp.next;

        }

        temp.next = list1 != null ? list1 : list2;

        return ans.next;
    }

  
  }
}
