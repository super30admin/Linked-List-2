/**
 * Definition for singly-linked list.
 */ 
 
/*Approach
1) in this secnario, we need to align the lists via alternate nodes in the same list
2) the approach for this would be to find the
            1) find the mid point of first list
            2) break into two lists (head to mid ) and (mid.next to last)
            3) reverse the second list in place 
            4) now join the two lists
3) mid point can be found using slow and fast pointers
4) rest follows in the code
*/  

class Solution {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        
        if(head==null)
            return;
        
        ListNode slow =head;
        ListNode fast =head;
        
        // find the mid point
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        // break into two lists
        ListNode head2= slow.next;
        slow.next=null;
        

        // reverse the second list
        ListNode p2=reverseList(head2);
        
        
        // reset the pointers, instead of declaring new pointers
        slow = head;
        fast=p2;
        

        // align, join them as needed
        while(slow!=null && fast!=null)
        {
            ListNode temp= slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
        
        
    }
    

    // reverse the linked list
    public ListNode reverseList(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        
        ListNode prev =null;
        
        while(head!=null)
        {
            ListNode nextPtr = head.next;
            //prev=head;
            head.next=prev;
            prev=head;
            head=nextPtr;
            
        }
        
        return prev;
        
        
    }
}