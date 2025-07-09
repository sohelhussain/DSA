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


  

  //141. Linked List Cycle
      public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                return true;
            }

        }
        return false;
    }




  
//206. Reverse Linked List
  {
    public ListNode reverse(ListNode head, ListNode pre) {
        if (head == null) return pre;

        ListNode temp = head.next;
        head.next = pre;
        pre = head;
        head = temp;

        return reverse(head, pre);

    }
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
  }

//83. Remove Duplicates from Sorted List
public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode ans = deleteDuplicates(head.next);

        if(head.val == ans.val){
            return ans;
        }else {
            head.next = ans;
            return head;
        }
    }


//24. Swap Nodes in Pairs

class Solution {
    public void reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        while(prev != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode start = head;
        ListNode end = head.next;

        ListNode ans = swapPairs(end.next);

        reverse(start, end);

        start.next = ans;

        return end;
    }
}


//25. Reverse Nodes in k-Group
class Solution {
    public void reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        while(prev != end) {
            ListNode temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null) return head;
        
        ListNode start = head;
        ListNode end = head;

        for(int i = 1; i < k; i++){
            end = end.next;
            if(end == null){
                return head;
            }
        }

        ListNode ans = reverseKGroup(end.next, k);

        reverse(start, end);

        start.next = ans;

        return end;
    }
}



//138. Copy List with Random Pointer
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node nh = new Node(head.val);
        Node temp = head;
        Node tempnh = nh;

        map.put(temp, tempnh);

        while(temp.next != null){
            tempnh.next = new Node(temp.next.val);
            map.put(temp.next, tempnh.next);

            tempnh = tempnh.next;
            temp = temp.next;
        } 

        tempnh = nh;
        temp = head;

        while(temp != null){
            if(temp.random != null){
                tempnh.random = map.get(temp.random);
            }
            temp = temp.next;
            tempnh = tempnh.next;
        }

        return nh;
    }
}



// 160. Intersection of Two Linked Lists
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

    while (a != b) {
        a = (a == null) ? headB : a.next;
        b = (b == null) ? headA : b.next;
    }

    return a;
    }


//2. add two numbers.

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;


            int sum = v1 + v2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }



// 1669. Merge In Between Linked Lists
public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;
        ListNode afterB = list1;
        ListNode tailNode = list2;
        int counter = 0;

        while(counter != a - 1){
            counter++;
            prevA = prevA.next;
        }

        counter = 0;
        while(counter != b + 1) {
            counter++;
            afterB = afterB.next;
        }

        while(tailNode.next != null){
            tailNode = tailNode.next;
        }

        prevA.next = list2;
        tailNode.next = afterB;

        return list1;
    }


//2181. Merge Nodes in Between Zeros

public ListNode mergeNodes(ListNode head) {
        boolean isAdd = false;
        ListNode dummy = new ListNode();
        ListNode point = dummy;
        int sum = 0;

        while(head != null){
            sum += head.val;

            if(head.val == 0){
                point.next = new ListNode(sum);
                point = point.next;
                sum = 0;
            }
            head = head.next;
        }

        return dummy.next.next;
    }
    
    //2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null) return new int[]{-1,-1};

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        int first = -1, last = -1;
        int index = 1;
        int minDist = Integer.MAX_VALUE;

        while(next != null && next.next != null) {
            prev = curr;
            curr = next;
            next = next.next;
            index++;

                // local maxima                                      // local minima
            if(prev.val < curr.val && curr.val > next.val || prev.val > curr.val && curr.val < next.val) {

                if(first == -1) {
                    first = index;
                }else {
                    minDist = Math.min(minDist, index - last);
                }

                last = index;
            }
        }

        if(first == last) return new int[]{-1,-1};

        return new int[] {minDist, last - first};
    }

  }
}
