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
        ListNode curr = headA;
        int lenA = 0; int lenB = 0;
        while(curr != null){
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while(curr != null){
            lenB++;
            curr = curr.next;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
