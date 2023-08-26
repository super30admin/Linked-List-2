// Time Complexity : O(n+m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int listA=0;
        int listB=0;
        ListNode curr=headA;
        while(curr!=null){
            listA++;
            curr=curr.next;
        }
        curr=headB;
        while(curr!=null){
            listB++;
            curr=curr.next;
        }
        while(listA>listB){
            headA=headA.next;
            listA--;
        }
        while(listB>listA){
            headB=headB.next;
            listB--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}