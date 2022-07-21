// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null && headB==null) return null;
        int lenA=0,lenB=0;
        ListNode curr=headA;
        while(curr!=null){
            curr=curr.next;
            lenA++;
        }
        curr=headB;
        while(curr!=null){
            curr=curr.next;
            lenB++;
        }
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenA<lenB){
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