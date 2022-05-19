/*
Time complexity: O(4n) linear scan 4 times
Space: O(Min(n,m)) Hashset hold at the max all the nodes from the linkedlist of smaller size
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    private static Set<ListNode> set;
    private static ListNode node;
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        set = new HashSet<>();
        int lenA = getLen(headA), lenB = getLen(headB);
        node = lenA > lenB ? headB : headA;
        addToSet(node);
        node = lenA <= lenB ? headB : headA;
        return ifContains(node);
    }
    
    private static int getLen(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
    private static void addToSet(ListNode node){
        while(node != null) {
            set.add(node);
            node = node.next;
        }
    }
    private static ListNode ifContains(ListNode node){
        while(node != null) {
            if(set.contains(node)){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(3);        

        head1.next = new ListNode(9);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(4);


        head2.next = head1.next.next.next;

        print(head1);
        print(head2);

        System.out.println(getIntersectionNode(head1, head2).val);
    }

    private static void print(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.print(node.val +" -> ");
            node = node.next;
        }
        System.out.println();
        return;
    }
}
