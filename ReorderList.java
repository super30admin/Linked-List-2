// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// mentioned inline with code

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
        if(head == null || head.next == null) return ;
        
        // initializing slow and fast pointers to find middle element
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // fast is middle+1 reference now
        fast = slow.next;
        // List1: reversing middle+1 till end 
        fast = reverse(fast);
        // List2: head till middle
        slow.next = null;
        slow = head;
        
        //Merging List1 and List2
        ListNode temp;
        while(fast != null) {
            temp = slow.next;
            slow.next = fast;
            slow = fast;
            fast = fast.next;
            slow.next = temp;
            slow = temp;
        }
            
    }
    
    // reversing the linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, temp = head;
        while(temp != null) {
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
        
    }
}

