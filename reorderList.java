// Time Complexity : O(N), we iterate over the list to find the mid, then N/2 for reverse. Then again N/2 for merge.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//The idea is to find the mid with help of two pointers. Then once we get the mid, we terminate the first part by declaring mid.next to null.
//Then we reverse the next half of the mid.
//Then we iterate over both the list to merge them into one by alternating thhe iterations between the two lists.

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
        
        //base check
        if(head == null) return;
        
        
        ListNode mid = findMid(head);
        ListNode reverse = reverse(mid.next);
        mid.next = null;
              
        ListNode cursorA = head;
        ListNode cursorB = reverse;
        
        while(cursorB != null){
            ListNode nodeA = cursorA.next;
            ListNode nodeB = cursorB.next;
            
            cursorA.next = cursorB;
            cursorB.next = nodeA;
            
            cursorA = nodeA;
            cursorB = nodeB;
            
        }
        
        return;
    }
    
    private ListNode findMid(ListNode head){
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
    private ListNode reverse(ListNode head){
        
        if(head == null) return null;
        
        ListNode curr = head, prev = null;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}