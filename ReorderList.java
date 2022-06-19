//Time O(n)
// Space O(1)

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
       if(head.next== null || head ==null)
            return;
        // find the half point of the LL
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast =fast.next.next;
        }

        
        
        
         fast= reverse(slow.next);
         slow.next= null;
          slow = head;
 
        
        while(fast!=null)
        {
            ListNode temp = slow.next;
            slow.next= fast;
            fast= fast.next;
            slow.next.next =temp;
            slow = temp;
        }
    
        
        
        
    }
    
    private ListNode reverse(ListNode head)
    {   if(  head == null|| head.next==null)
           return head;
        ListNode prev= null;
        ListNode curr= head;
        ListNode next= head.next;
        while(next!=null)
        {
            curr.next= prev;
            prev= curr;
            curr= next;
            next=next.next;
        }
     curr.next= prev;
        
     return curr;
        
    }
}