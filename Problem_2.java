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
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
//1. find mid
//2. find reverse of second half
//3. merge first half and reversed second half
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return ;
        ListNode slow=head,fast=head;
        while(fast.next!=null &&fast.next.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.print(slow.val);
        ListNode second= reverse(slow.next);
        slow.next=null;
        ListNode p1=head,p2=second;
        while(p2!=null){
            ListNode temp1=p1.next;
            p1.next=p2;
            p2=p2.next;
            p1.next.next=temp1;
            p1=temp1;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null,curr=head,fast=head.next;
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