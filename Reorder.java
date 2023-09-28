// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//first we find middle 
//then we part LL into 2 part 
//reverse second part
//and merge the LL in such a way that we use 3 pointer that 
//temp=slow.next slow.next=fast and fast=fast.next 
//slow.next.next=temp; slow=temp



class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return ;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse
        fast=reverselist(slow.next);
        slow.next=null;
        slow=head;
        //merge
     
        while(fast!=null){
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;      
        }
 
    }
    private ListNode reverselist(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}