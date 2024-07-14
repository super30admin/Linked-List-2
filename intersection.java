// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
        
        int lenA = 0; int lenB = 0;
        ListNode currA = headA;
        while(currA!=null)
        {
            currA = currA.next;
            lenA++;
        }

        ListNode currB = headB;
        while(currB!=null){
            currB = currB.next;
            lenB++;
        }

        while(lenA>lenB){
            lenA--;
            headA = headA.next;
        }

        while(lenB>lenA){
            lenB--;
            headB = headB.next;
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
    }
}