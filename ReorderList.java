// Time Complexity : O(n) // for dfs
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next==null) return;
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null) // find middle
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode curr = slow.next;
        ListNode prev = null;
        ListNode next = null;
        
        slow.next = null;
        
        while(curr!=null)  // reverse the list
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode head1= head;
        ListNode head2 = prev;
        // System.out.println(curr.val);
        while(head1!=null && head2!=null) // merge two lists
        {
            ListNode temp = head2;
            head2 = head2.next;
            temp.next = head1.next;
            head1.next=temp;
            head1 = temp.next;
            
        }
       
    }
}