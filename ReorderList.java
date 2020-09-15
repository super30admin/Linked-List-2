// Time Complexity : O(N) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        
        if(head==null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode h2 = reverse(slow.next);
        slow.next=null;
        
        ListNode h1 = head;
    
        ListNode temp1;
        ListNode temp2;
        
        while(h2!=null){
            temp1=h1.next;
            h1.next=h2;
            temp2=h2.next;
            h2.next=temp1;
            h1=temp1;
            h2=temp2;
        }
    }
    
    public ListNode reverse(ListNode node){
        
        ListNode previous=null;
        ListNode current=node;
        ListNode next=null;
        
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous; 
    }
}