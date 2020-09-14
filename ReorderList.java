
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//  	Not able to do intuition on this solution

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
        
         
        if( head == null ) return;
        
        Stack<ListNode> stack = new Stack<>();
        
        ListNode slow = head;
        ListNode fast = head;
        
        while( fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode ptr = slow.next;
        slow.next = null;// this will the end node after inserions
        // from mid add every element to stack
        while( ptr!=null ){
            stack.push(ptr);
            ptr = ptr.next;
        }
        
        ptr = head;
        //pop each element and insert them in between
        while( !stack.empty() && ptr!=null ){
            ListNode top = stack.pop();
            ListNode temp = ptr.next;
            ptr.next = top;
            top.next = temp;
            ptr = temp;
        }
        
        
    }
}