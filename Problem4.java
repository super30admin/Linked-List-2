
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null && headB==null){
            return null;
        }
        
        
        int len1=0;
        int len2=0;
        ListNode head1=null;
        ListNode head2=null;
        ListNode curr1=headA;
        ListNode curr2=headB;
        
        while(curr1!=null){
            len1++;
            curr1=curr1.next;
        }
        System.out.println(len1);
        
        while (curr2!=null){
            len2++;
            curr2=curr2.next;
        }
        System.out.println(len2);
        if(len1>len2){
            head1=headA;
            head2=headB;
        }else{
            head1=headB;
            head2=headA;
        }
        
        
        int diff=Math.abs(len1-len2);
        
        while(diff>0){
            head1=head1.next;
            diff--;
        }
        
        while(head1!=null && head2!=null){
            if(head1==head2){
                return head1;
            }
            head1=head1.next;
            head2=head2.next;
        }
        
        return null;
        
    }
}