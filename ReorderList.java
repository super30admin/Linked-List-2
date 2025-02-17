// Time complexity:- O(n)
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach: 
 * In this problem, we are tasked with reordering a singly linked list in a specific pattern without modifying node values. 
 * We first find the middle of the list using the slow and fast pointer technique, then reverse the second half of the list. 
 * Finally, we merge the two halves alternately to achieve the desired order of nodes.
 */ 
class Solution {
    public void reorderList(ListNode head) {
    
       // Find the middle of the list using slow and fast pointers.
        ListNode slow = head; 
        ListNode fast = head;
        ListNode pre = null;

        // Move fast pointer two steps and slow pointer one step until fast reaches the end.
        while(fast != null && fast.next != null) {
            pre = slow; // Update 'pre' to slow pointer.
            slow = slow.next; //  Move slow pointer one step.
            fast = fast.next.next; // // Move fast pointer two steps.
        }

        //Now slow is at the middle of the list
        // If the list has an even number of nodes, 'slow' will point to the second middle node.
        
        // Split the list into two parts and reverse the second part.
        if(fast == null) { // If the list has an even number of nodes, terminate the first half.
            pre.next = null; // Disconnect the first half of the list from the second half.
        } else { // If the list has an odd number of nodes, move slow to the next node.
            pre = slow; // Move 'pre' to slow (which is the middle node).
            slow = slow.next;// Move slow to the second half of the list.
            pre.next = null;// Disconnect the first half from the second half.
        }

        //Reverse the second half of the list (starting from 'slow').
        ListNode cur2 = reverse(slow);

        //Merge the two halves together in the desired order.
        ListNode cur1 = head;
        while(cur1 != null && cur2 != null) {
            ListNode next1 = cur1.next;
            cur1.next = cur2;
            cur1 = next1;
            ListNode next2 = cur2.next;
            cur2.next = cur1;
            cur2 = next2;
        }

    }

    // helper method for reverse the list
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

   

     