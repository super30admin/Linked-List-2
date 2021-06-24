// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I got a little confused in the merging logic 

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head.next;
      
        //find mid
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse second half of the list
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        // merge the two lists
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    private ListNode reverse(ListNode root){
        if(root == null || root.next == null)
            return root;
        ListNode p = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return p;
    }
}
