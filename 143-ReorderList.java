/**LC-143
 * 
 * Time Complexity : 
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes
 * 
 * Yes forgot to add null after the slow pointer after finding the mid. This separates the list into two halves which is necesary.
 *
 Algorithm: 
 1. First we find the middle by fast and slow pointer method
 2. Reverse the second half of the linkedlist
 3. Now we have two list: we take one element from 1st list, link it to 1st element of the second list and then link it to second element of first list and so on...
 */
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
        
        if(head == null || head.next == null) return;  //null or list with length 1
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while(fast.next != null && fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // in the list 1-> 2 -> 3 -> 4, slow = mid = 2
        ListNode reversed = reverseList(slow.next);
        slow.next = null;
        System.out.println("Slow: " + slow.val);
        slow= head;
        fast = reversed;
       // System.out.println("ptr2: " + ptr2.val);
        ListNode temp = null;
        while(fast != null ){
            
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
        return;
    }
    
    private ListNode reverseList(ListNode head){
        
        if( head.next == null ) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;
        
        while(fast.next != null){
            
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        fast.next = curr;
       // System.out.println("prev: " + prev.val);
        return fast;
    }
}