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
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
 class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null|| headB==null){
            return null;
        }
        int lenA=0;
        ListNode curr = headA;
        while(curr!=null){
            lenA++;
            curr=curr.next;
        }
        int lenB=0;
        curr = headB;
        while(curr!=null){
            lenB++;
            curr=curr.next;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while(lenA>lenB){
            currA=currA.next;
            lenA--;
        }
        while(lenB>lenA){
            currB=currB.next;
            lenB--;
        }
        while(currB!=currA){
            currA=currA.next;
            currB=currB.next;
        }
        return currB;
    }
}