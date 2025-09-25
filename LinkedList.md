# 876. Middle of the Linked List [solve here]()

```
        public ListNode middleNode(ListNode head) {
        if(head==null || head.next == null) return head; // but we not need becuse constraint say at least one node is present;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
```
---


# 21. Merge Two Sorted Lists [solve here]()

### recusive approach
```
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
```
### itrative approach
```
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
```

---

# 141. Linked List Cycle [solve here]()
```
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
```


---
  
# 206. Reverse Linked List [solve here]()
```
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
```
---

# 83. Remove Duplicates from Sorted List [solve here]()

```
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
```
---

# 24. Swap Nodes in Pairs [solve here]()

```
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
```

![IMG_0067](https://github.com/user-attachments/assets/bb7bb6b8-13d4-4d09-b1a8-6a5afcd02ecb)

---

# 25. Reverse Nodes in k-Group [solve here]()
```
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
```
---

# 138. Copy List with Random Pointer [solve here]()
```
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
```
---

# 160. Intersection of Two Linked Lists [solve here]()
```
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

    while (a != b) {
        a = (a == null) ? headB : a.next;
        b = (b == null) ? headA : b.next;
    }

    return a;
    }
```
---

# 2. add two numbers. [solve here]()

```
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
```
---

# 1669. Merge In Between Linked Lists [solve here]()
```
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
```
---

# 2181. Merge Nodes in Between Zeros [solve here]()

```
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
```
---

# 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points [solve here]()
```
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
```
---
# 143. Reorder List [solve here](https://leetcode.com/problems/reorder-list/)
- Take a middle by two pointers and break it into two parts.
- Last part, reverse it, then merge both parts one by one.
```
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    private void merge(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;

            l1.next = l2;
            if(l1 == null) break;
            l2.next = n1;

            l1 = n1;
            l2 = n2;
        }
    }
    public void reorderList(ListNode head) {
        if(head == null && head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null;

        merge(head, second);
    }
}
```
---
# 19. Remove Nth Node From End of List [solve here](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)
- Move fast and point to nth.
- Then we check if fast is null, then return head. next.
- Move slow point to head while fast is not null.
- Also check if slow or next is not null. then slow next is attached to slow. next.next.
```
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while(n-- > 0) {
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if(slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }
}
```
---

92. Reverse Linked List II [solve here](https://leetcode.com/problems/reverse-linked-list-ii/)
```
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPrev = dummy;
        for(int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
        }

        ListNode start = leftPrev.next;
        ListNode end = start;
        for(int i = left; i < right; i++) {
            end = end.next;
        }

        ListNode rightNext = end.next;
        end.next = null;

        ListNode newHead = reverse(start);
        
        leftPrev.next = newHead;
        start.next = rightNext;

        return dummy.next;

    }
}
```
---
# 61. Rotate List [solve here](https://leetcode.com/problems/rotate-list/)
first move pointer to end then end node point head (circular linked list) then target point add null
```
head → 1 → 2 → 3 → 4 → 5
       ↑               ↓
       └─--------──────┘


              null
               |
head → 1 → 2 → 3  4 → 5
       ↑               ↓
       └─--------──────┘
```
```
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        temp.next = head;
        k = k % length;
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
```
---
# 86. Partition List [solve here](https://leetcode.com/problems/partition-list/)
create a tow list one is small second is large.
```
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallTail = small;
        ListNode largeTail = large;

        while(head != null) {
            if(head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            }else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }
        smallTail.next = large.next;
        largeTail.next = null;
        return small.next;
    }
}
```
