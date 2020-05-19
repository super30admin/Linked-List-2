package com.ds.rani.linkedlist;

/**
 *Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

//Approach:split the list in 2 halfes, reverse the second half and then merge these two lists
//Time complexity:o(n) where n is linkedlist length
//space complexity:o(1)
public class ReorderList {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        //If list is null
        if (head == null || head.next==null) {
            return;
        }

        // Find the middle of list (3)
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        //1-2-3-5-4
         fast = reverse( slow.next );
         slow.next = null;
         slow=head;

        //1-2-3-null    5-4-null
        // Link the two lists,first is the not reversed and second is reversed lists
        while (fast!=null) {
            ListNode curr = slow.next; //2
            slow.next = fast; //5->2
            fast=fast.next;
            slow.next.next=curr;
            slow=curr;
        }
    }

    /**
     * Reverse linkedList
     * @param node head of linkedlist
     * @return the head of list sfter reversing it
     */
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode fast = node.next;

        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}
