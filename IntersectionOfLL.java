//Time Complexity: O(n)
//Space Complexity: O(1)

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
        if(headA==null || headB==null)
            return null;

        int lenA = 0;
        int lenB = 0;
        ListNode itrA = headA, itrB = headB;

        while(itrA.next!=null){
            lenA++;
            itrA = itrA.next;
        }

        while(itrB.next!=null){
            lenB++;
            itrB = itrB.next;
        }

        if(itrA!=itrB)
            return null;

        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

    }
}