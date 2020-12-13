// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
            return;
        
        ListNode mid = midpoint(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode rev = reverse(temp);        
        head = weave(head, rev);        
    }
    
    public ListNode midpoint(ListNode node) {
        
        ListNode slow = node;
        ListNode fast = node;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode node) {
        
        ListNode prev = null;
        
        ListNode curr = node;
        
        while(curr != null) {
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public ListNode weave(ListNode l1, ListNode l2) {
        
        ListNode head = l1;
        
        while(l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            
            l1.next = l2;
            l2.next = temp1;
            
            l1 = temp1;
            l2 = temp2;
        }
        return head;
    }
}