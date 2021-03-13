// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        ListNode temp;
        while(fast!=null && slow!=null){
            temp = slow.next;
            slow.next = fast;
            slow = temp;
            
            temp = fast.next;
            fast.next = slow;
            fast = temp;
            
        }
        
    }
    public ListNode reverseList(ListNode head) {
    
    ListNode temp = head;
    ListNode prev = null;
    ListNode curr = null;
    while(temp != null){
        prev = curr;
        curr = temp;
        temp = temp.next;
        curr.next = prev;
    }
    return curr; 
    }
}