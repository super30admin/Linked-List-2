// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        
        ListNode temp=fast.next;
        while(temp!=null){
            fast.next=prev;
            prev=fast;
            fast=temp;
            temp=temp.next;
        }
        fast.next=prev;
        slow=head;
        temp=null;
        
        while(fast!=null){
            temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
            }
    }
}