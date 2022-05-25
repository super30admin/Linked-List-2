//https://leetcode.com/problems/intersection-of-two-linked-lists/
// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr=headA;
        int lenA=0; //find length of a
        while(curr!=null)
        {
            lenA++;
            curr=curr.next;
        }
        curr=headB;
        int lenB=0; //find length of B
        while(curr!=null)
        {
            lenB++;
            curr=curr.next;
        }
        while(lenA>lenB) //when lenA is greater than lenB move headA to the difference
        {
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA) //when lenB is greater than lenA move headB to the difference
        {
            headB=headB.next;
            lenB--;
        }
        while(headA!=headB)  //check for the intersection
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}