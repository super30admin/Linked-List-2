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
public class IntersectionOfTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null){
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lenA=0, lenB=0;

        while(pointerA!=null){
            pointerA = pointerA.next;
            lenA++;
        }

        while(pointerB!=null){
            pointerB = pointerB.next;
            lenB++;
        }

        pointerA = headA;
        pointerB = headB;

        while(lenA > lenB){
            lenA--;
            pointerA=pointerA.next;
        }

        while(lenB > lenA){
            lenB--;
            pointerB=pointerB.next;
        }

        while(pointerA!=pointerB){
            pointerA=pointerA.next;
            pointerB=pointerB.next;
        }

        return pointerA;

    }
}
