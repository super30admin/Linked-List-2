// Time Complexity :O(n+n/2)traversal of whole list + reversing the list
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
        if(head==null || head.next==null)
            return;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        
        
        slow= head;
        ListNode S=null;
        ListNode F=null;
        while(fast!=null && slow.next!=null)
        {
            S=slow.next;
            F=fast.next;
            
            slow.next=fast;
            fast.next=S;
            slow=S;
            fast=F;
        }
        
       
    }
    private ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            
            prev=curr;
            curr=next;
        }
        return prev;
    }
}