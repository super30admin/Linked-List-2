// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//We will find the mid of linkedlist and then will reverse the next half of the LL
//and then we will merge this two linked list
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
        ListNode slow = head;
        ListNode fast = head;
        
        if(head==null){
            return;
        }
        
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = reverse(slow.next);
        slow.next=null;
        
        slow = head;
        while(slow!=null && fast!=null){
            ListNode fn = slow.next;
            ListNode sn = fast.next;
            
            slow.next = fast;
            fast.next = fn;
            fast = sn;
            slow = fn;
        }
        // return head;
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
}
