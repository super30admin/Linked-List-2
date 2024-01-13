// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: divide the list from mid and reverse the second half of the list and then merge it.

class Solution {
    public void reorderList(ListNode head) {
        if(head==null ||head.next==null ){
            return;
        }
        
        ListNode slow = middle(head);
        ListNode fast = reverse(slow.next);
        slow.next=null;
        slow= head;

        while(fast!=null){
            ListNode temps= slow.next;
            ListNode tempf=fast.next;

            slow.next= fast;
            fast.next=temps;
            
            slow= temps;
            fast= tempf;
          
        }   
    }
    public ListNode middle(ListNode head){
        ListNode slow= head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }

    public ListNode reverse(ListNode head){
        ListNode prev=null;
    
        ListNode temp= head;
        while(temp!=null){
            ListNode front= temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }   
        return prev;    
    }
}