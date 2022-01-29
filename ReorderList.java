// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Syntactical errors and confusion with reversing LL


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        //find middle element using 2 pointers
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow will be at mid
        //reverse 2nd half of LL
        fast = reverse(slow.next); //head of 2nd LL
        slow.next = null; //remove the connection bcz after reversal mid elemtn will be connected to mid+1
        slow = head;
        
        //merge the last two lists
        ListNode temp = null;
        
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
            
        }
        

    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode fast = head.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        return curr;
    }
}