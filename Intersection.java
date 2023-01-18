// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//in this approach we find the len of both the linked lists. then we make the larger one basically equal to the smaller one
//by moving the head to point to equidistant node. We move both the heads then until they meet which is our intersecting point.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        ListNode curr = headA;
        while(curr!=null){
            curr= curr.next;
            lenA++;
        }
        int lenB=0;
        curr = headB;
        while(curr!=null){
            curr= curr.next;
            lenB++;
        }
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
