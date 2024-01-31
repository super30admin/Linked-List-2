
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        if(head==null){
            return;
        }
    
        ListNode mid = findMid(head);
        ListNode temp=mid.next;
        mid.next=null;
        ListNode head2=reverse(temp);
        ListNode curr1= head;
        ListNode curr2= head2;
        ListNode dummy = new ListNode(0);
        while(curr1!=null || curr2!=null){
            if(curr1!=null){
                dummy.next=curr1;
                dummy=dummy.next;
                curr1=curr1.next;
            }
            
            if(curr2!=null){
                dummy.next=curr2;
                dummy=dummy.next;
                curr2=curr2.next;
            }
        }
        
    }
    
    private ListNode findMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}