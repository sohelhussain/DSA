package Listnode;

import java.lang.classfile.components.ClassPrinter.ListNode;

/**
 * buildList
 */
public class buildList {

    ListNode n1 = new ListNode(10);
    ListNode n2 = new ListNode(20);
    ListNode n3 = new ListNode(30);
    ListNode n4 = new ListNode(40);
    ListNode n5 = new ListNode(50);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    return n1;

    public static void printList(ListNode head){
        while (head != null) {
            System.out.println(head.val+ '->');
            printRecursive(head.next);
        }
    }
    public static int linearSearch(ListNode head, int key){
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        return head;
    }
    public static Listnode insertLast(ListNode head, int){
        listNode newNode = new Listnode(val);
        if (head == null) {
            return newNode
            ListNode temp = head:
            while(head.next != null){
                
            }
        }
    }
}