// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* 
1. Find the middle element. 
2. Seperate the Linked List into two parts.
3. Reverse the second linked list.
4. Now merge them again.
*/

// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            //Find the middle
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the List
        fast = reverseList(slow.next);
        
        //Merge the List
        slow.next = null;
        slow = head;
        while(fast!=null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast!=null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}
