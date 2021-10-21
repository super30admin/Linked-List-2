// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//here we are going to link 1st element to last then 2nd then 2nd last 3rd and third last and so on. 
//Fo this first we need to find middle of the linkedlist so that we can reveres it from there. 
//once we find the middle we reverse it from p1.next (1st node of 2nd half) and then assign p1.next
// as null which is last node of firs list now. now we reverse the 2nd list. then combine both the lists
//
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
        //midpoint
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse
        ListNode p2 = reverse(slow.next);
        slow.next = null;
        
        
        //combine
        ListNode p1=head;
       
        while(p1!=null && p2!=null){
           ListNode p1N=p1.next;
            ListNode p2N=p2.next;
                p1.next=p2;
            p2.next= p1N;
            p1=p1N;
            p2=p2N;
            
        }
      
        
    }
    
    private ListNode reverse (ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}