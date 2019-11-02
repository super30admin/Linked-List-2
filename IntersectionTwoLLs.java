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
/* 160. Intersection of Two Linked Lists
Time Complexity: O(m+n)
Space Complexity: O(1)
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode cur = headA;

        while(cur != null){
            lenA++;
            cur = cur.next;
        }
        cur = headB;
        while(cur != null){
            lenB++;
            cur = cur.next;
        }

        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}