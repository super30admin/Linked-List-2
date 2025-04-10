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
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;

            if(currA == null && currB == null)
                return null;

            if(currA == null)
                currA = headB;

            if(currB == null)
                currB = headA;
        }
    return currA;
    }
}