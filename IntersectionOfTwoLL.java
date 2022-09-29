// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;

        while(curA!=null && curB!=null){
            curA=curA.next;
            curB=curB.next;
        }
        while(curB!=null){
            curB=curB.next;
            headB=headB.next;
        }

        while(curA!=null){
            curA=curA.next;
            headA=headA.next;
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headB;
    }
}