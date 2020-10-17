// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Looked the idea from the leet code , but it is not executing throwing the memory exceeded.
 

// Your code here along with comments explaining your approach

// core logic: follow below 3 steps:
    // 1) split the list in to half
    // 2) reverse the second list
    // 3) merge both the lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverseList(slow);  // reverse the 2nd list
        slow.next = null; // split the list: point the last node of first list to null
        merge2Lists(head, head2);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static void merge2Lists(ListNode head1, ListNode head2) {
        while (head2 != null) {  
            ListNode n1 = head1.next;
            ListNode n2 = head2.next;
            head1.next = head2;
            head2.next = n1;
            head1 = n1;
            head2 = n2;
        }
    }
}
