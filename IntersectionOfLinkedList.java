//T.C O(m+n)
//S.C O(1)
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
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int countA = 0, countB = 0;
        while(a!=null){
            a = a.next;
            countA++;
        }

        while(b!=null){
            b = b.next;
            countB++;
        }

        while(countA > countB){
            headA = headA.next;
            countA--;
        }
        while(countB>countA){
            headB = headB.next;
            countB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }
}