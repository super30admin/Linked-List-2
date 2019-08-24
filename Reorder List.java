/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

// Beats 100% of LeetCode Submissions
// T: O(n)
// S: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;
        // Three Steps:
        // 1. Find the Mid Element
        // 2. Reverse the second list
        // 3. Merge the two lists
        
        ListNode slow = head, fast = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            
            prev = slow; // End of first list
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Slow now points to the middle of the list, which we can put it as part of second list.
        prev.next = null; // end of 1st list
        
        ListNode list2 = reverse(slow); // reverse the second list
        
        mergeLists(head, list2);    
        
    }
    
    public ListNode reverse(ListNode root){
        
        ListNode prev = null;
        
        while(root != null){
            
            ListNode next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        
        return prev;
    }
    
    public void mergeLists(ListNode l1, ListNode l2){
        
        while(l1 != null){
            
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            
            if(n1 == null) break;
            
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}