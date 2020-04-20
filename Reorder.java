// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Referred a solution


// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
     if(head==null||head.next==null)return;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode secondHead = reverse(slow);
        ListNode firstHead = head;
        
        while(firstHead!=null && secondHead!=null){
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;
            
            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }
        
        if(firstHead!=null)firstHead.next=null;
        
    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}