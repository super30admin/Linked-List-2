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
//TC : O(m + n)
//SC : O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) return null;
        
        int lenA = 0, lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        while(tempB != null) {
            lenB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;
        while(lenA > lenB) {
            tempA = tempA.next;
            lenA--;
        }
        while(lenB > lenA) {
            tempB = tempB.next;
            lenB--;
        }
        while(tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}
