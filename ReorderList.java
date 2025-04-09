// Time Complexity: O(n)
// Space Complexity: O(1)

//Leetcode problem: https://leetcode.com/problems/reorder-list/

// Find the middle of the linked list, reverse the second half, and then reorder the list.

public class ReorderList {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        //Find Mid
        ListNode slow = head;
        ListNode fast = head; 

        while(fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next;
        }

        //reverse the list from mid to end
        ListNode current = slow; 
        ListNode prev = null; 

        while(current != null) {
            ListNode temp = current.next;
            current.next = prev; 
            prev = current;
            current = temp;
        }
        
        //readjust pointers
        ListNode firstHead = head;
        ListNode secondHead = prev; 

        while(secondHead.next != null) {
            ListNode temp = firstHead.next; 
            firstHead.next = secondHead; 
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }
    }
}
